//package com.example.collegeconnect;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.List;
//
//public class DataAdapterSearch extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
//    SearchData[] searchData;
//    Context context;
//
//    public DataAdapterSearch(SearchData[] searchData, Context searchFragment) {
//        this.searchData = searchData;
//        this.context = searchFragment;
//    }
//
//    public DataAdapterSearch() {
//
//    }
//
//    public void setFilteredList(List<HomeData> filteredList) {
//        this.searchData = filteredList.toArray(new SearchData[0]);
//        notifyDataSetChanged();
//    }
//
//
//    @NonNull
//    public DataAdapterSearch.ViewHolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
//        View view = layoutInflater.inflate(R.layout.recycler_view,parent,false);
//        DataAdapterSearch.ViewHolderSearch viewHolderSearch = new ViewHolderSearch(view);
//        return viewHolderSearch;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull DataAdapter.ViewHolder holder, int position) {
//        final SearchData datalistSearch = searchData[position];
//        holder.textView.setText(datalistSearch.getHeading());
//        holder.textViewDesc.setText(datalistSearch.getDescription());
//        holder.imageView2.setImageResource(datalistSearch.getImage());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v)
//            {
//                Toast.makeText(context,datalistSearch.getHeading(),Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return searchData.length;
//    }
//
//    public class ViewHolderSearch extends RecyclerView.ViewHolder
//    {
//        ImageView imageView2;
//        TextView textView;
//        TextView textViewDesc;
//
//        public ViewHolderSearch(@NonNull View itemView) {
//            super(itemView);
//            imageView2 = itemView.findViewById(R.id.imageview);
//            textView = itemView.findViewById(R.id.heading);
//            textViewDesc = itemView.findViewById(R.id.desc);
//        }
//    }
//}
