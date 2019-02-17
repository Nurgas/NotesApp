package kg.nurga.notesapp.presentation.intro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import kg.nurga.notesapp.R;
public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        TextView textView = view.findViewById(R.id.textView1);
        textView.setText(getArguments().getString("msg"));

        return view;
    }

    public static FirstFragment newInstance(String text) {

        FirstFragment firstFragment = new FirstFragment();
        Bundle bundle = new Bundle();
        bundle.putString("msg", text);

        firstFragment.setArguments(bundle);

        return firstFragment;
    }
}

