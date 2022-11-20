package BancoDados;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import Model.Flor;

public class FlorDB {
    DBHelper db;
    private SQLiteDatabase conexao;
    public FlorDB(DBHelper db) {
        this.db = db;
    }

    public void insert(Flor flor) {
        conexao = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", flor.getNomeFlor());

        conexao.insertOrThrow("flor", null, values);
        conexao.close();
    }

    public void list(List data) {
        data.clear();
        conexao = db.getReadableDatabase();

        String names[] = {"id", "nome"};
        Cursor query = conexao.query(
                "flor", names, null, null, null, null,
                null
        );

        while(query.moveToNext()) {
            Flor flor = new Flor();
            flor.setId(Integer.parseInt(query.getString(0)));
            flor.setNomeFlor(query.getString(1));

            data.add(flor);
        }

        conexao.close();
    }

    public void remove(Integer id) {
        conexao = db.getWritableDatabase();
        conexao.delete("flor", "id=?", new String[]{ id+"" });
        conexao.close();
    }
}
