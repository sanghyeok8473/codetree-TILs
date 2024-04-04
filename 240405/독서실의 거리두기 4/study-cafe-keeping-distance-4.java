import java.util.Scanner;

public class Main {
    public static int n, maxDist = 0, nowDiff, minDiff = 30;
    public static int[] seats = new int[20];

    public static int nearest(int x, int y){
        int[] newSeats = new int[n];
        for(int i = 0 ; i < n ; i++)
            newSeats[i] = seats[i];
        
        newSeats[x] = 1; newSeats[y] = 1;    // 가장 가까운 두사람의 거리를 구할 새로운 배치
        
        minDiff = 1000;
        for(int i = 0 ; i < n-1 ; i++){           // 첫 번째 점
            for(int j = i+1 ; j < n ; j++){     // 두 번째 점
                nowDiff = j-i;
                if(newSeats[i] == 1 && newSeats[j] == 1)  //두 좌석이 1일때의 모든 거리를 구해서 최소값을 찾으면 그 값이 가장 가까운 사람의 거리임.
                    minDiff = Math.min(minDiff, nowDiff);
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        String seat = sc.next();

        for(int i = 0 ; i < n ; i++)
            seats[i] = seat.charAt(i)-'0'; // 정수 배열로 넣어주기

        for(int i = 0 ; i < n ; i++){      // 첫 번째 사람이 앉을 위치
            for(int j = 0 ; j < n ; j++){
                if(seats[i] == 1 || seats[j] == 1)
                    continue;
                maxDist = Math.max(maxDist, nearest(i, j));
            }
        }
        
        System.out.print(maxDist);
    }
}