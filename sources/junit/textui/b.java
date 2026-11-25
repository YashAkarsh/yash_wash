package junit.textui;

import java.io.PrintStream;
import junit.framework.i;
import junit.framework.j;
import junit.framework.m;
import junit.framework.n;
import junit.runner.c;

/* JADX INFO: loaded from: classes2.dex */
public class b extends junit.runner.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f34384g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f34385h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f34386i = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f34387f;

    public b() {
        this(System.out);
    }

    public static void G(String[] strArr) {
        try {
            if (!new b().N(strArr).q()) {
                System.exit(1);
            }
            System.exit(0);
        } catch (Exception e8) {
            System.err.println(e8.getMessage());
            System.exit(2);
        }
    }

    public static m I(i iVar) {
        return new b().E(iVar);
    }

    public static void J(Class<? extends j> cls) {
        I(new n(cls));
    }

    public static void K(i iVar) {
        new b().F(iVar, true);
    }

    @Override // junit.runner.a
    public void A(String str) {
    }

    protected m D() {
        return new m();
    }

    public m E(i iVar) {
        return F(iVar, false);
    }

    public m F(i iVar, boolean z7) {
        m mVarD = D();
        mVarD.c(this.f34387f);
        long jCurrentTimeMillis = System.currentTimeMillis();
        iVar.c(mVarD);
        this.f34387f.g(mVarD, System.currentTimeMillis() - jCurrentTimeMillis);
        H(z7);
        return mVarD;
    }

    protected void H(boolean z7) {
        if (z7) {
            this.f34387f.p();
            try {
                System.in.read();
            } catch (Exception unused) {
            }
        }
    }

    protected m L(String str, String str2, boolean z7) throws Exception {
        return F(n.h(p(str).asSubclass(j.class), str2), z7);
    }

    public void M(a aVar) {
        this.f34387f = aVar;
    }

    public m N(String[] strArr) throws Exception {
        String strG = "";
        String strSubstring = strG;
        int i7 = 0;
        boolean z7 = false;
        while (i7 < strArr.length) {
            if (strArr[i7].equals("-wait")) {
                z7 = true;
            } else if (strArr[i7].equals("-c")) {
                i7++;
                strG = g(strArr[i7]);
            } else if (strArr[i7].equals("-m")) {
                i7++;
                String str = strArr[i7];
                int iLastIndexOf = str.lastIndexOf(46);
                String strSubstring2 = str.substring(0, iLastIndexOf);
                strSubstring = str.substring(iLastIndexOf + 1);
                strG = strSubstring2;
            } else if (strArr[i7].equals("-v")) {
                System.err.println("JUnit " + c.a() + " by Kent Beck and Erich Gamma");
            } else {
                strG = strArr[i7];
            }
            i7++;
        }
        if (strG.equals("")) {
            throw new Exception("Usage: TestRunner [-wait] testCaseName, where name is the name of the TestCase class");
        }
        try {
            return !strSubstring.equals("") ? L(strG, strSubstring, z7) : F(o(strG), z7);
        } catch (Exception e8) {
            throw new Exception("Could not create and run test suite: " + e8);
        }
    }

    @Override // junit.runner.a
    protected void s(String str) {
        System.err.println(str);
        System.exit(1);
    }

    @Override // junit.runner.a
    public void y(String str) {
    }

    @Override // junit.runner.a
    public void z(int i7, i iVar, Throwable th) {
    }

    public b(PrintStream printStream) {
        this(new a(printStream));
    }

    public b(a aVar) {
        this.f34387f = aVar;
    }
}
