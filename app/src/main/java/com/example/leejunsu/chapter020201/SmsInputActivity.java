package com.example.leejunsu.chapter020201;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
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

        final EditText editText = (EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                Toast.makeText(getApplicationContext(), "[" + s.length() + "]", Toast.LENGTH_LONG).show();
                if(s.length() > 80) {
                    InputFilter[] filtArry = new InputFilter[1];
                    filtArry[0] = new InputFilter.LengthFilter(80);

                    editText.setFilters(filtArry);
                } else {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });






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
