package kg.nurga.notesapp.presentation.intro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kg.nurga.notesapp.R;


public class SecondFragment extends Fragment {


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        TextView textView = view.findViewById(R.id.textView2);
        textView.setText(getArguments().getString("msg"));


        return view;
    }
    public static SecondFragment newInstance(String text) {

        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", text);

        secondFragment.setArguments(bundle);

        return secondFragment;
    }

}
