package com.example.a12118.hw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private static SeekBar seekbar;
    private static EditText input_amount;
    private static TextView tip_percentage;
    private static TextView tip_amount;
    private static TextView total_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekbar = (SeekBar) findViewById(R.id.seekBar);
        input_amount = (EditText) findViewById(R.id.input);
        tip_percentage = (TextView) findViewById(R.id.tipPercentage);
        tip_amount = (TextView) findViewById(R.id.tipAmount);
        total_amount = (TextView) findViewById(R.id.tipTotal);

        seekbar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener(){
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
                    {
                        double input;
                        double tip;
                        double total;

                        tip_percentage.setText(progress + "%");
                        try{
                            input = Double.parseDouble(input_amount.getText().toString());
                            tip = Math.round((input * progress / 100.0) * 100.0) / 100.0;
                            total = Math.round((input + tip) * 100.0) / 100.0;
                            tip_amount.setText("$ " + tip);
                            total_amount.setText("$ " + total);
                        }catch (Exception e)
                        {
                            Log.i("Debugger", "invalid input");
                            tip_amount.setText("error");
                            total_amount.setText("error");
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                }
        );
    }
}
