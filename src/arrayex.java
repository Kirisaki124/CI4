import java.util.ArrayList;
import java.util.Arrays;

public class arrayex {
    public static void main(String[] args) {
        //Array
//        String[] badhabits = new String[]{
//                "Hoc ngoai troi",
//                "Xem mai nha hang xom",
//                "Xem phim trong gio",
//                "Mua cung doan voi co giao"
//        };

//        System.out.println(badhabits[0]);
//        for (int i = 0; i < (badhabits.length); i++) {
//            System.out.println(badhabits[i]);
//        }


//        for (String bad : badhabits) {
//            System.out.println(bad);
//        }

//        1. Upper case
//        for (int i = 0; i < badhabits.length; i++) {
//            System.out.println(badhabits[i].toUpperCase());
//        }

//        2. do dai < 22
//        for (int i = 0; i < badhabits.length; i++) {
//            int count = 0;
//            for (int j = 0; j < badhabits[i].length(); j++) {
//                if (Character.isLetter(badhabits[i].charAt(i)))
//                count++;
//            }
//            System.out.println(count);
//            for (String badhabit : badhabits) {
//                if (badhabit.length() < 22){
//                    System.out.println("yes");
//                }else{
//                    System.out.println("no");
//                }
//            }

        ArrayList<String> badHabits = new ArrayList<>();
        badHabits.add("Mua cung doan voi co giao");
        badHabits.add("Hoc ngoai troi");
        System.out.println(badHabits.get(0));
        badHabits.set(0, "Nhin tu cau thang len tren");
        System.out.println(badHabits);


//        }
    }
}
