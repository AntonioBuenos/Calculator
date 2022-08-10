package by.smirnov.repository;

import by.smirnov.ConsoleRunner;
import by.smirnov.constants.Patterns;
import by.smirnov.entity.Var;
import by.smirnov.exception.CalcException;
import by.smirnov.interfaces.Repository;
import by.smirnov.service.VarCreator;
import by.smirnov.util.PathGetter;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static by.smirnov.constants.Wordings.*;
import static by.smirnov.service.ResManager.INSTANCE;

public class PersistentRepository implements Repository {
    private final Map<String, Var> vars = new HashMap<>();
    private final File path;

    public PersistentRepository() {
        String fileName = PathGetter.getPath(ConsoleRunner.class, FILE_REPO);
        path = new File(fileName);
        initFromFile();
    }

    private void initFromFile() {
        if (path.exists()){
            VarCreator varCreator = new VarCreator(this);
            try (BufferedReader reader = new BufferedReader (new FileReader(path))){
                while (reader.ready()){
                    String line = reader.readLine();
                    String [] parts = line.split(Patterns.EQ, 2);
                    String name = parts[0];
                    Var variable = varCreator.createVar(parts[1]);
                    vars.put(name, variable);
                }
            } catch (IOException | CalcException e) {
                throw new RuntimeException(INSTANCE.getString(NO_FILE), e);
            }
        }
    }

    @Override
    public Var saveVar(String name, Var variable) throws CalcException {
        vars.put(name, variable);
        writeToFile();
        return variable;
    }

    private void writeToFile() throws CalcException {
        try (PrintWriter printWriter = new PrintWriter(path)){
            for (Map.Entry<String, Var> entry : vars.entrySet()) {
                printWriter.printf(REPO_FORMAT, entry.getKey(), entry.getValue());
            }

        } catch (FileNotFoundException e) {
            throw new CalcException(INSTANCE.getString(NO_FILE), e);
        }
    }

    @Override
    public Var get(String name) {
        return vars.get(name);
    }
}
