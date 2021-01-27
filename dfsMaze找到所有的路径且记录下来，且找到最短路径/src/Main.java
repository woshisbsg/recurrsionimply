import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    static ArrayList<ArrayList<Integer>> currentPath = new ArrayList<>();
    static ArrayList<ArrayList<ArrayList<Integer>>> pathCombination = new ArrayList<>();
    public static void main(String[] args) {
        /*
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

         */
        Scanner sc = new Scanner(System.in);
        int rowNumber = sc.nextInt();
        int columnNumber = sc.nextInt();
        int[][] maze = new int[rowNumber][columnNumber];

        for(int i = 0; i < rowNumber; i++){
            for(int j = 0; j < columnNumber; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        dfsMaze(0,0, maze);
        //System.out.println(currentPath);
        System.out.println(pathCombination);
        int counter = 1;
        System.out.println("所有的可选路径： ");
        Iterator iterator = pathCombination.iterator();
        while(iterator.hasNext()){
            ArrayList<ArrayList<Integer>> temp = (ArrayList<ArrayList<Integer>>) iterator.next();
            System.out.println(counter + " : ");
            for(ArrayList<Integer> al : temp){
                System.out.print(al);
            }
            counter++;
            System.out.println();
        }
        int len = 0;
        int min = pathCombination.get(0).size() + 1;
        ArrayList<ArrayList<Integer>> shortestPath = new ArrayList<>();
        for(ArrayList<ArrayList<Integer>> al : pathCombination){
            len = al.size();
            if(len < min){
                min = len;
                shortestPath = (ArrayList<ArrayList<Integer>>) al.clone();
            }
        }
        System.out.println("最短路径是： ");
        System.out.println(shortestPath);
        System.out.println("长度为： " + min);

    }
    public static void dfsMaze(int x, int y, int[][] maze){
        //if reach the final destination
        if(x == maze.length - 1 && y == maze[0].length - 1){
            ArrayList<Integer> currentLocation = new ArrayList<>();
            currentLocation.add(x);
            currentLocation.add(y);
            currentPath.add(currentLocation);
            pathCombination.add(currentPath);
            return;
        }
        //if reach the boundary of matrix
        if(x < 0 || y < 0 || x > maze.length - 1 || y > maze[0].length - 1){
            return;
        }
        //if hit a wall
        if(maze[x][y] == 1){
            return;
        }
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        temp = (ArrayList<ArrayList<Integer>>) currentPath.clone();
        ArrayList<Integer> currentLocation = new ArrayList<>();
        currentLocation.add(x);
        currentLocation.add(y);
        currentPath.add(currentLocation);
        maze[x][y] = 1;
        dfsMaze(x - 1, y, maze);
        dfsMaze(x + 1, y, maze);
        dfsMaze(x, y - 1, maze);
        dfsMaze(x, y + 1, maze);
        maze[x][y] = 0;
        currentPath = (ArrayList<ArrayList<Integer>>) temp.clone();
    }

}
