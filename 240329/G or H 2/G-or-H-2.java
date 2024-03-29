import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), b = 0, s = 101, max = 0, nowSum, sum = 0, countG, countH, photoStart, photoEnd;

        int[] arr = new int[n];
        char[] alphabet = new char[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            alphabet[i] = sc.next().charAt(0);

            b = Math.max(b, arr[i]);
            s = Math.min(s, arr[i]);
        }

        char[] placed = new char[b+1];

        for(int i = 0 ; i < n ; i++)
            placed[arr[i]] = alphabet[i]; // 입력받는 파트.

        if(n==1){
            System.out.print(0);
            System.exit(0);
        }

        //조건 : G로만 이루어져 있거나, H로만 이루어져 있거나, G와 H의 개수가 같음

        for(int i = 0 ; i < b ; i++){         // 구간의 시작점.
            for(int j = i+1 ; j <= b ; j++){     // 구간의 마지막 점.
                countG = 0; countH = 0;
                for(int k = i ; k <= j ; k++){
                    if(placed[k] =='G')
                        countG++;
                    else if(placed[k] == 'H')
                        countH++;
                }
                if((countH == 0 && countG != 0) || (countH != 0 && countG == 0) || countH == countG){
                    photoStart = 0; photoEnd = 0;
                    for(int k = i ; k <= j ; k++){
                        if(placed[k] =='G' || placed[k] =='H'){
                            photoStart = k;
                            break;
                        }
                    }
                    for(int k = j ; k >= i ; k--){
                        if(placed[k] =='G' || placed[k] =='H'){
                            photoEnd = k;
                            break;
                        }
                    }
                    max = Math.max(max, photoEnd-photoStart);
                }
                // 사진의 크기는 양쪽 끝에있는 사람간의 거리로 정의됨.  
            }
        }

        System.out.print(max);

         

        
    }
}