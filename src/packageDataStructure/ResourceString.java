/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packageDataStructure;

import atom.names.ATOMStringResource;
import java.util.HashMap;
import java.util.Map;
import atom.names.ELanguages;
/**
 *
 * @author Maru
 */

//Строковые ресурсы
public class ResourceString extends AbstractResource/*ATOMStringResource*/ {
    
    //статус ресурса: начальный, новый, изменённый
    private StatusResource stResRus = StatusResource.StartRes;
    private StatusResource stResEng = StatusResource.StartRes;
    
    //ресурс: язык, строка
    private Map LangMap = new HashMap < ELanguages,String >();
      
    public void setStatusResource(ELanguages Lang,StatusResource stRes)
    {
        if (Lang==ELanguages.English)
        {
            this.stResEng=stRes;
        }
        if (Lang==ELanguages.Russian)
        {
            this.stResRus=stRes;
        }
    }
    

    public StatusResource getStatusResource(ELanguages Lang)
    {
        if (Lang==ELanguages.English)
        {
            return stResEng;
        }
        else
        if (Lang==ELanguages.Russian)
        {
            return stResRus;
        }
        return stResRus;
    }
    public void setString(ELanguages IDLang,String value)
    {
        LangMap.put(IDLang, value);
        
    }
  
    public String getString(ELanguages IDLang)
    {
       return (String) LangMap.get(IDLang);
        
    }
    
   @Override
    public boolean equals(Object other)
    {
       if (other instanceof ResourceString)
           return equals((ResourceString)other);
       return false;
    }
   
    public boolean equals(ResourceString other)
    {
        if (other == null)
           return false;
        if ((this.LangMap.get(ELanguages.Russian).equals(other.LangMap.get(ELanguages.Russian)))&&
            (this.LangMap.get(ELanguages.English).equals(other.LangMap.get(ELanguages.English))))    
            return true;
        return false;
    }
    
    public boolean equalsRus(ResourceString other)
    {
        if (other == null)
           return false;
        if (this.LangMap.get(ELanguages.Russian).equals(other.LangMap.get(ELanguages.Russian)))
            return true;
        return false;
    }
    public boolean equalsEngl(ResourceString other)
    {
        if (other == null)
           return false;
        if (this.LangMap.get(ELanguages.English).equals(other.LangMap.get(ELanguages.English)))
            return true;
        return false;
    }
/*  public ResourceString()
    {}
   
    public ResourceString (String key)
    {
        super(key);
    }
    
    public void setString(ELanguages IDLang,String value)
    {
        //LangMap.put(IDLang, value);
        setStr(value,IDLang);
    }
  
    public String getString(ELanguages IDLang)
    {
       return (String) Str(IDLang);   
    }
*/
    
}
