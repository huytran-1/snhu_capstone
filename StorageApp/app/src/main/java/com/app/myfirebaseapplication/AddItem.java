package com.app.myfirebaseapplication;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddItem extends AppCompatActivity {

        EditText etItemName, etItemStock;
        Button buttonDML;
        DatabaseReference databaseReference;

        ItemModel item;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_item);
            getAllWidgets();
            databaseReference = FirebaseDatabase.getInstance().getReference("recyclerview");

            bindWidgetWithEvent();
            }

        private void getAllWidgets() {
            etItemName = (EditText) findViewById(R.id.etItemName);
            etItemStock = (EditText) findViewById(R.id.etItemStock);
            buttonDML = (Button) findViewById(R.id.buttonDML);
        }

        void bindWidgetWithEvent(){
            buttonDML.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String ID = databaseReference.push().getKey();
                    String name = etItemName.getText().toString();
                    int stock = Integer.parseInt(etItemStock.getText().toString());
                    addDataToFireBase(ID, name, stock);
                    etItemName.setText("");
                    etItemStock.setText("");
                    Intent intent = new Intent(AddItem.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }

        private void addDataToFireBase(String ID, String name, int stock){
            item = new ItemModel();
            item.setID(ID);
            item.setName(name);
            item.setStock(stock);
            item.setImage(R.drawable.test_image);
            databaseReference.child(ID).setValue(item);
        }
}
