package androidx.media;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.util.r;
import c.m0;

/* JADX INFO: loaded from: classes.dex */
class u implements j.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8683c = "MediaSessionManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean f8684d = j.f8670c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f8685e = "android.permission.STATUS_BAR_SERVICE";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8686f = "android.permission.MEDIA_CONTENT_CONTROL";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8687g = "enabled_notification_listeners";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f8688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ContentResolver f8689b;

    static class a implements j.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f8690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f8691b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8692c;

        a(String str, int i7, int i8) {
            this.f8690a = str;
            this.f8691b = i7;
            this.f8692c = i8;
        }

        @Override // androidx.media.j.c
        public String J() {
            return this.f8690a;
        }

        @Override // androidx.media.j.c
        public int a() {
            return this.f8692c;
        }

        @Override // androidx.media.j.c
        public int b() {
            return this.f8691b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f8690a, aVar.f8690a) && this.f8691b == aVar.f8691b && this.f8692c == aVar.f8692c;
        }

        public int hashCode() {
            return r.b(this.f8690a, Integer.valueOf(this.f8691b), Integer.valueOf(this.f8692c));
        }
    }

    u(Context context) {
        this.f8688a = context;
        this.f8689b = context.getContentResolver();
    }

    private boolean c(j.c cVar, String str) {
        if (cVar.b() < 0) {
            return this.f8688a.getPackageManager().checkPermission(str, cVar.J()) == 0;
        }
        return this.f8688a.checkPermission(str, cVar.b(), cVar.a()) == 0;
    }

    @Override // androidx.media.j.a
    public boolean a(@m0 j.c cVar) {
        try {
            if (this.f8688a.getPackageManager().getApplicationInfo(cVar.J(), 0).uid == cVar.a()) {
                return c(cVar, f8685e) || c(cVar, f8686f) || cVar.a() == 1000 || b(cVar);
            }
            if (f8684d) {
                Log.d(f8683c, "Package name " + cVar.J() + " doesn't match with the uid " + cVar.a());
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            if (f8684d) {
                Log.d(f8683c, "Package " + cVar.J() + " doesn't exist");
            }
            return false;
        }
    }

    boolean b(@m0 j.c cVar) {
        String string = Settings.Secure.getString(this.f8689b, f8687g);
        if (string != null) {
            for (String str : string.split(":")) {
                ComponentName componentNameUnflattenFromString = ComponentName.unflattenFromString(str);
                if (componentNameUnflattenFromString != null && componentNameUnflattenFromString.getPackageName().equals(cVar.J())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.media.j.a
    public Context d() {
        return this.f8688a;
    }
}
