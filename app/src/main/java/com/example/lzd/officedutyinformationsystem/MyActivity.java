package com.example.lzd.officedutyinformationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyActivity extends AppCompatActivity {
    private EditText edtSex;
    private EditText edtNumber;
    private EditText edtAge;
    private EditText edtGrade;
    private EditText edtName;
    private Button button;
    private LinearLayout ChatlinearLayout;
    private ImageView imageView2;
    private TextView textView7;
    private LinearLayout MianlinearLayout;
    private ImageView imageView3;
    private TextView textView6;
    private LinearLayout mylinearLayout;
    private ImageView imageView;
    private TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        edtSex = (EditText) findViewById(R.id.edt_sex);
        edtNumber = (EditText) findViewById(R.id.edt_number);
        edtAge = (EditText) findViewById(R.id.edt_age);
        edtGrade = (EditText) findViewById(R.id.edt_grade);
        edtName = (EditText) findViewById(R.id.edt_name);
        button = (Button) findViewById(R.id.button);
        ChatlinearLayout = (LinearLayout) findViewById(R.id.ChatlinearLayout);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView7 = (TextView) findViewById(R.id.textView7);
        MianlinearLayout = (LinearLayout) findViewById(R.id.MianlinearLayout);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        textView6 = (TextView) findViewById(R.id.textView6);
        mylinearLayout = (LinearLayout) findViewById(R.id.mylinearLayout);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView5 = (TextView) findViewById(R.id.textView5);
        MianlinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent=new Intent(MyActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

    }
}
