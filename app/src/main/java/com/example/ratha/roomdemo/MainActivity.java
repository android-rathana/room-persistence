package com.example.ratha.roomdemo;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ratha.roomdemo.adapter.CategoryAdapter;
import com.example.ratha.roomdemo.data.database.AppDatabase;
import com.example.ratha.roomdemo.entity.Category;
import com.example.ratha.roomdemo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE =1;
    private static final String TAG = "MainActivity";
    private AppDatabase db;

    private RecyclerView rvCategory;
    private List<Category> categories;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=AppDatabase.getInstance(this);

        rvCategory=findViewById(R.id.rv_category);
        categories=new ArrayList<>();
        categoryAdapter=new CategoryAdapter(this,categories);
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        rvCategory.setAdapter(categoryAdapter);

        //addUser();
        //getUsers();
        getAllCategory();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.create_new_category:
                startActivityForResult(new Intent(this,AddCategoryActivity.class),REQUEST_CODE);
                return true;
        }
        return false;
    }

    public void getAllCategory(){
        categories.addAll(db.categoryDao().getAll());
        categoryAdapter.notifyDataSetChanged();
    }
    private void getUsers() {
        List<User> users=db.userDao().getAll();
        for(User u : users){
            Log.e(TAG, "getUsers: "+u.toString());
        }
    }

    private void addUser() {
        User user =new User();
        user.name="rathana";
        user.password="rathana12345";
        user.email="rathana@gmail.com";
        try{
            db.userDao().add(user);
            Toast.makeText(this, "create success", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "have an error", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE && resultCode==RESULT_OK){
            Category category=new Category();
            category.name=data.getStringExtra("title");
            category.desc=data.getStringExtra("description");
            addCategory(category);
        }
    }

    private void addCategory(Category category) {
        if(category!=null)
            db.categoryDao().add(category);

        this.categories.add(0,category);
        this.categoryAdapter.notifyItemInserted(0);
        scrollRecyclerViewToTop();
    }

    public void scrollRecyclerViewToTop(){
        this.rvCategory.scrollToPosition(0);
    }
}
