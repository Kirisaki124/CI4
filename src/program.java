public class program {
    public static void main(String[] args){
        System.out.println("Hello world");
        System.out.println("Hello CI3");
//  1. Varribles
        int a = 5, b = 7, c = a + b;
        System.out.println(b);
        System.out.println(a);
        System.out.println(c);
        System.out.println(b%a);
//  File path
//  String formating
//        String s = "HqwerEqwG123.gr,3";
//        String d = "1231231234";
//        System.out.println(s);
//        System.out.println(d);
//
//
//        System.out.println(s + d);
//
//
//        System.out.print(s);
//        System.out.print(",");
//        System.out.print(d);
//
//        Bad
        System.out.println("a = " + a + ", " + "b = " + b + ", " + "c = " + c + ", ");
//
//        Better
        String output = String.format("a = %d, b = %d, c = %d", a, b, c);
        System.out.println(output);

//        Even better
        System.out.println(String.format("a = %d, b = %d, c = %d", a, b, c));
    }
}
