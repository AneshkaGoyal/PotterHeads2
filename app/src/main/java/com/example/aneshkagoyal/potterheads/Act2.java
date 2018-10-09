package com.example.aneshkagoyal.potterheads;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static com.example.aneshkagoyal.potterheads.MainActivity.total;

public class Act2 extends AppCompatActivity {
    int tot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Button b1 = (Button) findViewById(R.id.layout_two);
        Button b2 = (Button) findViewById(R.id.layout_three);
        final Button b3 = (Button) findViewById(R.id.layout_score);
        final RelativeLayout r1 = (RelativeLayout) findViewById(R.id.layoutone);
        final RelativeLayout r2 = (RelativeLayout) findViewById(R.id.layouttwo);
        final RelativeLayout r3 = (RelativeLayout) findViewById(R.id.layoutthree);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //submitAnswers(button);
                r1.setVisibility(View.GONE);
                r2.setVisibility(View.VISIBLE);


            }

        });
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //submitAnswers(button);
                r1.setVisibility(View.GONE);
                r2.setVisibility(View.GONE);
                r3.setVisibility(View.VISIBLE);


            }

        });
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                scoree(b3);
                //r1.setVisibility(View.GONE);
                //r2.setVisibility(View.GONE);
                //r3.setVisibility(View.VISIBLE);


            }

        });
    }

    public void scoree(View view) {


        EditText ans13 = (EditText) findViewById(R.id.ans_1);
        String a = ans13.getText().toString();
        EditText ans14 = (EditText) findViewById(R.id.ans_2);
        String ans_14 = ans14.getText().toString();
        EditText ans15 = (EditText) findViewById(R.id.ans_3);
        String ans_15 = ans15.getText().toString();
        if(a.equals("Bellatrix Lestrange"))
            tot+=10;
        if(ans_14.equals("Kreacher"))
            tot+=10;
        if(ans_15.equals("Nymphadora Tonks"))
            tot+=10;
        print_score(tot);
    }
    public void print_score (int num){

        num += total;
        if(num<90)
        {
            Toast.makeText(this, "TOTAL SCORE IS "+num, Toast.LENGTH_SHORT).show();
        }
        else if(num==90){
            Toast.makeText(this, "Congrats Potter head...Total Score "+num, Toast.LENGTH_SHORT).show();
        }
    }

}

