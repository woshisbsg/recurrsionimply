import java.util.ArrayList;
public class Main {
    static ArrayList<ArrayList<String>> resultCombination = new ArrayList<>();
    static ArrayList<String> currentCombination = new ArrayList<>();
    public static void main(String[] args) {
        String[] num = new String[]{"A", "B","C","D"};
        System.out.println(permuteUnique(num));
    }
    public static ArrayList<ArrayList<String>> permuteUnique(String[] num) {
        ArrayList<String> data = new ArrayList<>();
        for(int i = 0; i < num.length; i++){
            data.add(num[i]);
        }
        for(int i = 0; i < data.size(); i++) {
            dfs(data, i);
        }
        System.out.println(resultCombination.size());
        return resultCombination;
    }
    public static void dfs(ArrayList<String> num, int currentIndex ){
        //结束条件
        if(currentIndex >= num.size()){
            return;
        }

        ArrayList<String> backtracking = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        backtracking = (ArrayList<String>) currentCombination.clone();
        currentCombination.add(num.get(currentIndex));
        temp = (ArrayList<String>) currentCombination.clone();
        resultCombination.add(temp);
        for(int i = 1; i <= num.size() - currentIndex; i++) {
            dfs(num, currentIndex + i);
        }
        //下面两句话二选一，都是用来做回溯的
        //currentCombination = (ArrayList<String>) backtracking.clone();
        currentCombination.remove(currentCombination.size() - 1);
    }
}
