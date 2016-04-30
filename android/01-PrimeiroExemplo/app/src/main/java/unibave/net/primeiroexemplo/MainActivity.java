package unibave.net.primeiroexemplo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etxAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxAluno = (EditText) findViewById(R.id.etxAluno);
    }

    public void btnOkOnClick(View view) {
        String msg = "Olá " + etxAluno.getText().toString() + "!";
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

}
