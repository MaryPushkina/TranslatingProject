/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.kernel;

/**
 * Интерфейс для значений, которые могут принимать значение null
 * @author Жиряков
 * @param <TValue> Тип хранимого значения
 */
public interface INullableValue<TValue> extends IClonable<INullableValue<TValue>>
{
   boolean isNull();
   void SetNull();
   
   /*Получать значение*/
   TValue Value();
   
   /**
    * Установить значение
    * @param value новое значение
    * @return Предыдущее значение
    */
   TValue setValue(TValue value);
}
