import java.util.Scanner;

public class Main {
    public static int n = 0, tmp = 0, largest = 0, l=0, r=0;
    public static int[] arr = new int[100000];

    public static void heap_sort(int n){
        for(int i = n/2 ; i >= 1; i--){
            heapify(n, i);
        }
        for(int i = n ; i > 1; i--){
            tmp = arr[1];
            arr[1] = arr[i];
            arr[i] = tmp;
            heapify(i-1, 1);
        }
    }

    public static void heapify(int n, int i){
        largest = i;
        l = i*2;
        r = l+1;

        if(l<=n && arr[l] > arr[largest])
            largest = l;

        if(r<=n && arr[r] > arr[largest])
            largest = r;
        
        if(largest != i){
            tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            heapify(n, largest);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++)
            arr[i] = sc.nextInt();
        
        heap_sort(n);

        for(int i = 1 ; i <= n ; i++)
            System.out.print(arr[i]+" ");
    }
}