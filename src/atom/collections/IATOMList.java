/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.collections;

import atom.kernel.IComparator;
import java.util.List;

/**
 * Интерфейс динамического списка объектов, доступ к котором происходит по числовому индексу
 * @author Жиряков
 * @param <T> Тип элементов в списке
 */
public interface IATOMList<T> extends List<T>, IATOMListReader<T>
{
   
   /**
    * Добавить объект addingObject в список, если в списке еще нет равного объекта
    * @param addingObject добавляемый объект
    * @return Индекс добавленного элемента
    */
   int AddIfNotExist(T addingObject);
   
   /**
    * Изменить порядок расположения элементов на обратный
    */
   void InverseOrder();
   
   /**
    * Удалить объект из списка и возвратить индекс, из которого был удален элемент
    * @param removingObject удаляемый объект
    * @return Индекс, из которого был удален найденный объект или -1, если объект не был найден
    */
   int RemoveAndGetIndex(T removingObject);
   
   /**
    * Сортировать элементы массива
    * @param comparator Интерфейс сравнения объектов по отношению порядка ("больше-меньше-равно")
    * @return Число перестановок, которое потребовалось для сортировки
    */
   int Sort(IComparator<? super T> comparator);
   
   int add(T...addingObjects);
   
}
