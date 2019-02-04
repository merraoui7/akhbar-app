package com.zeneo.newsapp.Activities;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ListView;
import com.zeneo.newsapp.Adapter.MainListAdapter;
import com.zeneo.newsapp.Model.WebData;
import com.zeneo.newsapp.Model.WebSites;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    WebData webData = new WebData();
    int [] images = webData.images;

    List<WebSites> list = new ArrayList<>();
    GridView listView;
    MainListAdapter mainListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



        listView = (GridView) findViewById(R.id.mainlist);

        for (int i = 0 ;i<images.length ;i++ ){
            list.add(new WebSites(images[i]));
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
