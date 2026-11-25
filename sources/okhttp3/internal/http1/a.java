package okhttp3.internal.http1;

import a7.d;
import java.io.IOException;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okhttp3.Headers;
import okio.o;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f37904c = 262144;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0505a f37905d = new C0505a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f37906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @d
    private final o f37907b;

    /* JADX INFO: renamed from: okhttp3.internal.http1.a$a, reason: collision with other inner class name */
    public static final class C0505a {
        private C0505a() {
        }

        public /* synthetic */ C0505a(w wVar) {
            this();
        }
    }

    public a(@d o source) {
        l0.p(source, "source");
        this.f37907b = source;
        this.f37906a = 262144;
    }

    @d
    public final o a() {
        return this.f37907b;
    }

    @d
    public final Headers b() throws IOException {
        Headers.Builder builder = new Headers.Builder();
        while (true) {
            String strC = c();
            if (strC.length() == 0) {
                return builder.build();
            }
            builder.addLenient$okhttp(strC);
        }
    }

    @d
    public final String c() throws IOException {
        String strE0 = this.f37907b.e0(this.f37906a);
        this.f37906a -= (long) strE0.length();
        return strE0;
    }
}
