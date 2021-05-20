package entities.users;

public class Driver extends User{
    private double rating;
    private String carNumber;

    public double getRating() {
        return rating;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Driver() {
        super();
    }

    public Driver(String firstName, String lastName, Role role, String email, String password, String carNumber) {
        super( firstName, lastName, role, email, password);
        this.rating = 5.00;
        this.carNumber = carNumber;
    }
    public Driver(int id, int orders,String firstName, String lastName, Role role, String email, String password, double rating, String carNumber) {
        super(id, orders,  firstName, lastName, role, email, password);
        this.rating = rating;
        this.carNumber = carNumber;

    }

    @Override
    public String toString(){
        final StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(this.rating + "\n");
        sb.append(this.carNumber + "\n\n");
        return sb.toString();
    }

}
