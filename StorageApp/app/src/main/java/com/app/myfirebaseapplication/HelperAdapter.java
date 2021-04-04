package com.app.myfirebaseapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HelperAdapter extends RecyclerView.Adapter {
    List<FetchData> fetchDataList;

    public HelperAdapter(List<FetchData> fetchDataList){
        this.fetchDataList = fetchDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolderClass viewHolderClass = new ViewHolderClass(view);
        return null;
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder, int position){
        ViewHolderClass viewHolderClass = (ViewHolderClass)holder;
        FetchData fetchData = fetchDataList.get(position);
        viewHolderClass.name.setText(fetchData.getName());
        //viewHolderClass.stock.setText((int) fetchData.getStock());
        //viewHolderClass.image.setText((int) fetchData.getImage());
    }

    @Override
    public int getItemCount(){
        return fetchDataList.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView name;
        EditText stock;
        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            //stock = itemView.findViewById(R.id.stock);
            //image = itemView.findViewById(R.id.image);
        }
    }
}
