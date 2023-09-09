package com.n.rwf.flux;

import com.n.rwf.flux.ConsumerFluxSink;
import reactor.core.publisher.Flux;

public class RequestHandler {
    Flux<String> mainTube;
    private ConsumerFluxSink<String> fs;
    public RequestHandler(){
        fs = new ConsumerFluxSink<>();
        mainTube = Flux.create(fs);
        mainTube.subscribe(s -> {
            System.out.println("n sink "+s);
        });
    }

    public void startProcess(String startAction){
        System.out.println("start action ");
        fs.getF().next(startAction);
    }
}
