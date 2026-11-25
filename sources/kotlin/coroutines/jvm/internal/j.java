package kotlin.coroutines.jvm.internal;

import kotlin.g1;

/* JADX INFO: loaded from: classes2.dex */
@g1(version = "1.3")
public abstract class j extends a {
    public j(@a7.e kotlin.coroutines.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.d() == kotlin.coroutines.i.f34682a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // kotlin.coroutines.d
    @a7.d
    public kotlin.coroutines.g d() {
        return kotlin.coroutines.i.f34682a;
    }
}
