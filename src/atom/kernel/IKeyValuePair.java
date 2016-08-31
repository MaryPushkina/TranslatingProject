/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atom.kernel;


/**
 *

 * @param <TKey>
 * @param <TValue>
 * @author SERGEY
 */
public interface IKeyValuePair<TKey, TValue>
{
  /**
	 * Returns the key corresponding to this entry.
	 *
	 * @return the key corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
	 */
	TKey getKey();

    	/**
	 * Returns the value corresponding to this entry.  If the mapping
	 * has been removed from the backing map (by the iterator's
	 * <tt>remove</tt> operation), the results of this call are undefined.
	 *
	 * @return the value corresponding to this entry
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
	 */
	TValue getValue();

    	/**
	 * Replaces the value corresponding to this entry with the specified
	 * value (optional operation).  (Writes through to the map.)  The
	 * behavior of this call is undefined if the mapping has already been
	 * removed from the map (by the iterator's <tt>remove</tt> operation).
	 *
         * @param value new value to be stored in this entry
         * @return old value corresponding to the entry
         * @throws UnsupportedOperationException if the <tt>put</tt> operation
         *         is not supported by the backing map
         * @throws ClassCastException if the class of the specified value
         *         prevents it from being stored in the backing map
         * @throws NullPointerException if the backing map does not permit
         *         null values, and the specified value is null
         * @throws IllegalArgumentException if some property of this value
         *         prevents it from being stored in the backing map
         * @throws IllegalStateException implementations may, but are not
         *         required to, throw this exception if the entry has been
         *         removed from the backing map.
         */
	TValue setValue(TValue value);

	/**
	 * Compares the specified object with this entry for equality.
	 * Returns <tt>true</tt> if the given object is also a map entry and
	 * the two entries represent the same mapping.  More formally, two
	 * entries <tt>e1</tt> and <tt>e2</tt> represent the same mapping
	 * if<pre>
         *     (e1.getKey()==null ?
         *      e2.getKey()==null : e1.getKey().equals(e2.getKey()))  &amp;&amp;
         *     (e1.getValue()==null ?
         *      e2.getValue()==null : e1.getValue().equals(e2.getValue()))
         * </pre>
	 * This ensures that the <tt>equals</tt> method works properly across
	 * different implementations of the <tt>Map.Entry</tt> interface.
	 *
	 * @param o object to be compared for equality with this map entry
	 * @return <tt>true</tt> if the specified object is equal to this map
	 *         entry
         */
        @Override
	boolean equals(Object o);

	/**
	 * Returns the hash code value for this map entry.  The hash code
	 * of a map entry <tt>e</tt> is defined to be: <pre>
	 *     (e.getKey()==null   ? 0 : e.getKey().hashCode()) ^
	 *     (e.getValue()==null ? 0 : e.getValue().hashCode())
         * </pre>
	 * This ensures that <tt>e1.equals(e2)</tt> implies that
	 * <tt>e1.hashCode()==e2.hashCode()</tt> for any two Entries
	 * <tt>e1</tt> and <tt>e2</tt>, as required by the general
	 * contract of <tt>Object.hashCode</tt>.
	 *
	 * @return the hash code value for this map entry
	 * @see Object#hashCode()
	 * @see Object#equals(Object)
	 * @see #equals(Object)
	 */
        @Override
	int hashCode();
}