package com.example.beatboxer.recycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView numberlist;
    private NumbersAdapter numbersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberlist=findViewById(R.id.rv_numbers);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        numberlist.setLayoutManager(layoutManager);
        numberlist.setHasFixedSize(true);

        numbersAdapter = new NumbersAdapter(100,this);
        numberlist.setAdapter(numbersAdapter);



    }
}
