package com.lee.greendao;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.lee.greendao.adapter.ExampleAdapter;
import com.lee.greendao.db.dao.DBService;
import com.lee.greendao.db.model.User;
import com.lee.greendao.itemdeco.DividerItemDecoration;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mExampleRv;

    private ExampleAdapter mAdapter;

    private DBService mDbService;

    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDbService = DBService.getInstance(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addUser(view);
            }
        });

        mExampleRv = (RecyclerView) findViewById(R.id.exampleRv);
        mExampleRv.setLayoutManager(new LinearLayoutManager(this));
        mExampleRv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        getData();
    }

    private void getData() {
        users = mDbService.loadAllUsers();
        if (users != null) {
            mAdapter = new ExampleAdapter(this, users);
            mExampleRv.setAdapter(mAdapter);
        }
    }

    private void addUser(View view) {
        User user = new User();
        user.setUserId(System.currentTimeMillis() + "");
        user.setName("Leee");
        user.setAge("21");
        user.setIdentity(System.currentTimeMillis() + "");
        user.setDate(System.currentTimeMillis() + "");
        user.setLocation("北京");
        long id = mDbService.insertOrReplaceUser(user);
        if (id != 0) {
            Snackbar.make(view, "添加成功 id : " + id, Snackbar.LENGTH_LONG).show();
            mAdapter.addMore(user);
        }
    }
}
