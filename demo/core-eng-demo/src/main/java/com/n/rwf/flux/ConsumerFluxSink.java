package com.n.rwf.flux;

import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class ConsumerFluxSink<T> implements Consumer<FluxSink<T>> {

    private FluxSink<T> f;
    @Override
    public void accept(FluxSink<T> tFluxSink) {
        System.out.println("accept "+tFluxSink);
        f = tFluxSink;
    }

    public FluxSink<T> getF() {
        return f;
    }
}
