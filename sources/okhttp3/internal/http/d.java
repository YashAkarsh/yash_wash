package okhttp3.internal.http;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okio.m0;
import okio.o0;

/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f37873a = a.f37876b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f37874b = 100;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f37875a = 100;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ a f37876b = new a();

        private a() {
        }
    }

    void a() throws IOException;

    void b(@a7.d Request request) throws IOException;

    @a7.d
    o0 c(@a7.d Response response) throws IOException;

    void cancel();

    @a7.e
    Response.Builder d(boolean z7) throws IOException;

    @a7.d
    okhttp3.internal.connection.f e();

    void f() throws IOException;

    long g(@a7.d Response response) throws IOException;

    @a7.d
    Headers h() throws IOException;

    @a7.d
    m0 i(@a7.d Request request, long j7) throws IOException;
}
