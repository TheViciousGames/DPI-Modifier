package com.theviciousgames.dpimodifier;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Button changeCurrentDPIButton,testChangeCurrentDPIButton;
    private TextView currentDPIValueTextView;
    private EditText customDPIValueEditText;
    private int lastDPIValue,customDPIValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        declareObjects();
        buttonFunctions();
        getInfo();
    }
    protected void declareObjects()
    {
        currentDPIValueTextView=findViewById(R.id.currentDPIValueTextView);
        changeCurrentDPIButton=findViewById(R.id.changeCurrentDpiButton);
        customDPIValueEditText=findViewById(R.id.customValueEditText);
        testChangeCurrentDPIButton=findViewById(R.id.testChangeCurrentDpiButton);
    }
    protected void buttonFunctions()
    {
        changeCurrentDPIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.setDPI(customDPIValue);
            }
        });

        testChangeCurrentDPIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastDPIValue=Tools.getDPI(MainActivity.this);
                customDPIValue= Integer.parseInt(String.valueOf(customDPIValueEditText.getText()));
                Tools.setDPI(customDPIValue);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Tools.setDPI(lastDPIValue);
                    }
                }, 5000);
            }
        });
    }
    protected void getInfo()
    {
        currentDPIValueTextView.setText(""+Tools.getDPI(this));
    }
}