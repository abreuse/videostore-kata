package alexis.breuse;

public class MovieFactory {

    private final static int PRICE_CODE_REGULAR_MOVIE = 0;
    private final static int PRICE_CODE_NEW_RELEASE_MOVIE = 1;
    private final static int PRICE_CODE_CHILDREN_MOVIE = 2;

    public static Movie createRegularMovie(String title) {
        return new Movie(title, PRICE_CODE_REGULAR_MOVIE);
    }

    public static Movie createNewReleaseMovie(String title) {
        return new Movie(title, PRICE_CODE_NEW_RELEASE_MOVIE);
    }

    public static Movie createChildrenMovie(String title) {
        return new Movie(title, PRICE_CODE_CHILDREN_MOVIE);
    }
}
