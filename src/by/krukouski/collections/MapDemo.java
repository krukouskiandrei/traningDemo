package by.krukouski.collections;

import java.util.*;

public class MapDemo {

    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        hm.put("Сырок", 3);
        hm.put("Пряник", 5);
        hm.put("Молоко", 2);
        hm.put("Хлеб", 1);


        System.out.println(hm);
        hm.put("Пряник", 4);
        System.out.println(hm + "после замены элемента");

        Integer a = hm.get("Хлеб");
        System.out.println(a + " - найден по ключу 'Хлеб'");

        Set<Map.Entry<String, Integer>> setv = hm.entrySet();
        System.out.println(setv);
        Iterator<Map.Entry<String, Integer>> i = setv.iterator();

        while (i.hasNext()) {
            Map.Entry<String, Integer> me = i.next();
            System.out.println(me.getKey() + " : " + me.getValue());
        }

        Set<Integer> val = new HashSet<Integer>(hm.values());
        System.out.println(val);


        EnumMap<GASStation, Integer> station1 = new EnumMap<GASStation, Integer>(GASStation.class);
        station1.put(GASStation.DT, 10);
        station1.put(GASStation.A80, 5);
        station1.put(GASStation.A92, 30);
        EnumMap<GASStation, Integer> station2 = new EnumMap<GASStation, Integer>(GASStation.class);
        station2.put(GASStation.DT, 25);
        station2.put(GASStation.A95, 25);
        System.out.println(station1);
        System.out.println(station2);
    }

}

enum GASStation {
    DT(50), A80(30), A92(30), A95(50), GAS(40);
    private Integer maxVolume;

    GASStation (int maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Integer getMaxVolume() {
        return maxVolume;
    }
}