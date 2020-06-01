package ca.georgebrown.assignment2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import ca.georgebrown.assignment2.DummyContent.DummyItem;

public class AddItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        Button btn_save = findViewById(R.id.btnAdd);
        final TextView item_name = findViewById(R.id.txtAdd);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cont = item_name.getText().toString();
                DummyItem item = new DummyItem
                        (String.valueOf(DummyContent.ITEMS.size()+1), cont);

                //adding an item
                DummyContent.ITEMS.add(item);
                DummyContent.ITEM_MAP.put(item.id, item);
                Intent i = new Intent();
                ((Activity)v.getContext()).setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }
}
