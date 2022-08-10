package by.smirnov.report;

public class ReportPart {
    String dateTime;
    String message;
    Throwable exception;

    public ReportPart(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }
}
