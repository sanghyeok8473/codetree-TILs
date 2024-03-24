import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int offset = 1000000;

        int[] posA = new int[offset+1];
        int[] tA = new int[50001];
        char[] dA = new char[50001];

        int[] posB = new int[offset+1];
        int[] tB = new int[50001];
        char[] dB = new char[50001];

        int idxA = 1, idxB = 1;

        int sumA = 0 , sumB = 0;

        for(int i = 0 ; i < n ; i++){
            tA[i] = sc.nextInt();
            dA[i] = sc.next().charAt(0);

            sumA += tA[i];
        }

        for(int i = 0 ; i < m ; i++){
            tB[i] = sc.nextInt();
            dB[i] = sc.next().charAt(0);

            sumB += tB[i];
        }

        for(int j = 0 ; j < n ; j++ ){
            if(dA[j] == 'R'){
                for(int i = idxA ; i < idxA + tA[j] ; i++){
                    posA[i] = posA[i-1] + 1;
                }
                idxA += tA[j];
            }
            else{
                for(int i = idxA ; i < idxA + tA[j] ; i++){
                    posA[i] = posA[i-1] - 1;
                }
                idxA += tA[j];
            }
        }

        for(int j = 0 ; j < m ; j++ ){
            if(dB[j] == 'R'){
                for(int i = idxB ; i < idxB + tB[j] ; i++){
                    posB[i] = posB[i-1] + 1;
                }
                idxB += tB[j];
            }
            else{
                for(int i = idxB ; i < idxB + tB[j] ; i++){
                    posB[i] = posB[i-1] - 1;
                }
                idxB += tB[j];
            }
        }
        int max = Math.max(sumA, sumB);

        int diff = Math.max(sumA, sumB) - Math.min(sumA, sumB);

        if(sumA < sumB){
            for(int i = idxA ; i < idxA + diff ; i++){
                posA[i] = posA[i-1];
            }
        }
        else if(sumA > sumB){
            for(int i = idxB ; i < idxB + diff ; i++){
                posB[i] = posB[i-1];
            }
        }

        int cnt = 0;

        for(int i = 2 ; i <= max ; i++ ){
            if(posA[i-1] != posB[i-1] && posA[i] == posB[i])
                cnt++;
        }

        System.out.print(cnt);
        
            
    }
}