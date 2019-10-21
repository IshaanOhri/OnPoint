package com.ishaan.onpoint;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> senderNameArrayList = new ArrayList<String>();
    private ArrayList<String> summaryArrayList = new ArrayList<String>();
    private Context context;
    private ArrayList<Integer> background = new ArrayList<Integer>();


    public RecyclerViewAdapter(ArrayList<String> senderNameArrayList, ArrayList<String> summaryArrayList, Context context) {
        this.senderNameArrayList = senderNameArrayList;
        this.summaryArrayList = summaryArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.individual_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        holder.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        holder.senderNameTextView.setText(senderNameArrayList.get(position));
        holder.summaryTextView.setText(summaryArrayList.get(position));
        holder.constraintLayout.setBackgroundResource(background.get(position%4));
    }

    @Override
    public int getItemCount() {
        return senderNameArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView summaryTextView, senderNameTextView;
        CardView cardView;
        ImageView bookmark;
        public ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            background.add(R.drawable.green_box);
            background.add(R.drawable.purple_box);
            background.add(R.drawable.red_box);
            background.add(R.drawable.blue_box);


            cardView = itemView.findViewById(R.id.cardView);
            bookmark = itemView.findViewById(R.id.bookmark);
            summaryTextView = itemView.findViewById(R.id.summaryTextView);
            senderNameTextView = itemView.findViewById(R.id.senderNameTextView);
            constraintLayout = itemView.findViewById(R.id.linearLayout);

        }
    }

}
