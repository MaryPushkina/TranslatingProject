/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;

import atom.collections.Tuple2;
import java.util.UUID;

/**
 * Класс определяет некоторое наименование в предметной области (Название сущностей данных, имя атрибута и др.)
 * @author Жиряков
 */
public class ATOMName implements IATOMName
{
   protected static ATOMIDGenerator _IDGenerator = new ATOMIDGenerator();
   protected static ATOMNamesGenerator _StrNamesGenerator = new ATOMNamesGenerator("name");
   
   public static ATOMName RootATOMNamespace = new ATOMName("atom");
   public static ATOMName RootDefaultNamespace = new ATOMName("DefaultSpace");
   public static final ATOMName NULL = new ATOMName("atom.names.ATOMName.NullAtomName");
   
    /**Числовой идентификатор некоторого наименования*/
    protected long _ID;
    
    /** Глобальный идентификатор имени */
    protected UUID _GUID;
    
    /**Локальное идентификационное имя некоторого наименования*/
    protected String _LocalName;

    /** Локальное идентификационное имя некоторого наименования */
    //protected String _LocalName;
    
    /** Область определения имени */
    protected IATOMName _DefinitionNamespace;


 
    public ATOMName()
    {
        _ID = _IDGenerator.NextID();
        _LocalName = _StrNamesGenerator.NextID();
    }
    
    public ATOMName(String localName)
    {
     _ID = _IDGenerator.NextID();
     _LocalName = localName;
    }
    
    public ATOMName(String localName, UUID guid)
    {
      _ID = _IDGenerator.NextID();
      _LocalName = localName;
      _GUID = guid;
    }
    
     public ATOMName(String localName, IATOMName namespace)
    {
      _ID = _IDGenerator.NextID();
      _LocalName = localName;
      _DefinitionNamespace = namespace;
    }
    
     public ATOMName(String localName, long ID)
    {
     _ID = ID;
     _LocalName = localName;
    }

    @Override
    public long IDName()
    {
       return _ID;
    }
  
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        
       if (_DefinitionNamespace != null)
          sb.append(String.format("[%s] ", _DefinitionNamespace.FullName()));
      
       sb.append(_LocalName);
      
       sb.append(String.format("(ID=%d)",_ID));
        
        return sb.toString();
    }
    
//<editor-fold defaultstate="collapsed" desc="АКСЕССОРЫ СВОЙСТВА GUIDName">
//--------------------------------------------------
/** get-аксессор свойства "GUIDName" 
 * @return  Значение свойства "GUIDName" */
@Override
public UUID GUIDName() 
{   return _GUID;} 

//--------------------------------------------------
/** set-аксессор свойства "GUIDName" 
 * @param GUID Новое значение свойства "GUIDName" */
public void setGUID(UUID GUID)
{  this._GUID = GUID; }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="АКСЕССОРЫ СВОЙСТВА DefinitionNamespace">
//--------------------------------------------------
/** get-аксессор свойства "DefinitionNamespace" 
 * @return  Значение свойства "DefinitionNamespace" */
@Override
public IATOMName DefinitionNamespace() 
{   return _DefinitionNamespace;} 

//--------------------------------------------------
/** set-аксессор свойства "DefinitionNamespace" 
 * @param DefinitionNamespace Новое значение свойства "DefinitionNamespace" */
public void setDefinitionNamespace(IATOMName DefinitionNamespace)
{  this._DefinitionNamespace = DefinitionNamespace; }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="АКСЕССОРЫ СВОЙСТВА LocalName">
//--------------------------------------------------
/** get-аксессор свойства "LocalName" 
 * @return  Значение свойства "LocalName" */
@Override
public String LocalName() 
{   return _LocalName;} 

//--------------------------------------------------
/** set-аксессор свойства "LocalName" 
 * @param LocalName Новое значение свойства "LocalName" */
public void setLocalName(String LocalName)
{  this._LocalName = LocalName; }
//</editor-fold>

    //##################################################################
//<editor-fold defaultstate="collapsed" desc="##### Object hashCode and equals #####">
    @Override
    public int hashCode()
    {
        long mask = 0xFFFFFFFF;
        return (int) (IDName() & mask);
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
    public boolean IsEquals(IATOMName name)
    {
        //Равенство имен
        return (this.IDName() == name.IDName());
    }
//</editor-fold> КОНЕЦ "Object hashCode and equals"
//##################################################################

  @Override
  public String FullName()
  {
    if (_DefinitionNamespace != null)
      return _DefinitionNamespace.FullName()+"."+_LocalName;
    else
      return _LocalName;
  }

 /**
  * Провести синтаксический разбор строчки и выделить в имени name название пространства имен и локальное имя
  * @param name Строчка для разбора
  * @return Пара строк (Tuple2): Первый элемент - имя пространства имен или пустая строка, если отсутствует
  *                              Второй элемент - локальное имя 
  */
 public static Tuple2<String,String> ParseName(String name)
 {
     int indexStartSerach=-1;
     int indexDelimeterPointOfNamespaceAndLocalName = -1;
     
     do
     {
       indexStartSerach = name.indexOf(".",indexStartSerach+1);
       if (indexStartSerach >=0)
          indexDelimeterPointOfNamespaceAndLocalName = indexStartSerach;   
     } while (indexStartSerach >=0 );

     String namespaceName="";
     String localName = "";
     if (indexDelimeterPointOfNamespaceAndLocalName >= 0)
       namespaceName = name.substring(0, indexDelimeterPointOfNamespaceAndLocalName);
     
     localName = name.substring(indexDelimeterPointOfNamespaceAndLocalName+1, name.length());
     
     return new Tuple2<String, String>(namespaceName, localName);
     
 }
 
};




