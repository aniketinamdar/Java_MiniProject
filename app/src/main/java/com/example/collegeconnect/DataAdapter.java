package com.example.collegeconnect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    HomeData[] homeData;
    Context context;

    public DataAdapter(HomeData[] homeData, Context homeFragment) {
        this.homeData = homeData;
        this.context = homeFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final HomeData datalist = homeData[position];
        holder.textView.setText(datalist.getHeading());
        holder.textViewDesc.setText(datalist.getDescription());
        holder.imageView2.setImageResource(datalist.getImage());

        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Toast.makeText(context,datalist.getHeading(),Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return homeData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView2;
        TextView textView;
        TextView textViewDesc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView2 = itemView.findViewById(R.id.imageview);
            textView = itemView.findViewById(R.id.heading);
            textViewDesc = itemView.findViewById(R.id.desc);
        }
    }
}

