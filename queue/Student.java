package queue;

public class Student{
    String studentNo;
    String name;
    String serviceType;
    int serviceTime;
    
    Student(String studentno, String name, String serviceType, int serviceTime){
        this.studentNo = studentno;
        this.name = name;
        this.serviceType = serviceType;
        this.serviceTime = serviceTime;
    }
}