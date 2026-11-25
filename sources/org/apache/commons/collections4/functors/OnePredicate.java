package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Predicate;

/* JADX INFO: loaded from: classes3.dex */
public final class OnePredicate<T> extends AbstractQuantifierPredicate<T> {
    private static final long serialVersionUID = -8125389089924745785L;

    public OnePredicate(Predicate<? super T>... predicateArr) {
        super(predicateArr);
    }

    public static <T> Predicate<T> onePredicate(Predicate<? super T>... predicateArr) {
        FunctorUtils.validate(predicateArr);
        if (predicateArr.length == 0) {
            return FalsePredicate.falsePredicate();
        }
        return predicateArr.length == 1 ? (Predicate<T>) predicateArr[0] : new OnePredicate(FunctorUtils.copy(predicateArr));
    }

    @Override // org.apache.commons.collections4.Predicate
    public boolean evaluate(T t7) {
        boolean z7 = false;
        for (Predicate<? super T> predicate : this.iPredicates) {
            if (predicate.evaluate(t7)) {
                if (z7) {
                    return false;
                }
                z7 = true;
            }
        }
        return z7;
    }

    public static <T> Predicate<T> onePredicate(Collection<? extends Predicate<? super T>> collection) {
        return new OnePredicate(FunctorUtils.validate(collection));
    }
}
