package com.tutorials.hp.recyclerswipetofrag;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.tutorials.hp.recyclerswipetofrag.mData.SpaceCraftsCollection;
import com.tutorials.hp.recyclerswipetofrag.mRecycler.MyAdapter;
import com.tutorials.hp.recyclerswipetofrag.mSwiper.SwipeHelper;


public class MainActivity extends AppCompatActivity {

    MyAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        RecyclerView rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());


        adapter=new MyAdapter(this, SpaceCraftsCollection.getSpaceCrafts(),this.getSupportFragmentManager());
        rv.setAdapter(adapter);

        ItemTouchHelper.Callback callback=new SwipeHelper(adapter);
        ItemTouchHelper helper=new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rv);
    }


}
