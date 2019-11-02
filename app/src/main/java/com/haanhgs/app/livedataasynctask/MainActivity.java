package com.haanhgs.app.livedataasynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ThreadModel model;
    private int max1 = 5000;
    private int max2 = 9000;
    private int max3 = 10000;

    private ProgressBar pbrMain1;
    private ProgressBar pbrMain2;
    private ProgressBar pbrMain3;
    private TextView tvResult1;
    private TextView tvResult2;
    private TextView tvResult3;
    private Button bnStart1;
    private Button bnStart2;
    private Button bnStart3;

    private void initViews(){
        pbrMain1 = findViewById(R.id.pbrMain1);
        pbrMain2 = findViewById(R.id.pbrMain2);
        pbrMain3 = findViewById(R.id.pbrMain3);
        bnStart1 = findViewById(R.id.bnStart1);
        bnStart2 = findViewById(R.id.bnStart2);
        bnStart3 = findViewById(R.id.bnStart3);
        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);

        model = ViewModelProviders.of(this).get(ThreadModel.class );
        model.setMax1(max1);
        model.setMax2(max2);
        model.setMax3(max3);
    }

    private void handleProgressBar1(){
        model.getProgress1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain1.setProgress(integer);
                tvResult1.setText(String.valueOf(integer));
            }
        });

        model.getMax1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain1.setMax(integer);
            }
        });
    }

    private void handleProgressBar2(){
        model.getProgress2().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain2.setProgress(integer);
                tvResult2.setText(String.valueOf(integer));
            }
        });

        model.getMax2().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain2.setMax(integer);
            }
        });
    }

    private void handleProgressBar3(){
        model.getProgress3().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain3.setProgress(integer);
                tvResult3.setText(String.valueOf(integer));
            }
        });

        model.getMax3().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain3.setMax(integer);
            }
        });
    }

    private void handleButton1(){
        model.getEnable1().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                bnStart1.setEnabled(aBoolean);
            }
        });

        bnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.runTask1(max1);
            }
        });
    }

    private void handleButton2(){
        model.getEnable2().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                bnStart2.setEnabled(aBoolean);
            }
        });

        bnStart2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.runTask2(max2);
            }
        });
    }

    private void handleButton3(){
        model.getEnable3().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                bnStart3.setEnabled(aBoolean);
            }
        });

        bnStart3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.runTask3(max3);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        handleProgressBar1();
        handleButton1();
        handleProgressBar2();
        handleButton2();
        handleProgressBar3();
        handleButton3();
    }
}
