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
public class Size2Di  implements IClonable<Size2Di>
{

/** Ширина */
public int Width;

/** Высота */
public int Height;

public Size2Di()
{}

public Size2Di(int width, int height)
{
    Set(width, height);
}

public Size2Di(Size2Di size)
{
    Set(size.Width,size.Height);
}    

@Override
public String toString()
{
  return String.format("%s x %s", Width,Height);
}

public void Set(int width, int height)
{
    Width = width;
    Height = height;
}

public void Set(Size2Di size)
{
  Width = size.Width;
  Height = size.Height;
}

//##################################################################
//<editor-fold defaultstate="collapsed" desc="##### ИНТЕРФЕЙС Clonable<Size2Di> #####">
    @Override
    public Size2Di CreateInstance()
    {
        return new Size2Di();
    }

    @Override
    public void CopyTo(Size2Di destination)
    {
      destination.Height = this.Height;
      destination.Width = this.Width;
    }

    @Override
    public Size2Di Clone()
    {
        Size2Di clone = CreateInstance();
        this.CopyTo(clone);
        return clone;
    }
//</editor-fold> КОНЕЦ "ИНТЕРФЕЙС Clonable<Size2Di>"
//##################################################################

 //##################################################################
//<editor-fold defaultstate="collapsed" desc="##### equals и hashCode #####">
@Override
  public boolean equals(Object obj)
  {
    if (obj == null) return false;
    if (!(obj instanceof Size2Di)) return false;
    Size2Di typedObj = (Size2Di)obj;
    // Фактический способ сравнения объектов
    return ((typedObj.Width == this.Width) && (typedObj.Height == this.Height));
  }

  @Override
  public int hashCode()
  {
    return super.hashCode();
  }
//</editor-fold> КОНЕЦ "equals и hashCode"
//##################################################################
   
    
    
}

