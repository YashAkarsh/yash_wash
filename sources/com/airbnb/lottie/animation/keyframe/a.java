package com.airbnb.lottie.animation.keyframe;

import c.m0;
import c.o0;
import c.v;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class a<K, A> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d<K> f11716c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    protected com.airbnb.lottie.value.j<A> f11718e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<b> f11714a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11715b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected float f11717d = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private A f11719f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f11720g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f11721h = -1.0f;

    public interface b {
        void a();
    }

    private static final class c<T> implements d<T> {
        private c() {
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean a(float f8) {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public com.airbnb.lottie.value.a<T> b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean c(float f8) {
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public float d() {
            return 1.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public float e() {
            return 0.0f;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    private interface d<T> {
        boolean a(float f8);

        com.airbnb.lottie.value.a<T> b();

        boolean c(float f8);

        @v(from = 0.0d, to = 1.0d)
        float d();

        @v(from = 0.0d, to = 1.0d)
        float e();

        boolean isEmpty();
    }

    private static final class e<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<? extends com.airbnb.lottie.value.a<T>> f11722a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.airbnb.lottie.value.a<T> f11724c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f11725d = -1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        private com.airbnb.lottie.value.a<T> f11723b = f(0.0f);

        e(List<? extends com.airbnb.lottie.value.a<T>> list) {
            this.f11722a = list;
        }

        private com.airbnb.lottie.value.a<T> f(float f8) {
            List<? extends com.airbnb.lottie.value.a<T>> list = this.f11722a;
            com.airbnb.lottie.value.a<T> aVar = list.get(list.size() - 1);
            if (f8 >= aVar.e()) {
                return aVar;
            }
            for (int size = this.f11722a.size() - 2; size >= 1; size--) {
                com.airbnb.lottie.value.a<T> aVar2 = this.f11722a.get(size);
                if (this.f11723b != aVar2 && aVar2.a(f8)) {
                    return aVar2;
                }
            }
            return this.f11722a.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean a(float f8) {
            com.airbnb.lottie.value.a<T> aVar = this.f11724c;
            com.airbnb.lottie.value.a<T> aVar2 = this.f11723b;
            if (aVar == aVar2 && this.f11725d == f8) {
                return true;
            }
            this.f11724c = aVar2;
            this.f11725d = f8;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        @m0
        public com.airbnb.lottie.value.a<T> b() {
            return this.f11723b;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean c(float f8) {
            if (this.f11723b.a(f8)) {
                return !this.f11723b.h();
            }
            this.f11723b = f(f8);
            return true;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public float d() {
            List<? extends com.airbnb.lottie.value.a<T>> list = this.f11722a;
            return list.get(list.size() - 1).b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public float e() {
            return this.f11722a.get(0).e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    private static final class f<T> implements d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        private final com.airbnb.lottie.value.a<T> f11726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f11727b = -1.0f;

        f(List<? extends com.airbnb.lottie.value.a<T>> list) {
            this.f11726a = list.get(0);
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean a(float f8) {
            if (this.f11727b == f8) {
                return true;
            }
            this.f11727b = f8;
            return false;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public com.airbnb.lottie.value.a<T> b() {
            return this.f11726a;
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean c(float f8) {
            return !this.f11726a.h();
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public float d() {
            return this.f11726a.b();
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public float e() {
            return this.f11726a.e();
        }

        @Override // com.airbnb.lottie.animation.keyframe.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    a(List<? extends com.airbnb.lottie.value.a<K>> list) {
        this.f11716c = n(list);
    }

    @v(from = 0.0d, to = 1.0d)
    private float g() {
        if (this.f11720g == -1.0f) {
            this.f11720g = this.f11716c.e();
        }
        return this.f11720g;
    }

    private static <T> d<T> n(List<? extends com.airbnb.lottie.value.a<T>> list) {
        if (list.isEmpty()) {
            return new c();
        }
        return list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.f11714a.add(bVar);
    }

    protected com.airbnb.lottie.value.a<K> b() {
        com.airbnb.lottie.e.a("BaseKeyframeAnimation#getCurrentKeyframe");
        com.airbnb.lottie.value.a<K> aVarB = this.f11716c.b();
        com.airbnb.lottie.e.b("BaseKeyframeAnimation#getCurrentKeyframe");
        return aVarB;
    }

    @v(from = 0.0d, to = 1.0d)
    float c() {
        if (this.f11721h == -1.0f) {
            this.f11721h = this.f11716c.d();
        }
        return this.f11721h;
    }

    protected float d() {
        com.airbnb.lottie.value.a<K> aVarB = b();
        if (aVarB.h()) {
            return 0.0f;
        }
        return aVarB.f12351d.getInterpolation(e());
    }

    float e() {
        if (this.f11715b) {
            return 0.0f;
        }
        com.airbnb.lottie.value.a<K> aVarB = b();
        if (aVarB.h()) {
            return 0.0f;
        }
        return (this.f11717d - aVarB.e()) / (aVarB.b() - aVarB.e());
    }

    public float f() {
        return this.f11717d;
    }

    public A h() {
        float fD = d();
        if (this.f11718e == null && this.f11716c.a(fD)) {
            return this.f11719f;
        }
        A aI = i(b(), fD);
        this.f11719f = aI;
        return aI;
    }

    abstract A i(com.airbnb.lottie.value.a<K> aVar, float f8);

    public void j() {
        for (int i7 = 0; i7 < this.f11714a.size(); i7++) {
            this.f11714a.get(i7).a();
        }
    }

    public void k() {
        this.f11715b = true;
    }

    public void l(@v(from = 0.0d, to = 1.0d) float f8) {
        if (this.f11716c.isEmpty()) {
            return;
        }
        if (f8 < g()) {
            f8 = g();
        } else if (f8 > c()) {
            f8 = c();
        }
        if (f8 == this.f11717d) {
            return;
        }
        this.f11717d = f8;
        if (this.f11716c.c(f8)) {
            j();
        }
    }

    public void m(@o0 com.airbnb.lottie.value.j<A> jVar) {
        com.airbnb.lottie.value.j<A> jVar2 = this.f11718e;
        if (jVar2 != null) {
            jVar2.c(null);
        }
        this.f11718e = jVar;
        if (jVar != null) {
            jVar.c(this);
        }
    }
}
