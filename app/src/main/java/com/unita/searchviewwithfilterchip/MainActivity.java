package com.unita.searchviewwithfilterchip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   private Chip trending , new_arrival , best_selling , low_high , high_low;
   private Button apply;
   private ArrayList<String> selected_chip_data= new ArrayList<String>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trending = (Chip) findViewById(R.id.chipTrending);
        new_arrival = (Chip) findViewById(R.id.chipNewArrival);
        best_selling = (Chip) findViewById(R.id.chipBestSelling);
        low_high = (Chip) findViewById(R.id.chipLtoH);
        high_low = (Chip) findViewById(R.id.chipHtoL);
        apply =(Button) findViewById(R.id.buttonApply);


        CompoundButton.OnCheckedChangeListener checkedChangeListener =new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    selected_chip_data.add(compoundButton.getText().toString());
                    Toast.makeText(getApplicationContext(), "selected", Toast.LENGTH_LONG).show();
                }
                else
                {
                    selected_chip_data.remove(compoundButton.getText().toString());
                    Toast.makeText(getApplicationContext(), "removed", Toast.LENGTH_LONG).show();

                }

            }
        };
        trending.setOnCheckedChangeListener(checkedChangeListener);
        new_arrival.setOnCheckedChangeListener(checkedChangeListener);
        best_selling.setOnCheckedChangeListener(checkedChangeListener);
        low_high.setOnCheckedChangeListener(checkedChangeListener);
        high_low.setOnCheckedChangeListener(checkedChangeListener);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("data", selected_chip_data.toString());
                Toast.makeText(MainActivity.this, selected_chip_data.toString(), Toast.LENGTH_LONG ).show();
               //setResult(101, resultIntent);
                startActivity(i);
               //finish();
            }
        });

    }
}