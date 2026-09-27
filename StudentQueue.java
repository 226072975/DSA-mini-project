public class StudentQueue{
    private QueueNode front, rear;

    boolean isEmpty(){
        return (front == null && rear == null);

    }
    
    void enqueue(Student student){
    QueueNode newNode = new QueueNode(student);
    newNode.next = null;

    if (front == null && rear == null){
        front = newNode;
        rear = newNode;
    }else {
        rear.next = newNode;
        rear = newNode;
    
}
System.out.println(student.name + " joined the queue.");

}

Student dequeue(){
    if (front == null && rear == null){
        System.out.println("Queue is empty");
        return null;
    }else{
        QueueNode temp = front;
        System.out.println("The deleted element is: " + front.data.name);
        front = front.next;
        if(front == null){
            rear = null;
        }
        return temp.data;
    }
}

    
Student peek(){
    if(isEmpty()){
        System.out.println("Queue is empty");
        return null;

    }
    return front.data;
}


void displayQueue(){
    if(isEmpty()){
        System.out.println("No students waiting");
        return;

        }
        System.out.println("Current waiting queue (front to rear):");
        QueueNode current = front;
        while (current != null){
            System.out.println(" - " + current.data.studentNo + " | " + current.data.name + " | " + current.data.serviceType + " | " + current.data.serviceTime + " min");
            current = current.next;

        }
    }
}





