import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, x, sum;
        char O;
        int offset = 1000000;
        
        n = sc.nextInt();

        char[] block = new char[2000001];
        int[] cntWhite = new int[2000001];
        int[] cntBlack = new int[2000001];
        int[] move = new int[n];
        char[] dir = new char[n];

        for(int i = 0 ; i < n ; i++ ){
            move[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
        }

        int nowIdx = 1000000;

        for(int i = 0 ; i < n ; i++ ){
            if(dir[i] == 'R'){
                for(int j = nowIdx ; j < nowIdx + move[i] ; j++){
                    cntBlack[j]++;
                    if(cntBlack[j] >= 2 && cntWhite[j] >= 2)
                        block[j]= 'G';
                    else
                        block[j] = 'B';
                }
                if(move[i] != 1)
                    nowIdx += move[i] - 1;
            }
            else if(dir[i] == 'L'){
                for(int j = nowIdx ; j > nowIdx - move[i] ; j--){
                    cntWhite[j]++;
                    if(cntBlack[j] >= 2 && cntWhite[j] >= 2)
                        block[j]= 'G';
                    else
                        block[j] = 'W';
                }
                if(move[i] != 1)
                    nowIdx -= move[i] + 1;
            }
        } 

        int cntW = 0, cntB = 0, cntG = 0;

        for(int i = 0 ; i < 2000001 ; i++ ){ 
            if(block[i] == 'W')
                cntW++;
            else if(block[i] == 'B')
                cntB++;
            else if(block[i] == 'G')
                cntG++;
        }

        System.out.println(cntW+" "+cntB+" "+cntG);
        
        

        
    }
}