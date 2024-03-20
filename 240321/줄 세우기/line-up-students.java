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
        if(this.h == student.h){
            if(this.w == student.w)
                return this.n - student.n;
            return student.w - this.w;
        }
            
        return student.h - this.h;
    }
}; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Student[] students = new Student[N];

        for(int i = 0 ; i < N ; i++){
            int h = sc.nextInt();
            int w = sc.nextInt();

            students[i] = new Student(h, w, i+1);

        }

        Arrays.sort(students);

        for(int i = 0; i < N ; i++)
            System.out.println(students[i].h + " " + students[i].w + " " + students[i].n);
    }
}