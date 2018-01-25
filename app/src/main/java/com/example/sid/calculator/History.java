package com.example.sid.calculator;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by sid on 23/1/18.
 */

public class History  implements Parcelable{

    private String expression;
    private double value;

    public History(String expression, double value) {
        this.expression = expression;
        this.value = value;
    }

    public History() {
    }

    protected History(Parcel in) {
        expression = in.readString();
        value = in.readDouble();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            String string = in.readString();
            History history = new History();

            String[] data = string.split(" = ");
            history.setExpression(data[0]);
            history.setValue(Double.parseDouble(data[1]));

            return history;
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return   expression + " = " + value ;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || !(o == null || getClass() != o.getClass()) && expression.equals(((History) o).getExpression());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = expression.hashCode();
        temp = Double.doubleToLongBits(value);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int describeContents() {
        return (int) value;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(this.toString());
    }
}
