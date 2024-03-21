import java.util.Arrays;
import java.util.Scanner;

class Nums implements Comparable<Nums>{
    int x;
    int idx;

    public Nums(int x, int idx){
        this.x = x;
        this.idx = idx;
    }

    @Override
    public int compareTo(Nums nums){
        return this.x- nums.x;
    }
}; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

       Nums[] nums = new Nums[n];

        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();

            nums[i] = new Nums(x, i+1);
        }

        Arrays.sort(nums);

        int[] numbers = new int[n+1];

        for(int i = 0 ; i < n ; i++)
            numbers[nums[i].idx] = i+1;
        

        for(int i = 0; i < n ; i++){
            System.out.print(numbers[i+1]+" ");
        }
    }
}