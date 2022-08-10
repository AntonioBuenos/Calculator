package by.smirnov.entity;

import by.smirnov.constants.Patterns;
import by.smirnov.exception.CalcException;
import by.smirnov.interfaces.Operation;

import static by.smirnov.constants.Wordings.BAD_OPER;
import static by.smirnov.constants.Wordings.VAR_UNKNOWN;
import static by.smirnov.service.ResManager.INSTANCE;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return INSTANCE.getString(VAR_UNKNOWN);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.ADD, other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.SUB, other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.MUL, other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(INSTANCE.getString(BAD_OPER), this, Patterns.DIV, other);
    }
}
