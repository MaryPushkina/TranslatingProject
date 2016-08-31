/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.kernel;

/**
 * Строковая пара ключ-значение, где ключ и хранимое значение являтся строками
 * @author SERGEY
 */
public class StringKeyValuePair extends KeyValuePairAbstarct<String, String>
{

    public StringKeyValuePair(String key, String value)
    {
        super(key, value);
    }
    
}
