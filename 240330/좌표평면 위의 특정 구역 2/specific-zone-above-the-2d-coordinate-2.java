import java.util.Scanner;

public class Main {
    public static boolean same(int x, int[] arr){  // 인덱스가 x가 아닌 나머지의 arr값이 모두 같으면 true를 반환하는 함수
        int idxValue;
        if(x!=0)
            idxValue = arr[0];
        else
            idxValue = arr[1];

        for(int i = 0 ; i < n ; i++){
            if(i==x)
                continue;
            if(idxValue != arr[i])
                return false;
        }
        return true;
    }
    public static int n, nowArea, areaMin = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] x = new int[n], y = new int[n];                                                                                                                                                         

        for(int i = 0 ; i < n ; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){ // 제외할 점의 좌표
            int xMax = 0, xMin = 40001, yMax = 0, yMin = 40001;
            for(int j = 0 ; j < n ; j++){
                if(j == i)
                    continue;
                if(same(i, x) || same(i, y))
                    break;
                xMax = Math.max(xMax, x[j]);
                xMin = Math.min(xMin, x[j]);
                yMax = Math.max(yMax, y[j]);
                yMin = Math.min(yMin, y[j]);
            }
            if(same(i, x) || same(i, y))
                nowArea = 0;
            else
                nowArea = (xMax - xMin)*(yMax - yMin);

            areaMin = Math.min(nowArea, areaMin);
        }

        System.out.print(areaMin);


    }
}