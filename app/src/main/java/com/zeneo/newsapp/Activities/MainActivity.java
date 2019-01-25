package com.zeneo.newsapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.zeneo.newsapp.Adapter.MainListAdapter;
import com.zeneo.newsapp.Model.WebData;
import com.zeneo.newsapp.Model.WebSites;
import com.zeneo.newsapp.Activities.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    WebData webData = new WebData();
    String [] names =webData.names;
    int [] images =webData.images;

    List<WebSites> list = new ArrayList<>();
    ListView listView;
    MainListAdapter mainListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.mainlist);

        for (int i = 0 ;i<images.length ;i++ ){
            list.add(new WebSites(names[i],images[i]));
        }
        mainListAdapter = new MainListAdapter(getApplicationContext(),list);
        listView.setAdapter(mainListAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),NewsActivity.class);
                intent.putExtra("index",String.valueOf(i));
                startActivity(intent);
            }
        });




    }
}
