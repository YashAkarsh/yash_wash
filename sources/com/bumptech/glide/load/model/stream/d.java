package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class d implements f<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14519a;

    public static class a implements m<byte[], InputStream> {
        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<byte[], InputStream> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new d();
        }
    }

    public d() {
        this("");
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<InputStream> a(byte[] bArr, int i7, int i8) {
        return new com.bumptech.glide.load.data.b(bArr, this.f14519a);
    }

    @Deprecated
    public d(String str) {
        this.f14519a = str;
    }
}
