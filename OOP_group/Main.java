package OOP_group;

import OOP_group.Heroes.Archer;
import OOP_group.Heroes.Crossbowman;
import OOP_group.Heroes.Mag;
import OOP_group.Heroes.Monk;
import OOP_group.Heroes.Peasant;
import OOP_group.Heroes.Pikeman;
import OOP_group.Heroes.Robber;
import OOP_group.Heroes.Sniper;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, My Game !");

        Peasant Tom = new Peasant("Tom", 0);
        System.out.println(Tom.Endurance( 20));

        Archer Tim = new Archer("Tim", 50);
        System.out.println(Tim.StrikeLong(0, 20, 0));

        Robber Bill = new Robber("Bill", 40);
        Pikeman Rod = new Pikeman(null, 20);
        Crossbowman Mike = new Crossbowman(null, 0);
        Sniper Bom = new Sniper("Bom", 50);
        Monk John = new Monk("John", 10);
        Mag Raul = new Mag("Raul", 20);
    }
}
