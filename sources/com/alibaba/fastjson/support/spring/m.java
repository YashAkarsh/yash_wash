package com.alibaba.fastjson.support.spring;

import com.alibaba.fastjson.serializer.m1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<a> f13253a = new ArrayList();

    public class a extends m1 {
        public a() {
            super(new String[0]);
        }

        public a k(String... strArr) {
            for (String str : strArr) {
                g().add(str);
            }
            return this;
        }

        public a l(String... strArr) {
            for (String str : strArr) {
                h().add(str);
            }
            return this;
        }

        public a(String... strArr) {
            super(strArr);
        }

        public a(Class<?> cls, String... strArr) {
            super(cls, strArr);
        }
    }

    public a a() {
        a aVar = new a();
        this.f13253a.add(aVar);
        return aVar;
    }

    public a b(Class<?> cls, String... strArr) {
        a aVar = new a(cls, strArr);
        this.f13253a.add(aVar);
        return aVar;
    }

    public a c(String... strArr) {
        a aVar = new a(strArr);
        this.f13253a.add(aVar);
        return aVar;
    }

    public List<a> d() {
        return this.f13253a;
    }

    public void e(List<a> list) {
        this.f13253a = list;
    }

    public a[] f() {
        return (a[]) this.f13253a.toArray(new a[0]);
    }
}
