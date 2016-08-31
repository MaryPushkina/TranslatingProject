/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.collections;


/** Контейнер для четверки значений
 * @author Жиряков
 * @param <T1> Тип первого значения из четверки
 * @param <T2> Тип второго значения из четверки
 * @param <T3> Тип третьего значения из четверки
   * @param <T4> Тип третьего значения из четверки
 */
public class Tuple4<T1, T2, T3, T4>
{
    public T1 Obj1;
    public T2 Obj2;
    public T3 Obj3;
    public T4 Obj4;
    
    public Tuple4() {}
    public Tuple4(T1 obj1, T2 obj2, T3 obj3, T4 obj4)
    {
        this.Obj1 = obj1;
        this.Obj2 = obj2;
        this.Obj3 = obj3;
        this.Obj4 = obj4;
    }
    
     @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        String strObj1 = (Obj1 != null) ? Obj1.toString(): "-";
        String strObj2 = (Obj2 != null) ? Obj2.toString(): "-";
        String strObj3 = (Obj3 != null) ? Obj3.toString(): "-";
        String strObj4 = (Obj4 != null) ? Obj4.toString(): "-";
        return sb.append("[").append(strObj1).append("; ").
                              append(strObj2).append("; ").
                              append(strObj3).append("; ").
                              append(strObj4).
            append("]").toString();
    }
}

