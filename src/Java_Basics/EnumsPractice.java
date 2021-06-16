package Java_Basics;

public class EnumsPractice {
    enum Status{
        ACTIVE("Active"), INACTIVE("Inactive");
        private String status;
        Status(String status) {
            this.status=status;
        }

    }
    enum EnumWithMethod{
        INDIVIDUAL{
            public String getType()
            {
                return "individual";
            }
        },GROUP{
            public String getType()
            {
                return "group";
            }
        };
        public String getType()
        {
            return null;
        }

    }

    enum EnumWithAbsMethod{
        INDIVIDUAL{
            @Override
            public String getType() {
                return "individual";
            }
        },GROUP{
            @Override
            public String getType() {
                return "group";
            }
        };
        public abstract String getType();

    }
    public static void main(String[] args) {
        Status.valueOf("invalid value");
        //throws an exception Exception in thread "main" java.lang.IllegalArgumentException: No enum constant Java_Basics.EnumsPractice.Status.In-active

    }
}
