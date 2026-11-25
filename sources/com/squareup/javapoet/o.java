package com.squareup.javapoet;

import androidx.constraintlayout.core.motion.utils.w;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.SimpleTypeVisitor7;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final o f33371d = new o("void");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final o f33372e = new o(w.b.f3031f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f33373f = new o("byte");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final o f33374g = new o("short");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final o f33375h = new o("int");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final o f33376i = new o("long");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final o f33377j = new o("char");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final o f33378k = new o(w.b.f3028c);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final o f33379l = new o("double");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final c f33380m = c.x("java.lang", "Object", new String[0]);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final c f33381n = c.x("java.lang", "Void", new String[0]);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final c f33382o = c.x("java.lang", "Boolean", new String[0]);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final c f33383p = c.x("java.lang", "Byte", new String[0]);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final c f33384q = c.x("java.lang", "Short", new String[0]);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final c f33385r = c.x("java.lang", "Integer", new String[0]);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final c f33386s = c.x("java.lang", "Long", new String[0]);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final c f33387t = c.x("java.lang", "Character", new String[0]);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final c f33388u = c.x("java.lang", "Float", new String[0]);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final c f33389v = c.x("java.lang", "Double", new String[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.squareup.javapoet.a> f33391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f33392c;

    static class a extends SimpleTypeVisitor7<o, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f33393a;

        a(Map map) {
            this.f33393a = map;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public o b(TypeMirror typeMirror, Void r7) {
            throw new IllegalArgumentException("Unexpected type mirror: " + typeMirror);
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.squareup.javapoet.b d(ArrayType arrayType, Void r7) {
            return com.squareup.javapoet.b.w(arrayType, this.f33393a);
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public o f(DeclaredType declaredType, Void r7) {
            c cVarY = c.y(declaredType.asElement());
            TypeMirror enclosingType = declaredType.getEnclosingType();
            o oVar = (enclosingType.getKind() == TypeKind.NONE || declaredType.asElement().getModifiers().contains(Modifier.STATIC)) ? null : (o) enclosingType.accept(this, (Object) null);
            if (declaredType.getTypeArguments().isEmpty() && !(oVar instanceof n)) {
                return cVarY;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = declaredType.getTypeArguments().iterator();
            while (it.hasNext()) {
                arrayList.add(o.k((TypeMirror) it.next(), this.f33393a));
            }
            return oVar instanceof n ? ((n) oVar).y(cVarY.E(), arrayList) : new n(null, cVarY, arrayList);
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public o h(ErrorType errorType, Void r7) {
            return f(errorType, r7);
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public o j(NoType noType, Void r7) {
            return noType.getKind() == TypeKind.VOID ? o.f33371d : (o) super.visitUnknown(noType, r7);
        }

        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public o l(PrimitiveType primitiveType, Void r7) {
            switch (b.f33394a[primitiveType.getKind().ordinal()]) {
                case 1:
                    return o.f33372e;
                case 2:
                    return o.f33373f;
                case 3:
                    return o.f33374g;
                case 4:
                    return o.f33375h;
                case 5:
                    return o.f33376i;
                case 6:
                    return o.f33377j;
                case 7:
                    return o.f33378k;
                case 8:
                    return o.f33379l;
                default:
                    throw new AssertionError();
            }
        }

        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public o n(TypeVariable typeVariable, Void r7) {
            return q.A(typeVariable, this.f33393a);
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public o p(WildcardType wildcardType, Void r7) {
            return s.w(wildcardType, this.f33393a);
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33394a;

        static {
            int[] iArr = new int[TypeKind.values().length];
            f33394a = iArr;
            try {
                iArr[TypeKind.BOOLEAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33394a[TypeKind.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33394a[TypeKind.SHORT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33394a[TypeKind.INT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33394a[TypeKind.LONG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f33394a[TypeKind.CHAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f33394a[TypeKind.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f33394a[TypeKind.DOUBLE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private o(String str) {
        this(str, new ArrayList());
    }

    static o c(o oVar) {
        if (oVar instanceof com.squareup.javapoet.b) {
            return ((com.squareup.javapoet.b) oVar).f33284w;
        }
        return null;
    }

    public static o h(Type type) {
        return i(type, new LinkedHashMap());
    }

    static o i(Type type, Map<Type, q> map) {
        if (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                return n.w((ParameterizedType) type, map);
            }
            if (type instanceof java.lang.reflect.WildcardType) {
                return s.u((java.lang.reflect.WildcardType) type, map);
            }
            if (type instanceof java.lang.reflect.TypeVariable) {
                return q.x((java.lang.reflect.TypeVariable) type, map);
            }
            if (type instanceof GenericArrayType) {
                return com.squareup.javapoet.b.u((GenericArrayType) type, map);
            }
            throw new IllegalArgumentException("unexpected type: " + type);
        }
        Class cls = (Class) type;
        if (type == Void.TYPE) {
            return f33371d;
        }
        if (type == Boolean.TYPE) {
            return f33372e;
        }
        if (type == Byte.TYPE) {
            return f33373f;
        }
        if (type == Short.TYPE) {
            return f33374g;
        }
        if (type == Integer.TYPE) {
            return f33375h;
        }
        if (type == Long.TYPE) {
            return f33376i;
        }
        if (type == Character.TYPE) {
            return f33377j;
        }
        if (type == Float.TYPE) {
            return f33378k;
        }
        if (type == Double.TYPE) {
            return f33379l;
        }
        return cls.isArray() ? com.squareup.javapoet.b.x(i(cls.getComponentType(), map)) : c.w(cls);
    }

    public static o j(TypeMirror typeMirror) {
        return k(typeMirror, new LinkedHashMap());
    }

    static o k(TypeMirror typeMirror, Map<TypeParameterElement, q> map) {
        return (o) typeMirror.accept(new a(map), (Object) null);
    }

    static List<o> o(Type[] typeArr) {
        return p(typeArr, new LinkedHashMap());
    }

    static List<o> p(Type[] typeArr, Map<Type, q> map) {
        ArrayList arrayList = new ArrayList(typeArr.length);
        for (Type type : typeArr) {
            arrayList.add(i(type, map));
        }
        return arrayList;
    }

    public o a(List<com.squareup.javapoet.a> list) {
        r.c(list, "annotations == null", new Object[0]);
        return new o(this.f33390a, e(list));
    }

    public final o b(com.squareup.javapoet.a... aVarArr) {
        return a(Arrays.asList(aVarArr));
    }

    public o d() {
        if (this.f33390a == null) {
            return this;
        }
        if (this == f33371d) {
            return f33381n;
        }
        if (this == f33372e) {
            return f33382o;
        }
        if (this == f33373f) {
            return f33383p;
        }
        if (this == f33374g) {
            return f33384q;
        }
        if (this == f33375h) {
            return f33385r;
        }
        if (this == f33376i) {
            return f33386s;
        }
        if (this == f33377j) {
            return f33387t;
        }
        if (this == f33378k) {
            return f33388u;
        }
        if (this == f33379l) {
            return f33389v;
        }
        throw new AssertionError(this.f33390a);
    }

    protected final List<com.squareup.javapoet.a> e(List<com.squareup.javapoet.a> list) {
        ArrayList arrayList = new ArrayList(this.f33391b);
        arrayList.addAll(list);
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    e f(e eVar) throws IOException {
        String str = this.f33390a;
        if (str != null) {
            return eVar.d(str);
        }
        throw new AssertionError();
    }

    e g(e eVar) throws IOException {
        Iterator<com.squareup.javapoet.a> it = this.f33391b.iterator();
        while (it.hasNext()) {
            it.next().c(eVar, true);
            eVar.b(" ");
        }
        return eVar;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public boolean l() {
        return !this.f33391b.isEmpty();
    }

    public boolean m() {
        return equals(f33382o) || equals(f33383p) || equals(f33384q) || equals(f33385r) || equals(f33386s) || equals(f33387t) || equals(f33388u) || equals(f33389v);
    }

    public boolean n() {
        return (this.f33390a == null || this == f33371d) ? false : true;
    }

    public o q() {
        if (this.f33390a != null) {
            return this;
        }
        if (equals(f33381n)) {
            return f33371d;
        }
        if (equals(f33382o)) {
            return f33372e;
        }
        if (equals(f33383p)) {
            return f33373f;
        }
        if (equals(f33384q)) {
            return f33374g;
        }
        if (equals(f33385r)) {
            return f33375h;
        }
        if (equals(f33386s)) {
            return f33376i;
        }
        if (equals(f33387t)) {
            return f33377j;
        }
        if (equals(f33388u)) {
            return f33378k;
        }
        if (equals(f33389v)) {
            return f33379l;
        }
        throw new UnsupportedOperationException("cannot unbox " + this);
    }

    public o r() {
        return new o(this.f33390a);
    }

    public final String toString() {
        String str = this.f33392c;
        if (str != null) {
            return str;
        }
        try {
            StringBuilder sb = new StringBuilder();
            e eVar = new e(sb);
            g(eVar);
            f(eVar);
            String string = sb.toString();
            this.f33392c = string;
            return string;
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private o(String str, List<com.squareup.javapoet.a> list) {
        this.f33390a = str;
        this.f33391b = r.f(list);
    }

    o(List<com.squareup.javapoet.a> list) {
        this(null, list);
    }
}
