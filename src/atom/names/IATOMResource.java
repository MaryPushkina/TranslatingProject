/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.names;

import atom.collections.IATOMList;
import atom.kernel.StringKeyValuePair;

/**
 *
 * @author SERGEY
 */
public interface IATOMResource extends IATOMName
{
    IATOMName getResourceName();
    
    /**
     * Параметры, идентифицирующие ресурс из множества вариантов исполнения, версий и т.п.
     * @return 
     */
    IATOMList<StringKeyValuePair> getResourceParametrs();
    
        /**
     * Параметры, идентифицирующие фрагмент ресурса. Используется, когда необходимо сослаться на
     * ресурс, не имеющий самостоятельного имени и корторый является составной частью
     * другого более крупного ресурса.
     * Например для ресурса "Изображения" в исполнении "английский" можно сослаться на 
     * 
     * @return 
     */
    IATOMList<StringKeyValuePair> getFragmentParametrs();
    
    /**Получить значение параметра по имени. Если параметр не найден, то возвращается null*/
    String getParametrValue(String parametrName);
    
    /**
     * Установить значение параметра c именем parametrName 
     * @param parametrName Имя параметра
     * @return Предыдущее значение параметра. Если параметр не был задан, то возвращает null
     */
    String setParametrValue(String parametrName);
    
     /**
     * Установить значение параметра c именем parametrName 
     * @param parametrName Имя параметра
     * @return Предыдущее значение параметра. Если параметр не был задан, то возвращает null
     */
    String setParametrValue(IATOMName parametrName);
    
}
