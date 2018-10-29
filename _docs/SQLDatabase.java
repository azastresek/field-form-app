package com.example.hiren.fieldformapp1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLDatabase {
    String database="db";
    String table="userForm";
    int version=1;
    String firstName="First Name";
    String middleName="Middle Name";
    String lastName="Last Name";
    String dateOfBirth="Date Of Birth";
    String SSN="Social Security Number";
    String email="Email Address";
    String phoneNum="Phone Number";
    String contactPref="Contact Preference";
    String Address="Address";
    String City="City";
    String State="State";
    String Zip="Zip Code";
    String County="County";
    String Gender="Gender";
    String Ethnicity="Ethnicity";
    String Consent ="Consent";
    String highSchool="High School";
    String programOfInterest="Program of Interest";
    String gradYear="High School Graduation Year";
    String extraCurricularActivity="Extra Curricular Activities";
    String Hobbies="Hobbies";
    String Scholarships="Scholarships";
    String finanAid="Financial Aid";
    String medInfo="Medical Information";
    String id="ID";

    helper h;
    Context c;

    SQLiteDatabase s;

    public class helper extends SQLDatabaseOpenHelper {
        public helper(Context context) {
            super(context, database, null, version);
            // TODO Auto-generated constructor stub
        }
    }

        @Override
        public void onCreate(SQLiteDatabase arg0) {
            String query = "Create Table" "+table+" ("+id" INTEGER PRIMARY KEY AUTOINCREMENT,
            "+firstName+" TEXT NOT NULL);";
            // TODO Auto-generated method stub
        }

        @Override
        public void onUpgrade(SQLiteDatabase arg0, int arg1, arg2) {
            arg0.execSQL(query);
            {
                // TODO Auto-generated method stub

            }
        }

    public SQLDatabase(MainActivity mainActivity)
    {
        c=mainActivity;
        // TODO Auto-generated constructor stub
    }

    public void open()
    {
        h=new helper(c);
        s=h.getWritableDatabase();
        // TODO Auto-generated method stub
    }

    public void save(String na, String ad)
    {
        // TODO Auto-generated method stub
        ContentValues cv=new ContentValues();
        cv.put(firstName, na);
        cv.put(Address, ad);
        s.insert(table, null, cv);
    }

    public void close()
    {
        s.close();
        // TODO Auto-generated method stub
    }

    public String get()
    {
        h=new helper(c);
        s=h.getReadableDatabase();
        String txt="";
        String[] col={id,firstName,Address};
        Cursor c=s.query(table, col, null, null, null, null, null);
        c.moveToFirst();
        for(c.moveToFirst();!((Cursor) c).isAfterLast();c.moveToNext())
        {
            txt=txt+c.getString(0)+" "+c.getString(1)+ " "+c.getString(2)+"\n";
        }
        return txt;
    }
}

