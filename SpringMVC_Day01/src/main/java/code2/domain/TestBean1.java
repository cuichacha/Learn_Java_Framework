package code2.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class TestBean1 {
    private String str;
    private Integer num;
    private int[] intArr;
    private List<String> list;
    private Map<String, String> map;
    private TestBean2 testBean2;
    private List<TestBean2> testBean2List;
    private Map<String, TestBean2> testBean2Map;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public int[] getIntArr() {
        return intArr;
    }

    public void setIntArr(int[] intArr) {
        this.intArr = intArr;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public TestBean2 getTestBean2() {
        return testBean2;
    }

    public void setTestBean2(TestBean2 testBean2) {
        this.testBean2 = testBean2;
    }

    public List<TestBean2> getTestBean2List() {
        return testBean2List;
    }

    public void setTestBean2List(List<TestBean2> testBean2List) {
        this.testBean2List = testBean2List;
    }

    public Map<String, TestBean2> getTestBean2Map() {
        return testBean2Map;
    }

    public void setTestBean2Map(Map<String, TestBean2> testBean2Map) {
        this.testBean2Map = testBean2Map;
    }

    @Override
    public String toString() {
        return "TestBean1{" +
                "str='" + str + '\'' +
                ", num=" + num +
                ", intArr=" + Arrays.toString(intArr) +
                ", list=" + list +
                ", map=" + map +
                ", testBean2=" + testBean2 +
                ", testBean2List=" + testBean2List +
                ", testBean2Map=" + testBean2Map +
                '}';
    }
}
