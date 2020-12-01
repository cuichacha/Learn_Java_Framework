package code1.collectionTrial;

import java.util.*;

public class CollectionTrial {
    private int[] intArr;
    private ArrayList<String> arrayList;
    private HashSet<String> hashSet;
    private HashMap<String, String> hashMap;
    private Properties properties;

    public void setIntArr(int[] intArr) {
        this.intArr = intArr;
    }

    public void setArrayList(ArrayList<String> arrayList) {
        this.arrayList = arrayList;
    }

    public void setHashSet(HashSet<String> hashSet) {
        this.hashSet = hashSet;
    }

    public void setHashMap(HashMap<String, String> hashMap) {
        this.hashMap = hashMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void print() {
        System.out.println(Arrays.toString(intArr));
        System.out.println(arrayList);
        System.out.println(hashSet);
        System.out.println(hashMap);
        System.out.println(properties);
    }
}
