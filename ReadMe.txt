Flux.zip(a,b,c)                                                                 -> It will return as a tuple.
    .map(t -> new String(t.getT1() , t.getT2() , t.getT3());                    -> We can access by getT1() , getT2() , getT3()

a.zipWith(b)                                                                    -> It is used to create tuple for 2 objects.It will return as a tuple for the 2 objects.
    .map(t -> new String(t.getT1() , t.getT2());                                -> We can access by getT1() , getT2()

studentFlux.map()                                                               -> It takes any Function interface. It will return as Flux.  It  will process synchronously.

studentFlux.flatMap()                                                           -> It takes any Function interface as Publisher. It will return as Flux. It will process Asynchronously.
