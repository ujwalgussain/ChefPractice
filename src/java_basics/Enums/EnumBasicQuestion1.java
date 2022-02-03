package java_basics.Enums;

public class EnumBasicQuestion1 {
    public enum Ensemble {
        SOLO, DUET, TRIO, QUARTET, QUINTET,
        SEXTET, SEPTET, OCTET, NONET, DECTET;
        //WHAT WILL THIS METHOD RETURN FOR SOLO -> 1 since ordinal() is an instance method.
        public int numberOfMusicians() {
            return ordinal() + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(Ensemble.SOLO.numberOfMusicians());
    }
}
