package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a extends Exception {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f11325b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f11326c = "There were multiple errors.";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<Throwable> f11327a;

    public a(String str, Throwable[] thArr) {
        this(str, (List<? extends Throwable>) Arrays.asList(thArr));
    }

    @Deprecated
    public Throwable[] a() {
        List<Throwable> list = this.f11327a;
        return (Throwable[]) list.toArray(new Throwable[list.size()]);
    }

    @Deprecated
    public List<Exception> b() {
        ArrayList arrayList = new ArrayList();
        List<Throwable> list = this.f11327a;
        if (list == null) {
            return arrayList;
        }
        for (Throwable th : list) {
            if (th instanceof Exception) {
                arrayList.add((Exception) th);
            } else {
                arrayList.add(new Exception(th));
            }
        }
        return arrayList;
    }

    public List<Throwable> c() {
        return this.f11327a;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        int i7 = -1;
        for (Throwable th : this.f11327a) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i7++;
            printStream.append((CharSequence) Integer.toString(i7));
            printStream.append(": ");
            th.printStackTrace(printStream);
            printStream.append("\n");
        }
    }

    public a(String str, List<? extends Throwable> list) {
        super(str, (list == null || list.size() <= 0) ? null : list.get(0));
        this.f11327a = Collections.unmodifiableList(list);
    }

    public a(List<? extends Throwable> list) {
        this(f11326c, list);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        int i7 = -1;
        for (Throwable th : this.f11327a) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i7++;
            printWriter.append((CharSequence) Integer.toString(i7));
            printWriter.append(": ");
            th.printStackTrace(printWriter);
            printWriter.append("\n");
        }
    }
}
