/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.kernel;


/**
 * @param <TKey>
 * @param <TValue>
 * @author SERGEY
 */
public abstract class KeyValuePairAbstarct<TKey, TValue> implements IKeyValuePair<TKey, TValue>
{

    protected TKey _Key;
    protected TValue _Value;
    
    
    public KeyValuePairAbstarct(TKey key, TValue value)
    {
      if (key == null)
          throw new UnsupportedOperationException("Key in key-value pair can not be null!"); 
          
    }
    
    @Override
    public TKey getKey()
    {
       return  _Key; 
    }

    @Override
    public TValue getValue()
    {
        return _Value;
    }

    @Override
    public TValue setValue(TValue value)
    {
        TValue oldValue = _Value;
        _Value = value;
        return oldValue;
        
    }
    
    @Override
    public boolean equals(Object obj)
    {
      if (this == obj) return true;
      
      // Если объект obj реализует IKeyValuePair, то равенство определяем по равенству ключей
      if (obj instanceof IKeyValuePair<?, ?>)
      {
        IKeyValuePair<?, ?> kvpObj = (IKeyValuePair<?, ?>)obj;
        Object objKey = kvpObj.getKey();
        return objKey.equals(this._Key);
      }
      
      // По общему правилу сравниваем переданный obj c хранимым заначением _Key
      return _Key.equals(obj);
      
          
    }

    @Override
    public int hashCode()
    {
        return _Key.hashCode();
    }

}




