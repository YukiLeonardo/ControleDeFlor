package BancoDados;
    import android.database.sqlite.SQLiteDatabase;
    import android.database.sqlite.SQLiteOpenHelper;

    import androidx.annotation.Nullable;

    import com.example.controledeflores.MainActivity;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable MainActivity context) {
        super(context, "novo", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table cliente(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120),"+
                        "rua varchar(120)," +
                        "numerocasa string);"
        );

        sqLiteDatabase.execSQL(
                "create table flor(" +
                        "id integer primary key autoincrement," +
                        "nomeFlor varchar(120));"
        );

        sqLiteDatabase.execSQL(
                "create table encomenda(" +
                        "id integer primary key autoincrement," +
                        "nome varchar(120)," +
                        "flor varchar(120));"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
