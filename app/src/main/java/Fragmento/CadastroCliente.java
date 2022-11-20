package Fragmento;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.controledeflores.MainActivity;
import com.example.controledeflores.R;

import BancoDados.DBHelper;



public class CadastroCliente extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    Button btn;
    DBHelper db;

    public void setDb(DBHelper db) {
        this.db = db;
    }

    public CadastroCliente() {
        // Required empty public constructor
    }

    public static CadastroCliente newInstance(String param1, String param2) {
        CadastroCliente fragment = new CadastroCliente();
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
        View view = inflater.inflate(R.layout.fragment_cadastro_cliente, container, false);
        btn = view.findViewById(R.id.idSalvarCliente);
        db = new DBHelper((MainActivity) getActivity());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "ola", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
