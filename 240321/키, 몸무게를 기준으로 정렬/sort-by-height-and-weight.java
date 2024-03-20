import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    String n;
    int h;
    int w;

    public Student(String n, int h, int w){
        this.n = n;
        this.h = h;
        this.w = w;
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

        int N = sc.nextInt();

        Student[] students = new Student[N];

        for(int i = 0 ; i < N ; i++){
            String n = sc.next();
            int h = sc.nextInt();
            int w = sc.nextInt();

            students[i] = new Student(n, h, w);
        }

        Arrays.sort(students);

        for(int i = 0; i < N ; i++){
            System.out.println(students[i].n + " " + students[i].h + " " + students[i].w);
        }
    }
}