package unibave.net.viewapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(this);
        textView.setText("Nome:");
        EditText editText = new EditText(this);
        Button button = new Button(this);
        button.setText("OK");
        layout.addView(textView);
        layout.addView(editText);
        layout.addView(button);
        setContentView(layout);
//        setContentView(R.layout.activity_main);
    }
}
