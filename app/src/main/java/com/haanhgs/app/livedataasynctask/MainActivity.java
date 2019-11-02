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

    private  Model model;

    private int max1 = 5000;
    private ProgressBar pbrMain1;
    private TextView tvResult1;
    private Button bnStart1;

    private void initViews(){
        pbrMain1 = findViewById(R.id.pbrMain1);
        bnStart1 = findViewById(R.id.bnStart1);
        tvResult1 = findViewById(R.id.tvResult1);
        model = ViewModelProviders.of(this).get(Model.class );
        model.setMax1(max1);
    }

    private void handleProgressBar(){
        model.getProgress1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain1.setProgress(integer);
                tvResult1.setText(String.valueOf(integer));
            }
        });
    }

    private void handleTextView(){
        model.getMax1().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain1.setMax(integer);
            }
        });
    }

    private void handleButton(){
        model.getEnable1().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                bnStart1.setEnabled(aBoolean);
            }
        });

        bnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.runTask(max1);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        handleProgressBar();
        handleTextView();
        handleButton();
    }


}
