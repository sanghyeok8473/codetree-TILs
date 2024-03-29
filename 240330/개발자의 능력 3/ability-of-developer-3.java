import java.util.Scanner;

public class Main {
    public static int[] arr = new int[6];
    public static int sum = 0, minDiff = Integer.MAX_VALUE;

    public static int getDiff(int x, int y, int z){
        int nowSum = arr[x] + arr[y] + arr[z];

        return Math.abs((sum-nowSum)-nowSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 6 ; i++){   
            arr[i] = sc.nextInt();      // 조합 입력
            sum += arr[i];              // 총합 미리 구해놓기
        }
            

        for(int i = 0 ; i < 4 ; i++){         // 첫 번째 사람
            for(int j = i+1 ; j < 6 ; j++){     // 두 번째 사람
                for(int k = j+1 ; k < 6 ; k++){    //세 번째 사람
                    minDiff = Math.min(minDiff, getDiff(i, j, k));
                }
            }
        }
        

        System.out.print(minDiff);

         

        
    }
}