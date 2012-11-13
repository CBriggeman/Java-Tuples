/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Briggeman.Tuples;

/**
 *
 * @author Chris Briggeman
 */
public class Pair<T1, T2>
{
   private T1 a;
   private T2 b;
   /*
    * Need wildcards for the next pair, so that the linked pairs
    * can be different types.
    */
   Pair<? extends Object, ? extends Object> nextPair = null;
   boolean hasNext = false;
   public Pair()
   {
       
   }
   public Pair(T1 a1)
   {
       this.a = a1;
       this.b = null;
       
   }
   public Pair(Pair<?,?> aPair)
   {
       a = (T1)aPair.geta();
       b = (T2)aPair.getb();
   }
   public Pair(T1 a1, T2 b1)
   {
       this.a = a1;
       this.b = b1;
       nextPair = null;
   }
   protected Pair(T1 a1, Pair<? extends Object, ? extends Object> aPair)
   {
       
       this.a = a1;
       this.b = null;
      
       nextPair = aPair;
       hasNext = true;
   }
    
   public Pair get()
   {
       return this;
   }
   public T1 geta()
   {
       return this.a;
   }
   public T2 getb()
   {
       return this.b;
   }
   protected Pair<? extends Object, ? extends Object> getNext()
   {
       return nextPair;
   }
   protected boolean hasNext()
   {
       return hasNext;
   }
  
   @Override
   public String toString()
   {
       if(this.hasNext == false)
       {
           if(this.b ==null)
           {
               return String.format("%s ", a.toString());
           }
           return String.format("%s %s", a.toString(), b.toString());
       }
       else
       {
           return String.format("%s ", a.toString());
       }
   }
   
}
