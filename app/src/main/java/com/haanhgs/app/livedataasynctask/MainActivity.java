package com.haanhgs.app.livedataasynctask;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.pbrMain1)
    ProgressBar pbrMain1;
    @BindView(R.id.bnStart1)
    Button bnStart1;
    @BindView(R.id.tvResult1)
    TextView tvResult1;
    @BindView(R.id.pbrMain2)
    ProgressBar pbrMain2;
    @BindView(R.id.bnStart2)
    Button bnStart2;
    @BindView(R.id.tvResult2)
    TextView tvResult2;
    @BindView(R.id.pbrMain3)
    ProgressBar pbrMain3;
    @BindView(R.id.bnStart3)
    Button bnStart3;
    @BindView(R.id.tvResult3)
    TextView tvResult3;

    private ThreadViewModel model;
    private static final int max1 = 5000;
    private static final int max2 = 7500;
    private static final int max3 = 10000;

    private void setFullScreen(){
        if (getSupportActionBar() != null) getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    private void initViewModel(){
        model = ViewModelProviders.of(this).get(ThreadViewModel.class);
    }

    private void handleThread1(){
        pbrMain1.setMax(max1);
        model.getProgress1().observe(this, integer -> {
            pbrMain1.setProgress(integer);
            tvResult1.setText(String.valueOf(integer));
        });
        model.getEnable1().observe(this, aBoolean -> bnStart1.setEnabled(aBoolean));
    }

    private void handleThread2(){
        pbrMain2.setMax(max2);
        model.getProgress2().observe(this, integer -> {
            pbrMain2.setProgress(integer);
            tvResult2.setText(String.valueOf(integer));
        });
        model.getEnable2().observe(this, aBoolean -> bnStart2.setEnabled(aBoolean));
    }

    private void handleThread3(){
        pbrMain3.setMax(max3);
        model.getProgress3().observe(this, integer -> {
            pbrMain3.setProgress(integer);
            tvResult3.setText(String.valueOf(integer));
        });
        model.getEnable3().observe(this, aBoolean -> bnStart3.setEnabled(aBoolean));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setFullScreen();
        initViewModel();
        handleThread1();
        handleThread2();
        handleThread3();
    }

    @OnClick({R.id.bnStart1, R.id.bnStart2, R.id.bnStart3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bnStart1:
                model.runTask1(max1);
                break;
            case R.id.bnStart2:
                model.runTask2(max2);
                break;
            case R.id.bnStart3:
                model.runTask3(max3);
                break;
        }
    }
}
