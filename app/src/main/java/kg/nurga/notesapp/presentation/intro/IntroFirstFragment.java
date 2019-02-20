package kg.nurga.notesapp.presentation.intro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.nurga.notesapp.R;

public class IntroFirstFragment extends Fragment {
    public IntroFirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro_first, container, false);
    }
}
