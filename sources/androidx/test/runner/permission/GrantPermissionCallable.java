package androidx.test.runner.permission;

import android.content.Context;
import android.util.Log;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
class GrantPermissionCallable extends RequestPermissionCallable {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f10496e = "GrantPermissionCallable";

    GrantPermissionCallable(@m0 ShellCommand shellCommand, @m0 Context context, String permission) {
        super(shellCommand, context, permission);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public RequestPermissionCallable.Result call() throws Exception {
        if (c()) {
            String strA = a();
            StringBuilder sb = new StringBuilder(String.valueOf(strA).length() + 32);
            sb.append("Permission: ");
            sb.append(strA);
            sb.append(" is already granted!");
            Log.i(f10496e, sb.toString());
            return RequestPermissionCallable.Result.SUCCESS;
        }
        try {
            b().a();
            if (!c()) {
                Thread.sleep(1000L);
                if (!c()) {
                    String strA2 = a();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strA2).length() + 31);
                    sb2.append("Permission: ");
                    sb2.append(strA2);
                    sb2.append(" cannot be granted!");
                    Log.e(f10496e, sb2.toString());
                    return RequestPermissionCallable.Result.FAILURE;
                }
            }
            return RequestPermissionCallable.Result.SUCCESS;
        } catch (Throwable th) {
            if (!c()) {
                Thread.sleep(1000L);
                if (!c()) {
                    String strA3 = a();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(strA3).length() + 31);
                    sb3.append("Permission: ");
                    sb3.append(strA3);
                    sb3.append(" cannot be granted!");
                    Log.e(f10496e, sb3.toString());
                    return RequestPermissionCallable.Result.FAILURE;
                }
            }
            throw th;
        }
    }
}
