package MirrorImageImpl;

import java.util.*;

public class MirrorImageImpl {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();sc.nextLine();
        HashMap<String, List<String>> inputNodeMap = new HashMap<>();

        while(--N>=1)
        {
            String input = sc.nextLine();
            String tokens[] = input.split("\\s");
            List<String> list = inputNodeMap.containsKey(tokens[0])?inputNodeMap.get(tokens[0]):new ArrayList<>();
            list.add(tokens[1]+" " + tokens[2]);
            inputNodeMap.put(tokens[0],list);
        }
        String q[] = new String[Q];
        for(int i=0;i<Q;i++)
            q[i] = sc.next();
        // System.out.println(inputNodeMap);
        HashMap<String,String> queryMap = new HashMap<>();
        HashMap<String,String> mirror_queryMap = new HashMap<>();
        createMap(inputNodeMap,"1","",queryMap,mirror_queryMap);
        System.out.println(queryMap + "\n" + mirror_queryMap);
        for(int i=0;i<Q;i++)
        {
            if(q[i].equals("1"))
            {
                System.out.println("1");
            }
            //System.out.println(q[i]);
            if(!mirror_queryMap.containsKey(q[i])){
                System.out.println("-1");
                continue;
            }
            String res = queryMap.get(getMirrorKey(mirror_queryMap.get(q[i])));
            System.out.println(res==null?-1:res);
        }

    }
    static String getMirrorKey(String s)
    {
        String res="";
        for(int i=0;i<s.length();i++)
            res+=((s.charAt(i)=='L')?'R':'L');
        return res;
    }
    static void createMap(Map<String,List<String>> map, String node, String pre, Map<String,String> resmap, Map<String,String> mirror_resmap)
    {
        if(!map.containsKey(node))
        {
            return;
        }
        List<String> values = map.get(node);
        //resmap.put(pre+,node)
        for (String value:values)
        {
            String[] tokens = value.split("\\s");
            createMap(map,tokens[0],pre+tokens[1],resmap,mirror_resmap);
            resmap.put(pre+tokens[1],tokens[0]);
            mirror_resmap.put(tokens[0],pre+tokens[1]);
        }
    }
}
