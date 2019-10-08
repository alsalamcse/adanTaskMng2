package adan.sholy.adantaskmng2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {
    private EditText edtFort;
    private Switch switchOnOff;
    private SeekBar seekBar2;
    private Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        switchOnOff=(Switch)findViewById(R.id.switchOnOff);
        edtFort=(EditText) findViewById(R.id.edtFort);
        seekBar2=(SeekBar) findViewById(R.id.seekBar2);




    }
}
