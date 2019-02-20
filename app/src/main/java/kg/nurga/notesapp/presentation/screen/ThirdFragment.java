package kg.nurga.notesapp.presentation.screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kg.nurga.notesapp.R;


public class ThirdFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_intro_screen, container, false);

        TextView textView = view.findViewById(R.id.textView3);
        textView.setText(getArguments().getString("msg"));
        return view;


    }
    public static SecondFragment newInstance(String text) {

        SecondFragment secondFragment = new SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        secondFragment.setArguments(b);

        return secondFragment;
    }

}
