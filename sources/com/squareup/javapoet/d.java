package com.squareup.javapoet;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;

/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final List<String> f33288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final List<Object> f33289b;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List<String> f33290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final List<Object> f33291b;

        private Object d(Object obj) {
            return obj;
        }

        private String e(Object obj) {
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            if (obj instanceof m) {
                return ((m) obj).f33360a;
            }
            if (obj instanceof f) {
                return ((f) obj).f33308b;
            }
            if (obj instanceof k) {
                return ((k) obj).f33336a;
            }
            if (obj instanceof p) {
                return ((p) obj).f33396b;
            }
            throw new IllegalArgumentException("expected name but was " + obj);
        }

        private String f(Object obj) {
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }

        private o g(Object obj) {
            if (obj instanceof o) {
                return (o) obj;
            }
            if (obj instanceof TypeMirror) {
                return o.j((TypeMirror) obj);
            }
            if (obj instanceof Element) {
                return o.j(((Element) obj).asType());
            }
            if (obj instanceof Type) {
                return o.h((Type) obj);
            }
            throw new IllegalArgumentException("expected type but was " + obj);
        }

        public b a(d dVar) {
            this.f33290a.addAll(dVar.f33288a);
            this.f33291b.addAll(dVar.f33289b);
            return this;
        }

        public b b(String str, Object... objArr) {
            boolean z7;
            int i7;
            int i8;
            char cCharAt;
            boolean z8;
            int i9;
            int[] iArr = new int[objArr.length];
            int i10 = 0;
            boolean z9 = false;
            int i11 = 0;
            boolean z10 = false;
            while (i10 < str.length()) {
                if (str.charAt(i10) != '$') {
                    int iIndexOf = str.indexOf(36, i10 + 1);
                    if (iIndexOf == -1) {
                        iIndexOf = str.length();
                    }
                    this.f33290a.add(str.substring(i10, iIndexOf));
                    i10 = iIndexOf;
                } else {
                    int i12 = i10 + 1;
                    int i13 = i12;
                    while (true) {
                        r.b(i13 < str.length(), "dangling format characters in '%s'", str);
                        i8 = i13 + 1;
                        cCharAt = str.charAt(i13);
                        if (cCharAt < '0' || cCharAt > '9') {
                            break;
                        }
                        i13 = i8;
                    }
                    int i14 = i8 - 1;
                    if (cCharAt == '$' || cCharAt == '>' || cCharAt == '<' || cCharAt == '[' || cCharAt == ']') {
                        r.b(i12 == i14, "$$, $>, $<, $[ and $] may not have an index", new Object[0]);
                        this.f33290a.add("$" + cCharAt);
                        i10 = i8;
                    } else {
                        if (i12 < i14) {
                            int i15 = Integer.parseInt(str.substring(i12, i14)) - 1;
                            int length = i15 % objArr.length;
                            iArr[length] = iArr[length] + 1;
                            z8 = true;
                            i9 = i11;
                            i11 = i15;
                        } else {
                            z8 = z10;
                            i9 = i11 + 1;
                            z9 = true;
                        }
                        r.b(i11 >= 0 && i11 < objArr.length, "index %d for '%s' not in range (received %s arguments)", Integer.valueOf(i11 + 1), str.substring(i12 - 1, i14 + 1), Integer.valueOf(objArr.length));
                        r.b((z8 && z9) ? false : true, "cannot mix indexed and positional parameters", new Object[0]);
                        if (cCharAt == 'L') {
                            this.f33291b.add(d(objArr[i11]));
                        } else if (cCharAt == 'N') {
                            this.f33291b.add(e(objArr[i11]));
                        } else if (cCharAt == 'S') {
                            this.f33291b.add(f(objArr[i11]));
                        } else {
                            if (cCharAt != 'T') {
                                throw new IllegalArgumentException(String.format("invalid format string: '%s'", str));
                            }
                            this.f33291b.add(g(objArr[i11]));
                        }
                        this.f33290a.add("$" + cCharAt);
                        i11 = i9;
                        i10 = i8;
                        z10 = z8;
                    }
                }
            }
            if (z9) {
                if (i11 >= objArr.length) {
                    i7 = 2;
                    z7 = true;
                } else {
                    z7 = false;
                    i7 = 2;
                }
                Object[] objArr2 = new Object[i7];
                objArr2[0] = Integer.valueOf(i11);
                objArr2[1] = Integer.valueOf(objArr.length);
                r.b(z7, "unused arguments: expected %s, received %s", objArr2);
            }
            if (z10) {
                ArrayList arrayList = new ArrayList();
                for (int i16 = 0; i16 < objArr.length; i16++) {
                    if (iArr[i16] == 0) {
                        arrayList.add("$" + (i16 + 1));
                    }
                }
                r.b(arrayList.isEmpty(), "unused argument%s: %s", arrayList.size() == 1 ? "" : "s", r.j(", ", arrayList));
            }
            return this;
        }

        public b c(String str, Object... objArr) {
            b("$[", new Object[0]);
            b(str, objArr);
            b(";\n$]", new Object[0]);
            return this;
        }

        public b h(String str, Object... objArr) {
            b(str + " {\n", objArr);
            l();
            return this;
        }

        public d i() {
            return new d(this);
        }

        public b j() {
            n();
            b("}\n", new Object[0]);
            return this;
        }

        public b k(String str, Object... objArr) {
            n();
            b("} " + str + ";\n", objArr);
            return this;
        }

        public b l() {
            this.f33290a.add("$>");
            return this;
        }

        public b m(String str, Object... objArr) {
            n();
            b("} " + str + " {\n", objArr);
            l();
            return this;
        }

        public b n() {
            this.f33290a.add("$<");
            return this;
        }

        private b() {
            this.f33290a = new ArrayList();
            this.f33291b = new ArrayList();
        }
    }

    public static b a() {
        return new b();
    }

    public static d c(String str, Object... objArr) {
        return new b().b(str, objArr).i();
    }

    public boolean b() {
        return this.f33288a.isEmpty();
    }

    public b d() {
        b bVar = new b();
        bVar.f33290a.addAll(this.f33288a);
        bVar.f33291b.addAll(this.f33289b);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && d.class == obj.getClass()) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            new e(stringWriter).a(this);
            return stringWriter.toString();
        } catch (IOException unused) {
            throw new AssertionError();
        }
    }

    private d(b bVar) {
        this.f33288a = r.f(bVar.f33290a);
        this.f33289b = r.f(bVar.f33291b);
    }
}
