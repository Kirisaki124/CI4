import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
//        System.out.print("Enter a number: ");
//        int number = keyboard.nextInt();
//        System.out.println(String.format("You just entered %d", number));
//
//
//        System.out.print("Enter a String: ");
//        String s = keyboard.next();
//        System.out.println(String.format("You just entered %s", s));


        // int, float, double, byte   ==
        // string, map                equal

//        for(int i = 0; i < 4; i++){
        while (true) {
            System.out.print("Enter a: ");
            int a = keyboard.nextInt();
            System.out.print("Enter b: ");
            int b = keyboard.nextInt();
            System.out.print("Enter +, -, *, /: ");
            String sign = keyboard.next();

            if (sign.equals("+")){
                System.out.println(a + b);
            }
            else if (sign.equals("-")){
                System.out.println(a - b);
            }
            else if (sign.equals("/")){
                System.out.println(a / b);
            }
            else if (sign.equals("*")){
                System.out.println(a * b);
            }
            else {
                System.out.println("Wrong input");
            }
        }
    }
}
