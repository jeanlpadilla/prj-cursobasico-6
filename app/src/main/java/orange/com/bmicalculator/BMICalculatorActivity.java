package orange.com.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BMICalculatorActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextWeight;
    private EditText editTextHeight;
    private EditText editTextYear;

    private Button btnCalculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalculator);
        editTextWeight = (EditText) findViewById(R.id.text_number_weight);
        editTextHeight = (EditText) findViewById(R.id.text_number_height);
        editTextYear = (EditText) findViewById(R.id.text_number_year);


        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(this);
    }

    public void onClick(View v) {


        Intent intent = null;


        switch (v.getId()) {

            case R.id.btn_calculate:
                double btnTextYear   = 0;
                double btnTextWeight = 0;
                double btnTextHeight = 0;
                try {
                    btnTextHeight = Double.parseDouble(editTextHeight.getText().toString());
                    btnTextWeight = Double.parseDouble(editTextWeight.getText().toString());
                    btnTextYear = Double.parseDouble(editTextYear.getText().toString());

                } catch (NumberFormatException e) {
                    btnTextHeight = 0;
                    btnTextWeight = 0;
                    btnTextYear = 0;
                }

                intent = new Intent(BMICalculatorActivity.this, ResultActivity.class);
                if (intent != null) {
                    if (v instanceof Button) {
                        String cal = bmiCalculator(btnTextYear, btnTextHeight, btnTextWeight, "s");
                        intent.putExtra("resultCalculator", cal);
                    }
                }

                startActivity(intent);
                break;

        }

    }

    public String bmiCalculator(double age, double h, double w, String s) {
        double Ht = h;
        double Wt = w;
        double Age = age;


        String Sex = "1";
        double imc = 0;

        ////////////////////
        double PIdevine = 0;
        double PIrobinson = 0;
        double PImiller = 0;
        double PIhamwi = 0;
        double PIprueba = 0;
        double meters = Ht / 100;


        /////////////////////////
        double lbm = 0;
        double Watson = 0;
        double Hume = 0;


        /////////////////////////

        double tbw = 0;
        double PI = 0;
        double PIPorc = 0;
        double bsa = 0;


        imc = Wt / (meters * meters);
        imc = Math.round(imc * 100) / 100;

        if (Sex.equals("1")) {

            PIdevine = ((Ht - 152.4) * (0.91) + 50);

            PIrobinson = ((Ht - 152.4) * (0.748) + 52);

            PImiller = ((Ht - 152.4) * (0.555) + 56.2);

            PIhamwi = ((Ht - 152.4) * (1.063) + 48.2);

            PIprueba = (22 * ((Ht / 100) * (Ht / 100)));
            lbm = (Wt * 1.10) - ((128 * ((Wt / Ht) * (Wt / Ht))));
            Watson = 2.447 - (0.09156 * Age) + (0.1074 * Ht) + (0.3362 * Wt);
            Hume = (0.194786 * Ht) + (0.296785 * Wt) - 14.012934;
        }


        if (Sex == "2") {

            PIdevine = ((Ht - 152.4) * (0.91) + 45.5);

            PIrobinson = ((Ht - 152.4) * (0.669) + 49);

            PImiller = ((Ht - 152.4) * (0.5354) + 53.1);

            PIhamwi = ((Ht - 152.4) * (0.866) + 45.5);

            PIprueba = (22 * ((Ht / 100) * (Ht / 100)));
            lbm = (Wt * 1.07) - ((148 * ((Wt / Ht) * (Wt / Ht))));
            Watson = -2.097 + (0.1069 * Ht) + (0.2466 * Wt);
            Hume = (0.34454 * Ht) + (0.183809 * Wt) - 35.270121;
        }


        tbw = (Hume + Watson) / 2;
        PI = (PIdevine + PIrobinson + PImiller + PIhamwi + PIprueba) / 5;

        PI = Math.round(PI * 100) / 100;
        PIPorc = (Wt / PI) * (100);

        PIPorc = Math.round(PIPorc * 100) / 100;

        bsa = Math.pow(Wt, 0.425) * Math.pow(Ht, 0.725) * 0.007184;

        bsa = Math.round(bsa * 1000) / 1000;

        lbm = Math.round(lbm * 100) / 100;
        tbw = Math.round(tbw * 10) / 10;

        Log.i("metodo", Double.toString(PI));


        return "KG " + Double.toString(PI);
    }

    public void selectSex(String sex, View v){

        Log.i("selectSex", sex);
        if(sex.equals("male")){
            int resId = (Integer) v.getTag();
            if(resId == R.drawable.ic_man) {

             //   imageButtonFemale.setBackgroundResource(R.drawable.ic_woman);
             //   imageButtonFemale.setTag(R.drawable.ic_woman);
            }else {

             //   imageButtonFemale.setBackgroundResource(R.drawable.ic_man);
            //    imageButtonFemale.setTag(R.drawable.ic_man);
            }
        }else if(sex.equals("female")){


        }

    }
}

