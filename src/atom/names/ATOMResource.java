/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;

//==============================================================================

import atom.collections.IATOMList;
import atom.kernel.StringKeyValuePair;
import java.util.UUID;

//==============================================================================
/**
 * Базовый класс ресурса проекта ( локализуемое сообщение, картинка, иконка, настроечный файл и т.п.)
 * @author Жиряков С.М.
 */
public class ATOMResource implements IATOMResource
{
    /*Имя ресурса   
    */
    IATOMName _ResourceName;
    
    public ATOMResource()
    {
        _ResourceName = new ATOMName();
    }
    
    public ATOMResource(String resourceStrID)
    {
      _ResourceName = new ATOMName(resourceStrID);
    }
    public ATOMResource(String resourceStrID, long resourceID)
    {
    _ResourceName = new ATOMName(resourceStrID,resourceID);
    }
    
    public ATOMResource(IATOMName resourceName)
    {
      _ResourceName = new ATOMName(resourceName.LocalName(), resourceName.IDName());
    }

    @Override
    public long IDName()
    {
      return _ResourceName.IDName();
    }
   

    @Override
    public boolean IsEquals(IATOMName name)
    {
       return name.IDName() == _ResourceName.IDName();
    }
    
     //##################################################################
//<editor-fold defaultstate="collapsed" desc="##### Object hashCode and equals #####">
    @Override
    public int hashCode()
    {
        long mask = 0xFFFFFFFF;
        return (int) (_ResourceName.IDName() & mask);
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof IATOMName))
        {
            return false;
        }
        IATOMName typedObj = (IATOMName) obj;
        
        return IsEquals(typedObj);
    }

     @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
        IATOMName definitionNamespace = DefinitionNamespace();
       if (definitionNamespace != null)
          sb.append(String.format("[%s] ", definitionNamespace.FullName()));
      
       sb.append(LocalName());
      
       sb.append(String.format("(ID=%d)",IDName()));
        
        return sb.toString();
    }
    
  @Override
  public UUID GUIDName()
  {
     return _ResourceName.GUIDName();
  }

  @Override
  public String LocalName()
  {
    return _ResourceName.LocalName();
  }

  @Override
  public IATOMName DefinitionNamespace()
  {
    return _ResourceName.DefinitionNamespace();
  }

  @Override
  public String FullName()
  {
    return  _ResourceName.FullName();
  }

  @Override
  public void setDefinitionNamespace(IATOMName namespace)
  {
    _ResourceName.setDefinitionNamespace(namespace);
  }
 
  /**
     * Установить значение параметра c именем parametrName 
     * @param parametrName Имя параметра
     * @return Предыдущее значение параметра. Если параметр не был задан, то возвращает null
     */
    @Override
    public String setParametrValue(String parametrName)
    {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     /**
     * Установить значение параметра c именем parametrName 
     * @param parametrName Имя параметра
     * @return Предыдущее значение параметра. Если параметр не был задан, то возвращает null
     */
     @Override
    public String setParametrValue(IATOMName parametrName)
    {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  @Override
  public IATOMName getResourceName()
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public IATOMList<StringKeyValuePair> getResourceParametrs()
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public IATOMList<StringKeyValuePair> getFragmentParametrs()
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public String getParametrValue(String parametrName)
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
