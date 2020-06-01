package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class DeleteItem extends FragmentActivity
        implements ItemDetailsFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delete_item);

        FragmentManager manager = getSupportFragmentManager();
        ItemDetailsFragment itemDetailsFragment =
                (ItemDetailsFragment) manager
                        .findFragmentById(R.id.details_fragment);
        DummyContent.DummyItem item = (DummyContent.DummyItem)
                getIntent().getExtras().getSerializable("item");
        itemDetailsFragment.setItem(item);
    }

    @Override
    public void onFragmentInteraction(DummyContent.DummyItem item) {
        DummyContent.ITEMS.remove(DummyContent.ITEM_MAP.get(item.id));
        DummyContent.ITEM_MAP.remove(item.id);
        setResult(RESULT_OK);
        finish();

    }
}
