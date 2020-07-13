package ua.artemii.firsttask;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String YOU_TUBE_URL = "https://www.youtube.com/";
    private static final String THREE_SS_URL = "https://3ss.tv/";

    private MyFragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.youtube_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(YOU_TUBE_URL));
                startActivity(intent);
                Log.d(TAG, "URL: " + YOU_TUBE_URL + " was opened");

            }
        });


        findViewById(R.id.three_ss_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(THREE_SS_URL));
                startActivity(intent);
                Log.d(TAG, "URL: " + THREE_SS_URL + " was opened");
            }
        });

        findViewById(R.id.fragment_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMyFragment = new MyFragment();
                getFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.container, mMyFragment)
                        .commit();
                Log.d(TAG, MyFragment.class.getName() + " was opened");
            }
        });
    }
}
