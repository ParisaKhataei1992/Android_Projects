package com.example.assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Assignment2 extends FragmentActivity implements
        ItemFragment.OnListFragmentInteractionListener,
        ItemDetailsFragment.OnFragmentInteractionListener {

    public static final int CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment2);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent i = new Intent(view.getContext(), AddItem.class);
                startActivityForResult(i, 1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent date) {
        super.onActivityResult(requestCode, resultCode, date);
        if (requestCode == 1 || requestCode == CODE) {
            if (resultCode == Activity.RESULT_OK) {
                updateList();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_assignment2, menu);
        return true;
    }

    public void updateList() {
        FragmentManager manager = getSupportFragmentManager();
        ItemFragment fragment = (ItemFragment) manager.
                findFragmentById(R.id.list_fragment);
        fragment.updateView();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onListFragmentInteraction(
            DummyContent.DummyItem item) {

        Toast.makeText(this,
                "Selected: " + item.name,
                Toast.LENGTH_LONG).show();
        Button b = findViewById(R.id.btnDelete);
        if (b != null) {
            FragmentManager manager = getSupportFragmentManager();
            ItemDetailsFragment itemDetailsFragment =
                    (ItemDetailsFragment) manager
                            .findFragmentById(R.id.details_fragment);
            itemDetailsFragment.setItem(item);
        } else {

            Intent i = new Intent(this,
                    DeleteItem.class);
            i.putExtra("item", item);
            startActivityForResult(i, CODE);
        }
    }

    @Override
    public void onFragmentInteraction(DummyContent.DummyItem item) {
        DummyContent.ITEMS.remove(item);
        DummyContent.ITEM_MAP.remove(item.id);
        FragmentManager manager = getSupportFragmentManager();
        ItemFragment fragment =
                (ItemFragment) manager
                        .findFragmentById(R.id.list_fragment);
        fragment.updateView();

    }
}


