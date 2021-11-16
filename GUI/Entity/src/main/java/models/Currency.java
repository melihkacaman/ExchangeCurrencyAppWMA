package models;

public class Currency {
    private String code;
    private double curr;

    public Currency(String code, double curr) {
        this.code = code;
        this.curr = curr;
    }

    public String getCode() {
        return code;
    }

    public double getCurr() {
        return curr;
    }

    @Override
    public String toString() {
        return code + " " + curr;
    }
}
