package org.junit.internal;

import java.io.PrintStream;

/* JADX INFO: loaded from: classes3.dex */
public class i implements g {
    @Override // org.junit.internal.g
    public PrintStream a() {
        return System.out;
    }

    @Override // org.junit.internal.g
    @Deprecated
    public void b(int i7) {
        System.exit(i7);
    }
}
