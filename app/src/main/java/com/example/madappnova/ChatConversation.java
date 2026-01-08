package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChatConversation extends AppCompatActivity {
    private RecyclerView recyclerViewMessages;
    private MessageAdapter adapter;
    private EditText etMessage;
    private ImageButton btnSend;
    private TextView tvChatName;
    private ImageView btnBack;

    private ChatRepository chatRepository;
    private SessionManager session;

    private int currentUserId;
    private int otherUserId;
    private String otherUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        super.onCreate(savedInstanceState);

        // Check if user is logged in
        session = new SessionManager(this);
        if (!session.isLoggedIn()) {
            startActivity(new Intent(this, LoginPageSellerActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.chat_conversation);

        // Initialize repository
        chatRepository = new ChatRepository(this.getApplication());
        currentUserId = session.getUserId();

        // Get intent data
        Intent intent = getIntent();
        otherUserId = intent.getIntExtra("other_user_id", -1);
        otherUserName = intent.getStringExtra("other_user_name");

        // Setup window insets
        View topBar = findViewById(R.id.topBar);
        ViewCompat.setOnApplyWindowInsetsListener(topBar, (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        // Initialize views
        tvChatName = findViewById(R.id.tvChatName);
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);
        btnBack = findViewById(R.id.btnBack);

        // Set chat name
        if (otherUserName != null) {
            tvChatName.setText(otherUserName);
        }

        // Back button
        btnBack.setOnClickListener(v -> finish());

        // Setup RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewMessages.setLayoutManager(layoutManager);
        adapter = new MessageAdapter(currentUserId);
        recyclerViewMessages.setAdapter(adapter);

        // Load messages if we have a valid other user
        if (otherUserId != -1) {
            loadMessages();
            markMessagesAsRead();
        }

        // Send button
        btnSend.setOnClickListener(v -> sendMessage());
    }

    private void loadMessages() {
        chatRepository.getConversationLive(currentUserId, otherUserId).observe(this, messages -> {
            if (messages != null) {
                adapter.updateMessages(messages);
                // Scroll to bottom when new messages arrive
                if (messages.size() > 0) {
                    recyclerViewMessages.smoothScrollToPosition(messages.size() - 1);
                }
            }
        });
    }

    private void sendMessage() {
        String messageText = etMessage.getText().toString().trim();

        if (messageText.isEmpty()) {
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show();
            return;
        }

        if (otherUserId == -1) {
            Toast.makeText(this, "Cannot send message: Invalid recipient", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create new chat message
        Chat chat = new Chat();
        chat.setSenderId(currentUserId);
        chat.setReceiverId(otherUserId);
        chat.setSenderName(session.getUserName());
        chat.setLastMessage(messageText);
        chat.setUnreadCount(1);
        chat.setRead(false);

        // Send message in background
        new Thread(() -> {
            long result = chatRepository.insertChat(chat);

            runOnUiThread(() -> {
                if (result > 0) {
                    etMessage.setText("");
                } else {
                    Toast.makeText(this, "Failed to send message", Toast.LENGTH_SHORT).show();
                }
            });
        }).start();
    }

    private void markMessagesAsRead() {
        new Thread(() -> {
            chatRepository.markMessagesAsRead(otherUserId, currentUserId);
        }).start();
    }
}
