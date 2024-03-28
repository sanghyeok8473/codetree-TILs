import java.util.Scanner;

public class Main {
    public static boolean judgmentVec(int x, int y){ // 수직방향으로 내렸을 때 성립하는지 판단
        if(board[x][y] == 0)
            return false;
        else{
            int now = board[x][y];
            for(int i = x+1 ; i < x+5 ; i++){
                if(board[i][y] != now)
                    return false;
            }
            return true; // 여기까지 왔으면 5개의 값이 모두 0이 아닌값으로 동일하면서 일직선이라는 뜻임.
        }
    }

    public static boolean judgmentHor(int x, int y){ // 수평방향으로 뻗었을 때 성립하는지 판단
        if(board[x][y] == 0)
            return false;
        else{
            int now = board[x][y];
            for(int j = y+1 ; j < y+5 ; j++){
                if(board[x][j] != now)
                    return false;
            }
            return true; // 여기까지 왔으면 5개의 값이 모두 0이 아닌값으로 동일하면서 일직선이라는 뜻임.
        }
    }

    public static boolean judgmentDiaUp(int x, int y){ // 대각선(오른쪽 위 방향)여부를 판단
        if(board[x][y] == 0)
            return false;
        else{
            int now = board[x][y];
            for(int i = 1 ; i < 5 ; i++){
                if(board[x - i][y + i] != now) // 대각선 위로 올라가면 x는 1씩 줄어들때 y는 1씩 증가함.
                    return false;
            }
            return true; // 여기까지 왔으면 5개의 값이 모두 0이 아닌값으로 동일하면서 일직선이라는 뜻임.
        }
        
    }

    public static boolean judgmentDiaDown(int x, int y){ // 대각선(오른쪽 아래 방향)여부를 판단
        if(board[x][y] == 0)
            return false;
        else{
            int now = board[x][y];
            for(int i = 1 ; i < 5 ; i++){
                if(board[x + i][y + i] != now) // 대각선 아래로 내려가면 x는 1씩 증가할 때 y도 1씩 증가함.
                    return false;
            }
            return true; // 여기까지 왔으면 5개의 값이 모두 0이 아닌값으로 동일하면서 일직선이라는 뜻임.
        }
    }


    public static int[][] board = new int[19][19];
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 19 ; i++){
            for(int j = 0 ; j < 19 ; j++){
                board[i][j] = sc.nextInt();
            }
        } // 바둑판 입력
            

        // 승리판단방법 : 현재위치의 값이 0이 아닐때, 대각선(오른쪽아래 또는 오른쪽위), 동, 북 방향으로 4개가 같은값이면 결정이 남.

        for(int i = 0 ; i < 19 - 4 ; i++){      //수직, j가 (19-4)미만일 때는 대각선 아래도 가능.
            for(int j = 0 ; j < 19 ; j++){
                if(judgmentVec(i,j)){
                    System.out.println(board[i][j]);
                    System.out.print((i+1+2)+" "+(j+1)); // 줄 모양에 맞춰 가운데 위치하고있는 좌표를 적절하게 구해 출력
                    System.exit(0);
                }
                else if(j < 15 && judgmentDiaDown(i,j)){
                    System.out.println(board[i][j]);
                    System.out.print((i+1+2)+" "+(j+1+2)); // 줄 모양에 맞춰 가운데 위치하고있는 좌표를 적절하게 구해 출력
                    System.exit(0);
                }
            }
        }

        for(int i = 0 ; i < 19 ; i++){          //수평, i가 (0+4)이상일때는 대각선 위도 가능.
            for(int j = 0 ; j < 19 - 4 ; j++){
                if(judgmentHor(i,j)){
                    System.out.println(board[i][j]);
                    System.out.print((i+1)+" "+(j+1+2)); // 줄 모양에 맞춰 가운데 위치하고있는 좌표를 적절하게 구해 출력
                    System.exit(0);
                }
                else if(i>=4 && judgmentDiaUp(i,j)){
                    System.out.println(board[i][j]);
                    System.out.print((i+1-2)+" "+(j+1+2)); // 줄 모양에 맞춰 가운데 위치하고있는 좌표를 적절하게 구해 출력
                    System.exit(0);
                }
            }
        }

        System.out.print(0); // 이 코드가 실행된다는건 승부가 결정되지 않았다는 뜻임.
    }











    /*public static boolean carry(int a, int b){
        int sum = a + b,  min = Math.min(a, b), max = Math.max(a, b), nums = 0;

        for(int i = 0; i < 5 ; i++){
            if(min/(Math.pow(10,i))==0){
                num = i;
                break;
            }
        } // 두 수중 작은 수의 자리수를 구하는 과정(작은수의 자리수를 알면 각 수의 합이 9이하인지 알 수 있기 때문.)

        max %= Math.pow(10,num); // 자리수가 차이난다면, 작은 수의 가장 큰 자리수보다 높은 자리수는 볼 필요가 없음.

        for(int i = 1 ; i <= num ; i++){
            if(max % (Math.pow(10,i)) + min % (Math.pow(10,i)))
            
        } 



    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), sum = 0;

        int nums = new int[n];

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();

        // carry가 아님을 확인하는 방법 : 세 수를 더한 값의 각 자리수가 세 수의 각 자리 값을 합친 값과 같으면 carry가 아님.

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i+1 ; j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    int x = nums[i], y = nums[j], z = nums[k]; // 코드의 편의를 위해 x, y, z로 선언해 전개
                    if(carry(x, y) && carry(x+y, z)){
                        sum = x + y + z;
                    }
                }
            }
        }
        System.out.print(cnt);
    }*/
}