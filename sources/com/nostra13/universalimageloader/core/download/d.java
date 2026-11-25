package com.nostra13.universalimageloader.core.download;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f32793a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32794a;

        static {
            int[] iArr = new int[c.a.values().length];
            f32794a = iArr;
            try {
                iArr[c.a.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32794a[c.a.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public d(c cVar) {
        this.f32793a = cVar;
    }

    @Override // com.nostra13.universalimageloader.core.download.c
    public InputStream a(String str, Object obj) throws IOException {
        int i7 = a.f32794a[c.a.c(str).ordinal()];
        if (i7 == 1 || i7 == 2) {
            throw new IllegalStateException();
        }
        return this.f32793a.a(str, obj);
    }
}
