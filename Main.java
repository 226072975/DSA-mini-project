import java.util.Scanner;
import queue.Student;
import queue.StudentQueue;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StudentQueue waitingQueue = new StudentQueue();
		StudentList studentList = new StudentList();
		int choice;

		do {
			System.out.println("\n=== SERVICE CENTRE ===");
			System.out.println("1. Add student to waiting queue");
			System.out.println("2. Serve next student");
			System.out.println("3. Display waiting queue");
			System.out.println("4. Manage student linked list");
			System.out.println("5. Daily service-time statistics");
			System.out.println("6. Sort service times");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");
			choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Student number: ");
					String studentNo = scanner.next();
					System.out.print("Name: ");
					String name = scanner.next();
					System.out.print("Service type: ");
					String serviceType = scanner.next();
					System.out.print("Estimated service time (minutes): ");
					int serviceTime = scanner.nextInt();
					waitingQueue.enqueue(new Student(studentNo, name, serviceType, serviceTime));
					break;
				case 2:
					waitingQueue.dequeue();
					break;
				case 3:
					waitingQueue.displayQueue();
					break;
				case 4:
					manageStudentList(scanner, studentList);
					break;
				case 5:
					DailyStatistics.dailyStatistics(scanner);
					break;
				case 6:
					sortServiceTimes(scanner);
					break;
				case 0:
					System.out.println("Goodbye.");
					break;
				default:
					System.out.println("Invalid option.");
			}
		} while (choice != 0);

		scanner.close();
	}

	private static void manageStudentList(Scanner scanner, StudentList studentList) {
		System.out.println("1. Insert student  2. Search student  3. Delete student  4. Display list");
		System.out.print("Choose an operation: ");
		int operation = scanner.nextInt();

		if (operation == 1) {
			System.out.print("Student number: ");
			long studentNo = scanner.nextLong();
			System.out.print("Name: ");
			String name = scanner.next();
			System.out.print("Service type: ");
			String serviceType = scanner.next();
			System.out.print("Service time (minutes): ");
			int serviceTime = scanner.nextInt();
			System.out.print("Position: ");
			int position = scanner.nextInt();
			studentList.insertStudent(studentNo, name, serviceType, serviceTime, position);
		} else if (operation == 2 || operation == 3) {
			System.out.print("Student number: ");
			long studentNo = scanner.nextLong();
			if (operation == 2) {
				studentList.searchStudent(studentNo);
			} else {
				studentList.deleteStudent(studentNo);
			}
		} else if (operation == 4) {
			studentList.displayStudents();
		} else {
			System.out.println("Invalid operation.");
		}
	}

	private static void sortServiceTimes(Scanner scanner) {
		System.out.print("Number of service times: ");
		int count = scanner.nextInt();
		if (count <= 0) {
			System.out.println("Enter at least one service time.");
			return;
		}

		int[] serviceTimes = new int[count];
		for (int i = 0; i < count; i++) {
			System.out.print("Service time " + (i + 1) + ": ");
			serviceTimes[i] = scanner.nextInt();
		}

		System.out.println("1. Selection sort  2. Insertion sort  3. Merge sort  4. Quick sort");
		System.out.print("Choose a sorting method: ");
		int sortChoice = scanner.nextInt();
		switch (sortChoice) {
			case 1:
				SortingExperiment.selectionSort(serviceTimes);
				break;
			case 2:
				SortingExperiment.insertionSort(serviceTimes);
				break;
			case 3:
				SortingExperiment.mergeSort(serviceTimes, 0, serviceTimes.length - 1);
				break;
			case 4:
				SortingExperiment.quickSort(serviceTimes, 0, serviceTimes.length - 1);
				break;
			default:
				System.out.println("Invalid sorting method.");
				return;
		}

		System.out.print("Sorted service times: ");
		for (int time : serviceTimes) {
			System.out.print(time + " ");
		}
		System.out.println();
	}
}
