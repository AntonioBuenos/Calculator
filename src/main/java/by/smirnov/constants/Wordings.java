package by.smirnov.constants;

import java.io.File;

public interface Wordings {

    String END = "end";
    String EN = "en";
    String FR = "fr";
    String JP = "jp";
    String RU = "ru";
    String BE = "be";
    String USER_DIR = "user.dir";
    String FILE_REPO = "txtfiles" + File.separator + "Vars.txt";
    String LOG_TXT = "txtfiles" + File.separator + "log.txt";
    String REPORT_TXT = "txtfiles" + File.separator + "Report.txt";
    String BASENAME = "src/main/resources.text";
    String TITLE_SHORT = "report.titleshort";
    String TITLE_LONG = "report.titlelong";
    String REPORT_END = "report.end";
    String REPORT_START = "report.start";
    String BAD_STRING = "error.badstring";
    String BAD_SIZE = "error.badsize";
    String BAD_OPER = "error.badoper";
    String DIV_ZERO = "error.zero";
    String ERR = "error.error";
    String NOT_FOUND = "error.notfound";
    String VAR_UNKNOWN = "error.varunknown";
    String NO_FILE = "error.nofile";
    String ENDING = "message.ending";
    String START = "message.start";
    String CHANGE_LOCAL = "message.changelocale";
    String CHOOSE_REPORT = "message.choosereport";
    String LOG_ERROR_FORMAT = "%s:%n%s%n%s%n%s";
    String LOG_INFO_FORMAT = "%s%nMessage date: %s";
    String REPO_FORMAT = "%s=%s%n";
    String REPORT_RESULT = "report.result";
    String REPORT_EXPRESSION = "report.expression";
    String REPORT_ERROR = "report.error";
}
