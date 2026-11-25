package com.google.android.gms.common.server.response;

import c.o0;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class f implements j<Boolean> {
    f() {
    }

    @Override // com.google.android.gms.common.server.response.j
    @o0
    public final /* bridge */ /* synthetic */ Boolean a(a aVar, BufferedReader bufferedReader) throws IOException, a.C0185a {
        return Boolean.valueOf(aVar.A(bufferedReader, false));
    }
}
