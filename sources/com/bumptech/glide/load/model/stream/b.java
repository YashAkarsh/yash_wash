package com.bumptech.glide.load.model.stream;

import android.content.Context;
import com.bumptech.glide.load.model.k;
import com.bumptech.glide.load.model.l;
import com.bumptech.glide.load.model.m;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class b implements f<com.bumptech.glide.load.model.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final k<com.bumptech.glide.load.model.d, com.bumptech.glide.load.model.d> f14515a;

    public static class a implements m<com.bumptech.glide.load.model.d, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k<com.bumptech.glide.load.model.d, com.bumptech.glide.load.model.d> f14516a = new k<>(500);

        @Override // com.bumptech.glide.load.model.m
        public void a() {
        }

        @Override // com.bumptech.glide.load.model.m
        public l<com.bumptech.glide.load.model.d, InputStream> b(Context context, com.bumptech.glide.load.model.c cVar) {
            return new b(this.f14516a);
        }
    }

    public b() {
        this(null);
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<InputStream> a(com.bumptech.glide.load.model.d dVar, int i7, int i8) {
        k<com.bumptech.glide.load.model.d, com.bumptech.glide.load.model.d> kVar = this.f14515a;
        if (kVar != null) {
            com.bumptech.glide.load.model.d dVarA = kVar.a(dVar, 0, 0);
            if (dVarA == null) {
                this.f14515a.b(dVar, 0, 0, dVar);
            } else {
                dVar = dVarA;
            }
        }
        return new com.bumptech.glide.load.data.g(dVar);
    }

    public b(k<com.bumptech.glide.load.model.d, com.bumptech.glide.load.model.d> kVar) {
        this.f14515a = kVar;
    }
}
