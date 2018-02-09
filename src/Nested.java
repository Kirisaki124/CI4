import java.util.Scanner;
import java.util.Random;

public class Nested {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);
        Random rand = new Random();

// object
        int n = 5;
        int m = 5;

        int px = 0;
        int py = 0;

        int ex = 4;
        int ey = 4;

        int mx = 4;
        int my = 2;
        int mon = 0;
// wall

        int wall_x[] = {2, 2, 2, 3};
        int wall_y[] = {0, 1, 2, 2};

//      generate random key (maybe the key is inside the wall, under the player or the exit)
//        int kx = rand.nextInt(5);
//        int ky = rand.nextInt(4);

        int kx = 4;
        int ky = 0;

        boolean key = false;

        while(true) {
            int wall = 0;

            // view
            for (int y = 0; y < m; y ++) {
                for (int x = 0; x < n; x++) {
                    if (x == px && y == py) {
                        System.out.print("P ");
                    }
                    else if (x == ex && y == ey){
                        System.out.print("E ");
                    }
                    else if (x == wall_x[wall] && y == wall_y[wall]){
                        System.out.print("W ");
                        if (wall < wall_x.length - 1)
                            wall++;
                    }
                    else if (x == kx && y == ky && !key){        // key == false     <=>     !key
                        System.out.print("K ");                  // key == true      <=>      key
                    }
                    else if (x == mx && y == my && mon == 0){
                        System.out.print("m ");
                    }
                    else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }



            // 1. Ask user which direction?
            System.out.print("Your move (W, A, S, D)? ");

            String direction = keyboardScanner.nextLine();

            // 2. Direction => update x, y

            if (direction.equalsIgnoreCase("W")) {
                py--;
            } else if (direction.equalsIgnoreCase("S")) {
                py++;
            } else if (direction.equalsIgnoreCase("A")) {
                px--;
            } else if (direction.equalsIgnoreCase("D")) {
                px++;
            }

            int collide = 0;

            for (int i = 0; i < wall_x.length; i++) {
                if (px == wall_x[i] && py == wall_y[i]){
                    collide = 1;
                }
            }

            if (collide == 1)
                if (direction.equalsIgnoreCase("W")) {
                    py++;
                }
                else if(direction.equalsIgnoreCase("S")) {
                    py--;
                }
                else if(direction.equalsIgnoreCase("A")) {
                    px++;
                }
                else if(direction.equalsIgnoreCase("D")) {
                    px--;
                }
            // test

            if (px == kx && py == ky) {
                key = true;
                System.out.println("You picked up the key");
            }


            //Key

            if (px == ex && py == ey && key == true) {
                System.out.println("you win");
                break;
            }else if (px == ex && py == ey && key == false) {
                System.out.println("Pick up the key");
            }
            // Clamp
            if (py < 0) py = 0;
            if (py >= m) py = m - 1;

            if (px < 0) px = 0;
            if (px >= n) px = n-1;


            if (px == mx && py == my && mon == 0){
                System.out.println("You engage a monster");
                System.out.println("1. Attack");
                System.out.println("2. Run away");
                String attack = keyboardScanner.nextLine();
                if (attack.equalsIgnoreCase("1")){
                    System.out.println("Attacked");
                    mon = 1;
                }
                else if (attack.equalsIgnoreCase("2")){
                    System.out.println("Ran away");
                    if (direction.equalsIgnoreCase("W")) {
                        py++;
                    }
                    else if(direction.equalsIgnoreCase("S")) {
                        py--;
                    }
                    else if(direction.equalsIgnoreCase("A")) {
                        px++;
                    }
                    else if(direction.equalsIgnoreCase("D")) {
                        px--;
                    }
                }

            }
            // 3. Re-print map
            
            }
        }
    }

