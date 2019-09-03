package com.example.demotable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

Button button;
EditText et1,et2,et3;
RatingBar ratingBar;
Float ratingNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        button=findViewById(R.id.button);
        ratingBar=findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //Rating is store in ratingNumber using getRating()
                Float ratingNumber = ratingBar.getRating();
                Toast.makeText(MainActivity.this, ""+ratingNumber, Toast.LENGTH_SHORT).show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= String.valueOf(et1.getText());
                String s2= String.valueOf(et2.getText());
                String s3= String.valueOf(et3.getText());

                Float ratingNumber = ratingBar.getRating();

                //Condition to check if any field is empty
                if( !isEmpty(s1) && !isEmpty(s2) && !isEmpty(s3) && ratingNumber!=0)
                {
                    Intent intent = new Intent(MainActivity.this, Submit.class);

                    //Send data to other activity putExtra() is used
                    intent.putExtra("","\nMovie: "+s3+"\nRating: "+ratingNumber+"\nBy: "+s1+" "+s2);
                    startActivity(intent);

                }else
                    {
                    Toast.makeText(MainActivity.this, "Field cannot be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
