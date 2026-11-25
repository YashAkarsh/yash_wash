package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class f<A> implements l<A, g> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14476c = "IVML";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l<A, InputStream> f14477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<A, ParcelFileDescriptor> f14478b;

    static class a implements com.bumptech.glide.load.data.c<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.data.c<InputStream> f14479a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.load.data.c<ParcelFileDescriptor> f14480b;

        public a(com.bumptech.glide.load.data.c<InputStream> cVar, com.bumptech.glide.load.data.c<ParcelFileDescriptor> cVar2) {
            this.f14479a = cVar;
            this.f14480b = cVar2;
        }

        @Override // com.bumptech.glide.load.data.c
        public String a() {
            com.bumptech.glide.load.data.c<InputStream> cVar = this.f14479a;
            return cVar != null ? cVar.a() : this.f14480b.a();
        }

        @Override // com.bumptech.glide.load.data.c
        public void b() {
            com.bumptech.glide.load.data.c<InputStream> cVar = this.f14479a;
            if (cVar != null) {
                cVar.b();
            }
            com.bumptech.glide.load.data.c<ParcelFileDescriptor> cVar2 = this.f14480b;
            if (cVar2 != null) {
                cVar2.b();
            }
        }

        @Override // com.bumptech.glide.load.data.c
        public void cancel() {
            com.bumptech.glide.load.data.c<InputStream> cVar = this.f14479a;
            if (cVar != null) {
                cVar.cancel();
            }
            com.bumptech.glide.load.data.c<ParcelFileDescriptor> cVar2 = this.f14480b;
            if (cVar2 != null) {
                cVar2.cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public g c(com.bumptech.glide.p pVar) throws Exception {
            InputStream inputStreamC;
            com.bumptech.glide.load.data.c<InputStream> cVar = this.f14479a;
            ParcelFileDescriptor parcelFileDescriptorC = null;
            if (cVar != null) {
                try {
                    inputStreamC = cVar.c(pVar);
                } catch (Exception e8) {
                    if (Log.isLoggable(f.f14476c, 2)) {
                        Log.v(f.f14476c, "Exception fetching input stream, trying ParcelFileDescriptor", e8);
                    }
                    if (this.f14480b == null) {
                        throw e8;
                    }
                    inputStreamC = null;
                }
            } else {
                inputStreamC = null;
            }
            com.bumptech.glide.load.data.c<ParcelFileDescriptor> cVar2 = this.f14480b;
            if (cVar2 != null) {
                try {
                    parcelFileDescriptorC = cVar2.c(pVar);
                } catch (Exception e9) {
                    if (Log.isLoggable(f.f14476c, 2)) {
                        Log.v(f.f14476c, "Exception fetching ParcelFileDescriptor", e9);
                    }
                    if (inputStreamC == null) {
                        throw e9;
                    }
                }
            }
            return new g(inputStreamC, parcelFileDescriptorC);
        }
    }

    public f(l<A, InputStream> lVar, l<A, ParcelFileDescriptor> lVar2) {
        if (lVar == null && lVar2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f14477a = lVar;
        this.f14478b = lVar2;
    }

    @Override // com.bumptech.glide.load.model.l
    public com.bumptech.glide.load.data.c<g> a(A a8, int i7, int i8) {
        l<A, InputStream> lVar = this.f14477a;
        com.bumptech.glide.load.data.c<InputStream> cVarA = lVar != null ? lVar.a(a8, i7, i8) : null;
        l<A, ParcelFileDescriptor> lVar2 = this.f14478b;
        com.bumptech.glide.load.data.c<ParcelFileDescriptor> cVarA2 = lVar2 != null ? lVar2.a(a8, i7, i8) : null;
        if (cVarA == null && cVarA2 == null) {
            return null;
        }
        return new a(cVarA, cVarA2);
    }
}
