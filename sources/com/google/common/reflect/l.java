package com.google.common.reflect;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public interface l<B> extends Map<m<? extends B>, B> {
    @u1.a
    <T extends B> T F(m<T> mVar, T t7);

    @u1.a
    <T extends B> T h(Class<T> cls, T t7);

    <T extends B> T j(Class<T> cls);

    <T extends B> T p(m<T> mVar);
}
