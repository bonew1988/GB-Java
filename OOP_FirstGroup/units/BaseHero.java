package units;

public abstract class BaseHero implements Interf {
    protected String name;
    protected int hp;
    protected int def;
    protected int damag;
    protected int shot;
    protected int speed;
    protected int delivery;
    protected int attack;
    protected int magic;

    public BaseHero(String name, int hp, int def, int damag, int shot, int speed, int delivery, int attack, int magic) {
        this.name = name;
        this.hp = hp;
        this.def = def;
        this.damag = damag;
        this.shot = shot;
        this.speed = speed;
        this.delivery = delivery;
        this.attack = attack;
        this.magic = magic;
    }

    public int Ataka(int hp, int def, int damag) {
        hp = hp + def - damag;
        return hp;
    }

    public int healing(int hp, int healing) {
        hp = hp * 120 / 100;
        return hp;
    }

}