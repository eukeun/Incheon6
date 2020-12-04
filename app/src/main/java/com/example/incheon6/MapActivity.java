package com.example.incheon6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class MapActivity extends AppCompatActivity  {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);


        TabHost tab_host = (TabHost) findViewById(R.id.tabhost);
        tab_host.setup();

        TabHost.TabSpec ts1 = tab_host.newTabSpec("tab1");
        ts1.setIndicator("상품");
        ts1.setContent(R.id.tab1);
        tab_host.addTab(ts1);

        TabHost.TabSpec ts2 = tab_host.newTabSpec("tab2");
        ts2.setIndicator("정보");
        ts2.setContent(R.id.tab2);
        tab_host.addTab(ts2);

        TabHost.TabSpec ts3 = tab_host.newTabSpec("tab3");
        ts3.setIndicator("리뷰");
        ts3.setContent(R.id.tab3);
        tab_host.addTab(ts3);

        tab_host.setCurrentTab(0);
    }

}