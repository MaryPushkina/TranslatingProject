/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.collections;

/** Контейнер для тройки значений
 * @author SERGEY
 * @param <T1> Тип первого значения из тройки
 * @param <T2> Тип второго значения из тройки
 * @param <T3> Тип третьего значения из тройки
 */
public class Tuple3<T1, T2, T3>
{
    public T1 Obj1;
    public T2 Obj2;
    public T3 Obj3;
    
    public Tuple3() {}
    public Tuple3(T1 obj1, T2 obj2, T3 obj3)
    {
        this.Obj1 = obj1;
        this.Obj2 = obj2;
        this.Obj3 = obj3;
    }
    
     @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String strObj1 = (Obj1 != null) ? Obj1.toString(): "-";
        String strObj2 = (Obj2 != null) ? Obj2.toString(): "-";
        String strObj3 = (Obj3 != null) ? Obj3.toString(): "-";
        return sb.append("[").append(strObj1).append("; ").
                              append(strObj2).append("; ").
                              append(strObj3).
            append("]").toString();
    }
}
