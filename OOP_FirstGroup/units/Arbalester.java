package units;

public class Arbalester extends Shooter {

    public Arbalester(String heroID) {
        super(name, 5, 15, 15, 50);
    }
    @Override
    public String getInfo() {
        return "Арбалетчик " + heroID;
    }
}
