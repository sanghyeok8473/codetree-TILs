import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    int h, w, n;

    public Student(int h, int w, int n){
        this.h = h;
        this.w = w;
        this.n = n;
    }

    @Override
    public int compareTo(Student student){
        if(this.h == student.h)
            return student.w - this.w;
        return this.h - student.h;
    }
}; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for(int i = 0 ; i < n ; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();

            students[i] = new Student(h, w, i+1);
        }

        Arrays.sort(students);
        
        for(int i = 0; i < n ; i++){
            System.out.println(students[i].h+" "+students[i].w+" "+students[i].n);
        }
    }
}