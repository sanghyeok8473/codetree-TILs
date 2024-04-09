import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, cnt = 0;

    public static boolean checkManySecond(int[] arr){
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != arr[0]){     // 두 번째로 작은 값이 시작되는 위치를 찾음.
                if(i == n-1)
                    return false;       // 정렬 후 1 1 1 1 4 이면 두 번째 값은 하나인 경우임.
                if(arr[i] == arr[i+1]){     // sort를 했으므로 두번째 값 다음값도 두번째 값이면 두개이상 있는거임.
                    return true;
                }
            }
        }
        return false;

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
        
        if(checkAllSame(nums2) || checkManySecond(nums2))
            System.out.print(-1);
        else
            System.out.print(returnSecond(nums));
        
    }
}