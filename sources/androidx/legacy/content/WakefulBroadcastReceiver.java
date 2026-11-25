package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.util.SparseArray;
import org.apache.commons.lang3.time.DateUtils;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8204a = "androidx.contentpager.content.wakelockid";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SparseArray<PowerManager.WakeLock> f8205b = new SparseArray<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f8206c = 1;

    public static boolean a(Intent intent) {
        int intExtra = intent.getIntExtra(f8204a, 0);
        if (intExtra == 0) {
            return false;
        }
        SparseArray<PowerManager.WakeLock> sparseArray = f8205b;
        synchronized (sparseArray) {
            PowerManager.WakeLock wakeLock = sparseArray.get(intExtra);
            if (wakeLock != null) {
                wakeLock.release();
                sparseArray.remove(intExtra);
                return true;
            }
            Log.w("WakefulBroadcastReceiv.", "No active wake lock id #" + intExtra);
            return true;
        }
    }

    public static ComponentName b(Context context, Intent intent) {
        SparseArray<PowerManager.WakeLock> sparseArray = f8205b;
        synchronized (sparseArray) {
            int i7 = f8206c;
            int i8 = i7 + 1;
            f8206c = i8;
            if (i8 <= 0) {
                f8206c = 1;
            }
            intent.putExtra(f8204a, i7);
            ComponentName componentNameStartService = context.startService(intent);
            if (componentNameStartService == null) {
                return null;
            }
            PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "androidx.core:wake:" + componentNameStartService.flattenToShortString());
            wakeLockNewWakeLock.setReferenceCounted(false);
            wakeLockNewWakeLock.acquire(DateUtils.MILLIS_PER_MINUTE);
            sparseArray.put(i7, wakeLockNewWakeLock);
            return componentNameStartService;
        }
    }
}
