package h5;

import androidx.constraintlayout.core.motion.utils.w;
import java.lang.annotation.Annotation;
import kotlin.b1;
import kotlin.g1;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.l1;

/* JADX INFO: loaded from: classes2.dex */
@h(name = "JvmClassMappingKt")
public final class a {
    @a7.d
    public static final <T extends Annotation> kotlin.reflect.d<? extends T> a(@a7.d T t7) {
        l0.p(t7, "<this>");
        Class<? extends Annotation> clsAnnotationType = t7.annotationType();
        l0.o(clsAnnotationType, "this as java.lang.annota…otation).annotationType()");
        kotlin.reflect.d<? extends T> dVarI = i(clsAnnotationType);
        l0.n(dVarI, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return dVarI;
    }

    private static final <E extends Enum<E>> Class<E> b(E e8) {
        l0.p(e8, "<this>");
        Class<E> declaringClass = e8.getDeclaringClass();
        l0.o(declaringClass, "this as java.lang.Enum<E>).declaringClass");
        return declaringClass;
    }

    @g1(version = "1.7")
    @kotlin.internal.f
    public static /* synthetic */ void c(Enum r7) {
    }

    @a7.d
    public static final <T> Class<T> d(@a7.d T t7) {
        l0.p(t7, "<this>");
        Class<T> cls = (Class<T>) t7.getClass();
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    @a7.d
    @h(name = "getJavaClass")
    public static final <T> Class<T> e(@a7.d kotlin.reflect.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.t) dVar).s();
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static /* synthetic */ void f(kotlin.reflect.d dVar) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @a7.d
    public static final <T> Class<T> g(@a7.d kotlin.reflect.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.t) dVar).s();
        if (!cls.isPrimitive()) {
            l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    cls = (Class<T>) Integer.class;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                }
                break;
            case 64711720:
                if (name.equals(w.b.f3031f)) {
                    cls = (Class<T>) Boolean.class;
                }
                break;
            case 97526364:
                if (name.equals(w.b.f3028c)) {
                    cls = (Class<T>) Float.class;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                }
                break;
        }
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @a7.e
    public static final <T> Class<T> h(@a7.d kotlin.reflect.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<T> cls = (Class<T>) ((kotlin.jvm.internal.t) dVar).s();
        if (cls.isPrimitive()) {
            l0.n(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.f12428v)) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.f12430x)) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.f12427u)) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.A)) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.f12432z)) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.f12426t)) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.f12429w)) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals(com.alibaba.android.arouter.compiler.utils.a.f12431y)) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    @a7.d
    @h(name = "getKotlinClass")
    public static final <T> kotlin.reflect.d<T> i(@a7.d Class<T> cls) {
        l0.p(cls, "<this>");
        return l1.d(cls);
    }

    @a7.d
    @h(name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<kotlin.reflect.d<T>> j(@a7.d kotlin.reflect.d<T> dVar) {
        l0.p(dVar, "<this>");
        Class<kotlin.reflect.d<T>> cls = (Class<kotlin.reflect.d<T>>) dVar.getClass();
        l0.n(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @kotlin.k(level = kotlin.m.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @b1(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void k(kotlin.reflect.d dVar) {
    }

    public static final /* synthetic */ boolean l(Object[] objArr) {
        l0.p(objArr, "<this>");
        l0.y(4, "T");
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }
}
