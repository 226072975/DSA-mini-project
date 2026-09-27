public class Main{
    public static void main(String[] args){

    
    
    StudentQueue queue = new StudentQueue();

        Student s1 = new Student("221045678", "Maria", "Registration", 12);
        Student s2 = new Student("22034512", "Thomas", "Student Card", 5);
        Student s3 = new Student("223041876", "Ndapewa", "Fees", 8);
        Student s4 = new Student("221067341", "Simon", "Documents", 4);
        Student s5 = new Student("224058213", "Helena", "Academic Enquiry", 6);
        Student s6 = new Student("220019845", "Petrus", "Registration", 10);

        System.out.println("---- 6 students arriving ----");
         queue.enqueue(s1);
        queue.enqueue(s2);
        queue.enqueue(s3);
        queue.enqueue(s4);
        queue.enqueue(s5);
        queue.enqueue(s6);

        System.out.println();
        queue.displayQueue();

        System.out.println();
        System.out.println("---- Serving 3 students ----");
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println();
        queue.displayQueue();


    
}
}