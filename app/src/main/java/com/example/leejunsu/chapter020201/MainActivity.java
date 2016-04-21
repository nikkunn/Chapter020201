package com.example.leejunsu.chapter020201;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView01;
    ImageView imageView01;
    BitmapDrawable bitmap;


    ScrollView scrollView02;
    ImageView imageView02;


    BitmapDrawable bitmap2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scrollView01 = (ScrollView) findViewById(R.id.scrollView01);
        imageView01 = (ImageView) findViewById(R.id.imageView01);
        scrollView02 = (ScrollView) findViewById(R.id.scrollView02);
        imageView02 = (ImageView) findViewById(R.id.imageView02);
        Button  button01 = (Button) findViewById(R.id.button01);

        // 가로 스크롤뷰의 메소드 호출
        scrollView01.setHorizontalScrollBarEnabled(true);
        scrollView02.setHorizontalScrollBarEnabled(true);

        // drawable 리소스에 있는 이미지를 가져와서 이미지뷰에 설정하기
        Resources res = getResources();


        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img01);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView01.setImageDrawable(bitmap);
        imageView01.getLayoutParams().width = bitmapWidth;
        imageView01.getLayoutParams().height = bitmapHeight;

        Button btn01 = (Button) findViewById(R.id.button01);
        Button btn02 = (Button) findViewById(R.id.button02);
        Button btn03 = (Button) findViewById(R.id.button03);


        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                upImg();
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downImg();
            }
        });

        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SmsInputActivity.class);
                startActivity(intent);
            }
        });

    }

    private void upImg() {

        if(imageView01.getVisibility() == View.VISIBLE) {

            Toast.makeText(getApplicationContext(), "doesn't exist down image", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_LONG).show();

            Resources res = getResources();

            bitmap = (BitmapDrawable) imageView02.getDrawable();
            int bitmapWidth = bitmap.getIntrinsicWidth();
            int bitmapHeight = bitmap.getIntrinsicHeight();

            imageView01.setImageDrawable(bitmap);
            imageView01.getLayoutParams().width = bitmapWidth;
            imageView01.getLayoutParams().height = bitmapHeight;

            imageView02.setVisibility(View.INVISIBLE);

        }
/*


        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img01);
        int bitmapWidth2 = bitmap.getIntrinsicWidth();
        int bitmapHeight2 = bitmap.getIntrinsicHeight();

        imageView02.setImageDrawable(bitmap);
        imageView02.getLayoutParams().width = bitmapWidth2;
        imageView02.getLayoutParams().height = bitmapHeight2;
*/

    }

    private void downImg(){

        if(imageView02.getVisibility() == View.VISIBLE) {
            Toast.makeText(getApplicationContext(), "Down", Toast.LENGTH_LONG).show();

            Resources res = getResources();


            bitmap = (BitmapDrawable) imageView01.getDrawable();
            int bitmapWidth2 = bitmap.getIntrinsicWidth();
            int bitmapHeight2 = bitmap.getIntrinsicHeight();

            imageView02.setImageDrawable(bitmap);
            imageView02.getLayoutParams().width = bitmapWidth2;
            imageView02.getLayoutParams().height = bitmapHeight2; 

            imageView01.setVisibility(View.INVISIBLE);


        } else {

            Toast.makeText(getApplicationContext(), "Doesn't exist Up image", Toast.LENGTH_LONG).show();
        }
/*
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.img02);
        int bitmapWidth = bitmap.getIntrinsicWidth();
        int bitmapHeight = bitmap.getIntrinsicHeight();

        imageView01.setImageDrawable(bitmap);
        imageView01.getLayoutParams().width = bitmapWidth;
        imageView01.getLayoutParams().height = bitmapHeight;*/
    }

}
