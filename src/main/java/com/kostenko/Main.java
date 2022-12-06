package com.kostenko;

import com.kostenko.function.impl.DefaultCustomFunction;
import com.kostenko.method.CustomMethod;
import com.kostenko.method.dto.ResultDto;
import com.kostenko.method.impl.DichotomyMethod;
import com.kostenko.method.impl.SimpleIterationMethod;

import java.util.logging.Logger;

public class Main {
    public static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        CustomMethod simpleIterationMethod = new SimpleIterationMethod(new DefaultCustomFunction());
        ResultDto simpleIterationMethodDto = simpleIterationMethod.calculate();
        String simLog = simpleIterationMethodDto.toString();
        log.info(simLog);

        CustomMethod dichotomyMethod = new DichotomyMethod(new DefaultCustomFunction());
        ResultDto dichotomyMethodDto = dichotomyMethod.calculate();
        String dmLog = dichotomyMethodDto.toString();
        log.info(dmLog);
    }
}
