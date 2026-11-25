package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class n0 {
    static {
        m0.b.a aVar = m0.b.f8336a;
    }

    @a7.d
    public static k0 a(m0.b bVar, @a7.d Class modelClass) {
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    @a7.d
    public static k0 b(m0.b bVar, @a7.d Class modelClass, @a7.d v.a extras) {
        kotlin.jvm.internal.l0.p(modelClass, "modelClass");
        kotlin.jvm.internal.l0.p(extras, "extras");
        return bVar.a(modelClass);
    }

    @a7.d
    @h5.l
    public static m0.b c(@a7.d v.g<?>... gVarArr) {
        return m0.b.f8336a.a(gVarArr);
    }
}
