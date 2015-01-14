AlgoritmiGenetici
=================

A compilation of genetic algorithm to solve some problems. 
I am using the [Watchmaker Framework] to implement GAs in Java.

## StringsExample
org.uncommons.watchmaker.examples.strings.StringsExample

It is a basic GA, taken from examples in the Watchmaker framework, that evolves random strings to find a target string of knowns size. Termination is when the exact string is found.

## TravelingSalesmanGA
com.rzagni.salesman.TravelingSalesmanGA

It is a generic solution to the traveling salesman problem. 

It is possible to give the cities to visit or select their number and the size of the map and they are randomly selected. Termination is by stagnation, i.e. when the best fitness in the popolation does not get better over a certain amount of generations.

[Watchmaker Framework]:http://watchmaker.uncommons.org/
