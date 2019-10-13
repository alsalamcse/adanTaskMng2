package adan.sholy.adantaskmng2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class settings extends AppCompatActivity {
    private Switch switchOnOff;
    private SeekBar seekB;
    private Button btnSave;
    private EditText editSize;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        switchOnOff=(Switch)findViewById(R.id.switchOnOff);
        editSize=(EditText) findViewById(R.id.editSize);
        seekB=(SeekBar) findViewById(R.id.seekB);
        btnSave=(Button)findViewById(R.id.btnSave);




    }
}
