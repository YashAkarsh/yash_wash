package com.haier.hailicommontlib.mvp_api.moudle.bean;

import com.google.gson.f;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public class b<C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C f26203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f26204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f26205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f26206d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f26207e;

    class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f26208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f26209b;

        a(Class cls, Type[] typeArr) {
            this.f26208a = cls;
            this.f26209b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f26209b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f26208a;
        }
    }

    public b() {
    }

    private ParameterizedType n(Class cls, Type... typeArr) {
        return new a(cls, typeArr);
    }

    public b a(String str, Class<C> cls) {
        f fVar = new f();
        return cls == null ? (b) fVar.n(str, b.class) : (b) fVar.o(str, n(b.class, cls));
    }

    public C b() {
        return this.f26203a;
    }

    public String c() {
        return this.f26205c;
    }

    public String d() {
        return this.f26206d;
    }

    public String e() {
        return this.f26207e;
    }

    public long f() {
        return this.f26204b;
    }

    public void g(C c8) {
        this.f26203a = c8;
    }

    public void h(String str) {
        this.f26205c = str;
    }

    public void i(C c8) {
        this.f26203a = c8;
    }

    public void j(String str) {
        this.f26206d = str;
    }

    public void k(String str) {
        this.f26207e = str;
    }

    public void l(long j7) {
        this.f26204b = j7;
    }

    public String m(Class<C> cls) {
        return new f().A(this, n(b.class, cls));
    }

    public String toString() {
        return "{retData=" + this.f26203a + ", sysTime=" + this.f26204b + ", retCode='" + this.f26205c + "', retInfo='" + this.f26206d + "', retSign='" + this.f26207e + "'}";
    }

    public b(C c8, long j7, String str, String str2, String str3) {
        this.f26203a = c8;
        this.f26204b = j7;
        this.f26205c = str;
        this.f26206d = str2;
        this.f26207e = str3;
    }
}
