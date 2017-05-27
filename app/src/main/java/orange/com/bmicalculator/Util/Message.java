package orange.com.bmicalculator.Util;


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

