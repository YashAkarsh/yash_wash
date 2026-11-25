package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.l;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.r;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.google.gson.stream.a {
    private static final Reader V = new C0305a();
    private static final Object W = new Object();
    private Object[] R;
    private int S;
    private String[] T;
    private int[] U;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.a$a, reason: collision with other inner class name */
    class C0305a extends Reader {
        C0305a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i7, int i8) throws IOException {
            throw new AssertionError();
        }
    }

    public a(l lVar) {
        super(V);
        this.R = new Object[32];
        this.S = 0;
        this.T = new String[32];
        this.U = new int[32];
        N1(lVar);
    }

    private Object A1() {
        Object[] objArr = this.R;
        int i7 = this.S - 1;
        this.S = i7;
        Object obj = objArr[i7];
        objArr[i7] = null;
        return obj;
    }

    private void N1(Object obj) {
        int i7 = this.S;
        Object[] objArr = this.R;
        if (i7 == objArr.length) {
            int i8 = i7 * 2;
            this.R = Arrays.copyOf(objArr, i8);
            this.U = Arrays.copyOf(this.U, i8);
            this.T = (String[]) Arrays.copyOf(this.T, i8);
        }
        Object[] objArr2 = this.R;
        int i9 = this.S;
        this.S = i9 + 1;
        objArr2[i9] = obj;
    }

    private String g0() {
        return " at path " + G();
    }

    private void w1(com.google.gson.stream.c cVar) throws IOException {
        if (J0() == cVar) {
            return;
        }
        throw new IllegalStateException("Expected " + cVar + " but was " + J0() + g0());
    }

    private Object z1() {
        return this.R[this.S - 1];
    }

    public void B1() throws IOException {
        w1(com.google.gson.stream.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) z1()).next();
        N1(entry.getValue());
        N1(new r((String) entry.getKey()));
    }

    @Override // com.google.gson.stream.a
    public void C() throws IOException {
        w1(com.google.gson.stream.c.END_ARRAY);
        A1();
        A1();
        int i7 = this.S;
        if (i7 > 0) {
            int[] iArr = this.U;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public void E() throws IOException {
        w1(com.google.gson.stream.c.END_OBJECT);
        A1();
        A1();
        int i7 = this.S;
        if (i7 > 0) {
            int[] iArr = this.U;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String G() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i7 = 0;
        while (i7 < this.S) {
            Object[] objArr = this.R;
            Object obj = objArr[i7];
            if (obj instanceof i) {
                i7++;
                if (objArr[i7] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.U[i7]);
                    sb.append(']');
                }
            } else if (obj instanceof o) {
                i7++;
                if (objArr[i7] instanceof Iterator) {
                    sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    String str = this.T[i7];
                    if (str != null) {
                        sb.append(str);
                    }
                }
            }
            i7++;
        }
        return sb.toString();
    }

    @Override // com.google.gson.stream.a
    public String G0() throws IOException {
        com.google.gson.stream.c cVarJ0 = J0();
        com.google.gson.stream.c cVar = com.google.gson.stream.c.STRING;
        if (cVarJ0 == cVar || cVarJ0 == com.google.gson.stream.c.NUMBER) {
            String strU = ((r) A1()).u();
            int i7 = this.S;
            if (i7 > 0) {
                int[] iArr = this.U;
                int i8 = i7 - 1;
                iArr[i8] = iArr[i8] + 1;
            }
            return strU;
        }
        throw new IllegalStateException("Expected " + cVar + " but was " + cVarJ0 + g0());
    }

    @Override // com.google.gson.stream.a
    public boolean H() throws IOException {
        com.google.gson.stream.c cVarJ0 = J0();
        return (cVarJ0 == com.google.gson.stream.c.END_OBJECT || cVarJ0 == com.google.gson.stream.c.END_ARRAY) ? false : true;
    }

    @Override // com.google.gson.stream.a
    public com.google.gson.stream.c J0() throws IOException {
        if (this.S == 0) {
            return com.google.gson.stream.c.END_DOCUMENT;
        }
        Object objZ1 = z1();
        if (objZ1 instanceof Iterator) {
            boolean z7 = this.R[this.S - 2] instanceof o;
            Iterator it = (Iterator) objZ1;
            if (!it.hasNext()) {
                return z7 ? com.google.gson.stream.c.END_OBJECT : com.google.gson.stream.c.END_ARRAY;
            }
            if (z7) {
                return com.google.gson.stream.c.NAME;
            }
            N1(it.next());
            return J0();
        }
        if (objZ1 instanceof o) {
            return com.google.gson.stream.c.BEGIN_OBJECT;
        }
        if (objZ1 instanceof i) {
            return com.google.gson.stream.c.BEGIN_ARRAY;
        }
        if (!(objZ1 instanceof r)) {
            if (objZ1 instanceof n) {
                return com.google.gson.stream.c.NULL;
            }
            if (objZ1 == W) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        r rVar = (r) objZ1;
        if (rVar.G()) {
            return com.google.gson.stream.c.STRING;
        }
        if (rVar.B()) {
            return com.google.gson.stream.c.BOOLEAN;
        }
        if (rVar.F()) {
            return com.google.gson.stream.c.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.gson.stream.a
    public void b() throws IOException {
        w1(com.google.gson.stream.c.BEGIN_ARRAY);
        N1(((i) z1()).iterator());
        this.U[this.S - 1] = 0;
    }

    @Override // com.google.gson.stream.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.R = new Object[]{W};
        this.S = 1;
    }

    @Override // com.google.gson.stream.a
    public void e() throws IOException {
        w1(com.google.gson.stream.c.BEGIN_OBJECT);
        N1(((o) z1()).entrySet().iterator());
    }

    @Override // com.google.gson.stream.a
    public boolean h0() throws IOException {
        w1(com.google.gson.stream.c.BOOLEAN);
        boolean zF = ((r) A1()).f();
        int i7 = this.S;
        if (i7 > 0) {
            int[] iArr = this.U;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return zF;
    }

    @Override // com.google.gson.stream.a
    public double l0() throws IOException {
        com.google.gson.stream.c cVarJ0 = J0();
        com.google.gson.stream.c cVar = com.google.gson.stream.c.NUMBER;
        if (cVarJ0 != cVar && cVarJ0 != com.google.gson.stream.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarJ0 + g0());
        }
        double dJ = ((r) z1()).j();
        if (!K() && (Double.isNaN(dJ) || Double.isInfinite(dJ))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dJ);
        }
        A1();
        int i7 = this.S;
        if (i7 > 0) {
            int[] iArr = this.U;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return dJ;
    }

    @Override // com.google.gson.stream.a
    public int o0() throws IOException {
        com.google.gson.stream.c cVarJ0 = J0();
        com.google.gson.stream.c cVar = com.google.gson.stream.c.NUMBER;
        if (cVarJ0 != cVar && cVarJ0 != com.google.gson.stream.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarJ0 + g0());
        }
        int iL = ((r) z1()).l();
        A1();
        int i7 = this.S;
        if (i7 > 0) {
            int[] iArr = this.U;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return iL;
    }

    @Override // com.google.gson.stream.a
    public long p0() throws IOException {
        com.google.gson.stream.c cVarJ0 = J0();
        com.google.gson.stream.c cVar = com.google.gson.stream.c.NUMBER;
        if (cVarJ0 != cVar && cVarJ0 != com.google.gson.stream.c.STRING) {
            throw new IllegalStateException("Expected " + cVar + " but was " + cVarJ0 + g0());
        }
        long jR = ((r) z1()).r();
        A1();
        int i7 = this.S;
        if (i7 > 0) {
            int[] iArr = this.U;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return jR;
    }

    @Override // com.google.gson.stream.a
    public void q1() throws IOException {
        if (J0() == com.google.gson.stream.c.NAME) {
            r0();
            this.T[this.S - 2] = "null";
        } else {
            A1();
            int i7 = this.S;
            if (i7 > 0) {
                this.T[i7 - 1] = "null";
            }
        }
        int i8 = this.S;
        if (i8 > 0) {
            int[] iArr = this.U;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
    }

    @Override // com.google.gson.stream.a
    public String r0() throws IOException {
        w1(com.google.gson.stream.c.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) z1()).next();
        String str = (String) entry.getKey();
        this.T[this.S - 1] = str;
        N1(entry.getValue());
        return str;
    }

    @Override // com.google.gson.stream.a
    public String toString() {
        return a.class.getSimpleName();
    }

    @Override // com.google.gson.stream.a
    public void v0() throws IOException {
        w1(com.google.gson.stream.c.NULL);
        A1();
        int i7 = this.S;
        if (i7 > 0) {
            int[] iArr = this.U;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }
}
