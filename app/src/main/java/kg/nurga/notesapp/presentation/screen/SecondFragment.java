package kg.nurga.notesapp.presentation.screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import kg.nurga.notesapp.R;


public class SecondFragment extends Fragment {


    private static final String FIRST_FRAGMENT = "msg";


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second_intro_screen, container, false);
        TextView textView = view.findViewById(R.id.textView2);
        ImageView imageView = view.findViewById(R.id.imageLev);
        textView.setText(getArguments().getString(FIRST_FRAGMENT));


        return view;
    }
    public static SecondFragment newInstance(String text) {

        SecondFragment secondFragment = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FIRST_FRAGMENT, text);

        secondFragment.setArguments(bundle);

        return secondFragment;
    }

}
