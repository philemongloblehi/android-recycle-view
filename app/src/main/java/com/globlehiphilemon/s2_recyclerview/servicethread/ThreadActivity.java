package com.globlehiphilemon.s2_recyclerview.servicethread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.globlehiphilemon.s2_recyclerview.R;

public class ThreadActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btnGoThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        imageView = findViewById(R.id.img_thread);
        btnGoThread = findViewById(R.id.btn_go_thread);
    }
}
