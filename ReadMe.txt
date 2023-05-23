Flux.zip(a,b,c)                                                                 -> It will return as a tuple.
    .map(t -> new String(t.getT1() , t.getT2() , t.getT3());                    -> We can access by getT1() , getT2() , getT3()

a.zipWith(b)                                                                    -> It is used to create tuple for 2 objects.It will return as a tuple for the 2 objects.
    .map(t -> new String(t.getT1() , t.getT2());                                -> We can access by getT1() , getT2()

studentFlux.map()                                                               -> It takes any Function interface. It will return as Object.  It  will process synchronously.

studentFlux.flatMap()                                                           -> It takes any Function interface as Publisher. It will return as Flux. It will process Asynchronously.Its operators subscribe eagerly.

studentFlux.flatMapSequential()                                                 -> It takes any Function interface as Publisher. It will return as Flux. It will process Asynchronously.Its operators subscribe eagerly.

studentFlux.concatMap()                                                         -> It will emit the value in sequentialOrder.But Time consumption is high. It waits for each inner completion before generating the next sub-stream and subscribing to it.

.window(n)                                                                      -> It is used to group the elements by n. It sends the data to process for next operation.

.subscribeOn(parallel())                                                        -> parallel() will process the data in different threads. The subscribeOn accept only the Schedulers.

stringFlux.subscribe(value -> System.out.println(value));
stringFlux.blockLast();                                                         -> It will block the main until it's emitting all the value.

Flux.merge(a, b)                                                               ->The merge operator combines multiple publishers into a single publisher that emits the items from all the publishers in an unordered manner.

a.mergeWith(b)                                                                 ->mergeWith is same as merge. The difference is merging only 2 Flux.