package chapter12.item89;

public enum ElvisEnum {
    INSTANCE;

    private String[] favoriteSongs = { "Hound Dog", "Heartbreak Hotel" };

    public void printFavorites() {
        System.out.println(favoriteSongs);
    }
}
