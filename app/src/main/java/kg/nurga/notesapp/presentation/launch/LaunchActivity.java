package kg.nurga.notesapp.presentation.launch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kg.nurga.notesapp.R;
import kg.nurga.notesapp.presentation.intro.IntroActivity;


public class LaunchActivity extends AppCompatActivity {
    SharedPreferences mSharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean tutorialWasShown = mSharedPreferences.getBoolean("tutorial", false);
        if (!tutorialWasShown) {

            startActivity(new Intent(this, IntroActivity.class));
            finish();

        }else {
            setContentView(R.layout.activity_launch);

        }
    }
}
