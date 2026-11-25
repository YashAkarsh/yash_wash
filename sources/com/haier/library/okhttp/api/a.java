package com.haier.library.okhttp.api;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends b<byte[]> {
    @Override // com.haier.library.okhttp.api.b
    public byte[] parseNetworkResponse(com.haier.library.okhttp.a aVar) throws IOException {
        return aVar.b().e();
    }
}
