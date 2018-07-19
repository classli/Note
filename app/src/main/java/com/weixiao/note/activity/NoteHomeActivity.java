package com.weixiao.note.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.weixiao.note.R;
import com.weixiao.note.adapter.GridItemDecoration;
import com.weixiao.note.adapter.HomeAdapter;
import com.weixiao.note.model.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weixiao on 18/7/18.
 */

public class NoteHomeActivity extends AppCompatActivity {
    private final static String TAG = "NoteHomeActivity";
    private int SPAN_COUNT = 3;
    private int DIVIDER_WIDTH = 10;

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private HomeAdapter adapter;
    private List<Note> dataSource;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.list_view);
    }

    private void initData() {
        dataSource = new ArrayList<Note>();
        for (int i = 0; i < 30; i++) {
            Note note = new Note();
            dataSource.add(note);
        }
        adapter = new HomeAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        GridItemDecoration decoration = new GridItemDecoration(this, SPAN_COUNT, DIVIDER_WIDTH);
        recyclerView.addItemDecoration(decoration);
        adapter.refreshAllData(dataSource);
    }
}
