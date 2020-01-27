package OldProblems.src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

//Newgen interview Question
public class ComparartorWithTwoParametersImpl {
    class Employee{
        int id;
        String name;
        int sal;
        Employee(int id, String name, int sal)
        {
            this.id = id;this.sal=sal;this.name =name;
        }
        public String toString()
        {
            return "ID-"+id+" Name-"+name+" Sal-"+sal;
        }

    }
    static List<Employee> getEmployeesList(String s)
    {
        List<Employee> list = new ArrayList<>();
        String[] lines = s.split(Pattern.quote("|"));
        for(String line:lines)
        {
            String[] tokens = line.split(",");
            list.add(new ComparartorWithTwoParametersImpl().new Employee(Integer.parseInt(tokens[0]),tokens[1],Integer.parseInt(tokens[2])));
        }
        return list;
    }
    static public void main(String args[])
    {
        List<Employee> list = getEmployeesList("1,Rohit,1000|2,Prakash,2000|3,Rohit,4000|4,Shikhar,8000|5,Ramesh,4500");
        System.out.println(list);
        Collections.sort(list,(x,y)->{
            return (-x.name.compareToIgnoreCase(y.name)==0?-Integer.compare(x.sal,y.sal):-x.name.compareToIgnoreCase(y.name));
        });
        System.out.println(list);
    }
}
