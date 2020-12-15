package code.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//@Component("student")
@Component
@ConfigurationProperties(prefix = "student")
public class Student {
    private String name;
    private Integer age;
    private boolean boss;
    private Date birth;
    private Map<String, Object> maps;
    private String[] arr;

    public Student() {
    }

    public Student(String name, Integer age, boolean boss, Date birth, Map<String, Object> maps, String[] arr) {
        this.name = name;
        this.age = age;
        this.boss = boss;
        this.birth = birth;
        this.maps = maps;
        this.arr = arr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public String[] getArr() {
        return arr;
    }

    public void setArr(String[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", arr=" + Arrays.toString(arr) +
                '}';
    }
}
