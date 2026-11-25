package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.h1;
import androidx.appcompat.widget.o0;
import androidx.appcompat.widget.q1;
import androidx.appcompat.widget.r1;
import androidx.core.app.g0;
import androidx.core.view.n2;
import androidx.core.view.n4;
import androidx.core.view.p0;
import androidx.core.view.p4;
import androidx.core.view.q0;
import androidx.core.view.w5;
import androidx.core.view.z1;
import c.b0;
import c.b1;
import c.g1;
import c.m0;
import c.t0;
import c.x0;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY})
class AppCompatDelegateImpl extends androidx.appcompat.app.e implements androidx.appcompat.view.menu.g.a, LayoutInflater.Factory2 {
    private static final androidx.collection.i<String, Integer> N0 = new androidx.collection.i<>();
    private static final boolean O0 = false;
    private static final int[] P0 = {R.attr.windowBackground};
    private static final boolean Q0 = !"robolectric".equals(Build.FINGERPRINT);
    private static final boolean R0 = true;
    private static boolean S0 = false;
    static final String T0 = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    androidx.appcompat.view.b A;
    private int A0;
    ActionBarContextView B;
    private boolean B0;
    PopupWindow C;
    private boolean C0;
    Runnable D;
    private r D0;
    n4 E;
    private r E0;
    private boolean F;
    boolean F0;
    private boolean G;
    int G0;
    ViewGroup H;
    private final Runnable H0;
    private TextView I;
    private boolean I0;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private View f718J;
    private Rect J0;
    private boolean K;
    private Rect K0;
    private boolean L;
    private androidx.appcompat.app.n L0;
    boolean M;
    private androidx.appcompat.app.o M0;
    boolean N;
    boolean O;
    boolean P;
    boolean Q;
    private boolean R;
    private PanelFeatureState[] S;
    private PanelFeatureState T;
    private boolean U;
    private boolean V;
    private boolean W;
    boolean X;
    private Configuration Y;
    private int Z;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final Object f719p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final Context f720q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    Window f721r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private p f722s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final androidx.appcompat.app.d f723t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    ActionBar f724u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    MenuInflater f725v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private CharSequence f726w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private e0 f727x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private j f728y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private v f729z;

    protected static final class PanelFeatureState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f734e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f735f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ViewGroup f736g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        View f737h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        View f738i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        androidx.appcompat.view.menu.g f739j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        androidx.appcompat.view.menu.e f740k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Context f741l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f742m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f743n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f744o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f745p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        boolean f746q = false;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        boolean f747r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        boolean f748s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        Bundle f749t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        Bundle f750u;

        @SuppressLint({"BanParcelableUsage"})
        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f751a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            boolean f752b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Bundle f753c;

            class a implements Parcelable.ClassLoaderCreator<SavedState> {
                a() {
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public SavedState[] newArray(int i7) {
                    return new SavedState[i7];
                }
            }

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f751a = parcel.readInt();
                boolean z7 = parcel.readInt() == 1;
                savedState.f752b = z7;
                if (z7) {
                    savedState.f753c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i7) {
                parcel.writeInt(this.f751a);
                parcel.writeInt(this.f752b ? 1 : 0);
                if (this.f752b) {
                    parcel.writeBundle(this.f753c);
                }
            }
        }

        PanelFeatureState(int i7) {
            this.f730a = i7;
        }

        void a() {
            Bundle bundle;
            androidx.appcompat.view.menu.g gVar = this.f739j;
            if (gVar == null || (bundle = this.f749t) == null) {
                return;
            }
            gVar.U(bundle);
            this.f749t = null;
        }

        public void b() {
            androidx.appcompat.view.menu.g gVar = this.f739j;
            if (gVar != null) {
                gVar.S(this.f740k);
            }
            this.f740k = null;
        }

        androidx.appcompat.view.menu.o c(androidx.appcompat.view.menu.n.a aVar) {
            if (this.f739j == null) {
                return null;
            }
            if (this.f740k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f741l, androidx.appcompat.R.layout.abc_list_menu_item_layout);
                this.f740k = eVar;
                eVar.i(aVar);
                this.f739j.b(this.f740k);
            }
            return this.f740k.n(this.f736g);
        }

        public boolean d() {
            if (this.f737h == null) {
                return false;
            }
            return this.f738i != null || this.f740k.b().getCount() > 0;
        }

        void e(Parcelable parcelable) {
            SavedState savedState = (SavedState) parcelable;
            this.f730a = savedState.f751a;
            this.f748s = savedState.f752b;
            this.f749t = savedState.f753c;
            this.f737h = null;
            this.f736g = null;
        }

        Parcelable f() {
            SavedState savedState = new SavedState();
            savedState.f751a = this.f730a;
            savedState.f752b = this.f744o;
            if (this.f739j != null) {
                Bundle bundle = new Bundle();
                savedState.f753c = bundle;
                this.f739j.W(bundle);
            }
            return savedState;
        }

        void g(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f739j;
            if (gVar == gVar2) {
                return;
            }
            if (gVar2 != null) {
                gVar2.S(this.f740k);
            }
            this.f739j = gVar;
            if (gVar == null || (eVar = this.f740k) == null) {
                return;
            }
            gVar.b(eVar);
        }

        void h(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarPopupTheme, typedValue, true);
            int i7 = typedValue.resourceId;
            if (i7 != 0) {
                themeNewTheme.applyStyle(i7, true);
            }
            themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.panelMenuListTheme, typedValue, true);
            int i8 = typedValue.resourceId;
            if (i8 != 0) {
                themeNewTheme.applyStyle(i8, true);
            } else {
                themeNewTheme.applyStyle(androidx.appcompat.R.style.Theme_AppCompat_CompactMenu, true);
            }
            androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
            dVar.getTheme().setTo(themeNewTheme);
            this.f741l = dVar;
            TypedArray typedArrayObtainStyledAttributes = dVar.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
            this.f731b = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_panelBackground, 0);
            this.f735f = typedArrayObtainStyledAttributes.getResourceId(androidx.appcompat.R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    class a implements Thread.UncaughtExceptionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Thread.UncaughtExceptionHandler f754a;

        a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f754a = uncaughtExceptionHandler;
        }

        private boolean a(Throwable th) {
            String message;
            if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                return false;
            }
            return message.contains("drawable") || message.contains("Drawable");
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(@m0 Thread thread, @m0 Throwable th) {
            if (!a(th)) {
                this.f754a.uncaughtException(thread, th);
                return;
            }
            Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + AppCompatDelegateImpl.T0);
            notFoundException.initCause(th.getCause());
            notFoundException.setStackTrace(th.getStackTrace());
            this.f754a.uncaughtException(thread, notFoundException);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.G0 & 1) != 0) {
                appCompatDelegateImpl.h0(0);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl2.G0 & 4096) != 0) {
                appCompatDelegateImpl2.h0(108);
            }
            AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl3.F0 = false;
            appCompatDelegateImpl3.G0 = 0;
        }
    }

    class c implements z1 {
        c() {
        }

        @Override // androidx.core.view.z1
        public w5 a(View view, w5 w5Var) {
            int iR = w5Var.r();
            int iY0 = AppCompatDelegateImpl.this.Y0(w5Var, null);
            if (iR != iY0) {
                w5Var = w5Var.D(w5Var.p(), iY0, w5Var.q(), w5Var.o());
            }
            return n2.g1(view, w5Var);
        }
    }

    class d implements o0.a {
        d() {
        }

        @Override // androidx.appcompat.widget.o0.a
        public void a(Rect rect) {
            rect.top = AppCompatDelegateImpl.this.Y0(null, rect);
        }
    }

    class e implements ContentFrameLayout.a {
        e() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            AppCompatDelegateImpl.this.f0();
        }
    }

    class f implements Runnable {

        class a extends p4 {
            a() {
            }

            @Override // androidx.core.view.p4, androidx.core.view.o4
            public void b(View view) {
                AppCompatDelegateImpl.this.B.setAlpha(1.0f);
                AppCompatDelegateImpl.this.E.u(null);
                AppCompatDelegateImpl.this.E = null;
            }

            @Override // androidx.core.view.p4, androidx.core.view.o4
            public void c(View view) {
                AppCompatDelegateImpl.this.B.setVisibility(0);
            }
        }

        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            appCompatDelegateImpl.C.showAtLocation(appCompatDelegateImpl.B, 55, 0, 0);
            AppCompatDelegateImpl.this.i0();
            if (!AppCompatDelegateImpl.this.R0()) {
                AppCompatDelegateImpl.this.B.setAlpha(1.0f);
                AppCompatDelegateImpl.this.B.setVisibility(0);
            } else {
                AppCompatDelegateImpl.this.B.setAlpha(0.0f);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.E = n2.g(appCompatDelegateImpl2.B).b(1.0f);
                AppCompatDelegateImpl.this.E.u(new a());
            }
        }
    }

    class g extends p4 {
        g() {
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void b(View view) {
            AppCompatDelegateImpl.this.B.setAlpha(1.0f);
            AppCompatDelegateImpl.this.E.u(null);
            AppCompatDelegateImpl.this.E = null;
        }

        @Override // androidx.core.view.p4, androidx.core.view.o4
        public void c(View view) {
            AppCompatDelegateImpl.this.B.setVisibility(0);
            if (AppCompatDelegateImpl.this.B.getParent() instanceof View) {
                n2.v1((View) AppCompatDelegateImpl.this.B.getParent());
            }
        }
    }

    private class h implements androidx.appcompat.app.a.b {
        h() {
        }

        @Override // androidx.appcompat.app.a.b
        public void a(Drawable drawable, int i7) {
            ActionBar actionBarS = AppCompatDelegateImpl.this.s();
            if (actionBarS != null) {
                actionBarS.l0(drawable);
                actionBarS.i0(i7);
            }
        }

        @Override // androidx.appcompat.app.a.b
        public Drawable b() {
            h1 h1VarF = h1.F(e(), null, new int[]{androidx.appcompat.R.attr.homeAsUpIndicator});
            Drawable drawableH = h1VarF.h(0);
            h1VarF.I();
            return drawableH;
        }

        @Override // androidx.appcompat.app.a.b
        public void c(int i7) {
            ActionBar actionBarS = AppCompatDelegateImpl.this.s();
            if (actionBarS != null) {
                actionBarS.i0(i7);
            }
        }

        @Override // androidx.appcompat.app.a.b
        public boolean d() {
            ActionBar actionBarS = AppCompatDelegateImpl.this.s();
            return (actionBarS == null || (actionBarS.p() & 4) == 0) ? false : true;
        }

        @Override // androidx.appcompat.app.a.b
        public Context e() {
            return AppCompatDelegateImpl.this.n0();
        }
    }

    interface i {
        boolean a(int i7);

        @c.o0
        View onCreatePanelView(int i7);
    }

    private final class j implements androidx.appcompat.view.menu.n.a {
        j() {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public void d(@m0 androidx.appcompat.view.menu.g gVar, boolean z7) {
            AppCompatDelegateImpl.this.Z(gVar);
        }

        @Override // androidx.appcompat.view.menu.n.a
        public boolean e(@m0 androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackU0 = AppCompatDelegateImpl.this.u0();
            if (callbackU0 == null) {
                return true;
            }
            callbackU0.onMenuOpened(108, gVar);
            return true;
        }
    }

    class k implements androidx.appcompat.view.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private androidx.appcompat.view.b.a f764a;

        class a extends p4 {
            a() {
            }

            @Override // androidx.core.view.p4, androidx.core.view.o4
            public void b(View view) {
                AppCompatDelegateImpl.this.B.setVisibility(8);
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                PopupWindow popupWindow = appCompatDelegateImpl.C;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (appCompatDelegateImpl.B.getParent() instanceof View) {
                    n2.v1((View) AppCompatDelegateImpl.this.B.getParent());
                }
                AppCompatDelegateImpl.this.B.t();
                AppCompatDelegateImpl.this.E.u(null);
                AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl2.E = null;
                n2.v1(appCompatDelegateImpl2.H);
            }
        }

        public k(androidx.appcompat.view.b.a aVar) {
            this.f764a = aVar;
        }

        @Override // androidx.appcompat.view.b.a
        public void a(androidx.appcompat.view.b bVar) {
            this.f764a.a(bVar);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.C != null) {
                appCompatDelegateImpl.f721r.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.D);
            }
            AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl2.B != null) {
                appCompatDelegateImpl2.i0();
                AppCompatDelegateImpl appCompatDelegateImpl3 = AppCompatDelegateImpl.this;
                appCompatDelegateImpl3.E = n2.g(appCompatDelegateImpl3.B).b(0.0f);
                AppCompatDelegateImpl.this.E.u(new a());
            }
            AppCompatDelegateImpl appCompatDelegateImpl4 = AppCompatDelegateImpl.this;
            androidx.appcompat.app.d dVar = appCompatDelegateImpl4.f723t;
            if (dVar != null) {
                dVar.m(appCompatDelegateImpl4.A);
            }
            AppCompatDelegateImpl appCompatDelegateImpl5 = AppCompatDelegateImpl.this;
            appCompatDelegateImpl5.A = null;
            n2.v1(appCompatDelegateImpl5.H);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean b(androidx.appcompat.view.b bVar, Menu menu) {
            return this.f764a.b(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean c(androidx.appcompat.view.b bVar, Menu menu) {
            n2.v1(AppCompatDelegateImpl.this.H);
            return this.f764a.c(bVar, menu);
        }

        @Override // androidx.appcompat.view.b.a
        public boolean d(androidx.appcompat.view.b bVar, MenuItem menuItem) {
            return this.f764a.d(bVar, menuItem);
        }
    }

    @t0(17)
    static class l {
        private l() {
        }

        static Context a(@m0 Context context, @m0 Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void b(@m0 Configuration configuration, @m0 Configuration configuration2, @m0 Configuration configuration3) {
            int i7 = configuration.densityDpi;
            int i8 = configuration2.densityDpi;
            if (i7 != i8) {
                configuration3.densityDpi = i8;
            }
        }
    }

    @t0(21)
    static class m {
        private m() {
        }

        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    @t0(24)
    static class n {
        private n() {
        }

        static void a(@m0 Configuration configuration, @m0 Configuration configuration2, @m0 Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }
    }

    @t0(26)
    static class o {
        private o() {
        }

        static void a(@m0 Configuration configuration, @m0 Configuration configuration2, @m0 Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    class p extends androidx.appcompat.view.i {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private i f767b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f768c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f769d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f770e;

        p(Window.Callback callback) {
            super(callback);
        }

        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.f769d = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.f769d = false;
            }
        }

        public void c(Window.Callback callback) {
            try {
                this.f768c = true;
                callback.onContentChanged();
            } finally {
                this.f768c = false;
            }
        }

        public void d(Window.Callback callback, int i7, Menu menu) {
            try {
                this.f770e = true;
                callback.onPanelClosed(i7, menu);
            } finally {
                this.f770e = false;
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.f769d) {
                return a().dispatchKeyEvent(keyEvent);
            }
            return AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.F0(keyEvent.getKeyCode(), keyEvent);
        }

        void e(@c.o0 i iVar) {
            this.f767b = iVar;
        }

        final ActionMode f(ActionMode.Callback callback) {
            androidx.appcompat.view.f.a aVar = new androidx.appcompat.view.f.a(AppCompatDelegateImpl.this.f720q, callback);
            androidx.appcompat.view.b bVarT = AppCompatDelegateImpl.this.T(aVar);
            if (bVarT != null) {
                return aVar.e(bVarT);
            }
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onContentChanged() {
            if (this.f768c) {
                a().onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i7, Menu menu) {
            if (i7 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i7, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public View onCreatePanelView(int i7) {
            View viewOnCreatePanelView;
            i iVar = this.f767b;
            return (iVar == null || (viewOnCreatePanelView = iVar.onCreatePanelView(i7)) == null) ? super.onCreatePanelView(i7) : viewOnCreatePanelView;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onMenuOpened(int i7, Menu menu) {
            super.onMenuOpened(i7, menu);
            AppCompatDelegateImpl.this.I0(i7);
            return true;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public void onPanelClosed(int i7, Menu menu) {
            if (this.f770e) {
                a().onPanelClosed(i7, menu);
            } else {
                super.onPanelClosed(i7, menu);
                AppCompatDelegateImpl.this.J0(i7);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public boolean onPreparePanel(int i7, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i7 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.i0(true);
            }
            i iVar = this.f767b;
            boolean zOnPreparePanel = iVar != null && iVar.a(i7);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i7, view, menu);
            }
            if (gVar != null) {
                gVar.i0(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        @t0(24)
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i7) {
            androidx.appcompat.view.menu.g gVar;
            PanelFeatureState panelFeatureStateR0 = AppCompatDelegateImpl.this.r0(0, true);
            if (panelFeatureStateR0 == null || (gVar = panelFeatureStateR0.f739j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i7);
            } else {
                super.onProvideKeyboardShortcuts(list, gVar, i7);
            }
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        @t0(23)
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i7) {
            return (AppCompatDelegateImpl.this.x() && i7 == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i7);
        }
    }

    private class q extends r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final PowerManager f772c;

        q(Context context) {
            super();
            this.f772c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public int c() {
            return m.a(this.f772c) ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public void e() {
            AppCompatDelegateImpl.this.e();
        }
    }

    @x0({x0.a.LIBRARY})
    @g1
    abstract class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BroadcastReceiver f774a;

        class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                r.this.e();
            }
        }

        r() {
        }

        void a() {
            BroadcastReceiver broadcastReceiver = this.f774a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f720q.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f774a = null;
            }
        }

        @c.o0
        abstract IntentFilter b();

        abstract int c();

        boolean d() {
            return this.f774a != null;
        }

        abstract void e();

        void f() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f774a == null) {
                this.f774a = new a();
            }
            AppCompatDelegateImpl.this.f720q.registerReceiver(this.f774a, intentFilterB);
        }
    }

    private class s extends r {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.appcompat.app.t f777c;

        s(androidx.appcompat.app.t tVar) {
            super();
            this.f777c = tVar;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public int c() {
            return this.f777c.d() ? 2 : 1;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.r
        public void e() {
            AppCompatDelegateImpl.this.e();
        }
    }

    @t0(17)
    private static class t {
        private t() {
        }

        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class u extends ContentFrameLayout {
        public u(Context context) {
            super(context);
        }

        private boolean b(int i7, int i8) {
            return i7 < -5 || i8 < -5 || i7 > getWidth() + 5 || i8 > getHeight() + 5;
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.g0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.b0(0);
            return true;
        }

        @Override // android.view.View
        public void setBackgroundResource(int i7) {
            setBackgroundDrawable(e.a.b(getContext(), i7));
        }
    }

    private final class v implements androidx.appcompat.view.menu.n.a {
        v() {
        }

        @Override // androidx.appcompat.view.menu.n.a
        public void d(@m0 androidx.appcompat.view.menu.g gVar, boolean z7) {
            androidx.appcompat.view.menu.g gVarG = gVar.G();
            boolean z8 = gVarG != gVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z8) {
                gVar = gVarG;
            }
            PanelFeatureState panelFeatureStateL0 = appCompatDelegateImpl.l0(gVar);
            if (panelFeatureStateL0 != null) {
                if (!z8) {
                    AppCompatDelegateImpl.this.c0(panelFeatureStateL0, z7);
                } else {
                    AppCompatDelegateImpl.this.Y(panelFeatureStateL0.f730a, panelFeatureStateL0, gVarG);
                    AppCompatDelegateImpl.this.c0(panelFeatureStateL0, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.n.a
        public boolean e(@m0 androidx.appcompat.view.menu.g gVar) {
            Window.Callback callbackU0;
            if (gVar != gVar.G()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.M || (callbackU0 = appCompatDelegateImpl.u0()) == null || AppCompatDelegateImpl.this.X) {
                return true;
            }
            callbackU0.onMenuOpened(108, gVar);
            return true;
        }
    }

    AppCompatDelegateImpl(Activity activity, androidx.appcompat.app.d dVar) {
        this(activity, null, dVar, activity);
    }

    private boolean A0(Context context) {
        int i7;
        if (!this.C0 && (this.f719p instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 29) {
                    i7 = 269221888;
                } else {
                    i7 = i8 >= 24 ? 786432 : 0;
                }
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.f719p.getClass()), i7);
                this.B0 = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e8) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e8);
                this.B0 = false;
            }
        }
        this.C0 = true;
        return this.B0;
    }

    private boolean E0(int i7, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState panelFeatureStateR0 = r0(i7, true);
        if (panelFeatureStateR0.f744o) {
            return false;
        }
        return O0(panelFeatureStateR0, keyEvent);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    private boolean H0(int i7, KeyEvent keyEvent) {
        boolean zO0;
        e0 e0Var;
        if (this.A != null) {
            return false;
        }
        boolean zJ = true;
        PanelFeatureState panelFeatureStateR0 = r0(i7, true);
        if (i7 != 0 || (e0Var = this.f727x) == null || !e0Var.g() || ViewConfiguration.get(this.f720q).hasPermanentMenuKey()) {
            boolean z7 = panelFeatureStateR0.f744o;
            if (z7 || panelFeatureStateR0.f743n) {
                c0(panelFeatureStateR0, true);
                zJ = z7;
            } else if (panelFeatureStateR0.f742m) {
                if (panelFeatureStateR0.f747r) {
                    panelFeatureStateR0.f742m = false;
                    zO0 = O0(panelFeatureStateR0, keyEvent);
                } else {
                    zO0 = true;
                }
                if (zO0) {
                    L0(panelFeatureStateR0, keyEvent);
                } else {
                    zJ = false;
                }
            } else {
                zJ = false;
            }
        } else if (this.f727x.b()) {
            zJ = this.f727x.j();
        } else if (this.X || !O0(panelFeatureStateR0, keyEvent)) {
            zJ = false;
        } else {
            zJ = this.f727x.k();
        }
        if (zJ) {
            AudioManager audioManager = (AudioManager) this.f720q.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return zJ;
    }

    private void L0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i7;
        ViewGroup.LayoutParams layoutParams;
        if (panelFeatureState.f744o || this.X) {
            return;
        }
        if (panelFeatureState.f730a == 0) {
            if ((this.f720q.getResources().getConfiguration().screenLayout & 15) == 4) {
                return;
            }
        }
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null && !callbackU0.onMenuOpened(panelFeatureState.f730a, panelFeatureState.f739j)) {
            c0(panelFeatureState, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f720q.getSystemService("window");
        if (windowManager != null && O0(panelFeatureState, keyEvent)) {
            ViewGroup viewGroup = panelFeatureState.f736g;
            if (viewGroup != null && !panelFeatureState.f746q) {
                View view = panelFeatureState.f738i;
                if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                    i7 = -1;
                }
                panelFeatureState.f743n = false;
                WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i7, -2, panelFeatureState.f733d, panelFeatureState.f734e, 1002, 8519680, -3);
                layoutParams2.gravity = panelFeatureState.f732c;
                layoutParams2.windowAnimations = panelFeatureState.f735f;
                windowManager.addView(panelFeatureState.f736g, layoutParams2);
                panelFeatureState.f744o = true;
            }
            if (viewGroup == null) {
                if (!x0(panelFeatureState) || panelFeatureState.f736g == null) {
                    return;
                }
            } else if (panelFeatureState.f746q && viewGroup.getChildCount() > 0) {
                panelFeatureState.f736g.removeAllViews();
            }
            if (!w0(panelFeatureState) || !panelFeatureState.d()) {
                panelFeatureState.f746q = true;
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = panelFeatureState.f737h.getLayoutParams();
            if (layoutParams3 == null) {
                layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
            }
            panelFeatureState.f736g.setBackgroundResource(panelFeatureState.f731b);
            ViewParent parent = panelFeatureState.f737h.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(panelFeatureState.f737h);
            }
            panelFeatureState.f736g.addView(panelFeatureState.f737h, layoutParams3);
            if (!panelFeatureState.f737h.hasFocus()) {
                panelFeatureState.f737h.requestFocus();
            }
            i7 = -2;
            panelFeatureState.f743n = false;
            WindowManager.LayoutParams layoutParams4 = new WindowManager.LayoutParams(i7, -2, panelFeatureState.f733d, panelFeatureState.f734e, 1002, 8519680, -3);
            layoutParams4.gravity = panelFeatureState.f732c;
            layoutParams4.windowAnimations = panelFeatureState.f735f;
            windowManager.addView(panelFeatureState.f736g, layoutParams4);
            panelFeatureState.f744o = true;
        }
    }

    private boolean N0(PanelFeatureState panelFeatureState, int i7, KeyEvent keyEvent, int i8) {
        androidx.appcompat.view.menu.g gVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f742m || O0(panelFeatureState, keyEvent)) && (gVar = panelFeatureState.f739j) != null) {
            zPerformShortcut = gVar.performShortcut(i7, keyEvent, i8);
        }
        if (zPerformShortcut && (i8 & 1) == 0 && this.f727x == null) {
            c0(panelFeatureState, true);
        }
        return zPerformShortcut;
    }

    private boolean O0(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        e0 e0Var;
        e0 e0Var2;
        e0 e0Var3;
        if (this.X) {
            return false;
        }
        if (panelFeatureState.f742m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.T;
        if (panelFeatureState2 != null && panelFeatureState2 != panelFeatureState) {
            c0(panelFeatureState2, false);
        }
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null) {
            panelFeatureState.f738i = callbackU0.onCreatePanelView(panelFeatureState.f730a);
        }
        int i7 = panelFeatureState.f730a;
        boolean z7 = i7 == 0 || i7 == 108;
        if (z7 && (e0Var3 = this.f727x) != null) {
            e0Var3.setMenuPrepared();
        }
        if (panelFeatureState.f738i == null && (!z7 || !(M0() instanceof androidx.appcompat.app.r))) {
            androidx.appcompat.view.menu.g gVar = panelFeatureState.f739j;
            if (gVar == null || panelFeatureState.f747r) {
                if (gVar == null && (!y0(panelFeatureState) || panelFeatureState.f739j == null)) {
                    return false;
                }
                if (z7 && this.f727x != null) {
                    if (this.f728y == null) {
                        this.f728y = new j();
                    }
                    this.f727x.setMenu(panelFeatureState.f739j, this.f728y);
                }
                panelFeatureState.f739j.m0();
                if (!callbackU0.onCreatePanelMenu(panelFeatureState.f730a, panelFeatureState.f739j)) {
                    panelFeatureState.g(null);
                    if (z7 && (e0Var = this.f727x) != null) {
                        e0Var.setMenu(null, this.f728y);
                    }
                    return false;
                }
                panelFeatureState.f747r = false;
            }
            panelFeatureState.f739j.m0();
            Bundle bundle = panelFeatureState.f750u;
            if (bundle != null) {
                panelFeatureState.f739j.T(bundle);
                panelFeatureState.f750u = null;
            }
            if (!callbackU0.onPreparePanel(0, panelFeatureState.f738i, panelFeatureState.f739j)) {
                if (z7 && (e0Var2 = this.f727x) != null) {
                    e0Var2.setMenu(null, this.f728y);
                }
                panelFeatureState.f739j.l0();
                return false;
            }
            boolean z8 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f745p = z8;
            panelFeatureState.f739j.setQwertyMode(z8);
            panelFeatureState.f739j.l0();
        }
        panelFeatureState.f742m = true;
        panelFeatureState.f743n = false;
        this.T = panelFeatureState;
        return true;
    }

    private void P0(boolean z7) {
        e0 e0Var = this.f727x;
        if (e0Var == null || !e0Var.g() || (ViewConfiguration.get(this.f720q).hasPermanentMenuKey() && !this.f727x.i())) {
            PanelFeatureState panelFeatureStateR0 = r0(0, true);
            panelFeatureStateR0.f746q = true;
            c0(panelFeatureStateR0, false);
            L0(panelFeatureStateR0, null);
            return;
        }
        Window.Callback callbackU0 = u0();
        if (this.f727x.b() && z7) {
            this.f727x.j();
            if (this.X) {
                return;
            }
            callbackU0.onPanelClosed(108, r0(0, true).f739j);
            return;
        }
        if (callbackU0 == null || this.X) {
            return;
        }
        if (this.F0 && (this.G0 & 1) != 0) {
            this.f721r.getDecorView().removeCallbacks(this.H0);
            this.H0.run();
        }
        PanelFeatureState panelFeatureStateR1 = r0(0, true);
        androidx.appcompat.view.menu.g gVar = panelFeatureStateR1.f739j;
        if (gVar == null || panelFeatureStateR1.f747r || !callbackU0.onPreparePanel(0, panelFeatureStateR1.f738i, gVar)) {
            return;
        }
        callbackU0.onMenuOpened(108, panelFeatureStateR1.f739j);
        this.f727x.k();
    }

    private int Q0(int i7) {
        if (i7 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        if (i7 != 9) {
            return i7;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return 109;
    }

    private boolean S0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f721r.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || n2.O0((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean U(boolean z7) {
        if (this.X) {
            return false;
        }
        int iX = X();
        boolean zW0 = W0(B0(this.f720q, iX), z7);
        if (iX == 0) {
            q0(this.f720q).f();
        } else {
            r rVar = this.D0;
            if (rVar != null) {
                rVar.a();
            }
        }
        if (iX == 3) {
            o0(this.f720q).f();
        } else {
            r rVar2 = this.E0;
            if (rVar2 != null) {
                rVar2.a();
            }
        }
        return zW0;
    }

    private void U0() {
        if (this.G) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void V() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.H.findViewById(R.id.content);
        View decorView = this.f721r.getDecorView();
        contentFrameLayout.setDecorPadding(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.f720q.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    @c.o0
    private AppCompatActivity V0() {
        for (Context baseContext = this.f720q; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof AppCompatActivity) {
                return (AppCompatActivity) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    private void W(@m0 Window window) {
        if (this.f721r != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof p) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        p pVar = new p(callback);
        this.f722s = pVar;
        window.setCallback(pVar);
        h1 h1VarF = h1.F(this.f720q, null, P0);
        Drawable drawableI = h1VarF.i(0);
        if (drawableI != null) {
            window.setBackgroundDrawable(drawableI);
        }
        h1VarF.I();
        this.f721r = window;
    }

    private boolean W0(int i7, boolean z7) {
        boolean z8 = false;
        Configuration configurationD0 = d0(this.f720q, i7, null, false);
        boolean zA0 = A0(this.f720q);
        Configuration configuration = this.Y;
        if (configuration == null) {
            configuration = this.f720q.getResources().getConfiguration();
        }
        int i8 = configuration.uiMode & 48;
        int i9 = configurationD0.uiMode & 48;
        boolean z9 = true;
        if (i8 != i9 && z7 && !zA0 && this.V && (Q0 || this.W)) {
            Object obj = this.f719p;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                androidx.core.app.b.E((Activity) this.f719p);
                z8 = true;
            }
        }
        if (z8 || i8 == i9) {
            z9 = z8;
        } else {
            X0(i9, zA0, null);
        }
        if (z9) {
            Object obj2 = this.f719p;
            if (obj2 instanceof AppCompatActivity) {
                ((AppCompatActivity) obj2).M(i7);
            }
        }
        return z9;
    }

    private int X() {
        int i7 = this.Z;
        return i7 != -100 ? i7 : androidx.appcompat.app.e.o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void X0(int i7, boolean z7, @c.o0 Configuration configuration) {
        Resources resources = this.f720q.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i7 | (resources.getConfiguration().uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            androidx.appcompat.app.q.a(resources);
        }
        int i8 = this.A0;
        if (i8 != 0) {
            this.f720q.setTheme(i8);
            this.f720q.getTheme().applyStyle(this.A0, true);
        }
        if (z7) {
            Object obj = this.f719p;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.q) {
                    if (((androidx.lifecycle.q) activity).getLifecycle().b().a(androidx.lifecycle.m.c.CREATED)) {
                        activity.onConfigurationChanged(configuration2);
                    }
                } else {
                    if (!this.W || this.X) {
                        return;
                    }
                    activity.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void Z0(View view) {
        view.setBackgroundColor((n2.C0(view) & 8192) != 0 ? androidx.core.content.d.f(this.f720q, androidx.appcompat.R.color.abc_decor_view_status_guard_light) : androidx.core.content.d.f(this.f720q, androidx.appcompat.R.color.abc_decor_view_status_guard));
    }

    private void a0() {
        r rVar = this.D0;
        if (rVar != null) {
            rVar.a();
        }
        r rVar2 = this.E0;
        if (rVar2 != null) {
            rVar2.a();
        }
    }

    @m0
    private Configuration d0(@m0 Context context, int i7, @c.o0 Configuration configuration, boolean z7) {
        int i8;
        if (i7 == 1) {
            i8 = 16;
        } else if (i7 != 2) {
            i8 = z7 ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48;
        } else {
            i8 = 32;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i8 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    private ViewGroup e0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.f720q.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            I(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            I(108);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            I(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            I(10);
        }
        this.P = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        k0();
        this.f721r.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f720q);
        if (this.Q) {
            viewGroup = this.O ? (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.P) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.N = false;
            this.M = false;
        } else if (this.M) {
            TypedValue typedValue = new TypedValue();
            this.f720q.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new androidx.appcompat.view.d(this.f720q, typedValue.resourceId) : this.f720q).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
            e0 e0Var = (e0) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
            this.f727x = e0Var;
            e0Var.setWindowCallback(u0());
            if (this.N) {
                this.f727x.m(109);
            }
            if (this.K) {
                this.f727x.m(2);
            }
            if (this.L) {
                this.f727x.m(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.M + ", windowActionBarOverlay: " + this.N + ", android:windowIsFloating: " + this.P + ", windowActionModeOverlay: " + this.O + ", windowNoTitle: " + this.Q + " }");
        }
        n2.a2(viewGroup, new c());
        if (this.f727x == null) {
            this.I = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
        }
        r1.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f721r.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f721r.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new e());
        return viewGroup;
    }

    private void j0() {
        if (this.G) {
            return;
        }
        this.H = e0();
        CharSequence charSequenceT0 = t0();
        if (!TextUtils.isEmpty(charSequenceT0)) {
            e0 e0Var = this.f727x;
            if (e0Var != null) {
                e0Var.setWindowTitle(charSequenceT0);
            } else if (M0() != null) {
                M0().B0(charSequenceT0);
            } else {
                TextView textView = this.I;
                if (textView != null) {
                    textView.setText(charSequenceT0);
                }
            }
        }
        V();
        K0(this.H);
        this.G = true;
        PanelFeatureState panelFeatureStateR0 = r0(0, false);
        if (this.X) {
            return;
        }
        if (panelFeatureStateR0 == null || panelFeatureStateR0.f739j == null) {
            z0(108);
        }
    }

    private void k0() {
        if (this.f721r == null) {
            Object obj = this.f719p;
            if (obj instanceof Activity) {
                W(((Activity) obj).getWindow());
            }
        }
        if (this.f721r == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    @m0
    private static Configuration m0(@m0 Configuration configuration, @c.o0 Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f8 = configuration.fontScale;
            float f9 = configuration2.fontScale;
            if (f8 != f9) {
                configuration3.fontScale = f9;
            }
            int i7 = configuration.mcc;
            int i8 = configuration2.mcc;
            if (i7 != i8) {
                configuration3.mcc = i8;
            }
            int i9 = configuration.mnc;
            int i10 = configuration2.mnc;
            if (i9 != i10) {
                configuration3.mnc = i10;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                n.a(configuration, configuration2, configuration3);
            } else if (!androidx.core.util.r.a(configuration.locale, configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            int i12 = configuration.touchscreen;
            int i13 = configuration2.touchscreen;
            if (i12 != i13) {
                configuration3.touchscreen = i13;
            }
            int i14 = configuration.keyboard;
            int i15 = configuration2.keyboard;
            if (i14 != i15) {
                configuration3.keyboard = i15;
            }
            int i16 = configuration.keyboardHidden;
            int i17 = configuration2.keyboardHidden;
            if (i16 != i17) {
                configuration3.keyboardHidden = i17;
            }
            int i18 = configuration.navigation;
            int i19 = configuration2.navigation;
            if (i18 != i19) {
                configuration3.navigation = i19;
            }
            int i20 = configuration.navigationHidden;
            int i21 = configuration2.navigationHidden;
            if (i20 != i21) {
                configuration3.navigationHidden = i21;
            }
            int i22 = configuration.orientation;
            int i23 = configuration2.orientation;
            if (i22 != i23) {
                configuration3.orientation = i23;
            }
            int i24 = configuration.screenLayout & 15;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 15)) {
                configuration3.screenLayout |= i25 & 15;
            }
            int i26 = configuration.screenLayout & com.alibaba.fastjson.asm.j.f12606c0;
            int i27 = configuration2.screenLayout;
            if (i26 != (i27 & com.alibaba.fastjson.asm.j.f12606c0)) {
                configuration3.screenLayout |= i27 & com.alibaba.fastjson.asm.j.f12606c0;
            }
            int i28 = configuration.screenLayout & 48;
            int i29 = configuration2.screenLayout;
            if (i28 != (i29 & 48)) {
                configuration3.screenLayout |= i29 & 48;
            }
            int i30 = configuration.screenLayout & 768;
            int i31 = configuration2.screenLayout;
            if (i30 != (i31 & 768)) {
                configuration3.screenLayout |= i31 & 768;
            }
            if (i11 >= 26) {
                o.a(configuration, configuration2, configuration3);
            }
            int i32 = configuration.uiMode & 15;
            int i33 = configuration2.uiMode;
            if (i32 != (i33 & 15)) {
                configuration3.uiMode |= i33 & 15;
            }
            int i34 = configuration.uiMode & 48;
            int i35 = configuration2.uiMode;
            if (i34 != (i35 & 48)) {
                configuration3.uiMode |= i35 & 48;
            }
            int i36 = configuration.screenWidthDp;
            int i37 = configuration2.screenWidthDp;
            if (i36 != i37) {
                configuration3.screenWidthDp = i37;
            }
            int i38 = configuration.screenHeightDp;
            int i39 = configuration2.screenHeightDp;
            if (i38 != i39) {
                configuration3.screenHeightDp = i39;
            }
            int i40 = configuration.smallestScreenWidthDp;
            int i41 = configuration2.smallestScreenWidthDp;
            if (i40 != i41) {
                configuration3.smallestScreenWidthDp = i41;
            }
            l.b(configuration, configuration2, configuration3);
        }
        return configuration3;
    }

    private r o0(@m0 Context context) {
        if (this.E0 == null) {
            this.E0 = new q(context);
        }
        return this.E0;
    }

    private r q0(@m0 Context context) {
        if (this.D0 == null) {
            this.D0 = new s(androidx.appcompat.app.t.a(context));
        }
        return this.D0;
    }

    private void v0() {
        j0();
        if (this.M && this.f724u == null) {
            Object obj = this.f719p;
            if (obj instanceof Activity) {
                this.f724u = new androidx.appcompat.app.u((Activity) this.f719p, this.N);
            } else if (obj instanceof Dialog) {
                this.f724u = new androidx.appcompat.app.u((Dialog) this.f719p);
            }
            ActionBar actionBar = this.f724u;
            if (actionBar != null) {
                actionBar.X(this.I0);
            }
        }
    }

    private boolean w0(PanelFeatureState panelFeatureState) {
        View view = panelFeatureState.f738i;
        if (view != null) {
            panelFeatureState.f737h = view;
            return true;
        }
        if (panelFeatureState.f739j == null) {
            return false;
        }
        if (this.f729z == null) {
            this.f729z = new v();
        }
        View view2 = (View) panelFeatureState.c(this.f729z);
        panelFeatureState.f737h = view2;
        return view2 != null;
    }

    private boolean x0(PanelFeatureState panelFeatureState) {
        panelFeatureState.h(n0());
        panelFeatureState.f736g = new u(panelFeatureState.f741l);
        panelFeatureState.f732c = 81;
        return true;
    }

    private boolean y0(PanelFeatureState panelFeatureState) {
        Resources.Theme themeNewTheme;
        Context context = this.f720q;
        int i7 = panelFeatureState.f730a;
        if ((i7 == 0 || i7 == 108) && this.f727x != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, 0);
                dVar.getTheme().setTo(themeNewTheme);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.X(this);
        panelFeatureState.g(gVar);
        return true;
    }

    private void z0(int i7) {
        this.G0 = (1 << i7) | this.G0;
        if (this.F0) {
            return;
        }
        n2.p1(this.f721r.getDecorView(), this.H0);
        this.F0 = true;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0045  */
    @Override // androidx.appcompat.app.e
    public void A() {
        if (this.f719p instanceof Activity) {
            androidx.appcompat.app.e.G(this);
        }
        if (this.F0) {
            this.f721r.getDecorView().removeCallbacks(this.H0);
        }
        this.X = true;
        if (this.Z != -100) {
            Object obj = this.f719p;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                N0.put(this.f719p.getClass().getName(), Integer.valueOf(this.Z));
            } else {
                N0.remove(this.f719p.getClass().getName());
            }
        } else {
            N0.remove(this.f719p.getClass().getName());
        }
        ActionBar actionBar = this.f724u;
        if (actionBar != null) {
            actionBar.J();
        }
        a0();
    }

    @Override // androidx.appcompat.app.e
    public void B(Bundle bundle) {
        j0();
    }

    int B0(@m0 Context context, int i7) {
        if (i7 == -100) {
            return -1;
        }
        if (i7 != -1) {
            if (i7 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return q0(context).c();
            }
            if (i7 != 1 && i7 != 2) {
                if (i7 == 3) {
                    return o0(context).c();
                }
                throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
            }
        }
        return i7;
    }

    @Override // androidx.appcompat.app.e
    public void C() {
        ActionBar actionBarS = s();
        if (actionBarS != null) {
            actionBarS.u0(true);
        }
    }

    boolean C0() {
        androidx.appcompat.view.b bVar = this.A;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        ActionBar actionBarS = s();
        return actionBarS != null && actionBarS.m();
    }

    @Override // androidx.appcompat.app.e
    public void D(Bundle bundle) {
    }

    boolean D0(int i7, KeyEvent keyEvent) {
        if (i7 == 4) {
            this.U = (keyEvent.getFlags() & 128) != 0;
        } else if (i7 == 82) {
            E0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void E() {
        e();
    }

    @Override // androidx.appcompat.app.e
    public void F() {
        ActionBar actionBarS = s();
        if (actionBarS != null) {
            actionBarS.u0(false);
        }
    }

    boolean F0(int i7, KeyEvent keyEvent) {
        ActionBar actionBarS = s();
        if (actionBarS != null && actionBarS.K(i7, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.T;
        if (panelFeatureState != null && N0(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            PanelFeatureState panelFeatureState2 = this.T;
            if (panelFeatureState2 != null) {
                panelFeatureState2.f743n = true;
            }
            return true;
        }
        if (this.T == null) {
            PanelFeatureState panelFeatureStateR0 = r0(0, true);
            O0(panelFeatureStateR0, keyEvent);
            boolean zN0 = N0(panelFeatureStateR0, keyEvent.getKeyCode(), keyEvent, 1);
            panelFeatureStateR0.f742m = false;
            if (zN0) {
                return true;
            }
        }
        return false;
    }

    boolean G0(int i7, KeyEvent keyEvent) {
        if (i7 == 4) {
            boolean z7 = this.U;
            this.U = false;
            PanelFeatureState panelFeatureStateR0 = r0(0, false);
            if (panelFeatureStateR0 != null && panelFeatureStateR0.f744o) {
                if (!z7) {
                    c0(panelFeatureStateR0, true);
                }
                return true;
            }
            if (C0()) {
                return true;
            }
        } else if (i7 == 82) {
            H0(0, keyEvent);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.app.e
    public boolean I(int i7) {
        int iQ0 = Q0(i7);
        if (this.Q && iQ0 == 108) {
            return false;
        }
        if (this.M && iQ0 == 1) {
            this.M = false;
        }
        if (iQ0 == 1) {
            U0();
            this.Q = true;
            return true;
        }
        if (iQ0 == 2) {
            U0();
            this.K = true;
            return true;
        }
        if (iQ0 == 5) {
            U0();
            this.L = true;
            return true;
        }
        if (iQ0 == 10) {
            U0();
            this.O = true;
            return true;
        }
        if (iQ0 == 108) {
            U0();
            this.M = true;
            return true;
        }
        if (iQ0 != 109) {
            return this.f721r.requestFeature(iQ0);
        }
        U0();
        this.N = true;
        return true;
    }

    void I0(int i7) {
        ActionBar actionBarS;
        if (i7 != 108 || (actionBarS = s()) == null) {
            return;
        }
        actionBarS.n(true);
    }

    void J0(int i7) {
        if (i7 == 108) {
            ActionBar actionBarS = s();
            if (actionBarS != null) {
                actionBarS.n(false);
                return;
            }
            return;
        }
        if (i7 == 0) {
            PanelFeatureState panelFeatureStateR0 = r0(i7, true);
            if (panelFeatureStateR0.f744o) {
                c0(panelFeatureStateR0, false);
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void K(int i7) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.H.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f720q).inflate(i7, viewGroup);
        this.f722s.c(this.f721r.getCallback());
    }

    void K0(ViewGroup viewGroup) {
    }

    @Override // androidx.appcompat.app.e
    public void L(View view) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.H.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f722s.c(this.f721r.getCallback());
    }

    @Override // androidx.appcompat.app.e
    public void M(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ViewGroup viewGroup = (ViewGroup) this.H.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f722s.c(this.f721r.getCallback());
    }

    final ActionBar M0() {
        return this.f724u;
    }

    @Override // androidx.appcompat.app.e
    public void O(boolean z7) {
        this.F = z7;
    }

    @Override // androidx.appcompat.app.e
    @t0(17)
    public void P(int i7) {
        if (this.Z != i7) {
            this.Z = i7;
            if (this.V) {
                e();
            }
        }
    }

    @Override // androidx.appcompat.app.e
    public void Q(Toolbar toolbar) {
        if (this.f719p instanceof Activity) {
            ActionBar actionBarS = s();
            if (actionBarS instanceof androidx.appcompat.app.u) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.f725v = null;
            if (actionBarS != null) {
                actionBarS.J();
            }
            this.f724u = null;
            if (toolbar != null) {
                androidx.appcompat.app.r rVar = new androidx.appcompat.app.r(toolbar, t0(), this.f722s);
                this.f724u = rVar;
                this.f722s.e(rVar.f852k);
            } else {
                this.f722s.e(null);
            }
            v();
        }
    }

    @Override // androidx.appcompat.app.e
    public void R(@b1 int i7) {
        this.A0 = i7;
    }

    final boolean R0() {
        ViewGroup viewGroup;
        return this.G && (viewGroup = this.H) != null && n2.U0(viewGroup);
    }

    @Override // androidx.appcompat.app.e
    public final void S(CharSequence charSequence) {
        this.f726w = charSequence;
        e0 e0Var = this.f727x;
        if (e0Var != null) {
            e0Var.setWindowTitle(charSequence);
            return;
        }
        if (M0() != null) {
            M0().B0(charSequence);
            return;
        }
        TextView textView = this.I;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.view.b T(@m0 androidx.appcompat.view.b.a aVar) {
        androidx.appcompat.app.d dVar;
        if (aVar == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        androidx.appcompat.view.b bVar = this.A;
        if (bVar != null) {
            bVar.c();
        }
        k kVar = new k(aVar);
        ActionBar actionBarS = s();
        if (actionBarS != null) {
            androidx.appcompat.view.b bVarD0 = actionBarS.D0(kVar);
            this.A = bVarD0;
            if (bVarD0 != null && (dVar = this.f723t) != null) {
                dVar.l(bVarD0);
            }
        }
        if (this.A == null) {
            this.A = T0(kVar);
        }
        return this.A;
    }

    androidx.appcompat.view.b T0(@m0 androidx.appcompat.view.b.a aVar) {
        androidx.appcompat.view.b bVarQ;
        Context dVar;
        androidx.appcompat.app.d dVar2;
        i0();
        androidx.appcompat.view.b bVar = this.A;
        if (bVar != null) {
            bVar.c();
        }
        if (!(aVar instanceof k)) {
            aVar = new k(aVar);
        }
        androidx.appcompat.app.d dVar3 = this.f723t;
        if (dVar3 == null || this.X) {
            bVarQ = null;
        } else {
            try {
                bVarQ = dVar3.q(aVar);
            } catch (AbstractMethodError unused) {
                bVarQ = null;
            }
        }
        if (bVarQ != null) {
            this.A = bVarQ;
        } else {
            if (this.B == null) {
                if (this.P) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.f720q.getTheme();
                    theme.resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme themeNewTheme = this.f720q.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        dVar = new androidx.appcompat.view.d(this.f720q, 0);
                        dVar.getTheme().setTo(themeNewTheme);
                    } else {
                        dVar = this.f720q;
                    }
                    this.B = new ActionBarContextView(dVar);
                    PopupWindow popupWindow = new PopupWindow(dVar, (AttributeSet) null, androidx.appcompat.R.attr.actionModePopupWindowStyle);
                    this.C = popupWindow;
                    androidx.core.widget.s.d(popupWindow, 2);
                    this.C.setContentView(this.B);
                    this.C.setWidth(-1);
                    dVar.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarSize, typedValue, true);
                    this.B.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, dVar.getResources().getDisplayMetrics()));
                    this.C.setHeight(-2);
                    this.D = new f();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.H.findViewById(androidx.appcompat.R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(n0()));
                        this.B = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.B != null) {
                i0();
                this.B.t();
                androidx.appcompat.view.e eVar = new androidx.appcompat.view.e(this.B.getContext(), this.B, aVar, this.C == null);
                if (aVar.b(eVar, eVar.e())) {
                    eVar.k();
                    this.B.q(eVar);
                    this.A = eVar;
                    if (R0()) {
                        this.B.setAlpha(0.0f);
                        n4 n4VarB = n2.g(this.B).b(1.0f);
                        this.E = n4VarB;
                        n4VarB.u(new g());
                    } else {
                        this.B.setAlpha(1.0f);
                        this.B.setVisibility(0);
                        if (this.B.getParent() instanceof View) {
                            n2.v1((View) this.B.getParent());
                        }
                    }
                    if (this.C != null) {
                        this.f721r.getDecorView().post(this.D);
                    }
                } else {
                    this.A = null;
                }
            }
        }
        androidx.appcompat.view.b bVar2 = this.A;
        if (bVar2 != null && (dVar2 = this.f723t) != null) {
            dVar2.l(bVar2);
        }
        return this.A;
    }

    void Y(int i7, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i7 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.S;
                if (i7 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i7];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f739j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f744o) && !this.X) {
            this.f722s.d(this.f721r.getCallback(), i7, menu);
        }
    }

    final int Y0(@c.o0 w5 w5Var, @c.o0 Rect rect) {
        int iR;
        boolean z7;
        boolean z8;
        if (w5Var != null) {
            iR = w5Var.r();
        } else {
            iR = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.B;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z7 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.B.getLayoutParams();
            boolean z9 = true;
            if (this.B.isShown()) {
                if (this.J0 == null) {
                    this.J0 = new Rect();
                    this.K0 = new Rect();
                }
                Rect rect2 = this.J0;
                Rect rect3 = this.K0;
                if (w5Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(w5Var.p(), w5Var.r(), w5Var.q(), w5Var.o());
                }
                r1.a(this.H, rect2, rect3);
                int i7 = rect2.top;
                int i8 = rect2.left;
                int i9 = rect2.right;
                w5 w5VarO0 = n2.o0(this.H);
                int iP = w5VarO0 == null ? 0 : w5VarO0.p();
                int iQ = w5VarO0 == null ? 0 : w5VarO0.q();
                if (marginLayoutParams.topMargin == i7 && marginLayoutParams.leftMargin == i8 && marginLayoutParams.rightMargin == i9) {
                    z8 = false;
                } else {
                    marginLayoutParams.topMargin = i7;
                    marginLayoutParams.leftMargin = i8;
                    marginLayoutParams.rightMargin = i9;
                    z8 = true;
                }
                if (i7 <= 0 || this.f718J != null) {
                    View view = this.f718J;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i10 = marginLayoutParams2.height;
                        int i11 = marginLayoutParams.topMargin;
                        if (i10 != i11 || marginLayoutParams2.leftMargin != iP || marginLayoutParams2.rightMargin != iQ) {
                            marginLayoutParams2.height = i11;
                            marginLayoutParams2.leftMargin = iP;
                            marginLayoutParams2.rightMargin = iQ;
                            this.f718J.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f720q);
                    this.f718J = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iP;
                    layoutParams.rightMargin = iQ;
                    this.H.addView(this.f718J, -1, layoutParams);
                }
                View view3 = this.f718J;
                z9 = view3 != null;
                if (z9 && view3.getVisibility() != 0) {
                    Z0(this.f718J);
                }
                if (!this.O && z9) {
                    iR = 0;
                }
                z7 = z9;
                z9 = z8;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z7 = false;
            } else {
                z7 = false;
                z9 = false;
            }
            if (z9) {
                this.B.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.f718J;
        if (view4 != null) {
            view4.setVisibility(z7 ? 0 : 8);
        }
        return iR;
    }

    void Z(@m0 androidx.appcompat.view.menu.g gVar) {
        if (this.R) {
            return;
        }
        this.R = true;
        this.f727x.n();
        Window.Callback callbackU0 = u0();
        if (callbackU0 != null && !this.X) {
            callbackU0.onPanelClosed(108, gVar);
        }
        this.R = false;
    }

    @Override // androidx.appcompat.view.menu.g.a
    public boolean a(@m0 androidx.appcompat.view.menu.g gVar, @m0 MenuItem menuItem) {
        PanelFeatureState panelFeatureStateL0;
        Window.Callback callbackU0 = u0();
        if (callbackU0 == null || this.X || (panelFeatureStateL0 = l0(gVar.G())) == null) {
            return false;
        }
        return callbackU0.onMenuItemSelected(panelFeatureStateL0.f730a, menuItem);
    }

    @Override // androidx.appcompat.view.menu.g.a
    public void b(@m0 androidx.appcompat.view.menu.g gVar) {
        P0(true);
    }

    void b0(int i7) {
        c0(r0(i7, true), true);
    }

    void c0(PanelFeatureState panelFeatureState, boolean z7) {
        ViewGroup viewGroup;
        e0 e0Var;
        if (z7 && panelFeatureState.f730a == 0 && (e0Var = this.f727x) != null && e0Var.b()) {
            Z(panelFeatureState.f739j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f720q.getSystemService("window");
        if (windowManager != null && panelFeatureState.f744o && (viewGroup = panelFeatureState.f736g) != null) {
            windowManager.removeView(viewGroup);
            if (z7) {
                Y(panelFeatureState.f730a, panelFeatureState, null);
            }
        }
        panelFeatureState.f742m = false;
        panelFeatureState.f743n = false;
        panelFeatureState.f744o = false;
        panelFeatureState.f737h = null;
        panelFeatureState.f746q = true;
        if (this.T == panelFeatureState) {
            this.T = null;
        }
    }

    @Override // androidx.appcompat.app.e
    public void d(View view, ViewGroup.LayoutParams layoutParams) {
        j0();
        ((ViewGroup) this.H.findViewById(R.id.content)).addView(view, layoutParams);
        this.f722s.c(this.f721r.getCallback());
    }

    @Override // androidx.appcompat.app.e
    public boolean e() {
        return U(true);
    }

    void f0() {
        androidx.appcompat.view.menu.g gVar;
        e0 e0Var = this.f727x;
        if (e0Var != null) {
            e0Var.n();
        }
        if (this.C != null) {
            this.f721r.getDecorView().removeCallbacks(this.D);
            if (this.C.isShowing()) {
                try {
                    this.C.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.C = null;
        }
        i0();
        PanelFeatureState panelFeatureStateR0 = r0(0, false);
        if (panelFeatureStateR0 == null || (gVar = panelFeatureStateR0.f739j) == null) {
            return;
        }
        gVar.close();
    }

    boolean g0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f719p;
        if (((obj instanceof p0.a) || (obj instanceof androidx.appcompat.app.l)) && (decorView = this.f721r.getDecorView()) != null && p0.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.f722s.b(this.f721r.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? D0(keyCode, keyEvent) : G0(keyCode, keyEvent);
    }

    @Override // androidx.appcompat.app.e
    @c.i
    @m0
    public Context h(@m0 Context context) {
        this.V = true;
        int iB0 = B0(context, X());
        boolean z7 = false;
        if (R0 && (context instanceof ContextThemeWrapper)) {
            try {
                t.a((ContextThemeWrapper) context, d0(context, iB0, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof androidx.appcompat.view.d) {
            try {
                ((androidx.appcompat.view.d) context).a(d0(context, iB0, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!Q0) {
            return super.h(context);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = l.a(context, configuration).getResources().getConfiguration();
        Configuration configuration3 = context.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationD0 = d0(context, iB0, configuration2.equals(configuration3) ? null : m0(configuration2, configuration3), true);
        androidx.appcompat.view.d dVar = new androidx.appcompat.view.d(context, androidx.appcompat.R.style.Theme_AppCompat_Empty);
        dVar.a(configurationD0);
        try {
            z7 = context.getTheme() != null;
        } catch (NullPointerException unused3) {
        }
        if (z7) {
            androidx.core.content.res.i.h.a(dVar.getTheme());
        }
        return super.h(dVar);
    }

    void h0(int i7) {
        PanelFeatureState panelFeatureStateR0;
        PanelFeatureState panelFeatureStateR1 = r0(i7, true);
        if (panelFeatureStateR1.f739j != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateR1.f739j.V(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateR1.f750u = bundle;
            }
            panelFeatureStateR1.f739j.m0();
            panelFeatureStateR1.f739j.clear();
        }
        panelFeatureStateR1.f747r = true;
        panelFeatureStateR1.f746q = true;
        if ((i7 != 108 && i7 != 0) || this.f727x == null || (panelFeatureStateR0 = r0(0, false)) == null) {
            return;
        }
        panelFeatureStateR0.f742m = false;
        O0(panelFeatureStateR0, null);
    }

    void i0() {
        n4 n4Var = this.E;
        if (n4Var != null) {
            n4Var.d();
        }
    }

    PanelFeatureState l0(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.S;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i7 = 0; i7 < length; i7++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i7];
            if (panelFeatureState != null && panelFeatureState.f739j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.app.e
    public View m(View view, String str, @m0 Context context, @m0 AttributeSet attributeSet) {
        boolean z7;
        boolean zS0 = false;
        if (this.L0 == null) {
            String string = this.f720q.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme).getString(androidx.appcompat.R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                this.L0 = new androidx.appcompat.app.n();
            } else {
                try {
                    this.L0 = (androidx.appcompat.app.n) this.f720q.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.L0 = new androidx.appcompat.app.n();
                }
            }
        }
        boolean z8 = O0;
        if (z8) {
            if (this.M0 == null) {
                this.M0 = new androidx.appcompat.app.o();
            }
            if (this.M0.a(attributeSet)) {
                z7 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zS0 = S0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zS0 = true;
                }
                z7 = zS0;
            }
        } else {
            z7 = zS0;
        }
        return this.L0.r(view, str, context, attributeSet, z7, z8, true, q1.d());
    }

    @Override // androidx.appcompat.app.e
    @c.o0
    public <T extends View> T n(@b0 int i7) {
        j0();
        return (T) this.f721r.findViewById(i7);
    }

    final Context n0() {
        ActionBar actionBarS = s();
        Context contextA = actionBarS != null ? actionBarS.A() : null;
        return contextA == null ? this.f720q : contextA;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return m(view, str, context, attributeSet);
    }

    @Override // androidx.appcompat.app.e
    public final androidx.appcompat.app.a.b p() {
        return new h();
    }

    @x0({x0.a.LIBRARY})
    @m0
    @g1
    final r p0() {
        return q0(this.f720q);
    }

    @Override // androidx.appcompat.app.e
    public int q() {
        return this.Z;
    }

    @Override // androidx.appcompat.app.e
    public MenuInflater r() {
        if (this.f725v == null) {
            v0();
            ActionBar actionBar = this.f724u;
            this.f725v = new androidx.appcompat.view.g(actionBar != null ? actionBar.A() : this.f720q);
        }
        return this.f725v;
    }

    protected PanelFeatureState r0(int i7, boolean z7) {
        PanelFeatureState[] panelFeatureStateArr = this.S;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i7) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i7 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.S = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i7];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i7);
        panelFeatureStateArr[i7] = panelFeatureState2;
        return panelFeatureState2;
    }

    @Override // androidx.appcompat.app.e
    public ActionBar s() {
        v0();
        return this.f724u;
    }

    ViewGroup s0() {
        return this.H;
    }

    @Override // androidx.appcompat.app.e
    public boolean t(int i7) {
        boolean z7;
        int iQ0 = Q0(i7);
        if (iQ0 == 1) {
            z7 = this.Q;
        } else if (iQ0 == 2) {
            z7 = this.K;
        } else if (iQ0 == 5) {
            z7 = this.L;
        } else if (iQ0 == 10) {
            z7 = this.O;
        } else if (iQ0 != 108) {
            z7 = iQ0 != 109 ? false : this.N;
        } else {
            z7 = this.M;
        }
        return z7 || this.f721r.hasFeature(i7);
    }

    final CharSequence t0() {
        Object obj = this.f719p;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.f726w;
    }

    @Override // androidx.appcompat.app.e
    public void u() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f720q);
        if (layoutInflaterFrom.getFactory() == null) {
            q0.d(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    final Window.Callback u0() {
        return this.f721r.getCallback();
    }

    @Override // androidx.appcompat.app.e
    public void v() {
        if (M0() == null || s().D()) {
            return;
        }
        z0(0);
    }

    @Override // androidx.appcompat.app.e
    public boolean x() {
        return this.F;
    }

    @Override // androidx.appcompat.app.e
    public void y(Configuration configuration) {
        ActionBar actionBarS;
        if (this.M && this.G && (actionBarS = s()) != null) {
            actionBarS.I(configuration);
        }
        androidx.appcompat.widget.g.b().g(this.f720q);
        this.Y = new Configuration(this.f720q.getResources().getConfiguration());
        U(false);
        configuration.updateFrom(this.f720q.getResources().getConfiguration());
    }

    @Override // androidx.appcompat.app.e
    public void z(Bundle bundle) {
        String strD;
        this.V = true;
        U(false);
        k0();
        Object obj = this.f719p;
        if (obj instanceof Activity) {
            try {
                strD = g0.d((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strD = null;
            }
            if (strD != null) {
                ActionBar actionBarM0 = M0();
                if (actionBarM0 == null) {
                    this.I0 = true;
                } else {
                    actionBarM0.X(true);
                }
            }
            androidx.appcompat.app.e.c(this);
        }
        this.Y = new Configuration(this.f720q.getResources().getConfiguration());
        this.W = true;
    }

    AppCompatDelegateImpl(Dialog dialog, androidx.appcompat.app.d dVar) {
        this(dialog.getContext(), dialog.getWindow(), dVar, dialog);
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.d dVar) {
        this(context, window, dVar, context);
    }

    AppCompatDelegateImpl(Context context, Activity activity, androidx.appcompat.app.d dVar) {
        this(context, null, dVar, activity);
    }

    private AppCompatDelegateImpl(Context context, Window window, androidx.appcompat.app.d dVar, Object obj) {
        androidx.collection.i<String, Integer> iVar;
        Integer num;
        AppCompatActivity appCompatActivityV0;
        this.E = null;
        this.F = true;
        this.Z = -100;
        this.H0 = new b();
        this.f720q = context;
        this.f723t = dVar;
        this.f719p = obj;
        if (this.Z == -100 && (obj instanceof Dialog) && (appCompatActivityV0 = V0()) != null) {
            this.Z = appCompatActivityV0.I().q();
        }
        if (this.Z == -100 && (num = (iVar = N0).get(obj.getClass().getName())) != null) {
            this.Z = num.intValue();
            iVar.remove(obj.getClass().getName());
        }
        if (window != null) {
            W(window);
        }
        androidx.appcompat.widget.g.i();
    }
}
