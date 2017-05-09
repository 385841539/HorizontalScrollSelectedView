package com.example.horizontalscrollselectedview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.horizontalselectedviewlibrary.HorizontalselectedView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View leftImageView;
    private View rightImageView;
    private HorizontalselectedView hsMain;
    private Button btMain;
    List<String> strings = new ArrayList<String>();
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initdata();
    }

    private void initdata() {

        for (int i = 0; i < 20; i++) {
            strings.add(i + "00");
        }
        hsMain.setData(strings);
    }

    private void initView() {
        hsMain = (HorizontalselectedView) findViewById(R.id.hd_main);
        leftImageView = findViewById(R.id.iv_left);
        rightImageView = findViewById(R.id.iv_right);
        btMain = ((Button) findViewById(R.id.bt_main));
        tvMain = ((TextView) findViewById(R.id.tv_main));


        leftImageView.setOnClickListener(this);
        rightImageView.setOnClickListener(this);
        btMain.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_left:
                hsMain.setAnLeftOffset();
                break;
            case R.id.iv_right:
                hsMain.setAnRightOffset();
                break;
            case R.id.bt_main:

                tvMain.setText("所选文本：" + hsMain.getSelectedString());

                break;
            default:
                break;
        }
    }
}
