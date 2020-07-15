package JavaInterviewQuestionsImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
* Problem Statement:
*   Sort the List of Persons by lastName and then Firstname ie., if lastname is equal then first name
*   If lastName/firstname is null it should come first*/
public class Comparator_With_Nulls_First {
    String firstName,lastName;

    Comparator_With_Nulls_First()
    {
        //always create for avoiding errors in Inheritance
    }

    Comparator_With_Nulls_First(String a,String b)
    {
        firstName=a;
        lastName=b;

    }

    @Override
    public String toString() {
        return String.format("%s %s",firstName,lastName);
    }

    public static void main(String[] args) {
        List<Comparator_With_Nulls_First> list=new ArrayList<>();
        Comparator_With_Nulls_First s1 = new Comparator_With_Nulls_First("Adarsh",null);
        Comparator_With_Nulls_First s2 = new Comparator_With_Nulls_First("Rajesh","Kumar");
        Comparator_With_Nulls_First s3 = new Comparator_With_Nulls_First("Dinesh","Kumar");
        Comparator_With_Nulls_First s4 = new Comparator_With_Nulls_First("Archana","Shah");
        Comparator_With_Nulls_First s5 = new Comparator_With_Nulls_First(null,"Shah");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(null);
        list.add(new Comparator_With_Nulls_First());
        /*
         * Comparator.nullsFirst()/Comparator.nullsLast() will handle null objects in the list and not objects with null firstname/lastName*/
        Collections.sort(list, Comparator.nullsFirst(new Comparator<Comparator_With_Nulls_First>() {
            @Override
            public int compare(Comparator_With_Nulls_First o1, Comparator_With_Nulls_First o2) {
                /*Handle null FirstName/lastName*/
                if(o1.lastName==null&& o2.lastName!=null)
                    return -1;
                if(o2.lastName==null && o1.lastName!=null)
                    return 1;
                if((o1.lastName==null &&o2.lastName==null )||o1.lastName.equals(o2.lastName)){
                    if(o1.firstName==null && o2.firstName==null)
                        return 0;
                    if(o1.firstName==null)
                    {
                        return -1;
                    }
                    if(o2.firstName==null)
                    {
                        return 1;
                    }
                    return o1.firstName.compareTo(o2.lastName);
                }

                return o1.lastName.compareTo(o2.lastName);
            }
        }));
        System.out.println(list);


    }
}
