package edu.lewisu.fieldformapp;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstName,Address;
    edu.lewisu.fieldformapp.SQLDatabase sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName=(EditText)findViewById(R.id.editText);
        Address=(EditText)findViewById(R.id.editText2);
        sql=new edu.lewisu.fieldformapp.SQLDatabase(MainActivity.this);
    }

    public void click(View v)
    {
        String fName = firstName.getText().toString();
        String add = Address.getText().toString();
        sql.open();
        sql.save();
        sql.close();
        Toast.makeText(MainActivity.this, "Saved Successfully", Toast.LENGTH_SHORT).show();

    }

    public void view(View v)
    {
        String txt=sql.get();
        Dialog d=new Dialog(MainActivity.this);
        d.setTitle("Form Data");
        TextView tv=new TextView(MainActivity.this);
        tv.setText(txt);
        d.setContentView(tv);
        d.show();
    }
}
