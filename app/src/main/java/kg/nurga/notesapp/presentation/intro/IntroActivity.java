package kg.nurga.notesapp.presentation.intro;


import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.badoualy.stepperindicator.StepperIndicator;

import kg.nurga.notesapp.App;
import kg.nurga.notesapp.R;
import kg.nurga.notesapp.presentation.main.MainActivity;
import kg.nurga.util.SharedStorage;
import kg.nurga.util.SharedStorageImpl;


public class IntroActivity extends AppCompatActivity implements View.OnClickListener {
    private IntroPagerAdapter mIntroAdapter;
    private ViewPager mViewPager;

    private TextView nextBtn, skipBtn;
    private StepperIndicator mStepperIndicator;

    private SharedPreferences mSharedPreferences;

    private static String PREF_FIRST_LAUNCH = "first_launch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        mSharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
        if(isFirstLaunch()) {
            setContentView(R.layout.activity_intro);

            firstLaunch();

            init();
        } else {
            MainActivity.start(this);
            finish();
        }
    }


    private void init() {
        initViewPager();
        nextBtn = findViewById(R.id.intro_next_btn);
        nextBtn.setOnClickListener(this);
        skipBtn = findViewById(R.id.intro_skip_btn);
        skipBtn.setOnClickListener(this);
    }

    private void initViewPager(){
        mIntroAdapter = new IntroPagerAdapter(getSupportFragmentManager());

        mStepperIndicator = findViewById(R.id.intro_stepper);

        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mIntroAdapter);
        mViewPager.setOffscreenPageLimit(3);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {
                onPageChanged(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        mStepperIndicator.setViewPager(mViewPager, mIntroAdapter.getCount());
    }

    private boolean isFirstLaunch() {
        if (mSharedPreferences.contains(PREF_FIRST_LAUNCH)) {
            return mSharedPreferences.getBoolean(PREF_FIRST_LAUNCH, true);
        } else {
            return true;
        }
    }

    private void firstLaunch() {
        mSharedPreferences.edit()
                .putBoolean(PREF_FIRST_LAUNCH, false)
                .apply();
    }

    private void onPageChanged(int position) {
        String btnText = "Next";
        if (position == 2) {
            btnText = "Finish";
        }
        nextBtn.setText(btnText);
    }



    private void onNextClick() {
        if(mViewPager.getCurrentItem()==mIntroAdapter.getCount()-1){
            MainActivity.start(this);
            finish();
        } else {
            mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.intro_next_btn:
                onNextClick();

                break;
            case R.id.intro_skip_btn:
                MainActivity.start(this);
                finish();
        }
    }

    public class IntroPagerAdapter extends FragmentPagerAdapter {

        private final int PAGES_COUNT = 3;

        public IntroPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = new IntroFirstFragment();
                    break;
                case 1:
                    fragment = new IntroSecondFragment();
                    break;
                case 2:
                    fragment = new IntroThirdFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return PAGES_COUNT;
        }
    }
}
