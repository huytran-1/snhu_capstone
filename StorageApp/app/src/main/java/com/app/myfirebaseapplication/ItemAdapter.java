package com.app.myfirebaseapplication;

import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class ItemAdapter extends FirebaseRecyclerAdapter<ItemModel, ItemAdapter.itemViewholder> {
    public ItemAdapter(@NonNull FirebaseRecyclerOptions<ItemModel> options){
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull itemViewholder holder, int position, @NonNull ItemModel model){
        holder.name.setText(model.getName());
        holder.stock.setText(Integer.toString(model.getStock()));
        holder.image.setImageResource(model.getImage());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mPostReference = FirebaseDatabase.getInstance().getReference("recyclerview");
                mPostReference.child(model.getID()).setValue(null);
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.stock.setEnabled(true);
                holder.check.setVisibility(View.VISIBLE);
            }
        });

        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newStock = Integer.parseInt(holder.stock.getText().toString());
                DatabaseReference mPostReference = FirebaseDatabase.getInstance().getReference("recyclerview").child(model.getID());
                mPostReference.child("stock").setValue(newStock);
                holder.stock.setEnabled(false);
                holder.check.setVisibility(View.INVISIBLE);
            }
        });
    }

    @NonNull
    @Override
    public itemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ItemAdapter.itemViewholder(view);
    }

    class itemViewholder extends RecyclerView.ViewHolder{
        TextView name;
        EditText stock;
        ImageView image, delete, edit, check;

        public itemViewholder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.name);
            stock = itemView.findViewById(R.id.stock);
            image = itemView.findViewById(R.id.image);
            delete = itemView.findViewById(R.id.delete);
            edit = itemView.findViewById(R.id.edit);
            check = itemView.findViewById((R.id.check));
            stock.setEnabled(false);
        }
    }

}
