package org.chromium.net.impl;

import c.o0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.chromium.net.k0;
import org.chromium.net.t0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends org.chromium.net.o {

    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface b {
    }

    @Override // org.chromium.net.o, org.chromium.net.j
    /* JADX INFO: renamed from: s */
    public org.chromium.net.p.a e(String str, t0.b bVar, Executor executor) {
        return new s(str, bVar, executor, this);
    }

    protected abstract org.chromium.net.n y(String str, org.chromium.net.d.b bVar, Executor executor, String str2, List<Map.Entry<String, String>> list, int i7, boolean z7, Collection<Object> collection, boolean z8, int i8, boolean z9, int i9);

    protected abstract r z(String str, t0.b bVar, Executor executor, int i7, Collection<Object> collection, boolean z7, boolean z8, boolean z9, boolean z10, int i8, boolean z11, int i9, @o0 k0.a aVar);
}
