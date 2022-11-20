package Fragmento;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.controledeflores.MainActivity;
import com.example.controledeflores.R;

import BancoDados.DBHelper;
import BancoDados.EncomendaDB;
import Model.Encomenda;

public class CadastroEncomenda extends Fragment {
    DBHelper db;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    private Button btn;
    EditText nome;

    public CadastroEncomenda() {
        // Required empty public constructor
    }

    public void setDb(DBHelper db) {
        this.db = db;
    }
    public static CadastroEncomenda newInstance(String param1, String param2) {
        CadastroEncomenda fragment = new CadastroEncomenda();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cadastro_encomenda, container, false);
        btn=view.findViewById(R.id.idSalvarEncomenda);
        nome= view.findViewById(R.id.idNomeFlor);
        db=new DBHelper((MainActivity) getActivity());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                salvar();
            }
        });

        return view;
    }

    private void salvar() {
        Encomenda encomenda = new Encomenda();
        encomenda.setNome(nome.getText().toString());
        new EncomendaDB(db).insert(encomenda);
        Toast.makeText(getContext(),"Salvo",Toast.LENGTH_SHORT).show();
    }
}
