/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.collections;

/** Контейнер для пары значений
 * @author SERGEY
 * @param <T1> Тип первого значения из пары значений
 * @param <T2> Тип второго значения из пары значений
 */
public class Tuple2<T1, T2>
{
    public T1 Obj1;
    public T2 Obj2;
    
    public Tuple2() {}
    
    public Tuple2(T1 obj1, T2 obj2)
    {
        this.Obj1 = obj1;
        this.Obj2 = obj2;
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String strObj1 = (Obj1 != null) ? Obj1.toString(): "-";
        String strObj2 = (Obj2 != null) ? Obj2.toString(): "-";
        
        return sb.append("[").append(strObj1).append("; ").
                              append(strObj2).
            append("]").toString();
    }
   
}
