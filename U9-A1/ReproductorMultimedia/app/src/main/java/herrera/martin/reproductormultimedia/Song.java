package herrera.martin.reproductormultimedia;

public class Song {
    private long id;
    private String title;
    private String astist;

    public Song(long id, String title, String astist) {
        this.id = id;
        this.title = title;
        this.astist = astist;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAstist() {
        return astist;
    }

    public void setAstist(String astist) {
        this.astist = astist;
    }
}
