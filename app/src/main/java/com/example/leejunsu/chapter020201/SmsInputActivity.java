package com.example.leejunsu.chapter020201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SmsInputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_input);

        EditText editText = (EditText) findViewById(R.id.editText);

        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // 텍스트가 변경되기전 입력한 내용에 대해
                // s는 변경할 수 없음
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // 텍스트를 변경된 후 변경 사항과 함께
                // s는 변경할 수 없음

 


                EditText text = (EditText) findViewById(R.id.editText);

                String TextStr = text.getText().toString();

                TextView tV = (TextView) findViewById(R.id.textView01);

                CharSequence ch = tV.getText();
                int nch = ch.length();

                ch = Integer.toString(nch);

                tV.setText(ch);
            }

            @Override
            public void afterTextChanged(Editable s) {
                // 텍스트가 변경된 후. 변경 사항은 알 수 없음
                // s는 변경 가능. 하지만 위 함수들이 다시 콜백됨을 유의
            }

        };

        editText.addTextChangedListener(textWatcher); // EditText인 editText에 textWatcher를 핸들러로 등록


        Button btn = (Button) findViewById(R.id.btnSubmit);
        assert btn != null;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text = (EditText) findViewById(R.id.editText);

                String TextStr = text.getText().toString();
                Toast.makeText(getApplicationContext(), text.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        btn = (Button) findViewById(R.id.btnClose);

        btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Toast.makeText(getApplicationContext(), "닫음...", Toast.LENGTH_LONG).show();
          }
      });
    }
}
