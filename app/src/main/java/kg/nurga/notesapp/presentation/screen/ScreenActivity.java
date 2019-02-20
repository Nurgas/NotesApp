package kg.nurga.notesapp.presentation.screen;


import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import kg.nurga.notesapp.R;

public class ScreenActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_screen, menu);
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



    public void onClickNextFirst(View view) {
        Button buttonNextFirst = findViewById(R.id.buttonNext1);
        buttonNextFirst.setVisibility(View.INVISIBLE);

        setContentView(R.layout.fragment_second_intro_screen);
    }

    public void onClickNextSecond(View view) {
    }

    public void onClickNextFinish(View view) {
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return FirstFragmentIntroScreen.newInstance("First Fragment");
                case 1:
                    return SecondFragment.newInstance("SecondFragment");
                case 2:
                    return ThirdFragment.newInstance("ThirdFragment");
                    default: return SecondFragment.newInstance("First Fragment");
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
