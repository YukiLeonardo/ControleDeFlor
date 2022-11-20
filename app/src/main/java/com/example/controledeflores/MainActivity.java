package com.example.controledeflores;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.LinkedList;
import java.util.List;

import Adapter.ClienteAdapter;
import BancoDados.DBHelper;
import BancoDados.ClienteDB;
import Model.Cliente;

public class MainActivity extends AppCompatActivity {
    DBHelper db;
    ClienteDB clienteDB;
    ClienteAdapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    List dados;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        linearLayoutManager=new LinearLayoutManager(this);

            dados= new LinkedList();
            db= new DBHelper(this);
            clienteDB = new ClienteDB(db);
            clienteDB.list(dados);
            adapter = new ClienteAdapter(dados);
            recyclerView = findViewById(R.id.idLista);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);


        }
        public void salvar(View view){
            Cliente cliente = new Cliente();
            cliente.setNome(((EditText)findViewById(R.id.id_nome)).getText().toString());
            ClienteDB clienteDB = new ClienteDB(db);
            clienteDB.insert(cliente);
            clienteDB.list(dados);
            adapter.notifyDataSetChanged();

    }
}