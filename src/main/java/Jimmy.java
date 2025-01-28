import java.util.Scanner;

public class Jimmy {
    public static void main(String[] args) {
        String[] list = new String[100];
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
                for (int i = 0; i < index; i++) {
                    System.out.println("    " + (i + 1) + ". " + list[i]);
                }
                System.out.println("    __________________________________________________");
            }
            else {
                System.out.println("    __________________________________________________");
                System.out.println("    added: " + input);
                System.out.println("    __________________________________________________");
                list[index] = input;
                index++;
            }
        }
        sc.close();
    }
}
