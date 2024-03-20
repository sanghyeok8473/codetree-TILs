import java.util.Arrays;
import java.util.Scanner;

class Student {
    String n;
    int h;
    double w;

    public Student(String n, int h, double w){
        this.n = n;
        this.h = h;
        this.w = w;
    }
}; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[5];

        for(int i = 0 ; i < 5 ; i++){
            String n = sc.next();
            int h = sc.nextInt();
            double w = sc.nextDouble();

            students[i] = new Student(n, h, w);

        }

        String[] str = new String[5];

        for(int i = 0; i < 5 ; i++){
            str[i] = students[i].n;
        }

        Arrays.sort(str);

        System.out.println("name");

        for(int i = 0; i < 5 ; i++){
            for(int j = 0 ; j < 5 ; j++ ){
                if(str[i].equals(students[j].n))
                    System.out.println(students[j].n + " " + students[j].h + " " + students[j].w);
            }
        }
            

        System.out.println();
        System.out.println("height");

        Arrays.sort(students, (a, b) -> b.h - a.h);

        for(int i = 0; i < 5 ; i++)
            System.out.println(students[i].n + " " + students[i].h + " " + students[i].w);
    }
}