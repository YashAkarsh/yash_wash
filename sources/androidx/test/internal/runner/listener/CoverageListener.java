package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.runner.j;

/* JADX INFO: loaded from: classes.dex */
public class CoverageListener extends InstrumentationRunListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10168c = "CoverageListener";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10169d = "coverageFilePath";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10170e = "coverage.ec";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10171f = "com.vladium.emma.rt.RT";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f10172b;

    public CoverageListener(String customCoverageFilePath) {
        this.f10172b = customCoverageFilePath;
    }

    private void m(PrintStream writer, Bundle results) {
        Class<?> cls;
        File file = new File(this.f10172b);
        try {
            try {
                try {
                    cls = Class.forName(f10171f, true, h().getTargetContext().getClassLoader());
                } catch (ClassNotFoundException unused) {
                    cls = Class.forName(f10171f, true, h().getContext().getClassLoader());
                    Log.w(f10168c, "Generating coverage for alternate test context.");
                    writer.format("\nWarning: %s", "Generating coverage for alternate test context.");
                }
                Class<?> cls2 = Boolean.TYPE;
                Method method = cls.getMethod("dumpCoverageData", file.getClass(), cls2, cls2);
                Boolean bool = Boolean.FALSE;
                method.invoke(null, file, bool, bool);
                results.putString(f10169d, this.f10172b);
                writer.format("\nGenerated code coverage data to %s", this.f10172b);
            } catch (ClassNotFoundException e8) {
                o(writer, "Is Emma/JaCoCo jar on classpath?", e8);
            }
        } catch (IllegalAccessException e9) {
            n(writer, e9);
        } catch (IllegalArgumentException e10) {
            n(writer, e10);
        } catch (NoSuchMethodException e11) {
            n(writer, e11);
        } catch (SecurityException e12) {
            n(writer, e12);
        } catch (InvocationTargetException e13) {
            n(writer, e13);
        }
    }

    private void n(PrintStream writer, Exception e8) {
        o(writer, "", e8);
    }

    private void o(PrintStream writer, String hint, Exception e8) {
        String strValueOf = String.valueOf(hint);
        String strConcat = strValueOf.length() != 0 ? "Failed to generate Emma/JaCoCo coverage. ".concat(strValueOf) : new String("Failed to generate Emma/JaCoCo coverage. ");
        Log.e(f10168c, strConcat, e8);
        writer.format("\nError: %s", strConcat);
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void i(PrintStream writer, Bundle results, j junitResults) {
        m(writer, results);
    }

    @Override // androidx.test.internal.runner.listener.InstrumentationRunListener
    public void l(Instrumentation instr) {
        super.l(instr);
        if (this.f10172b == null) {
            String absolutePath = instr.getTargetContext().getFilesDir().getAbsolutePath();
            String str = File.separator;
            StringBuilder sb = new StringBuilder(String.valueOf(absolutePath).length() + 11 + String.valueOf(str).length());
            sb.append(absolutePath);
            sb.append(str);
            sb.append(f10170e);
            this.f10172b = sb.toString();
        }
    }
}
