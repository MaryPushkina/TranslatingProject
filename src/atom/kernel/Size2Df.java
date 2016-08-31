/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package atom.kernel;

import atom.kernel.IClonable;

/**
 * 2-мерные размеры - ширина и высота
 * @author SERGEY
 */
public class Size2Df  implements IClonable<Size2Df>
{

/** Ширина */
public float Width;

/** Высота */
public float Height;

public Size2Df()
{}

public Size2Df(float width, float height)
{
    Set(width,height);
}

public Size2Df(Size2Df size)
{
    Set(size.Width,size.Height);
}    

@Override
public String toString()
{
  return String.format("%f x %f", Width,Height);
}

public void Set(float width, float height)
{
    Width = width;
    Height = height;
}


public void Set(Size2Df size)
{
  Width = size.Width;
  Height = size.Height;
}

//##################################################################
//<editor-fold defaultstate="collapsed" desc="##### ИНТЕРФЕЙС Clonable<Size2Df> #####">
    @Override
    public Size2Df CreateInstance()
    {
        return new Size2Df();
    }

    @Override
    public void CopyTo(Size2Df destination)
    {
      destination.Height = this.Height;
      destination.Width = this.Width;
    }

    @Override
    public Size2Df Clone()
    {
        Size2Df clone = CreateInstance();
        this.CopyTo(clone);
        return clone;
    }
//</editor-fold> КОНЕЦ "ИНТЕРФЕЙС Clonable<Size2Df>"
//##################################################################

    
}

