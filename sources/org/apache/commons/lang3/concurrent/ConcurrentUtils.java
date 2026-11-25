package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes3.dex */
public class ConcurrentUtils {

    static final class ConstantFuture<T> implements Future<T> {
        private final T value;

        ConstantFuture(T t7) {
            this.value = t7;
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z7) {
            return false;
        }

        @Override // java.util.concurrent.Future
        public T get() {
            return this.value;
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        @Override // java.util.concurrent.Future
        public T get(long j7, TimeUnit timeUnit) {
            return this.value;
        }
    }

    private ConcurrentUtils() {
    }

    static Throwable checkedException(Throwable th) {
        Validate.isTrue((th == null || (th instanceof RuntimeException) || (th instanceof Error)) ? false : true, "Not a checked exception: " + th, new Object[0]);
        return th;
    }

    public static <T> Future<T> constantFuture(T t7) {
        return new ConstantFuture(t7);
    }

    public static <K, V> V createIfAbsent(ConcurrentMap<K, V> concurrentMap, K k7, ConcurrentInitializer<V> concurrentInitializer) throws ConcurrentException {
        if (concurrentMap == null || concurrentInitializer == null) {
            return null;
        }
        V v7 = concurrentMap.get(k7);
        return v7 == null ? (V) putIfAbsent(concurrentMap, k7, concurrentInitializer.get()) : v7;
    }

    public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> concurrentMap, K k7, ConcurrentInitializer<V> concurrentInitializer) {
        try {
            return (V) createIfAbsent(concurrentMap, k7, concurrentInitializer);
        } catch (ConcurrentException e8) {
            throw new ConcurrentRuntimeException(e8.getCause());
        }
    }

    public static ConcurrentException extractCause(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentException(executionException.getMessage(), executionException.getCause());
    }

    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentRuntimeException(executionException.getMessage(), executionException.getCause());
    }

    public static void handleCause(ExecutionException executionException) throws ConcurrentException {
        ConcurrentException concurrentExceptionExtractCause = extractCause(executionException);
        if (concurrentExceptionExtractCause != null) {
            throw concurrentExceptionExtractCause;
        }
    }

    public static void handleCauseUnchecked(ExecutionException executionException) {
        ConcurrentRuntimeException concurrentRuntimeExceptionExtractCauseUnchecked = extractCauseUnchecked(executionException);
        if (concurrentRuntimeExceptionExtractCauseUnchecked != null) {
            throw concurrentRuntimeExceptionExtractCauseUnchecked;
        }
    }

    public static <T> T initialize(ConcurrentInitializer<T> concurrentInitializer) throws ConcurrentException {
        if (concurrentInitializer != null) {
            return concurrentInitializer.get();
        }
        return null;
    }

    public static <T> T initializeUnchecked(ConcurrentInitializer<T> concurrentInitializer) {
        try {
            return (T) initialize(concurrentInitializer);
        } catch (ConcurrentException e8) {
            throw new ConcurrentRuntimeException(e8.getCause());
        }
    }

    public static <K, V> V putIfAbsent(ConcurrentMap<K, V> concurrentMap, K k7, V v7) {
        if (concurrentMap == null) {
            return null;
        }
        V vPutIfAbsent = concurrentMap.putIfAbsent(k7, v7);
        return vPutIfAbsent != null ? vPutIfAbsent : v7;
    }

    private static void throwCause(ExecutionException executionException) {
        if (executionException.getCause() instanceof RuntimeException) {
            throw ((RuntimeException) executionException.getCause());
        }
        if (executionException.getCause() instanceof Error) {
            throw ((Error) executionException.getCause());
        }
    }
}
