package sg.edu.np.practical4;

public class User {
    private String name;
    private String description;
    private int id;
    private boolean follow;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFollow() {
        return follow;
    }

    public void setFollow(boolean follow) {
        this.follow = follow;
    }

    public User(String name, String description, int id, boolean follow) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.follow = follow;
    }
}
