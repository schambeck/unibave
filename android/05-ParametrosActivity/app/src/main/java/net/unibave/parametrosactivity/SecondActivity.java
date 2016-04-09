package net.unibave.parametrosactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY = "IDADE";
    private TextView txtAluno;
    private EditText etxIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtAluno = (TextView) findViewById(R.id.txtAluno);
        etxIdade = (EditText) findViewById(R.id.etxIdade);

        Intent intent = getIntent();
        if (intent != null) { // activity foi iniciada pelo usuário
            String aluno = intent.getStringExtra(MainActivity.KEY);
            txtAluno.setText("Olá " + aluno + ". Qual sua idade?");
        }
    }

    public void btnOkOnClick(View view) {
        String idade = etxIdade.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(KEY, idade);
        setResult(RESULT_OK, intent);
        finish();
    }

}
