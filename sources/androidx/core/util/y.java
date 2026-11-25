package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import c.t0;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ClassVerificationFailure"})
public final class y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> implements kotlin.ranges.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Range<T> f6418a;

        a(Range<T> range) {
            this.f6418a = range;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        @Override // kotlin.ranges.g
        public boolean a(@a7.d Comparable comparable) {
            return kotlin.ranges.g.a.a(this, comparable);
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // kotlin.ranges.g
        public Comparable d() {
            return this.f6418a.getLower();
        }

        /* JADX WARN: Incorrect return type in method signature: ()TT; */
        @Override // kotlin.ranges.g
        public Comparable f() {
            return this.f6418a.getUpper();
        }

        @Override // kotlin.ranges.g
        public boolean isEmpty() {
            return kotlin.ranges.g.a.b(this);
        }
    }

    @a7.d
    @t0(21)
    public static final <T extends Comparable<? super T>> Range<T> a(@a7.d Range<T> range, @a7.d Range<T> other) {
        l0.p(range, "<this>");
        l0.p(other, "other");
        Range<T> rangeIntersect = range.intersect(other);
        l0.o(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @a7.d
    @t0(21)
    public static final <T extends Comparable<? super T>> Range<T> b(@a7.d Range<T> range, @a7.d Range<T> other) {
        l0.p(range, "<this>");
        l0.p(other, "other");
        Range<T> rangeExtend = range.extend(other);
        l0.o(rangeExtend, "extend(other)");
        return rangeExtend;
    }

    @a7.d
    @t0(21)
    public static final <T extends Comparable<? super T>> Range<T> c(@a7.d Range<T> range, @a7.d T value) {
        l0.p(range, "<this>");
        l0.p(value, "value");
        Range<T> rangeExtend = range.extend(value);
        l0.o(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @a7.d
    @t0(21)
    public static final <T extends Comparable<? super T>> Range<T> d(@a7.d T t7, @a7.d T that) {
        l0.p(t7, "<this>");
        l0.p(that, "that");
        return new Range<>(t7, that);
    }

    @a7.d
    @t0(21)
    public static final <T extends Comparable<? super T>> kotlin.ranges.g<T> e(@a7.d Range<T> range) {
        l0.p(range, "<this>");
        return new a(range);
    }

    @a7.d
    @t0(21)
    public static final <T extends Comparable<? super T>> Range<T> f(@a7.d kotlin.ranges.g<T> gVar) {
        l0.p(gVar, "<this>");
        return new Range<>(gVar.d(), gVar.f());
    }
}
