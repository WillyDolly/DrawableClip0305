package com.thanhtam.drawableclip0305;

import android.graphics.drawable.ClipDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgClip;
    Button btnClip;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgClip = (ImageView)findViewById(R.id.imageViewHinh);
        btnClip = (Button)findViewById(R.id.buttonClip);

        final ClipDrawable clipDrawable = (ClipDrawable) imgClip.getDrawable(); // Khai báo clipDrawable và lấy trong imgClip

        clipDrawable.setLevel(1000); // Gán số phần mỗi lần click tối đa 10000

        btnClip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final CountDownTimer countDownTimer = new CountDownTimer(10000,500) {//Gán thời gian (Tổng thời gian chạy, Thời gian chạy)
                    @Override                                       //Milisecond
                    public void onTick(long millisUntilFinished) {
                        clipDrawable.setLevel((clipDrawable.getLevel())%10000 +1000);   //
                    }

                    @Override
                    public void onFinish() {
                        this.start();
                        //Toast.makeText(MainActivity.this,"Finish",Toast.LENGTH_SHORT).show();
                    }
                }.start();




            }
        });
    }
}
