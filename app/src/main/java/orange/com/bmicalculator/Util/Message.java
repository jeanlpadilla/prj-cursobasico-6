package orange.com.bmicalculator.Util;

/**
 * Created by Jean Luis on 5/27/2017.
 */


public enum Message {
    male {
        @Override
        public String detail() {
            return "masculino";
        }


    },

    female {
        @Override
        public String detail() {
            return "femenino";
        }


    };


    public abstract String detail();

}

