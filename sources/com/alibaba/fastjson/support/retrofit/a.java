package com.alibaba.fastjson.support.retrofit;

import com.alibaba.fastjson.parser.c;
import com.alibaba.fastjson.parser.j;
import com.alibaba.fastjson.serializer.g1;
import com.alibaba.fastjson.serializer.k1;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.e;
import retrofit2.s;

/* JADX INFO: loaded from: classes.dex */
public class a extends e.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final MediaType f13210f = MediaType.parse("application/json; charset=UTF-8");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final c[] f13211g = new c[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private j f13212a = j.q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13213b = com.alibaba.fastjson.a.f12532f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c[] f13214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g1 f13215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private k1[] f13216e;

    /* JADX INFO: renamed from: com.alibaba.fastjson.support.retrofit.a$a, reason: collision with other inner class name */
    final class C0151a<T> implements e<T, RequestBody> {
        C0151a() {
        }

        @Override // retrofit2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public RequestBody a(T t7) throws IOException {
            return RequestBody.create(a.f13210f, com.alibaba.fastjson.a.t0(t7, a.this.f13215d == null ? g1.f13055g : a.this.f13215d, a.this.f13216e == null ? k1.F : a.this.f13216e));
        }
    }

    final class b<T> implements e<ResponseBody, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Type f13218a;

        b(Type type) {
            this.f13218a = type;
        }

        @Override // retrofit2.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public T a(ResponseBody responseBody) throws IOException {
            try {
                return (T) com.alibaba.fastjson.a.W(responseBody.string(), this.f13218a, a.this.f13212a, a.this.f13213b, a.this.f13214c != null ? a.this.f13214c : a.f13211g);
            } finally {
                responseBody.close();
            }
        }
    }

    @Override // retrofit2.e.a
    public e<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new C0151a();
    }

    @Override // retrofit2.e.a
    public e<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        return new b(type);
    }

    public j m() {
        return this.f13212a;
    }

    public int n() {
        return this.f13213b;
    }

    public c[] o() {
        return this.f13214c;
    }

    public g1 p() {
        return this.f13215d;
    }

    public k1[] q() {
        return this.f13216e;
    }

    public a r(j jVar) {
        this.f13212a = jVar;
        return this;
    }

    public a s(int i7) {
        this.f13213b = i7;
        return this;
    }

    public a t(c[] cVarArr) {
        this.f13214c = cVarArr;
        return this;
    }

    public a u(g1 g1Var) {
        this.f13215d = g1Var;
        return this;
    }

    public a v(k1[] k1VarArr) {
        this.f13216e = k1VarArr;
        return this;
    }
}
