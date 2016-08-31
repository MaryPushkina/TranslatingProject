/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.collections;

import java.util.HashMap;

/*
 */
public class ATOMMap<TKey, TValue> extends HashMap<TKey, TValue> implements IATOMMap<TKey, TValue>
{

    
      //==============================================================
  @Override
  public String toString()
  {
      StringBuilder sb = new StringBuilder();
      
      for(ATOMMap.Entry<TKey,TValue> kvp: entrySet())
      {
          if (sb.length() != 0)
              sb.append(", ");
          sb.append("{");
          sb.append(kvp.getKey().toString());
          sb.append(":");
          sb.append(kvp.getValue().toString());
          sb.append("}"); 
      }
      
      return sb.toString();
  }
}
