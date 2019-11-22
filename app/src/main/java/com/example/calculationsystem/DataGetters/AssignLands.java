package com.example.calculationsystem.DataGetters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.calculationsystem.Logic.Land;
import com.example.calculationsystem.Logic.Manager;
import com.example.calculationsystem.Logic.Owner;
import com.example.calculationsystem.R;


public class AssignLands extends AppCompatActivity  {

    private EditText name;
    private EditText size;
    private EditText price;
    private Spinner owner;
    private Spinner renter;
    private ArrayAdapter<String> adapterO;
    private ArrayAdapter<String> adapterR;

    private String ownerName;
    private String renterName;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assign_lands);

        name=(EditText)findViewById(R.id.edit_text_landname);
        size=(EditText)findViewById(R.id.edit_text_landSize);
        price=(EditText)findViewById(R.id.edit_text_landPrice);
        owner=(Spinner)findViewById(R.id.spinner_owner);
        renter=(Spinner)findViewById(R.id.spinner_renter);

        load();





    }


    public void assign(View view)
    {

        String landName=name.getText().toString();
        double landSize=Double.valueOf(size.getText().toString());
        double landPrice=Double.valueOf(price.getText().toString());
        String msg="Enter Valid";
        boolean error=false;


        if(landName.matches(""))
        {
          error=true;
          msg+=" Name";
        }

        if(landSize==0)
        {
            error=true;
            msg+=" Size";
        }

        if(landPrice==0)
        {
            error=true;
            msg+=" Price";
        }


        if(error){
       Toast toast=Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
       toast.show();
        }


        else
        {

            msg="Choose Valid";



            if(owner.getSelectedItem()!=null)
            {    ownerName=owner.getSelectedItem().toString();}
            else
            {
                error= true;
                msg+=" Owner";
            }

            if(renter.getSelectedItem()!=null){
             renterName=renter.getSelectedItem().toString();
            }
            else
            {
                error=true;
                msg+= " Owner";
            }


            if(error)
            {
                Toast toast=Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Land temp=new Land(landSize,landPrice,landName);
                Manager.addLand(ownerName,renterName,temp);

                name.setText("");
                size.setText("");
                price.setText("");

                Toast toast=Toast.makeText(getApplicationContext(),"Land Assigned",Toast.LENGTH_SHORT);
                toast.show();

            }





    }

    }


    private void load() {


          adapterR=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Manager.getNames(false,false));
         adapterR.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

         adapterO=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Manager.getNames(true,false));
        adapterO.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        owner.setAdapter(adapterO);
        renter.setAdapter(adapterR);


    }


}


