package BancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import Model.Encomenda;

public class EncomendaDB {
    DBHelper db;
    private SQLiteDatabase conexao;
    public EncomendaDB(DBHelper db) {
        this.db = db;
    }

    public void insert(Encomenda encomenda) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", encomenda.getNome());

        conexao.insertOrThrow("fornecedor", null, values);
        conexao.close();
    }

    public void list(List data) {
        data.clear();
        conexao = db.getReadableDatabase();

        String names[] = {"id", "nome"};
        Cursor query = conexao.query(
                "encomenda", names, null, null, null, null,
                null
        );

        while(query.moveToNext()) {
            Encomenda encomenda = new Encomenda();
            encomenda.setId(Integer.parseInt(query.getString(0)));
            encomenda.setNome(query.getString(1));

            data.add(encomenda);
        }

        conexao.close();
    }

    public void remove(Integer id) {
        conexao = db.getWritableDatabase();
        conexao.delete("encomenda", "id=?", new String[]{ id+"" });
        conexao.close();
    }
}
