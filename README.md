# camel-transacted-multicast

There seems to be a deadlock situation caused by using a multicast in a transacted context.
                         
The following routes illustrate the problem:

    from("direct:route1")
        .transacted()
        .to("direct:route2")
        .log("will never get here");
    
    from("direct:route2")
        .multicast()
            .to("log:r.test", "log:r.test")
        .end();
      
## Running

To run the example, simply type

    mvn test

The route should get hung up and the test will not complete.


