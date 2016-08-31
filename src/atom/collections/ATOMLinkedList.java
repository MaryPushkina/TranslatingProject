/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.collections;

import atom.kernel.IComparator;
import atom.kernel.ICriteria;
import java.util.LinkedList;

/*
 */
public class ATOMLinkedList<V> extends LinkedList<V> implements IATOMList<V> 
{

    public ATOMLinkedList()
    {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      /**Найти первый объект, соответствующий критерию
   * @param criteria Критекрий поиска объекта
   * @return Найденный объект или null, если объект не найден*/
   @Override 
   public  V FindFirst(ICriteria<? super V> criteria)
   {
     for (V obj : this)
       if ( criteria.Match(obj)) return obj;

     return null;
   }
   
         /**Найти первый объект, равный serachTemplate
   * @param serachTemplate
   * @return   Найденный объект или null, если объект не найден*/
   @Override
   public V FindFirst(Object serachTemplate)
   {
     int idx = indexOf(serachTemplate);
     return (idx>=0)? get(idx) : null;
   }
   

    @Override
    public int indexOf(V searchTemplate, IComparator<V> comparator)
    {
      int N = this.size();
      for (int i=0; i< N; i++)
      {
        V obj = get(i);
       if ( comparator.Compare(searchTemplate, obj)==0) return i;
      }
      return -1;
    }

  @Override
  public int AddIfNotExist(V addingObject)
  {
    int idx = indexOf(addingObject);
    if (idx < 0)
    {
      add(addingObject);
      return size()-1;
    }
    else return idx;
  }
  
     /** Изменить порядок расположения элементов на обратный */
   @Override
   public void InverseOrder()
   {
    int N = (int)Math.floor(size()/2);
    for (int i=0; i< N; i++)
    {
      int pairIndex = N-i;
      V tmp = get(i);
      set(i, get(pairIndex));
      set(pairIndex,tmp);
    }
   }

     /**
    * Удалить объект из списка и возвратить индекс, из которого был удален элемент
    * @param removingObject удаляемый объект
    * @return Индекс, из которого был удален найденный объект или -1, если объект не был найден
    */
   @Override
   public int RemoveAndGetIndex(V removingObject)
   {
      int removeIndex = indexOf(removingObject);
      if (removeIndex >=0)
      {
        remove(removeIndex);
        return removeIndex;
      }
      else
         return -1;
   }
   
    /**
    * Сортировать элементы массива по возрастанию элементов
    * @param comparator Интерфейс сравнения объектов по отношению порядка ("больше-меньше-равно")
    * @return Число перестановок, которое потребовалось для сортировки
    */
   @Override
  public int Sort(IComparator<? super V> comparator)
  {
    int replaceCounter = 0;
    int N = size();
    for (int i = 0; i < N - 2; i++)
    {
      V targetElement = get(i);
      for (int j = i+1; j < N - 1; j++)
      {
        V currentElement = get(j);
        int orderFactor = comparator.Compare(targetElement, currentElement);
        if (orderFactor > 0)
        { // Согласно отношению порядка элемент currentElement должен идти раньше targetElement
          set(i,currentElement);
          set(j,targetElement);
          replaceCounter++;
         }
      }
    }

    return replaceCounter;
  }
  
      /**
     * добавить элементы в коллекцию
     * @param addingObjects Список добавляемых элементов
     * @return Число добавленных элементов
     */
   @Override
   public int add(V...addingObjects)
   {
      int addedCounter = 0;
      for (V obj : addingObjects)
      {
          boolean isSuccess = add(obj);
          if (isSuccess) addedCounter++;
      }
      
      return addedCounter;
   }
   
}
