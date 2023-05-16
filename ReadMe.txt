Flux.zip(a,b,c)                                                                 -> It will return as a tuple.
    .map(t -> new String(t.getT1() , t.getT2() , t.getT3());                    -> We can access by getT1() , getT2() , getT3()

a.zipWith(b)                                                                    -> It is used to create tuple for 2 objects.It will return as a tuple for the 2 objects.
    .map(t -> new String(t.getT1() , t.getT2());                                -> We can access by getT1() , getT2()