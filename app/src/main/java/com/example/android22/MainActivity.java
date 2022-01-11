package com.example.android22;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifi = (TextView)findViewById(R.id.a);

        ConnectivityManager CM = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = CM.getActiveNetworkInfo();
        if(info!=null) {
            if(info.getTypeName().equals("WIFI")){
                wifi.setText("wifi");
            }
            else if(info.getTypeName().equals("MOBILE")){
                wifi.setText("基地台");
            }
        }
        else{
            wifi.setText("目前沒有網路");
        }
    }
}