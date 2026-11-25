package org.junit.runners;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.l;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public class e extends g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final org.junit.runners.parameterized.c f40026h = new org.junit.runners.parameterized.b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final List<l> f40027i = Collections.emptyList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<l> f40028g;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface a {
        int value() default 0;
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String name() default "{index}";
    }

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface c {
        Class<? extends org.junit.runners.parameterized.c> value() default org.junit.runners.parameterized.b.class;
    }

    public e(Class<?> cls) throws Throwable {
        super(cls, f40027i);
        this.f40028g = Collections.unmodifiableList(L(K(), ((b) P().getAnnotation(b.class)).name(), Q(cls)));
    }

    private Iterable<Object> K() throws Exception {
        Object objM = P().m(null, new Object[0]);
        if (objM instanceof Iterable) {
            return (Iterable) objM;
        }
        if (objM instanceof Object[]) {
            return Arrays.asList((Object[]) objM);
        }
        throw R();
    }

    private List<l> L(Iterable<Object> iterable, String str, org.junit.runners.parameterized.c cVar) throws Exception {
        try {
            List<org.junit.runners.parameterized.d> listO = O(iterable, str);
            ArrayList arrayList = new ArrayList();
            Iterator<org.junit.runners.parameterized.d> it = listO.iterator();
            while (it.hasNext()) {
                arrayList.add(cVar.a(it.next()));
            }
            return arrayList;
        } catch (ClassCastException unused) {
            throw R();
        }
    }

    private org.junit.runners.parameterized.d M(String str, int i7, Object obj) {
        return N(t(), str, i7, obj instanceof Object[] ? (Object[]) obj : new Object[]{obj});
    }

    private static org.junit.runners.parameterized.d N(k kVar, String str, int i7, Object[] objArr) {
        return new org.junit.runners.parameterized.d("[" + MessageFormat.format(str.replaceAll("\\{index\\}", Integer.toString(i7)), objArr) + "]", kVar, Arrays.asList(objArr));
    }

    private List<org.junit.runners.parameterized.d> O(Iterable<Object> iterable, String str) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = iterable.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            arrayList.add(M(str, i7, it.next()));
            i7++;
        }
        return arrayList;
    }

    private org.junit.runners.model.d P() throws Exception {
        for (org.junit.runners.model.d dVar : t().i(b.class)) {
            if (dVar.h() && dVar.e()) {
                return dVar;
            }
        }
        throw new Exception("No public static parameters method on class " + t().k());
    }

    private org.junit.runners.parameterized.c Q(Class<?> cls) throws IllegalAccessException, InstantiationException {
        c cVar = (c) cls.getAnnotation(c.class);
        return cVar == null ? f40026h : cVar.value().newInstance();
    }

    private Exception R() throws Exception {
        return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", t().k(), P().c()));
    }

    @Override // org.junit.runners.g, org.junit.runners.f
    protected List<l> p() {
        return this.f40028g;
    }
}
