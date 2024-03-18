import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {

    public static boolean cal(String A){
        
        for(int i = 0 ; i < A.length(); i++){
            for(int j = i+1 ; j < A.length(); j++){
                if(A.charAt(i) != A.charAt(j))
                    return true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        if(cal(A))
            System.out.print("Yes");
        else
            System.out.print("No");
        
        

        
    }
}