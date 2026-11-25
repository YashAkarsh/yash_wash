package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.l0;
import kotlin.text.b0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.a0;
import okio.n;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f37868a;

    public b(boolean z7) {
        this.f37868a = z7;
    }

    @Override // okhttp3.Interceptor
    @a7.d
    public Response intercept(@a7.d Interceptor.Chain chain) throws IOException {
        boolean z7;
        Response.Builder builderQ;
        l0.p(chain, "chain");
        g gVar = (g) chain;
        okhttp3.internal.connection.c cVarE = gVar.e();
        l0.m(cVarE);
        Request requestG = gVar.g();
        RequestBody requestBodyBody = requestG.body();
        long jCurrentTimeMillis = System.currentTimeMillis();
        cVarE.w(requestG);
        if (!f.b(requestG.method()) || requestBodyBody == null) {
            cVarE.o();
            z7 = true;
            builderQ = null;
        } else {
            if (b0.K1("100-continue", requestG.header(com.google.common.net.c.f22166r), true)) {
                cVarE.f();
                builderQ = cVarE.q(true);
                cVarE.s();
                z7 = false;
            } else {
                z7 = true;
                builderQ = null;
            }
            if (builderQ != null) {
                cVarE.o();
                if (!cVarE.h().y()) {
                    cVarE.n();
                }
            } else if (requestBodyBody.isDuplex()) {
                cVarE.f();
                requestBodyBody.writeTo(a0.c(cVarE.c(requestG, true)));
            } else {
                n nVarC = a0.c(cVarE.c(requestG, false));
                requestBodyBody.writeTo(nVarC);
                nVarC.close();
            }
        }
        if (requestBodyBody == null || !requestBodyBody.isDuplex()) {
            cVarE.e();
        }
        if (builderQ == null) {
            builderQ = cVarE.q(false);
            l0.m(builderQ);
            if (z7) {
                cVarE.s();
                z7 = false;
            }
        }
        Response responseBuild = builderQ.request(requestG).handshake(cVarE.h().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
        int iCode = responseBuild.code();
        if (iCode == 100) {
            Response.Builder builderQ2 = cVarE.q(false);
            l0.m(builderQ2);
            if (z7) {
                cVarE.s();
            }
            responseBuild = builderQ2.request(requestG).handshake(cVarE.h().handshake()).sentRequestAtMillis(jCurrentTimeMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            iCode = responseBuild.code();
        }
        cVarE.r(responseBuild);
        Response responseBuild2 = (this.f37868a && iCode == 101) ? responseBuild.newBuilder().body(okhttp3.internal.d.f37856c).build() : responseBuild.newBuilder().body(cVarE.p(responseBuild)).build();
        if (b0.K1("close", responseBuild2.request().header(com.google.common.net.c.f22160o), true) || b0.K1("close", Response.header$default(responseBuild2, com.google.common.net.c.f22160o, null, 2, null), true)) {
            cVarE.n();
        }
        if (iCode == 204 || iCode == 205) {
            ResponseBody responseBodyBody = responseBuild2.body();
            if ((responseBodyBody != null ? responseBodyBody.contentLength() : -1L) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(iCode);
                sb.append(" had non-zero Content-Length: ");
                ResponseBody responseBodyBody2 = responseBuild2.body();
                sb.append(responseBodyBody2 != null ? Long.valueOf(responseBodyBody2.contentLength()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return responseBuild2;
    }
}
