import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), nowSum, cnt = n;

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();

        for(int i = 0 ; i < n-1 ; i++){ // 첫 위치
            for(int j = i+1 ; j < n ; j++){ // 마지막 위치
                nowSum = 0;
                for(int k = i ; k <= j ; k++) //첫 위치부터 마지막 위치까지의 합을 구함
                    nowSum += arr[k];
                double avg = (double)nowSum / (j-i+1);
                for(int l = i ; l <= j ; l++){          //첫 위치부터 마지막 위치 중 일치하는 값이 있는지 구함.
                    if(avg == (double)arr[l]){
                        cnt++;
                        break;                          //원소가 하나라도 있으면 더 살펴볼 필요가 없으므로 cnt를 세는 것을 멈춤.
                    }
                }  
            }

        }

        System.out.print(cnt);
    }
}