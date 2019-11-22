package com.example.calculationsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculationsystem.DataGetters.AddNew;
import com.example.calculationsystem.DataGetters.AddPayment;
import com.example.calculationsystem.DataGetters.AssignLands;
import com.example.calculationsystem.Logic.Manager;

public class CustomersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customers_menu);

        load();

    }

    private void load() {

        if(Manager.getName().matches(""))
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);




            final EditText et = new EditText(this);
            final TextView view=new TextView(this);




            et.setPadding(5,5,5,5);
            et.setHint("Manager name here");
            et.setGravity(Gravity.CENTER);

            et.setBackgroundColor(getResources().getColor(android.R.color.transparent));

            // set prompts.xml to alertdialog builder
            alertDialogBuilder.setView(et);
            alertDialogBuilder.setTitle("Add Manager");

            // set dialog message
            alertDialogBuilder.setCancelable(false).setPositiveButton("Add", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                   Manager.setName( et.getText().toString());


                }
            });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();
        }


    }


    public void Scenes(View view)
    {
        Intent intent = null;

        if(view.getId()==R.id.btn_addPayment)
            intent=new Intent(this, AddPayment.class);


        if(view.getId()==R.id.btn_lands)
            intent=new Intent(this, AssignLands.class);

        if(view.getId()==R.id.btn_customer)
        {
            intent=new Intent(this, AddNew.class);
            intent.putExtra("type",true);
        }

        if(view.getId()==R.id.btn_renter) {

            intent = new Intent(this, AddNew.class);
            intent.putExtra("type",false);
        }



        if(intent!=null)
            startActivity(intent);







    }

}
