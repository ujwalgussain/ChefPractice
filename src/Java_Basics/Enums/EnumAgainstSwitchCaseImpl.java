package Java_Basics.Enums;
public class EnumAgainstSwitchCaseImpl {
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
        String s;
        CorpCode(String s) {
            this.s = s;
        }
        public abstract String getNurseLineNo();
    }
    public static void main(String[] args) {
        CorpCode c1 = CorpCode.valueOf("IL1");
        System.out.println(CorpCode.IL.getNurseLineNo());
    }
}
