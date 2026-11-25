package com.google.android.gms.common.server.response;

import c.o0;
import java.io.BufferedReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
final class d implements j<Float> {
    d() {
    }

    @Override // com.google.android.gms.common.server.response.j
    @o0
    public final /* synthetic */ Float a(a aVar, BufferedReader bufferedReader) throws IOException, a.C0185a {
        return Float.valueOf(aVar.m(bufferedReader));
    }
}
