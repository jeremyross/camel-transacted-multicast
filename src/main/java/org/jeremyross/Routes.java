package org.jeremyross;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        getCamelContext().setMessageHistory(true);

        from("direct:route1").routeId("r.route1")
            .log(LoggingLevel.DEBUG, "Entering route: ${routeId}")
            .transacted()
            .to("direct:route2")
            .log("will never get here");

        from("direct:route2").routeId("r.route2")
            .log(LoggingLevel.DEBUG, "Entering route: ${routeId}")
            .multicast()
                .to("log:r.test", "log:r.test")
            .end();
    }
}
