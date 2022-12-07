package com.kostenko.node.impl;

import com.kostenko.node.NodeService;

import java.util.stream.IntStream;

import static com.kostenko.util.Constants.*;

public class DefaultNodeService implements NodeService {
    @Override
    public Double[] getNodes() {
        double h = (END_RANGE - START_RANGE)/(COUNT_OF_NODES - 1);
        return IntStream.range(0, COUNT_OF_NODES)
                .mapToObj(i -> START_RANGE + h * i)
                .toArray(Double[]::new);
    }
}
