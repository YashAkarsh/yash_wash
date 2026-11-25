package com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends o implements Comparable<c> {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final c f33285y = w(Object.class);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final List<String> f33286w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final String f33287x;

    private c(List<String> list) {
        this(list, new ArrayList());
    }

    private static boolean A(Element element) {
        return element.getKind().isClass() || element.getKind().isInterface();
    }

    public static c t(String str) {
        ArrayList arrayList = new ArrayList();
        int iIndexOf = 0;
        while (iIndexOf < str.length() && Character.isLowerCase(str.codePointAt(iIndexOf))) {
            iIndexOf = str.indexOf(46, iIndexOf) + 1;
            r.b(iIndexOf != 0, "couldn't make a guess for %s", str);
        }
        arrayList.add(iIndexOf != 0 ? str.substring(0, iIndexOf - 1) : "");
        for (String str2 : str.substring(iIndexOf).split("\\.", -1)) {
            r.b(!str2.isEmpty() && Character.isUpperCase(str2.codePointAt(0)), "couldn't make a guess for %s", str);
            arrayList.add(str2);
        }
        r.b(arrayList.size() >= 2, "couldn't make a guess for %s", str);
        return new c(arrayList);
    }

    public static c w(Class<?> cls) {
        r.c(cls, "clazz == null", new Object[0]);
        r.b(!cls.isPrimitive(), "primitive types cannot be represented as a ClassName", new Object[0]);
        r.b(!Void.TYPE.equals(cls), "'void' type cannot be represented as a ClassName", new Object[0]);
        r.b(!cls.isArray(), "array types cannot be represented as a ClassName", new Object[0]);
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(cls.getSimpleName());
            Class<?> enclosingClass = cls.getEnclosingClass();
            if (enclosingClass == null) {
                break;
            }
            cls = enclosingClass;
        }
        int iLastIndexOf = cls.getName().lastIndexOf(46);
        if (iLastIndexOf != -1) {
            arrayList.add(cls.getName().substring(0, iLastIndexOf));
        }
        Collections.reverse(arrayList);
        return new c(arrayList);
    }

    public static c x(String str, String str2, String... strArr) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        arrayList.add(str2);
        Collections.addAll(arrayList, strArr);
        return new c(arrayList);
    }

    public static c y(TypeElement typeElement) {
        r.c(typeElement, "element == null", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (TypeElement enclosingElement = typeElement; A(enclosingElement); enclosingElement = enclosingElement.getEnclosingElement()) {
            r.b(typeElement.getNestingKind() == NestingKind.TOP_LEVEL || typeElement.getNestingKind() == NestingKind.MEMBER, "unexpected type testing", new Object[0]);
            arrayList.add(enclosingElement.getSimpleName().toString());
        }
        arrayList.add(z(typeElement).getQualifiedName().toString());
        Collections.reverse(arrayList);
        return new c(arrayList);
    }

    private static PackageElement z(Element element) {
        while (element.getKind() != ElementKind.PACKAGE) {
            element = element.getEnclosingElement();
        }
        return (PackageElement) element;
    }

    public c B(String str) {
        r.c(str, "name == null", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f33286w.size() + 1);
        arrayList.addAll(this.f33286w);
        arrayList.add(str);
        return new c(arrayList);
    }

    public String C() {
        return this.f33286w.get(0);
    }

    public c D(String str) {
        ArrayList arrayList = new ArrayList(this.f33286w);
        arrayList.set(arrayList.size() - 1, str);
        return new c(arrayList);
    }

    public String E() {
        List<String> list = this.f33286w;
        return list.get(list.size() - 1);
    }

    public List<String> F() {
        List<String> list = this.f33286w;
        return list.subList(1, list.size());
    }

    public c G() {
        return new c(this.f33286w.subList(0, 2));
    }

    @Override // com.squareup.javapoet.o
    e f(e eVar) throws IOException {
        return eVar.d(eVar.s(this));
    }

    @Override // com.squareup.javapoet.o
    public o r() {
        return new c(this.f33286w);
    }

    @Override // com.squareup.javapoet.o
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public c a(List<a> list) {
        return new c(this.f33286w, e(list));
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        return this.f33287x.compareTo(cVar.f33287x);
    }

    public c v() {
        if (this.f33286w.size() == 2) {
            return null;
        }
        List<String> list = this.f33286w;
        return new c(list.subList(0, list.size() - 1));
    }

    private c(List<String> list, List<a> list2) {
        super(list2);
        for (int i7 = 1; i7 < list.size(); i7++) {
            r.b(SourceVersion.isName(list.get(i7)), "part '%s' is keyword", list.get(i7));
        }
        this.f33286w = r.f(list);
        this.f33287x = list.get(0).isEmpty() ? r.j(com.alibaba.android.arouter.utils.b.f12515h, list.subList(1, list.size())) : r.j(com.alibaba.android.arouter.utils.b.f12515h, list);
    }
}
