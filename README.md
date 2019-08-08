# DueDateCalculator

Dear reviewer,

As requested, I did this assigment the TDD way that is

1. Write a test
2. Write just as much code as needed to make the test pass
3. Refactor and start over

Most of the time I committed tests and business code separately
so that the commits tell a story when you look at them.

You will see that I refactored multiple times when I found
that writing a new test is difficult either because the class
under test violates the single responsibility principle or
realized that the hiearchy of dependencies is not quite right.

Build the app by issuing
```mvn clean install```
and run it by issuing
```java -jar target/duedatecalculator-0.0.1-SNAPSHOT.jar```.
