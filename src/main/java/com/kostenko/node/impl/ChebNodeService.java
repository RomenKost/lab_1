package com.kostenko.node.impl;

import com.kostenko.node.NodeService;

import java.util.stream.IntStream;

import static com.kostenko.util.Constants.*;

public class ChebNodeService implements NodeService {
    @Override
    public Double[] getNodes() {
        return IntStream.range(0, COUNT_OF_NODES)
                .mapToObj(this::getNode)
                .toArray(Double[]::new);
    }

    private Double getNode(int i) {
        return (START_RANGE + END_RANGE)/2 + ((END_RANGE - START_RANGE) / 2)
                * (-Math.cos(((2*i+1)/((double) 2*COUNT_OF_NODES + 2))*Math.PI));
    }
}
