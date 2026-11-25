package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.List;
import org.junit.runner.l;
import org.junit.runners.model.h;

/* JADX INFO: loaded from: classes3.dex */
public class g extends f<l> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<l> f40042f;

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        Class<?>[] value();
    }

    public g(Class<?> cls, h hVar) throws org.junit.runners.model.e {
        this(hVar, cls, I(cls));
    }

    public static l H() {
        try {
            return new g((Class<?>) null, (Class<?>[]) new Class[0]);
        } catch (org.junit.runners.model.e unused) {
            throw new RuntimeException("This shouldn't be possible");
        }
    }

    private static Class<?>[] I(Class<?> cls) throws org.junit.runners.model.e {
        a aVar = (a) cls.getAnnotation(a.class);
        if (aVar != null) {
            return aVar.value();
        }
        throw new org.junit.runners.model.e(String.format("class '%s' must have a SuiteClasses annotation", cls.getName()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.f
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public org.junit.runner.c o(l lVar) {
        return lVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.junit.runners.f
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void v(l lVar, org.junit.runner.notification.c cVar) {
        lVar.a(cVar);
    }

    @Override // org.junit.runners.f
    protected List<l> p() {
        return this.f40042f;
    }

    public g(h hVar, Class<?>[] clsArr) throws org.junit.runners.model.e {
        this((Class<?>) null, hVar.e(null, clsArr));
    }

    protected g(Class<?> cls, Class<?>[] clsArr) throws org.junit.runners.model.e {
        this(new org.junit.internal.builders.a(true), cls, clsArr);
    }

    protected g(h hVar, Class<?> cls, Class<?>[] clsArr) throws org.junit.runners.model.e {
        this(cls, hVar.e(cls, clsArr));
    }

    protected g(Class<?> cls, List<l> list) throws org.junit.runners.model.e {
        super(cls);
        this.f40042f = Collections.unmodifiableList(list);
    }
}
