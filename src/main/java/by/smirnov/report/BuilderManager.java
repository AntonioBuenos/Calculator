package by.smirnov.report;

import by.smirnov.service.ResManager;

import java.util.ArrayList;
import java.util.List;

public class BuilderManager {

    public static List<ReportPart> data;

    static {
        data = new ArrayList<>();
    }

    public static void chooseReport(String command) {
        Builder builder;
        if (command.equalsIgnoreCase("s")) builder = new ShortReportBuilder();
        else if (command.equalsIgnoreCase("l")) builder = new LongReportBuilder();
        else return;
        Report report = builder.createReport();
        builder.fillReport();
        report.writeToFile();
    }

    public static void toReport(String message) {
        ReportPart part = new ReportPart(ResManager.getTime());
        part.setMessage(message);
        BuilderManager.data.add(part);
    }

    public static void toReport(String date, String message) {
        ReportPart part = new ReportPart(date);
        part.setMessage(message);
        BuilderManager.data.add(part);
    }

    public static void toReport(Throwable e) {
        ReportPart part = new ReportPart(ResManager.getTime());
        part.setException(e);
        BuilderManager.data.add(part);
    }

}
