package JavaInterviewQuestionsImpl;

import java.util.HashMap;

class HashCodeOverride implements Cloneable{
    int id;
    String name;
    HashCodeOverride()
    {

    }
    HashCodeOverride(int id, String name)
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
class EqualsOverride implements Cloneable{
    int id;
    String name;
    EqualsOverride()
    {

    }
    EqualsOverride(int id, String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj)
            return true;
        if(!(obj instanceof EqualsOverride))
            return false;
        EqualsOverride e1 = (EqualsOverride)obj;
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
            HashCodeOverride e1 = new HashCodeOverride(1,"Adarsh");
            HashCodeOverride e2 = new HashCodeOverride(2,"Ujwal");

            HashCodeOverride e2_duplicate= new HashCodeOverride(2,"Ujwal");
            HashCodeOverride e2_clone= (HashCodeOverride)e2.clone();

            HashCodeOverride e3 = new HashCodeOverride(3,"Rama");
            HashCodeOverride e4 = new HashCodeOverride(4,"Dinesh");
            HashMap<HashCodeOverride,String> map1= new HashMap<>();
            map1.put(e1,"e1");
            map1.put(e2,"e2");
            map1.put(e2_duplicate,"e2_duplicate");//inserted a duplicate object.
            map1.put(e2_clone,"e2_clone");
            map1.put(e3,"e3");
            map1.put(e4,"e4");

            System.out.println("Map With HashCode override "+map1);

            System.out.println("Same Object as inserted is used then");
            System.out.println("\tmap1.get(e2) "+map1.get(e2));//We will get a response
            System.out.println("\tmap1.get(e2_duplicate) "+map1.get(e2_duplicate));
            System.out.println("\tmap1.get(e2_clone)"+map1.get(e2_clone));
            System.out.println("Different Object is used then");
            //Different object/clone with same data used will give null
            System.out.println("\tmap1.get(new EmployeeWithHashCode(1,\"Ujwal\")) -"+map1.get(new HashCodeOverride(1,"Ujwal")));
            System.out.println("\tmap1.get((EmployeeWithHashCode) e2.clone())" +map1.get((HashCodeOverride) e2.clone()));
            //Same Object used will return the corresponding data even if the Objects are clone of each other

        }
        {
            System.out.println("If Only Equals is Overridden then");
            EqualsOverride e1 = new EqualsOverride(1,"Adarsh");
            EqualsOverride e2 = new EqualsOverride(2,"Ujwal");

            EqualsOverride e2_duplicate= new EqualsOverride(2,"Ujwal");
            EqualsOverride e2_clone= (EqualsOverride)e2.clone();

            EqualsOverride e3 = new EqualsOverride(3,"Rama");
            EqualsOverride e4 = new EqualsOverride(4,"Dinesh");
            HashMap<EqualsOverride,String> map1= new HashMap<>();
            map1.put(e1,"e1");
            map1.put(e2,"e2");
            map1.put(e2_duplicate,"e2_duplicate");//inserted a duplicate object.
            map1.put(e2_clone,"e2_clone");
            map1.put(e3,"e3");
            map1.put(e4,"e4");


            System.out.println("Map With Equals override "+map1);

            System.out.println("Same Object as inserted is used then");
            System.out.println("\tmap1.get(e2) -  "+map1.get(e2));//We will get a response
            System.out.println("\tmap1.get(e2_duplicate) - "+map1.get(e2_duplicate));
            System.out.println("\tmap1.get(e2_clone) - "+map1.get(e2_clone));
            System.out.println("Different Object is used then");
            //Different object/clone with same data used will give null
            System.out.println("\tmap1.get(new Employee(1,\"Ujwal\")) -"+map1.get(new HashCodeOverride(1,"Ujwal")));
            System.out.println("\tmap1.get((EmployeeWithEquals) e2.clone()) - " +map1.get((EqualsOverride) e2.clone()));
            //Same Object used will return the corresponding data even if the Objects are clone of each other
        }

    }
}
