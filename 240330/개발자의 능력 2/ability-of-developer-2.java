import java.util.Scanner;

public class Main {
    public static int[] arr = new int[6];
    public static int sum = 0, minDiff = Integer.MAX_VALUE, firstSum, secondSum, thirdSum;

    public static int getDiff(int x, int y, int z){
        int max = Math.max(x, y);
        max = Math.max(max, z);         // 세 인수 중 최대값을 구함

        int min = Math.min(x, y);
        min = Math.min(min, z);         // 세 인수 중 최소값을 구함.

        return max - min;                 //세 인수 중 나오는 최대값과 최소값의 차를 반환.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 6 ; i++){   
            arr[i] = sc.nextInt();      // 조합 입력
            sum += arr[i];              // 총합 미리 구해놓기
        }
            

        for(int i = 0 ; i < 5 ; i++){         // 첫 번째 팀의 첫 번째 사람
            for(int j = i+1 ; j < 6 ; j++){    // 첫 번째 팀의 두 번째 사람
                firstSum = arr[i] + arr[j];
                for(int k = 0 ; k < 6 ; k++){    //  두 번째 팀의 첫 번째 사람
                    if(k != i && k != j){
                        for(int l = 0 ; l < 6 ; l++){ 
                            if(l != i && l != j && l != k){
                                secondSum = arr[k] + arr[l];
                                thirdSum = sum - (firstSum + secondSum);

                                if(minDiff > getDiff(firstSum, secondSum, thirdSum))
                                    minDiff = getDiff(firstSum, secondSum, thirdSum);
                            }
                        }
                    }
                }
            }
        }
        

        System.out.print(minDiff);

         

        
    }
}