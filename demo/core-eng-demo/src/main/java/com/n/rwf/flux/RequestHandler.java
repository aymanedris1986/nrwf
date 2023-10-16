package com.n.rwf.flux;

import com.n.rwf.flux.ConsumerFluxSink;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

public class RequestHandler {
    Flux<String> mainTube;
    ConnectableFlux<String> subTube;
    private ConsumerFluxSink<String> fs;
    public RequestHandler(){
        fs = new ConsumerFluxSink<>();
        mainTube = Flux.create(fs);
        subTube = mainTube.publish();


        subTube.subscribe(s -> {
            System.out.println("n sink 1 "+s);
        });
        subTube.filter( s -> s != null && s.contains("hello")).subscribe(
                s -> {
                    System.out.println(" hello baaack ");
                }
        );
        subTube.subscribe(s -> {
            System.out.println("n sink 2 "+s);
        });
        subTube.connect();
    }

    public void startProcess(String startAction){
        System.out.println("start action ");
        fs.getF().next(startAction);
    }
}
