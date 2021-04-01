package com.example.unitConverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Math.round;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] unit = { "Metre", "Celsius", "Kilograms" };    //#008774
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner list = (Spinner) findViewById(R.id.unitSelection);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, unit);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        list.setAdapter(adapter);
        list.setOnItemSelectedListener(this);

        EditText editText = (EditText)findViewById(R.id.inputValue);
        editText.setHint("Enter Number Here");
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void lengthClick(View view) {
        EditText inputValue  = (EditText) findViewById(R.id.inputValue);
        try {
            if(checkSpinner("Metre")){
                Double input = Double.parseDouble(inputValue.getText().toString());

                Double centimetre = round(100 * input, 2);
                setResultsView1(centimetre.toString());
                Double foot = round(100 *input/3.28084, 2);
                setResultsView2(foot.toString());
                Double inch = round(100 *input/39.37008, 2);
                setResultsView3(inch.toString());

                setUnitsView1("Centimetre");
                setUnitsView2("Foot");
                setUnitsView3("Inch");
            }
            else {
            wrongUnit();
            }
        }catch(Exception e){
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }
    }

    public void weightClick(View view) {
        EditText inputValue  = (EditText) findViewById(R.id.inputValue);
        try {
            if (checkSpinner("Kilograms")){
                Double input = Double.parseDouble(inputValue.getText().toString());

                Double gram = round(1000 * input, 2);
                setResultsView1(gram.toString());
                Double ounce = round(input*35.27396195, 2);
                setResultsView2(ounce.toString());
                Double pound = round(input*2.2046, 2);
                setResultsView3(pound.toString());

                setUnitsView1("Gram");
                setUnitsView2("Ounce(Oz)");
                setUnitsView3("Pound(lb)");
            }
            else {
                wrongUnit();
            }
        }catch(Exception e){
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }
    }

    public void tempClick(View view) {
        EditText inputValue  = (EditText) findViewById(R.id.inputValue);
        try {
            if (checkSpinner("Celsius")){
                Double input = Double.parseDouble(inputValue.getText().toString());

                Double fahren = round((1.8 * input) + 32, 2);
                setResultsView1(fahren.toString());
                Double kelvin = round(input + 273.15, 2);
                setResultsView2(kelvin.toString());
                setResultsView3("");

                setUnitsView1("Fahrenheit");
                setUnitsView2("Kelvin");
                setUnitsView3("");

            }
            else {
                wrongUnit();
            }
        }catch(Exception e){
            Toast.makeText(this, "Please enter a valid number.", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean checkSpinner(String targetVal){
        Spinner spinner = (Spinner) findViewById(R.id.unitSelection);
        if(spinner.getSelectedItem().toString().equals(targetVal)) {
            return true;
        }
        else {
            return false;
        }

    }
    public void wrongUnit() {
        Toast.makeText(this, "Please select the correct conversion icon.", Toast.LENGTH_SHORT).show();
    }

    public void setUnitsView1(String unit) {
        TextView view  = (TextView) findViewById(R.id.unitsTextView1);
        view.setText(unit);
    }
    public void setUnitsView2(String unit) {
        TextView view  = (TextView) findViewById(R.id.unitsTextView2);
        view.setText(unit);
    }
    public void setUnitsView3(String unit) {
        TextView view  = (TextView) findViewById(R.id.unitsTextView3);
        view.setText(unit);
    }
    public void setResultsView1(String result) {
        TextView view  = (TextView) findViewById(R.id.resultTextView1);
        view.setText(result);
    }
    public void setResultsView2(String result) {
        TextView view  = (TextView) findViewById(R.id.resultTextView2);
        view.setText(result);
    }
    public void setResultsView3(String result) {
        TextView view  = (TextView) findViewById(R.id.resultTextView3);
        view.setText(result);
    }
    //rounding method copied from https://stackoverflow.com/questions/2808535/round-a-double-to-2-decimal-places
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}