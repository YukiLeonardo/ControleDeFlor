package Fragmento;

import static android.app.PendingIntent.getActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.controledeflores.R;

import java.util.LinkedList;
import java.util.List;

public class Listagem extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List dados ;
    ListView listView;
    private String mParam1;
    private String mParam2;
    private ArrayAdapter adaptar;

    public Listagem() {
        // Required empty public constructor
        dados= new LinkedList();
    }
    public List getDados(){
        return dados;
    }
    public void atualizaAdapter(){
        adaptar.notifyDataSetChanged();
    }

    public static Listagem newInstance(String param1, String param2) {
        Listagem fragment = new Listagem();
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
        View view = inflater.inflate(R.layout.fragment_listagem, container, false);
        listView=view.findViewById(R.id.idLista);
        adaptar= new ArrayAdapter(   getActivity(),
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                dados);
        listView.setAdapter(adaptar);
        return  view;
    }
}
