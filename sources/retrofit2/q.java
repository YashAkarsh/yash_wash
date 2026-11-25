package retrofit2;

import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
final class q {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final char[] f40217k = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f40218l = " \"<>^`{}|\\?#";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f40219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HttpUrl f40220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f40221c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private HttpUrl.Builder f40222d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Request.Builder f40223e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private MediaType f40224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f40225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private MultipartBody.Builder f40226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private FormBody.Builder f40227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private RequestBody f40228j;

    private static class a extends RequestBody {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RequestBody f40229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MediaType f40230b;

        a(RequestBody requestBody, MediaType mediaType) {
            this.f40229a = requestBody;
            this.f40230b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.f40229a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.f40230b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(okio.n nVar) throws IOException {
            this.f40229a.writeTo(nVar);
        }
    }

    q(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z7, boolean z8, boolean z9) {
        this.f40219a = str;
        this.f40220b = httpUrl;
        this.f40221c = str2;
        Request.Builder builder = new Request.Builder();
        this.f40223e = builder;
        this.f40224f = mediaType;
        this.f40225g = z7;
        if (headers != null) {
            builder.headers(headers);
        }
        if (z8) {
            this.f40227i = new FormBody.Builder();
        } else if (z9) {
            MultipartBody.Builder builder2 = new MultipartBody.Builder();
            this.f40226h = builder2;
            builder2.setType(MultipartBody.FORM);
        }
    }

    private static String h(String str, boolean z7) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || f40218l.indexOf(iCodePointAt) != -1 || (!z7 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                okio.m mVar = new okio.m();
                mVar.B0(str, 0, iCharCount);
                i(mVar, str, iCharCount, length, z7);
                return mVar.m1();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    private static void i(okio.m mVar, String str, int i7, int i8, boolean z7) {
        okio.m mVar2 = null;
        while (i7 < i8) {
            int iCodePointAt = str.codePointAt(i7);
            if (!z7 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt < 32 || iCodePointAt >= 127 || f40218l.indexOf(iCodePointAt) != -1 || (!z7 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    if (mVar2 == null) {
                        mVar2 = new okio.m();
                    }
                    mVar2.x(iCodePointAt);
                    while (!mVar2.N()) {
                        int i9 = mVar2.readByte() & 255;
                        mVar.writeByte(37);
                        char[] cArr = f40217k;
                        mVar.writeByte(cArr[(i9 >> 4) & 15]);
                        mVar.writeByte(cArr[i9 & 15]);
                    }
                } else {
                    mVar.x(iCodePointAt);
                }
            }
            i7 += Character.charCount(iCodePointAt);
        }
    }

    void a(String str, String str2, boolean z7) {
        if (z7) {
            this.f40227i.addEncoded(str, str2);
        } else {
            this.f40227i.add(str, str2);
        }
    }

    void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f40223e.addHeader(str, str2);
            return;
        }
        MediaType mediaType = MediaType.parse(str2);
        if (mediaType != null) {
            this.f40224f = mediaType;
            return;
        }
        throw new IllegalArgumentException("Malformed content type: " + str2);
    }

    void c(Headers headers, RequestBody requestBody) {
        this.f40226h.addPart(headers, requestBody);
    }

    void d(MultipartBody.Part part) {
        this.f40226h.addPart(part);
    }

    void e(String str, String str2, boolean z7) {
        String str3 = this.f40221c;
        if (str3 == null) {
            throw new AssertionError();
        }
        this.f40221c = str3.replace("{" + str + com.alipay.sdk.util.j.f13808d, h(str2, z7));
    }

    void f(String str, @Nullable String str2, boolean z7) {
        String str3 = this.f40221c;
        if (str3 != null) {
            HttpUrl.Builder builderNewBuilder = this.f40220b.newBuilder(str3);
            this.f40222d = builderNewBuilder;
            if (builderNewBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f40220b + ", Relative: " + this.f40221c);
            }
            this.f40221c = null;
        }
        if (z7) {
            this.f40222d.addEncodedQueryParameter(str, str2);
        } else {
            this.f40222d.addQueryParameter(str, str2);
        }
    }

    Request g() {
        HttpUrl httpUrlResolve;
        HttpUrl.Builder builder = this.f40222d;
        if (builder != null) {
            httpUrlResolve = builder.build();
        } else {
            httpUrlResolve = this.f40220b.resolve(this.f40221c);
            if (httpUrlResolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.f40220b + ", Relative: " + this.f40221c);
            }
        }
        RequestBody aVar = this.f40228j;
        if (aVar == null) {
            FormBody.Builder builder2 = this.f40227i;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f40226h;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.f40225g) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f40224f;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f40223e.addHeader("Content-Type", mediaType.toString());
            }
        }
        return this.f40223e.url(httpUrlResolve).method(this.f40219a, aVar).build();
    }

    void j(RequestBody requestBody) {
        this.f40228j = requestBody;
    }

    void k(Object obj) {
        this.f40221c = obj.toString();
    }
}
