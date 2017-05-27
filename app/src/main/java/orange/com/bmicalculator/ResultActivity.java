package orange.com.bmicalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textIdealWeight;
    private TextView textLeanBodyMass;
    private TextView textPercentagePI;
    private TextView textObesity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        textIdealWeight = (TextView) findViewById(R.id.text_ideal_weight);
        textLeanBodyMass = (TextView) findViewById(R.id.text_lean_body_mass);
        textPercentagePI = (TextView) findViewById(R.id.text_pi_percentage);
        textObesity = (TextView) findViewById(R.id.text_obesity);

        Intent i= getIntent();

        textIdealWeight.setText( i.getStringExtra("idealWeight"));
        textLeanBodyMass.setText( i.getStringExtra("leanBodyMass"));
        textPercentagePI.setText( i.getStringExtra("percentagePI"));
        textObesity.setText( i.getStringExtra("obesity"));
    }
}
