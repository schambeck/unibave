package net.unibave.logcat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "Verbose");
        Log.d(TAG, "Debug");
        Log.i(TAG, "Info");
        Log.w(TAG, "Warning");
        Log.e(TAG, "Error");
    }
}
