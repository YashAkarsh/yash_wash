package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.d7;
import androidx.lifecycle.p0;
import androidx.lifecycle.q0;
import c.h0;
import c.j0;
import c.m0;
import c.o0;
import c.x0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public class FragmentActivity extends ComponentActivity implements androidx.core.app.b.i, androidx.core.app.b.k {
    static final String FRAGMENTS_TAG = "android:support:fragments";
    boolean mCreated;
    final androidx.lifecycle.r mFragmentLifecycleRegistry;
    final f mFragments;
    boolean mResumed;
    boolean mStopped;

    class a implements androidx.savedstate.b.c {
        a() {
        }

        @Override // androidx.savedstate.b.c
        @m0
        public Bundle a() {
            Bundle bundle = new Bundle();
            FragmentActivity.this.markFragmentsCreated();
            FragmentActivity.this.mFragmentLifecycleRegistry.j(androidx.lifecycle.m.b.ON_STOP);
            Parcelable parcelableP = FragmentActivity.this.mFragments.P();
            if (parcelableP != null) {
                bundle.putParcelable(FragmentActivity.FRAGMENTS_TAG, parcelableP);
            }
            return bundle;
        }
    }

    class b implements a.c {
        b() {
        }

        @Override // a.c
        public void a(@m0 Context context) {
            FragmentActivity.this.mFragments.a(null);
            Bundle bundleB = FragmentActivity.this.getSavedStateRegistry().b(FragmentActivity.FRAGMENTS_TAG);
            if (bundleB != null) {
                FragmentActivity.this.mFragments.L(bundleB.getParcelable(FragmentActivity.FRAGMENTS_TAG));
            }
        }
    }

    class c extends h<FragmentActivity> implements q0, androidx.activity.h, androidx.activity.result.d, n {
        public c() {
            super(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.n
        public void a(@m0 FragmentManager fragmentManager, @m0 Fragment fragment) {
            FragmentActivity.this.onAttachFragment(fragment);
        }

        @Override // androidx.fragment.app.h, androidx.fragment.app.e
        @o0
        public View c(int i7) {
            return FragmentActivity.this.findViewById(i7);
        }

        @Override // androidx.fragment.app.h, androidx.fragment.app.e
        public boolean d() {
            Window window = FragmentActivity.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // androidx.activity.result.d
        @m0
        public ActivityResultRegistry getActivityResultRegistry() {
            return FragmentActivity.this.getActivityResultRegistry();
        }

        @Override // androidx.lifecycle.q
        @m0
        public androidx.lifecycle.m getLifecycle() {
            return FragmentActivity.this.mFragmentLifecycleRegistry;
        }

        @Override // androidx.activity.h
        @m0
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return FragmentActivity.this.getOnBackPressedDispatcher();
        }

        @Override // androidx.lifecycle.q0
        @m0
        public p0 getViewModelStore() {
            return FragmentActivity.this.getViewModelStore();
        }

        @Override // androidx.fragment.app.h
        public void h(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr) {
            FragmentActivity.this.dump(str, fileDescriptor, printWriter, strArr);
        }

        @Override // androidx.fragment.app.h
        @m0
        public LayoutInflater j() {
            return FragmentActivity.this.getLayoutInflater().cloneInContext(FragmentActivity.this);
        }

        @Override // androidx.fragment.app.h
        public int k() {
            Window window = FragmentActivity.this.getWindow();
            if (window == null) {
                return 0;
            }
            return window.getAttributes().windowAnimations;
        }

        @Override // androidx.fragment.app.h
        public boolean l() {
            return FragmentActivity.this.getWindow() != null;
        }

        @Override // androidx.fragment.app.h
        public boolean n(@m0 Fragment fragment) {
            return !FragmentActivity.this.isFinishing();
        }

        @Override // androidx.fragment.app.h
        public boolean o(@m0 String str) {
            return androidx.core.app.b.M(FragmentActivity.this, str);
        }

        @Override // androidx.fragment.app.h
        public void s() {
            FragmentActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // androidx.fragment.app.h
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public FragmentActivity i() {
            return FragmentActivity.this;
        }
    }

    public FragmentActivity() {
        this.mFragments = f.b(new c());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.r(this);
        this.mStopped = true;
        G();
    }

    private void G() {
        getSavedStateRegistry().j(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean H(FragmentManager fragmentManager, androidx.lifecycle.m.c cVar) {
        boolean zH = false;
        for (Fragment fragment : fragmentManager.G0()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    zH |= H(fragment.getChildFragmentManager(), cVar);
                }
                z zVar = fragment.mViewLifecycleOwner;
                if (zVar != null && zVar.getLifecycle().b().a(androidx.lifecycle.m.c.STARTED)) {
                    fragment.mViewLifecycleOwner.f(cVar);
                    zH = true;
                }
                if (fragment.mLifecycleRegistry.b().a(androidx.lifecycle.m.c.STARTED)) {
                    fragment.mLifecycleRegistry.q(cVar);
                    zH = true;
                }
            }
        }
        return zH;
    }

    @o0
    final View dispatchFragmentsOnCreateView(@o0 View view, @m0 String str, @m0 Context context, @m0 AttributeSet attributeSet) {
        return this.mFragments.G(view, str, context, attributeSet);
    }

    @Override // android.app.Activity
    public void dump(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            androidx.loader.app.a.d(this).b(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.D().b0(str, fileDescriptor, printWriter, strArr);
    }

    @m0
    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.D();
    }

    @m0
    @Deprecated
    public androidx.loader.app.a getSupportLoaderManager() {
        return androidx.loader.app.a.d(this);
    }

    void markFragmentsCreated() {
        while (H(getSupportFragmentManager(), androidx.lifecycle.m.c.CREATED)) {
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @c.i
    protected void onActivityResult(int i7, int i8, @o0 Intent intent) {
        this.mFragments.F();
        super.onActivityResult(i7, i8, intent);
    }

    @j0
    @Deprecated
    public void onAttachFragment(@m0 Fragment fragment) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@m0 Configuration configuration) {
        this.mFragments.F();
        super.onConfigurationChanged(configuration);
        this.mFragments.d(configuration);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.j(androidx.lifecycle.m.b.ON_CREATE);
        this.mFragments.f();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i7, @m0 Menu menu) {
        return i7 == 0 ? super.onCreatePanelMenu(i7, menu) | this.mFragments.g(menu, getMenuInflater()) : super.onCreatePanelMenu(i7, menu);
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory2
    @o0
    public View onCreateView(@o0 View view, @m0 String str, @m0 Context context, @m0 AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mFragments.h();
        this.mFragmentLifecycleRegistry.j(androidx.lifecycle.m.b.ON_DESTROY);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.j();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i7, @m0 MenuItem menuItem) {
        if (super.onMenuItemSelected(i7, menuItem)) {
            return true;
        }
        if (i7 == 0) {
            return this.mFragments.l(menuItem);
        }
        if (i7 != 6) {
            return false;
        }
        return this.mFragments.e(menuItem);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @c.i
    public void onMultiWindowModeChanged(boolean z7) {
        this.mFragments.k(z7);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @c.i
    protected void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.F();
        super.onNewIntent(intent);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i7, @m0 Menu menu) {
        if (i7 == 0) {
            this.mFragments.m(menu);
        }
        super.onPanelClosed(i7, menu);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.n();
        this.mFragmentLifecycleRegistry.j(androidx.lifecycle.m.b.ON_PAUSE);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @c.i
    public void onPictureInPictureModeChanged(boolean z7) {
        this.mFragments.o(z7);
    }

    @Override // android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @Deprecated
    protected boolean onPrepareOptionsPanel(@o0 View view, @m0 Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i7, @o0 View view, @m0 Menu menu) {
        return i7 == 0 ? onPrepareOptionsPanel(view, menu) | this.mFragments.p(menu) : super.onPreparePanel(i7, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    @c.i
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
        this.mFragments.F();
        super.onRequestPermissionsResult(i7, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        this.mFragments.F();
        super.onResume();
        this.mResumed = true;
        this.mFragments.z();
    }

    protected void onResumeFragments() {
        this.mFragmentLifecycleRegistry.j(androidx.lifecycle.m.b.ON_RESUME);
        this.mFragments.r();
    }

    @Override // android.app.Activity
    protected void onStart() {
        this.mFragments.F();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.c();
        }
        this.mFragments.z();
        this.mFragmentLifecycleRegistry.j(androidx.lifecycle.m.b.ON_START);
        this.mFragments.s();
    }

    @Override // android.app.Activity
    public void onStateNotSaved() {
        this.mFragments.F();
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        this.mFragments.t();
        this.mFragmentLifecycleRegistry.j(androidx.lifecycle.m.b.ON_STOP);
    }

    public void setEnterSharedElementCallback(@o0 d7 d7Var) {
        androidx.core.app.b.I(this, d7Var);
    }

    public void setExitSharedElementCallback(@o0 d7 d7Var) {
        androidx.core.app.b.J(this, d7Var);
    }

    public void startActivityFromFragment(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i7) {
        startActivityFromFragment(fragment, intent, i7, (Bundle) null);
    }

    @Deprecated
    public void startIntentSenderFromFragment(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i7, @o0 Intent intent, int i8, int i9, int i10, @o0 Bundle bundle) throws IntentSender.SendIntentException {
        if (i7 == -1) {
            androidx.core.app.b.O(this, intentSender, i7, intent, i8, i9, i10, bundle);
        } else {
            fragment.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10, bundle);
        }
    }

    public void supportFinishAfterTransition() {
        androidx.core.app.b.x(this);
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        androidx.core.app.b.D(this);
    }

    public void supportStartPostponedEnterTransition() {
        androidx.core.app.b.P(this);
    }

    @Override // androidx.core.app.b.k
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i7) {
    }

    public void startActivityFromFragment(@m0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i7, @o0 Bundle bundle) {
        if (i7 == -1) {
            androidx.core.app.b.N(this, intent, -1, bundle);
        } else {
            fragment.startActivityForResult(intent, i7, bundle);
        }
    }

    @Override // android.app.Activity, android.view.LayoutInflater.Factory
    @o0
    public View onCreateView(@m0 String str, @m0 Context context, @m0 AttributeSet attributeSet) {
        View viewDispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return viewDispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : viewDispatchFragmentsOnCreateView;
    }

    @c.o
    public FragmentActivity(@h0 int i7) {
        super(i7);
        this.mFragments = f.b(new c());
        this.mFragmentLifecycleRegistry = new androidx.lifecycle.r(this);
        this.mStopped = true;
        G();
    }
}
