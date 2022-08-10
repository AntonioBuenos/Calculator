package by.smirnov.service;

import by.smirnov.constants.Patterns;
import by.smirnov.entity.Matrix;
import by.smirnov.entity.Scalar;
import by.smirnov.entity.Var;
import by.smirnov.entity.Vector;
import by.smirnov.exception.CalcException;
import by.smirnov.interfaces.Repository;

import java.util.Objects;

import static by.smirnov.constants.Wordings.BAD_STRING;
import static by.smirnov.service.ResManager.INSTANCE;

public class VarCreator {

    private final Repository repository;

    public VarCreator(Repository repository) {
        this.repository = repository;
    }

    public Var createVar(String operand) throws CalcException {
        Var result;
        Parser parser = new Parser(repository, new VarCreator(repository));
        operand = parser.deBrace(operand);
        if (operand.matches(Patterns.SCALAR)) result = new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR)) result = new Vector(operand);
        else if (operand.matches(Patterns.MATRIX)) result = new Matrix(operand);
        else result = repository.get(operand);
        if (Objects.isNull(result)) {
            throw new CalcException(INSTANCE.getString(BAD_STRING), operand);
        }
        return result;
    }
}
