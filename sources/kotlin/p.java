package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public class p {
    @kotlin.internal.e
    @g1(version = "1.1")
    public static void a(@a7.d Throwable th, @a7.d Throwable exception) {
        kotlin.jvm.internal.l0.p(th, "<this>");
        kotlin.jvm.internal.l0.p(exception, "exception");
        if (th != exception) {
            kotlin.internal.m.f34747a.a(th, exception);
        }
    }

    @a7.d
    public static final StackTraceElement[] b(@a7.d Throwable th) {
        kotlin.jvm.internal.l0.p(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        kotlin.jvm.internal.l0.m(stackTrace);
        return stackTrace;
    }

    public static /* synthetic */ void c(Throwable th) {
    }

    @a7.d
    public static final List<Throwable> d(@a7.d Throwable th) {
        kotlin.jvm.internal.l0.p(th, "<this>");
        return kotlin.internal.m.f34747a.d(th);
    }

    @g1(version = "1.4")
    public static /* synthetic */ void e(Throwable th) {
    }

    @kotlin.internal.f
    private static final void f(Throwable th) {
        kotlin.jvm.internal.l0.p(th, "<this>");
        th.printStackTrace();
    }

    @kotlin.internal.f
    private static final void g(Throwable th, PrintStream stream) {
        kotlin.jvm.internal.l0.p(th, "<this>");
        kotlin.jvm.internal.l0.p(stream, "stream");
        th.printStackTrace(stream);
    }

    @kotlin.internal.f
    private static final void h(Throwable th, PrintWriter writer) {
        kotlin.jvm.internal.l0.p(th, "<this>");
        kotlin.jvm.internal.l0.p(writer, "writer");
        th.printStackTrace(writer);
    }

    @a7.d
    @g1(version = "1.4")
    public static final String i(@a7.d Throwable th) {
        kotlin.jvm.internal.l0.p(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String string = stringWriter.toString();
        kotlin.jvm.internal.l0.o(string, "sw.toString()");
        return string;
    }
}
