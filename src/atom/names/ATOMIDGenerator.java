/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.names;

//==============================================================================
//==============================================================================
/**
 * Генератор идентификаторов событий. Обеспечивает уникальность номеров событий
 * @author Жиряков
 */
public class ATOMIDGenerator
{
    protected long _IDCounter=0;

    public long NextID() {return _IDCounter++;}
};
