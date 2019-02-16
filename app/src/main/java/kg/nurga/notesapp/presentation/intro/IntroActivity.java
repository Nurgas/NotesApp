package kg.nurga.notesapp.presentation.intro;

import android.content.Intent;
import android.support.annotation.DrawableRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kg.nurga.notesapp.R;
import kg.nurga.notesapp.presentation.main.MainActivity;

public class IntroActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.setOffscreenPageLimit(3);

        mViewPager.setCurrentItem(mSectionsPagerAdapter.getCount() / 2);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_intro, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        private static final String ARG_IMAGE_RES_ID = "image_res_id";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(
                int sectionNumber
        ) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_intro, container, false);
            TextView textView = rootView.findViewById(R.id.section_label);
            ImageView imageView = rootView.findViewById(R.id.section_image);
            Button button = rootView.findViewById(R.id.button);
            Button button1 = rootView.findViewById(R.id.button1);

            int page = getArguments().getInt(ARG_SECTION_NUMBER);

            switch (page) {
                case 0:
                    textView.setText("Hi");
                    imageView.setImageResource(R.drawable.lev);
                    button.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.INVISIBLE);

                    break;
                case 1:
                    textView.setText("How are you?");
                    imageView.setImageResource(R.drawable.lev);
                    button.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.INVISIBLE);


                    break;
                case 2:
                    textView.setText("What are you doing?");
                    imageView.setImageResource(R.drawable.lev);
                    button.setVisibility(View.INVISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(getContext(), MainActivity.class));
                            getActivity().finish();
                        }
                    });


                    break;
            }

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position);

//            int index = position % 6;
//            Log.d("ololo", "Index is " + index + " , Position is " + position);
//            int imageRes;
//            if (index == 0) {
//                imageRes = R.drawable.ic_attachment;
//            } else {
//                imageRes = R.drawable.ic_circle_plus;
//            }
//            return PlaceholderFragment.newInstance(index + 1, imageRes);


        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
