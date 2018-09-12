package fr.wildcodeschool.myapplication3;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

CheckBox cb;
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    final Button buttonAccept = findViewById(R.id.button_accept);
    buttonAccept.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText editlastname = findViewById(R.id.edit_lastname);
            String lastnameValue = editlastname.getText().toString();

            EditText editfirstname = findViewById(R.id.edit_firstname);
            String firstnameValue = editfirstname.getText().toString();
            if(firstnameValue.isEmpty() || lastnameValue.equals("")){
                Toast.makeText(MainActivity.this, R.string.error_empty, Toast.LENGTH_SHORT).show();
            }else{
                TextView textCongrats = findViewById(R.id.text_congratulation);
                textCongrats.setVisibility(View.VISIBLE);
                textCongrats.setText(String.format(getString(R.string.congratulation), firstnameValue, lastnameValue));
            }
        }
    });

    CheckBox checkWilder = findViewById(R.id.checkBox_wilder);
    checkWilder.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            EditText editFirstname= findViewById(R.id.edit_firstname);
            EditText editLastname= findViewById(R.id.edit_lastname);


            editFirstname.setEnabled(isChecked);
            editLastname.setEnabled(isChecked);
            buttonAccept.setEnabled(isChecked);

        }
    });

    }
}
