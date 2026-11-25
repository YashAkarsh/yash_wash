package g1;

import android.os.Process;
import android.os.StrictMode;
import c.o0;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private static String f34021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f34022b;

    private x() {
    }

    @o0
    @c1.a
    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f34021a == null) {
            int iMyPid = f34022b;
            if (iMyPid == 0) {
                iMyPid = Process.myPid();
                f34022b = iMyPid;
            }
            String strTrim = null;
            strTrim = null;
            strTrim = null;
            BufferedReader bufferedReader2 = null;
            if (iMyPid > 0) {
                try {
                    StringBuilder sb = new StringBuilder(25);
                    sb.append("/proc/");
                    sb.append(iMyPid);
                    sb.append("/cmdline");
                    String string = sb.toString();
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        bufferedReader = new BufferedReader(new FileReader(string));
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        try {
                            String line = bufferedReader.readLine();
                            com.google.android.gms.common.internal.u.k(line);
                            strTrim = line.trim();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedReader;
                            q.b(bufferedReader2);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        throw th2;
                    }
                } catch (IOException unused2) {
                    bufferedReader = null;
                } catch (Throwable th3) {
                    th = th3;
                }
                q.b(bufferedReader);
            }
            f34021a = strTrim;
        }
        return f34021a;
    }
}
