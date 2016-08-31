/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.kernel;

/**
 * Интерфейс клонирования. Позволяет сделать копию объекта.
 * @author SERGEY
 * @param <T> Тип клнируемых объектов
 */
public interface IClonable<T>
{
    /**Создать экземпляр объекта
     * @return  Экземпляр объекта, для дублирования значения атрибутов*/
   T CreateInstance(); 
   
   /**Копировать значения атрибутов данного объекта в destination
     * @param destination Объект, куда происходит копирование атрибутов*/
   void CopyTo(T destination);
   
   /**Создать копию данного объекта
     * @return Новый экземпляр объекта - клон данного объекта*/
   T Clone();
}
