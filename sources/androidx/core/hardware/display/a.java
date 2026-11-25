package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import c.m0;
import c.o0;
import c.t;
import c.t0;
import com.facebook.internal.ServerProtocol;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap<Context, a> f5931b = new WeakHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f5932c = "android.hardware.display.category.PRESENTATION";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f5933a;

    /* JADX INFO: renamed from: androidx.core.hardware.display.a$a, reason: collision with other inner class name */
    @t0(17)
    static class C0063a {
        private C0063a() {
        }

        @t
        static Display a(DisplayManager displayManager, int i7) {
            return displayManager.getDisplay(i7);
        }

        @t
        static Display[] b(DisplayManager displayManager) {
            return displayManager.getDisplays();
        }
    }

    private a(Context context) {
        this.f5933a = context;
    }

    @m0
    public static a d(@m0 Context context) {
        a aVar;
        WeakHashMap<Context, a> weakHashMap = f5931b;
        synchronized (weakHashMap) {
            aVar = weakHashMap.get(context);
            if (aVar == null) {
                aVar = new a(context);
                weakHashMap.put(context, aVar);
            }
        }
        return aVar;
    }

    @o0
    public Display a(int i7) {
        return C0063a.a((DisplayManager) this.f5933a.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY), i7);
    }

    @m0
    public Display[] b() {
        return C0063a.b((DisplayManager) this.f5933a.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY));
    }

    @m0
    public Display[] c(@o0 String str) {
        return C0063a.b((DisplayManager) this.f5933a.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY));
    }
}
