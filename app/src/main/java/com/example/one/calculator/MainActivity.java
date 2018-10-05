package com.example.one.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.AlertDialog;

import java.lang.String;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_plus,
            btn_minus,btn_multi,btn_divide,btn_equls,btn_AC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBtn();
    }


    public void onClick(View view){

        TextView fomula = (TextView)findViewById(R.id.fomula);
        TextView result = (TextView)findViewById(R.id.result);
        String pre = fomula.getText().toString();
        String str = new String();

        switch (view.getId()) {
            case R.id.btn_0:
                fomula.setText(pre+"0");
                break;

            case R.id.btn_1:
                fomula.setText(pre+"1");
                break;

            case R.id.btn_2:
                fomula.setText(pre+"2");
                break;

            case R.id.btn_3:
                fomula.setText(pre+"3");
                break;

            case R.id.btn_4:
                fomula.setText(pre+"4");
                break;

            case R.id.btn_5:
                fomula.setText(pre+"5");
                break;

            case R.id.btn_6:
                fomula.setText(pre+"6");
                break;

            case R.id.btn_7:
                fomula.setText(pre+"7");
                break;

            case R.id.btn_8:
                fomula.setText(pre+"8");
                break;

            case R.id.btn_9:
                fomula.setText(pre+"9");
                break;

            case R.id.btn_plus:
                fomula.setText(pre+"+");
                break;

            case R.id.btn_minus:
                fomula.setText(pre+"-");
                break;

            case R.id.btn_multi:
                fomula.setText(pre+"*");
                break;

            case R.id.btn_divide:
                fomula.setText(pre+"/");
                break;

            case R.id.btn_equls:
                str = fomula.getText().toString();
                calculate(str);
                break;

            case R.id.btn_AC:
                fomula.setText("");
                result.setText("0");
                break;
            default:
                fomula.setText("default");
        }
    }

    private void initBtn(){

        btn_0 = (Button)findViewById(R.id.btn_0);
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_plus = (Button)findViewById(R.id.btn_plus);
        btn_minus = (Button)findViewById(R.id.btn_minus);
        btn_multi = (Button)findViewById(R.id.btn_multi);
        btn_divide = (Button)findViewById(R.id.btn_divide);
        btn_equls = (Button)findViewById(R.id.btn_equls);
        btn_AC = (Button)findViewById(R.id.btn_AC);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multi.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_equls.setOnClickListener(this);
        btn_AC.setOnClickListener(this);

    }

    private void calculate(String str){

        TextView result = (TextView)findViewById(R.id.result);
        char [] strArray = str.toCharArray();

        for(int i = 0;i < strArray.length;i++) {
            switch (strArray[i]) {
                case '+':
                    try {
                        int num1 = Integer.parseInt(str.split("\\+")[0]);
                        int num2 = Integer.parseInt(str.split("\\+")[1]);
                        int sum = num1 + num2;
                        result.setText(""+sum);
                        break;

                    }
                    catch (Exception e){
                        tips();
                    }
                    break;


                case '-':
                    try {
                        int num3 = Integer.parseInt(str.split("-")[0]);
                        int num4 = Integer.parseInt(str.split("-")[1]);
                        int differ = num3 - num4;
                        result.setText(""+differ);
                        break;
                    }
                    catch (Exception e){
                        tips();
                    }
                    break;


                case '*':
                    try {
                        int num5 = Integer.parseInt(str.split("\\*")[0]);
                        int num6 = Integer.parseInt(str.split("\\*")[1]);
                        int product = num5 * num6;
                        result.setText(""+product);
                        break;

                    }
                    catch (Exception e){
                        tips();
                    }
                    break;

                case '/':
                    try{
                        int num7 = Integer.parseInt(str.split("/")[0]);
                        int num8 = Integer.parseInt(str.split("/")[1]);
                        if (num8 == 0){
                            tips();
                            break;
                        }
                        int quotient = num7 / num8;
                        result.setText(""+quotient);
                        break;

                    }
                    catch (Exception e){
                        tips();
                    }
                    break;

                default:
                    break;
            }
        }
    }

    private void tips(){
        new  AlertDialog.Builder(this)
                .setTitle("" )
                .setMessage("输入错误,请检查！" )
                .setPositiveButton("确定" ,  null )
                .show();
    }

}