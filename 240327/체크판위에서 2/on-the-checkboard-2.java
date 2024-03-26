import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        char[][] arr = new char[r][c];

        int[] firstX = new int[100];
        int[] firstY = new int[100];
        int[] secondX = new int[100];
        int[] secondY = new int[100];

        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                arr[i][j] = sc.next().charAt(0);
            }
        }

        int firstIdx = 0, cnt = 0;

        // 해결방법 : 첫 번째 점프를 할 수 있는 좌표들을 모두구함(idx가 1보다 크고, n-2보다 작아야함. 또한 0,0의 값과 달라야함.)
        // 두 번째 점프를 할 수 있는 좌표들을 모두 구함.(첫번째 좌표보다 idx가 최소 1씩 크고, n-1보다 작아야함. 또한 0,0의 값과 같아야함.)
        // 만약 0,0이랑 n-1,n-1이 같다면, 답은 무조건 0임.

        if(arr[0][0] == arr[r-1][c-1]){
            System.out.print(0);
            System.exit(0);
        }

        for(int i = 1 ; i < r-2 ; i++){ // 가능한 첫번째 좌표 모두 구하기
            for(int j = 1 ; j < c-2 ; j++){
                if(arr[i][j] != arr[0][0]){
                    firstX[firstIdx] = i ; firstY[firstIdx] = j;
                    firstIdx++;
                }
            }
        }

        for(int i = 0 ; i < firstIdx ; i++){ // 가능한 두 번째 좌표 모두 구하기
            for(int j = firstX[i]+1 ; j < c-1 ; j++){
                for(int k = firstY[i]+1 ; k < c-1 ; k++){
                    if(arr[j][k] != arr[firstX[i]][firstY[i]]){
                        cnt++;
                    }
                }
                
            }
        }

        System.out.print(cnt);
    }
}