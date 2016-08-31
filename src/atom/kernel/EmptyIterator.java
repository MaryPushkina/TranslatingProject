/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.kernel;

import java.util.Iterator;

/**
 * Пустой итератор
 * @author Жиряков
 */
public class EmptyIterator<T> implements Iterable<T>
{

  @Override
  public Iterator<T> iterator()
  {
    return new Iterator<T>()
    {

      @Override
      public boolean hasNext()
      {
        return false;
      }

      @Override
      public T next()
      {
        return null;
      }

      @Override
      public void remove()
      {
        
      }
    };
  }
  
}
