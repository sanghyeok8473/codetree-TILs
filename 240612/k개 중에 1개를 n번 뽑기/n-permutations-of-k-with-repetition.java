import java.util.*;

public class Main {
    public static int n, k;
    public static ArrayList<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt(); n = sc.nextInt();
        answer = new ArrayList<>();

        choose(1);
    }

    public static void choose(int currNum){
        if(answer.size() == n){
            print();
            return;
        }

        for(int i = 1 ; i <= k ; i++){
            answer.add(i);
            choose(i);
            answer.remove(answer.size()-1);
        }
    }

    public static void print(){
        for(int i = 0 ; i < answer.size() ; i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }
}