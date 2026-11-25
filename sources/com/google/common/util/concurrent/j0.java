package com.google.common.util.concurrent;

import java.lang.Exception;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
@u1.a
@Deprecated
@s1.a
@s1.b
public interface j0<V, X extends Exception> extends l1<V> {
    V J(long j7, TimeUnit timeUnit) throws Exception;

    V w() throws Exception;
}
