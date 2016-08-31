/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.collections;

import atom.names.ELanguages;
import java.util.HashMap;

/*
 */
public class ATOMHashMap<K, V> extends HashMap<K, V> implements IATOMMap<K, V>
{

    
      //==============================================================
  @Override
  public String toString()
  {
      StringBuilder sb = new StringBuilder();
      
      for(ATOMHashMap.Entry<K,V> kvp: entrySet())
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
