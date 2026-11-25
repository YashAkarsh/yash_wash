package okhttp3.internal.platform.android;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.c1;
import kotlin.jvm.internal.l0;
import kotlin.text.c0;
import kotlin.text.e0;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes3.dex */
@okhttp3.internal.c
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f38224a = 4000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map<String, String> f38226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e f38227d = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CopyOnWriteArraySet<Logger> f38225b = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r7 = OkHttpClient.class.getPackage();
        String name = r7 != null ? r7.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        l0.o(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = okhttp3.internal.http2.e.class.getName();
        l0.o(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = okhttp3.internal.concurrent.d.class.getName();
        l0.o(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f38226c = c1.D0(linkedHashMap);
    }

    private e() {
    }

    private final void c(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (f38225b.add(logger)) {
            l0.o(logger, "logger");
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(f.f38228a);
        }
    }

    private final String d(String str) {
        String str2 = f38226c.get(str);
        return str2 != null ? str2 : e0.X8(str, 23);
    }

    public final void a(@a7.d String loggerName, int i7, @a7.d String message, @a7.e Throwable th) {
        int iMin;
        l0.p(loggerName, "loggerName");
        l0.p(message, "message");
        String strD = d(loggerName);
        if (Log.isLoggable(strD, i7)) {
            if (th != null) {
                message = message + "\n" + Log.getStackTraceString(th);
            }
            int length = message.length();
            int i8 = 0;
            while (i8 < length) {
                int iQ3 = c0.q3(message, '\n', i8, false, 4, null);
                if (iQ3 == -1) {
                    iQ3 = length;
                }
                while (true) {
                    iMin = Math.min(iQ3, i8 + 4000);
                    String strSubstring = message.substring(i8, iMin);
                    l0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i7, strD, strSubstring);
                    if (iMin >= iQ3) {
                        break;
                    } else {
                        i8 = iMin;
                    }
                }
                i8 = iMin + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry<String, String> entry : f38226c.entrySet()) {
            c(entry.getKey(), entry.getValue());
        }
    }
}
