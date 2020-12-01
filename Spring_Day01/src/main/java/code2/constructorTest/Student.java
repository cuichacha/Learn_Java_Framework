package code2.constructorTest;

public class Student {
    private Integer id;
    private String name;
    private TheClass theClass;

    public Student(Integer id, String name, TheClass theClass) {
        this.id = id;
        this.name = name;
        this.theClass = theClass;
    }
}
