package Users;

import Menus.Menu;

public class Restaurant extends User{
        private String name;
        private String address;
        private double rating;
        private Menu menu;

        public Restaurant() {
                super();
        }

        public Restaurant(String firstName, String lastName, Role role, String email, String password, String name, String address, Menu menu) {
                super(firstName, lastName, role, email, password);
                this.name = name;
                this.address = address;
                this.rating = 5.00;
                this.menu = menu;
        }

        public String getName() {
                return name;
        }

        public String getAddress() {
                return address;
        }

        public double getRating() {
                return rating;
        }

        public Menu getMenu() {
                return menu;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        public void setRating(double rating) {
                this.rating = rating;
        }

        public void setMenu(Menu menu) {
                this.menu = menu;
        }

        @Override
        public String toString(){
                final StringBuilder sb = new StringBuilder();
                sb.append(super.toString());
                sb.append(this.name + "\n");
                sb.append(this.address + "\n");
                sb.append(this.rating + "\n\n");
                return sb.toString();
        }
}
