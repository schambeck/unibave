package net.unibave.parametrosactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String KEY = "ALUNO";
    private EditText etxAluno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etxAluno = (EditText) findViewById(R.id.etxAluno);
    }

    public void btnOkOnClick(View view) {
        String aluno = etxAluno.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY, aluno);
//        startActivity(intent);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            String idade = data.getStringExtra(SecondActivity.KEY);
            Toast.makeText(MainActivity.this, "Você tem " + idade + " anos, parabéns!", Toast.LENGTH_SHORT).show();
        }
    }

}
