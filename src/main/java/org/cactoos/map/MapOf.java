/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2020 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.cactoos.map;

import java.util.HashMap;
import java.util.Map;
import org.cactoos.Func;
import org.cactoos.Scalar;
import org.cactoos.iterable.IterableOf;
import org.cactoos.iterable.Joined;
import org.cactoos.iterable.Mapped;
import org.cactoos.scalar.Unchecked;

/**
 * Iterable as {@link Map}.
 *
 * <p>This class should be used very carefully. You must understand that
 * it will fetch the entire content of the encapsulated {@link Map} on each
 * method call. It doesn't cache the data anyhow.
 * If you don't need this {@link Map} to re-fresh its content on every call,
 * by doing round-trips to the encapsulated iterable, use
 * {@link Sticky}.</p>
 *
 * <p>There is no thread-safety guarantee.
 *
 * @param <X> Type of key
 * @param <Y> Type of value
 * @see Sticky
 * @since 0.4
 */
public final class MapOf<X, Y> extends MapEnvelope<X, Y> {

    /**
     * Ctor.
     * @param list List of entries
     */
    @SafeVarargs
    public MapOf(final Map.Entry<X, Y>... list) {
        this(new IterableOf<>(list));
    }

    /**
     * Ctor.
     * @param src The map to extend
     * @param list List of entries
     * @since 0.12
     */
    @SafeVarargs
    public MapOf(final Map<X, Y> src, final Map.Entry<X, Y>... list) {
        this(src, new IterableOf<>(list));
    }

    /**
     * Ctor.
     * @param key Func to create key
     * @param value Func to create value
     * @param list List of items
     * @param <Z> Type of items in the list
     * @since 0.11
     */
    public <Z> MapOf(final Func<Z, X> key,
        final Func<Z, Y> value, final Iterable<Z> list) {
        this(item -> new MapEntry<>(key.apply(item), value.apply(item)), list);
    }

    /**
     * Ctor.
     * @param key Func to create key
     * @param value Func to create value
     * @param src The map to extend
     * @param list List of items
     * @param <Z> Type of items in the list
     * @since 0.12
     * @checkstyle ParameterNumberCheck (5 lines)
     */
    public <Z> MapOf(final Func<Z, X> key,
        final Func<Z, Y> value, final Map<X, Y> src,
        final Iterable<Z> list) {
        this(
            item -> new MapEntry<>(key.apply(item), value.apply(item)),
            src, list
        );
    }

    /**
     * Ctor.
     * @param entry Func to create entry
     * @param list List of items
     * @param <Z> Type of items in the list
     * @since 0.11
     */
    public <Z> MapOf(final Func<Z, Map.Entry<X, Y>> entry,
        final Iterable<Z> list) {
        this(new Mapped<>(entry, list));
    }

    /**
     * Ctor.
     * @param entry Func to create entry
     * @param src The map to extend
     * @param list List of items
     * @param <Z> Type of items in the list
     * @since 0.11
     */
    public <Z> MapOf(final Func<Z, Map.Entry<X, Y>> entry,
        final Map<X, Y> src, final Iterable<Z> list) {
        this(src, new Mapped<>(entry, list));
    }

    /**
     * Ctor.
     * @param src Map to extend
     * @param list List of the entries
     * @since 0.12
     */
    @SuppressWarnings("unchecked")
    public MapOf(final Map<X, Y> src,
        final Iterable<Map.Entry<X, Y>> list) {
        this(
            new Joined<>(
                src.entrySet(), list
            )
        );
    }

    /**
     * Ctor.
     * @param scalar The scalar for Map.
     */
    public MapOf(final Scalar<Map<X, Y>> scalar) {
        this(new Unchecked<>(scalar).value().entrySet());
    }

    /**
     * Ctor.
     * @param entries List of the entries
     */
    public MapOf(final Iterable<Map.Entry<X, Y>> entries) {
        super(new HashMap<>());
        for (final Map.Entry<X, Y> entry : entries) {
            this.put(entry.getKey(), entry.getValue());
        }
    }
}
