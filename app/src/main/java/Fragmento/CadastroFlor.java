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
import BancoDados.FlorDB;
import Model.Flor;

public class CadastroFlor extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    private Button btn;
    EditText nome;
    DBHelper db;
    public CadastroFlor() {
        // Required empty public constructor
    }

    public void setDb(DBHelper db) {
        this.db = db;
    }

    public static CadastroFlor newInstance(String param1, String param2) {
        CadastroFlor fragment = new CadastroFlor();
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
        View view= inflater.inflate(R.layout.fragment_cadastro_flor, container, false);
        btn=view.findViewById(R.id.idSalvarProduto);
        nome= view.findViewById(R.id.idNomeProduto);
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
        Flor flor = new Flor();
        flor.setNomeFlor(nome.getText().toString());
        new FlorDB(db).insert(flor);
        Toast.makeText(getContext(),"Salvo",Toast.LENGTH_SHORT).show();
    }
}
