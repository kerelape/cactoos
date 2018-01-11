/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2018 Yegor Bugayenko
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
package org.cactoos.scalar;

import java.util.Collections;
import org.cactoos.Scalar;
import org.cactoos.iterable.IterableOf;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link AvgOf}.
 *
 * @author Vseslav Sekorin (vssekorin@gmail.com)
 * @version $Id$
 * @since 0.24
 * @checkstyle JavadocMethodCheck (500 lines)
 * @checkstyle MagicNumberCheck (500 lines)
 */
@SuppressWarnings("PMD.TooManyMethods")
public final class AvgOfTest {

    @Test
    public void withEmptyCollection() {
        MatcherAssert.assertThat(
            new AvgOf(Collections.emptyList()).longValue(),
            Matchers.equalTo(0L)
        );
    }

    @Test
    public void withIntegerCollectionIntValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1, 2, 3, 4
            ).intValue(),
            Matchers.equalTo(2)
        );
    }

    @Test
    public void withIntegerCollectionIntValueMaxValues() {
        MatcherAssert.assertThat(
            new AvgOf(
                Integer.MAX_VALUE, Integer.MAX_VALUE
            ).intValue(),
            Matchers.equalTo(Integer.MAX_VALUE)
        );
    }

    @Test
    public void withIntegerCollectionLongValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1, 2, 3, 4
            ).longValue(),
            Matchers.equalTo(2L)
        );
    }

    @Test
    public void withIntegerCollectionDoubleValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1, 2, 3, 4
            ).doubleValue(),
            Matchers.equalTo(2.5d)
        );
    }

    @Test
    public void withIntegerCollectionFloatValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1, 2, 3, 4
            ).floatValue(),
            Matchers.equalTo(2.5f)
        );
    }

    @Test
    public void withLongCollectionIntValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1L, 2L, 3L, 4L
            ).intValue(),
            Matchers.equalTo(2)
        );
    }

    @Test
    public void withLongCollectionLongValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1L, 2L, 3L, 4L
            ).longValue(),
            Matchers.equalTo(2L)
        );
    }

    @Test
    public void withLongCollectionMaxValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                Long.MAX_VALUE, Long.MAX_VALUE
            ).longValue(),
            Matchers.equalTo(Long.MAX_VALUE)
        );
    }

    @Test
    public void withLongCollectionDoubleValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1L, 2L, 3L, 4L
            ).doubleValue(),
            Matchers.equalTo(2.5d)
        );
    }

    @Test
    public void withLongCollectionFloatValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1L, 2L, 3L, 4L
            ).floatValue(),
            Matchers.equalTo(2.5f)
        );
    }

    @Test
    public void withDoubleCollectionIntValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0d, 2.0d, 3.0d, 4.0d
            ).intValue(),
            Matchers.equalTo(2)
        );
    }

    @Test
    public void withDoubleCollectionLongValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0d, 2.0d, 3.0d, 4.0d
            ).longValue(),
            Matchers.equalTo(2L)
        );
    }

    @Test
    public void withDoubleCollectionDoubleValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0d, 2.0d, 3.0d, 4.0d
            ).doubleValue(),
            Matchers.equalTo(2.5d)
        );
    }

    @Test
    public void withDoubleCollectionMaxValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                Double.MAX_VALUE, Double.MAX_VALUE
            ).doubleValue(),
            Matchers.equalTo(Double.MAX_VALUE)
        );
    }

    @Test
    public void withDoubleCollectionFloatValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0d, 2.0d, 3.0d, 4.0d
            ).floatValue(),
            Matchers.equalTo(2.5f)
        );
    }

    @Test
    public void withDoubleCollectionPrecisionProblem() {
        MatcherAssert.assertThat(
            new AvgOf(
                100.0, 100.266
            ).doubleValue(),
            Matchers.equalTo(100.133d)
        );
    }

    @Test
    public void withFloatCollectionIntValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0f, 2.0f, 3.0f, 4.0f
            ).intValue(),
            Matchers.equalTo(2)
        );
    }

    @Test
    public void withFloatCollectionLongValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0f, 2.0f, 3.0f, 4.0f
            ).longValue(),
            Matchers.equalTo(2L)
        );
    }

    @Test
    public void withFloatCollectionDoubleValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0f, 2.0f, 3.0f, 4.0f
            ).doubleValue(),
            Matchers.equalTo(2.5d)
        );
    }

    @Test
    public void withFloatCollectionFloatValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                1.0f, 2.0f, 3.0f, 4.0f
            ).floatValue(),
            Matchers.equalTo(2.5f)
        );
    }

    @Test
    public void withFloatCollectionMaxValue() {
        MatcherAssert.assertThat(
            new AvgOf(
                Float.MAX_VALUE, Float.MAX_VALUE
            ).floatValue(),
            Matchers.equalTo(Float.MAX_VALUE)
        );
    }

    @Test
    public void withScalars() {
        MatcherAssert.assertThat(
            new AvgOf(
                () -> 1L, () -> 2L, () -> 10L
            ).longValue(),
            Matchers.equalTo(4L)
        );
    }

    @Test
    public void withIterableOfScalars() {
        MatcherAssert.assertThat(
            new AvgOf(
                new IterableOf<Scalar<Number>>(() -> 1L, () -> 2L, () -> 10L)
            ).longValue(),
            Matchers.equalTo(4L)
        );
    }

}
