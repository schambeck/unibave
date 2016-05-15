package net.unibave.listview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);

        clientes.add(new Cliente(1, "Fabio Andrade", "9984-7452"));
        clientes.add(new Cliente(2, "João Paulo", "9964-4568"));
        clientes.add(new Cliente(3, "Fabrício da Silva", "9857-4586"));
        clientes.add(new Cliente(4, "Silvio Santos", "8848-4865"));

        listView.setAdapter(new ClienteAdapter(this, clientes));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cliente cliente = clientes.get(position);
                Intent it = new Intent(MainActivity.this, DetalheClienteActivity.class);
                it.putExtra("cliente", cliente);
                startActivity(it);
            }
        });
    }

    class ClienteAdapter extends TwoLineArrayAdapter<Cliente> {

        public ClienteAdapter(Context context, List<Cliente> clientes) {
            super(context, clientes);
        }

        @Override
        public String lineOneText(Cliente cliente) {
            return cliente.getCodigo() + " - " + cliente.getTelefone();
        }

        @Override
        public String lineTwoText(Cliente cliente) {
            return cliente.getNome();
        }
    }

}
