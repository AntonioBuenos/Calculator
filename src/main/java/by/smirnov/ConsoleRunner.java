package by.smirnov;

import by.smirnov.report.BuilderManager;
import by.smirnov.service.Printer;
import by.smirnov.service.ResManager;

import static by.smirnov.constants.Wordings.START;
import static by.smirnov.service.CommandManager.inputCommand;
import static by.smirnov.service.ResManager.getDate;
import static java.lang.System.out;

public class ConsoleRunner {

    public static void main(String[] args) {
        ResManager manager = ResManager.INSTANCE;
        Printer printer = new Printer(out);
        BuilderManager.toReport(getDate(), "start");
        printer.println(manager.getString(START));
        inputCommand();
    }
}
