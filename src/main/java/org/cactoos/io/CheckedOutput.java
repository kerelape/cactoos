/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2022 Yegor Bugayenko
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
package org.cactoos.io;

import java.io.OutputStream;
import org.cactoos.Func;
import org.cactoos.Output;
import org.cactoos.scalar.Checked;

/**
 * Output that throws exception of specified type.
 *
 * @param <E> Exception's type.
 * @since 0.31
 */
public final class CheckedOutput<E extends Exception> implements Output {

    /**
     * Original output.
     */
    private final Output origin;

    /**
     * Function that wraps exception of {@link #origin} to the required type.
     */
    private final Func<? super Exception, ? extends E> func;

    /**
     * Ctor.
     * @param orig Origin output.
     * @param fnc Function that wraps exceptions.
     */
    public CheckedOutput(final Output orig, final Func<? super Exception, ? extends E> fnc) {
        this.origin = orig;
        this.func = fnc;
    }

    @Override
    public OutputStream stream() throws E {
        return new Checked<>(
            this.origin::stream,
            this.func
        ).value();
    }
}
