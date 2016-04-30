package net.unibave.navegador;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnAbrirNavegadorOnClick(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String endereco = editText.getText().toString();
        Uri uri = Uri.parse("http:" + endereco);
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(intent);
    }

}
