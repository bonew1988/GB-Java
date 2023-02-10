package OOP;

import OOP.Units.Villager;

public class Game {
    public static void main(String[] args) {

        Villager John = new Villager("John", 10, 15, 20);
        System.out.println(John.Attack(100, 1001, 50));

    }
}