import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.Comparator;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Create the Student and Priorities classes here.
 */
class Student{
    int id;
    String name;
    double cgpa;

    public Student(String name, double cgpa, int id) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }

    @Override
    public String toString() {
        return "Student [cgpa=" + cgpa + ", id=" + id + ", name=" + name + "]";
    }

}


class Priorities{
    private final static Scanner scan = new Scanner(System.in);
    public List<Student> getStudents(List<String> events){

        Queue<Student> students = new PriorityQueue<Student>(events.size(), Comparator.comparing(Student::getCGPA).reversed()
        .thenComparing(Student::getName)
        .thenComparing(Student::getId)
        );
                   
       
        for (int i = 0; i < events.size(); i++) {
            String[] temp = events.get(i).split(" ") ;
            if(temp[0].equals("ENTER")) {
                students.offer(new Student(temp[1], Double.parseDouble(temp[2]), Integer.parseInt(temp[3])));
            }
            else if(temp[0].equals("SERVED")) students.poll();
        }
        
        List<Student> toBeServed = new ArrayList<Student>(students.size());
       Student first = students.poll();
        if (first == null) {
            return toBeServed;
        } 
        else {
            while (first != null) {

                toBeServed.add(first);
                first = students.poll();

            }
            return toBeServed;
        }
        
    }
    
}


public class Main {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}