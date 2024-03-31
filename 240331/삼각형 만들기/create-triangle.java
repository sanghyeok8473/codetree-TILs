import java.util.Scanner;

public class Main {
    public static int n, nowArea, areaMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] x = new int[n], y = new int[n];                                                                                                                                                         

        for(int i = 0 ; i < n ; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){ // 첫 번째 점의 좌표
            for(int j = 0 ; j < n ; j++){ // 두 번째 점의 좌표
                if(j != i){
                    for(int k = 0 ; k < n ; k++){ // 세 번째 점의 좌표
                        if(k != i && k != j){
                            int x1 = x[i], x2 = x[j], x3 = x[k], y1 = y[i], y2 = y[j], y3 = y[k];
                            if((y[i] == y[j] && y[i] != y[k]) && (x[k] == x[i] || x[k] == x[j])){
                                nowArea = Math.abs((x1*y2 + x2*y3 + x3*y1)-(x2*y1 + x3*y2 + x1*y3))/2*2;
                                areaMax = Math.max(areaMax, nowArea);
                            }
                        }      
                    }
                }
            }  
        }

        System.out.print(areaMax);


    }
}