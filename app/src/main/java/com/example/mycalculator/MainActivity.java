package com.example.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    TextView myresult, total;



    Button zero , one , two, three, four, five, six, seven , eight , nine,dot ,dividir,minus,plus,multiply,percentage,C,btnbracket;

    boolean bracket = false;
    String pro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Inicial();



    }

    public void Inicial(){
        myresult = findViewById(R.id.process);
        total = findViewById(R.id.result);

        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five= findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);


        plus = findViewById(R.id.plus);
        multiply = findViewById(R.id.multiply);
        minus = findViewById(R.id.minus);
        btnbracket = findViewById(R.id.bracket);
        dividir = findViewById(R.id.dividir);
        dot = findViewById(R.id.dot);
        percentage = findViewById(R.id.percentage);


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "9");
            }
        });


        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "+");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "x");
            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "/");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "-");
            }
        });

        percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + "%");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pro = myresult.getText().toString();
                myresult.setText(pro + ".");
            }
        });

        btnbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bracket){
                    pro = myresult.getText().toString();
                    myresult.setText(pro +")");
                    bracket = false;

                }else {
                    pro = myresult.getText().toString();
                    myresult.setText(pro +"(");
                    bracket = true;
                }
            }
        });




    }
    public void equal(View view) {


        pro = myresult.getText().toString();
        pro = pro.replaceAll("x", "*");
        pro = pro.replaceAll("%","/100");

        Context context = Context.enter();
        context.setOptimizationLevel(-1);

        String finalResut = "";

        try {
            Scriptable scriptable = context.initStandardObjects();
            finalResut = context.evaluateString(scriptable, pro, "javascript", 1, null).toString();


        }catch (Exception e){
            finalResut="0";

        }
        total.setText(finalResut);
    }


    public void clear(View view) {

        myresult.setText("");
        total.setText("");
    }

    public void borrar(View view) {

        String string = myresult.getText().toString();

        if (string.length() >= 1){

            string = string.substring(0, string.length() - 1);
            myresult.setText(string);
        }else if (string.length() <1){
            myresult.setText("");

        }


    }


}