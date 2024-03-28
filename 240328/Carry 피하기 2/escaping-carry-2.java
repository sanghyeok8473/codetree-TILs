import java.util.Scanner;

public class Main {
    public static boolean carry(String a, String b){
        int lenA = a.length(), lenB = b.length();
        int max = Math.max(lenA, lenB);
        int min = Math.min(lenA, lenB);

        if(lenA == lenB){
            for(int i = 0 ; i < lenA ; i++){
                int nowValueA = a.charAt(i) - '0', nowValueB = b.charAt(i) - '0';
                if(nowValueA + nowValueB > 9)
                    return false;
            }
            return true; // 여기까지 실행된다는 건 모든 자리수에서 carry가 발생하지 않았다는 뜻임
        } // 자리수가 같으면, 각 자리끼리의 합이 9보다 큰 경우가 있으면 false를 return후 종료. 밑 조건까지 갔다는거는 모든자리의 합이 9이하라는 뜻이므로 true
        else if(lenA > lenB){
            int minIdx = 0;
            for(int i = max-min ; i < max ; i++){
                int nowValueA = a.charAt(i) - '0', nowValueB = b.charAt(minIdx) - '0';
                if(nowValueA + nowValueB > 9)
                    return false;
                minIdx++;
            }
            return true; // 여기까지 실행된다는 건 모든 자리수에서 carry가 발생하지 않았다는 뜻임
        }
        else{
            int minIdx = 0;
            for(int i = max-min ; i < max ; i++){
                int nowValueA = a.charAt(minIdx) - '0', nowValueB = b.charAt(i) - '0';
                if(nowValueA + nowValueB > 9)
                    return false;
                minIdx++;
            }
            return true; // 여기까지 실행된다는 건 모든 자리수에서 carry가 발생하지 않았다는 뜻임
        } // 자리수가 다르면, 자리수가 더 큰 숫자의 자리수가 더 작은 숫자의 가장 높은 자리수부터 나아가며 더해서 모두 9 이하면 true, 하나라도 9를 초과하면 false

    } 



    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), sum = 0, max = -1; // 만족하는 조합이 없을 때는 -1이므로, 초기값을 -1로 잡음.(숫자의 범위가 1이상이기에 초기값 -1가능)

        String[] nums = new String[n];

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.next();

        // carry가 아님을 확인하는 방법 : 세 수를 더한 값의 각 자리수가 세 수의 각 자리 값을 합친 값과 같으면 carry가 아님.

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i+1 ; j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    String x = nums[i], y = nums[j], z = nums[k]; // 코드의 편의를 위해 x, y, z로 선언해 전개
                    int xPy = Integer.parseInt(x) + Integer.parseInt(y); //밑 if문의 두 번째 조건에 xy를 위해 정수로 변환해서 더하고 다시 문자열로 변환
                    String xy = Integer.toString(xPy);
                    if(carry(x, y) && carry(xy, z)){
                        sum = xPy + Integer.parseInt(z);
                        if(sum > max)
                            max = sum;
                    }
                }
            }
        }
        System.out.print(max);
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