/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Briggeman.Tuples;
import java.util.Iterator;
/**
 * An Iterator class for tuples. Does not support remove.
 * @author Chris
 */
public class TupleIterator implements Iterator
{
    private Tuple currentTuple;
    private Pair begin;
    private Pair current;
    private boolean beginning;
    
    public TupleIterator(Tuple aTup)
    {
        this.currentTuple = aTup;
        this.begin = aTup.beginning;
        this.current = begin;
        this.beginning = true;
    }
    
    @Override
    public boolean hasNext()
    {
        return this.current.hasNext();
    }
    
    @Override
    public Pair next()
    {
        if(!(this.hasNext()))
        {
            return null;
        }
       
       if(beginning == true)
       {
           beginning = false;
           return begin;
       }
       
       current=current.getNext();
       return current;
    }
    
    @Override
    public void remove()
    {
        
    }
}
