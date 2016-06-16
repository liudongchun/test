package ldc.zzptc.com.work1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //定义一个标志
        sp = getSharedPreferences("config", MODE_PRIVATE);
        Boolean b = sp.getBoolean("frist", true);

        if (b==true) {
            new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    Intent intent = new Intent(MainActivity.this, GuideActivity.class);
                    startActivity(intent);
                }
            }.sendEmptyMessage(3000);
           sp.edit().putBoolean("frist",false).commit();//进入一次之后就改变其属性值，第二次进入的时候就不会进了
            }else{
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    startActivity(intent);

        }

    }
}
