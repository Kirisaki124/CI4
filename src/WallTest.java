import java.util.ArrayList;

public class WallTest {
    public static void main(String[] args) {
        //1. Arraylist toan wall
        ArrayList<Wall> walls = new ArrayList<>();

        //2. Create wall

        //3. add
        walls.add(new Wall(1,2));
        walls.add(new Wall(3,4));

        Wall temp = walls.get(0);
        if (temp.match(2,2)){
            System.out.println("block");
        }

        System.out.println(walls);
//        System.out.println(newWall);
    }
}
