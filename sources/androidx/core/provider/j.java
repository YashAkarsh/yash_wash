package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.graphics.a4;
import androidx.core.graphics.q2;
import androidx.core.util.w;
import c.e0;
import c.g1;
import c.m0;
import c.o0;
import c.t0;
import c.x0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static final String f6151a = "font_results";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    static final int f6152b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    static final int f6153c = -2;

    public static final class a implements BaseColumns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f6154a = "file_id";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f6155b = "font_ttc_index";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f6156c = "font_variation_settings";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f6157d = "font_weight";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f6158e = "font_italic";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f6159f = "result_code";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6160g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f6161h = 1;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f6162i = 2;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final int f6163j = 3;
    }

    public static class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6164c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6165d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6166e = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f6167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c[] f6168b;

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public b(int i7, @o0 c[] cVarArr) {
            this.f6167a = i7;
            this.f6168b = cVarArr;
        }

        static b a(int i7, @o0 c[] cVarArr) {
            return new b(i7, cVarArr);
        }

        public c[] b() {
            return this.f6168b;
        }

        public int c() {
            return this.f6167a;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f6169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f6171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f6172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f6173e;

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public c(@m0 Uri uri, @e0(from = 0) int i7, @e0(from = 1, to = 1000) int i8, boolean z7, int i9) {
            this.f6169a = (Uri) w.l(uri);
            this.f6170b = i7;
            this.f6171c = i8;
            this.f6172d = z7;
            this.f6173e = i9;
        }

        static c a(@m0 Uri uri, @e0(from = 0) int i7, @e0(from = 1, to = 1000) int i8, boolean z7, int i9) {
            return new c(uri, i7, i8, z7, i9);
        }

        public int b() {
            return this.f6173e;
        }

        @e0(from = 0)
        public int c() {
            return this.f6170b;
        }

        @m0
        public Uri d() {
            return this.f6169a;
        }

        @e0(from = 1, to = 1000)
        public int e() {
            return this.f6171c;
        }

        public boolean f() {
            return this.f6172d;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        @Deprecated
        public static final int f6174a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f6175b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f6176c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f6177d = -2;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f6178e = -3;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f6179f = -4;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f6180g = 1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int f6181h = 2;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int f6182i = 3;

        @x0({x0.a.LIBRARY_GROUP_PREFIX})
        @Retention(RetentionPolicy.SOURCE)
        public @interface a {
        }

        public void a(int i7) {
        }

        public void b(Typeface typeface) {
        }
    }

    private j() {
    }

    @o0
    public static Typeface a(@m0 Context context, @o0 CancellationSignal cancellationSignal, @m0 c[] cVarArr) {
        return q2.c(context, cancellationSignal, cVarArr, 0);
    }

    @m0
    public static b b(@m0 Context context, @o0 CancellationSignal cancellationSignal, @m0 h hVar) throws PackageManager.NameNotFoundException {
        return g.e(context, hVar, cancellationSignal);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Typeface c(Context context, h hVar, @o0 androidx.core.content.res.i.g gVar, @o0 Handler handler, boolean z7, int i7, int i8) {
        return f(context, hVar, i8, z7, i7, androidx.core.content.res.i.g.e(handler), new q2.a(gVar));
    }

    @o0
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @g1
    @Deprecated
    public static ProviderInfo d(@m0 PackageManager packageManager, @m0 h hVar, @o0 Resources resources) throws PackageManager.NameNotFoundException {
        return g.f(packageManager, hVar, resources);
    }

    @t0(19)
    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static Map<Uri, ByteBuffer> e(Context context, c[] cVarArr, CancellationSignal cancellationSignal) {
        return a4.h(context, cVarArr, cancellationSignal);
    }

    @o0
    @x0({x0.a.LIBRARY})
    public static Typeface f(@m0 Context context, @m0 h hVar, int i7, boolean z7, @e0(from = 0) int i8, @m0 Handler handler, @m0 d dVar) {
        androidx.core.provider.a aVar = new androidx.core.provider.a(dVar, handler);
        return z7 ? i.e(context, hVar, aVar, i7, i8) : i.d(context, hVar, i7, null, aVar);
    }

    public static void g(@m0 Context context, @m0 h hVar, @m0 d dVar, @m0 Handler handler) {
        androidx.core.provider.a aVar = new androidx.core.provider.a(dVar);
        i.d(context.getApplicationContext(), hVar, 0, k.b(handler), aVar);
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static void h() {
        i.f();
    }

    @x0({x0.a.TESTS})
    @g1
    public static void i() {
        i.f();
    }
}
