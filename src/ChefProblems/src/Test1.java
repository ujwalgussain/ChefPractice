package ChefProblems.src;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class Test1 {
    public static void main(String... a)
    {/*
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A","B","C"));
        Iterator<String> itr = list.iterator();
        while(itr.hasNext())
        {
            System.out.println(list);
            String s = itr.next();
            System.out.println("Deleting" + s);
            itr.remove();

        }
        System.out.println(list);*/
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("First", 10);
        map.put("Second", 20);
        map.put("Third", 30);
        map.put("Fourth", 40);

        Iterator<String> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            map.put("Fifth", 50);
            System.out.println("In loop " + key + " Map " + map);
            map.remove("Third");
            if(key.equals("First"))iterator.remove();

        }
        System.out.println(map);
    }
}
