/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.collections;

import atom.kernel.IComparator;
import atom.kernel.ICriteria;


/*
 */
public class ATOMList<T> extends java.util.ArrayList<T> implements IATOMList<T>
{
    /**Найти первый объект, соответствующий критерию
   * @param criteria Критекрий поиска объекта
   * @return Найденный объект или null, если объект не найден*/
   @Override 
   public  T FindFirst(ICriteria<? super T> criteria)
   {
     for (T obj : this)
     {
       if (criteria.Match(obj))
          return obj;
       
     }

     return null;
   }
   
      /**Найти первый объект, равный serachTemplate
   * @param serachTemplate
   * @return   Найденный объект или null, если объект не найден*/
   @Override
   public T FindFirst(Object serachTemplate)
   {
     int idx = indexOf(serachTemplate);
     return (idx>=0)? get(idx) : null;
   }
   
   /**Найти индекс объекта в коллекции равный заданному searchObject
     * @param searchTemplate Объект - образец для поиска
     * @param comparator Критерий сравнения объектов
     * @return Индекс найденного объекта, -1, если объект не найден*/
    @Override 
   public int indexOf(T searchTemplate, IComparator<T> comparator)
   {
       int N = this.size();
       for (int i=0; i< N; i++)
       {
        T obj = get(i);
        if ( comparator.Compare(searchTemplate, obj)==0) return i;
       }
     return -1;
   }
   
      /**
    * Добавить объект addingObject в список, если в списке ее нет равного объекта
    * @param addingObject добавляемый объект
    */
   @Override
   public int AddIfNotExist(T addingObject)
   {
     int idx = indexOf(addingObject);
     if (idx < 0)
     { 
       add(addingObject);
       return size()-1;
     }
     return idx;
     
   }
   
   /** Изменить порядок расположения элементов на обратный */
   @Override
   public void InverseOrder()
   {
    int N = (int)Math.floor(size()/2);
    for (int i=0; i< N; i++)
    {
      int pairIndex = size()-i-1;
      T tmp = get(i);
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
   public int RemoveAndGetIndex(T removingObject)
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
  public int Sort(IComparator<? super T> comparator)
  {
    int replaceCounter = 0;
    int N = size();
    for (int i = 0; i < N - 2; i++)
    {
      T targetElement = get(i);
      for (int j = i+1; j < N - 1; j++)
      {
        T currentElement = get(j);
        int orderFactor = comparator.Compare(targetElement, currentElement);
        if (orderFactor > 0)
        { // Согласно отношению порядка элемент currentElement должен идти раньше targetElement
          set(i,currentElement);
          set(j,targetElement);
          targetElement = currentElement;
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
   public int add(T...addingObjects)
   {
      int addedCounter = 0;
      for (T obj : addingObjects)
      {
          boolean isSuccess = add(obj);
          if (isSuccess) addedCounter++;
      }
      
      return addedCounter;
   }
  
}
