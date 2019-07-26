package com.example.database;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {

            SQLiteDatabase mydatabase=this.openOrCreateDatabase("student",MODE_PRIVATE,null);

            mydatabase.execSQL("CREATE TABLE IF NOT EXISTS profile(name VARCHAR,year INT(4) )");
            mydatabase.execSQL("INSERT INTO profile(name,year) VALUES ('HARI',1945) ");
            mydatabase.execSQL("INSERT INTO profile(name,year) VALUES ('JOHN',1948) ");
            mydatabase.execSQL("INSERT INTO profile(name,year) VALUES ('AMAN',1949) ");
            mydatabase.execSQL("INSERT INTO profile(name,year) VALUES ('JUDIT',1950) ");

            Cursor c=mydatabase.rawQuery("SELECT *FROM profile",null);
            mydatabase.execSQL("UPDATE profile SET name='Alton' where name='AMAN'");
            mydatabase.execSQL("DELETE FROM profile WHERE name = 'Alton'");
            int name=c.getColumnIndex("name");
            int year=c.getColumnIndex("year");

            c.moveToFirst();
            while (c!=null){

                Log.i("name",c.getString(name));
                Log.i("year",Integer.toString((c.getInt(year))));
                Log.i("Count:",Integer.toString(c.getCount()));

                c.moveToNext();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
