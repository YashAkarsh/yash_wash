package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.g0;
import kotlin.g1;
import kotlin.j0;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.m0;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class b0 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35068a;

        static {
            int[] iArr = new int[v.values().length];
            iArr[v.IN.ordinal()] = 1;
            iArr[v.INVARIANT.ordinal()] = 2;
            iArr[v.OUT.ordinal()] = 3;
            f35068a = iArr;
        }
    }

    /* synthetic */ class b extends h0 implements i5.l<Class<?>, Class<?>> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b f35069j = new b();

        b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // i5.l
        /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
        public final Class<?> z(@a7.d Class<?> p7) {
            l0.p(p7, "p0");
            return p7.getComponentType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @kotlin.s
    public static final Type c(s sVar, boolean z7) {
        g gVarC0 = sVar.c0();
        if (gVarC0 instanceof t) {
            return new a0((t) gVarC0);
        }
        if (!(gVarC0 instanceof d)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + sVar);
        }
        d dVar = (d) gVarC0;
        Class clsG = z7 ? h5.a.g(dVar) : h5.a.e(dVar);
        List<u> listD = sVar.d();
        if (listD.isEmpty()) {
            return clsG;
        }
        if (!clsG.isArray()) {
            return e(clsG, listD);
        }
        if (clsG.getComponentType().isPrimitive()) {
            return clsG;
        }
        u uVar = (u) g0.f5(listD);
        if (uVar == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + sVar);
        }
        v vVarA = uVar.a();
        s sVarB = uVar.b();
        int i7 = vVarA == null ? -1 : a.f35068a[vVarA.ordinal()];
        if (i7 == -1 || i7 == 1) {
            return clsG;
        }
        if (i7 != 2 && i7 != 3) {
            throw new j0();
        }
        l0.m(sVarB);
        Type typeD = d(sVarB, false, 1, null);
        return typeD instanceof Class ? clsG : new kotlin.reflect.a(typeD);
    }

    static /* synthetic */ Type d(s sVar, boolean z7, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            z7 = false;
        }
        return c(sVar, z7);
    }

    @kotlin.s
    private static final Type e(Class<?> cls, List<u> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(kotlin.collections.z.Z(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(g((u) it.next()));
            }
            return new x(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(kotlin.collections.z.Z(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(g((u) it2.next()));
            }
            return new x(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeE = e(declaringClass, list.subList(length, list.size()));
        List<u> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(kotlin.collections.z.Z(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(g((u) it3.next()));
        }
        return new x(cls, typeE, arrayList3);
    }

    @a7.d
    public static final Type f(@a7.d s sVar) {
        Type typeN;
        l0.p(sVar, "<this>");
        return (!(sVar instanceof m0) || (typeN = ((m0) sVar).N()) == null) ? d(sVar, false, 1, null) : typeN;
    }

    private static final Type g(u uVar) {
        v vVarH = uVar.h();
        if (vVarH == null) {
            return c0.f35070c.a();
        }
        s sVarG = uVar.g();
        l0.m(sVarG);
        int i7 = a.f35068a[vVarH.ordinal()];
        if (i7 == 1) {
            return new c0(null, c(sVarG, true));
        }
        if (i7 == 2) {
            return c(sVarG, true);
        }
        if (i7 == 3) {
            return new c0(c(sVarG, true), null);
        }
        throw new j0();
    }

    @g1(version = "1.4")
    @kotlin.internal.h
    @kotlin.s
    public static /* synthetic */ void h(s sVar) {
    }

    @kotlin.s
    private static /* synthetic */ void i(u uVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(Type type) {
        String name;
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            kotlin.sequences.m mVarN = kotlin.sequences.s.n(type, b.f35069j);
            name = ((Class) kotlin.sequences.u.f1(mVarN)).getName() + kotlin.text.b0.g2(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, kotlin.sequences.u.g0(mVarN));
        } else {
            name = cls.getName();
        }
        l0.o(name, "{\n        if (type.isArr…   } else type.name\n    }");
        return name;
    }
}
