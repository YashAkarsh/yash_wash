package retrofit2;

import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class r<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Response f40231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final T f40232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final ResponseBody f40233c;

    private r(Response response, @Nullable T t7, @Nullable ResponseBody responseBody) {
        this.f40231a = response;
        this.f40232b = t7;
        this.f40233c = responseBody;
    }

    public static <T> r<T> c(int i7, ResponseBody responseBody) {
        if (i7 >= 400) {
            return d(responseBody, new Response.Builder().code(i7).message("Response.error()").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
        }
        throw new IllegalArgumentException("code < 400: " + i7);
    }

    public static <T> r<T> d(ResponseBody responseBody, Response response) {
        u.b(responseBody, "body == null");
        u.b(response, "rawResponse == null");
        if (response.isSuccessful()) {
            throw new IllegalArgumentException("rawResponse should not be successful response");
        }
        return new r<>(response, null, responseBody);
    }

    public static <T> r<T> j(@Nullable T t7) {
        return l(t7, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> r<T> k(@Nullable T t7, Headers headers) {
        u.b(headers, "headers == null");
        return l(t7, new Response.Builder().code(200).message("OK").protocol(Protocol.HTTP_1_1).headers(headers).request(new Request.Builder().url("http://localhost/").build()).build());
    }

    public static <T> r<T> l(@Nullable T t7, Response response) {
        u.b(response, "rawResponse == null");
        if (response.isSuccessful()) {
            return new r<>(response, t7, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    @Nullable
    public T a() {
        return this.f40232b;
    }

    public int b() {
        return this.f40231a.code();
    }

    @Nullable
    public ResponseBody e() {
        return this.f40233c;
    }

    public Headers f() {
        return this.f40231a.headers();
    }

    public boolean g() {
        return this.f40231a.isSuccessful();
    }

    public String h() {
        return this.f40231a.message();
    }

    public Response i() {
        return this.f40231a;
    }

    public String toString() {
        return this.f40231a.toString();
    }
}
