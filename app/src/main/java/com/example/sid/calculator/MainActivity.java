package com.example.sid.calculator;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;

import com.example.sid.calculator.databinding.ActivityMainBinding;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ArrayList<History> histories = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        decimalFormat=new DecimalFormat("");
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);


        //binding.editText.setSelected(true);
        binding.buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dotFlag==false){
                dotFlag=true;
                binding.editText.setText(binding.editText.getText()+".");
                binding.infoTextView.setText(binding.infoTextView.getText()+".");
                check(".");}

            }
        });
        binding.buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"1");
                binding.infoTextView.setText(binding.infoTextView.getText()+"1");
                check("1");
            }
        });
        binding.buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"2");
                binding.infoTextView.setText(binding.infoTextView.getText()+"2");
                check("2");
            }
        });
        binding.buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"3");
                binding.infoTextView.setText(binding.infoTextView.getText()+"3");
                check("3");
            }
        });
        binding.buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"4");
                binding.infoTextView.setText(binding.infoTextView.getText()+"4");
                check("4");

            }
        });
        binding.buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"5");
                binding.infoTextView.setText(binding.infoTextView.getText()+"5");
                check("5");

            }
        });
        binding.buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"6");
                binding.infoTextView.setText(binding.infoTextView.getText()+"6");
                check("6");

            }
        });
        binding.buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"7");
                binding.infoTextView.setText(binding.infoTextView.getText()+"7");
                check("7");

            }
        });
        binding.buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"8");
                binding.infoTextView.setText(binding.infoTextView.getText()+"8");
                check("8");

            }
        });
        binding.buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"9");
                binding.infoTextView.setText(binding.infoTextView.getText()+"9");
                check("9");



            }
        });
        binding.buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(binding.editText.getText()+"0");
                binding.infoTextView.setText(binding.infoTextView.getText()+"0");
                check("0");

            }
        });
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(!binding.infoTextView.getText().toString().equals("")&& !binding.editText.getText().toString().endsWith("+"))
                    {

                    binding.editText.setText(binding.editText.getText() + "+");
                    valueOne = Double.parseDouble(binding.infoTextView.getText().toString());
                    dotFlag = false;
                    valueTwo = new StringBuilder();
                    //computeCalculation();
                    CURRENT_ACTION = ADDITION;
                }}
                catch(Exception e){}
                //binding.editText.setText(null);
            }
        });

        binding.buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{

                    if(binding.infoTextView.getText().toString().equals("")&& !binding.editText.getText().toString().endsWith("-"))
                    {
                        subtractFlag=true;
                     binding.infoTextView.setText("-");
                     binding.editText.setText("-");
                    }
                else if(!binding.editText.getText().toString().endsWith("-")){

                        binding.editText.setText(binding.editText.getText() + "-");
                valueOne=Double.parseDouble(binding.infoTextView.getText().toString());
                dotFlag=false;
                valueTwo=new StringBuilder();
                //computeCalculation();
                CURRENT_ACTION = SUBTRACTION;}}
                catch(Exception e){}
            }
        });

        binding.buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(!binding.infoTextView.getText().toString().equals("") && !binding.editText.getText().toString().endsWith("*"))
                    {
                        binding.editText.setText(binding.editText.getText() + "*");
                    valueOne = Double.parseDouble(binding.infoTextView.getText().toString());
                    dotFlag = false;
                    valueTwo = new StringBuilder();
                    //computeCalculation();
                    CURRENT_ACTION = MULTIPLICATION;
                }}
                catch(Exception e){

                }
            }
        });

        binding.buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if(!binding.infoTextView.getText().toString().equals("") && !binding.editText.getText().toString().endsWith("/"))
                    {
                        binding.editText.setText(binding.editText.getText() + "/");
                    valueOne = Double.parseDouble(binding.infoTextView.getText().toString());
                    dotFlag = false;
                    valueTwo = new StringBuilder();
                    //computeCalculation();
                    CURRENT_ACTION = DIVISION;}
                }
                catch (Exception e){}
            }
        });
        binding.history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j=new Intent(MainActivity.this,History_Activty.class);
                j.putExtra("History",histories);
                startActivity(j);

                histories.clear();
                binding.editText.setText("");
                binding.infoTextView.setText("");
            }
        });

        binding.buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtractFlag=false;
                History history = new History();
                history.setExpression(binding.editText.getText().toString());
                history.setValue(valueOne1);
                histories.add(history);
                binding.editText.setText(binding.infoTextView.getText());
                //binding.infoTextView.setText(null);


                CURRENT_ACTION = '.';

            }
        });
        binding.buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.editText.setText(null);
                binding.infoTextView.setText(null);
                valueOne=Double.NaN;
                subtractFlag=false;
                dotFlag=false;
                CURRENT_ACTION = '.';

            }
        });



    }
    private void computeCalculation(){

            //binding.editText.setText(null);
            valueTwo1=Double.parseDouble(valueTwo.toString());
            if(CURRENT_ACTION == ADDITION)
                valueOne1 = this.valueOne + valueTwo1;
            else if(CURRENT_ACTION == SUBTRACTION)
                valueOne1 = this.valueOne - valueTwo1;
            else if(CURRENT_ACTION == MULTIPLICATION)
                valueOne1 = this.valueOne * valueTwo1;
            else if(CURRENT_ACTION == DIVISION)
                valueOne1 = this.valueOne / valueTwo1;
            binding.infoTextView.setText(fmt(valueOne1));

            /*History history = new History();
            history.setExpression(binding.editText.getText().toString());
            history.setValue(valueOne1);
            histories.add(history);*/
    }

private void check(String i){
        if(CURRENT_ACTION!='.') {
            if(!i.equals(".")) {
                valueTwo.append(i);
                computeCalculation();
                //binding.infoTextView.setText(decimalFormat.format(valueOne));
            }

        else{
                valueTwo.append(i).append("0");
                computeCalculation();
                valueTwo.deleteCharAt(valueTwo.length() - 1);

                //binding.infoTextView.setText(decimalFormat.format(valueOne));
            }
        }

}
    public static String fmt(double d)
    {
        if(d == (long) d) {

            return String.format("%d", (long) d);

        }
        else

            return String.format("%s",d);
    }

    private static final char ADDITION='+';
    private static final char SUBTRACTION='-';
    private static final char MULTIPLICATION='*';
    private static final char DIVISION='/';
    private char CURRENT_ACTION='.';
    private double valueTwo1;

    private double valueOne=Double.NaN;
    private double valueOne1=Double.NaN;
    private StringBuilder valueTwo=new StringBuilder();
    private DecimalFormat decimalFormat;
    private boolean dotFlag=false;
    private boolean subtractFlag=false;
}

