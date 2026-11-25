package com.google.common.base;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
@FunctionalInterface
@s1.b
public interface g0<T> extends Predicate<T> {
    @u1.a
    boolean apply(T t7);

    boolean equals(Object obj);

    @Override // java.util.function.Predicate
    boolean test(T t7);
}
