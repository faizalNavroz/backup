package com.example.fordlabs.calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import com.example.fordlabs.calculator.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    CalculationService calculationService = new CalculationService();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        ArrayAdapter<String>operationAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,getOperationsList());
        operationAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mainBinding.spinner.setAdapter(operationAdapter);
    }

    private List<String> getOperationsList() {
        List<String>operationsList = new ArrayList<String>();
        operationsList.add("ADD");
        operationsList.add("SUB");
        operationsList.add("MUL");
        operationsList.add("DIV");

        return operationsList;
    }

    public void calculate(View view){
        Spinner operation = findViewById(R.id.spinner);
        EditText input1 = findViewById(R.id.editText1);
        EditText input2 = findViewById(R.id.editText2);

        String result  = getFinalResult(input1.getText().toString() , input2.getText().toString(),operation.getSelectedItem().toString());
        TextView resultView = findViewById(R.id.result);
        resultView.setText(result);
    }

    private String getFinalResult(String input1, String input2, String operation) {
        Integer result= null;
        int variable1 = Integer.valueOf(input1);
        int variable2 = Integer.valueOf(input2);


        if (operation.equalsIgnoreCase("ADD")) {
            result = calculationService.addInputs(variable1,variable1);
        }else if(operation.equalsIgnoreCase("SUB")){
            result = calculationService.subtractInputs(variable1,variable2);
        }else if(operation.equalsIgnoreCase("MUL")){
            result = calculationService.multiplyInputs(variable1,variable1);
        }else{
            result = calculationService.divideInputs(variable1,variable1);
        }
        return result.toString();
    }
}
