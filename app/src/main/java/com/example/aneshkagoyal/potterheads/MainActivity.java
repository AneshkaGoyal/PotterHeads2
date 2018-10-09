package com.example.aneshkagoyal.potterheads;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    public static int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;

        button = (Button) findViewById(R.id.submit_area);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                submitAnswers(button);
                if (total > 30) {

                    Intent intent = new Intent(context, Act2.class);
                    startActivity(intent);


                }
            }

        });


    }
    private int numberOfChildren =1;
    public void increment(View view){
        if(numberOfChildren>=10)
        {
            Context context = getApplicationContext();
            CharSequence text = "You can't go above 10";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;

        }
        numberOfChildren++;
        display(numberOfChildren);
    }
    public void decrement(View view){
        if(numberOfChildren<=1)
        {
            Context context = getApplicationContext();
            CharSequence text = "You can't go below one";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }
        numberOfChildren--;
        display(numberOfChildren);
    }




    private void display(int number) {
        TextView children = (TextView) findViewById(R.id.ans_three);
        children.setText("" + number);
    }
    public void submitAnswers(View view){
        EditText text_ans1 = (EditText)findViewById(R.id.ans_one);
        String ans1 = text_ans1.getText().toString();

        CheckBox check = (CheckBox)findViewById(R.id.check);
        boolean isChecked = check.isChecked();
        CheckBox check1 = (CheckBox)findViewById(R.id.check1);
        boolean isChecked1 = check1.isChecked();
        CheckBox check2 = (CheckBox)findViewById(R.id.check2);
        boolean isChecked2 = check2.isChecked();
        CheckBox check3 = (CheckBox)findViewById(R.id.check3);
        boolean isChecked3 = check3.isChecked();
        boolean isAns_4Correct = checkAns4(isChecked,isChecked1,isChecked2,isChecked3);
        EditText text_ans2 = (EditText)findViewById(R.id.ans_two);
        String ans2 = text_ans2.getText().toString();
        RadioButton hagrid = (RadioButton) findViewById(R.id.opt);
        boolean ans5 = hagrid.isChecked();
        //RadioButton
        RadioButton eleven = (RadioButton) findViewById(R.id.option1);
        boolean ans6 = eleven.isChecked();

         total = cal(ans1,ans2,numberOfChildren,isAns_4Correct,ans5,ans6);
        print_score(total);


    }


    public int cal(String a1,String a2,int a3,boolean a4,boolean a5,boolean a6){
        int tot = 0;

        if(a1.equals("Fluffy"))
            tot+=10;
        if(a2.equals("Tom Morvolo Riddle"))
            tot+=10;
        if(a3 == 7)
            tot+=10;
        if(a4==true)
            tot+=10;
        if(a5 == true)
            tot+=10;

        if(a6)
            tot+=10;
        return tot;
    }

    public void print_score (int num){
        if(num<60)
        {
            Toast.makeText(this, "LEVEL ONE SCORE IS "+num, Toast.LENGTH_SHORT).show();
        }
        else if(num==60){
            Toast.makeText(this, "Congrats Level One PotterHead...Score "+num, Toast.LENGTH_SHORT).show();
        }
    }
    public boolean checkAns4(boolean ck,boolean ck1,boolean ck2,boolean ck3){
        if(ck== false && ck1== false && ck2 == true && ck3==true )
            return true;
        return false;
    }
    public int gettot() {
        return total;
    }

}
