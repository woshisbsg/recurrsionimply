import java.util.Scanner;

public class Main {
    static int targetRow = 0;
    static int targetColumn = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            targetRow = n;
            targetColumn = m;
            System.out.println(move(0,0));

        }
    }
    /*
    public static int move(int row, int column){
        if(row == 0 || column == 0){
            return 1;
        }

        int result = move(row - 1, column) + move(row, column - 1);
        return result;
    }

     */
    public static int move(int row, int column){
        if(row ==  targetRow|| column == targetColumn){
            return 1;
        }

        int result = move(row + 1, column) + move(row, column + 1);
        return result;
    }

}
