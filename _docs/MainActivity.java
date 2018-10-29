package com.example.hiren.fieldformapp1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstName,Address;
    SQLDatabase sql;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.editText1);
        Address=(EditText)findViewById(R.id.editText2);
        sql=new SQLDatabase(MainActivity.this);
    }

    public void click(View v)
    {
        String firstName=name.getText().toString();
        String Address=add.getText().toString();
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
