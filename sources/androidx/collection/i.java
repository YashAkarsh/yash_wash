package androidx.collection;

import c.m0;
import c.o0;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class i<K, V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f2311d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2312e = "ArrayMap";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final boolean f2313f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f2314g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f2315h = 10;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    static Object[] f2316i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static int f2317j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @o0
    static Object[] f2318k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static int f2319l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int[] f2320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f2321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2322c;

    public i() {
        this.f2320a = e.f2280a;
        this.f2321b = e.f2282c;
        this.f2322c = 0;
    }

    private void a(int i7) {
        if (i7 == 8) {
            synchronized (i.class) {
                Object[] objArr = f2318k;
                if (objArr != null) {
                    this.f2321b = objArr;
                    f2318k = (Object[]) objArr[0];
                    this.f2320a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f2319l--;
                    return;
                }
            }
        } else if (i7 == 4) {
            synchronized (i.class) {
                Object[] objArr2 = f2316i;
                if (objArr2 != null) {
                    this.f2321b = objArr2;
                    f2316i = (Object[]) objArr2[0];
                    this.f2320a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f2317j--;
                    return;
                }
            }
        }
        this.f2320a = new int[i7];
        this.f2321b = new Object[i7 << 1];
    }

    private static int b(int[] iArr, int i7, int i8) {
        try {
            return e.a(iArr, i7, i8);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i7) {
        if (iArr.length == 8) {
            synchronized (i.class) {
                if (f2319l < 10) {
                    objArr[0] = f2318k;
                    objArr[1] = iArr;
                    for (int i8 = (i7 << 1) - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f2318k = objArr;
                    f2319l++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (i.class) {
                if (f2317j < 10) {
                    objArr[0] = f2316i;
                    objArr[1] = iArr;
                    for (int i9 = (i7 << 1) - 1; i9 >= 2; i9--) {
                        objArr[i9] = null;
                    }
                    f2316i = objArr;
                    f2317j++;
                }
            }
        }
    }

    public void c(int i7) {
        int i8 = this.f2322c;
        int[] iArr = this.f2320a;
        if (iArr.length < i7) {
            Object[] objArr = this.f2321b;
            a(i7);
            if (this.f2322c > 0) {
                System.arraycopy(iArr, 0, this.f2320a, 0, i8);
                System.arraycopy(objArr, 0, this.f2321b, 0, i8 << 1);
            }
            d(iArr, objArr, i8);
        }
        if (this.f2322c != i8) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i7 = this.f2322c;
        if (i7 > 0) {
            int[] iArr = this.f2320a;
            Object[] objArr = this.f2321b;
            this.f2320a = e.f2280a;
            this.f2321b = e.f2282c;
            this.f2322c = 0;
            d(iArr, objArr, i7);
        }
        if (this.f2322c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@o0 Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    int e(Object obj, int i7) {
        int i8 = this.f2322c;
        if (i8 == 0) {
            return -1;
        }
        int iB = b(this.f2320a, i8, i7);
        if (iB < 0 || obj.equals(this.f2321b[iB << 1])) {
            return iB;
        }
        int i9 = iB + 1;
        while (i9 < i8 && this.f2320a[i9] == i7) {
            if (obj.equals(this.f2321b[i9 << 1])) {
                return i9;
            }
            i9++;
        }
        for (int i10 = iB - 1; i10 >= 0 && this.f2320a[i10] == i7; i10--) {
            if (obj.equals(this.f2321b[i10 << 1])) {
                return i10;
            }
        }
        return ~i9;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (size() != iVar.size()) {
                return false;
            }
            for (int i7 = 0; i7 < this.f2322c; i7++) {
                try {
                    K k7 = k(i7);
                    V vO = o(i7);
                    Object obj2 = iVar.get(k7);
                    if (vO == null) {
                        if (obj2 != null || !iVar.containsKey(k7)) {
                            return false;
                        }
                    } else if (!vO.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i8 = 0; i8 < this.f2322c; i8++) {
                try {
                    K k8 = k(i8);
                    V vO2 = o(i8);
                    Object obj3 = map.get(k8);
                    if (vO2 == null) {
                        if (obj3 != null || !map.containsKey(k8)) {
                            return false;
                        }
                    } else if (!vO2.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(@o0 Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i7 = this.f2322c;
        if (i7 == 0) {
            return -1;
        }
        int iB = b(this.f2320a, i7, 0);
        if (iB < 0 || this.f2321b[iB << 1] == null) {
            return iB;
        }
        int i8 = iB + 1;
        while (i8 < i7 && this.f2320a[i8] == 0) {
            if (this.f2321b[i8 << 1] == null) {
                return i8;
            }
            i8++;
        }
        for (int i9 = iB - 1; i9 >= 0 && this.f2320a[i9] == 0; i9--) {
            if (this.f2321b[i9 << 1] == null) {
                return i9;
            }
        }
        return ~i8;
    }

    @o0
    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v7) {
        int iF = f(obj);
        return iF >= 0 ? (V) this.f2321b[(iF << 1) + 1] : v7;
    }

    public int hashCode() {
        int[] iArr = this.f2320a;
        Object[] objArr = this.f2321b;
        int i7 = this.f2322c;
        int i8 = 1;
        int i9 = 0;
        int iHashCode = 0;
        while (i9 < i7) {
            Object obj = objArr[i8];
            iHashCode += (obj == null ? 0 : obj.hashCode()) ^ iArr[i9];
            i9++;
            i8 += 2;
        }
        return iHashCode;
    }

    int i(Object obj) {
        int i7 = this.f2322c * 2;
        Object[] objArr = this.f2321b;
        if (obj == null) {
            for (int i8 = 1; i8 < i7; i8 += 2) {
                if (objArr[i8] == null) {
                    return i8 >> 1;
                }
            }
            return -1;
        }
        for (int i9 = 1; i9 < i7; i9 += 2) {
            if (obj.equals(objArr[i9])) {
                return i9 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.f2322c <= 0;
    }

    public K k(int i7) {
        return (K) this.f2321b[i7 << 1];
    }

    public void l(@m0 i<? extends K, ? extends V> iVar) {
        int i7 = iVar.f2322c;
        c(this.f2322c + i7);
        if (this.f2322c != 0) {
            for (int i8 = 0; i8 < i7; i8++) {
                put(iVar.k(i8), iVar.o(i8));
            }
        } else if (i7 > 0) {
            System.arraycopy(iVar.f2320a, 0, this.f2320a, 0, i7);
            System.arraycopy(iVar.f2321b, 0, this.f2321b, 0, i7 << 1);
            this.f2322c = i7;
        }
    }

    public V m(int i7) {
        Object[] objArr = this.f2321b;
        int i8 = i7 << 1;
        V v7 = (V) objArr[i8 + 1];
        int i9 = this.f2322c;
        int i10 = 0;
        if (i9 <= 1) {
            d(this.f2320a, objArr, i9);
            this.f2320a = e.f2280a;
            this.f2321b = e.f2282c;
        } else {
            int i11 = i9 - 1;
            int[] iArr = this.f2320a;
            if (iArr.length <= 8 || i9 >= iArr.length / 3) {
                if (i7 < i11) {
                    int i12 = i7 + 1;
                    int i13 = i11 - i7;
                    System.arraycopy(iArr, i12, iArr, i7, i13);
                    Object[] objArr2 = this.f2321b;
                    System.arraycopy(objArr2, i12 << 1, objArr2, i8, i13 << 1);
                }
                Object[] objArr3 = this.f2321b;
                int i14 = i11 << 1;
                objArr3[i14] = null;
                objArr3[i14 + 1] = null;
            } else {
                a(i9 > 8 ? i9 + (i9 >> 1) : 8);
                if (i9 != this.f2322c) {
                    throw new ConcurrentModificationException();
                }
                if (i7 > 0) {
                    System.arraycopy(iArr, 0, this.f2320a, 0, i7);
                    System.arraycopy(objArr, 0, this.f2321b, 0, i8);
                }
                if (i7 < i11) {
                    int i15 = i7 + 1;
                    int i16 = i11 - i7;
                    System.arraycopy(iArr, i15, this.f2320a, i7, i16);
                    System.arraycopy(objArr, i15 << 1, this.f2321b, i8, i16 << 1);
                }
            }
            i10 = i11;
        }
        if (i9 != this.f2322c) {
            throw new ConcurrentModificationException();
        }
        this.f2322c = i10;
        return v7;
    }

    public V n(int i7, V v7) {
        int i8 = (i7 << 1) + 1;
        Object[] objArr = this.f2321b;
        V v8 = (V) objArr[i8];
        objArr[i8] = v7;
        return v8;
    }

    public V o(int i7) {
        return (V) this.f2321b[(i7 << 1) + 1];
    }

    @o0
    public V put(K k7, V v7) {
        int i7;
        int iE;
        int i8 = this.f2322c;
        if (k7 == null) {
            iE = g();
            i7 = 0;
        } else {
            int iHashCode = k7.hashCode();
            i7 = iHashCode;
            iE = e(k7, iHashCode);
        }
        if (iE >= 0) {
            int i9 = (iE << 1) + 1;
            Object[] objArr = this.f2321b;
            V v8 = (V) objArr[i9];
            objArr[i9] = v7;
            return v8;
        }
        int i10 = ~iE;
        int[] iArr = this.f2320a;
        if (i8 >= iArr.length) {
            int i11 = 8;
            if (i8 >= 8) {
                i11 = (i8 >> 1) + i8;
            } else if (i8 < 4) {
                i11 = 4;
            }
            Object[] objArr2 = this.f2321b;
            a(i11);
            if (i8 != this.f2322c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f2320a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f2321b, 0, objArr2.length);
            }
            d(iArr, objArr2, i8);
        }
        if (i10 < i8) {
            int[] iArr3 = this.f2320a;
            int i12 = i10 + 1;
            System.arraycopy(iArr3, i10, iArr3, i12, i8 - i10);
            Object[] objArr3 = this.f2321b;
            System.arraycopy(objArr3, i10 << 1, objArr3, i12 << 1, (this.f2322c - i10) << 1);
        }
        int i13 = this.f2322c;
        if (i8 == i13) {
            int[] iArr4 = this.f2320a;
            if (i10 < iArr4.length) {
                iArr4[i10] = i7;
                Object[] objArr4 = this.f2321b;
                int i14 = i10 << 1;
                objArr4[i14] = k7;
                objArr4[i14 + 1] = v7;
                this.f2322c = i13 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    @o0
    public V putIfAbsent(K k7, V v7) {
        V v8 = get(k7);
        return v8 == null ? put(k7, v7) : v8;
    }

    @o0
    public V remove(Object obj) {
        int iF = f(obj);
        if (iF >= 0) {
            return m(iF);
        }
        return null;
    }

    @o0
    public V replace(K k7, V v7) {
        int iF = f(k7);
        if (iF >= 0) {
            return n(iF, v7);
        }
        return null;
    }

    public int size() {
        return this.f2322c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2322c * 28);
        sb.append('{');
        for (int i7 = 0; i7 < this.f2322c; i7++) {
            if (i7 > 0) {
                sb.append(", ");
            }
            K k7 = k(i7);
            if (k7 != this) {
                sb.append(k7);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V vO = o(i7);
            if (vO != this) {
                sb.append(vO);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean remove(Object obj, Object obj2) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        V vO = o(iF);
        if (obj2 != vO && (obj2 == null || !obj2.equals(vO))) {
            return false;
        }
        m(iF);
        return true;
    }

    public boolean replace(K k7, V v7, V v8) {
        int iF = f(k7);
        if (iF < 0) {
            return false;
        }
        V vO = o(iF);
        if (vO != v7 && (v7 == null || !v7.equals(vO))) {
            return false;
        }
        n(iF, v8);
        return true;
    }

    public i(int i7) {
        if (i7 == 0) {
            this.f2320a = e.f2280a;
            this.f2321b = e.f2282c;
        } else {
            a(i7);
        }
        this.f2322c = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(i<K, V> iVar) {
        this();
        if (iVar != 0) {
            l(iVar);
        }
    }
}
