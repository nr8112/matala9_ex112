package com.example.matala9_ex112;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;

/**
 * @author Noa Rahamim
 * @version 1.0
 * @since 2/1/2021
 *  description:
 *  3 buttons,
 *  one editText to enter an input
 *  and one text view that showing the count and the input
 *  (if the information is saved).
 */
public class MainActivity extends AppCompatActivity {


    String klick;
    /** number of times the Count button is clicked. */
    EditText ed;  /** keeps the user input.*/

    TextView tv;
    int counter;

    /**
     * onCreate...
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed = findViewById(R.id.et);
        tv = findViewById(R.id.tv);

        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);

        /** Checks if this is the first time the program has been run */
        boolean bool = settings.getBoolean("Exit", false);
        if(bool==true){    /** reads the information saved in the last time ,and shows it in the text view */

            String str = settings.getString("klicks", "");
            int count = settings.getInt("counter", -1); //כדאי לבדוק שגיאות הערך של בדיםפולד צריך להיות משוג לכן מינוס 1
            tv.setText("befor"+count);
            ed.setText("" + str);
        }


    }



//------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     *every time the button is clicked -> counter++
     * @param view the view
     */
    public void count(View view) {
        counter++;
        tv.setText(""+counter);
    }

    /**
     * reset the counter to 0.
     * @param view the view
     */
    public void reset(View view) {
        tv.setText("0");
        ed.setText("");
        counter =0;

    }

    /**
     *  Exits the program & saves information.
     * @param view the view
     */
    public void exit(View view) {

        klick= ed.getText().toString();

        SharedPreferences settings=getSharedPreferences("PREFS_NAME",MODE_PRIVATE);
/**
 * applay the editor
 */
        SharedPreferences.Editor editor=settings.edit();
        editor.putBoolean("Exit",true); //boolean
        editor.putInt("counter",counter); //int
        editor.putString("klicks",klick);//string

        editor.commit();

        finish(); //סוגר את האפליקציה
    }



    //-------------------------------------------------------------------------------------------------------------------------
    /**
     * General menu
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    /**
     * gos to cred activity
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String st = item.getTitle().toString();
        if (st.endsWith("Credits")) {
            Intent si = new Intent(this, cred.class);
            startActivity(si);
        }
        return true;
    }

}