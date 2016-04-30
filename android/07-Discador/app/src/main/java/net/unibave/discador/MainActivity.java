package net.unibave.discador;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
    }

    public void btnDiscarOnClick(View view) {
        String numero = editText.getText().toString();
        Uri uri = Uri.parse("tel:" + numero);
        Intent intent = new Intent(Intent.ACTION_CALL, uri);
        startActivity(intent);
    }

}
