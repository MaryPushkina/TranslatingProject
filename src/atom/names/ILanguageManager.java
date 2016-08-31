/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;

/**
 * Интерфейс доступа к менеджеру языков
 * @author Жиряков
 */
public interface ILanguageManager
{

   ELanguages CurrentLanguage();  
   void setCurrentLanguage(ELanguages currentLanguage);  
 
    
}
