package jimmy;

public class FindCommand extends Command{
    private final String input;

    public FindCommand(String input) throws JimmyException {
        super();
        this.input = input;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws JimmyException {
        ui.showMessage("Here are the matching tasks in your list:");
        int index = 1;
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.getTask(i).getName().toLowerCase().contains(input.toLowerCase())) {
                ui.showMessage((index) + ". " + tasks.getTask(i));
                index++;
            }
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
