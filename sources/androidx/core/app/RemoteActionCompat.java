package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteActionCompat implements androidx.versionedparcelable.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @c.x0({c.x0.a.LIBRARY_GROUP})
    @c.m0
    public IconCompat f5083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @c.x0({c.x0.a.LIBRARY_GROUP})
    @c.m0
    public CharSequence f5084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.x0({c.x0.a.LIBRARY_GROUP})
    @c.m0
    public CharSequence f5085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @c.x0({c.x0.a.LIBRARY_GROUP})
    @c.m0
    public PendingIntent f5086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @c.x0({c.x0.a.LIBRARY_GROUP})
    public boolean f5087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @c.x0({c.x0.a.LIBRARY_GROUP})
    public boolean f5088f;

    @c.t0(26)
    static class a {
        private a() {
        }

        @c.t
        static RemoteAction a(Icon icon, CharSequence charSequence, CharSequence charSequence2, PendingIntent pendingIntent) {
            p6.a();
            return o6.a(icon, charSequence, charSequence2, pendingIntent);
        }

        @c.t
        static PendingIntent b(RemoteAction remoteAction) {
            return remoteAction.getActionIntent();
        }

        @c.t
        static CharSequence c(RemoteAction remoteAction) {
            return remoteAction.getContentDescription();
        }

        @c.t
        static Icon d(RemoteAction remoteAction) {
            return remoteAction.getIcon();
        }

        @c.t
        static CharSequence e(RemoteAction remoteAction) {
            return remoteAction.getTitle();
        }

        @c.t
        static boolean f(RemoteAction remoteAction) {
            return remoteAction.isEnabled();
        }

        @c.t
        static void g(RemoteAction remoteAction, boolean z7) {
            remoteAction.setEnabled(z7);
        }
    }

    @c.t0(28)
    static class b {
        private b() {
        }

        @c.t
        static void a(RemoteAction remoteAction, boolean z7) {
            remoteAction.setShouldShowIcon(z7);
        }

        @c.t
        static boolean b(RemoteAction remoteAction) {
            return remoteAction.shouldShowIcon();
        }
    }

    public RemoteActionCompat(@c.m0 IconCompat iconCompat, @c.m0 CharSequence charSequence, @c.m0 CharSequence charSequence2, @c.m0 PendingIntent pendingIntent) {
        this.f5083a = (IconCompat) androidx.core.util.w.l(iconCompat);
        this.f5084b = (CharSequence) androidx.core.util.w.l(charSequence);
        this.f5085c = (CharSequence) androidx.core.util.w.l(charSequence2);
        this.f5086d = (PendingIntent) androidx.core.util.w.l(pendingIntent);
        this.f5087e = true;
        this.f5088f = true;
    }

    @c.t0(26)
    @c.m0
    public static RemoteActionCompat g(@c.m0 RemoteAction remoteAction) {
        androidx.core.util.w.l(remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.m(a.d(remoteAction)), a.e(remoteAction), a.c(remoteAction), a.b(remoteAction));
        remoteActionCompat.m(a.f(remoteAction));
        if (Build.VERSION.SDK_INT >= 28) {
            remoteActionCompat.n(b.b(remoteAction));
        }
        return remoteActionCompat;
    }

    @c.m0
    public PendingIntent h() {
        return this.f5086d;
    }

    @c.m0
    public CharSequence i() {
        return this.f5085c;
    }

    @c.m0
    public IconCompat j() {
        return this.f5083a;
    }

    @c.m0
    public CharSequence k() {
        return this.f5084b;
    }

    public boolean l() {
        return this.f5087e;
    }

    public void m(boolean z7) {
        this.f5087e = z7;
    }

    public void n(boolean z7) {
        this.f5088f = z7;
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public boolean o() {
        return this.f5088f;
    }

    @c.t0(26)
    @c.m0
    public RemoteAction p() {
        RemoteAction remoteActionA = a.a(this.f5083a.L(), this.f5084b, this.f5085c, this.f5086d);
        a.g(remoteActionA, l());
        if (Build.VERSION.SDK_INT >= 28) {
            b.a(remoteActionA, o());
        }
        return remoteActionA;
    }

    @c.x0({c.x0.a.LIBRARY_GROUP})
    public RemoteActionCompat() {
    }

    public RemoteActionCompat(@c.m0 RemoteActionCompat remoteActionCompat) {
        androidx.core.util.w.l(remoteActionCompat);
        this.f5083a = remoteActionCompat.f5083a;
        this.f5084b = remoteActionCompat.f5084b;
        this.f5085c = remoteActionCompat.f5085c;
        this.f5086d = remoteActionCompat.f5086d;
        this.f5087e = remoteActionCompat.f5087e;
        this.f5088f = remoteActionCompat.f5088f;
    }
}
