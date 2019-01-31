package com.hva.joris.madlevel6;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ArrayList<QuoteItem> quoteList = new ArrayList<QuoteItem>();
    private QuoteAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        updateUI();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestData();
            }
        });
    }

    private void updateUI() {
        if (adapter == null) {
            adapter = new QuoteAdapter(quoteList);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.swapList(quoteList);
        }
    }

    private void requestData() {
        NumbersApiService service = NumbersApiService.retrofit.create(NumbersApiService.class);

        Call<QuoteItem> call = service.getRandomQuote();
        call.enqueue(new Callback<QuoteItem>() {

            @Override
            public void onResponse(Call<QuoteItem> call, Response<QuoteItem> response) {
                QuoteItem quoteItem = response.body();
                quoteList.add(quoteItem);
                updateUI();
            }

            @Override
            public void onFailure(Call<QuoteItem> call, Throwable t) {
            }
        });
    }
}
