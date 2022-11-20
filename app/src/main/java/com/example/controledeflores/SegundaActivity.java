package com.example.controledeflores;
import static android.content.Intent.getIntent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import BancoDados.ClienteDB;
import BancoDados.DBHelper;
import BancoDados.EncomendaDB;
import BancoDados.FlorDB;
import Fragmento.CadastroCliente;
import Fragmento.CadastroEncomenda;
import Fragmento.CadastroFlor;
import Fragmento.Listagem;


public class SegundaActivity extends AppCompatActivity {
    Fragment fragmento;
    Listagem listagem;
    DBHelper db;
    ArrayAdapter adapter;
    private String acao;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        getSupportActionBar().setElevation(0);
        listagem=new Listagem();
        acao=getIntent().getStringExtra("fragmento");
        fragmento=criaFragmento(acao);

        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.idframe,listagem);
        transaction.commit();
        findViewById(R.id.idLista);

    }

    public Fragment criaFragmento(String nome){
        switch (nome){
            case "Fornecedor":
                fragmento=new CadastroEncomenda();

                break;
            case "Produto":
                fragmento=new CadastroFlor();
                break;
            case "Cliente":
                fragmento=new CadastroCliente();
                break;
        }
        return fragmento;
    }
    public void segundaTela(View view){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.idframe,fragmento)
                .commit();
    }
    public void primeiraTela(View view){
        getSupportFragmentManager().beginTransaction().
                replace(R.id.idframe,listagem)
                .commit();
        switch (acao){
            case "Fornecedor":
                new EncomendaDB(db).list(listagem.getDados());
                break;
            case "Produto":
                new FlorDB(db).list(listagem.getDados());
                break;
            case "Cliente":
                new ClienteDB(db).list(listagem.getDados());
                break;

        }
        listagem.atualizaAdapter();
    }
}
