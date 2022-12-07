package com.kostenko.function.impl;

import com.kostenko.function.CustomFunction;

public class DefaultCustomFunction implements CustomFunction {
    @Override
    public double calculate(double x) {
        return x*x*x + Math.sin(x) - 12*x + 1;
    }
}
