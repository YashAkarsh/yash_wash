package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class d implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f23295j = new String[128];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f23296k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Writer f23297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f23298b = new int[32];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23299c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f23300d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f23301e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f23302f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f23303g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f23304h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f23305i;

    static {
        for (int i7 = 0; i7 <= 31; i7++) {
            f23295j[i7] = String.format("\\u%04x", Integer.valueOf(i7));
        }
        String[] strArr = f23295j;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f23296k = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public d(Writer writer) {
        o0(6);
        this.f23301e = ":";
        this.f23305i = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f23297a = writer;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void G0(String str) throws IOException {
        String str2;
        String[] strArr = this.f23303g ? f23296k : f23295j;
        this.f23297a.write(34);
        int length = str.length();
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = str.charAt(i8);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i7 < i8) {
                        this.f23297a.write(str, i7, i8 - i7);
                    }
                    this.f23297a.write(str2);
                    i7 = i8 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i7 < i8) {
                    this.f23297a.write(str, i7, i8 - i7);
                }
                this.f23297a.write(str2);
                i7 = i8 + 1;
            }
        }
        if (i7 < length) {
            this.f23297a.write(str, i7, length - i7);
        }
        this.f23297a.write(34);
    }

    private void Q() throws IOException {
        if (this.f23300d == null) {
            return;
        }
        this.f23297a.write(10);
        int i7 = this.f23299c;
        for (int i8 = 1; i8 < i7; i8++) {
            this.f23297a.write(this.f23300d);
        }
    }

    private void Y0() throws IOException {
        if (this.f23304h != null) {
            b();
            G0(this.f23304h);
            this.f23304h = null;
        }
    }

    private void b() throws IOException {
        int iL0 = l0();
        if (iL0 == 5) {
            this.f23297a.write(44);
        } else if (iL0 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        Q();
        p0(4);
    }

    private void e() throws IOException {
        int iL0 = l0();
        if (iL0 == 1) {
            p0(2);
            Q();
            return;
        }
        if (iL0 == 2) {
            this.f23297a.append(',');
            Q();
        } else {
            if (iL0 == 4) {
                this.f23297a.append((CharSequence) this.f23301e);
                p0(5);
                return;
            }
            if (iL0 != 6) {
                if (iL0 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f23302f) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            p0(7);
        }
    }

    private d h0(int i7, char c8) throws IOException {
        e();
        o0(i7);
        this.f23297a.write(c8);
        return this;
    }

    private int l0() {
        int i7 = this.f23299c;
        if (i7 != 0) {
            return this.f23298b[i7 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void o0(int i7) {
        int i8 = this.f23299c;
        int[] iArr = this.f23298b;
        if (i8 == iArr.length) {
            this.f23298b = Arrays.copyOf(iArr, i8 * 2);
        }
        int[] iArr2 = this.f23298b;
        int i9 = this.f23299c;
        this.f23299c = i9 + 1;
        iArr2[i9] = i7;
    }

    private void p0(int i7) {
        this.f23298b[this.f23299c - 1] = i7;
    }

    private d s(int i7, int i8, char c8) throws IOException {
        int iL0 = l0();
        if (iL0 != i8 && iL0 != i7) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f23304h != null) {
            throw new IllegalStateException("Dangling name: " + this.f23304h);
        }
        this.f23299c--;
        if (iL0 == i8) {
            Q();
        }
        this.f23297a.write(c8);
        return this;
    }

    public d C() throws IOException {
        return s(3, 5, '}');
    }

    public final boolean E() {
        return this.f23305i;
    }

    public final boolean F() {
        return this.f23303g;
    }

    public boolean G() {
        return this.f23302f;
    }

    public d H(String str) throws IOException {
        if (str == null) {
            return g0();
        }
        Y0();
        e();
        this.f23297a.append((CharSequence) str);
        return this;
    }

    public d I0(double d8) throws IOException {
        Y0();
        if (this.f23302f || !(Double.isNaN(d8) || Double.isInfinite(d8))) {
            e();
            this.f23297a.append((CharSequence) Double.toString(d8));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d8);
    }

    public d J0(long j7) throws IOException {
        Y0();
        e();
        this.f23297a.write(Long.toString(j7));
        return this;
    }

    public d K(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f23304h != null) {
            throw new IllegalStateException();
        }
        if (this.f23299c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f23304h = str;
        return this;
    }

    public d L0(Boolean bool) throws IOException {
        if (bool == null) {
            return g0();
        }
        Y0();
        e();
        this.f23297a.write(bool.booleanValue() ? "true" : com.paytm.pgsdk.d.G);
        return this;
    }

    public d Q0(Number number) throws IOException {
        if (number == null) {
            return g0();
        }
        Y0();
        String string = number.toString();
        if (this.f23302f || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            e();
            this.f23297a.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public d T0(String str) throws IOException {
        if (str == null) {
            return g0();
        }
        Y0();
        e();
        G0(str);
        return this;
    }

    public d V0(boolean z7) throws IOException {
        Y0();
        e();
        this.f23297a.write(z7 ? "true" : com.paytm.pgsdk.d.G);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f23297a.close();
        int i7 = this.f23299c;
        if (i7 > 1 || (i7 == 1 && this.f23298b[i7 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f23299c = 0;
    }

    public void flush() throws IOException {
        if (this.f23299c == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f23297a.flush();
    }

    public d g0() throws IOException {
        if (this.f23304h != null) {
            if (!this.f23305i) {
                this.f23304h = null;
                return this;
            }
            Y0();
        }
        e();
        this.f23297a.write("null");
        return this;
    }

    public d q() throws IOException {
        Y0();
        return h0(1, '[');
    }

    public d r() throws IOException {
        Y0();
        return h0(3, '{');
    }

    public final void r0(boolean z7) {
        this.f23303g = z7;
    }

    public final void s0(String str) {
        if (str.length() == 0) {
            this.f23300d = null;
            this.f23301e = ":";
        } else {
            this.f23300d = str;
            this.f23301e = ": ";
        }
    }

    public d u() throws IOException {
        return s(1, 2, ']');
    }

    public final void v0(boolean z7) {
        this.f23302f = z7;
    }

    public final void x0(boolean z7) {
        this.f23305i = z7;
    }
}
