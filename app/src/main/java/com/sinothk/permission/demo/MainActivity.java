package com.sinothk.permission.demo;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sinothk.permission.PermissionManager;
import com.sinothk.permission.PermissionResultListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestSms();
            }
        });
    }

    String[] permissions = {Manifest.permission.READ_SMS, Manifest.permission.CALL_PHONE};

    private void requestSms() {
        if (PermissionManager.haveAllPermission(this, permissions)) {

            Toast.makeText(this, "读取消息", Toast.LENGTH_LONG).show();

        } else {
            PermissionManager.requestAllPermission(this, new PermissionResultListener() {
                @Override
                public void permissionSuccess(String[] permission) {
                    Toast.makeText(MainActivity.this, "用户授予读取消息权限", Toast.LENGTH_LONG).show();
                }

                @Override
                public void permissionFail(String[] permission) {
                    Toast.makeText(MainActivity.this, "用户拒绝了读取消息权限", Toast.LENGTH_LONG).show();
                }
            }, permissions, false, null);
        }
    }
}
