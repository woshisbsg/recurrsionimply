import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int numberOfApple = sc.nextInt();
            int numberOfPlate = sc.nextInt();
            System.out.println(count(numberOfApple, numberOfPlate));

        }
    }
    public static int count(int numberOfApple, int numberOfPlate){
        if(numberOfApple < 0 || numberOfPlate == 0){
            return 0;
        }
        if(numberOfApple == 1 || numberOfPlate == 1 || numberOfApple == 0){
            return 1;
        }
        return count(numberOfApple, numberOfPlate - 1) + count(numberOfApple - numberOfPlate, numberOfPlate);

    }
}
