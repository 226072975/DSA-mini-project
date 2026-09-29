import java.util.Scanner;

class DailyStatistics {

    static final int MAX_STUDENTS = 100;

    // Calculate and display daily service statistics
    static void dailyStatistics(Scanner scanner)
    {
        int[] serviceTimes = new int[MAX_STUDENTS];
        int numberOfStudents;

        int totalServiceTime = 0;
        int highestServiceTime;
        int lowestServiceTime;
        int servicesLongerThan10 = 0;

        // Get the number of students
        System.out.print("Enter number of students served: ");
        numberOfStudents = scanner.nextInt();

        // Enter service times
        System.out.println("\nEnter the service time for each student:");

        for (int i = 0; i < numberOfStudents; i++)
        {
            System.out.print("Student " + (i + 1) + " service time: ");
            serviceTimes[i] = scanner.nextInt();
        }

        /*
           Use the first array element as the
           starting highest and lowest value.
        */
        highestServiceTime = serviceTimes[0];
        lowestServiceTime = serviceTimes[0];

        /*
           Traverse the array and calculate
           the required statistics.
        */
        for (int i = 0; i < numberOfStudents; i++)
        {
            // Calculate total service time
            totalServiceTime = totalServiceTime + serviceTimes[i];

            // Find highest service time
            if (serviceTimes[i] > highestServiceTime)
            {
                highestServiceTime = serviceTimes[i];
            }

            // Find lowest service time
            if (serviceTimes[i] < lowestServiceTime)
            {
                lowestServiceTime = serviceTimes[i];
            }

            // Count services longer than 10 minutes
            if (serviceTimes[i] > 10)
            {
                servicesLongerThan10++;
            }
        }

        // Calculate average service time
        double averageServiceTime =
                (double) totalServiceTime / numberOfStudents;

        // Display results
        System.out.println("\n====================================");
        System.out.println("       DAILY SERVICE STATISTICS");
        System.out.println("====================================");

        System.out.printf("Total students served: %d%n",
                numberOfStudents);

        System.out.printf("Total service time: %d minutes%n",
                totalServiceTime);

        System.out.printf("Average service time: %.2f minutes%n",
                averageServiceTime);

        System.out.printf("Highest service time: %d minutes%n",
                highestServiceTime);

        System.out.printf("Lowest service time: %d minutes%n",
                lowestServiceTime);

        System.out.printf("Services longer than 10 minutes: %d%n",
                servicesLongerThan10);

        System.out.println("====================================");
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        dailyStatistics(scanner);
        scanner.close();
    }
}
