package alexis.breuse;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;

    private List<Rental> rentals;

    public Customer(String name) {
        this.name = name;
        this.rentals = new ArrayList<Rental>();
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        StatementPrinter statementPrinter = StatementPrinter.getInstance();

       String statement = statementPrinter.getCustomerStatement(this.name);
       statement += statementPrinter.getRentalsStatement(this.rentals);

       return statement;
    }
}

