package by.smirnov.repository;

import by.smirnov.entity.Var;
import by.smirnov.interfaces.Repository;

import java.util.HashMap;
import java.util.Map;

public class VarRepository implements Repository {

    private final Map<String, Var> vars = new HashMap<>();
@Override
    public Var saveVar(String name, Var variable){
        vars.put(name, variable);
        return variable;
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
