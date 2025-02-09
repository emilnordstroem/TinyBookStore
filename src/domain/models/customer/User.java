package domain.models.customer;

public abstract class User {
    protected static long userId = 100_001L;
    protected String password;

    public User(String password) {
        userId += 1;
        this.password = password;
    }
}
