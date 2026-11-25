package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.l0;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f37746a = new a();

    private a() {
    }

    @Override // okhttp3.Interceptor
    @a7.d
    public Response intercept(@a7.d Interceptor.Chain chain) throws IOException {
        l0.p(chain, "chain");
        okhttp3.internal.http.g gVar = (okhttp3.internal.http.g) chain;
        return okhttp3.internal.http.g.b(gVar, 0, gVar.c().t(gVar), null, 0, 0, 0, 61, null).proceed(gVar.g());
    }
}
