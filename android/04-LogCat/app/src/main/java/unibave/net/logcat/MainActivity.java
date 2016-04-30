package unibave.net.logcat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v(TAG, "Log verboso");
        Log.d(TAG, "Log debug");
        Log.i(TAG, "Log info");
        Log.w(TAG, "Log aviso");
        Log.e(TAG, "Log erro");
    }
}
