package com.example.lzd.officedutyinformationsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView textView4;
    private LinearLayout ChatlinearLayout;
    private ImageView imageView2;
    private TextView textView7;
    private LinearLayout MianlinearLayout;
    private ImageView imageView3;
    private TextView textView6;
    private LinearLayout mylinearLayout;
    private ImageView imageView;
    private TextView textView5;
    private LinearLayout linearLayout;
    private Button btnSchedule,btn_luru;
    private Button btnAttention;
    private Button btnArrangement;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        textView4 = (TextView) findViewById(R.id.textView4);
        ChatlinearLayout = (LinearLayout) findViewById(R.id.ChatlinearLayout);

        MianlinearLayout = (LinearLayout) findViewById(R.id.MianlinearLayout);
        mylinearLayout = (LinearLayout) findViewById(R.id.mylinearLayout);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        btnSchedule = (Button) findViewById(R.id.btn_schedule);
        btnAttention = (Button) findViewById(R.id.btn_attention);
        btn_luru = (Button) findViewById(R.id.btn_luru);
        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent=new Intent(Main2Activity.this,TableActivity.class);
                startActivity(intent);
            }
        });
        btnAttention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent2=new Intent(Main2Activity.this,AttentionActivity.class);
                startActivity(intent2);
            }
        });

        btn_luru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick( View v ) {
                Intent intent7=new Intent(Main2Activity.this,MyActivity.class);
                startActivity(intent7);
            }
        });



    }
}
