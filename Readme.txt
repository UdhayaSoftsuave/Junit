
assertIterableEquals not there in junit 4. It's available only in junit 5.

assertEquals() ---> equals() method to validate if the two objects are equal whereas
assertSame() ---> the operator == to validate if two objects are equal.

Lazy assert: It will read and execute the message only when we are occuring error.

Assumptions.assumeTrue(true/false); It will execute the test case only when we receive true.