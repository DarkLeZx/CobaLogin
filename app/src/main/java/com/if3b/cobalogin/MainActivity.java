package com.if3b.cobalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView tvSesi, tvName;
private Button btnLogout;

KendaliLogin KL = new KendaliLogin();

public static String keySPusername = "f9m6CsKUTFSfe2JCKHQR==_username";
public static String keySPname = "f9m6CvKUTFSfe2JCKHQR==_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (KL.isLogin(MainActivity.this, keySPusername) == true )
        {
            setContentView(R.layout.activity_main);
            tvSesi = findViewById(R.id.tv_sesi);
            tvName = findViewById(R.id.tv_name);
            btnLogout = findViewById(R.id.btn_logout);

            tvSesi.setText(KL.getPref(MainActivity.this, keySPusername));
            tvName.setText(KL.getPref(MainActivity.this, keySPname));

            btnLogout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    KL.setPref(MainActivity.this, keySPusername, null);
                    KL.setPref(MainActivity.this, keySPname, null);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                }
            });


        }
        else
        {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }

    }
}