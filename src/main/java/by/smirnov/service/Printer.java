package by.smirnov.service;

import by.smirnov.entity.Var;
import by.smirnov.exception.CalcException;

import java.io.PrintStream;
import java.util.Objects;

import static by.smirnov.constants.Wordings.ERR;
import static by.smirnov.service.ResManager.INSTANCE;

public class Printer {

    private final PrintStream out;
    private final LoggerODH logger = LoggerODH.getLogInstance();


    public Printer(PrintStream out) {
        this.out = out;
    }

    public void print(Var result) {
        if (Objects.nonNull(result)) out.println(result);
    }

    public void println(String message) {
        logger.info(message);
        out.println(message);
    }

    public void print(CalcException e) {
        logger.error(INSTANCE.getString(ERR), e);
        out.printf(INSTANCE.getString(ERR), e.getMessage());
    }
}
