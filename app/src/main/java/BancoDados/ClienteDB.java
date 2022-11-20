package BancoDados;

    import android.content.ContentValues;
    import android.database.Cursor;
    import android.database.sqlite.SQLiteDatabase;

    import java.util.List;

    import Model.Cliente;

public class ClienteDB {
    DBHelper db;
    private SQLiteDatabase conexao;
    public ClienteDB(DBHelper db) {
        this.db = db;
    }

    public void insert(Cliente c) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", c.getNome());

        conexao.insertOrThrow("pessoa", null, values);
        conexao.close();
    }

    public void list(List data) {
        data.clear();
        conexao = db.getReadableDatabase();

        String names[] = {"id", "nome"};
        Cursor query = conexao.query(
                "pessoa", names, null, null, null, null,
                null
        );

        while(query.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(query.getString(0)));
            cliente.setNome(query.getString(1));


            data.add(cliente);
        }

        conexao.close();
    }

    public void remove(Integer id) {
        conexao = db.getWritableDatabase();
        conexao.delete("pessoa", "id=?", new String[]{ id+"" });
        conexao.close();
    }
}
