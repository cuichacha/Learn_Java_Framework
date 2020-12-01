package code2.constructorTest;

public class Person {
    private Integer id;
    private String name;
    private TheClass theClass;

    public Person(Integer id, String name, TheClass theClass) {
        this.id = id;
        this.name = name;
        this.theClass = theClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TheClass getTheClass() {
        return theClass;
    }

    public void setTheClass(TheClass theClass) {
        this.theClass = theClass;
    }
}
