package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.r;
import com.google.gson.stream.d;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends d {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Writer f23138o = new a();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final r f23139p = new r("closed");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List<l> f23140l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f23141m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private l f23142n;

    class a extends Writer {
        a() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i7, int i8) {
            throw new AssertionError();
        }
    }

    public b() {
        super(f23138o);
        this.f23140l = new ArrayList();
        this.f23142n = n.f23245a;
    }

    private l d1() {
        List<l> list = this.f23140l;
        return list.get(list.size() - 1);
    }

    private void e1(l lVar) {
        if (this.f23141m != null) {
            if (!lVar.w() || E()) {
                ((o) d1()).A(this.f23141m, lVar);
            }
            this.f23141m = null;
            return;
        }
        if (this.f23140l.isEmpty()) {
            this.f23142n = lVar;
            return;
        }
        l lVarD1 = d1();
        if (!(lVarD1 instanceof i)) {
            throw new IllegalStateException();
        }
        ((i) lVarD1).A(lVar);
    }

    @Override // com.google.gson.stream.d
    public d C() throws IOException {
        if (this.f23140l.isEmpty() || this.f23141m != null) {
            throw new IllegalStateException();
        }
        if (!(d1() instanceof o)) {
            throw new IllegalStateException();
        }
        List<l> list = this.f23140l;
        list.remove(list.size() - 1);
        return this;
    }

    @Override // com.google.gson.stream.d
    public d I0(double d8) throws IOException {
        if (G() || !(Double.isNaN(d8) || Double.isInfinite(d8))) {
            e1(new r(Double.valueOf(d8)));
            return this;
        }
        throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d8);
    }

    @Override // com.google.gson.stream.d
    public d J0(long j7) throws IOException {
        e1(new r(Long.valueOf(j7)));
        return this;
    }

    @Override // com.google.gson.stream.d
    public d K(String str) throws IOException {
        if (this.f23140l.isEmpty() || this.f23141m != null) {
            throw new IllegalStateException();
        }
        if (!(d1() instanceof o)) {
            throw new IllegalStateException();
        }
        this.f23141m = str;
        return this;
    }

    @Override // com.google.gson.stream.d
    public d L0(Boolean bool) throws IOException {
        if (bool == null) {
            return g0();
        }
        e1(new r(bool));
        return this;
    }

    @Override // com.google.gson.stream.d
    public d Q0(Number number) throws IOException {
        if (number == null) {
            return g0();
        }
        if (!G()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        e1(new r(number));
        return this;
    }

    @Override // com.google.gson.stream.d
    public d T0(String str) throws IOException {
        if (str == null) {
            return g0();
        }
        e1(new r(str));
        return this;
    }

    @Override // com.google.gson.stream.d
    public d V0(boolean z7) throws IOException {
        e1(new r(Boolean.valueOf(z7)));
        return this;
    }

    public l a1() {
        if (this.f23140l.isEmpty()) {
            return this.f23142n;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f23140l);
    }

    @Override // com.google.gson.stream.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f23140l.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f23140l.add(f23139p);
    }

    @Override // com.google.gson.stream.d, java.io.Flushable
    public void flush() throws IOException {
    }

    @Override // com.google.gson.stream.d
    public d g0() throws IOException {
        e1(n.f23245a);
        return this;
    }

    @Override // com.google.gson.stream.d
    public d q() throws IOException {
        i iVar = new i();
        e1(iVar);
        this.f23140l.add(iVar);
        return this;
    }

    @Override // com.google.gson.stream.d
    public d r() throws IOException {
        o oVar = new o();
        e1(oVar);
        this.f23140l.add(oVar);
        return this;
    }

    @Override // com.google.gson.stream.d
    public d u() throws IOException {
        if (this.f23140l.isEmpty() || this.f23141m != null) {
            throw new IllegalStateException();
        }
        if (!(d1() instanceof i)) {
            throw new IllegalStateException();
        }
        List<l> list = this.f23140l;
        list.remove(list.size() - 1);
        return this;
    }
}
