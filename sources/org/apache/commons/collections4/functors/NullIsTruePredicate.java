package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public final class NullIsTruePredicate<T> implements PredicateDecorator<T>, Serializable {
    private static final long serialVersionUID = -7625133768987126273L;
    private final Predicate<? super T> iPredicate;

    public NullIsTruePredicate(Predicate<? super T> predicate) {
        this.iPredicate = predicate;
    }

    public static <T> Predicate<T> nullIsTruePredicate(Predicate<? super T> predicate) {
        if (predicate != null) {
            return new NullIsTruePredicate(predicate);
        }
        throw new NullPointerException("Predicate must not be null");
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t7) {
        if (t7 == null) {
            return true;
        }
        return this.iPredicate.evaluate(t7);
    }

    @Override // org.apache.commons.collections4.functors.PredicateDecorator
    public Predicate<? super T>[] getPredicates() {
        return new Predicate[]{this.iPredicate};
    }
}
