/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.kernel;

/**
 * Обертка для параметра метода, передаваемого по ссылке
 * @author Жиряков
 * @param <TParametrType>
 */
public class ParametrRef<TParametrType>
{
   TParametrType _Value;
   
   public ParametrRef(TParametrType defaultValue)
   { _Value = defaultValue;}
   
   public TParametrType Value()
    {return _Value;}
   
   /**
    * Установить новое значение параметра
    * @param newValue новое значение параметра
    * @return Предыдущее значение параметра
    */
   public TParametrType setValue(TParametrType newValue)
    {
        TParametrType oldValue = _Value;
        _Value = newValue;
        return oldValue;}
   
}
