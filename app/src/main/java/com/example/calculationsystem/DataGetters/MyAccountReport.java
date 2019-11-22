package com.example.calculationsystem.DataGetters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.calculationsystem.Logic.Manager;
import com.example.calculationsystem.R;

import java.util.ArrayList;
import java.util.List;

public class MyAccountReport extends AppCompatActivity {



    private TextView moneyExpected;
    private TextView moneyCollected;
    private TextView moneyOwners;
    private TextView moneyOwnersLeft;
    private TextView MoneyLeft;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_report);


          moneyExpected=findViewById(R.id.my_report_MExpected);
          moneyCollected=findViewById(R.id.my_report_MCollected);
          moneyOwners=findViewById(R.id.my_report_MLOwner);
          moneyOwnersLeft=findViewById(R.id.my_report_MOPaid);
          MoneyLeft=findViewById(R.id.my_report_MExpectedLeft);

         load();


    }

    private void load() {

         List<Double> temp=new ArrayList<>();
         temp=Manager.getMoneyList();


          moneyExpected.setText("Money Expected: "+String.valueOf(temp.get(0)));
          moneyCollected.setText("Money Collected: "+String.valueOf(temp.get(1)));
          moneyOwners.setText("Money Owners Expects: "+String.valueOf(temp.get(2)));
          moneyOwnersLeft.setText("Money Left for Owners: "+String.valueOf(temp.get(2)-temp.get(3)));
          MoneyLeft.setText("Money Left: "+String.valueOf(temp.get(4)));




    }


}
