import alexis.breuse.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VideoStoreTest {

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer("Fred");
    }

    @Test
    public void should_add_one_new_release_movie(){
        customer.addRental(new Rental(MovieFactory.createNewReleaseMovie("The cell"), 3));

        Assert.assertEquals("Rental Record for Fred\n" +
                        "\tThe cell\t9.0\n" +
                        "You owed 9.0\n" +
                        "You earned 2 frequent renter points \n",
                customer.statement());
    }

    @Test
    public void should_add_two_new_release_movies() {
        customer.addRental(new Rental(MovieFactory.createNewReleaseMovie("The cell"), 3));
        customer.addRental(new Rental(MovieFactory.createNewReleaseMovie("The Tigger Movie"), 3));

        Assert.assertEquals("Rental Record for Fred\n" +
                "\tThe cell\t9.0\n" +
                "\tThe Tigger Movie\t9.0\n" +
                "You owed 18.0\n" +
                "You earned 4 frequent renter points \n",
                customer.statement());
    }

    @Test
    public void should_add_one_children_movie() {
        customer.addRental(new Rental(MovieFactory.createChildrenMovie("The Tigger Movie"), 3));

        Assert.assertEquals("Rental Record for Fred\n" +
                        "\tThe Tigger Movie\t1.5\n" +
                        "You owed 1.5\n" +
                        "You earned 1 frequent renter points \n",
                customer.statement());

    }

    @Test
    public void should_add_three_regular_movies() {
        customer.addRental(new Rental(MovieFactory.createRegularMovie("Plan 9 from Outer Space"), 1));
        customer.addRental(new Rental(MovieFactory.createRegularMovie("8 1/2"), 2));
        customer.addRental(new Rental(MovieFactory.createRegularMovie("Eraserhead"), 3));

        Assert.assertEquals("Rental Record for Fred\n" +
                "\tPlan 9 from Outer Space\t2.0\n" +
                "\t8 1/2\t2.0\n" +
                "\tEraserhead\t3.5\n" +
                "You owed 7.5\n" +
                "You earned 3 frequent renter points \n",
                customer.statement());
    }
}