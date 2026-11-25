package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.model.l;
import com.bumptech.glide.p;

/* JADX INFO: loaded from: classes.dex */
class g implements l<com.bumptech.glide.gifdecoder.a, com.bumptech.glide.gifdecoder.a> {

    private static class a implements com.bumptech.glide.load.data.c<com.bumptech.glide.gifdecoder.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.gifdecoder.a f14667a;

        public a(com.bumptech.glide.gifdecoder.a aVar) {
            this.f14667a = aVar;
        }

        @Override // com.bumptech.glide.load.data.c
        public String a() {
            return String.valueOf(this.f14667a.d());
        }

        @Override // com.bumptech.glide.load.data.c
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.c
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.gifdecoder.a c(p pVar) {
            return this.f14667a;
        }
    }

    g() {
    }

    @Override // com.bumptech.glide.load.model.l
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.load.data.c<com.bumptech.glide.gifdecoder.a> a(com.bumptech.glide.gifdecoder.a aVar, int i7, int i8) {
        return new a(aVar);
    }
}
