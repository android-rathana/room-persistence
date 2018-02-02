package com.example.ratha.roomdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCategoryActivity extends AppCompatActivity {

    private EditText dtTitle;
    private EditText dtDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        dtTitle=findViewById(R.id.title);
        dtDesc=findViewById(R.id.description);
    }

    public void onSave(View view) {
        Intent intent=new Intent();
        intent.putExtra("title",dtTitle.getText().toString());
        intent.putExtra("description",dtDesc.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}
