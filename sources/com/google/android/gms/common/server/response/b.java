package com.google.android.gms.common.server.response;

import c.o0;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class b implements j<Integer> {
    b() {
    }

    @Override // com.google.android.gms.common.server.response.j
    @o0
    public final /* synthetic */ Integer a(a aVar, BufferedReader bufferedReader) throws IOException, a.C0185a {
        return Integer.valueOf(aVar.n(bufferedReader));
    }
}
