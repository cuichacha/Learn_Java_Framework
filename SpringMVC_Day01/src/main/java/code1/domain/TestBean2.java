package code1.domain;

public class TestBean2 {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "TestBean2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
