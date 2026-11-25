package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@h5.h(name = "CollectionToArray")
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @a7.d
    private static final Object[] f34936a = new Object[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f34937b = 2147483645;

    @a7.d
    @h5.h(name = "toArray")
    public static final Object[] a(@a7.d Collection<?> collection) {
        l0.p(collection, "collection");
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it = collection.iterator();
            if (it.hasNext()) {
                Object[] objArrCopyOf = new Object[size];
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    objArrCopyOf[i7] = it.next();
                    if (i8 >= objArrCopyOf.length) {
                        if (!it.hasNext()) {
                            return objArrCopyOf;
                        }
                        int i9 = ((i8 * 3) + 1) >>> 1;
                        if (i9 <= i8) {
                            i9 = f34937b;
                            if (i8 >= f34937b) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArrCopyOf = Arrays.copyOf(objArrCopyOf, i9);
                        l0.o(objArrCopyOf, "copyOf(result, newSize)");
                    } else if (!it.hasNext()) {
                        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i8);
                        l0.o(objArrCopyOf2, "copyOf(result, size)");
                        return objArrCopyOf2;
                    }
                    i7 = i8;
                }
            }
        }
        return f34936a;
    }

    @a7.d
    @h5.h(name = "toArray")
    public static final Object[] b(@a7.d Collection<?> collection, @a7.e Object[] objArr) {
        Object[] objArrCopyOf;
        l0.p(collection, "collection");
        objArr.getClass();
        int size = collection.size();
        int i7 = 0;
        if (size == 0) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            if (objArr.length <= 0) {
                return objArr;
            }
            objArr[0] = null;
            return objArr;
        }
        if (size <= objArr.length) {
            objArrCopyOf = objArr;
        } else {
            Object objNewInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
            l0.n(objNewInstance, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf = (Object[]) objNewInstance;
        }
        while (true) {
            int i8 = i7 + 1;
            objArrCopyOf[i7] = it.next();
            if (i8 >= objArrCopyOf.length) {
                if (!it.hasNext()) {
                    return objArrCopyOf;
                }
                int i9 = ((i8 * 3) + 1) >>> 1;
                if (i9 <= i8) {
                    i9 = f34937b;
                    if (i8 >= f34937b) {
                        throw new OutOfMemoryError();
                    }
                }
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i9);
                l0.o(objArrCopyOf, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                if (objArrCopyOf == objArr) {
                    objArr[i8] = null;
                    return objArr;
                }
                Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, i8);
                l0.o(objArrCopyOf2, "copyOf(result, size)");
                return objArrCopyOf2;
            }
            i7 = i8;
        }
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private static final Object[] c(Collection<?> collection, i5.a<Object[]> aVar, i5.l<? super Integer, Object[]> lVar, i5.p<? super Object[], ? super Integer, Object[]> pVar) {
        int size = collection.size();
        if (size == 0) {
            return aVar.invoke();
        }
        Iterator<?> it = collection.iterator();
        if (!it.hasNext()) {
            return aVar.invoke();
        }
        Object[] objArrZ = lVar.z(Integer.valueOf(size));
        int i7 = 0;
        ?? CopyOf = objArrZ;
        while (true) {
            int i8 = i7 + 1;
            CopyOf[i7] = it.next();
            if (i8 >= CopyOf.length) {
                if (!it.hasNext()) {
                    return CopyOf;
                }
                int i9 = ((i8 * 3) + 1) >>> 1;
                if (i9 <= i8) {
                    i9 = f34937b;
                    if (i8 >= f34937b) {
                        throw new OutOfMemoryError();
                    }
                }
                CopyOf = Arrays.copyOf((Object[]) CopyOf, i9);
                l0.o(CopyOf, "copyOf(result, newSize)");
            } else if (!it.hasNext()) {
                return pVar.a0(CopyOf, Integer.valueOf(i8));
            }
            i7 = i8;
            CopyOf = CopyOf;
        }
    }
}
