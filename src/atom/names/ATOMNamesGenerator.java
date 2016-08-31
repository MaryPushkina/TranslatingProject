/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;


//==============================================================================
//==============================================================================
/**
 * Генератор текстовых названий
 * @author Жиряков
 */
public class ATOMNamesGenerator
{
   protected String _BaseName;
   protected long _Counter;
   
   public ATOMNamesGenerator(String baseName)
   {
       _Counter=0;
      _BaseName = baseName; 
   }
   
   public String NextID()
   {
       _Counter++;
       return _BaseName + "_" + _Counter;
   }
   
   public IATOMName NextName()
   {
    IATOMName nextName =  new ATOMName(NextID(), _Counter);
    return nextName;
   }
   
    public IATOMName NextName(String localName)
   {
    _Counter++; 
    IATOMName nextName =  new ATOMName(localName, _Counter);
    return nextName;
   }
   
   
}