package com.google.common.base;

import java.lang.ref.PhantomReference;

/* JADX INFO: loaded from: classes.dex */
@s1.c
public abstract class n<T> extends PhantomReference<T> implements o {
    protected n(T t7, p pVar) {
        super(t7, pVar.f19508a);
        pVar.e();
    }
}
