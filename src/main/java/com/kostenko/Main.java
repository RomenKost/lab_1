package com.kostenko;

import com.kostenko.function.CustomFunction;
import com.kostenko.function.impl.DefaultCustomFunction;
import com.kostenko.interpolation.InterpolationFunction;
import com.kostenko.method.CustomMethod;
import com.kostenko.method.dto.ResultDto;
import com.kostenko.method.impl.SimpleIterationMethod;
import com.kostenko.node.impl.ChebNodeService;
import com.kostenko.node.impl.DefaultNodeService;
import com.kostenko.view.Viewer;
import com.kostenko.view.impl.DefaultViewer;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    public static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        CustomFunction customFunction = new DefaultCustomFunction();

        CustomFunction defaultNodeMethod = new InterpolationFunction(new DefaultNodeService(), customFunction);

        CustomMethod simpleIterationMethod = new SimpleIterationMethod(defaultNodeMethod);
        ResultDto simpleIterationMethodDto = simpleIterationMethod.calculate();
        String simLog = simpleIterationMethodDto.toString();
        log.info(simLog);

        CustomFunction chebNodeMethod = new InterpolationFunction(new ChebNodeService(), customFunction);

        CustomMethod dichotomyMethod = new SimpleIterationMethod(chebNodeMethod);
        ResultDto dichotomyMethodDto = dichotomyMethod.calculate();
        String dmLog = dichotomyMethodDto.toString();
        log.info(dmLog);

        Viewer customFunctionViewer = new DefaultViewer();
        JFrame j = new JFrame();
        j.add((Canvas) customFunctionViewer);
        j.setSize(1000, 1000);
        j.setVisible(true);

        customFunctionViewer.setFunction(Arrays.asList(customFunction, chebNodeMethod, defaultNodeMethod));

    }
}
