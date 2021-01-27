import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static  ArrayList<String> path = new ArrayList<>();
    static int counter = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String data = sc.nextLine();
            String[] arrData = data.split(" ");
            int[] input = new int[arrData.length];
            for(int i = 0; i < arrData.length; i++){
                if(arrData[i].equals("JOKER")|| arrData[i].equals("joker")){
                    System.out.println("ERROR");
                }
                if(arrData[i].equals("J")){
                    arrData[i] = "11";
                }
                else if(arrData[i].equals("Q")){
                    arrData[i] = "12";
                }
                else if(arrData[i].equals("K")){
                    arrData[i] = "13";
                }
                else if(arrData[i].equals("A")){
                    arrData[i] = "1";
                }
                input[i] = Integer.parseInt(arrData[i]);
            }
            int[] visited = new int[4];
            boolean result = false;
            int head = 0;

            for(int i = 0 ; i < 4; i++){
                visited[i] = 1;
                if(dfs(input, visited, input[i], 24, "")){
                    head = input[i];
                    result = true;
                    break;
                }
                path.clear();
                visited[i] = 0;
            }
            //System.out.println(result);

            if(result){
                path.remove(0);
                StringBuffer finalresult = new StringBuffer();
                StringBuffer temp = new StringBuffer();
                for(int i = 0; i < input.length; i++){
                    temp.append(input[i]);
                }


                for(int i = 0; i < 3; i++){
                    finalresult.append(input[i]);
                    finalresult.append(path.get(i));
                }
                finalresult.append(input[3]);
                System.out.println(finalresult);
            }
            else{
                System.out.println("NONE");
            }




        }
    }

    public static boolean dfs(int[] numbers, int[] visited, double currentResult, double target, String sign){
        boolean allVisited = true;
        path.add(sign);

        for(int i = 0; i < visited.length; i++){
            if(visited[i] == 0){
                allVisited = false;
            }
        }

        if(allVisited){
            if(currentResult == target){
                return true;
            }
            else {
                path.remove(path.size() - 1);
                return false;
            }
        }


        for(int i = 0; i < 4; i++){
            if(visited[i] == 0){
                visited[i] = 1;

                if(dfs(numbers, visited, currentResult + numbers[i], target, "+") ||
                        dfs(numbers, visited, currentResult - numbers[i], target, "-") ||
                        dfs(numbers,visited,currentResult * numbers[i], target, "*") ||
                        dfs(numbers, visited, currentResult / numbers[i], target, "/")){
                    if(path.size() != 0){
                        //System.out.println(path);
                    }
                    return true;
                }
                visited[i] = 0;
                if(path.size() != 1){
                    path.remove(path.size() - 1);
                }


            }
        }
        if(path.size() != 0){
            //System.out.println(path);
        }
        return false;
    }
}
