import java.util.ArrayList;
import java.util.Scanner;

public class Main extends RuntimeException {
    static ArrayList<ArrayList<Integer>> path = new ArrayList<>();
    //ArrayList<ArrayList<Integer>> shortestPath = new ArrayList<>();

    public static void main(String[] args) {

        int[][] maze = {
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };


        /*
        Scanner sc = new Scanner(System.in);
        int rowNumber = sc.nextInt();
        int columnNumber = sc.nextInt();
        int[][] maze = new int[rowNumber][columnNumber];

        for(int i = 0; i < rowNumber; i++){
            for(int j = 0; j < columnNumber; j++){
                maze[i][j] = sc.nextInt();
            }
        }

         */

        boolean result = false;

        try{
            dfsMaze(0,0, maze);
        }
        catch (Exception e){
            result = true;
                System.out.println(path);
        }
        if(!result){
            System.out.println("No Result Found!");
        }
    }
    //只寻找一条路径，且记录下来。
    public static void dfsMaze(int x, int y, int[][] maze){
        //reach the destination
        if(x == maze.length - 1 && y == maze.length - 1){
            ArrayList<Integer> currentLocationIndex = new ArrayList<>();
            currentLocationIndex.add(x);
            currentLocationIndex.add(y);
            path.add(currentLocationIndex);
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new Main();
            //return;
        }
        //out of matrix bounds(upper and lower)
        if(x < 0 || y < 0 || x > maze.length - 1 || y > maze[0].length - 1){
            return;
        }
        //if hit a wall
        if(maze[x][y] == 1){
            return;
        }


        maze[x][y] = 1;
        ArrayList<Integer> currentLocationIndex = new ArrayList<>();
        currentLocationIndex.add(x);
        currentLocationIndex.add(y);
        path.add(currentLocationIndex);

        dfsMaze(x - 1, y, maze);
        dfsMaze(x + 1, y, maze);
        dfsMaze(x, y - 1, maze);
        dfsMaze(x, y + 1, maze);






    }
}
