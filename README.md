Java-Tuples
===========

Java tuple class that I made from scratch. Can concat, and they are iterable. It took me a 
couple days to work out and make. The functionality is rather basic, and is a work in progress.  
For example, I have not made a way to swap elements yet. Keep in mind this is non-standard functionality,
so I would not recommend using this for commercial/performance critical projects. With that
being said, here is how to use it. Package to import is com.Briggeman.Tuples.*
One can email me at cbriggeman06@gmail.com with any questions or issues found.
This repo is my netbeans project for the library. If project is imported, its name will be just Tuple. 


To make a tuple:

You can define a variable and pass it to Tuple's constructors like this

		String greet = "Hello World!";
		Tuple aTuple = new Tuple(greet);

You can also just pass parameters directly like this

		Tuple aTuple = new Tuple("Hello World!");

You can then get an element of a tuple with get(int n) n being the element number you want.
Elements in tuples start with 0.

	    System.out.printf("%s\n", aTuple.get(0));

I have not learned how to use exception handling in Java yet, so if you use a bad index, 
the program will tell you and then return a null.

Tuple's constructors take up to 5 variables (can all be different types), after that you must
make a separate tuple and then concatenate using tupleCat(Tuple tupleB) tubleB being the tuple 
to add to original.

	   (New program)
	   String greet = "Hello ";
       String greetAgain = "world!";
       Tuple aTuple = new Tuple(greet);
       Tuple anotherTuple = new Tuple(greetAgain);
       aTuple.tupleCat(anotherTuple);
       System.out.printf("%s\n", aTuple.get(1));
	  
	  
One important thing. In order to make this all work, get(int n) returns Objects. In order to
set variables to elements in a tuple, you are going to have to cast what is returned by get() 
using (type) in front of the element returned

	   String someString = (String)aTuple.get(0);
	   System.out.printf("%s\n", someString);
	   
Finally, I had to make a basic Pair template class. You can make a pair like so

	   Pair aPair = new Pair("Hello ", "World!");

Basic constructor being Pair(T1 a, T2 b) with T1 and T2 being arbitrary types. You can then 
get each element with geta() or getb(). Not really needed, but pairs are there if you would 
like to use them. Since tuples are related to pairs, tuples can take pairs in their constructors.

Update

What is new:

I have made tuples iterable. Works just like any other iterator in Java. Iterator is over
pairs, not their values. Iterator does not support remove(). Iterator class is named TupleIterator.
Also, I have added javadoc files and a .toString() method to class Pair.

To Do:

-Post Netbeans project on github once I clean up source code.

-Add exception handling in get() method.

-Try to work on a way to swap and remove elements.