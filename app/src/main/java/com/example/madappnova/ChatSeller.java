package com.example.madappnova;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChatSeller extends AppCompatActivity implements ChatAdapter.OnChatClickListener {
    private RecyclerView recyclerViewChat;
    private ChatAdapter adapter;
    private ChatRepository chatRepository;
    private SessionManager session;

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

        setContentView(R.layout.chat_seller);

        // Initialize repository
        chatRepository = new ChatRepository(this.getApplication());

        // Setup window insets
        View topBar = findViewById(R.id.topBar);
        ViewCompat.setOnApplyWindowInsetsListener(topBar, (v, insets) -> {
            androidx.core.graphics.Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(v.getPaddingLeft(), systemBars.top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        // Setup RecyclerView
        recyclerViewChat = findViewById(R.id.recyclerViewChat);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ChatAdapter(this);
        recyclerViewChat.setAdapter(adapter);

        // Get current user ID
        int userId = session.getUserId();

        // Observe LiveData for real-time updates
        if (userId != -1) {
            chatRepository.getChatMessagesByUserLive(userId).observe(this, chats -> {
                if (chats != null) {
                    adapter.updateChats(chats);
                }
            });
        }

        // Setup navigation
        setupNavigation();
    }

    @Override
    public void onChatClick(Chat chat) {
        // Open conversation with the sender
        Intent intent = new Intent(this, ChatConversation.class);
        intent.putExtra("other_user_id", chat.getSenderId());
        intent.putExtra("other_user_name", chat.getSenderName());
        startActivity(intent);
    }

    private void setupNavigation() {
        // Bottom nav
        findViewById(R.id.tvShop).setOnClickListener(v -> {
            startActivity(new Intent(ChatSeller.this, ShopSeller.class));
        });

        findViewById(R.id.tvUpload).setOnClickListener(v -> {
            startActivity(new Intent(ChatSeller.this, UploadRegularSeller.class));
        });

        findViewById(R.id.tvHome).setOnClickListener(v -> {
            startActivity(new Intent(ChatSeller.this, HomeSellerActivity.class));
        });

        findViewById(R.id.tvChat).setOnClickListener(v -> {
            // Already on chat page
        });

        findViewById(R.id.tvOrder).setOnClickListener(v -> {
            startActivity(new Intent(ChatSeller.this, CurrentOrderSeller.class));
        });

        // Account button
        ImageView account = findViewById(R.id.imgPlaceholder);
        account.setOnClickListener(v -> {
            startActivity(new Intent(ChatSeller.this, AccountActivity.class));
        });
    }
}
