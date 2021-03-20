package Users;

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

    public Driver(String firstName, String lastName, int orders, Role role, String email, String password, double rating, String carNumber) {
        super( firstName, lastName, orders, role, email, password);
        this.rating = rating;
        this.carNumber = carNumber;
    }
}
