package by.smirnov.entity;

import by.smirnov.exception.CalcException;

import java.util.Arrays;
import java.util.StringJoiner;

import static by.smirnov.constants.Patterns.*;

public class Matrix extends Var {

    private final double[][] values;

    Matrix(double[][] values) {
        this.values = values;
        for (int i = 0; i < values.length; i++) {
            this.values[i] = Arrays.copyOf(values[i],values[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this.values = matrix.values;
    }

    public Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll(SPACES, "").replaceAll(DOUBLE_CURLY, "");
        String[] array = strMatrix.split(MATRIX_INTER);
        String[][] multiArray = new String[array.length][];
        double[][] toDouble = new double[array.length][];
        for (int i = 0; i < multiArray.length; i++) {
            multiArray[i] = array[i].split(",");
            double[] buffer = new double[multiArray[i].length];
            for (int j = 0; j < multiArray[i].length; j++) {
                buffer[j] = Double.parseDouble(multiArray[i][j]);
            }
            toDouble[i] = buffer;
        }
        this.values = toDouble;
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(",", "{", "}");
        for (double[] doubles : values) {
            StringJoiner sj = new StringJoiner(",", "{", "}");
            for (double value : doubles) {
                if (Math.round(value) == value) {
                    sj.add(String.valueOf((int) value));
                } else {
                    sj.add(String.valueOf(value));
                }

            }
            joiner.add(sj.toString());
        }
        return joiner.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[][] add = new double[this.values.length][];
            for (int i = 0; i < add.length; i++) {
                add[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < add[i].length; j++) {
                    add[i][j] = add[i][j] + scalar.getValue();
                }
            }
            return new Matrix(add);
        }
        else if (other instanceof Matrix matrix) {
            double[][] add = new double[this.values.length][];
            for (int i = 0; i < add.length; i++) {
                add[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < add[i].length; j++) {
                    add[i][j] = add[i][j] + matrix.values[i][j];
                }
            }
            return new Matrix(add);
        }
        else return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {

        if (other instanceof Scalar scalar) {
            double[][] sub = new double[this.values.length][];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] = sub[i][j] - scalar.getValue();
                }
            }
            return new Matrix(sub);
        }
        else if (other instanceof Matrix matrix) {
            double[][] sub = new double[this.values.length][];
            for (int i = 0; i < sub.length; i++) {
                sub[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < sub[i].length; j++) {
                    sub[i][j] = sub[i][j] - matrix.values[i][j];
                }
            }
            return new Matrix(sub);
        }
        else return super.add(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar scalar) {
            double[][] mul = new double[this.values.length][];
            for (int i = 0; i < mul.length; i++) {
                mul[i] = Arrays.copyOf(values[i], values[i].length);
                for (int j = 0; j < mul[i].length; j++) {
                    mul[i][j] = mul[i][j] * scalar.getValue();
                }
            }
            return new Matrix(mul);
        }
        else if (other instanceof Vector vector) {
            int vectorLength = vector.getValues().length;
            double[] result = new double[vectorLength];
            for (int i = 0; i < this.values.length; i++) {
                for (int j = 0; j < vectorLength; j++) {
                    if(j> this.values.length) break;
                    result[i] = result[i] + this.values[i][j] * vector.getValues()[j];
                }
            }
            return new Vector(result);
        }
        else if (other instanceof Matrix matrix) {
            double[][] result = new double[this.values.length][matrix.values[0].length];
            for (int i = 0; i < this.values.length; i++) {
                for (int j = 0; j < matrix.values[0].length; j++) {
                    for (int k = 0; k < matrix.values.length; k++) {
                        result[i][j] = result[i][j] + this.values[i][k] * matrix.values[k][j];
                    }
                }
            }
            return new Matrix(result);
        }
        else return super.mul(other);
    }

}

