import java.util.Scanner;

/**
 * Created by huynq on 2/3/18.
 */
public class n1 {

    public static void main(String[] args) {
        Scanner keyboardScanner = new Scanner(System.in);

        int n = 5;
        int m = 4;

        int px = 3;
        int py = 1;

        int ex = 3;
        int ey = 3;

        int kx = 0;
        int ky = 3;

        int wx = 3;
        int wy = 2;

        int vx = 0;
        int vy = 0;

        boolean hasKey = false;


        while (true) {
            for (int y = 0; y < m; y ++) {
                for (int x = 0; x < n; x++) {
                    if (x == px && y == py) {
                        System.out.print("P ");
                    }
                    else if (x == kx && y == ky && !hasKey) {
                        System.out.print("K ");
                    }
                    else if (x == wx && y == wy) {
                        System.out.print("W ");
                    }
                    else if (x == ex && y == ey) {
                        System.out.print("E ");
                    }
                    else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }

            System.out.print("Your move? ");
            String command = keyboardScanner.nextLine();

            vx = 0;
            vy = 0;

            if (command.equalsIgnoreCase("w")) {
//                py--;
                vy = -1;
            }
            else if(command.equalsIgnoreCase("s")) {
//                py++;
                vy = 1;
            }
            else if(command.equalsIgnoreCase("a")) {
//                px--;
                vx = -1;
            }
            else if(command.equalsIgnoreCase("d")) {
//                px++;
                vx = 1;
            }

            px += vx;
            py += vy;

            if (px < 0) px = 0;
            if (px >= n) px = n - 1;
            if (py < 0) py = 0;
            if (py >= m) py = m - 1;

            if (px == wx && py == wy){
                px -= vx;
                py -= vy;
            }

            if (px == kx && py == ky) {
                System.out.println("You got the key");
                hasKey = true;
            }

            if (px == ex && py == ey) {
                if (!hasKey) {
                    System.out.println("Get the key dude!");
                } else {
                    System.out.println("You won");
                    break;
                }
            }
        }
    }
}