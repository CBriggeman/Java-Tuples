/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Briggeman.Tuples;

/**
 *This class builds nested pairs for up to 5 arguments. 
 * After that you must make separate tuples and use tupleCat().
 * The relationship between tuples and pairs is aggregate.
 * @author Chris Briggeman
 * 
 * 
 */
public class Tuple implements Iterable
{
    /*
     * First start by making null pointers. Beginning always
     * points to start of tuple.
     */
    /**
     * A pointer that always points to beginning of a Tuple.
     */
    protected Pair<?,?> beginning = null;     
    protected Pair<?,?> currentPair = null; //Ghetto iterator
    protected Pair<?,?> nextPair = null;
    
    
    /*
     * These constructors creates a tuple up to 5 arguments.
     * After that you will need to make seprate tuples and use
     * tupleCat().
     */
   
   public Tuple()
   {
        
   }
   /**
    * 
    * @param <T1> Generic Type.
    * @param type1 Generic object.
    */
   public<T1> Tuple(T1 type1)
   {
       beginning = new Pair(type1);
   }
   
   public <T1, T2> Tuple(T1 type1, T2 type2)
   {
       beginning = new Pair(type1, type2);
   }
   /*
    * Pairception
    */
   
   public<T1,T2,T3> Tuple(T1 type1,T2 type2,T3 type3)
   {
       beginning = new Pair(type1,new Pair(type2,type3));
   }
   public<T1, T2, T3, T4> Tuple(T1 type1, T2 type2, T3 type3, T4 type4)
   {
       beginning = new Pair(type1, new Pair(type2,new Pair(type3,type4)));
   }
   
   public<T1, T2, T3, T4, T5> Tuple(T1 type1, T2 type2, T3 type3, T4 type4,
                                    T5 type5)
   {
       beginning = new Pair(type1, new Pair(type2,new Pair(type3,
               new Pair(type4, type5))));
   }
   
   public Tuple(Pair aPair) 
   {
       beginning = aPair;
       
   }
   
   /*
    * Checks if there is another pair.
    */
   public boolean hasNext()
   {
        
        currentPair = beginning;
        
        if(currentPair.hasNext())
        {
            return true;
        }
        
        return false;
   }
   
   /**
    * Gets next pair.
    */
   public Pair next()
   {
       currentPair = beginning;
       if(currentPair.hasNext == false)
       {
           return null;
       }
       
       return currentPair.getNext();
   }
   
   /*
    * Now for the tricky part. Getting a value based 
    * on user defined index.
    */
   
   /**
    * Function used to retrieve given element in a tuple. 
    * @param n The number representing index to be retrieved.
    * @return Object
    */
   public Object get(int n)
   {
       Pair aPair = beginning;
       int counter = 0;
       if( n < 0)
       {
           System.out.printf("Not a valid index.\n");
           return null;
       }
       if(n == 0)
       {
           return aPair.geta();
       }
               
       
       while(aPair.hasNext)
       {
           aPair = aPair.getNext();
           counter++;
           if(counter == n)
           {
               return aPair.geta();
           }
       }
       if(counter == (n-1))
       {
           return aPair.getb();
       }
       
       System.out.printf("Used bad index.\n");
       return null;
   }
   
   /*
    * Even more tricky. Concatenating two tuples.
    */
   /**
    * Concatenates tuple to current.
    * @param tupleB Tuple that will append to current.
    */
   public void tupleCat(Tuple tupleB)
   {
       currentPair = beginning; //Have pair variable point to beginning.
       
       /*
        * This while loop just walks to end of a line of nested pairs.
        */
       while(currentPair.hasNext)
       {
           currentPair = currentPair.getNext();
       }
       
       /*
        * This actually appends new pairs. Had to be careful because
        * currentPair.b isn't always null. Have to check and 
        * carry over if defined.
        */
       if(currentPair.getb()==null)
       {
           currentPair.nextPair = new Pair(tupleB.beginning);
           currentPair.hasNext = true;
       }
       else
       {
       currentPair.nextPair = new Pair(currentPair.getb(),tupleB.beginning);
       currentPair.hasNext = true;
       }
   }
    
   /**
    * This returns an iterator over the current tuple. Works just like an 
    * iterator over standard collections. Keep in mind that this is an 
    * Iterator over Pairs, not the individual values. You will have to take
    * into consideration what your code will need to do when the iterator hits the
    * last pair.
    * 
    */
   @Override
   public TupleIterator iterator()
   {
       TupleIterator iterator;
        iterator = new TupleIterator(this);
       return iterator;
   }
   
}
