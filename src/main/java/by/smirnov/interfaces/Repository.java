package by.smirnov.interfaces;

import by.smirnov.entity.Var;
import by.smirnov.exception.CalcException;

public interface Repository {
    Var saveVar(String name, Var variable) throws CalcException;

    Var get(String name) throws CalcException;
}
