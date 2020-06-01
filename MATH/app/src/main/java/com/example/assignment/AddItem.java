package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        Button add = findViewById(R.id.btnAdd);
        final TextView add_name = findViewById(R.id.txtAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cont = add_name.getText().toString();
                DummyContent.DummyItem item = new DummyContent.
                        DummyItem(String.valueOf(DummyContent.ITEMS.size()+1), cont);

                DummyContent.ITEMS.add(item);
                DummyContent.ITEM_MAP.put(item.id , item);
                Intent i = new Intent();
                ((Activity)v.getContext()).setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }
}
