package net.unibave.bancodados;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DetalheClienteActivity extends AppCompatActivity {

    private static final String TAG = DetalheClienteActivity.class.getSimpleName();
    private EditText etxId;
    private EditText etxNome;
    private EditText etxTelefone;
    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cliente);
        Log.i(TAG, "onCreate()");
        etxId = (EditText) findViewById(R.id.etxId);
        etxNome = (EditText) findViewById(R.id.etxNome);
        etxTelefone = (EditText) findViewById(R.id.etxTelefone);
        Intent intent = getIntent();
        if (intent != null) {
            Long id = (Long) intent.getSerializableExtra("id");
            if (id != null) {
                cliente = Cliente.load(Cliente.class, id);
                etxId.setText(cliente.getId().toString());
                etxNome.setText(cliente.getNome());
                etxTelefone.setText(cliente.getTelefone());
            }
        }
    }

    public void btnSalvarOnClick(View view) {
        if (cliente == null) {
            cliente = new Cliente();
        }
        cliente.setNome(etxNome.getText().toString());
        cliente.setTelefone(etxTelefone.getText().toString());
        cliente.save();
        Toast.makeText(this, "Cliente salvo com sucesso: " + cliente.getId() + " - " + cliente.getNome(), Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

}
