public class Main {

    public static void main(String[] args) {

        Student maria = new Student(
            221045678,
            "Maria",
            "Registration",
            12
        );

        System.out.println("Student Number: " + maria.studentNumber);
        System.out.println("Name: " + maria.studentName);
        System.out.println("Service Type: " + maria.serviceType);
        System.out.println("Estimated Service Time: "
                           + maria.estimatedServiceTime + " minutes");
    }}