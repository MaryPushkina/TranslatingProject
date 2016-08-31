/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.collections;

import atom.kernel.IComparator;
import atom.kernel.ICriteria;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Интерфейс списка, который можно только читать
 * @author Жиряков
 * @param <T>
 */
public interface IATOMListReader<T> extends Iterable<T>
{
   /**Найти первый объект, соответствующий критерию
   * @param criteria Критекрий поиска объекта
   * @return Найденный объект или null, если объект не найден*/
   T FindFirst(ICriteria<? super T> criteria);  
   
   /**Найти первый объект, равный serachTemplate
   * @param serachTemplate
   * @return   Найденный объект или null, если объект не найден*/
   T FindFirst(Object serachTemplate);  
   
   /**Найти индекс объекта в коллекции равный заданному searchObject
     * @param searchTemplate Объект - образец для поиска
     * @param comparator Критерий сравнения объектов
     * @return Индекс найденного объекта, -1, если объект не найден*/
   int indexOf(T searchTemplate, IComparator<T> comparator);
  
   
   

    /**
     * Returns the number of elements in this list.  If this list contains
     * more than <tt>Integer.MAX_VALUE</tt> elements, returns
     * <tt>Integer.MAX_VALUE</tt>.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     * More formally, returns <tt>true</tt> if and only if this list contains
     * at least one element <tt>e</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list (optional)
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements (optional)
     */
    boolean contains(Object o);

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     *
     * @return an iterator over the elements in this list in proper sequence
     */
    Iterator<T> iterator();

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must
     * allocate a new array even if this list is backed by an array).
     * The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list in proper
     *         sequence
     * @see Arrays#asList(Object[])
     */
    Object[] toArray();

    /**
     * Returns an array containing all of the elements in this list in
     * proper sequence (from first to last element); the runtime type of
     * the returned array is that of the specified array.  If the list fits
     * in the specified array, it is returned therein.  Otherwise, a new
     * array is allocated with the runtime type of the specified array and
     * the size of this list.
     *
     * <p>If the list fits in the specified array with room to spare (i.e.,
     * the array has more elements than the list), the element in the array
     * immediately following the end of the list is set to <tt>null</tt>.
     * (This is useful in determining the length of the list <i>only</i> if
     * the caller knows that the list does not contain any null elements.)
     *
     * <p>Like the {@link #toArray()} method, this method acts as bridge between
     * array-based and collection-based APIs.  Further, this method allows
     * precise control over the runtime type of the output array, and may,
     * under certain circumstances, be used to save allocation costs.
     *
     * <p>Suppose <tt>x</tt> is a list known to contain only strings.
     * The following code can be used to dump the list into a newly
     * allocated array of <tt>String</tt>:
     *
     * <pre>
     *     String[] y = x.toArray(new String[0]);</pre>
     *
     * Note that <tt>toArray(new Object[0])</tt> is identical in function to
     * <tt>toArray()</tt>.
     *
   * @param <T2>
     * @param a the array into which the elements of this list are to
     *          be stored, if it is big enough; otherwise, a new array of the
     *          same runtime type is allocated for this purpose.
     * @return an array containing the elements of this list
     * @throws ArrayStoreException if the runtime type of the specified array
     *         is not a supertype of the runtime type of every element in
     *         this list
     * @throws NullPointerException if the specified array is null
     */
    <T2> T2[] toArray(T2[] a);


    // Modification Operations


    /**
     * Returns <tt>true</tt> if this list contains all of the elements of the
     * specified collection.
     *
     * @param  c collection to be checked for containment in this list
     * @return <tt>true</tt> if this list contains all of the elements of the
     *         specified collection
     * @throws ClassCastException if the types of one or more elements
     *         in the specified collection are incompatible with this
     *         list (optional)
     * @throws NullPointerException if the specified collection contains one
     *         or more null elements and this list does not permit null
     *         elements (optional), or if the specified collection is null
     * @see #contains(Object)
     */
    boolean containsAll(Collection<?> c);

   



    // Positional Access Operations

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    T get(int index);

   
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list (optional)
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements (optional)
     */
    int indexOf(Object o);

    /**
     * Returns the index of the last occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the highest index <tt>i</tt> such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     * @throws ClassCastException if the type of the specified element
     *         is incompatible with this list (optional)
     * @throws NullPointerException if the specified element is null and this
     *         list does not permit null elements (optional)
     */
    int lastIndexOf(Object o);


    // List Iterators

    /**
     * Returns a list iterator over the elements in this list (in proper
     * sequence).
     *
     * @return a list iterator over the elements in this list (in proper
     *         sequence)
     */
    ListIterator<T> listIterator();

    /**
     * Returns a list iterator of the elements in this list (in proper
     * sequence), starting at the specified position in this list.
     * The specified index indicates the first element that would be
     * returned by an initial call to {@link ListIterator#next next}.
     * An initial call to {@link ListIterator#previous previous} would
     * return the element with the specified index minus one.
     *
     * @param index index of first element to be returned from the
     *              list iterator (by a call to the <tt>next</tt> method)
     * @return a list iterator of the elements in this list (in proper
     *         sequence), starting at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt; size()</tt>)
     */
    ListIterator<T> listIterator(int index);

    // View

    /**
     * Returns a view of the portion of this list between the specified
     * <tt>fromIndex</tt>, inclusive, and <tt>toIndex</tt>, exclusive.  (If
     * <tt>fromIndex</tt> and <tt>toIndex</tt> are equal, the returned list is
     * empty.)  The returned list is backed by this list, so non-structural
     * changes in the returned list are reflected in this list, and vice-versa.
     * The returned list supports all of the optional list operations supported
     * by this list.<p>
     *
     * This method eliminates the need for explicit range operations (of
     * the sort that commonly exist for arrays).   Any operation that expects
     * a list can be used as a range operation by passing a subList view
     * instead of a whole list.  For example, the following idiom
     * removes a range of elements from a list:
     * <pre>
     *      list.subList(from, to).clear();
     * </pre>
     * Similar idioms may be constructed for <tt>indexOf</tt> and
     * <tt>lastIndexOf</tt>, and all of the algorithms in the
     * <tt>Collections</tt> class can be applied to a subList.<p>
     *
     * The semantics of the list returned by this method become undefined if
     * the backing list (i.e., this list) is <i>structurally modified</i> in
     * any way other than via the returned list.  (Structural modifications are
     * those that change the size of this list, or otherwise perturb it in such
     * a fashion that iterations in progress may yield incorrect results.)
     *
     * @param fromIndex low endpoint (inclusive) of the subList
     * @param toIndex high endpoint (exclusive) of the subList
     * @return a view of the specified range within this list
     * @throws IndexOutOfBoundsException for an illegal endpoint index value
     *         (<tt>fromIndex &lt; 0 || toIndex &gt; size ||
     *         fromIndex &gt; toIndex</tt>)
     */
    List<T> subList(int fromIndex, int toIndex);
   
   
}
