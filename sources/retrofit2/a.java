package retrofit2;

import f7.w;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
final class a extends retrofit2.e.a {

    /* JADX INFO: renamed from: retrofit2.a$a, reason: collision with other inner class name */
    static final class C0544a implements retrofit2.e<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final C0544a f40147a = new C0544a();

        C0544a() {
        }

        @Override // retrofit2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResponseBody a(ResponseBody responseBody) throws IOException {
            try {
                return u.a(responseBody);
            } finally {
                responseBody.close();
            }
        }
    }

    static final class b implements retrofit2.e<RequestBody, RequestBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f40148a = new b();

        b() {
        }

        @Override // retrofit2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestBody a(RequestBody requestBody) throws IOException {
            return requestBody;
        }
    }

    static final class c implements retrofit2.e<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final c f40149a = new c();

        c() {
        }

        @Override // retrofit2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResponseBody a(ResponseBody responseBody) throws IOException {
            return responseBody;
        }
    }

    static final class d implements retrofit2.e<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final d f40150a = new d();

        d() {
        }

        @Override // retrofit2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }

    static final class e implements retrofit2.e<ResponseBody, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final e f40151a = new e();

        e() {
        }

        @Override // retrofit2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return null;
        }
    }

    a() {
    }

    @Override // retrofit2.e.a
    public retrofit2.e<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        if (RequestBody.class.isAssignableFrom(u.j(type))) {
            return b.f40148a;
        }
        return null;
    }

    @Override // retrofit2.e.a
    public retrofit2.e<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        if (type == ResponseBody.class) {
            return u.o(annotationArr, w.class) ? c.f40149a : C0544a.f40147a;
        }
        if (type == Void.class) {
            return e.f40151a;
        }
        return null;
    }
}
