/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;

import atom.collections.ATOMMap;
import atom.collections.IATOMMap;
import java.util.Map;


/*
 */
public class ATOMStringResource extends ATOMResource
{
  
  ATOMMap<ELanguages, String> _Translations = new ATOMMap<ELanguages, String>(); 
  
  public ATOMStringResource()
  {
   
  }
  
  public ATOMStringResource(String strID)
  {
    super(strID);
   
  }
  
  public ATOMStringResource(String strID, long ID)
  {
     super(strID,ID);
  }
  
  public ATOMStringResource(String strID, long ID,String defaultTranslation)
  {
    super(strID, ID);
    setStr(defaultTranslation);
   
  }
  
  public ATOMStringResource(String strID, String defaultTranslation)
  {
    super(strID);
    setStr(defaultTranslation);
  }  
  
  public ATOMStringResource(IATOMName stringName)
  {
   super(stringName);
   _Translations = new ATOMMap<ELanguages, String>();
  }
  
  
  //==============================================================
  /*
   Записать вариант перевода str строкового ресурса на текущем языке
  */
  public void setStr(final String str)
  {
      
      _Translations.put( LanguageManager.getManager().CurrentLanguage(), str);
  }
 
  //==============================================================
  /**
   * Получить перевод строкового ресурса на текущем языке
   * @return 
   */
  public String Str()
  {
      ELanguages curLanguage = LanguageManager.getManager().CurrentLanguage();
      if (_Translations.containsKey(curLanguage))
         return _Translations.get(curLanguage);
      else
         return null;
  }
  
  //==============================================================
  /*
   Записать вариант перевода str строкового ресурса на языке language
  */
  public void setStr(final String str, final ELanguages language)
  {
      _Translations.put(language, str);
  }
  
  //==============================================================
  /*
  Получить перевод строкового ресурса на желаемом языке
  */
  public String Str(final ELanguages language)
  {
      if (_Translations.containsKey(language))
         return _Translations.get(language);
      else
         return null;
  }
  
  public  ATOMMap<ELanguages, String> getTranslations()
  {
    return _Translations;
  }
  
  //==============================================================
  @Override
  public String toString()
  {
      
      StringBuilder sb = new StringBuilder();
      
      sb.append(super.toString());
      
      IATOMMap<ELanguages,String> translations = getTranslations();
      if (translations.size() > 0)
      {
        sb.append(" ");
        for (Map.Entry<ELanguages, String> translationVariant : translations.entrySet())
        {
           sb.append(String.format("<%s:\"%s\">",translationVariant.getKey().toString(), translationVariant.getValue()));
        }
      }
      
      return sb.toString();
  }
  
  
  
}
