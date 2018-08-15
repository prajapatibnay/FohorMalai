package org.example.fohormalai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.example.fohormalai.Models.Home;
import org.example.fohormalai.utils.ItemOffsetDecoration;

public class MainActivity_after_sign_in extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_sign_in);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this, Home.getHomeList(), new RecyclerViewAdapter.ItemListener() {
            @Override
            public void onItemClick(Home item) {
                Log.i("MainActivity"," home "+item.getName());

                if(item.getName().equalsIgnoreCase("My schedule")){
                    Intent in=new Intent(MainActivity_after_sign_in.this,ScheduleActivity.class);
                    startActivity(in);

                }
                if(item.getName().equalsIgnoreCase("Notification")){

                }

                if(item.getName().equalsIgnoreCase("Notices")){

                }

                if(item.getName().equalsIgnoreCase("About us")){

                }

                if(item.getName().equalsIgnoreCase("Search")){

                }

                if(item.getName().equalsIgnoreCase("Better Recycler")){

                }
            }
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(mAdapter);
        Log.i("MainSecondActiviy","inside onCreate");


    }
}

