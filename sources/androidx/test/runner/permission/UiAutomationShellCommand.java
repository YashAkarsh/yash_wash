package androidx.test.runner.permission;

import android.annotation.TargetApi;
import android.app.UiAutomation;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.test.InstrumentationRegistry;
import androidx.test.internal.util.Checks;
import c.g1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(23)
class UiAutomationShellCommand extends ShellCommand {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10509f = "UiAutomationShellCmd";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f10511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PmCommand f10512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final UiAutomation f10513e = (UiAutomation) Checks.f(InstrumentationRegistry.c().getUiAutomation());

    enum PmCommand {
        GRANT_PERMISSION("grant");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10516a;

        PmCommand(String command) {
            String strValueOf = String.valueOf(command);
            this.f10516a = strValueOf.length() != 0 ? "pm ".concat(strValueOf) : new String("pm ");
        }

        public String a() {
            return this.f10516a;
        }
    }

    UiAutomationShellCommand(String targetPackage, String permission, PmCommand pmCommand) {
        this.f10510b = ShellCommand.b(targetPackage);
        this.f10511c = ShellCommand.b(permission);
        this.f10512d = pmCommand;
    }

    private static void c(ParcelFileDescriptor pfDescriptor, long timeout, TimeUnit unit) throws Throwable {
        long millis = unit.toMillis(timeout);
        long jCurrentTimeMillis = millis > 0 ? System.currentTimeMillis() + millis : 0L;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new ParcelFileDescriptor.AutoCloseInputStream(pfDescriptor)));
            do {
                try {
                    String line = bufferedReader2.readLine();
                    if (line == null) {
                        bufferedReader2.close();
                        return;
                    }
                    Log.i(f10509f, line);
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } while (jCurrentTimeMillis <= System.currentTimeMillis());
            throw new TimeoutException();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private void e(String cmd) throws Throwable {
        String strValueOf = String.valueOf(cmd);
        Log.i(f10509f, strValueOf.length() != 0 ? "Requesting permission: ".concat(strValueOf) : new String("Requesting permission: "));
        try {
            c(this.f10513e.executeShellCommand(cmd), 2L, TimeUnit.SECONDS);
        } catch (TimeoutException unused) {
            String strValueOf2 = String.valueOf(cmd);
            Log.e(f10509f, strValueOf2.length() != 0 ? "Timeout while executing cmd: ".concat(strValueOf2) : new String("Timeout while executing cmd: "));
        }
    }

    @Override // androidx.test.runner.permission.ShellCommand
    public void a() throws Exception {
        e(d());
    }

    @g1
    protected String d() {
        return this.f10512d.a() + " " + this.f10510b + " " + this.f10511c;
    }
}
