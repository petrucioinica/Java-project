package Users;

public class Client extends User{
        private String address;
        private String phoneNumber;

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client() {
        super();
    }

    public Client( String firstName, String lastName, int orders, Role role, String email, String password, String address, String phoneNumber) {
        super( firstName, lastName, orders, role, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
