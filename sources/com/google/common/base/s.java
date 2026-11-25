package com.google.common.base;

import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
@FunctionalInterface
@s1.b
public interface s<F, T> extends Function<F, T> {
    @Override // java.util.function.Function
    @u1.a
    T apply(F f8);

    boolean equals(Object obj);
}
