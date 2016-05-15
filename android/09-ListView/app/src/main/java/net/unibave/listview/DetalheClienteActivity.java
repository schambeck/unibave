package net.unibave.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.Serializable;

public class DetalheClienteActivity extends AppCompatActivity {

    private EditText etxCodigo;
    private EditText etxNome;
    private EditText etxTelefone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);
        Intent intent = getIntent();
        if (intent != null) {
            Cliente cliente = (Cliente) intent.getSerializableExtra("cliente");
            if (cliente != null) {
                etxCodigo = (EditText) findViewById(R.id.etxCodigo);
                etxNome = (EditText) findViewById(R.id.etxNome);
                etxTelefone = (EditText) findViewById(R.id.etxTelefone);
                etxCodigo.setText(cliente.getCodigo().toString());
                etxNome.setText(cliente.getNome());
                etxTelefone.setText(cliente.getTelefone());
            }
        }
    }
}
