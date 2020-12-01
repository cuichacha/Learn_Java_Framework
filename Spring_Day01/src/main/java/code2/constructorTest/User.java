package code2.constructorTest;

public class User {
    private Integer id;
    private String name;
    private TheClass theClass;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheClass(TheClass theClass) {
        this.theClass = theClass;
    }

    public void method() {
        System.out.println(0);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public TheClass getTheClass() {
        return theClass;
    }
}
