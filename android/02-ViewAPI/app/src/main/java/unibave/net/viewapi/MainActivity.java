package unibave.net.viewapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        TextView textView = new TextView(this);
        textView.setText("Aluno:");
        final EditText editText = new EditText(this);
        Button button = new Button(this);
        button.setText("OK!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Olá " + editText.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
        layout.addView(textView);
        layout.addView(editText);
        layout.addView(button);
        setContentView(layout);
    }

}
