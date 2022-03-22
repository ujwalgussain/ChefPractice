package LargestCycle_DiameterProblem;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap {
    //=======================Using Access Order==================================================//
    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap(2, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > 2;
            }
        };
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        System.out.println(map);
        map.put(1, 1);
        System.out.println(map);
        System.out.println(map.entrySet().iterator().next());
    }

    //==========================================without Using Lib=================================================//
    class LRUCacheImplWithoutLib {
        LinkedHashMap<Integer, Integer> cache;
        int capacity;

        public LRUCacheImplWithoutLib(int capacity) {
            this.capacity = capacity;
            cache = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (cache.containsKey(key)) {
                int value = cache.get(key);
                cache.remove(key);
                cache.put(key, value);
                return value;
            }
            return -1;
        }

        public void put(int key, int value) {
            //If cache already has the key then
            if (cache.containsKey(key)) {
                cache.remove(key);
            }
            if (cache.size() == capacity) {
                int lastKey = (int) cache.keySet().toArray()[0];
                cache.remove(lastKey);
            }
            cache.put(key, value);
        }
    }
}
