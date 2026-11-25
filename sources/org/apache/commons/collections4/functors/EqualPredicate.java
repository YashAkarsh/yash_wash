package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public final class EqualPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = 5633766978029907089L;
    private final Equator<T> equator;
    private final T iValue;

    public EqualPredicate(T t7) {
        this(t7, null);
    }

    public static <T> Predicate<T> equalPredicate(T t7) {
        return t7 == null ? NullPredicate.nullPredicate() : new EqualPredicate(t7);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t7) {
        Equator<T> equator = this.equator;
        return equator != null ? equator.equate(this.iValue, t7) : this.iValue.equals(t7);
    }

    public Object getValue() {
        return this.iValue;
    }

    public EqualPredicate(T t7, Equator<T> equator) {
        this.iValue = t7;
        this.equator = equator;
    }

    public static <T> Predicate<T> equalPredicate(T t7, Equator<T> equator) {
        if (t7 == null) {
            return NullPredicate.nullPredicate();
        }
        return new EqualPredicate(t7, equator);
    }
}
