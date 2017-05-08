package him.testloginpro;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.password;

public class Main2Activity extends AppCompatActivity {
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView1 = (TextView) findViewById(R.id.textView1);
        TextView textView3 = (TextView) findViewById(R.id.textView3);

        Intent intent = getIntent();
        String userdIdString = intent.getStringExtra("userdId");
        String passwordString = intent.getStringExtra("password");
        textView1.setText("USER-ID"+userdIdString);
        textView3.setText("PASSWORD"+passwordString);
        //verifyUser(userdIdString,passwordString);
        SQLiteDatabase mydatabase = openOrCreateDatabase("LoginDB",MODE_PRIVATE,null);
        mydatabase.execSQL("DROP TABLE IF EXISTS " + "loginData");
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS loginData(Username VARCHAR,Password VARCHAR);");
        ContentValues contentValues = new ContentValues();
        contentValues.put("Username",userdIdString);
        contentValues.put("Password",passwordString);
        mydatabase.insert("loginData",null,contentValues);
       // mydatabase.execSQL("INSERT INTO loginData VALUES(Username ,userdIdString,passwordString);");
        verifyUserFromDB(mydatabase);

    }


    public void verifyUser (String userdIdString, String passwordString){
        textView4 = (TextView) findViewById(R.id.textView4);
        if("himanshu".equals(userdIdString) && "omshanti".equals(passwordString)) {
            textView4.setText("Login Succuessful ::");
        } else {
            textView4.setText("Login failed ::");
        }
    }

    public void verifyUserFromDB (SQLiteDatabase mydatabase){
        Cursor resultset=mydatabase.rawQuery("select * from loginData",null);
        resultset.moveToFirst();
        String userdIdString =resultset.getString(0);
        String passwordString =resultset.getString(1);

        textView4 = (TextView) findViewById(R.id.textView4);
        if("himanshu".equals(userdIdString) && "omshanti".equals(passwordString)) {
            textView4.setText("verifyUserFromDB- Login Succuessful ::");
        } else {
            textView4.setText("verifyUserFromDB -Login failed ::");
        }
    }
}
