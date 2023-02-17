package units;

public abstract class Priest extends BaseHero {
    private int magic;

    public Priest(String name, int hp, int def, int damag, int speed, int attack, int magic) {
        super(name, 30, 7, 12, 0, 0, 0, 5, 0);
        this.magic = 1;
    }

    @Override
    public String getInfo(){
        return "Priest" + name;
    }
    @Override
    public void step() {
        
    }
}
