package com.photoshotlist;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.photoshotlist.DAL.PSLDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickAddCategory(View view)
    {
//        EditText categoryName = null;
        TextView display = null;
        Cursor cursor = null;
        SQLiteDatabase db = null;

        try
        {
            /*categoryName = (EditText) findViewById(R.id.editTextCategoryName);
            String text = categoryName.getText().toString();*/

            display = (TextView)findViewById(R.id.textViewDisplayCategory);
            //display.setText(String.format("Thanks for adding category: %s", text));

            SQLiteOpenHelper bomDiaDatabaseHelper = new PSLDatabaseHelper(this);
            db = bomDiaDatabaseHelper.getReadableDatabase();
            cursor = db.query("Category", new String[]{"Name"}, null, null, null, null, "RANDOM() LIMIT 1");

            if(cursor.moveToFirst()){
                // output the first row
                String dbCategoryName = cursor.getString(0);
                display.setText(String.format("Random category: %s", dbCategoryName));
            }
        }
        catch(Exception e){
            display.setText(String.format("Error: %s", e.getMessage()));
        }
        finally {
            if(cursor != null)
                cursor.close();

            if(db != null)
                db.close();
        }

    }

    public void onClickAddRule(View view)
    {
//        EditText categoryName = null;
        TextView display = null;
        Cursor cursor = null;
        SQLiteDatabase db = null;

        try
        {
            /*categoryName = (EditText) findViewById(R.id.editTextCategoryName);
            String text = categoryName.getText().toString();*/

            display = (TextView)findViewById(R.id.textViewDisplayRule);
            //display.setText(String.format("Thanks for adding category: %s", text));

            SQLiteOpenHelper bomDiaDatabaseHelper = new PSLDatabaseHelper(this);
            db = bomDiaDatabaseHelper.getReadableDatabase();
            cursor = db.query("Rule", new String[]{"Name"}, null, null, null, null, "RANDOM() LIMIT 1");

            if(cursor.moveToFirst()){
                // output the first row
                String dbRuleName = cursor.getString(0);
                display.setText(String.format("Random rule: %s", dbRuleName));
            }
        }
        catch(Exception e){
            display.setText(String.format("Error: %s", e.getMessage()));
        }
        finally {
            if(cursor != null)
                cursor.close();

            if(db != null)
                db.close();
        }

    }
}
