package wybory;

public class Parties {
    private String name;

    public Parties(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Parties setName(String name) {
        this.name = name;
        return this;
    }
}
