import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, cnt = 0;

    public static boolean checkManySecond(int[] arr){
        int find = 0, cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != arr[0]){    
                find = arr[i];
                break;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(find == arr[i]){ 
                cnt++;
            }
        }
        if(cnt == 1)
            return false;
        else
            return true;

    }

    public static boolean checkAllSame(int[] arr){
        for(int i = 0 ; i < n-1 ; i++){
            if(arr[i] != arr[i+1])
                return false;
        }
        return true;
    }

    public static int returnSecond(int[] arr){
        int[] arr2 = new int[n];
        for(int i = 0 ; i < n ; i++)
            arr2[i] = arr[i];

        Arrays.sort(arr2);
        int find = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr2[i] != arr2[0]){    
                find = arr2[i];
                break;
            }
        }
        for(int i = 0 ; i < n ; i++){
            if(find == arr[i]){ 
                return i+1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int[] nums = new int[n];
        
        // 두번째로 작은 수가 없는 경우 = 모든 수가 같을 경우
        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();

        int[] nums2 = new int[n];
        for(int i = 0 ; i < n ; i++)
            nums2[i] = nums[i];

        Arrays.sort(nums2);
        
        if(checkAllSame(nums) || checkManySecond(nums2))
            System.out.print(-1);
        else
            System.out.print(returnSecond(nums));
        
    }
}