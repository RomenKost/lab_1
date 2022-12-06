package com.kostenko.function.impl;

import com.kostenko.function.CustomFunction;

public class DefaultCustomFunction implements CustomFunction {
    @Override
    public double calculate(double x) {
        return x*x*x - 3*x*x - 14*x - 8;
    }
}
