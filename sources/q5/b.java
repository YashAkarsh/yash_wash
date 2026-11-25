package q5;

import a7.d;
import a7.e;
import android.annotation.SuppressLint;
import h5.l;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.d1;
import kotlin.e1;
import kotlin.jvm.internal.l0;
import kotlinx.coroutines.debug.internal.g;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/* JADX INFO: loaded from: classes2.dex */
@z6.a
@SuppressLint({"all"})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d
    public static final b f40138a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final boolean f40139b;

    public static final class a implements ClassFileTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @d
        public static final a f40140a = new a();

        private a() {
        }

        @e
        public byte[] a(@d ClassLoader classLoader, @d String str, @e Class<?> cls, @d ProtectionDomain protectionDomain, @e byte[] bArr) {
            if (!l0.g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            kotlinx.coroutines.debug.internal.a.f35896a.b(true);
            return kotlin.io.b.p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    static {
        Object objB;
        try {
            d1.a aVar = d1.f34719b;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            objB = d1.b(property == null ? null : Boolean.valueOf(Boolean.parseBoolean(property)));
        } catch (Throwable th) {
            d1.a aVar2 = d1.f34719b;
            objB = d1.b(e1.a(th));
        }
        Boolean bool = (Boolean) (d1.i(objB) ? null : objB);
        f40139b = bool == null ? g.f35950a.u() : bool.booleanValue();
    }

    private b() {
    }

    private final void b() {
        try {
            Signal.handle(new Signal("TRAP"), new SignalHandler() { // from class: q5.a
                public final void a(Signal signal) {
                    b.c(signal);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Signal signal) {
        g gVar = g.f35950a;
        if (gVar.z()) {
            gVar.f(System.out);
        } else {
            System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @l
    public static final void d(@e String str, @d Instrumentation instrumentation) {
        kotlinx.coroutines.debug.internal.a.f35896a.b(true);
        instrumentation.addTransformer(a.f40140a);
        g gVar = g.f35950a;
        gVar.K(f40139b);
        gVar.x();
        f40138a.b();
    }
}
