package com.example.flagsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Quiz2 extends AppCompatActivity {

        RadioGroup rg;
        RadioButton rb;
        Button bNext;



        String RepCorrect="  Egypt";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz2);
            rg=(RadioGroup) findViewById(R.id.rg);
            bNext=(Button) findViewById(R.id.NEXT);
            Intent intent=getIntent();
            Quiz.score=intent.getIntExtra("score",0) ;
            bNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    rb=(RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    if(rg.getCheckedRadioButtonId()==-1){
                        Toast.makeText(getApplicationContext(),"Choose an option please !",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(rb.getText().toString().equals(RepCorrect)){
                            Quiz.score+=1;
                        }
                        Intent intent=new Intent(Quiz2.this,Quiz3.class);
                        intent.putExtra("score",Quiz.score);
                        startActivity(intent);
                        overridePendingTransition(R.anim.exit,R.anim.entry);
                        finish();
                    }

                }
            });

        }

    }
