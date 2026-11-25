package d5;

import a7.d;
import java.util.List;
import kotlin.collections.o;
import kotlin.internal.l;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends l {
    @Override // kotlin.internal.l
    public void a(@d Throwable cause, @d Throwable exception) {
        l0.p(cause, "cause");
        l0.p(exception, "exception");
        cause.addSuppressed(exception);
    }

    @Override // kotlin.internal.l
    @d
    public List<Throwable> d(@d Throwable exception) {
        l0.p(exception, "exception");
        Throwable[] suppressed = exception.getSuppressed();
        l0.o(suppressed, "exception.suppressed");
        return o.t(suppressed);
    }
}
