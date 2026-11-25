package androidx.lifecycle;

import androidx.lifecycle.k0;

/* JADX INFO: loaded from: classes.dex */
public final class l0<VM extends k0> implements kotlin.d0<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private final kotlin.reflect.d<VM> f8312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private final i5.a<p0> f8313b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @a7.d
    private final i5.a<m0.b> f8314c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @a7.d
    private final i5.a<v.a> f8315d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @a7.e
    private VM f8316e;

    static final class a extends kotlin.jvm.internal.n0 implements i5.a<v.a.C0550a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f8317a = new a();

        a() {
            super(0);
        }

        @Override // i5.a
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final v.a.C0550a invoke() {
            return v.a.C0550a.f40425b;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @h5.i
    public l0(@a7.d kotlin.reflect.d<VM> viewModelClass, @a7.d i5.a<? extends p0> storeProducer, @a7.d i5.a<? extends m0.b> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        kotlin.jvm.internal.l0.p(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.l0.p(storeProducer, "storeProducer");
        kotlin.jvm.internal.l0.p(factoryProducer, "factoryProducer");
    }

    @Override // kotlin.d0
    public boolean a() {
        return this.f8316e != null;
    }

    @Override // kotlin.d0
    @a7.d
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public VM getValue() {
        VM vm = this.f8316e;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new m0(this.f8313b.invoke(), this.f8314c.invoke(), this.f8315d.invoke()).a(h5.a.e(this.f8312a));
        this.f8316e = vm2;
        return vm2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @h5.i
    public l0(@a7.d kotlin.reflect.d<VM> viewModelClass, @a7.d i5.a<? extends p0> storeProducer, @a7.d i5.a<? extends m0.b> factoryProducer, @a7.d i5.a<? extends v.a> extrasProducer) {
        kotlin.jvm.internal.l0.p(viewModelClass, "viewModelClass");
        kotlin.jvm.internal.l0.p(storeProducer, "storeProducer");
        kotlin.jvm.internal.l0.p(factoryProducer, "factoryProducer");
        kotlin.jvm.internal.l0.p(extrasProducer, "extrasProducer");
        this.f8312a = viewModelClass;
        this.f8313b = storeProducer;
        this.f8314c = factoryProducer;
        this.f8315d = extrasProducer;
    }

    public /* synthetic */ l0(kotlin.reflect.d dVar, i5.a aVar, i5.a aVar2, i5.a aVar3, int i7, kotlin.jvm.internal.w wVar) {
        this(dVar, aVar, aVar2, (i7 & 8) != 0 ? a.f8317a : aVar3);
    }
}
