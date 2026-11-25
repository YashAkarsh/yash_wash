package junit.framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f extends HashMap<org.junit.runner.c, i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f34357a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f34358b = new f();

    class a extends org.junit.runner.notification.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f34359a;

        a(m mVar) {
            this.f34359a = mVar;
        }

        @Override // org.junit.runner.notification.b
        public void b(org.junit.runner.notification.a aVar) throws Exception {
            this.f34359a.a(f.this.a(aVar.a()), aVar.b());
        }

        @Override // org.junit.runner.notification.b
        public void c(org.junit.runner.c cVar) throws Exception {
            this.f34359a.e(f.this.a(cVar));
        }

        @Override // org.junit.runner.notification.b
        public void g(org.junit.runner.c cVar) throws Exception {
            this.f34359a.o(f.this.a(cVar));
        }
    }

    public static f e() {
        return f34358b;
    }

    public i a(org.junit.runner.c cVar) {
        if (cVar.t()) {
            return c(cVar);
        }
        if (!containsKey(cVar)) {
            put(cVar, c(cVar));
        }
        return get(cVar);
    }

    public List<i> b(org.junit.runner.c cVar) {
        if (cVar.u()) {
            return Arrays.asList(a(cVar));
        }
        ArrayList arrayList = new ArrayList();
        Iterator<org.junit.runner.c> it = cVar.m().iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    i c(org.junit.runner.c cVar) {
        if (cVar.u()) {
            return new g(cVar);
        }
        n nVar = new n(cVar.o());
        Iterator<org.junit.runner.c> it = cVar.m().iterator();
        while (it.hasNext()) {
            nVar.b(a(it.next()));
        }
        return nVar;
    }

    public org.junit.runner.notification.c g(m mVar, e eVar) {
        org.junit.runner.notification.c cVar = new org.junit.runner.notification.c();
        cVar.d(new a(mVar));
        return cVar;
    }
}
