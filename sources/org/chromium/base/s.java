package org.chromium.base;

import c.g1;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static c f38863b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g1
    final d f38864a;

    private static class a extends RuntimeException {
        a() {
            super("vvv This is where object was created. vvv");
        }
    }

    static class b extends RuntimeException {
        b(String str, Throwable th) {
            super(str, th);
        }
    }

    interface c {
        void a(d dVar, String str);
    }

    @g1
    static class d extends PhantomReference<Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static ReferenceQueue<Object> f38865d = new ReferenceQueue<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static Set<d> f38866e = Collections.synchronizedSet(new HashSet());

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f38867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<?> f38868b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final a f38869c;

        class a extends Thread {
            a(String str) {
                super(str);
                setDaemon(true);
                start();
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                while (true) {
                    try {
                        d dVar = (d) d.f38865d.remove();
                        d.f38866e.remove(dVar);
                        if (dVar.f38867a) {
                            c cVar = s.f38863b;
                            if (cVar != null) {
                                cVar.a(dVar, null);
                            }
                        } else {
                            String str = String.format("Object of type %s was GC'ed without cleanup. Refer to \"Caused by\" for where object was created.", dVar.f38868b.getName());
                            c cVar2 = s.f38863b;
                            if (cVar2 == null) {
                                throw new b(str, dVar.f38869c);
                            }
                            cVar2.a(dVar, str);
                        }
                    } catch (InterruptedException e8) {
                        throw new RuntimeException(e8);
                    }
                }
            }
        }

        static {
            new a("GcStateAssertQueue");
        }

        public d(Object obj, a aVar, boolean z7) {
            super(obj, f38865d);
            this.f38869c = aVar;
            this.f38867a = z7;
            this.f38868b = obj.getClass();
            f38866e.add(this);
        }
    }

    private s(d dVar) {
        this.f38864a = dVar;
    }

    public static void a() throws b {
        if (l.f38814b) {
            synchronized (d.f38866e) {
                for (d dVar : d.f38866e) {
                    if (!dVar.f38867a) {
                        throw new b(String.format("Object of type %s was not destroyed after test completed. Refer to \"Caused by\" for where object was created.", dVar.f38868b.getName()), dVar.f38869c);
                    }
                }
            }
        }
    }

    public static s b(Object obj) {
        if (l.f38814b) {
            return new s(new d(obj, new a(), false));
        }
        return null;
    }

    public static s c(Object obj, boolean z7) {
        if (l.f38814b) {
            return new s(new d(obj, new a(), z7));
        }
        return null;
    }

    public static void d(s sVar, boolean z7) {
        if (l.f38814b) {
            sVar.f38864a.f38867a = z7;
        }
    }
}
