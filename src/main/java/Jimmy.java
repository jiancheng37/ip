import java.util.Scanner;

public class Jimmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("    __________________________________________________");
        System.out.println("    Hello! I'm Jimmy. What can I do for you?");
        System.out.println("    __________________________________________________");
        while (true) {
            String input = sc.nextLine();
            System.out.println("    __________________________________________________");
            System.out.println("    " + input);
            System.out.println("    __________________________________________________");
            if (input.equals("bye")) {
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    __________________________________________________");
                break;
            }
        }
        sc.close();
    }
}
