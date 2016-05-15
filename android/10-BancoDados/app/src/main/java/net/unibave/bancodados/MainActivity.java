package net.unibave.bancodados;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.activeandroid.query.Select;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

//        clientes.add(new Cliente(1, "Fabio Andrade", "9984-7452"));
//        clientes.add(new Cliente(2, "João Paulo", "9964-4568"));
//        clientes.add(new Cliente(3, "Fabrício da Silva", "9857-4586"));
//        clientes.add(new Cliente(4, "Silvio Santos", "8848-4865"));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cliente cliente = clientes.get(position);
                Intent it = new Intent(MainActivity.this, DetalheClienteActivity.class);
                it.putExtra("id", cliente.getId());
                startActivity(it);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           final int position, long id) {
                new AlertDialog.Builder(MainActivity.this)
                        .setMessage("Confirma exclusão?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int which) {
                                Cliente cliente = clientes.get(position);
                                cliente.delete();
                                Toast.makeText(MainActivity.this,
                                        "Cliente excluído com sucesso: " + cliente.getId()
                                                + " - " + cliente.getNome(),
                                        Toast.LENGTH_SHORT).show();
                                refreshListView();
                            }
                        })
                        .setNegativeButton("Não", null)
                        .show();
                return true; // se retornar false o onItemClickListener é chamado depois
            }
        });
    }

    public void fabNovoOnClick(View view) {
        Intent it = new Intent(MainActivity.this, DetalheClienteActivity.class);
        startActivity(it);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshListView();
    }

    private void refreshListView() {
        clientes = new Select()
                .from(Cliente.class)
                .orderBy("nome")
                .execute();
        listView.setAdapter(new ClienteAdapter(this, clientes));
    }

    class ClienteAdapter extends TwoLineArrayAdapter<Cliente> {

        public ClienteAdapter(Context context, List<Cliente> clientes) {
            super(context, clientes);
        }

        @Override
        public String lineOneText(Cliente cliente) {
            return cliente.getId() + " - " + cliente.getTelefone();
        }

        @Override
        public String lineTwoText(Cliente cliente) {
            return cliente.getNome();
        }
    }

}
