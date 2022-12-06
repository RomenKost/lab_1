package com.kostenko.method.dto;

public class ResultDto {
    private final int iterationCount;
    private final double result;

    public ResultDto(int iterationCount, double result) {
        this.iterationCount = iterationCount;
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "iterationCount=" + iterationCount +
                ", result=" + result +
                '}';
    }
}
