package com.example.mahmood.a087;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Object> objectList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Text text1 = new Text();
        text1.setText("Mahmood");

        Text text2 = new Text();
        text2.setText("Javad");

        Text text3 = new Text();
        text3.setText("Hamed");

        Image image1 = new Image();
        image1.setImage(R.mipmap.iran);

        Image image2 = new Image();
        image2.setImage(R.mipmap.canada);

        objectList.add(text1);
        objectList.add(image1);
        objectList.add(text2);
        objectList.add(text3);
        objectList.add(image2);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ObjectAdapter(objectList);
        recyclerView.setAdapter(adapter);
    }
}
