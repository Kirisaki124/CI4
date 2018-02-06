import java.util.Scanner;

public class BTVN {
    public static void main(String[] args) {
        System.out.println("Enter width: ");

        Scanner scanner = new Scanner(System.in);
        int width = scanner.nextInt();
        System.out.println("Enter height: ");
        int height = scanner.nextInt();
        int x = 0 , y = 0;
        while (true){
            // Print map
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (i == x && j == y){
                        System.out.print("P");
                    }
                    else {
                        System.out.print('*');
                    }
                }
                System.out.println();
            }

            //
            // Get input
            char choice = scanner.next().charAt(0);
    //        System.out.println(choice);
            if (x >= 0 && x <= width && y >= 0 && y <= height) {
                switch (choice) {
                    case 'w':
                        x--;
                        //                System.out.println(x);
                        break;
                    case 'a':
                        y--;
                        //                System.out.println(y);
                        break;
                    case 'd':
                        y++;
                        //                System.out.println(y);
                        break;
                    case 's':
                        x++;
                        //                System.out.println(x);
                        break;
                }
            }else{
                System.out.println("You just went out of the map and never come back");
            }
        }
    }
}
