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
            }
            else if (input.equals("list")) {
                System.out.println("    __________________________________________________");
                System.out.println("    Here are the tasks in your list!");
                for (int i = 0; i < index; i++) {
                    Task task = list[i];
                    if (task.isCompleted()) {
                        System.out.println("    " + (i + 1) + ". " + "[X] " + task.getName());
                    }
                    else {
                        System.out.println("    " + (i + 1) + ". " + "[ ] " + task.getName());
                    }
                }
                System.out.println("    __________________________________________________");
            }
            else if (input.startsWith("mark")) {
                System.out.println("    __________________________________________________");
                String[] words = input.split(" ");
                if (words.length != 2) {
                    System.out.println("    Error: Please provide only one number after 'mark'.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                String secondWord = words[1];
                try {
                    int x = Integer.parseInt(secondWord);
                    if (x <= index) {
                        System.out.println("    Nice! I've marked this task as done");
                        System.out.println("    [X] " + list[x - 1].getName());
                        list[x - 1].mark();
                    } else {
                        System.out.println("    Error: The task does not exist!");
                    }
            
                } catch (NumberFormatException e) {
                    System.out.println("    Error: '" + secondWord + "' is not a valid number.");
                    continue;
                }
                System.out.println("    __________________________________________________");
            }
            else if (input.startsWith("unmark")) {
                System.out.println("    __________________________________________________");
                String[] words = input.split(" ");
                if (words.length != 2) {
                    System.out.println("    Error: Please provide only one number after 'unmark'.");
                    System.out.println("    __________________________________________________");
                    continue;
                }
                String secondWord = words[1];
                try {
                    int x = Integer.parseInt(secondWord);
                    if (x <= index) {
                        System.out.println("    OK, I've marked this task as not done yet:");
                        System.out.println("    [ ] " + list[x - 1].getName());
                        list[x - 1].unmark();
                    } else {
                        System.out.println("    Error: The task does not exist!");
                    }
            
                } catch (NumberFormatException e) {
                    System.out.println("    Error: '" + secondWord + "' is not a valid number.");
                    continue;
                }
                System.out.println("    __________________________________________________");
            }
            else {
                System.out.println("    __________________________________________________");
                System.out.println("    added: " + input);
                System.out.println("    __________________________________________________");
                list[index] = new Task(input);
                index++;
            }
        }
        sc.close();
    }
}
