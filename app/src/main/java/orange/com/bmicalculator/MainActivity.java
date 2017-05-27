package orange.com.bmicalculator;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import orange.com.bmicalculator.Class.IdealWeight;

import static orange.com.bmicalculator.Class.Person.getIdealWeight;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    private EditText editTextWeight;
    private EditText editTextHeight;
    private EditText editTextYear;
    private Button btnCalculate;

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        editTextWeight = (EditText) findViewById(R.id.text_number_weight);
        editTextHeight = (EditText) findViewById(R.id.text_number_height);
        editTextYear = (EditText) findViewById(R.id.text_number_year);


        btnCalculate = (Button) findViewById(R.id.btn_calculate);
        btnCalculate.setOnClickListener(this);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if  (id == R.id.nav_gallery) {

        }  else if (id == R.id.nav_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, "PESO IDEAL");
            startActivity(Intent.createChooser(intent, "Comparte con"));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        IdealWeight idealWeight = null;
        Intent intent = null;

        switch (v.getId()) {


            case R.id.btn_calculate:


                String gender = "";
                radioSexGroup = (RadioGroup) findViewById(R.id.radioSex);
                Integer selectedId = radioSexGroup.getCheckedRadioButtonId();
                Log.i("selectedId",Integer.toString(selectedId));
                radioSexButton = (RadioButton) findViewById(selectedId);
                if(selectedId != null && selectedId >= 1){

                    gender = radioSexButton.getText().toString().toLowerCase();
                }


                double btnTextYear;
                double btnTextWeight;
                double btnTextHeight;
                try {
                    btnTextHeight = Double.parseDouble(editTextHeight.getText().toString());
                    btnTextWeight = Double.parseDouble(editTextWeight.getText().toString());
                    btnTextYear = Double.parseDouble(editTextYear.getText().toString());

                } catch (NumberFormatException e) {
                    btnTextHeight = 0;
                    btnTextWeight = 0;
                    btnTextYear = 0;
                }


                intent = new Intent(MainActivity.this, ResultActivity.class);
                if (intent != null) {
                    if (v instanceof Button) {
                        Log.i("gender", gender);
                        if(validateFields(btnTextYear, btnTextHeight, btnTextWeight, gender,getApplicationContext())){
                            idealWeight = getIdealWeight(btnTextYear, btnTextHeight, btnTextWeight, gender);
                            intent.putExtra("idealWeight", idealWeight.getIdealWeight());
                            intent.putExtra("leanBodyMass", idealWeight.getLeanBodyMass());
                            intent.putExtra("percentagePI", idealWeight.getPercentagePI());
                            intent.putExtra("obesity", idealWeight.getObesity());

                            startActivity(intent);
                        }

                    }
                }
                break;


        }

    }

    public boolean validateFields(double ageText, double heightText, double weightText, String sexText, Context c) {

        boolean success = false;

        Log.i("validateFields", Double.toString(ageText));
        Log.i("validateFields", Double.toString(heightText));
        Log.i("validateFields", Double.toString(weightText));
        Log.i("validateFields", sexText);
        if (ageText <= 0.0 || heightText <= 0.0 || weightText <= 0.0 || sexText.equals("")) {

            Log.i("validateFields", "entroe 1");
            Toast.makeText(c.getApplicationContext(),"Debe completar todos los campos",Toast.LENGTH_LONG).show();

        } else {


            Log.i("validateFields", "entroe 2");
            if (weightText > 300) {

                Toast.makeText(c.getApplicationContext(),"El peso no puede ser mayor de 300 KG.",Toast.LENGTH_LONG).show();

            } else if (heightText > 300) {

                Toast.makeText(c.getApplicationContext(),"La altura no puede ser mayor de 300 CM.",Toast.LENGTH_LONG).show();
            } else if (ageText > 125) {


                Toast.makeText(c.getApplicationContext(),"La edad no puede ser mayor de 125 años.",Toast.LENGTH_LONG).show();
            }else{
                success = true;
            }
        }

    return success;
    }


}
