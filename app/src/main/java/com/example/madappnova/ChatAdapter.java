package com.example.madappnova;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {

    private List<Chat> chatList;
    private OnChatClickListener listener;

    public interface OnChatClickListener {
        void onChatClick(Chat chat);
    }

    public ChatAdapter(OnChatClickListener listener) {
        this.chatList = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_card, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat chat = chatList.get(position);
        holder.bind(chat, listener);
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    public void updateChats(List<Chat> newChats) {
        this.chatList = newChats;
        notifyDataSetChanged();
    }

    static class ChatViewHolder extends RecyclerView.ViewHolder {
        TextView tvSenderName, tvLastMessage, tvBadge;

        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSenderName = itemView.findViewById(R.id.tvSenderName);
            tvLastMessage = itemView.findViewById(R.id.tvLastMessage);
            tvBadge = itemView.findViewById(R.id.badge1);
        }

        public void bind(Chat chat, OnChatClickListener listener) {
            tvSenderName.setText(chat.getSenderName());
            tvLastMessage.setText(chat.getLastMessage());

            // Show unread badge if count > 0
            if (chat.getUnreadCount() > 0) {
                tvBadge.setVisibility(View.VISIBLE);
                tvBadge.setText(String.valueOf(chat.getUnreadCount()));
                // Make text bold for unread messages
                tvSenderName.setTypeface(null, android.graphics.Typeface.BOLD);
                tvLastMessage.setTypeface(null, android.graphics.Typeface.BOLD);
            } else {
                tvBadge.setVisibility(View.GONE);
                tvSenderName.setTypeface(null, android.graphics.Typeface.NORMAL);
                tvLastMessage.setTypeface(null, android.graphics.Typeface.NORMAL);
            }

            // Click listener
            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onChatClick(chat);
                }
            });
        }
    }
}