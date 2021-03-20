package Users;

import Menus.Menu;

public class Restaurant extends User{
        private String name;
        private String address;
        private Double rating;
        private Menu menu;

        public Restaurant() {

        }

        public Restaurant(String firstName, String lastName, int orders, Role role, String email, String password, String name, String address, Double rating, Menu menu) {
                super(firstName, lastName, orders, role, email, password);
                this.name = name;
                this.address = address;
                this.rating = rating;
                this.menu = menu;
        }

        public String getName() {
                return name;
        }

        public String getAddress() {
                return address;
        }

        public Double getRating() {
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

        public void setRating(Double rating) {
                this.rating = rating;
        }

        public void setMenu(Menu menu) {
                this.menu = menu;
        }
}
