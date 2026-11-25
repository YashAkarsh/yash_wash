package okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.s1;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    @a7.d
    public static final String b(long j7) {
        String str;
        if (j7 <= -999500000) {
            str = ((j7 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j7 <= -999500) {
            str = ((j7 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j7 <= 0) {
            str = ((j7 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j7 < 999500) {
            str = ((j7 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j7 < 999500000) {
            str = ((j7 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j7 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        s1 s1Var = s1.f34921a;
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        l0.o(str2, "java.lang.String.format(format, *args)");
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a aVar, c cVar, String str) {
        Logger loggerA = d.f37736j.a();
        StringBuilder sb = new StringBuilder();
        sb.append(cVar.h());
        sb.append(' ');
        s1 s1Var = s1.f34921a;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        l0.o(str2, "java.lang.String.format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(aVar.b());
        loggerA.fine(sb.toString());
    }

    public static final <T> T d(@a7.d a task, @a7.d c queue, @a7.d i5.a<? extends T> block) {
        long jA;
        l0.p(task, "task");
        l0.p(queue, "queue");
        l0.p(block, "block");
        boolean zIsLoggable = d.f37736j.a().isLoggable(Level.FINE);
        if (zIsLoggable) {
            jA = queue.k().h().a();
            c(task, queue, "starting");
        } else {
            jA = -1;
        }
        try {
            T tInvoke = block.invoke();
            i0.d(1);
            if (zIsLoggable) {
                long jA2 = queue.k().h().a() - jA;
                new StringBuilder().append("finished run in ");
            }
            return tInvoke;
        } finally {
            i0.d(1);
            if (zIsLoggable) {
                c(task, queue, "failed a run in " + b(queue.k().h().a() - jA));
            }
            i0.c(1);
        }
    }

    public static final void e(@a7.d a task, @a7.d c queue, @a7.d i5.a<String> messageBlock) {
        l0.p(task, "task");
        l0.p(queue, "queue");
        l0.p(messageBlock, "messageBlock");
        if (d.f37736j.a().isLoggable(Level.FINE)) {
            c(task, queue, messageBlock.invoke());
        }
    }
}
