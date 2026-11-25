package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.w;
import okio.o;

/* JADX INFO: loaded from: classes3.dex */
public interface l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38203b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    @h5.e
    public static final l f38202a = new a.C0508a();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f38204a = null;

        /* JADX INFO: renamed from: okhttp3.internal.http2.l$a$a, reason: collision with other inner class name */
        private static final class C0508a implements l {
            @Override // okhttp3.internal.http2.l
            public boolean a(int i7, @a7.d List<c> requestHeaders) {
                l0.p(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.l
            public boolean b(int i7, @a7.d List<c> responseHeaders, boolean z7) {
                l0.p(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // okhttp3.internal.http2.l
            public void c(int i7, @a7.d b errorCode) {
                l0.p(errorCode, "errorCode");
            }

            @Override // okhttp3.internal.http2.l
            public boolean d(int i7, @a7.d o source, int i8, boolean z7) throws IOException {
                l0.p(source, "source");
                source.skip(i8);
                return true;
            }
        }

        private a() {
        }

        public /* synthetic */ a(w wVar) {
            this();
        }
    }

    boolean a(int i7, @a7.d List<c> list);

    boolean b(int i7, @a7.d List<c> list, boolean z7);

    void c(int i7, @a7.d b bVar);

    boolean d(int i7, @a7.d o oVar, int i8, boolean z7) throws IOException;
}
