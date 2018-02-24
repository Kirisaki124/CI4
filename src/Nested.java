import java.util.Scanner;
import java.util.Random;

public class Nested {
    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);
        Random rand = new Random();
// player static
        int damage = rand.nextInt(30);
//        System.out.println(String.format("%d", damage));
// direction
        int vx;
        int vy;
// turn
        int turn = 0;
// object
        //map
        int n = 5;
        int m = 5;

        //player
        int px = 0;
        int py = 0;

        //exit
        int ex = 4;
        int ey = 4;

        //item_buff
        int ix = 1;
        int iy = 1;
        boolean iv = false; //item visible
        int hasitem = 0;

        //monster
        int mx = 4;
        int my = 2;
        int mon = 0;
        int mon_health = 100;
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
            for (int y = 0; y < m; y++) {
                for (int x = 0; x < n; x++) {
                    if (x == px && y == py) {
                        System.out.print("P ");
                    } else if (x == ex && y == ey) {
                        System.out.print("E ");
                    } else if (x == wall_x[wall] && y == wall_y[wall]) {
                        System.out.print("W ");
                        if (wall < wall_x.length - 1)
                            wall++;
                    } else if (x == kx && y == ky && !key) {        // key == false     <=>     !key
                        System.out.print("K ");                  // key == true      <=>      key
                    } else if (x == mx && y == my && mon == 0) {
                        System.out.print("m ");
                    } else if (x == ix && y == iy && iv == false) {
                        System.out.print("# ");
                    } else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }


            // 1. Ask user which direction?
            System.out.print("Your move (W, A, S, D)? ");

            String direction = keyboardScanner.nextLine();

            // 2. Direction

            vx = 0;
            vy = 0;

            if (direction.equalsIgnoreCase("W")) {
                vy = -1;
            } else if (direction.equalsIgnoreCase("S")) {
                vy = 1;
            } else if (direction.equalsIgnoreCase("A")) {
                vx = -1;
            } else if (direction.equalsIgnoreCase("D")) {
                vx = 1;
            }

            px += vx;
            py += vy;

            for (int i = 0; i < wall_x.length; i++) {
                if (px == wall_x[i] && py == wall_y[i]) {
                    px -= vx;
                    py -= vy;
                }
            }

            // key
            if (px == kx && py == ky) {
                key = true;
                System.out.println("You picked up the key");
            }

            // item
            if (px == ix && py == iy){
                iv = true;
                System.out.println("You picked up an item");
                hasitem = 1;
            }


            if (px == ex && py == ey && key == true) {
                System.out.println("you win");
                break;
            } else if (px == ex && py == ey && key == false) {
                System.out.println("Pick up the key");
            }
            // Clamp
            if (py < 0) py = 0;
            if (py >= m) py = m - 1;

            if (px < 0) px = 0;
            if (px >= n) px = n - 1;

            if (px == mx && py == my && mon == 0) {
                System.out.println("You engage a monster");
                System.out.println("1. Attack");
                System.out.println("2. Run away");
                String attack = keyboardScanner.nextLine();
                damage = rand.nextInt(30);   //random damage

                if (attack.equalsIgnoreCase("1")) {
//                    System.out.println("Attacked");
                    if (hasitem == 1){
                        System.out.println("You have a buff item do you want to use it ?");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        String use_item = keyboardScanner.nextLine();
                        if (use_item.equalsIgnoreCase("1")){
                            hasitem = 0;
                            damage += 40;
                        }
                    }

                    mon_health -= damage;
                    if (mon_health < 0){
                        System.out.println("You killed the monster");
                        mon = 1;
                    }
                    else{
                        System.out.println(String.format("You deal %d damage to the monster", damage));
                        System.out.println(String.format("Now it has %d hp", mon_health));
                        px -= vx;
                        py -= vy;
                    }
                } else if (attack.equalsIgnoreCase("2")) {
                    System.out.println("Ran away");
                    px -= vx;
                    py -= vy;
                }

            }


        }

        }
    }

