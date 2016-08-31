/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.collections;

/**
 * Базовая реализация обертки поведения
 * @author SERGEY
 * @param <TOriginal> Исходный класс, который реализует поведение TImplementataion
 * @param <TImplementataion> Класс поведения, которое обязуется реализовывать класс TOriginal
 */
public class Wrap<TOriginal, TImplementataion> implements IWrap<TOriginal, TImplementataion>
{
    protected TOriginal _Original;
    protected TImplementataion _Implementation;
    
 
    public Wrap(TOriginal original, TImplementataion implementation)
    {
        _Original = original;
        _Implementation = implementation;
    }
    
    @Override
    public TOriginal getOriginal()
    {
        return _Original;
    }

    @Override
    public TImplementataion getWrap()
    {
       return _Implementation;
    }

//    @Override
//    public Class<? extends TImplementataion> getImplementsClass()
//    {
//       
//    }

//    @Override
//    public IATOMName getWrapName()
//    {
//        return null;
//    }
//
//    @Override
//    public IATOMName getWrapVariantName()
//    {
//        return null;
//    }
    
}
