/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.kernel;

/**
 * Интерфейс сравнения объектов.
 * @author Жиряков
 * @param <T> Тип сравниваемых объектов
 */
public interface IComparator<T>
{
  /**Сравнить объекты. Если объекты равны, то возвращает 0, Если obj1 меньше obj2, то возвращает -1, 
   Если obj1 больше obj2, то возвращает +1.
   * @param obj1 Первый объект для сравнения
   * @param obj2 Второй объект для сравнения
   * @return 0 , если obj1 = obj2
             +1, если obj1 < obj2
             -1, если obj1 > obj2 */
  int Compare(T obj1, T obj2);
}
