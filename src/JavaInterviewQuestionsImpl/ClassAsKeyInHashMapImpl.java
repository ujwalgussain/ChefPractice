package JavaInterviewQuestionsImpl;

import java.util.HashMap;

class EmployeeWithHashCode implements Cloneable{
    int id;
    String name;
    EmployeeWithHashCode()
    {

    }
    EmployeeWithHashCode(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public String toString() {
        return "[ID-"+id+", Name="+name+"]";
    }
}
class EmployeeWithEquals implements Cloneable{
    int id;
    String name;
    EmployeeWithEquals()
    {

    }
    EmployeeWithEquals(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof EmployeeWithEquals))
            return false;
        EmployeeWithEquals e1 = (EmployeeWithEquals)obj;
        return e1.id==this.id && this.name == e1.name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "[ID-"+id+", Name="+name+"]";
    }
}
public class ClassAsKeyInHashMapImpl {

    public static void main(String[] args) throws CloneNotSupportedException {
        /*If we override HashCode only then*/{
            EmployeeWithHashCode e1 = new EmployeeWithHashCode(1,"Adarsh");
            EmployeeWithHashCode e2 = new EmployeeWithHashCode(2,"Ujwal");

            EmployeeWithHashCode e2_duplicate= new EmployeeWithHashCode(2,"Ujwal");
            EmployeeWithHashCode e2_clone= (EmployeeWithHashCode)e2.clone();

            EmployeeWithHashCode e3 = new EmployeeWithHashCode(3,"Rama");
            EmployeeWithHashCode e4 = new EmployeeWithHashCode(4,"Dinesh");
            HashMap<EmployeeWithHashCode,String> map1= new HashMap<>();
            map1.put(e1,"e1");
            map1.put(e2,"e2");
            map1.put(e2_duplicate,"e2_duplicate");//inserted a duplicate object.
            map1.put(e2_clone,"e2_clone");
            map1.put(e3,"e3");
            map1.put(e4,"e4");

            System.out.println("Map With HashCode override "+map1);

            System.out.println("Same Object as inserted is used then");
            System.out.println("\te2 is used "+map1.get(e2));//We will get a response
            System.out.println("\te2_duplicate is used "+map1.get(e2_duplicate));
            System.out.println("\te2_clone is used "+map1.get(e2_clone));
            System.out.println("Different Object is used then");
            //Different object/clone with same data used will give null
            System.out.println("\tIf a new object with same Data as e2 used then -"+map1.get(new EmployeeWithHashCode(1,"Ujwal")));
            System.out.println("\tIf a clone of e2 is used " +map1.get((EmployeeWithHashCode) e2.clone()));
            //Same Object used will return the corresponding data even if the Objects are clone of each other

        }
        {
            System.out.println("If Only Equals is Overridden then");
            EmployeeWithEquals e1 = new EmployeeWithEquals(1,"Adarsh");
            EmployeeWithEquals e2 = new EmployeeWithEquals(2,"Ujwal");

            EmployeeWithEquals e2_duplicate= new EmployeeWithEquals(2,"Ujwal");
            EmployeeWithEquals e2_clone= (EmployeeWithEquals)e2.clone();

            EmployeeWithEquals e3 = new EmployeeWithEquals(3,"Rama");
            EmployeeWithEquals e4 = new EmployeeWithEquals(4,"Dinesh");
            HashMap<EmployeeWithEquals,String> map1= new HashMap<>();
            map1.put(e1,"e1");
            map1.put(e2,"e2");
            map1.put(e2_duplicate,"e2_duplicate");//inserted a duplicate object.
            map1.put(e2_clone,"e2_clone");
            map1.put(e3,"e3");
            map1.put(e4,"e4");


            System.out.println("Map With HashCode override "+map1);

            System.out.println("Same Object as inserted is used then");
            System.out.println("\te2 is used "+map1.get(e2));//We will get a response
            System.out.println("\te2_duplicate is used "+map1.get(e2_duplicate));
            System.out.println("\te2_clone is used "+map1.get(e2_clone));
            System.out.println("Different Object is used then");
            //Different object/clone with same data used will give null
            System.out.println("\tIf a new object with same Data as e2 used then -"+map1.get(new EmployeeWithHashCode(1,"Ujwal")));
            System.out.println("\tIf a clone of e2 is used " +map1.get((EmployeeWithEquals) e2.clone()));
            //Same Object used will return the corresponding data even if the Objects are clone of each other





        }

    }
}
