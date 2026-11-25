package com.airbnb.lottie.model;

import c.j;
import c.o0;
import c.x0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f12083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @o0
    private f f12084b;

    public e(String... strArr) {
        this.f12083a = Arrays.asList(strArr);
    }

    private boolean b() {
        List<String> list = this.f12083a;
        return list.get(list.size() - 1).equals("**");
    }

    private boolean f(String str) {
        return "__container".equals(str);
    }

    @j
    @x0({x0.a.LIBRARY})
    public e a(String str) {
        e eVar = new e(this);
        eVar.f12083a.add(str);
        return eVar;
    }

    @x0({x0.a.LIBRARY})
    public boolean c(String str, int i7) {
        if (i7 >= this.f12083a.size()) {
            return false;
        }
        boolean z7 = i7 == this.f12083a.size() - 1;
        String str2 = this.f12083a.get(i7);
        if (!str2.equals("**")) {
            return (z7 || (i7 == this.f12083a.size() + (-2) && b())) && (str2.equals(str) || str2.equals("*"));
        }
        if (!z7 && this.f12083a.get(i7 + 1).equals(str)) {
            return i7 == this.f12083a.size() + (-2) || (i7 == this.f12083a.size() + (-3) && b());
        }
        if (z7) {
            return true;
        }
        int i8 = i7 + 1;
        if (i8 < this.f12083a.size() - 1) {
            return false;
        }
        return this.f12083a.get(i8).equals(str);
    }

    @o0
    @x0({x0.a.LIBRARY})
    public f d() {
        return this.f12084b;
    }

    @x0({x0.a.LIBRARY})
    public int e(String str, int i7) {
        if (f(str)) {
            return 0;
        }
        if (this.f12083a.get(i7).equals("**")) {
            return (i7 != this.f12083a.size() - 1 && this.f12083a.get(i7 + 1).equals(str)) ? 2 : 0;
        }
        return 1;
    }

    public String g() {
        return this.f12083a.toString();
    }

    @x0({x0.a.LIBRARY})
    public boolean h(String str, int i7) {
        if (f(str)) {
            return true;
        }
        if (i7 >= this.f12083a.size()) {
            return false;
        }
        return this.f12083a.get(i7).equals(str) || this.f12083a.get(i7).equals("**") || this.f12083a.get(i7).equals("*");
    }

    @x0({x0.a.LIBRARY})
    public boolean i(String str, int i7) {
        return "__container".equals(str) || i7 < this.f12083a.size() - 1 || this.f12083a.get(i7).equals("**");
    }

    @x0({x0.a.LIBRARY})
    public e j(f fVar) {
        e eVar = new e(this);
        eVar.f12084b = fVar;
        return eVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f12083a);
        sb.append(",resolved=");
        sb.append(this.f12084b != null);
        sb.append('}');
        return sb.toString();
    }

    private e(e eVar) {
        this.f12083a = new ArrayList(eVar.f12083a);
        this.f12084b = eVar.f12084b;
    }
}
