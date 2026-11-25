package com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.SimpleAnnotationValueVisitor7;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f33279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<d>> f33280b;

    /* JADX INFO: renamed from: com.squareup.javapoet.a$a, reason: collision with other inner class name */
    static class C0403a implements Comparator<Method> {
        C0403a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Method method, Method method2) {
            return method.getName().compareTo(method2.getName());
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f33281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<String, List<d>> f33282b;

        /* synthetic */ b(o oVar, C0403a c0403a) {
            this(oVar);
        }

        public b c(String str, d dVar) {
            List<d> arrayList = this.f33282b.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f33282b.put(str, arrayList);
            }
            arrayList.add(dVar);
            return this;
        }

        public b d(String str, String str2, Object... objArr) {
            return c(str, d.c(str2, objArr));
        }

        b e(String str, Object obj) {
            r.c(str, "memberName == null", new Object[0]);
            r.c(obj, "value == null, constant non-null value expected for %s", str);
            if (obj instanceof Class) {
                return d(str, "$T.class", obj);
            }
            if (obj instanceof Enum) {
                return d(str, "$T.$L", obj.getClass(), ((Enum) obj).name());
            }
            if (obj instanceof String) {
                return d(str, "$S", obj);
            }
            if (obj instanceof Float) {
                return d(str, "$Lf", obj);
            }
            return obj instanceof Character ? d(str, "'$L'", r.a(((Character) obj).charValue())) : d(str, "$L", obj);
        }

        public a f() {
            return new a(this, null);
        }

        private b(o oVar) {
            this.f33282b = new LinkedHashMap();
            this.f33281a = oVar;
        }
    }

    private static class c extends SimpleAnnotationValueVisitor7<b, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f33283a;

        c(b bVar) {
            super(bVar);
            this.f33283a = bVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public b b(Object obj, String str) {
            return this.f33283a.e(str, obj);
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public b d(AnnotationMirror annotationMirror, String str) {
            return this.f33283a.d(str, "$L", a.g(annotationMirror));
        }

        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b f(List<? extends AnnotationValue> list, String str) {
            Iterator<? extends AnnotationValue> it = list.iterator();
            while (it.hasNext()) {
                it.next().accept(this, str);
            }
            return this.f33283a;
        }

        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b h(VariableElement variableElement, String str) {
            return this.f33283a.d(str, "$T.$L", variableElement.asType(), variableElement.getSimpleName());
        }

        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b j(TypeMirror typeMirror, String str) {
            return this.f33283a.d(str, "$T.class", typeMirror);
        }
    }

    /* synthetic */ a(b bVar, C0403a c0403a) {
        this(bVar);
    }

    public static b a(com.squareup.javapoet.c cVar) {
        r.c(cVar, "type == null", new Object[0]);
        return new b(cVar, null);
    }

    public static b b(Class<?> cls) {
        return a(com.squareup.javapoet.c.w(cls));
    }

    private void d(e eVar, String str, String str2, List<d> list) throws IOException {
        boolean z7 = true;
        if (list.size() == 1) {
            eVar.r(2);
            eVar.a(list.get(0));
            eVar.B(2);
            return;
        }
        eVar.b("{" + str);
        eVar.r(2);
        for (d dVar : list) {
            if (!z7) {
                eVar.b(str2);
            }
            eVar.a(dVar);
            z7 = false;
        }
        eVar.B(2);
        eVar.b(str + com.alipay.sdk.util.j.f13808d);
    }

    public static a e(Annotation annotation) {
        return f(annotation, false);
    }

    public static a f(Annotation annotation, boolean z7) {
        b bVarB = b(annotation.annotationType());
        try {
            Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
            Arrays.sort(declaredMethods, new C0403a());
            for (Method method : declaredMethods) {
                Object objInvoke = method.invoke(annotation, new Object[0]);
                if (z7 || !Objects.deepEquals(objInvoke, method.getDefaultValue())) {
                    if (objInvoke.getClass().isArray()) {
                        for (int i7 = 0; i7 < Array.getLength(objInvoke); i7++) {
                            bVarB.e(method.getName(), Array.get(objInvoke, i7));
                        }
                    } else if (objInvoke instanceof Annotation) {
                        bVarB.d(method.getName(), "$L", e((Annotation) objInvoke));
                    } else {
                        bVarB.e(method.getName(), objInvoke);
                    }
                }
            }
            return bVarB.f();
        } catch (Exception e8) {
            throw new RuntimeException("Reflecting " + annotation + " failed!", e8);
        }
    }

    public static a g(AnnotationMirror annotationMirror) {
        b bVarA = a(com.squareup.javapoet.c.y(annotationMirror.getAnnotationType().asElement()));
        c cVar = new c(bVarA);
        for (ExecutableElement executableElement : annotationMirror.getElementValues().keySet()) {
            ((AnnotationValue) annotationMirror.getElementValues().get(executableElement)).accept(cVar, executableElement.getSimpleName().toString());
        }
        return bVarA.f();
    }

    void c(e eVar, boolean z7) throws IOException {
        String str = z7 ? "" : "\n";
        String str2 = z7 ? ", " : ",\n";
        if (this.f33280b.isEmpty()) {
            eVar.c("@$T", this.f33279a);
            return;
        }
        if (this.f33280b.size() == 1 && this.f33280b.containsKey("value")) {
            eVar.c("@$T(", this.f33279a);
            d(eVar, str, str2, this.f33280b.get("value"));
            eVar.b(")");
            return;
        }
        eVar.c("@$T(" + str, this.f33279a);
        eVar.r(2);
        Iterator<Map.Entry<String, List<d>>> it = this.f33280b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, List<d>> next = it.next();
            eVar.c("$L = ", next.getKey());
            d(eVar, str, str2, next.getValue());
            if (it.hasNext()) {
                eVar.b(str2);
            }
        }
        eVar.B(2);
        eVar.b(str + ")");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public b h() {
        b bVar = new b(this.f33279a, null);
        for (Map.Entry<String, List<d>> entry : this.f33280b.entrySet()) {
            bVar.f33282b.put(entry.getKey(), new ArrayList(entry.getValue()));
        }
        return bVar;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new e(stringWriter).c("$L", this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private a(b bVar) {
        this.f33279a = bVar.f33281a;
        this.f33280b = r.h(bVar.f33282b);
    }
}
