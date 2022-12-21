package com.example.hw_3_1_;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText ed_email,ed_sub,editText;
Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_email = findViewById(R.id.edemail);
        ed_sub = findViewById(R.id.edsubject);
        editText = findViewById(R.id.edtext);
        button = findViewById(R.id.botton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subject=ed_sub.getText().toString();
                String message=editText.getText().toString();
                String emaile=ed_email.getText().toString();





                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, emaile );
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"Choose an Email client :"));
            }
        });


    }
}