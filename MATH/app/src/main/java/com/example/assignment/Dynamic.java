package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class Dynamic extends FragmentActivity
        implements ItemFragment.OnListFragmentInteractionListener,
        ItemDetailsFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction tx = manager.beginTransaction();
        ItemFragment fragment = new ItemFragment();
        tx.add(R.id.container, fragment);
        tx.commit();
    }

    @Override
    public void onFragmentInteraction(DummyContent.DummyItem item) {
        DummyContent.ITEMS.remove(item);
        DummyContent.ITEM_MAP.remove(item.id);
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack();
    }

    @Override
    public void onListFragmentInteraction(
            DummyContent.DummyItem item) {

        Button btnDelete = findViewById(R.id.btnDelete);
        FragmentManager manager = getSupportFragmentManager();

        if(btnDelete!=null) {
            //FragmentManager manager = getSupportFragmentManager();
            ItemDetailsFragment itemDetailsFragment =
                    (ItemDetailsFragment) manager
                            .findFragmentById(R.id.details_fragment);
            itemDetailsFragment.setItem(item);
        }else{

           // FragmentManager manager = getSupportFragmentManager();
            ItemDetailsFragment fragment = new ItemDetailsFragment();
            FragmentTransaction tx = manager.beginTransaction();
            tx.replace(R.id.container, fragment);
            tx.addToBackStack("detail");
            tx.commit();
            fragment.setItem(item);
        }
    }
}
