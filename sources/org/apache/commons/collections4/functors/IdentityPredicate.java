package org.apache.commons.collections4.functors;

import java.io.Serializable;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public final class IdentityPredicate<T> implements Predicate<T>, Serializable {
    private static final long serialVersionUID = -89901658494523293L;
    private final T iValue;

    public IdentityPredicate(T t7) {
        this.iValue = t7;
    }

    public static <T> Predicate<T> identityPredicate(T t7) {
        return t7 == null ? NullPredicate.nullPredicate() : new IdentityPredicate(t7);
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t7) {
        return this.iValue == t7;
    }

    public T getValue() {
        return this.iValue;
    }
}
