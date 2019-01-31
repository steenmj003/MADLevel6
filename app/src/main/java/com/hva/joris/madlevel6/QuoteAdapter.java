package com.hva.joris.madlevel6;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.ViewHolder> {
    public TextView quoteText;
    private List<QuoteItem> quoteList;

    public QuoteAdapter(List<QuoteItem> mQuoteList) {
        this.quoteList = mQuoteList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(android.R.layout.simple_list_item_1, null);
        QuoteAdapter.ViewHolder viewHolder = new QuoteAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        QuoteItem quote = quoteList.get(position);
        holder.quoteText.setText(quote.getText());
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView quoteText;

        public ViewHolder(View itemView) {
            super(itemView);
            quoteText = itemView.findViewById(android.R.id.text1);
        }
    }

    public void swapList(List<QuoteItem> newList) {

        quoteList = newList;
        if (newList != null) {
            this.notifyDataSetChanged();
        }
    }

}
