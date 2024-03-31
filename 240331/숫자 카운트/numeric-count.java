import java.util.Scanner;

public class Main {
    public static int n, sum = 0, idx = 0;
    public static int[] possibleNums = new int[1000000];

    public static int checkCountOne(int x, int y, int z, int f, int s, int t){
        int cnt = 0;
        if(x==f)
            cnt++;
        if(y==s)
            cnt++;
        if(z==t)
            cnt++;
        return cnt;
    }

    public static int checkCountTwo(int x, int y, int z, int f, int s, int t){
        int cnt = 0;
        if(x == s || x == t)
            cnt++;
        if(y == f || y == t)
            cnt++;
        if(z == f || z == s)
            cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int[] numbers = new int[n], countOne = new int[n], countTwo = new int[n];

        for(int i = 0 ; i < n ; i++){
            numbers[i] = sc.nextInt();
            countOne[i] = sc.nextInt();
            countTwo[i] = sc.nextInt();

            if(countOne[i] == 3){
                System.out.print(1);
                System.exit(0);
            }
        } // 입력 받는 파트

        //xyz와 fst를 비교해서 조건에 맞춰 cnt1과 cnt2를 증가시키고, 이 값들이 cO와 cS와 일치하면 xyz는 조건을 만족하는 수이므로 배열에 집어넣음
        for(int i = 0 ; i < n ; i++){    
            if(i==0){
                for(int x = 1 ; x <= 9 ; x++){
                    for(int y = 1 ; y <= 9 ; y++){
                        if(y != x){
                            for(int z = 1 ; z <= 9 ; z++){  // 서로 다른 수로 이루어진 세자리수 xyz가 조건을 만족하는지 여부를 체크.
                                if(z != x && z != y){
                                    int first = numbers[i]/100, second = (numbers[i]-(first*100))/10, third = numbers[i]%10; // 각 자리 숫자 추출
                                    int cnt1 = checkCountOne(x, y, z, first, second, third), cnt2 = checkCountTwo(x, y, z, first, second, third);
                                    if(cnt1 == countOne[i] && cnt2 == countTwo[i]){
                                        possibleNums[idx] = x*100 + y*10 + z;
                                        idx++;
                                    }
                                }
                            }
                        }
                    }
                }   
            }
            else{
                int idx2 = 0;
                while(idx2 < idx){
                    if(possibleNums[idx2] != 0){
                        int x = possibleNums[idx2]/100, y = (possibleNums[idx2]-(x*100))/10, z = possibleNums[idx2]%10; // 첫번째 숫자에서 가능했던 숫자의 각자리 숫자 추출
                        int first = numbers[i]/100, second = (numbers[i]-(first*100))/10, third = numbers[i]%10; // 두번째 부터 입력받은 숫자의 각 자리 숫자 추출
                        int cnt1 = checkCountOne(x, y, z, first, second, third), cnt2 = checkCountTwo(x, y, z, first, second, third);
                        if(cnt1 != countOne[i] || cnt2 != countTwo[i]){  // 앞선 숫자까지는 조건에 맞았으나 이번 순서에 조건이 틀어졌다면
                            possibleNums[idx2] = 0;
                        }
                    }
                    idx2++;
                }
            }
        }
        // 처음 물어봐진 숫자와 1번, 2번 카운트를 기준으로 가능한 모든 숫자들을 배열에 집어넣은 다음,
        // 그 다음부터는 그 직전까지의 모든 조건들을 만족한 숫자들이 이를 만족하는지 확인
        // 만족하지 않으면 정수형 배열의 초기값인 0으로 만들어 마지막에는 모든 조건을 만족하는 수만 남아있고, 중간에 탈락된 숫자들은
        // 모두 0으로 재입력되어 0이 아닌 숫자의 개수가 모든 조건을 만족하는 숫자의 개수인 결과가 나오게 됨.
        int cntNums = 0;
        for(int i = 0 ; i < idx ; i++){
            if(possibleNums[i] != 0)
                cntNums++;
        }
        System.out.print(cntNums);
    }
}