package by.smirnov.entity;

import by.smirnov.exception.CalcException;

import static by.smirnov.constants.Wordings.DIV_ZERO;
import static by.smirnov.service.ResManager.INSTANCE;

public class Scalar extends Var {

private final double value;

    public double getValue() {
        return value;
    }

    Scalar(double value) {
        this.value = value;
    }

    public Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar scalar) {
            double add = this.value + scalar.value;
            return new Scalar(add);
        }
        else return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar scalar) {
            double sub = this.value - scalar.value;
            return new Scalar(sub);
        }
        else return new Scalar(-1).mul(other).add(this);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar scalar) {
            double mul = this.value * scalar.value;
            return new Scalar(mul);
        }
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar scalar) {
            if(((Scalar) other).value == 0)
                throw new CalcException(INSTANCE.getString(DIV_ZERO), this);
            double div = this.value / scalar.value;
            return new Scalar(div);
        }
        else return super.div(other);
    }
}
