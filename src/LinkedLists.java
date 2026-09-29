class Student {
    long studentNo;
    String name;
    String serviceType;
    int estimatedServiceTime;
    Student next; 

    
    public Student(long studentNo, String name, String serviceType, int estimatedServiceTime) {
        this.studentNo = studentNo;
        this.name = name;
        this.serviceType = serviceType;
        this.estimatedServiceTime = estimatedServiceTime;
        this.next = null;
    }

   
    @Override
    public String toString() {
        return "[" + studentNo + " | " + name + " | " + serviceType + " | " + estimatedServiceTime + "min]";
    }
}


class StudentList {
    private Student head; 

    public StudentList() {
        this.head = null;
    }

   
    public void insertStudent(long studentNo, String name, String serviceType, int time, int position) {
        Student newStudent = new Student(studentNo, name, serviceType, time);

        if (position <= 1 || head == null) {
            newStudent.next = head;
            head = newStudent;
            System.out.println("-> Inserted " + name + " at the beginning.");
            return;
        }

        Student current = head;
        int currentPos = 1;

        while (current.next != null && currentPos < position - 1) {
            current = current.next;
            currentPos++;
        }

        newStudent.next = current.next;
        current.next = newStudent;
        
        if (newStudent.next == null) {
            System.out.println("-> Inserted " + name + " at the end.");
        } else {
            System.out.println("-> Inserted " + name + " at position " + position + ".");
        }
    }

    public void deleteStudent(long studentNo) {
        if (head == null) {
            System.out.println("List is empty. Cannot delete.");
            return;
        }

        if (head.studentNo == studentNo) {
            System.out.println("-> Deleted " + head.name + " (Head node).");
            head = head.next; 
            return;
        }

        Student current = head;
        Student prev = null;

        while (current != null && current.studentNo != studentNo) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("-> Student " + studentNo + " not found.");
            return;
        }

        prev.next = current.next;
        System.out.println("-> Deleted " + current.name + ".");
    }

    public void searchStudent(long studentNo) {
        Student current = head;
        while (current != null) {
            if (current.studentNo == studentNo) {
                System.out.println("-> Found: " + current.toString());
                return;
            }
            current = current.next;
        }
        System.out.println("-> Student " + studentNo + " not found in list.");
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("Current Queue: HEAD -> ");
        Student current = head;
        while (current != null) {
            System.out.print(current.toString() + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}

class LinkedListDemo {
    public static void main(String[] args) {
        StudentList queue = new StudentList();

        System.out.println("=== INITIALIZING QUEUE (From Problem Statement) ===");
       
        queue.insertStudent(221045678, "Maria", "Registration", 12, 1);
        queue.insertStudent(222034512, "Tomas", "Student Card", 5, 2);
        queue.insertStudent(223041876, "Ndapewa", "Fees", 8, 3);
        queue.insertStudent(221067341, "Simon", "Documents", 4, 4);
        
        System.out.println("\n--- Initial State ---");
        queue.displayStudents();

        System.out.println("\n=== DEMONSTRATION OF OPERATIONS ===");

       
        System.out.println("\nOperation 1: Insert new student at Beginning (Priority Case)");
        queue.insertStudent(999999999, "Emergency Student", "Help", 2, 1);
        queue.displayStudents(); 

       
        System.out.println("\nOperation 2: Insert student at Position 3");
        queue.insertStudent(888888888, "John Doe", "Enquiry", 10, 3); 
        queue.displayStudents();

        System.out.println("\nOperation 3: Search for Student");
        queue.searchStudent(223041876); 

        
        System.out.println("\nOperation 4: Delete a Student (Maria - Head)");
        queue.deleteStudent(221045678);
        queue.displayStudents();

        System.out.println("\nOperation 5: Delete a Student (Tomas - Middle)");
        queue.deleteStudent(222034512);
        queue.displayStudents();

        System.out.println("\n=== FINAL STATE ===");
        queue.displayStudents();
    }
}
