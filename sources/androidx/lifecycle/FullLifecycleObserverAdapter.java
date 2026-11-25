package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class FullLifecycleObserverAdapter implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f8208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f8209b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8210a;

        static {
            int[] iArr = new int[m.b.values().length];
            f8210a = iArr;
            try {
                iArr[m.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8210a[m.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8210a[m.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8210a[m.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8210a[m.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8210a[m.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8210a[m.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    FullLifecycleObserverAdapter(h hVar, o oVar) {
        this.f8208a = hVar;
        this.f8209b = oVar;
    }

    @Override // androidx.lifecycle.o
    public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
        switch (a.f8210a[bVar.ordinal()]) {
            case 1:
                this.f8208a.b(qVar);
                break;
            case 2:
                this.f8208a.f(qVar);
                break;
            case 3:
                this.f8208a.a(qVar);
                break;
            case 4:
                this.f8208a.c(qVar);
                break;
            case 5:
                this.f8208a.d(qVar);
                break;
            case 6:
                this.f8208a.e(qVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        o oVar = this.f8209b;
        if (oVar != null) {
            oVar.g(qVar, bVar);
        }
    }
}
