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

    private int max = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressBar pbrMain = findViewById(R.id.pbrMain);
        final Button bnStart = findViewById(R.id.bnStart);
        final TextView tvResult = findViewById(R.id.tvResult);

        final Model model = ViewModelProviders.of(this).get(Model.class );
        model.setMax(3000);
        model.getProgress().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain.setProgress(integer);
                tvResult.setText(String.valueOf(integer));
            }
        });
        model.getMax().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                pbrMain.setMax(integer);
            }
        });

        model.getEnable().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                bnStart.setEnabled(aBoolean);
            }
        });

        bnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.runTask(max);
            }
        });
    }


}
