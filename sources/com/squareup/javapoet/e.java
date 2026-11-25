package com.squareup.javapoet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Modifier;

/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f33292o = new String();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Appendable f33294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f33295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f33297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f33298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List<p> f33299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set<String> f33300h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Set<String> f33301i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, c> f33302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<String, c> f33303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Set<String> f33304l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f33305m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f33306n;

    e(Appendable appendable) {
        this(appendable, "  ", Collections.emptySet());
    }

    private void g() throws IOException {
        for (int i7 = 0; i7 < this.f33295c; i7++) {
            this.f33294b.append(this.f33293a);
        }
    }

    private void i(Object obj) throws IOException {
        if (obj instanceof p) {
            ((p) obj).f(this, null, Collections.emptySet());
            return;
        }
        if (obj instanceof a) {
            ((a) obj).c(this, true);
        } else if (obj instanceof d) {
            a((d) obj);
        } else {
            d(String.valueOf(obj));
        }
    }

    private boolean l(String str, String str2) throws IOException {
        String strSubstring = str2.substring(1);
        if (strSubstring.isEmpty() || !Character.isJavaIdentifierStart(strSubstring.charAt(0))) {
            return false;
        }
        String str3 = str + com.alibaba.android.arouter.utils.b.f12515h + n(strSubstring);
        String str4 = str + ".*";
        if (!this.f33301i.contains(str3) && !this.f33301i.contains(str4)) {
            return false;
        }
        d(strSubstring);
        return true;
    }

    private static String n(String str) {
        r.b(Character.isJavaIdentifierStart(str.charAt(0)), "not an identifier: %s", str);
        for (int i7 = 1; i7 <= str.length(); i7++) {
            if (!SourceVersion.isIdentifier(str.substring(0, i7))) {
                return str.substring(0, i7 - 1);
            }
        }
        return str;
    }

    private void o(c cVar) {
        c cVarG;
        String strE;
        c cVarPut;
        if (cVar.C().isEmpty() || (cVarPut = this.f33303k.put((strE = (cVarG = cVar.G()).E()), cVarG)) == null) {
            return;
        }
        this.f33303k.put(strE, cVarPut);
    }

    private c x(String str) {
        for (int size = this.f33299g.size() - 1; size >= 0; size--) {
            Iterator<p> it = this.f33299g.get(size).f33409o.iterator();
            while (it.hasNext()) {
                if (Objects.equals(it.next().f33396b, str)) {
                    return y(size, str);
                }
            }
        }
        if (this.f33299g.size() > 0 && Objects.equals(this.f33299g.get(0).f33396b, str)) {
            return c.x(this.f33298f, str, new String[0]);
        }
        c cVar = this.f33302j.get(str);
        if (cVar != null) {
            return cVar;
        }
        return null;
    }

    private c y(int i7, String str) {
        c cVarX = c.x(this.f33298f, this.f33299g.get(0).f33396b, new String[0]);
        for (int i8 = 1; i8 <= i7; i8++) {
            cVarX = cVarX.B(this.f33299g.get(i8).f33396b);
        }
        return cVarX.B(str);
    }

    public e A() {
        return B(1);
    }

    public e B(int i7) {
        r.b(this.f33295c - i7 >= 0, "cannot unindent %s from %s", Integer.valueOf(i7), Integer.valueOf(this.f33295c));
        this.f33295c -= i7;
        return this;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x00d5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:101:0x0126 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:102:0x013f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x014d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:104:0x015b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:105:0x0160 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:106:0x0165 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x008f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:116:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:118:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:119:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:123:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:12:0x002f  */
    /* JADX WARN: Code duplicated, block: B:13:0x0033  */
    /* JADX WARN: Code duplicated, block: B:16:0x003c  */
    /* JADX WARN: Code duplicated, block: B:17:0x003e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:21:0x0049  */
    /* JADX WARN: Code duplicated, block: B:24:0x0052  */
    /* JADX WARN: Code duplicated, block: B:25:0x0054  */
    /* JADX WARN: Code duplicated, block: B:28:0x005d  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0068  */
    /* JADX WARN: Code duplicated, block: B:33:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    /* JADX WARN: Code duplicated, block: B:40:0x007e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080  */
    /* JADX WARN: Code duplicated, block: B:44:0x0089  */
    /* JADX WARN: Code duplicated, block: B:48:0x0091  */
    /* JADX WARN: Code duplicated, block: B:50:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:83:0x0122  */
    /* JADX WARN: Code duplicated, block: B:86:0x0132  */
    /* JADX WARN: Code duplicated, block: B:87:0x0139  */
    /* JADX WARN: Code duplicated, block: B:8:0x0023  */
    /* JADX WARN: Code duplicated, block: B:98:0x00ac A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:99:0x00c4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0026  */
    /* JADX WARN: Failed to find 'out' block for switch in B:46:0x008c. Please report as an issue. */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:107:0x008f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public com.squareup.javapoet.e a(com.squareup.javapoet.d r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.javapoet.e.a(com.squareup.javapoet.d):com.squareup.javapoet.e");
    }

    public e b(String str) throws IOException {
        return d(str);
    }

    public e c(String str, Object... objArr) throws IOException {
        return a(d.c(str, objArr));
    }

    e d(String str) throws IOException {
        String[] strArrSplit = str.split("\n", -1);
        int length = strArrSplit.length;
        boolean z7 = true;
        int i7 = 0;
        while (i7 < length) {
            String str2 = strArrSplit[i7];
            if (!z7) {
                if ((this.f33296d || this.f33297e) && this.f33305m) {
                    g();
                    this.f33294b.append(this.f33296d ? " *" : "//");
                }
                this.f33294b.append('\n');
                this.f33305m = true;
                int i8 = this.f33306n;
                if (i8 != -1) {
                    if (i8 == 0) {
                        r(2);
                    }
                    this.f33306n++;
                }
            }
            if (!str2.isEmpty()) {
                if (this.f33305m) {
                    g();
                    if (this.f33296d) {
                        this.f33294b.append(" * ");
                    } else if (this.f33297e) {
                        this.f33294b.append("// ");
                    }
                }
                this.f33294b.append(str2);
                this.f33305m = false;
            }
            i7++;
            z7 = false;
        }
        return this;
    }

    public void e(List<a> list, boolean z7) throws IOException {
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            it.next().c(this, z7);
            b(z7 ? " " : "\n");
        }
    }

    public void f(d dVar) throws IOException {
        this.f33305m = true;
        this.f33297e = true;
        try {
            a(dVar);
            b("\n");
        } finally {
            this.f33297e = false;
        }
    }

    public void h(d dVar) throws IOException {
        if (dVar.b()) {
            return;
        }
        b("/**\n");
        this.f33296d = true;
        try {
            a(dVar);
            this.f33296d = false;
            b(" */\n");
        } catch (Throwable th) {
            this.f33296d = false;
            throw th;
        }
    }

    public void j(Set<Modifier> set) throws IOException {
        k(set, Collections.emptySet());
    }

    public void k(Set<Modifier> set, Set<Modifier> set2) throws IOException {
        if (set.isEmpty()) {
            return;
        }
        for (Modifier modifier : EnumSet.copyOf((Collection) set)) {
            if (!set2.contains(modifier)) {
                d(modifier.name().toLowerCase(Locale.US));
                d(" ");
            }
        }
    }

    public void m(List<q> list) throws IOException {
        if (list.isEmpty()) {
            return;
        }
        b("<");
        boolean z7 = true;
        for (q qVar : list) {
            if (!z7) {
                b(", ");
            }
            c("$L", qVar.f33436w);
            Iterator<o> it = qVar.f33437x.iterator();
            boolean z8 = true;
            while (it.hasNext()) {
                c(z8 ? " extends $T" : " & $T", it.next());
                z8 = false;
            }
            z7 = false;
        }
        b(">");
    }

    public Map<String, c> p() {
        return this.f33302j;
    }

    public e q() {
        return r(1);
    }

    public e r(int i7) {
        this.f33295c += i7;
        return this;
    }

    String s(c cVar) {
        c cVarV = cVar;
        boolean z7 = false;
        while (cVarV != null) {
            c cVarX = x(cVarV.E());
            boolean z8 = cVarX != null;
            if (Objects.equals(cVarX, cVarV)) {
                return r.j(com.alibaba.android.arouter.utils.b.f12515h, cVar.F().subList(cVarV.F().size() - 1, cVar.F().size()));
            }
            cVarV = cVarV.v();
            z7 = z8;
        }
        if (z7) {
            return cVar.f33287x;
        }
        if (Objects.equals(this.f33298f, cVar.C())) {
            this.f33304l.add(cVar.G().E());
            return r.j(com.alibaba.android.arouter.utils.b.f12515h, cVar.F());
        }
        if (!this.f33296d) {
            o(cVar);
        }
        return cVar.f33287x;
    }

    public e t() {
        String str = this.f33298f;
        String str2 = f33292o;
        r.d(str != str2, "package already set: %s", str);
        this.f33298f = str2;
        return this;
    }

    public e u() {
        List<p> list = this.f33299g;
        list.remove(list.size() - 1);
        return this;
    }

    public e v(String str) {
        String str2 = this.f33298f;
        r.d(str2 == f33292o, "package already set: %s", str2);
        this.f33298f = (String) r.c(str, "packageName == null", new Object[0]);
        return this;
    }

    public e w(p pVar) {
        this.f33299g.add(pVar);
        return this;
    }

    Map<String, c> z() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(this.f33303k);
        linkedHashMap.keySet().removeAll(this.f33304l);
        return linkedHashMap;
    }

    e(Appendable appendable, String str, Set<String> set) {
        this(appendable, str, Collections.emptyMap(), set);
    }

    e(Appendable appendable, String str, Map<String, c> map, Set<String> set) {
        this.f33296d = false;
        this.f33297e = false;
        this.f33298f = f33292o;
        this.f33299g = new ArrayList();
        this.f33303k = new LinkedHashMap();
        this.f33304l = new LinkedHashSet();
        this.f33306n = -1;
        this.f33294b = (Appendable) r.c(appendable, "out == null", new Object[0]);
        this.f33293a = (String) r.c(str, "indent == null", new Object[0]);
        this.f33302j = (Map) r.c(map, "importedTypes == null", new Object[0]);
        this.f33301i = (Set) r.c(set, "staticImports == null", new Object[0]);
        this.f33300h = new LinkedHashSet();
        for (String str2 : set) {
            this.f33300h.add(str2.substring(0, str2.lastIndexOf(46)));
        }
    }
}
