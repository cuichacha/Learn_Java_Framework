package code2.constructorTest;

public class UserFactory1 {
    public static User createUser() {
        System.out.println(111);
        return new User();
    }
}
