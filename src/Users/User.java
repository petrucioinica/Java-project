package Users;

public class User {
    private static int count = 0;
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private int orders;
    private Role role;
    private String password;

    public User() {
            this.id = count+1;
            setCount(count+1);

    }

    public User( String firstName, String lastName, int orders, Role role, String email, String password) {
        this.id = count+1;
        setCount(count+1);
        this.firstName = firstName;
        this.lastName = lastName;
        this.orders = orders;
        this.role = role;
        this.email = email;
        this.password = password;
    }


    public static void setCount(int count) {
        User.count = count;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getOrders() {
        return orders;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
