package com.example.matala9_ex112;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

/**
 * @author Noa Rahamim
 *  @version 1.0
 *  @since 2/1/2021
 *  credits....
 */
public class cred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cred);
    }
    public void go(View view) {
        finish();
    }
}