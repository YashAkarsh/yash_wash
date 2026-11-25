package org.junit.runners.parameterized;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.model.e;
import org.junit.runners.model.j;

/* JADX INFO: loaded from: classes3.dex */
public class a extends org.junit.runners.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object[] f40062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f40063h;

    public a(d dVar) throws e {
        super(dVar.c().j());
        this.f40062g = dVar.b().toArray(new Object[dVar.b().size()]);
        this.f40063h = dVar.a();
    }

    private Object k0() throws Exception {
        return t().l().newInstance(this.f40062g);
    }

    private Object l0() throws Exception {
        List<org.junit.runners.model.b> listN0 = n0();
        if (listN0.size() != this.f40062g.length) {
            throw new Exception("Wrong number of parameters and @Parameter fields. @Parameter fields counted: " + listN0.size() + ", available parameters: " + this.f40062g.length + com.alibaba.android.arouter.utils.b.f12515h);
        }
        Object objNewInstance = t().j().newInstance();
        Iterator<org.junit.runners.model.b> it = listN0.iterator();
        while (it.hasNext()) {
            Field fieldJ = it.next().j();
            int iValue = ((org.junit.runners.e.a) fieldJ.getAnnotation(org.junit.runners.e.a.class)).value();
            try {
                fieldJ.set(objNewInstance, this.f40062g[iValue]);
            } catch (IllegalArgumentException e8) {
                throw new Exception(t().k() + ": Trying to set " + fieldJ.getName() + " with the value " + this.f40062g[iValue] + " that is not the right type (" + this.f40062g[iValue].getClass().getSimpleName() + " instead of " + fieldJ.getType().getSimpleName() + ").", e8);
            }
        }
        return objNewInstance;
    }

    private boolean m0() {
        return !n0().isEmpty();
    }

    private List<org.junit.runners.model.b> n0() {
        return t().e(org.junit.runners.e.a.class);
    }

    @Override // org.junit.runners.b
    public Object H() throws Exception {
        return m0() ? l0() : k0();
    }

    @Override // org.junit.runners.b
    protected String V(org.junit.runners.model.d dVar) {
        return dVar.c() + r();
    }

    @Override // org.junit.runners.b
    protected void W(List<Throwable> list) {
        b0(list);
        if (m0()) {
            d0(list);
        }
    }

    @Override // org.junit.runners.b
    protected void X(List<Throwable> list) {
        super.X(list);
        if (m0()) {
            List<org.junit.runners.model.b> listN0 = n0();
            int size = listN0.size();
            int[] iArr = new int[size];
            Iterator<org.junit.runners.model.b> it = listN0.iterator();
            while (it.hasNext()) {
                int iValue = ((org.junit.runners.e.a) it.next().j().getAnnotation(org.junit.runners.e.a.class)).value();
                if (iValue < 0 || iValue > listN0.size() - 1) {
                    list.add(new Exception("Invalid @Parameter value: " + iValue + ". @Parameter fields counted: " + listN0.size() + ". Please use an index between 0 and " + (listN0.size() - 1) + com.alibaba.android.arouter.utils.b.f12515h));
                } else {
                    iArr[iValue] = iArr[iValue] + 1;
                }
            }
            for (int i7 = 0; i7 < size; i7++) {
                int i8 = iArr[i7];
                if (i8 == 0) {
                    list.add(new Exception("@Parameter(" + i7 + ") is never used."));
                } else if (i8 > 1) {
                    list.add(new Exception("@Parameter(" + i7 + ") is used more than once (" + i8 + ")."));
                }
            }
        }
    }

    @Override // org.junit.runners.f
    protected j j(org.junit.runner.notification.c cVar) {
        return i(cVar);
    }

    @Override // org.junit.runners.f
    protected String r() {
        return this.f40063h;
    }

    @Override // org.junit.runners.f
    protected Annotation[] s() {
        return new Annotation[0];
    }
}
