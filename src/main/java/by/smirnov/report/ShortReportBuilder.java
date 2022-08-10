package by.smirnov.report;

import by.smirnov.service.ResManager;

import java.util.Objects;
import java.util.StringJoiner;

import static by.smirnov.constants.Wordings.*;
import static by.smirnov.report.BuilderManager.data;
import static by.smirnov.service.ResManager.INSTANCE;

public class ShortReportBuilder extends Builder {

    public ShortReportBuilder() {
        super();
    }

    @Override
    void fillReport() {
        StringJoiner joiner = new StringJoiner("\n");
        joiner.add(INSTANCE.getString(TITLE_SHORT));
        for (ReportPart part : data) {
            if (Objects.nonNull(part.message)) {
                if(part.message.equals("start")) joiner.add(ResManager.getDate()
                        + " - " + INSTANCE.getString(REPORT_START));
                else joiner.add(part.message);
            }
            if (Objects.nonNull(part.exception)) joiner.add(INSTANCE.getString(REPORT_ERROR)
                    + part.exception.getClass().getSimpleName());
        }
        joiner.add(ResManager.getDate() + " - " + INSTANCE.getString(REPORT_END));
        Report.reportText = joiner.toString();
    }
}
