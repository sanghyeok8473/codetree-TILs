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
        int now = 0;
        for(int i = n ; i >= 1 ; i--)  // 현재 배열에 들어있는 값을 구함.
            now += nums[n-i] * (int)Math.pow(10,i-1);
       
        while(true){
            now++;                      // 현재 배열에 들어있는 값을 1 증가.
            int nowCheck = now;
            for(int i = n-1 ; i >= 0 ; i--){
                nums[i] = nowCheck%10;
                nowCheck /= 10;
            }               // nums배열에 1이 증가된 now값을 순서대로 집어넣음.(1이 증가한 값으로 업데이트)
            for(int i = 0 ; i < n ; i++){
                if(isRightArray(nums))      // nums가 사전순으로 다음에 나오는 숫자의 배열이 되었으면 next를 끝냄.
                    break;
            }
            if(isRightArray(nums)){
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

    public static int factorial(int x){
        if(x==1)
            return 1;
        
        return factorial(x-1) * x;
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
        
        for(int seq = 1 ; seq <= factorial(n) ; seq++){     //최대 가짓수는 factorial(n)임.
            if(sumAns(nums)){
                for(int i = 0 ; i < n ; i++){
                    System.out.print(nums[i]+"  ");
                }
                break;
            }
            next();
        }
        
        
    }
}