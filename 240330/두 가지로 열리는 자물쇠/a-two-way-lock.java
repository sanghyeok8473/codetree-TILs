import java.util.Scanner;

public class Main {
    public static int[] arr1 = new int[3], arr2 = new int[3], arrFirst = new int[10], arrSecond = new int[10], arrThird = new int[10];
    public static int sum = 0, n, minDiff = Integer.MAX_VALUE, cnt = 250, a = 0, b = 0, c = 0;

    public static void fillArr(int[] dial){
        arrFirst[2] = arr1[0]; arrFirst[7] = arr2[0]; arrSecond[2] = arr1[1]; arrSecond[7] = arr2[1]; arrThird[2] = arr1[2]; arrThird[7] = arr2[2]; 

        for(int i = 0 ; i < 10 ; i++){
            if(i==2){
                arrFirst[i-2] = dial[((arrFirst[i]-1)+n-1)%n];
                arrFirst[i-1] = dial[((arrFirst[i]-1)+n-2)%n];
                arrFirst[i+1] = dial[arrFirst[i]%n];
                arrFirst[i+2] = dial[(arrFirst[i]+1)%n];
                arrSecond[i-2] = dial[((arrSecond[i]-1)+n-1)%n];
                arrSecond[i-1] = dial[((arrSecond[i]-1)+n-2)%n];
                arrSecond[i+1] = dial[arrSecond[i]%n];
                arrSecond[i+2] = dial[(arrSecond[i]+1)%n];
                arrThird[i-2] = dial[((arrThird[i]-1)+n-1)%n];
                arrThird[i-1] = dial[((arrThird[i]-1)+n-2)%n];
                arrThird[i+1] = dial[arrThird[i]%n];
                arrThird[i+2] = dial[(arrThird[i]+1)%n];

            }
            else if(i==7){
                arrFirst[i-2] = dial[((arrFirst[i]-1)+n-1)%n];
                arrFirst[i-1] = dial[((arrFirst[i]-1)+n-2)%n];
                arrFirst[i+1] = dial[arrFirst[i]%n];
                arrFirst[i+2] = dial[(arrFirst[i]+1)%n];
                arrSecond[i-2] = dial[((arrSecond[i]-1)+n-1)%n];
                arrSecond[i-1] = dial[((arrSecond[i]-1)+n-2)%n];
                arrSecond[i+1] = dial[arrSecond[i]%n];
                arrSecond[i+2] = dial[(arrSecond[i]+1)%n];
                arrThird[i-2] = dial[((arrThird[i]-1)+n-1)%n];
                arrThird[i-1] = dial[((arrThird[i]-1)+n-2)%n];
                arrThird[i+1] = dial[arrThird[i]%n];
                arrThird[i+2] = dial[(arrThird[i]+1)%n];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] dial = new int[n];

        for(int i = 0 ; i < n ; i++)
            dial[i] = i+1;     // 다이얼 모양의 변수 선언.

        // dial[(i+n-1)%6] => 다이얼모양 한 칸 왼쪽인 수
        // dial[(i+n-2)%6] => 다이얼모양 두 칸 왼쪽인 수
        // dial[(i+1)%6] => 다이얼모양 한 칸 오른쪽인 수
        // dial[(i+2)%6] => 다이얼모양 두 칸 오른쪽인 수

        // arr1[i] = 1일때 가능한 수 들은
        // 한 칸 왼쪽인 수 : dial[((arr1[i]-1)+n-1)%n] = dial[((1-1)+6-1)%6] = dial[5%6 = 5] = dial[5] = 6
    

        for(int i = 0 ; i < 3 ; i++)
            arr1[i] = sc.nextInt();      // 첫 번째 조합 입력

        for(int i = 0 ; i < 3 ; i++)
            arr2[i] = sc.nextInt();      // 두 번째 조합 입력

        // 이 문제는 250에서 겹치는 것의 개수를 빼면 되는 문제이므로
        // 각 3자리 총 6자리의 숫자에서 가능한 숫자들을 나열했을때, 각 자리에서 겹치는 숫자의 개수끼리 곱한값을 250에서 빼면됨. 

        if(n <= 5){
            System.out.print(n*n*n);
            System.exit(0);
        }
        // n이 5 이하일때는 어떤 수를 입력해도 다이얼의 모든 숫자가 열리는 조건을 만족하는 수이므로, 첫번째 조합에서 n의 세제곱, 두 번째 조합에서 n의 세제곱
        // 이 가능한 숫자로 나오지만, 그 모든 경우가 겹치는 경우이므로 n^3 + n^3 - n^3이 된다. 따라서 n이 5 이하잉 때 정답은 n^3
            

        fillArr(dial);

        for(int i = 0 ; i < 5 ; i++){
            for(int j = 5 ; j < 10 ; j++){
                if(arrFirst[i] == arrFirst[j])
                    a++;
                if(arrSecond[i] == arrSecond[j])
                    b++;
                if(arrThird[i] == arrThird[j])
                    c++;
            }
        }

        System.out.print(cnt-(a*b*c));

        
    }
}