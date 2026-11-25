package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import androidx.test.internal.runner.listener.InstrumentationRunListener;
import androidx.test.internal.util.Checks;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.c;
import org.junit.runner.h;
import org.junit.runner.i;
import org.junit.runner.j;
import org.junit.runner.notification.b;

/* JADX INFO: loaded from: classes.dex */
public final class TestExecutor {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10051c = "TestExecutor";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f10052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Instrumentation f10053b;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<b> f10054a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Instrumentation f10055b;

        public Builder(Instrumentation instr) {
            this.f10055b = instr;
        }

        public Builder c(b listener) {
            this.f10054a.add(listener);
            return this;
        }

        public TestExecutor d() {
            return new TestExecutor(this);
        }
    }

    private void b(List<b> listeners, PrintStream summaryWriter, Bundle resultBundle, j jUnitResults) {
        for (b bVar : listeners) {
            if (bVar instanceof InstrumentationRunListener) {
                ((InstrumentationRunListener) bVar).i(summaryWriter, resultBundle, jUnitResults);
            }
        }
    }

    private void c(h testRunner) {
        for (b bVar : this.f10052a) {
            String name = bVar.getClass().getName();
            Log.d(f10051c, name.length() != 0 ? "Adding listener ".concat(name) : new String("Adding listener "));
            testRunner.a(bVar);
            if (bVar instanceof InstrumentationRunListener) {
                ((InstrumentationRunListener) bVar).l(this.f10053b);
            }
        }
    }

    public Bundle a(i request) {
        String str;
        Bundle bundle = new Bundle();
        j jVar = new j();
        try {
            h hVar = new h();
            c(hVar);
            j jVarH = hVar.h(request);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            b(this.f10052a, printStream, bundle, jVarH);
            printStream.close();
            str = String.format("\n%s", byteArrayOutputStream.toString());
        } catch (Throwable th) {
            try {
                Log.e(f10051c, "Fatal exception when running tests", th);
                jVar.h().add(new org.junit.runner.notification.a(c.e("Fatal exception when running tests", new Annotation[0]), th));
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                PrintStream printStream2 = new PrintStream(byteArrayOutputStream2);
                b(this.f10052a, printStream2, bundle, jVar);
                printStream2.close();
                str = String.format("\n%s", byteArrayOutputStream2.toString());
            } catch (Throwable th2) {
                ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                PrintStream printStream3 = new PrintStream(byteArrayOutputStream3);
                b(this.f10052a, printStream3, bundle, jVar);
                printStream3.close();
                bundle.putString("stream", String.format("\n%s", byteArrayOutputStream3.toString()));
                throw th2;
            }
        }
        bundle.putString("stream", str);
        return bundle;
    }

    private TestExecutor(Builder builder) {
        this.f10052a = (List) Checks.f(builder.f10054a);
        this.f10053b = builder.f10055b;
    }
}
