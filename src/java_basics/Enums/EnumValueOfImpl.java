package java_basics.Enums;

public class EnumValueOfImpl {
    enum Status{
        ACTIVE("active"),
        INACTIVE("inactive"),
        PAUSED("paused");
        String value;
        Status(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }

    }

    public static void main(String[] args) {
        System.out.println(Status.valueOf("ACTIVE"))    ;
    }
}
