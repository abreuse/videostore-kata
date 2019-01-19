package alexis.breuse;

import java.util.List;

public class StatementPrinter {

    private static StatementPrinter instance;

    private StatementPrinter() {
    }

    public static StatementPrinter getInstance() {
        if(instance == null)
            instance = new StatementPrinter();

        return instance;
    }

    public String getCustomerStatement(String name) {
        return "Rental Record for " + name + "\n";
    }

    public String getRentalsStatement(List<Rental> rentals) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "";

        for (Rental rental : rentals) {
            double thisAmount = 0;

            switch (rental.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented() - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result += "\t" + rental.getMovie().getTitle() + "\t"
                    + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }

        result += "You owed " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points \n";

        return result;
    }

}
