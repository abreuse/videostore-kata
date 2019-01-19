package alexis.breuse;

public class MovieFactory {

    public static Movie createRegularMovie(String title) {
        return new Movie(title, 0);
    }

    public static Movie createNewReleaseMovie(String title) {
        return new Movie(title, 1);
    }

    public static Movie createChildrenMovie(String title) {
        return new Movie(title, 2);
    }
}
