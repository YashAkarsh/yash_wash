package com.haier.hailicommontlib.mvp_api.moudle.bean;

import com.google.gson.f;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class c<C> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<C> f26213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f26214d;

    class a implements ParameterizedType {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Class f26215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type[] f26216b;

        a(Class cls, Type[] typeArr) {
            this.f26215a = cls;
            this.f26216b = typeArr;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return this.f26216b;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return null;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.f26215a;
        }
    }

    private ParameterizedType k(Class cls, Type... typeArr) {
        return new a(cls, typeArr);
    }

    public c<C> a(String str, Class<C> cls) {
        return (c) new f().o(str, k(c.class, cls));
    }

    public ArrayList<C> b() {
        return this.f26213c;
    }

    public String c() {
        return this.f26211a;
    }

    public String d() {
        return this.f26212b;
    }

    public long e() {
        return this.f26214d;
    }

    public void f(ArrayList<C> arrayList) {
        this.f26213c = arrayList;
    }

    public void g(String str) {
        this.f26211a = str;
    }

    public void h(String str) {
        this.f26212b = str;
    }

    public void i(long j7) {
        this.f26214d = j7;
    }

    public String j(String str, Class<C> cls) {
        return new f().A(this, k(b.class, cls));
    }

    public String toString() {
        return "BaseListDate{retCode='" + this.f26211a + "', retInfo='" + this.f26212b + "', retData=" + this.f26213c + '}';
    }
}
