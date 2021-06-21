package Java_Basics.Enums;

import java.util.HashMap;

public class GetEnumTypeFromValue {
    enum CorpCode{
        IL("IL1"){
            @Override
            public String getNurseLineNo() {
                return "IL number";
            }
        },TX("TX1"){
            @Override
            public String getNurseLineNo() {
                return "TX Number";
            }
        };
        String s; //we can access from outside if public
        private static HashMap<String,CorpCode> valuesMap = new HashMap<>();
        CorpCode(String s) {
            this.s = s;
        }
        private static void populateValueMap()
        {
            for(CorpCode corpCode : CorpCode.values())
                valuesMap.put(corpCode.s,corpCode);
        }
        public static CorpCode from(String value)
        {
            //here we can handle default operation also\
            if(valuesMap.isEmpty())
                populateValueMap();
            return valuesMap.get(value);
        }
        public abstract String getNurseLineNo();
    }

    public static void main(String[] args) {
        System.out.println(CorpCode.from("IL1"));
    }
}
