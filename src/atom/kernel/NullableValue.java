/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.kernel;

/**
 * Класс, инкапсулирующий значение, которое может принимать значение null
 * @author Жиряков
 * @param <TValue> Тип хранимого значения
 */
public class NullableValue<TValue> implements INullableValue<TValue>
{
  /** Признак того, что значение равно NULL */
  protected boolean _IsNull;

  /*Значение*/
  protected TValue _Value;

  public NullableValue()
  {
    _Value = null;
    _IsNull = true;
  }
  @Override
  public boolean isNull()
  {
    return _IsNull;
  }

  @Override
  public void SetNull()
  {
    _IsNull = true;
  }

  @Override
  public TValue Value()
  {
    return _Value;
  }

  @Override
  public TValue setValue(TValue value)
  {
    TValue oldValue = _Value;
    _Value = value;
    if (_Value == null) 
        _IsNull = true; //SetNull();
    else 
       _IsNull = false;
    return oldValue;
  }

  //##################################################################
//<editor-fold defaultstate="collapsed" desc="##### ИНТЕРФЕЙС IClonable #####">
@Override
  public INullableValue<TValue> CreateInstance()
  {
    INullableValue<TValue> newValue = new NullableValue<TValue>();
    return newValue;
  }

  @Override
  public void CopyTo(INullableValue<TValue> destination)
  {
    destination.setValue(_Value);
  }

  @Override
  public INullableValue<TValue> Clone()
  {
    INullableValue<TValue> newValue = CreateInstance();
    CopyTo(newValue);
    return newValue;
  }
//</editor-fold> КОНЕЦ "ИНТЕРФЕЙС IClonable"
//##################################################################
  
  
  /**Получить строковое представление объекта
* @return Строковое представление объекта*/
@Override    
public String toString()
{
    //1. Составная строка
    StringBuilder sb = new StringBuilder();
    if (_IsNull) return "NULL";
    else if (_Value != null) return _Value.toString();
    else return "_Value = null, but _IsNull=false. It`s MISTAKE !!!";
}
 
}
