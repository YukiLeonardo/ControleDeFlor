package Adapter;

        import android.annotation.SuppressLint;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import com.example.controledeflores.R;

        import java.util.List;

        import Model.Cliente;

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteHolder> {

    List<Cliente> dados;

    public ClienteAdapter(List<Cliente> dados) {
        this.dados = dados;
    }
    @NonNull
    @Override
    public ClienteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.linha,parent,false);
        return new ClienteHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ClienteHolder clienteHolder, int position) {
        clienteHolder.nome.setText(dados.get(position).getNome());
    }
    @Override
    public int getItemCount() {
        return dados.size();
    }

    public class ClienteHolder extends RecyclerView.ViewHolder {
        public TextView nome;
        public TextView nome2;
        public Button editar;

        public ClienteHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.idNome);
            nome2 = itemView.findViewById(R.id.id_rua);
            editar = itemView.findViewById(R.id.idEditar);
        }
    }
}

