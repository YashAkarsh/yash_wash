package org.apache.commons.collections4.functors;

import java.util.Collection;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: loaded from: classes3.dex */
class FunctorUtils {
    private FunctorUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> Closure<T> coerce(Closure<? super T> closure) {
        return closure;
    }

    static <T> Predicate<T>[] copy(Predicate<? super T>... predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    static void validate(Predicate<?>... predicateArr) {
        if (predicateArr == null) {
            throw new NullPointerException("The predicate array must not be null");
        }
        for (int i7 = 0; i7 < predicateArr.length; i7++) {
            if (predicateArr[i7] == null) {
                throw new NullPointerException("The predicate array must not contain a null predicate, index " + i7 + " was null");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <T> Predicate<T> coerce(Predicate<? super T> predicate) {
        return predicate;
    }

    static <E> Closure<E>[] copy(Closure<? super E>... closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <I, O> Transformer<I, O> coerce(Transformer<? super I, ? extends O> transformer) {
        return transformer;
    }

    static <I, O> Transformer<I, O>[] copy(Transformer<? super I, ? extends O>... transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    static <T> Predicate<? super T>[] validate(Collection<? extends Predicate<? super T>> collection) {
        if (collection != null) {
            Predicate<? super T>[] predicateArr = new Predicate[collection.size()];
            int i7 = 0;
            for (Predicate<? super T> predicate : collection) {
                predicateArr[i7] = predicate;
                if (predicate == null) {
                    throw new NullPointerException("The predicate collection must not contain a null predicate, index " + i7 + " was null");
                }
                i7++;
            }
            return predicateArr;
        }
        throw new NullPointerException("The predicate collection must not be null");
    }

    static void validate(Closure<?>... closureArr) {
        if (closureArr != null) {
            for (int i7 = 0; i7 < closureArr.length; i7++) {
                if (closureArr[i7] == null) {
                    throw new NullPointerException("The closure array must not contain a null closure, index " + i7 + " was null");
                }
            }
            return;
        }
        throw new NullPointerException("The closure array must not be null");
    }

    static void validate(Transformer<?, ?>... transformerArr) {
        if (transformerArr != null) {
            for (int i7 = 0; i7 < transformerArr.length; i7++) {
                if (transformerArr[i7] == null) {
                    throw new NullPointerException("The transformer array must not contain a null transformer, index " + i7 + " was null");
                }
            }
            return;
        }
        throw new NullPointerException("The transformer array must not be null");
    }
}
