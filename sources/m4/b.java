package m4;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static int a(Context context, float f8) {
        return (int) ((f8 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f8) {
        return (int) ((f8 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f8) {
        return (int) ((f8 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int d(Context context, float f8) {
        return (int) ((f8 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
