import java.util.ArrayList;
import java.util.Scanner;

public class Jimmy {
    public static void main(String[] args) {
        ArrayList<Task> list = new ArrayList<>();
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
                System.out.println("    Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("     " + (i + 1) + "." + list.get(i));
                }
                System.out.println("    __________________________________________________");

            } else if (input.startsWith("mark")) {
                String[] words = input.split(" ");
                
                if (words.length != 2) {
                    System.out.println("    __________________________________________________");
                    System.out.println("    Error: Please provide only one number after 'mark'.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                System.out.println("    __________________________________________________");
                try {
                    int taskIndex = Integer.parseInt(words[1]) - 1;
                    if (taskIndex >= 0 && taskIndex < list.size()) {
                        list.get(taskIndex).mark();
                        System.out.println("    Nice! I've marked this task as done:");
                        System.out.println("      " + list.get(taskIndex));
                    } else {
                        System.out.println("    Error: The task does not exist!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("    Error: '" + words[1] + "' is not a valid number.");
                }
                System.out.println("    __________________________________________________");

            } else if (input.startsWith("unmark")) {
                String[] words = input.split(" ");
                if (words.length != 2) {
                    System.out.println("    __________________________________________________");
                    System.out.println("    Error: Please provide only one number after 'unmark'.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                System.out.println("    __________________________________________________");
                try {
                    int taskIndex = Integer.parseInt(words[1]) - 1;
                    if (taskIndex >= 0 && taskIndex < list.size()) {
                        list.get(taskIndex).unmark();
                        System.out.println("    OK, I've marked this task as not done yet:");
                        System.out.println("      " + list.get(taskIndex));
                    } else {
                        System.out.println("    Error: The task does not exist!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("    Error: '" + words[1] + "' is not a valid number.");
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
                list.add(task);
                System.out.println("    __________________________________________________");
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println("     Now you have " + list.size() + " tasks in the list.");
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
                list.add(task);
                System.out.println("    __________________________________________________");
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println("     Now you have " + list.size() + " tasks in the list.");
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
                list.add(task);
                System.out.println("    __________________________________________________");
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task);
                System.out.println("     Now you have " + list.size() + " tasks in the list.");
                System.out.println("    __________________________________________________");

            } else if (input.startsWith("delete")) {
                String[] words = input.split(" ");
                if (words.length != 2) {
                    System.out.println("    __________________________________________________");
                    System.out.println("    Error: Please provide only one number after 'delete'.");
                    System.out.println("    __________________________________________________");
                    continue;
                }

                System.out.println("    __________________________________________________");
                try {
                    int taskIndex = Integer.parseInt(words[1]) - 1;
                    if (taskIndex >= 0 && taskIndex < list.size()) {
                        Task removedTask = list.remove(taskIndex);
                        System.out.println("     Noted. I've removed this task:");
                        System.out.println("       " + removedTask);
                        System.out.println("     Now you have " + list.size() + " tasks in the list.");
                    } else {
                        System.out.println("    Error: The task does not exist!");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("    Error: '" + words[1] + "' is not a valid number.");
                }
                System.out.println("    __________________________________________________");

            } else {
                System.out.println("    __________________________________________________");
                System.out.println("     Invalid command. Try again!");
                System.out.println("    __________________________________________________");
            }
        }

        sc.close();
    }
}
