package by.smirnov.service;

import by.smirnov.entity.Var;
import by.smirnov.exception.CalcException;
import by.smirnov.interfaces.Repository;
import by.smirnov.report.BuilderManager;
import by.smirnov.repository.PersistentRepository;

import java.util.Locale;
import java.util.Scanner;

import static by.smirnov.constants.Wordings.*;
import static by.smirnov.report.BuilderManager.toReport;
import static by.smirnov.service.ResManager.INSTANCE;
import static java.lang.System.in;
import static java.lang.System.out;

public class CommandManager {
    private CommandManager() {
    }

    public static void inputCommand() {
        ResManager manager = INSTANCE;
        Scanner scanner = new Scanner(in);
        String line;
        Repository repository = new PersistentRepository();
        VarCreator varCreator = new VarCreator(repository);
        Parser parser = new Parser(repository, varCreator);
        Printer printer = new Printer(out);
        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.equalsIgnoreCase(END)) {
                out.println(INSTANCE.getString(CHOOSE_REPORT));
                BuilderManager.chooseReport(scanner.nextLine());
                printer.println(INSTANCE.getString(ENDING));
                break;
            } else if (line.equalsIgnoreCase(EN)) manager.setLocale(Locale.ENGLISH);
            else if (line.equalsIgnoreCase(RU)) manager.setLocale(new Locale("ru", "RU"));
            else if (line.equalsIgnoreCase(BE)) manager.setLocale(new Locale("be", "BE"));
            else if (line.equalsIgnoreCase(FR)) manager.setLocale(Locale.CANADA_FRENCH);
            else if (line.equalsIgnoreCase(JP)) manager.setLocale(new Locale("jp", "JP"));
            else {
                toReport(INSTANCE.getString(REPORT_EXPRESSION) + line);
                try {
                    Var result = parser.calc(line);
                    printer.print(result);
                    toReport(INSTANCE.getString(REPORT_RESULT) + result);
                } catch (CalcException e) {
                    printer.print(e);
                    toReport(e);
                }
            }
        }
    }
}
