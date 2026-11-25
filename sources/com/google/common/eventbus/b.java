package com.google.common.eventbus;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@s1.a
public class b extends e {
    public b(String str, Executor executor) {
        super(str, executor, d.c(), e.a.f21562a);
    }

    public b(Executor executor, i iVar) {
        super("default", executor, d.c(), iVar);
    }

    public b(Executor executor) {
        super("default", executor, d.c(), e.a.f21562a);
    }
}
