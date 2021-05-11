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

    public Client( String firstName, String lastName, Role role, String email, String password, String address, String phoneNumber) {
        super( firstName, lastName, role, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Client( int id, int orders, String firstName, String lastName, Role role, String email, String password, String address, String phoneNumber) {
        super(id, orders,firstName, lastName, role, email, password);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(this.address + "\n");
        sb.append(this.phoneNumber + "\n");
        return sb.toString();
    }



}
