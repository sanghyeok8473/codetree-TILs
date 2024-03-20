import java.util.Arrays;
import java.util.Scanner;

class Student implements Comparable<Student>{
    String name;
    int kor, eng, math;

    public Student(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public int compareTo(Student student){
        return (this.kor + this.eng + this.math) - (student.kor + student.eng + student.math);
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Student[] students = new Student[n];

        for(int i = 0 ; i < n ; i++){
            String name = sc.next();
            int k = sc.nextInt();
            int e = sc.nextInt();
            int m = sc.nextInt();

            students[i] = new Student(name, k, e, m);

        }


        Arrays.sort(students);

        for(int i = 0; i < n; i++)
            System.out.println(students[i].name + " " + students[i].kor + " " + students[i].eng + " " + students[i].math);
    }
}