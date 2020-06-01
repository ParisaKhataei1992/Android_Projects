package ca.georgebrown.assignment2;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import ca.georgebrown.assignment2.ItemFragment.OnListFragmentInteractionListener;
import ca.georgebrown.assignment2.DummyContent.*;
import java.util.List;

public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> itemValues;
    private final OnListFragmentInteractionListener interactionListener;

    public MyItemRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        itemValues = items;
        interactionListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context con = parent.getContext();
        View view = LayoutInflater.from(con).inflate(R.layout.fragment_item, parent, false);
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
    public int getItemCount() {
        return itemValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View view;
        public final TextView textView;
        public DummyItem item;
        public ImageView img_info;

        public ViewHolder(View v) {
            super(v);
            view = v;
            textView = v.findViewById(R.id.txtAdd);
            //img_info = v.findViewById(R.id.img_info);
        }

        @Override
        public String toString() {
            return String.valueOf(textView.getText());
        }
    }
}
