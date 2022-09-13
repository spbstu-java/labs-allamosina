package Lab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainGame {
    public static void main(String[] args) throws IOException {
        Hero hero = new Hero();
        String cl = "";
        while (!cl.equalsIgnoreCase("exit")) {
            System.out.print("Enter how you want to travel: 'walk', 'ride' or 'sail' \n" +
                    "Enter 'exit' to finish the game \n");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            cl = reader.readLine();
            switch (cl.toLowerCase()) {
                case ("walk"):
                    hero.setMoveStrategy(new MoveByFoot());
                    hero.move();
                    break;
                case ("ride"):
                    hero.setMoveStrategy(new MoveByHorse());
                    hero.move();
                    break;
                case ("sail"):
                    hero.setMoveStrategy(new MoveByShip());
                    hero.move();
                    break;
                case ("exit"):
                    System.out.println("Finishing the game!");
                    break;
                default:
                    System.out.println("No such type of transportation!");
                    break;
            }
        }
    }
}

