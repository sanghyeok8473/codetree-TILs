import java.util.Scanner;

public class Main {
    public static int n;
    public static int[] sums = new int[1000];
    public static int[] nums = new int[1001];

    // 해결 아이디어 : 1부터 n까지의 숫자를 무작위로 배치한 배열이 sums 조건을 만족하는지 계속 체크
    // 사전순으로 가장 앞선 수열을 출력하므로 사전 순으로 가장 먼저 오는 수부터 시작해서 비교하는 조건
    // 무작위로 배치한다는 것이 굉장히 힘듬. 따라서 n을 받으면, 1부터 n까지 순서대로 들어가있는 배열을 하나 만들고,
    // 사전순을 기준으로 한칸 뒤에 있는 배열을 만들고, 이 배열이 성립하면 끝.

    public static void next(){
        int idx = n-1;
        while(true){
            if(nums[idx] != 9){
                nums[idx]++;
                break;
            }
            else{
                nums[idx] = 0;
                idx--;
            }
            if(idx == 0){
                nums[idx]++;
                break;
            }
        }
    }

    public static boolean isRightArray(int[] arr){  // 받은 배열이 1부터 n까지 한 번씬만 있는 배열인지 확인해주는 함수.
        for(int i = 0 ; i < n ; i++){
            if(arr[i] < 1 || arr[i] > n) // 1보다 작거나 n보다 큰 수가 있으면 반드시 false임.
                return false;
        }
        for(int i = 0 ; i < n - 1 ; i++){       // 여기까지 왔으면 모든 수가 1에서 n사이 이긴 함. 그러나 중복되면 안됨.
            for(int j = i+1 ; j < n ; j++){ 
                if(arr[i] == arr[j])
                    return false;
            }
        }
        return true;                            // 모든 수가 1이상 n이하이면서 중복되는 수가 없으면, 1부터 n까지 한번씩만 등장한다는 뜻임.
    }

    public static boolean sumAns(int[] arr){
        for(int i = 0 ; i < n-1 ; i++){
            if(sums[i] != (arr[i]+arr[i+1]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n-1 ; i++)
            sums[i] = sc.nextInt();                         // 처음 입력받는 인접한 수 끼리의 합
        
        for(int i = 0 ; i < n ; i++)
            nums[i] = i+1;                                  // 1부터 n까지의 수를 사전순으로 했을 때 가장 앞에 있는 값
        
        while(true){
            if(isRightArray(nums) && sumAns(nums)){
                for(int i = 0 ; i < n ; i++){
                    System.out.print(nums[i]+" ");
                }
                break;
            }
            next();
        }
        
        
    }
}