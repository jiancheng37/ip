import java.util.Scanner;

public class Jimmy {
    public static void main(String[] args) {
        Task[] list = new Task[100];
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("    __________________________________________________");
        System.out.println("    Hello! I'm Jimmy. What can I do for you?");
        System.out.println("    __________________________________________________");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {

                System.out.println("    __________________________________________________");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    __________________________________________________");
                break;

            } else if (input.equals("list")) {

                System.out.println("    __________________________________________________");
                System.out.println("    Here are the tasks in your list!");
                for (int i = 0; i < index; i++) {
                    System.out.println("     " + (i + 1) + "." + list[i]);
                }
                System.out.println("    __________________________________________________");

            } else if (input.startsWith("mark")) {

                System.out.println("    __________________________________________________");
                String[] words = input.split(" ");
                if (words.length != 2) {
                    System.out.println("    Error: Please provide only one number after 'mark'.");
                    System.out.println("    __________________________________________________");
                    continue;
                }

                String secondWord = words[1];

                try {
                    int taskIndex = Integer.parseInt(secondWord) - 1;
                    if (taskIndex >= 0 && taskIndex < index) {
                        list[taskIndex].mark();
                        System.out.println("    Nice! I've marked this task as done");
                        System.out.println("    " + list[taskIndex]);
                    } else {
                        System.out.println("    Error: The task does not exist!");
                    }
            
                } catch (NumberFormatException e) {
                    System.out.println("    Error: '" + secondWord + "' is not a valid number.");
                    continue;
                }
                System.out.println("    __________________________________________________");
            } else if (input.startsWith("unmark")) {
                System.out.println("    __________________________________________________");
                String[] words = input.split(" ");
                if (words.length != 2) {
                    System.out.println("    Error: Please provide only one number after 'unmark'.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                String secondWord = words[1];
                try {
                    int taskIndex = Integer.parseInt(secondWord) - 1;
                    if (taskIndex >= 0 && taskIndex < index) {
                        list[taskIndex].unmark();
                        System.out.println("    OK, I've marked this task as not done yet:");
                        System.out.println("    " + list[taskIndex]);
                    } else {
                        System.out.println("    Error: The task does not exist!");
                    }
            
                } catch (NumberFormatException e) {
                    System.out.println("    Error: '" + secondWord + "' is not a valid number.");
                    continue;
                }
                System.out.println("    __________________________________________________");
            } else if (input.startsWith("todo")) {
                if (input.trim().equals("todo")) {
                    System.out.println("    __________________________________________________");
                    System.out.println("    Error: The description of a todo cannot be empty.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                String name = input.substring(5).trim();
                Todo task = new Todo(name);
                list[index++] = task;
                System.out.println("    __________________________________________________");
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println("     Now you have " + index + " tasks in the list.");
                System.out.println("    __________________________________________________");
            } else if (input.startsWith("deadline")) {
                if (input.trim().equals("deadline")) {
                    System.out.println("    __________________________________________________");
                    System.out.println("    Error: The description of a deadline cannot be empty.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                String[] parts = input.substring(9).split(" /by ");
                if (parts.length < 2 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
                    System.out.println("    Error: Please provide a deadline using '/by'.");
                    continue;
                }
                Deadline task = new Deadline(parts[0].trim(), parts[1].trim());
                list[index++] = task;
                System.out.println("    __________________________________________________");
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println("     Now you have " + index + " tasks in the list.");
                System.out.println("    __________________________________________________");
            } else if (input.startsWith("event")) {
                if (input.trim().equals("event")) {
                    System.out.println("    __________________________________________________");
                    System.out.println("    Error: The description of an event cannot be empty.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                String[] parts = input.substring(6).split(" /from | /to ");
                if (parts.length < 3 || parts[0].trim().isEmpty() || parts[1].trim().isEmpty() || parts[2].trim().isEmpty()) {
                    System.out.println("    Error: Please provide an event using '/from' and '/to'.");
                    continue;
                }
                Event task = new Event(parts[0].trim(), parts[1].trim(), parts[2].trim());
                list[index++] = task;
                System.out.println("    __________________________________________________");
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println("     Now you have " + index + " tasks in the list.");
                System.out.println("    __________________________________________________");
            } else {
                System.out.println("    __________________________________________________");
                System.out.println("     Invalid command. Try again!");
                System.out.println("    __________________________________________________");
                continue;
            }
        }
            sc.close();
    }
}
