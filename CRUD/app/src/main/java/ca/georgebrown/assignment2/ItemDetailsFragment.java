package ca.georgebrown.assignment2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ItemDetailsFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public DummyContent.DummyItem getItem() {
        return item;
    }

    public void setItem(DummyContent.DummyItem item) {
        this.item = item;
        Activity a = getActivity();
        if(a != null) {
            TextView t = a.findViewById(R.id.text);
            if (t != null)
                t.setText(item.name);
        }
    }

    private DummyContent.DummyItem item;
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ItemDetailsFragment() { }

    @SuppressWarnings("unused")
    public static ItemDetailsFragment newInstance(String param1, String param2) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_item_details, container, false);

        //deleting item
        Button btn_delete = v.findViewById(R.id.btnDelete);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onFragmentInteraction(item);
            }
        });

        if(item != null){
            TextView text = v.findViewById(R.id.text);
            if (text != null)
                text.setText(item.name);
        }
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(DummyContent.DummyItem item);
    }
}
