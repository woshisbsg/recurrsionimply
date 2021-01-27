import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int[] numbers = new int[4];
            int[] visited = new int[4];
            boolean result = false;
            for(int i = 0; i < 4; i++){
                numbers[i] = sc.nextInt();
            }
            for(int i = 0; i < 4; i++){
                visited[i] = 1;
                if(dfs(numbers, visited, numbers[i], 24)){
                    result = true;
                    break;
                }
                visited[i] = 0;
            }
            System.out.println(result);
        }
    }
    public static boolean dfs (int[] numbers, int[] visited, int currentResult, int target){
        boolean allVisited = true;
        for(int v : visited){
            if(v == 0){
                allVisited = false;
            }
        }
        if(allVisited){
            if(currentResult == target){
                return true;
            }
            else return false;

        }
        for(int i = 0; i < 4; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                if(dfs(numbers,visited,currentResult + numbers[i], target) ||
                        dfs(numbers,visited,currentResult - numbers[i], target) ||
                        dfs(numbers,visited,currentResult * numbers[i], target) ||
                        (currentResult % numbers[i] == 0 && dfs(numbers, visited, currentResult/numbers[i], target))){
                    return true;
                }
                visited[i] = 0;
            }
        }
        return false;
    }
}
