package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class e implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f32795a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32796a;

        static {
            int[] iArr = new int[c.a.values().length];
            f32796a = iArr;
            try {
                iArr[c.a.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32796a[c.a.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public e(c cVar) {
        this.f32795a = cVar;
    }

    @Override // com.nostra13.universalimageloader.core.download.c
    public InputStream a(String str, Object obj) throws IOException {
        InputStream inputStreamA = this.f32795a.a(str, obj);
        int i7 = a.f32796a[c.a.c(str).ordinal()];
        return (i7 == 1 || i7 == 2) ? new com.nostra13.universalimageloader.core.assist.c(inputStreamA) : inputStreamA;
    }
}
