package androidx.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.core.app.f0;
import androidx.core.app.h6;
import androidx.core.app.o5;
import androidx.core.app.p5;
import androidx.core.app.q5;
import androidx.core.content.r;
import androidx.core.content.s;
import androidx.core.view.p1;
import androidx.core.view.v0;
import androidx.core.view.y0;
import androidx.lifecycle.b0;
import androidx.lifecycle.e0;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.m0;
import androidx.lifecycle.o;
import androidx.lifecycle.p0;
import androidx.lifecycle.q;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import c.h0;
import c.j0;
import c.o0;
import c.t0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ComponentActivity extends androidx.core.app.ComponentActivity implements a.a, q, q0, l, androidx.savedstate.d, h, androidx.activity.result.d, androidx.activity.result.b, r, s, p5, o5, q5, v0 {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private final ActivityResultRegistry mActivityResultRegistry;

    @h0
    private int mContentLayoutId;
    final a.b mContextAwareHelper;
    private m0.b mDefaultFactory;
    private final androidx.lifecycle.r mLifecycleRegistry;
    private final y0 mMenuHostHelper;
    private final AtomicInteger mNextLocalRequestCode;
    private final OnBackPressedDispatcher mOnBackPressedDispatcher;
    private final CopyOnWriteArrayList<androidx.core.util.e<Configuration>> mOnConfigurationChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.e<f0>> mOnMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.e<Intent>> mOnNewIntentListeners;
    private final CopyOnWriteArrayList<androidx.core.util.e<h6>> mOnPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<androidx.core.util.e<Integer>> mOnTrimMemoryListeners;
    final androidx.savedstate.c mSavedStateRegistryController;
    private p0 mViewModelStore;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ComponentActivity.super.onBackPressed();
            } catch (IllegalStateException e8) {
                if (!TextUtils.equals(e8.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e8;
                }
            }
        }
    }

    class b extends ActivityResultRegistry {

        class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f547a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ b.a.C0134a f548b;

            a(int i7, b.a.C0134a c0134a) {
                this.f547a = i7;
                this.f548b = c0134a;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.c(this.f547a, this.f548b.a());
            }
        }

        /* JADX INFO: renamed from: androidx.activity.ComponentActivity$b$b, reason: collision with other inner class name */
        class RunnableC0018b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f550a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f551b;

            RunnableC0018b(int i7, IntentSender.SendIntentException sendIntentException) {
                this.f550a = i7;
                this.f551b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.b(this.f550a, 0, new Intent().setAction(b.b.l.f11260b).putExtra(b.b.l.f11262d, this.f551b));
            }
        }

        b() {
        }

        @Override // androidx.activity.result.ActivityResultRegistry
        public <I, O> void f(int i7, @c.m0 b.a<I, O> aVar, I i8, @o0 androidx.core.app.i iVar) {
            Bundle bundleL;
            ComponentActivity componentActivity = ComponentActivity.this;
            b.a.C0134a<O> c0134aB = aVar.b(componentActivity, i8);
            if (c0134aB != null) {
                new Handler(Looper.getMainLooper()).post(new a(i7, c0134aB));
                return;
            }
            Intent intentA = aVar.a(componentActivity, i8);
            if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
                intentA.setExtrasClassLoader(componentActivity.getClassLoader());
            }
            if (intentA.hasExtra(b.b.k.f11258b)) {
                Bundle bundleExtra = intentA.getBundleExtra(b.b.k.f11258b);
                intentA.removeExtra(b.b.k.f11258b);
                bundleL = bundleExtra;
            } else {
                bundleL = iVar != null ? iVar.l() : null;
            }
            if (b.b.i.f11254b.equals(intentA.getAction())) {
                String[] stringArrayExtra = intentA.getStringArrayExtra(b.b.i.f11255c);
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.b.G(componentActivity, stringArrayExtra, i7);
                return;
            }
            if (!b.b.l.f11260b.equals(intentA.getAction())) {
                androidx.core.app.b.N(componentActivity, intentA, i7, bundleL);
                return;
            }
            IntentSenderRequest intentSenderRequest = (IntentSenderRequest) intentA.getParcelableExtra(b.b.l.f11261c);
            try {
                androidx.core.app.b.O(componentActivity, intentSenderRequest.e(), i7, intentSenderRequest.a(), intentSenderRequest.b(), intentSenderRequest.d(), 0, bundleL);
            } catch (IntentSender.SendIntentException e8) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0018b(i7, e8));
            }
        }
    }

    @t0(19)
    static class c {
        private c() {
        }

        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        p0 f554b;

        d() {
        }
    }

    public ComponentActivity() {
        this.mContextAwareHelper = new a.b();
        this.mMenuHostHelper = new y0(new Runnable() { // from class: androidx.activity.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f571a.invalidateMenu();
            }
        });
        this.mLifecycleRegistry = new androidx.lifecycle.r(this);
        androidx.savedstate.c cVarA = androidx.savedstate.c.a(this);
        this.mSavedStateRegistryController = cVarA;
        this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new a());
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mActivityResultRegistry = new b();
        this.mOnConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.mOnNewIntentListeners = new CopyOnWriteArrayList<>();
        this.mOnMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.mOnPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i7 = Build.VERSION.SDK_INT;
        getLifecycle().a(new o() { // from class: androidx.activity.ComponentActivity.3
            @Override // androidx.lifecycle.o
            public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
                if (bVar == m.b.ON_STOP) {
                    Window window = ComponentActivity.this.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        c.a(viewPeekDecorView);
                    }
                }
            }
        });
        getLifecycle().a(new o() { // from class: androidx.activity.ComponentActivity.4
            @Override // androidx.lifecycle.o
            public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
                if (bVar == m.b.ON_DESTROY) {
                    ComponentActivity.this.mContextAwareHelper.b();
                    if (ComponentActivity.this.isChangingConfigurations()) {
                        return;
                    }
                    ComponentActivity.this.getViewModelStore().a();
                }
            }
        });
        getLifecycle().a(new o() { // from class: androidx.activity.ComponentActivity.5
            @Override // androidx.lifecycle.o
            public void g(@c.m0 q qVar, @c.m0 m.b bVar) {
                ComponentActivity.this.ensureViewModelStore();
                ComponentActivity.this.getLifecycle().c(this);
            }
        });
        cVarA.c();
        e0.c(this);
        if (i7 <= 23) {
            getLifecycle().a(new ImmLeaksCleaner(this));
        }
        getSavedStateRegistry().j(ACTIVITY_RESULT_TAG, new androidx.savedstate.b.c() { // from class: androidx.activity.c
            @Override // androidx.savedstate.b.c
            public final Bundle a() {
                return this.f572a.E();
            }
        });
        addOnContextAvailableListener(new a.c() { // from class: androidx.activity.d
            @Override // a.c
            public final void a(Context context) {
                this.f573a.F(context);
            }
        });
    }

    private void D() {
        r0.b(getWindow().getDecorView(), this);
        androidx.lifecycle.t0.b(getWindow().getDecorView(), this);
        androidx.savedstate.e.b(getWindow().getDecorView(), this);
        i.b(getWindow().getDecorView(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle E() {
        Bundle bundle = new Bundle();
        this.mActivityResultRegistry.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(Context context) {
        Bundle bundleB = getSavedStateRegistry().b(ACTIVITY_RESULT_TAG);
        if (bundleB != null) {
            this.mActivityResultRegistry.g(bundleB);
        }
    }

    @Override // android.app.Activity
    public void addContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        D();
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.v0
    public void addMenuProvider(@c.m0 p1 p1Var) {
        this.mMenuHostHelper.c(p1Var);
    }

    @Override // androidx.core.content.r
    public final void addOnConfigurationChangedListener(@c.m0 androidx.core.util.e<Configuration> eVar) {
        this.mOnConfigurationChangedListeners.add(eVar);
    }

    @Override // a.a
    public final void addOnContextAvailableListener(@c.m0 a.c cVar) {
        this.mContextAwareHelper.a(cVar);
    }

    @Override // androidx.core.app.o5
    public final void addOnMultiWindowModeChangedListener(@c.m0 androidx.core.util.e<f0> eVar) {
        this.mOnMultiWindowModeChangedListeners.add(eVar);
    }

    @Override // androidx.core.app.p5
    public final void addOnNewIntentListener(@c.m0 androidx.core.util.e<Intent> eVar) {
        this.mOnNewIntentListeners.add(eVar);
    }

    @Override // androidx.core.app.q5
    public final void addOnPictureInPictureModeChangedListener(@c.m0 androidx.core.util.e<h6> eVar) {
        this.mOnPictureInPictureModeChangedListeners.add(eVar);
    }

    @Override // androidx.core.content.s
    public final void addOnTrimMemoryListener(@c.m0 androidx.core.util.e<Integer> eVar) {
        this.mOnTrimMemoryListeners.add(eVar);
    }

    void ensureViewModelStore() {
        if (this.mViewModelStore == null) {
            d dVar = (d) getLastNonConfigurationInstance();
            if (dVar != null) {
                this.mViewModelStore = dVar.f554b;
            }
            if (this.mViewModelStore == null) {
                this.mViewModelStore = new p0();
            }
        }
    }

    @Override // androidx.activity.result.d
    @c.m0
    public final ActivityResultRegistry getActivityResultRegistry() {
        return this.mActivityResultRegistry;
    }

    @Override // androidx.lifecycle.l
    @c.i
    @c.m0
    public v.a getDefaultViewModelCreationExtras() {
        v.e eVar = new v.e();
        if (getApplication() != null) {
            eVar.c(m0.a.f8333i, getApplication());
        }
        eVar.c(e0.f8286c, this);
        eVar.c(e0.f8287d, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            eVar.c(e0.f8288e, getIntent().getExtras());
        }
        return eVar;
    }

    @Override // androidx.lifecycle.l
    @c.m0
    public m0.b getDefaultViewModelProviderFactory() {
        if (this.mDefaultFactory == null) {
            this.mDefaultFactory = new androidx.lifecycle.h0(getApplication(), this, getIntent() != null ? getIntent().getExtras() : null);
        }
        return this.mDefaultFactory;
    }

    @o0
    @Deprecated
    public Object getLastCustomNonConfigurationInstance() {
        d dVar = (d) getLastNonConfigurationInstance();
        if (dVar != null) {
            return dVar.f553a;
        }
        return null;
    }

    @Override // androidx.core.app.ComponentActivity, androidx.lifecycle.q
    @c.m0
    public m getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // androidx.activity.h
    @c.m0
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.mOnBackPressedDispatcher;
    }

    @Override // androidx.savedstate.d
    @c.m0
    public final androidx.savedstate.b getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @Override // androidx.lifecycle.q0
    @c.m0
    public p0 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        ensureViewModelStore();
        return this.mViewModelStore;
    }

    @Override // androidx.core.view.v0
    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    @c.i
    @Deprecated
    protected void onActivityResult(int i7, int i8, @o0 Intent intent) {
        if (this.mActivityResultRegistry.b(i7, i8, intent)) {
            return;
        }
        super.onActivityResult(i7, i8, intent);
    }

    @Override // android.app.Activity
    @j0
    public void onBackPressed() {
        this.mOnBackPressedDispatcher.e();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    @c.i
    public void onConfigurationChanged(@c.m0 Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<androidx.core.util.e<Configuration>> it = this.mOnConfigurationChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@o0 Bundle bundle) {
        this.mSavedStateRegistryController.d(bundle);
        this.mContextAwareHelper.c(this);
        super.onCreate(bundle);
        b0.g(this);
        int i7 = this.mContentLayoutId;
        if (i7 != 0) {
            setContentView(i7);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i7, @c.m0 Menu menu) {
        if (i7 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i7, menu);
        this.mMenuHostHelper.h(menu, getMenuInflater());
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i7, @c.m0 MenuItem menuItem) {
        if (super.onMenuItemSelected(i7, menuItem)) {
            return true;
        }
        if (i7 == 0) {
            return this.mMenuHostHelper.j(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    @c.i
    public void onMultiWindowModeChanged(boolean z7) {
        Iterator<androidx.core.util.e<f0>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new f0(z7));
        }
    }

    @Override // android.app.Activity
    @c.i
    protected void onNewIntent(@SuppressLint({"UnknownNullness", "MissingNullability"}) Intent intent) {
        super.onNewIntent(intent);
        Iterator<androidx.core.util.e<Intent>> it = this.mOnNewIntentListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i7, @c.m0 Menu menu) {
        this.mMenuHostHelper.i(menu);
        super.onPanelClosed(i7, menu);
    }

    @Override // android.app.Activity
    @c.i
    public void onPictureInPictureModeChanged(boolean z7) {
        Iterator<androidx.core.util.e<h6>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new h6(z7));
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i7, @o0 View view, @c.m0 Menu menu) {
        if (i7 != 0) {
            return true;
        }
        super.onPreparePanel(i7, view, menu);
        this.mMenuHostHelper.k(menu);
        return true;
    }

    @Override // android.app.Activity
    @c.i
    @Deprecated
    public void onRequestPermissionsResult(int i7, @c.m0 String[] strArr, @c.m0 int[] iArr) {
        if (this.mActivityResultRegistry.b(i7, -1, new Intent().putExtra(b.b.i.f11255c, strArr).putExtra(b.b.i.f11256d, iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i7, strArr, iArr);
    }

    @o0
    @Deprecated
    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    @o0
    public final Object onRetainNonConfigurationInstance() {
        d dVar;
        Object objOnRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        p0 p0Var = this.mViewModelStore;
        if (p0Var == null && (dVar = (d) getLastNonConfigurationInstance()) != null) {
            p0Var = dVar.f554b;
        }
        if (p0Var == null && objOnRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        d dVar2 = new d();
        dVar2.f553a = objOnRetainCustomNonConfigurationInstance;
        dVar2.f554b = p0Var;
        return dVar2;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity
    @c.i
    protected void onSaveInstanceState(@c.m0 Bundle bundle) {
        m lifecycle = getLifecycle();
        if (lifecycle instanceof androidx.lifecycle.r) {
            ((androidx.lifecycle.r) lifecycle).q(m.c.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    @c.i
    public void onTrimMemory(int i7) {
        super.onTrimMemory(i7);
        Iterator<androidx.core.util.e<Integer>> it = this.mOnTrimMemoryListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i7));
        }
    }

    @Override // a.a
    @o0
    public Context peekAvailableContext() {
        return this.mContextAwareHelper.d();
    }

    @Override // androidx.activity.result.b
    @c.m0
    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(@c.m0 b.a<I, O> aVar, @c.m0 ActivityResultRegistry activityResultRegistry, @c.m0 androidx.activity.result.a<O> aVar2) {
        return activityResultRegistry.i("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, aVar, aVar2);
    }

    @Override // androidx.core.view.v0
    public void removeMenuProvider(@c.m0 p1 p1Var) {
        this.mMenuHostHelper.l(p1Var);
    }

    @Override // androidx.core.content.r
    public final void removeOnConfigurationChangedListener(@c.m0 androidx.core.util.e<Configuration> eVar) {
        this.mOnConfigurationChangedListeners.remove(eVar);
    }

    @Override // a.a
    public final void removeOnContextAvailableListener(@c.m0 a.c cVar) {
        this.mContextAwareHelper.e(cVar);
    }

    @Override // androidx.core.app.o5
    public final void removeOnMultiWindowModeChangedListener(@c.m0 androidx.core.util.e<f0> eVar) {
        this.mOnMultiWindowModeChangedListeners.remove(eVar);
    }

    @Override // androidx.core.app.p5
    public final void removeOnNewIntentListener(@c.m0 androidx.core.util.e<Intent> eVar) {
        this.mOnNewIntentListeners.remove(eVar);
    }

    @Override // androidx.core.app.q5
    public final void removeOnPictureInPictureModeChangedListener(@c.m0 androidx.core.util.e<h6> eVar) {
        this.mOnPictureInPictureModeChangedListeners.remove(eVar);
    }

    @Override // androidx.core.content.s
    public final void removeOnTrimMemoryListener(@c.m0 androidx.core.util.e<Integer> eVar) {
        this.mOnTrimMemoryListeners.remove(eVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (androidx.tracing.b.h()) {
                androidx.tracing.b.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
        } finally {
            androidx.tracing.b.f();
        }
    }

    @Override // android.app.Activity
    public void setContentView(@h0 int i7) {
        D();
        super.setContentView(i7);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i7) {
        super.startActivityForResult(intent, i7);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i7, @o0 Intent intent, int i8, int i9, int i10) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10);
    }

    @Override // androidx.core.view.v0
    public void addMenuProvider(@c.m0 p1 p1Var, @c.m0 q qVar) {
        this.mMenuHostHelper.d(p1Var, qVar);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i7, @o0 Bundle bundle) {
        super.startActivityForResult(intent, i7, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i7, @o0 Intent intent, int i8, int i9, int i10, @o0 Bundle bundle) throws IntentSender.SendIntentException {
        super.startIntentSenderForResult(intentSender, i7, intent, i8, i9, i10, bundle);
    }

    @Override // androidx.core.view.v0
    @SuppressLint({"LambdaLast"})
    public void addMenuProvider(@c.m0 p1 p1Var, @c.m0 q qVar, @c.m0 m.c cVar) {
        this.mMenuHostHelper.e(p1Var, qVar, cVar);
    }

    @Override // android.app.Activity
    @t0(api = 26)
    @c.i
    public void onMultiWindowModeChanged(boolean z7, @c.m0 Configuration configuration) {
        Iterator<androidx.core.util.e<f0>> it = this.mOnMultiWindowModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new f0(z7, configuration));
        }
    }

    @Override // android.app.Activity
    @t0(api = 26)
    @c.i
    public void onPictureInPictureModeChanged(boolean z7, @c.m0 Configuration configuration) {
        Iterator<androidx.core.util.e<h6>> it = this.mOnPictureInPictureModeChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().accept(new h6(z7, configuration));
        }
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view) {
        D();
        super.setContentView(view);
    }

    @Override // androidx.activity.result.b
    @c.m0
    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(@c.m0 b.a<I, O> aVar, @c.m0 androidx.activity.result.a<O> aVar2) {
        return registerForActivityResult(aVar, this.mActivityResultRegistry, aVar2);
    }

    @Override // android.app.Activity
    public void setContentView(@SuppressLint({"UnknownNullness", "MissingNullability"}) View view, @SuppressLint({"UnknownNullness", "MissingNullability"}) ViewGroup.LayoutParams layoutParams) {
        D();
        super.setContentView(view, layoutParams);
    }

    @c.o
    public ComponentActivity(@h0 int i7) {
        this();
        this.mContentLayoutId = i7;
    }
}
