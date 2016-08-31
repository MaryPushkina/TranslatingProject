/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.kernel;

/**
 * Интерфейс критерия поиска объекта, удовлетворяющего критерию
 * @author Жиряков
 * @param <T> Тип объектов в множестве объектов поиска
 */
public interface ICriteria<T>
{
  /**Определить, соответствует ли объект obj критерию.
   * @param obj Объект для анализа
   * @return true - объект соответствует критерию, false -иначе*/
    boolean Match(T obj);
}
