package com.example.timeandfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    int DoSums,i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(message);

    }


    public void DoCalculation (View view) {
        EditText LeftTank = findViewById(R.id.LeftTank);
        EditText CentreTank = findViewById(R.id.CentreTank);
        EditText RightTank = findViewById(R.id.RightTank);
        EditText TankTotal = findViewById(R.id.TankTotal);
        EditText RequiredFuel = findViewById(R.id.NeededFuel);
        EditText ActualLitres = findViewById(R.id.ActualLitres);
        EditText Temperature = findViewById(R.id.Temperature);
        EditText ExpectedLitres = findViewById(R.id.ExpectedLitres);

        TextView Difference = findViewById(R.id.DifferenceText);



        DoSums=(1+2+5);

                //Integer.parseInt(LeftTank.getText().toString())+
       //  Integer.parseInt(CentreTank.getText().toString())
     //   +Integer.parseInt(RightTank.getText().toString()));
       //TankTotal.setText(String.valueOf(DoSums));
       // TankTotal.setText(String.valueOf(12345));
        TankTotal.setText("Hello again");
    }

    public void ButtonTest(View view){

        TextView test=findViewById(R.id.DifferenceText);
        EditText LeftTank = findViewById(R.id.LeftTank);
        EditText CentreTank = findViewById(R.id.CentreTank);
        EditText RightTank = findViewById(R.id.RightTank);
        EditText TankTotal = findViewById(R.id.TankTotal);
        EditText RequiredFuel = findViewById(R.id.NeededFuel);
        EditText ActualLitres = findViewById(R.id.ActualLitres);
        EditText Temperature = findViewById(R.id.Temperature);
        EditText ExpectedLitres = findViewById(R.id.ExpectedLitres);

        String LeftTankString=LeftTank.getText().toString();
        if(TextUtils.isEmpty(LeftTankString)) {
            LeftTank.setError("Add Fuel!");
            return;
        }
        String RightTankString=RightTank.getText().toString();
        if(TextUtils.isEmpty(RightTankString)) {
            RightTank.setError("Add Fuel!");
            return;
        }
        String CentreTankString=CentreTank.getText().toString();
        if(TextUtils.isEmpty(CentreTankString)) {
            CentreTank.setText("0");

        }

        int LeftTank1=(Integer.parseInt(LeftTank.getText().toString()));

        int CentreTank1=((Integer.parseInt(CentreTank.getText().toString())));
        int RightTank1=(Integer.parseInt(RightTank.getText().toString()));
        DoSums=(LeftTank1+CentreTank1+RightTank1);
       // RightTank.setText("24");

        //test.setText("Hello");
        test.setText(String.valueOf(DoSums));
        TankTotal.setText(String.valueOf(DoSums));

       // if(RequiredFuel)
        String TotalRequiredString=RequiredFuel.getText().toString();
        String TemperatureString=Temperature.getText().toString();

        if(TextUtils.isEmpty(TotalRequiredString)) {
            //RequiredFuel.setError("Add Total!");
            return;
        }
        else {if (TextUtils.isEmpty(TemperatureString)) {
            Temperature.setError("Add Temperature!");
            return;
        }

        int FuelNeededTotal1=(Integer.parseInt(RequiredFuel.getText().toString()));
        double Temperature1=(Integer.parseInt(Temperature.getText().toString()));

        if(Temperature1<5){
                Temperature1=(0.806);
            }
            else if(Temperature1>=5 && Temperature1<=18){
                Temperature1=(0.8);


            }
            else if (Temperature1>=19 && Temperature1<=30){
                Temperature1=(0.787);
        }
            else if (Temperature1>30){
                Temperature1=(0.781);

        }
        double fuelcalculation=((FuelNeededTotal1-DoSums)/Temperature1);
            int output=(int) Math.round(fuelcalculation);
            ExpectedLitres.setText(String.valueOf(output));
            String TotalActualLitresString=ActualLitres.getText().toString();

        if(TextUtils.isEmpty(TotalActualLitresString)) {
            //RequiredFuel.setError("Add Total!");
            return;
        }
        else {
            int actualLitres1=(Integer.parseInt(TotalActualLitresString));
            int ActualDifference=(actualLitres1-output);
            test.setText((String.valueOf(ActualDifference)));
                if (ActualDifference>625 || ActualDifference<-625){
                    test.setText((String.valueOf(ActualDifference))+"litre  Discrepancy!");
                    test.setTextColor(Color.RED);
                }
        }
        }
    }
}