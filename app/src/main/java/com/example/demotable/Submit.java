package com.example.demotable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Submit extends AppCompatActivity {
Button button1;
TextView tv1;
Intent in;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        button1=findViewById(R.id.button2);
        tv1=findViewById(R.id.textView3);
        //Accept Intent using getIntent()
        in=getIntent();
        String s1=in.getStringExtra("");
        tv1.setText(s1);
        button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(Submit.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
