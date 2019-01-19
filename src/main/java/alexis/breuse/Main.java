package alexis.breuse;

public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer("Alfred");
        customer.addRental(new Rental(new Movie("The cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.statement();
    }
}
