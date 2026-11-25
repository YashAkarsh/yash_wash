package kotlinx.coroutines;

import java.io.Closeable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a2 extends o0 implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    public static final a f35500b = new a(null);

    @kotlin.s
    public static final class a extends kotlin.coroutines.b<o0, a2> {

        /* JADX INFO: renamed from: kotlinx.coroutines.a2$a$a, reason: collision with other inner class name */
        static final class C0443a extends kotlin.jvm.internal.n0 implements i5.l<kotlin.coroutines.g.b, a2> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0443a f35501a = new C0443a();

            C0443a() {
                super(1);
            }

            @Override // i5.l
            @a7.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final a2 z(@a7.d kotlin.coroutines.g.b bVar) {
                if (bVar instanceof a2) {
                    return (a2) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.w wVar) {
            this();
        }

        private a() {
            super(o0.f37100a, C0443a.f35501a);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @a7.d
    public abstract Executor e1();
}
