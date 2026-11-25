package junit.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.framework.i;
import junit.framework.l;
import junit.framework.n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f34375b = "suite";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Properties f34376c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f34377d = k("maxmessage", 500);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static boolean f34378e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f34379a = true;

    public static String B(String str) {
        if (f34377d == -1 || str.length() <= f34377d) {
            return str;
        }
        return str.substring(0, f34377d) + "...";
    }

    static boolean h(String str) {
        String[] strArr = {"junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke("};
        for (int i7 = 0; i7 < 8; i7++) {
            if (str.indexOf(strArr[i7]) > 0) {
                return true;
            }
        }
        return false;
    }

    public static String i(String str) {
        if (x()) {
            return str;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return stringWriter.toString();
                }
                if (!h(line)) {
                    printWriter.println(line);
                }
            } catch (Exception unused) {
                return str;
            }
        }
    }

    public static String j(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return i(stringWriter.toString());
    }

    public static int k(String str, int i7) {
        String strL = l(str);
        if (strL == null) {
            return i7;
        }
        try {
            return Integer.parseInt(strL);
        } catch (NumberFormatException unused) {
            return i7;
        }
    }

    public static String l(String str) {
        return m().getProperty(str);
    }

    protected static Properties m() throws Throwable {
        if (f34376c == null) {
            Properties properties = new Properties();
            f34376c = properties;
            properties.put("loading", "true");
            f34376c.put("filterstack", "true");
            r();
        }
        return f34376c;
    }

    private static File n() {
        return new File(System.getProperty("user.home"), "junit.properties");
    }

    private static void r() throws Throwable {
        FileInputStream fileInputStream;
        Throwable th;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(n());
                try {
                    w(new Properties(m()));
                    m().load(fileInputStream);
                    fileInputStream.close();
                } catch (IOException unused) {
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 == null) {
                    } else {
                        fileInputStream2.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            }
        } catch (IOException unused4) {
        } catch (Throwable th3) {
            fileInputStream = null;
            th = th3;
        }
    }

    public static void t() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(n());
        try {
            m().store(fileOutputStream, "");
        } finally {
            fileOutputStream.close();
        }
    }

    public static void v(String str, String str2) {
        m().put(str, str2);
    }

    protected static void w(Properties properties) {
        f34376c = properties;
    }

    protected static boolean x() {
        return (l("filterstack").equals("true") && f34378e) ? false : true;
    }

    public abstract void A(String str);

    protected boolean C() {
        return l("loading").equals("true") && this.f34379a;
    }

    @Override // junit.framework.l
    public synchronized void a(i iVar, Throwable th) {
        z(1, iVar, th);
    }

    @Override // junit.framework.l
    public synchronized void b(i iVar, junit.framework.b bVar) {
        z(2, iVar, bVar);
    }

    @Override // junit.framework.l
    public synchronized void c(i iVar) {
        y(iVar.toString());
    }

    @Override // junit.framework.l
    public synchronized void d(i iVar) {
        A(iVar.toString());
    }

    protected void e() {
    }

    public String f(long j7) {
        return NumberFormat.getInstance().format(j7 / 1000.0d);
    }

    public String g(String str) {
        return str.startsWith("Default package for") ? str.substring(str.lastIndexOf(com.alibaba.android.arouter.utils.b.f12515h) + 1) : str;
    }

    public i o(String str) {
        if (str.length() <= 0) {
            e();
            return null;
        }
        try {
            Class<?> clsP = p(str);
            try {
                Method method = clsP.getMethod(f34375b, new Class[0]);
                if (!Modifier.isStatic(method.getModifiers())) {
                    s("Suite() method must be static");
                    return null;
                }
                try {
                    i iVar = (i) method.invoke(null, new Object[0]);
                    if (iVar == null) {
                        return iVar;
                    }
                    e();
                    return iVar;
                } catch (IllegalAccessException e8) {
                    s("Failed to invoke suite():" + e8.toString());
                    return null;
                } catch (InvocationTargetException e9) {
                    s("Failed to invoke suite():" + e9.getTargetException().toString());
                    return null;
                }
            } catch (Exception unused) {
                e();
                return new n(clsP);
            }
        } catch (ClassNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null) {
                str = message;
            }
            s("Class not found \"" + str + "\"");
            return null;
        } catch (Exception e11) {
            s("Error: " + e11.toString());
            return null;
        }
    }

    protected Class<?> p(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    protected String q(String[] strArr) {
        String strG = null;
        int i7 = 0;
        while (i7 < strArr.length) {
            if (strArr[i7].equals("-noloading")) {
                u(false);
            } else if (strArr[i7].equals("-nofilterstack")) {
                f34378e = false;
            } else if (strArr[i7].equals("-c")) {
                i7++;
                if (strArr.length > i7) {
                    strG = g(strArr[i7]);
                } else {
                    System.out.println("Missing Test class name");
                }
            } else {
                strG = strArr[i7];
            }
            i7++;
        }
        return strG;
    }

    protected abstract void s(String str);

    public void u(boolean z7) {
        this.f34379a = z7;
    }

    public abstract void y(String str);

    public abstract void z(int i7, i iVar, Throwable th);
}
