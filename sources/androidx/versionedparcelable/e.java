package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import c.m0;
import c.t0;
import c.x0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP_PREFIX})
public abstract class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f11011d = "VersionedParcel";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f11012e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f11013f = -2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f11014g = -3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f11015h = -4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f11016i = -5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f11017j = -6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f11018k = -7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f11019l = -9;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f11020m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f11021n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f11022o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f11023p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final int f11024q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final int f11025r = 7;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final int f11026s = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f11027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final androidx.collection.a<String, Method> f11028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final androidx.collection.a<String, Class> f11029c;

    class a extends ObjectInputStream {
        a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        protected Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    public static class b extends RuntimeException {
        public b(Throwable th) {
            super(th);
        }
    }

    public e(androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        this.f11027a = aVar;
        this.f11028b = aVar2;
        this.f11029c = aVar3;
    }

    private <T> void A0(Collection<T> collection) {
        if (collection == null) {
            L0(-1);
        }
        int size = collection.size();
        L0(size);
        if (size > 0) {
            int iG = g(collection.iterator().next());
            L0(iG);
            switch (iG) {
                case 1:
                    Iterator<T> it = collection.iterator();
                    while (it.hasNext()) {
                        l1((h) it.next());
                    }
                    break;
                case 2:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        W0((Parcelable) it2.next());
                    }
                    break;
                case 3:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        Y0((Serializable) it3.next());
                    }
                    break;
                case 4:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        e1((String) it4.next());
                    }
                    break;
                case 5:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        g1((IBinder) it5.next());
                    }
                    break;
                case 7:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        L0(((Integer) it6.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        H0(((Float) it7.next()).floatValue());
                    }
                    break;
            }
        }
    }

    private <T> void B0(Collection<T> collection, int i7) {
        i0(i7);
        A0(collection);
    }

    private Exception C(int i7, String str) {
        return b(i7, str);
    }

    private int E() {
        return L();
    }

    private void Y0(Serializable serializable) {
        if (serializable == null) {
            e1(null);
            return;
        }
        String name = serializable.getClass().getName();
        e1(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            t0(byteArrayOutputStream.toByteArray());
        } catch (IOException e8) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ")", e8);
        }
    }

    private Exception b(int i7, String str) {
        switch (i7) {
            case -9:
                return (Exception) V();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i7 + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    private Class d(Class<? extends h> cls) throws ClassNotFoundException {
        Class cls2 = this.f11029c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f11029c.put(cls.getName(), cls3);
        return cls3;
    }

    private Method e(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f11027a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, e.class.getClassLoader()).getDeclaredMethod("read", e.class);
        this.f11027a.put(str, declaredMethod);
        return declaredMethod;
    }

    @m0
    protected static Throwable f(@m0 Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    private <T> int g(T t7) {
        if (t7 instanceof String) {
            return 4;
        }
        if (t7 instanceof Parcelable) {
            return 2;
        }
        if (t7 instanceof h) {
            return 1;
        }
        if (t7 instanceof Serializable) {
            return 3;
        }
        if (t7 instanceof IBinder) {
            return 5;
        }
        if (t7 instanceof Integer) {
            return 7;
        }
        if (t7 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t7.getClass().getName() + " cannot be VersionedParcelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method h(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f11028b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsD = d(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsD.getDeclaredMethod("write", cls, e.class);
        this.f11028b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void n1(h hVar) {
        try {
            e1(d(hVar.getClass()).getName());
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException(hVar.getClass().getSimpleName() + " does not have a Parcelizer", e8);
        }
    }

    private <T, S extends Collection<T>> S x(S s7) {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        if (iL != 0) {
            int iL2 = L();
            if (iL < 0) {
                return null;
            }
            if (iL2 == 1) {
                while (iL > 0) {
                    s7.add(g0());
                    iL--;
                }
            } else if (iL2 == 2) {
                while (iL > 0) {
                    s7.add(V());
                    iL--;
                }
            } else if (iL2 == 3) {
                while (iL > 0) {
                    s7.add(X());
                    iL--;
                }
            } else if (iL2 == 4) {
                while (iL > 0) {
                    s7.add(c0());
                    iL--;
                }
            } else if (iL2 == 5) {
                while (iL > 0) {
                    s7.add(e0());
                    iL--;
                }
            }
        }
        return s7;
    }

    protected double[] A() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        double[] dArr = new double[iL];
        for (int i7 = 0; i7 < iL; i7++) {
            dArr[i7] = y();
        }
        return dArr;
    }

    public double[] B(double[] dArr, int i7) {
        return !F(i7) ? dArr : A();
    }

    protected abstract void C0(double d8);

    public Exception D(Exception exc, int i7) {
        int iE;
        return (F(i7) && (iE = E()) != 0) ? C(iE, c0()) : exc;
    }

    public void D0(double d8, int i7) {
        i0(i7);
        C0(d8);
    }

    protected void E0(double[] dArr) {
        if (dArr == null) {
            L0(-1);
            return;
        }
        L0(dArr.length);
        for (double d8 : dArr) {
            C0(d8);
        }
    }

    protected abstract boolean F(int i7);

    public void F0(double[] dArr, int i7) {
        i0(i7);
        E0(dArr);
    }

    protected abstract float G();

    /* JADX WARN: Multi-variable type inference failed */
    public void G0(Exception exc, int i7) {
        int i8;
        i0(i7);
        if (exc == 0) {
            V0();
            return;
        }
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i8 = -9;
        } else if (exc instanceof SecurityException) {
            i8 = -1;
        } else if (exc instanceof BadParcelableException) {
            i8 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i8 = -3;
        } else if (exc instanceof NullPointerException) {
            i8 = -4;
        } else if (exc instanceof IllegalStateException) {
            i8 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i8 = -6;
        } else {
            i8 = exc instanceof UnsupportedOperationException ? -7 : 0;
        }
        L0(i8);
        if (i8 == 0) {
            if (!(exc instanceof RuntimeException)) {
                throw new RuntimeException(exc);
            }
            throw ((RuntimeException) exc);
        }
        e1(exc.getMessage());
        if (i8 != -9) {
            return;
        }
        W0((Parcelable) exc);
    }

    public float H(float f8, int i7) {
        return !F(i7) ? f8 : G();
    }

    protected abstract void H0(float f8);

    protected float[] I() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        float[] fArr = new float[iL];
        for (int i7 = 0; i7 < iL; i7++) {
            fArr[i7] = G();
        }
        return fArr;
    }

    public void I0(float f8, int i7) {
        i0(i7);
        H0(f8);
    }

    public float[] J(float[] fArr, int i7) {
        return !F(i7) ? fArr : I();
    }

    protected void J0(float[] fArr) {
        if (fArr == null) {
            L0(-1);
            return;
        }
        L0(fArr.length);
        for (float f8 : fArr) {
            H0(f8);
        }
    }

    protected <T extends h> T K(String str, e eVar) {
        try {
            return (T) e(str).invoke(null, eVar);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e9);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (e11.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e11.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
        }
    }

    public void K0(float[] fArr, int i7) {
        i0(i7);
        J0(fArr);
    }

    protected abstract int L();

    protected abstract void L0(int i7);

    public int M(int i7, int i8) {
        return !F(i8) ? i7 : L();
    }

    public void M0(int i7, int i8) {
        i0(i8);
        L0(i7);
    }

    protected int[] N() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        int[] iArr = new int[iL];
        for (int i7 = 0; i7 < iL; i7++) {
            iArr[i7] = L();
        }
        return iArr;
    }

    protected void N0(int[] iArr) {
        if (iArr == null) {
            L0(-1);
            return;
        }
        L0(iArr.length);
        for (int i7 : iArr) {
            L0(i7);
        }
    }

    public int[] O(int[] iArr, int i7) {
        return !F(i7) ? iArr : N();
    }

    public void O0(int[] iArr, int i7) {
        i0(i7);
        N0(iArr);
    }

    public <T> List<T> P(List<T> list, int i7) {
        return !F(i7) ? list : (List) x(new ArrayList());
    }

    public <T> void P0(List<T> list, int i7) {
        B0(list, i7);
    }

    protected abstract long Q();

    protected abstract void Q0(long j7);

    public long R(long j7, int i7) {
        return !F(i7) ? j7 : Q();
    }

    public void R0(long j7, int i7) {
        i0(i7);
        Q0(j7);
    }

    protected long[] S() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        long[] jArr = new long[iL];
        for (int i7 = 0; i7 < iL; i7++) {
            jArr[i7] = Q();
        }
        return jArr;
    }

    protected void S0(long[] jArr) {
        if (jArr == null) {
            L0(-1);
            return;
        }
        L0(jArr.length);
        for (long j7 : jArr) {
            Q0(j7);
        }
    }

    public long[] T(long[] jArr, int i7) {
        return !F(i7) ? jArr : S();
    }

    public void T0(long[] jArr, int i7) {
        i0(i7);
        S0(jArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> U(Map<K, V> map, int i7) {
        if (!F(i7)) {
            return map;
        }
        int iL = L();
        if (iL < 0) {
            return null;
        }
        androidx.collection.a aVar = new androidx.collection.a();
        if (iL == 0) {
            return aVar;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        x(arrayList);
        x(arrayList2);
        for (int i8 = 0; i8 < iL; i8++) {
            aVar.put(arrayList.get(i8), arrayList2.get(i8));
        }
        return aVar;
    }

    public <K, V> void U0(Map<K, V> map, int i7) {
        i0(i7);
        if (map == null) {
            L0(-1);
            return;
        }
        int size = map.size();
        L0(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        A0(arrayList);
        A0(arrayList2);
    }

    protected abstract <T extends Parcelable> T V();

    protected void V0() {
        L0(0);
    }

    public <T extends Parcelable> T W(T t7, int i7) {
        return !F(i7) ? t7 : (T) V();
    }

    protected abstract void W0(Parcelable parcelable);

    protected Serializable X() {
        String strC0 = c0();
        if (strC0 == null) {
            return null;
        }
        try {
            return (Serializable) new a(new ByteArrayInputStream(s())).readObject();
        } catch (IOException e8) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + strC0 + ")", e8);
        } catch (ClassNotFoundException e9) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + strC0 + ")", e9);
        }
    }

    public void X0(Parcelable parcelable, int i7) {
        i0(i7);
        W0(parcelable);
    }

    public <T> Set<T> Y(Set<T> set, int i7) {
        return !F(i7) ? set : (Set) x(new androidx.collection.b());
    }

    @t0(api = 21)
    public Size Z(Size size, int i7) {
        if (!F(i7)) {
            return size;
        }
        if (l()) {
            return new Size(L(), L());
        }
        return null;
    }

    public void Z0(Serializable serializable, int i7) {
        i0(i7);
        Y0(serializable);
    }

    protected abstract void a();

    @t0(api = 21)
    public SizeF a0(SizeF sizeF, int i7) {
        if (!F(i7)) {
            return sizeF;
        }
        if (l()) {
            return new SizeF(G(), G());
        }
        return null;
    }

    public <T> void a1(Set<T> set, int i7) {
        B0(set, i7);
    }

    public SparseBooleanArray b0(SparseBooleanArray sparseBooleanArray, int i7) {
        if (!F(i7)) {
            return sparseBooleanArray;
        }
        int iL = L();
        if (iL < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(iL);
        for (int i8 = 0; i8 < iL; i8++) {
            sparseBooleanArray2.put(L(), l());
        }
        return sparseBooleanArray2;
    }

    @t0(api = 21)
    public void b1(Size size, int i7) {
        i0(i7);
        m0(size != null);
        if (size != null) {
            L0(size.getWidth());
            L0(size.getHeight());
        }
    }

    protected abstract e c();

    protected abstract String c0();

    @t0(api = 21)
    public void c1(SizeF sizeF, int i7) {
        i0(i7);
        m0(sizeF != null);
        if (sizeF != null) {
            H0(sizeF.getWidth());
            H0(sizeF.getHeight());
        }
    }

    public String d0(String str, int i7) {
        return !F(i7) ? str : c0();
    }

    public void d1(SparseBooleanArray sparseBooleanArray, int i7) {
        i0(i7);
        if (sparseBooleanArray == null) {
            L0(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        L0(size);
        for (int i8 = 0; i8 < size; i8++) {
            L0(sparseBooleanArray.keyAt(i8));
            m0(sparseBooleanArray.valueAt(i8));
        }
    }

    protected abstract IBinder e0();

    protected abstract void e1(String str);

    public IBinder f0(IBinder iBinder, int i7) {
        return !F(i7) ? iBinder : e0();
    }

    public void f1(String str, int i7) {
        i0(i7);
        e1(str);
    }

    protected <T extends h> T g0() {
        String strC0 = c0();
        if (strC0 == null) {
            return null;
        }
        return (T) K(strC0, c());
    }

    protected abstract void g1(IBinder iBinder);

    public <T extends h> T h0(T t7, int i7) {
        return !F(i7) ? t7 : (T) g0();
    }

    public void h1(IBinder iBinder, int i7) {
        i0(i7);
        g1(iBinder);
    }

    public boolean i() {
        return false;
    }

    protected abstract void i0(int i7);

    protected abstract void i1(IInterface iInterface);

    protected <T> T[] j(T[] tArr) {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iL);
        if (iL != 0) {
            int iL2 = L();
            if (iL < 0) {
                return null;
            }
            if (iL2 == 1) {
                while (iL > 0) {
                    arrayList.add(g0());
                    iL--;
                }
            } else if (iL2 == 2) {
                while (iL > 0) {
                    arrayList.add(V());
                    iL--;
                }
            } else if (iL2 == 3) {
                while (iL > 0) {
                    arrayList.add(X());
                    iL--;
                }
            } else if (iL2 == 4) {
                while (iL > 0) {
                    arrayList.add(c0());
                    iL--;
                }
            } else if (iL2 == 5) {
                while (iL > 0) {
                    arrayList.add(e0());
                    iL--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public void j0(boolean z7, boolean z8) {
    }

    public void j1(IInterface iInterface, int i7) {
        i0(i7);
        i1(iInterface);
    }

    public <T> T[] k(T[] tArr, int i7) {
        return !F(i7) ? tArr : (T[]) j(tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T> void k0(T[] tArr) {
        if (tArr == 0) {
            L0(-1);
            return;
        }
        int length = tArr.length;
        L0(length);
        if (length > 0) {
            int i7 = 0;
            int iG = g(tArr[0]);
            L0(iG);
            if (iG == 1) {
                while (i7 < length) {
                    l1((h) tArr[i7]);
                    i7++;
                }
                return;
            }
            if (iG == 2) {
                while (i7 < length) {
                    W0((Parcelable) tArr[i7]);
                    i7++;
                }
                return;
            }
            if (iG == 3) {
                while (i7 < length) {
                    Y0((Serializable) tArr[i7]);
                    i7++;
                }
            } else if (iG == 4) {
                while (i7 < length) {
                    e1((String) tArr[i7]);
                    i7++;
                }
            } else {
                if (iG != 5) {
                    return;
                }
                while (i7 < length) {
                    g1((IBinder) tArr[i7]);
                    i7++;
                }
            }
        }
    }

    protected <T extends h> void k1(T t7, e eVar) {
        try {
            h(t7.getClass()).invoke(null, t7, eVar);
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e8);
        } catch (IllegalAccessException e9) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e9);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e10);
        } catch (InvocationTargetException e11) {
            if (!(e11.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e11);
            }
            throw ((RuntimeException) e11.getCause());
        }
    }

    protected abstract boolean l();

    public <T> void l0(T[] tArr, int i7) {
        i0(i7);
        k0(tArr);
    }

    protected void l1(h hVar) {
        if (hVar == null) {
            e1(null);
            return;
        }
        n1(hVar);
        e eVarC = c();
        k1(hVar, eVarC);
        eVarC.a();
    }

    public boolean m(boolean z7, int i7) {
        return !F(i7) ? z7 : l();
    }

    protected abstract void m0(boolean z7);

    public void m1(h hVar, int i7) {
        i0(i7);
        l1(hVar);
    }

    protected boolean[] n() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        boolean[] zArr = new boolean[iL];
        for (int i7 = 0; i7 < iL; i7++) {
            zArr[i7] = L() != 0;
        }
        return zArr;
    }

    public void n0(boolean z7, int i7) {
        i0(i7);
        m0(z7);
    }

    public boolean[] o(boolean[] zArr, int i7) {
        return !F(i7) ? zArr : n();
    }

    protected void o0(boolean[] zArr) {
        if (zArr == null) {
            L0(-1);
            return;
        }
        L0(zArr.length);
        for (boolean z7 : zArr) {
            L0(z7 ? 1 : 0);
        }
    }

    protected abstract Bundle p();

    public void p0(boolean[] zArr, int i7) {
        i0(i7);
        o0(zArr);
    }

    public Bundle q(Bundle bundle, int i7) {
        return !F(i7) ? bundle : p();
    }

    protected abstract void q0(Bundle bundle);

    public byte r(byte b8, int i7) {
        return !F(i7) ? b8 : (byte) (L() & 255);
    }

    public void r0(Bundle bundle, int i7) {
        i0(i7);
        q0(bundle);
    }

    protected abstract byte[] s();

    public void s0(byte b8, int i7) {
        i0(i7);
        L0(b8);
    }

    public byte[] t(byte[] bArr, int i7) {
        return !F(i7) ? bArr : s();
    }

    protected abstract void t0(byte[] bArr);

    public char[] u(char[] cArr, int i7) {
        if (!F(i7)) {
            return cArr;
        }
        int iL = L();
        if (iL < 0) {
            return null;
        }
        char[] cArr2 = new char[iL];
        for (int i8 = 0; i8 < iL; i8++) {
            cArr2[i8] = (char) L();
        }
        return cArr2;
    }

    public void u0(byte[] bArr, int i7) {
        i0(i7);
        t0(bArr);
    }

    protected abstract CharSequence v();

    protected abstract void v0(byte[] bArr, int i7, int i8);

    public CharSequence w(CharSequence charSequence, int i7) {
        return !F(i7) ? charSequence : v();
    }

    public void w0(byte[] bArr, int i7, int i8, int i9) {
        i0(i9);
        v0(bArr, i7, i8);
    }

    public void x0(char[] cArr, int i7) {
        i0(i7);
        if (cArr == null) {
            L0(-1);
            return;
        }
        L0(cArr.length);
        for (char c8 : cArr) {
            L0(c8);
        }
    }

    protected abstract double y();

    protected abstract void y0(CharSequence charSequence);

    public double z(double d8, int i7) {
        return !F(i7) ? d8 : y();
    }

    public void z0(CharSequence charSequence, int i7) {
        i0(i7);
        y0(charSequence);
    }
}
