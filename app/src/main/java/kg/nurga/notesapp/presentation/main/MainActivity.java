package kg.nurga.notesapp.presentation.main;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import kg.nurga.notesapp.R;
import kg.nurga.notesapp.presentation.intro.IntroActivity;

public class MainActivity extends AppCompatActivity {

    public static void start(Activity activity) {
        activity.startActivity(new Intent(activity, MainActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
