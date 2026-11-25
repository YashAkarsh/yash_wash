package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public class j0 {

    /* JADX INFO: Add missing generic type declarations: [X] */
    static class a<X> implements x<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ u f8303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i.a f8304b;

        a(u uVar, i.a aVar) {
            this.f8303a = uVar;
            this.f8304b = aVar;
        }

        @Override // androidx.lifecycle.x
        public void a(@c.o0 X x7) {
            this.f8303a.q(this.f8304b.apply(x7));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    static class b<X> implements x<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        LiveData<Y> f8305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i.a f8306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ u f8307c;

        /* JADX INFO: Add missing generic type declarations: [Y] */
        class a<Y> implements x<Y> {
            a() {
            }

            @Override // androidx.lifecycle.x
            public void a(@c.o0 Y y7) {
                b.this.f8307c.q(y7);
            }
        }

        b(i.a aVar, u uVar) {
            this.f8306b = aVar;
            this.f8307c = uVar;
        }

        @Override // androidx.lifecycle.x
        public void a(@c.o0 X x7) {
            LiveData<Y> liveData = (LiveData) this.f8306b.apply(x7);
            Object obj = this.f8305a;
            if (obj == liveData) {
                return;
            }
            if (obj != null) {
                this.f8307c.s(obj);
            }
            this.f8305a = liveData;
            if (liveData != 0) {
                this.f8307c.r(liveData, new a());
            }
        }
    }

    private j0() {
    }

    @c.j0
    public static <X, Y> LiveData<Y> a(@c.m0 LiveData<X> liveData, @c.m0 i.a<X, Y> aVar) {
        u uVar = new u();
        uVar.r(liveData, new a(uVar, aVar));
        return uVar;
    }

    @c.j0
    public static <X, Y> LiveData<Y> b(@c.m0 LiveData<X> liveData, @c.m0 i.a<X, LiveData<Y>> aVar) {
        u uVar = new u();
        uVar.r(liveData, new b(aVar, uVar));
        return uVar;
    }
}
