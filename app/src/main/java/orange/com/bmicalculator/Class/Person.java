package orange.com.bmicalculator.Class;

import android.util.Log;

import orange.com.bmicalculator.Util.Message;


public class Person {

    public static IdealWeight getIdealWeight(double ageText, double heightText, double weightText, String sexText){

        IdealWeight idealWeight = new IdealWeight();


        Log.i("metodo", Double.toString(ageText));
        Log.i("metodo", Double.toString(heightText));
        Log.i("metodo", Double.toString(weightText));

        double imc;

        ////////////////////
        double PIdevine = 0;
        double PIrobinson = 0;
        double PImiller = 0;
        double PIhamwi = 0;
        double PIprueba = 0;
        double meters = heightText / 100;


        /////////////////////////
       // double lbm = 0;
     //   double Watson = 0;
      //  double Hume = 0;


        /////////////////////////

       // double tbw;
        double PI;
        double PIPorc;
      //  double bsa;


        imc = weightText / (meters * meters);
        imc = Math.round(imc * 100) / 100;
        Log.i("female",Message.female.toString());
        Log.i("female",Message.male.toString());
        if (sexText.equals(Message.male.detail())) {

            PIdevine = ((heightText - 152.4) * (0.91) + 50);

            PIrobinson = ((heightText - 152.4) * (0.748) + 52);

            PImiller = ((heightText - 152.4) * (0.555) + 56.2);

            PIhamwi = ((heightText - 152.4) * (1.063) + 48.2);

            PIprueba = (22 * ((heightText / 100) * (heightText / 100)));
          //  lbm = (weightText * 1.10) - ((128 * ((weightText / heightText) * (weightText / heightText))));
          //  Watson = 2.447 - (0.09156 * ageText) + (0.1074 * heightText) + (0.3362 * weightText);
          //  Hume = (0.194786 * heightText) + (0.296785 * weightText) - 14.012934;

        }else if (sexText.equals(Message.female.detail())) {

            PIdevine = ((heightText - 152.4) * (0.91) + 45.5);

            PIrobinson = ((heightText - 152.4) * (0.669) + 49);

            PImiller = ((heightText - 152.4) * (0.5354) + 53.1);

            PIhamwi = ((heightText - 152.4) * (0.866) + 45.5);

            PIprueba = (22 * ((heightText / 100) * (heightText / 100)));
        //    lbm = (weightText * 1.07) - ((148 * ((weightText / heightText) * (weightText / heightText))));
          //  Watson = -2.097 + (0.1069 * heightText) + (0.2466 * weightText);
          //  Hume = (0.34454 * heightText) + (0.183809 * weightText) - 35.270121;
        }


       // tbw = (Hume + Watson) / 2;
        PI = (PIdevine + PIrobinson + PImiller + PIhamwi + PIprueba) / 5;

        PI = Math.round(PI * 100) / 100;
        PIPorc = (weightText / PI) * (100);

        PIPorc = Math.round(PIPorc * 100) / 100;

      //  bsa = Math.pow(weightText, 0.425) * Math.pow(heightText, 0.725) * 0.007184;



    //    bsa = Math.round(bsa * 1000) / 1000;

    //    lbm = Math.round(lbm * 100) / 100;
    //    tbw = Math.round(tbw * 10) / 10;

        Log.i("metodo", Double.toString(PI));
        idealWeight.setIdealWeight( Double.toString(PI));
        idealWeight.setLeanBodyMass( Double.toString(imc));
        idealWeight.setPercentagePI( Double.toString(PIPorc));
        idealWeight.setObesity(obesity(imc));

        return idealWeight;
    }




    private static String obesity(double imc) {

        String obesity = "";
        if (imc < 16) {
            obesity = "Desnutrición severa";

        } else if (imc >= 16 && imc < 17) {

            obesity = "Desnutrición moderada";
        } else if (imc >= 17 && imc < 18.5) {

            obesity = "Desnutrición ligera";
        } else if (imc >= 18.5 && imc < 24.91) {
            obesity = "Peso Normal";

        } else if (imc > 24.91 && imc < 26.91) {

            obesity = "Sobrepeso grado I";
        } else if (imc > 26.9 && imc < 29.91) {
            obesity = "Sobrepeso grado II (preobesidad)";

        } else if (imc > 29.91 && imc < 34.6) {

            obesity = "Obesidad tipo I";
        } else if (imc > 34.6 && imc < 39.91) {
            obesity = "Obesidad tipo II";

        } else if (imc > 39.91 && imc < 49.91) {
            obesity = "Obesidad tipo III ((Mórbida)";

        } else if (imc > 49.91) {
            obesity = "Obesidad tipo IV (Extrema)";

        }
        return obesity;
    }
}
/* public String bmiCalculator(double age, double h, double w, String s) {
        double Ht = h;
        double Wt = w;
        double Age = age;

        Log.i("bmiCalculator", Double.toString(age));

        Log.i("bmiCalculator", Double.toString(h));

        Log.i("bmiCalculator", Double.toString(w));

        Log.i("bmiCalculator", s);

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

        if (s.equals("masculino")) {

            PIdevine = ((Ht - 152.4) * (0.91) + 50);

            PIrobinson = ((Ht - 152.4) * (0.748) + 52);

            PImiller = ((Ht - 152.4) * (0.555) + 56.2);

            PIhamwi = ((Ht - 152.4) * (1.063) + 48.2);

            PIprueba = (22 * ((Ht / 100) * (Ht / 100)));
            lbm = (Wt * 1.10) - ((128 * ((Wt / Ht) * (Wt / Ht))));
            Watson = 2.447 - (0.09156 * Age) + (0.1074 * Ht) + (0.3362 * Wt);
            Hume = (0.194786 * Ht) + (0.296785 * Wt) - 14.012934;
        }else  if (s.equals("femenina")) {

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
*/
