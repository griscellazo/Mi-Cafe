package bo.Androides.MiCafe.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import bo.Androides.MiCafe.Constants;

public class Database extends SQLiteOpenHelper {

    public Database(Context context){
        super(context,
                Constants.DATABASE_NAME,
                null,
                Constants.DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " usuario VARCHAR NOT NULL," +
                " password VARCHAR NOT NULL," +
                " edad INTEGER," +
                " email VARCHAR NOT NULL," +
                " codigoUpb INTEGER NOT NULL)");
        Log.d("Database", "Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
