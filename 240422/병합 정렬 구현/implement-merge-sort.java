import java.util.Scanner;

public class Main {
    public static int n = 0;
    public static int[] nums = new int[100000];

    public static void merge_sort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            merge_sort(arr, low, mid);
            merge_sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high){
        int[] merged_arr = new int[n];
        int k = low, i = low, j = mid+1;

        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                merged_arr[k] = arr[i];
                k++; i++;
            }
            else{
                merged_arr[k] = arr[j];
                k++; j++;
            }  
        }
        while(i <= mid){
            merged_arr[k] = arr[i];
            k++; i++; 
        }
        while(j <= high){
            merged_arr[k] = arr[j];
            k++; j++; 
        }
        for(k = low ; k <= high ; k++)
            nums[k] = merged_arr[k];
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();
        
        merge_sort(nums, 0, n-1);

        for(int i = 0 ; i < n ; i++)
            System.out.print(nums[i]+" ");
    }
}