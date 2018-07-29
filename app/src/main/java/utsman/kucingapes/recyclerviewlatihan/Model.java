package utsman.kucingapes.recyclerviewlatihan;

public class Model {

    private int id;
    private String title;
    private String favorite;

    public Model() {
    }

    public Model(int id, String title, String favorite) {
        this.id = id;
        this.title = title;
        this.favorite = favorite;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}