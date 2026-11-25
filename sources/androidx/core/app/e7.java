package androidx.core.app;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class e7 implements Iterable<Intent> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f5121c = "TaskStackBuilder";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<Intent> f5122a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f5123b;

    @c.t0(16)
    static class a {
        private a() {
        }

        @c.t
        static PendingIntent a(Context context, int i7, Intent[] intentArr, int i8, Bundle bundle) {
            return PendingIntent.getActivities(context, i7, intentArr, i8, bundle);
        }
    }

    public interface b {
        @c.o0
        Intent o();
    }

    private e7(Context context) {
        this.f5123b = context;
    }

    @c.m0
    public static e7 h(@c.m0 Context context) {
        return new e7(context);
    }

    @Deprecated
    public static e7 k(Context context) {
        return h(context);
    }

    @c.m0
    public e7 a(@c.m0 Intent intent) {
        this.f5122a.add(intent);
        return this;
    }

    @c.m0
    public e7 b(@c.m0 Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f5123b.getPackageManager());
        }
        if (component != null) {
            f(component);
        }
        a(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c.m0
    public e7 d(@c.m0 Activity activity) {
        Intent intentO = activity instanceof b ? ((b) activity).o() : null;
        if (intentO == null) {
            intentO = g0.a(activity);
        }
        if (intentO != null) {
            ComponentName component = intentO.getComponent();
            if (component == null) {
                component = intentO.resolveActivity(this.f5123b.getPackageManager());
            }
            f(component);
            a(intentO);
        }
        return this;
    }

    @c.m0
    public e7 f(@c.m0 ComponentName componentName) {
        int size = this.f5122a.size();
        try {
            Intent intentB = g0.b(this.f5123b, componentName);
            while (intentB != null) {
                this.f5122a.add(size, intentB);
                intentB = g0.b(this.f5123b, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e8) {
            Log.e(f5121c, "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e8);
        }
    }

    @c.m0
    public e7 g(@c.m0 Class<?> cls) {
        return f(new ComponentName(this.f5123b, cls));
    }

    @Override // java.lang.Iterable
    @c.m0
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f5122a.iterator();
    }

    @c.o0
    public Intent j(int i7) {
        return this.f5122a.get(i7);
    }

    @Deprecated
    public Intent l(int i7) {
        return j(i7);
    }

    public int m() {
        return this.f5122a.size();
    }

    @c.m0
    public Intent[] n() {
        int size = this.f5122a.size();
        Intent[] intentArr = new Intent[size];
        if (size == 0) {
            return intentArr;
        }
        intentArr[0] = new Intent(this.f5122a.get(0)).addFlags(268484608);
        for (int i7 = 1; i7 < size; i7++) {
            intentArr[i7] = new Intent(this.f5122a.get(i7));
        }
        return intentArr;
    }

    @c.o0
    public PendingIntent o(int i7, int i8) {
        return p(i7, i8, null);
    }

    @c.o0
    public PendingIntent p(int i7, int i8, @c.o0 Bundle bundle) {
        if (this.f5122a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
        }
        Intent[] intentArr = (Intent[]) this.f5122a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        return a.a(this.f5123b, i7, intentArr, i8, bundle);
    }

    public void r() {
        s(null);
    }

    public void s(@c.o0 Bundle bundle) {
        if (this.f5122a.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f5122a.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (androidx.core.content.d.s(this.f5123b, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.f5123b.startActivity(intent);
    }
}
