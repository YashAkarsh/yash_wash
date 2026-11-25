package org.checkerframework.checker.nullness;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    private c() {
        throw new AssertionError("shouldn't be instantiated");
    }

    public static <T> T a(T t7, Predicate<? super T> predicate) {
        if (t7 != null && predicate.test(t7)) {
            return t7;
        }
        return null;
    }

    public static <T> T b(T t7) {
        if (t7 != null) {
            return t7;
        }
        throw new NoSuchElementException("No value present");
    }

    public static <T> void c(T t7, Consumer<? super T> consumer) {
        if (t7 != null) {
            consumer.accept(t7);
        }
    }

    @g6.c(expression = {"#1"}, result = true)
    public static boolean d(Object obj) {
        return obj != null;
    }

    public static <T, U> U e(T t7, Function<? super T, ? extends U> function) {
        if (t7 == null) {
            return null;
        }
        return (U) function.apply(t7);
    }

    public static <T> T f(T t7, T t8) {
        return t7 != null ? t7 : t8;
    }

    public static <T> T g(T t7, Supplier<? extends T> supplier) {
        return t7 != null ? t7 : (T) supplier.get();
    }

    public static <T, X extends Throwable> T h(T t7, Supplier<? extends X> supplier) throws Throwable {
        if (t7 != null) {
            return t7;
        }
        throw ((Throwable) supplier.get());
    }
}
