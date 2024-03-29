import java.util.Scanner;

public class Main {
    public static int[] arr = new int[5];
    public static int sum = 0, minDiff = Integer.MAX_VALUE, firstSum, secondSum, thirdSum, diff;

    public static int getDiff(int x, int y, int z){
        int max = Math.max(x, y);
        max = Math.max(max, z);         // 세 인수 중 최대값을 구함

        int min = Math.min(x, y);
        min = Math.min(min, z);         // 세 인수 중 최소값을 구함.

        return max - min;                 //세 인수 중 나오는 최대값과 최소값의 차를 반환.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 5 ; i++){   
            arr[i] = sc.nextInt();      // 조합 입력
            sum += arr[i];              // 총합 미리 구해놓기
        }
            
        boolean none = true;            // 팀의 능력이 모두 다른경우가 있는지 여부를 파악하기위해 none이라는 이름의 boolean 변수를 선언.

        for(int i = 0 ; i < 5 ; i++){         // 첫 번째 팀의 첫 번째 사람
            for(int j = 0 ; j < 5 ; j++){    // 첫 번째 팀의 두 번째 사람
                if(j != i){
                    firstSum = arr[i] + arr[j];   // 첫 번재 팀의 능력
                    for(int k = 0 ; k < 5 ; k++){    //  두 번째 팀의 첫 번째 사람
                        if(k != i && k != j){       
                            for(int l = 0 ; l < 5 ; l++){ 
                                if(l != i && l != j && l != k){  //   두 번째 팀의 두 번째 사람
                                    secondSum = arr[k] + arr[l];    // 두 번째 팀의 능력
                                    thirdSum = sum - (firstSum + secondSum);    // 세 번째 팀(혼자) 의 능력
                                    if(firstSum != secondSum && secondSum != thirdSum){  // 팀의 능력이 모두 다른경우가 없으면 -1을 출력해야 함.
                                        none = false; diff = getDiff(firstSum, secondSum, thirdSum);
                                        if(minDiff > diff)
                                            minDiff = diff;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        if(none)       // none이 true면, 중첩for문을 수행하는 과정에서 none이 false로 변경되지 않았다는 뜻이므로 팀의 능력이 모두 다른경우가 없음을 의미함.
            System.out.print(-1);
        else
            System.out.print(minDiff);

         

        
    }
}