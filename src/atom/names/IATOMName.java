/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;

import java.util.UUID;

/**
 * Интерфейс имени, с которым ассоциирован числовой и строковый идентфикатор
 * @author Жиряков С.М.
 */
public interface IATOMName
{
  /**Локальный идентификатор*/
   long IDName();
   
   /**Глобальный уникальный идентификатор имени*/
   UUID GUIDName(); 
   
   
   //String StrID();
   
   /**Получить локальное имя (уникально в прнеделах своего пространства имен)
   * @return Локальное имя*/
   String LocalName();
   
   /**Получить имя пространства имен, внутри которого определено данное имя
   * @return Имя пространства имен */
   IATOMName DefinitionNamespace();
   
   /**Установить имя пространства имен, в котором располагается данне имя
   * @param namespace пространство имен в котором определено имя*/
   void setDefinitionNamespace(IATOMName namespace);
   /**Получить полное имя
   * @return Полное имя*/
   String FullName();
   
   
   /**Строковое представление имени
   * @return Строковое представление имени*/
   @Override 
   String toString();
   
   @Override
   boolean equals(Object obj);    
   
   @Override
   int hashCode();
   
   /**Проверить, равны ли два имени
   * @param name Имя для сравнения с текущим на равенство
   * @return true - имена равны, false - иначе*/
   boolean IsEquals(IATOMName name);
  
}
