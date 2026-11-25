package okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f38228a = new f();

    private f() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(@a7.d LogRecord record) {
        l0.p(record, "record");
        e eVar = e.f38227d;
        String loggerName = record.getLoggerName();
        l0.o(loggerName, "record.loggerName");
        int iB = g.b(record);
        String message = record.getMessage();
        l0.o(message, "record.message");
        eVar.a(loggerName, iB, message, record.getThrown());
    }
}
