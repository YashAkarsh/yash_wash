package com.google.common.collect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.b
public interface v0<B> extends Map<Class<? extends B>, B> {
    @u1.a
    <T extends B> T h(Class<T> cls, T t7);

    @u1.a
    <T extends B> T j(Class<T> cls);
}
