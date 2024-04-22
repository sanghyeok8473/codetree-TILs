import java.util.Scanner;

public class Main {
    public static int n = 0, tmp = 0;
    public static int[] nums = new int[100000];

    public static void quick_sort(int low, int high){
        if(low < high){
            int pos = partition(low, high);

            quick_sort(low, pos-1);
            quick_sort(pos+1, high);
        }
    }

    public static int partition(int low, int high){
        int pivot = nums[high];
        int i = low - 1;

        for(int j = low ; j <= high-1 ; j++){
            if(nums[j] < pivot){
                i++;
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        tmp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = tmp;
        
        return i+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();
        
        quick_sort(0, n-1);

        for(int i = 0 ; i < n ; i++)
            System.out.print(nums[i]+" ");
    }
}