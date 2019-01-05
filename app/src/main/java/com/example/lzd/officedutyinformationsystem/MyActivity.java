package com.example.lzd.officedutyinformationsystem;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {
    private EditText edtSex;
    private EditText edtNumber;
    private EditText edtAge;
    private EditText edtGrade;
    private EditText edtName;
    private Button btnRegister2;
    private LinearLayout ChatlinearLayout;
    private LinearLayout MianlinearLayout;
    private LinearLayout mylinearLayout;
    private ImageView ivHead;
    private TextView textView;
    private Button btnQuery;
    private TextView tvShow;

    private MyDbHelper dbHelper;
    private SQLiteDatabase db;
    private final int CAMERA_REQUEST = 8888;
    Cursor cursor;
    SimpleCursorAdapter cursorAdapter;
    TextView tv_name,tv_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        dbHelper = new MyDbHelper(this, "information.db", null, 1);



        edtSex = (EditText) findViewById(R.id.edt_sex);
        edtNumber = (EditText) findViewById(R.id.edt_number);
        edtAge = (EditText) findViewById(R.id.edt_age);
        edtGrade = (EditText) findViewById(R.id.edt_grade);
        edtName = (EditText) findViewById(R.id.edt_name);
        btnRegister2 = (Button) findViewById(R.id.btn_register2);
        ChatlinearLayout = (LinearLayout) findViewById(R.id.ChatlinearLayout);
        MianlinearLayout = (LinearLayout) findViewById(R.id.MianlinearLayout);
        mylinearLayout = (LinearLayout) findViewById(R.id.mylinearLayout);
        ivHead = (ImageView) findViewById(R.id.iv_head);
        textView = (TextView) findViewById(R.id.textView);
        btnQuery = (Button) findViewById(R.id.btn_query);
        tvShow = (TextView) findViewById(R.id.tv_show);

        btnRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = dbHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", edtName.getText().toString());
                values.put("age", edtAge.getText().toString());
                values.put("grade", edtGrade.getText().toString());
                values.put("number", edtNumber.getText().toString());
                values.put("sex", edtSex.getText().toString());
                db.insert("information", null, values);
                Toast.makeText(MyActivity.this, "信息修改成功！", Toast.LENGTH_SHORT).show();
                values.clear();



            }
        });
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserTable userTable = new UserTable();
                String Name = edtName.getText().toString();
                //String Password = edtPassword.getText().toString();
                db = dbHelper.getWritableDatabase();
                Cursor cursor = db.rawQuery("select * from information where name=?", new String[]{Name});
                if (cursor.moveToFirst()) {
                    userTable.setName(cursor.getString(cursor.getColumnIndex("name")));
                    userTable.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                    userTable.setAge(cursor.getString(cursor.getColumnIndex("age")));
                    userTable.setGrade(cursor.getString(cursor.getColumnIndex("grade")));
                    userTable.setSex(cursor.getString(cursor.getColumnIndex("sex")));
                    userTable.setNumber(cursor.getString(cursor.getColumnIndex("number")));
                    tvShow.setText("用户名："+userTable.getName()+"性别:"+userTable.getSex());
                    Log.i("MyUserTable", userTable.toString());


                }
                Toast.makeText(MyActivity.this,"查询成功",Toast.LENGTH_SHORT).show();
                cursor.close();

            }
        });



        ivHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivHead.setImageBitmap(photo);
        }
    }
}
