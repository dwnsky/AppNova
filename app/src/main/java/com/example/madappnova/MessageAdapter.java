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

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_SENT = 1;
    private static final int VIEW_TYPE_RECEIVED = 2;

    private List<Chat> messages;
    private int currentUserId;

    public MessageAdapter(int currentUserId) {
        this.messages = new ArrayList<>();
        this.currentUserId = currentUserId;
    }

    @Override
    public int getItemViewType(int position) {
        Chat message = messages.get(position);
        if (message.getSenderId() == currentUserId) {
            return VIEW_TYPE_SENT;
        } else {
            return VIEW_TYPE_RECEIVED;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SENT) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_sent, parent, false);
            return new SentMessageViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.message_received, parent, false);
            return new ReceivedMessageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat message = messages.get(position);
        if (holder instanceof SentMessageViewHolder) {
            ((SentMessageViewHolder) holder).bind(message);
        } else {
            ((ReceivedMessageViewHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void updateMessages(List<Chat> newMessages) {
        this.messages = newMessages;
        notifyDataSetChanged();
    }

    static class SentMessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage, tvTimestamp;

        public SentMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessageText);
            tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
        }

        public void bind(Chat message) {
            tvMessage.setText(message.getLastMessage());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
            tvTimestamp.setText(sdf.format(new Date(message.getTimestamp())));
        }
    }

    static class ReceivedMessageViewHolder extends RecyclerView.ViewHolder {
        TextView tvMessage, tvTimestamp, tvSenderName;

        public ReceivedMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessageText);
            tvTimestamp = itemView.findViewById(R.id.tvTimestamp);
            tvSenderName = itemView.findViewById(R.id.tvSenderName);
        }

        public void bind(Chat message) {
            tvMessage.setText(message.getLastMessage());
            tvSenderName.setText(message.getSenderName());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
            tvTimestamp.setText(sdf.format(new Date(message.getTimestamp())));
        }
    }
}