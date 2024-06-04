package finalProject;

public class PlayerName { //Player Name field from Initial Frame
    private static PlayerName instance;
    private String name;

    private PlayerName() {}

    public static PlayerName getInstance() {
        if (instance == null) {
            instance = new PlayerName();
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
