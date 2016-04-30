package net.unibave.selecionarcontato;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSelecionarContatosOnClick(View view) {
        Uri uri = Uri.parse("content://com.android.contacts/contacts");
        Intent intent = new Intent(Intent.ACTION_PICK, uri);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri uri = data.getData();
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            if (cursor != null) {
                cursor.moveToNext();
                String i = ContactsContract.Contacts.DISPLAY_NAME;
                String id = ContactsContract.Contacts._ID;
                int nameColumn = cursor.getColumnIndex(i);
                String nome = cursor.getString(nameColumn);
                cursor.close();

                Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + id, null, null);
                String number = null;
                while (phones.moveToNext()) {
                    number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                }
                phones.close();

                Toast.makeText(this, "Nome: " + nome + " Número: " + number, Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Cursor inválido!", Toast.LENGTH_LONG).show();
            }
        }
    }

}
