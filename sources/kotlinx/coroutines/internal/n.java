package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f37001a = f(Throwable.class, -1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @a7.d
    private static final k f37002b;

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t7, T t8) {
            return kotlin.comparisons.b.g(Integer.valueOf(((Constructor) t8).getParameterTypes().length), Integer.valueOf(((Constructor) t7).getParameterTypes().length));
        }
    }

    static final class b extends kotlin.jvm.internal.n0 implements i5.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f37003a = new b();

        b() {
            super(1);
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void z(@a7.d Throwable th) {
            return null;
        }
    }

    public static final class c extends kotlin.jvm.internal.n0 implements i5.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f37004a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Constructor constructor) {
            super(1);
            this.f37004a = constructor;
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable z(@a7.d Throwable th) {
            Object objB;
            try {
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                Object objNewInstance = this.f37004a.newInstance(th.getMessage(), th);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                objB = kotlin.d1.b((Throwable) objNewInstance);
                if (kotlin.d1.i(objB)) {
                    objB = null;
                }
                return (Throwable) objB;
            } catch (Throwable th2) {
                kotlin.d1.a aVar2 = kotlin.d1.f34719b;
                objB = kotlin.d1.b(kotlin.e1.a(th2));
            }
        }
    }

    public static final class d extends kotlin.jvm.internal.n0 implements i5.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f37005a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Constructor constructor) {
            super(1);
            this.f37005a = constructor;
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable z(@a7.d Throwable th) {
            Object objB;
            try {
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                Object objNewInstance = this.f37005a.newInstance(th);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                objB = kotlin.d1.b((Throwable) objNewInstance);
                if (kotlin.d1.i(objB)) {
                    objB = null;
                }
                return (Throwable) objB;
            } catch (Throwable th2) {
                kotlin.d1.a aVar2 = kotlin.d1.f34719b;
                objB = kotlin.d1.b(kotlin.e1.a(th2));
            }
        }
    }

    public static final class e extends kotlin.jvm.internal.n0 implements i5.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f37006a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Constructor constructor) {
            super(1);
            this.f37006a = constructor;
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable z(@a7.d Throwable th) {
            Object objB;
            try {
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                Object objNewInstance = this.f37006a.newInstance(th.getMessage());
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                Throwable th2 = (Throwable) objNewInstance;
                th2.initCause(th);
                objB = kotlin.d1.b(th2);
                if (kotlin.d1.i(objB)) {
                    objB = null;
                }
                return (Throwable) objB;
            } catch (Throwable th3) {
                kotlin.d1.a aVar2 = kotlin.d1.f34719b;
                objB = kotlin.d1.b(kotlin.e1.a(th3));
            }
        }
    }

    public static final class f extends kotlin.jvm.internal.n0 implements i5.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f37007a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Constructor constructor) {
            super(1);
            this.f37007a = constructor;
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable z(@a7.d Throwable th) {
            Object objB;
            try {
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                Object objNewInstance = this.f37007a.newInstance(new Object[0]);
                if (objNewInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                Throwable th2 = (Throwable) objNewInstance;
                th2.initCause(th);
                objB = kotlin.d1.b(th2);
                if (kotlin.d1.i(objB)) {
                    objB = null;
                }
                return (Throwable) objB;
            } catch (Throwable th3) {
                kotlin.d1.a aVar2 = kotlin.d1.f34719b;
                objB = kotlin.d1.b(kotlin.e1.a(th3));
            }
        }
    }

    public static final class g extends kotlin.jvm.internal.n0 implements i5.l<Throwable, Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i5.l<Throwable, Throwable> f37008a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public g(i5.l<? super Throwable, ? extends Throwable> lVar) {
            super(1);
            this.f37008a = lVar;
        }

        @Override // i5.l
        @a7.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Throwable z(@a7.d Throwable th) {
            Object objB;
            i5.l<Throwable, Throwable> lVar = this.f37008a;
            try {
                kotlin.d1.a aVar = kotlin.d1.f34719b;
                objB = kotlin.d1.b(lVar.z(th));
            } catch (Throwable th2) {
                kotlin.d1.a aVar2 = kotlin.d1.f34719b;
                objB = kotlin.d1.b(kotlin.e1.a(th2));
            }
            if (kotlin.d1.i(objB)) {
                objB = null;
            }
            return (Throwable) objB;
        }
    }

    static {
        k kVar;
        try {
            kVar = p.a() ? e1.f36976a : kotlinx.coroutines.internal.e.f36971a;
        } catch (Throwable unused) {
            kVar = e1.f36976a;
        }
        f37002b = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> i5.l<Throwable, Throwable> b(Class<E> cls) {
        b bVar = b.f37003a;
        if (f37001a != f(cls, 0)) {
            return bVar;
        }
        Iterator it = kotlin.collections.p.mw(cls.getConstructors(), new a()).iterator();
        while (it.hasNext()) {
            i5.l<Throwable, Throwable> lVarC = c((Constructor) it.next());
            if (lVarC != null) {
                return lVarC;
            }
        }
        return bVar;
    }

    private static final i5.l<Throwable, Throwable> c(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length == 0) {
            return new f(constructor);
        }
        if (length != 1) {
            if (length == 2 && kotlin.jvm.internal.l0.g(parameterTypes[0], String.class) && kotlin.jvm.internal.l0.g(parameterTypes[1], Throwable.class)) {
                return new c(constructor);
            }
            return null;
        }
        Class<?> cls = parameterTypes[0];
        if (kotlin.jvm.internal.l0.g(cls, Throwable.class)) {
            return new d(constructor);
        }
        if (kotlin.jvm.internal.l0.g(cls, String.class)) {
            return new e(constructor);
        }
        return null;
    }

    private static final int d(Class<?> cls, int i7) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            int length = declaredFields.length;
            int i8 = 0;
            int i9 = 0;
            while (i8 < length) {
                Field field = declaredFields[i8];
                i8++;
                if (!Modifier.isStatic(field.getModifiers())) {
                    i9++;
                }
            }
            i7 += i9;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i7;
    }

    static /* synthetic */ int e(Class cls, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i7 = 0;
        }
        return d(cls, i7);
    }

    private static final int f(Class<?> cls, int i7) {
        Object objB;
        h5.a.i(cls);
        try {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            objB = kotlin.d1.b(Integer.valueOf(e(cls, 0, 1, null)));
        } catch (Throwable th) {
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            objB = kotlin.d1.b(kotlin.e1.a(th));
        }
        Integer numValueOf = Integer.valueOf(i7);
        if (kotlin.d1.i(objB)) {
            objB = numValueOf;
        }
        return ((Number) objB).intValue();
    }

    private static final i5.l<Throwable, Throwable> g(i5.l<? super Throwable, ? extends Throwable> lVar) {
        return new g(lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @a7.e
    public static final <E extends Throwable> E h(@a7.d E e8) {
        Object objB;
        if (!(e8 instanceof kotlinx.coroutines.m0)) {
            return (E) f37002b.a(e8.getClass()).z(e8);
        }
        try {
            kotlin.d1.a aVar = kotlin.d1.f34719b;
            objB = kotlin.d1.b(((kotlinx.coroutines.m0) e8).a());
        } catch (Throwable th) {
            kotlin.d1.a aVar2 = kotlin.d1.f34719b;
            objB = kotlin.d1.b(kotlin.e1.a(th));
        }
        if (kotlin.d1.i(objB)) {
            objB = null;
        }
        return (E) objB;
    }
}
