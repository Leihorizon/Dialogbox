package com.example.acer.lsh;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.v7.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = (Button) findViewById(R.id.button4);//提示按钮
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("提示如下").setTitle("提示");
                builder.setNegativeButton(R.string.b5, new DialogInterface.OnClickListener() {
                    @Override//进行方法重载
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);//登录按钮
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.login_dialog,null);//一定要在这个位置定义view否则eT1,eT2将无法用到view的定义
                final EditText editText1 = view.findViewById(R.id.editTextUserId);
                final EditText editText2 = view.findViewById(R.id.editTextPwd);
                builder.setView(view)
                        .setTitle("登录")
                        .setPositiveButton(R.string.b0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                if(editText1.getText().toString().equals("abc")&&editText2.getText().toString().equals("123")){
                                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(MainActivity.this, "用户或密码错误", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.b1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                        });
                builder.show();
            }
        });

    }
}





