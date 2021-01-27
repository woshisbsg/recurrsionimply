import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int month = sc.nextInt();
            //System.out.println(Fib(10));
            /*
            int noobrabbit = Fib(month - 1);
            int youngrabbit = Fib(month - 2);
            int maturerabbit = noobrabbit;
            int result = noobrabbit + youngrabbit + maturerabbit;
            System.out.print(result);

             */
            System.out.println(Fib(month));

        }
    }

    public static int Fib(int index){
        int[] temp = new int[index + 1];
        temp[0] = 0;
        temp[1] = 1;
        for(int i = 2; i < index + 1; i++){
            temp[i] = temp[i-1] + temp[i-2];
        }
        return temp[index];
    }
}
