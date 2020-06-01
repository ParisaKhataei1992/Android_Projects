package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyContent.DummyItem> itemValues;
    private final ItemFragment.OnListFragmentInteractionListener interactionListener;

    public MyItemRecyclerViewAdapter(List<DummyContent.DummyItem> items, ItemFragment.OnListFragmentInteractionListener listener) {
        itemValues = items;
        interactionListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context con = parent.getContext();
        View view = LayoutInflater.from(con).inflate(R.layout.item_fragment, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.item = itemValues.get(position);
        holder.textView.setText(itemValues.get(position).name);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != interactionListener)
                    interactionListener.onListFragmentInteraction(holder.item);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return itemValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView textView;
        public DummyContent.DummyItem item;
        public ViewHolder(View v) {
            super(v);
            view = v;
            textView = v.findViewById(R.id.ItemName);

        }

        @Override
        public String toString()
        {
            return String.valueOf(textView.getText());
        }
    }
}
