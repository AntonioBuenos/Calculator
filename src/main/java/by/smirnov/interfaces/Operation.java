package by.smirnov.interfaces;

import by.smirnov.entity.Var;
import by.smirnov.exception.CalcException;

public interface Operation {
    Var add(Var other) throws CalcException;
    Var sub(Var other) throws CalcException;
    Var mul(Var other) throws CalcException;
    Var div(Var other) throws CalcException;
}
