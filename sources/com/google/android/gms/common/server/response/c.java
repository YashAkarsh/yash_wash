package com.google.android.gms.common.server.response;

import c.o0;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class c implements j<Long> {
    c() {
    }

    @Override // com.google.android.gms.common.server.response.j
    @o0
    public final /* synthetic */ Long a(a aVar, BufferedReader bufferedReader) throws IOException, a.C0185a {
        return Long.valueOf(aVar.p(bufferedReader));
    }
}
