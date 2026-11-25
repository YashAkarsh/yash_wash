package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.core.app.d7;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.p0;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import c.a1;
import c.f1;
import c.h0;
import c.j0;
import c.m0;
import c.o0;
import c.x0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.q, q0, androidx.lifecycle.l, androidx.savedstate.d, androidx.activity.result.b {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    i mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    private boolean mCalled;

    @m0
    FragmentManager mChildFragmentManager;
    ViewGroup mContainer;
    int mContainerId;

    @h0
    private int mContentLayoutId;
    androidx.lifecycle.m0.b mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    androidx.fragment.app.h<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    LayoutInflater mLayoutInflater;
    androidx.lifecycle.r mLifecycleRegistry;
    androidx.lifecycle.m.c mMaxState;
    boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<k> mOnPreAttachedListeners;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    float mPostponedAlpha;
    Runnable mPostponedDurationRunnable;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    androidx.savedstate.c mSavedStateRegistryController;

    @o0
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    int mState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    String mTargetWho;
    boolean mUserVisibleHint;
    View mView;

    @o0
    z mViewLifecycleOwner;
    androidx.lifecycle.w<androidx.lifecycle.q> mViewLifecycleOwnerLiveData;

    @m0
    String mWho;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c0 f7748a;

        c(c0 c0Var) {
            this.f7748a = c0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7748a.g();
        }
    }

    class d extends androidx.fragment.app.e {
        d() {
        }

        @Override // androidx.fragment.app.e
        @o0
        public View c(int i7) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i7);
            }
            throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
        }

        @Override // androidx.fragment.app.e
        public boolean d() {
            return Fragment.this.mView != null;
        }
    }

    class e implements i.a<Void, ActivityResultRegistry> {
        e() {
        }

        @Override // i.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r7) {
            Fragment fragment = Fragment.this;
            Object obj = fragment.mHost;
            return obj instanceof androidx.activity.result.d ? ((androidx.activity.result.d) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
        }
    }

    class f implements i.a<Void, ActivityResultRegistry> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ActivityResultRegistry f7752a;

        f(ActivityResultRegistry activityResultRegistry) {
            this.f7752a = activityResultRegistry;
        }

        @Override // i.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResultRegistry apply(Void r7) {
            return this.f7752a;
        }
    }

    class g extends k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i.a f7754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AtomicReference f7755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b.a f7756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ androidx.activity.result.a f7757d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(i.a aVar, AtomicReference atomicReference, b.a aVar2, androidx.activity.result.a aVar3) {
            super(null);
            this.f7754a = aVar;
            this.f7755b = atomicReference;
            this.f7756c = aVar2;
            this.f7757d = aVar3;
        }

        @Override // androidx.fragment.app.Fragment.k
        void a() {
            String strGenerateActivityResultKey = Fragment.this.generateActivityResultKey();
            this.f7755b.set(((ActivityResultRegistry) this.f7754a.apply(null)).i(strGenerateActivityResultKey, Fragment.this, this.f7756c, this.f7757d));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    class h<I> extends androidx.activity.result.c<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AtomicReference f7759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b.a f7760b;

        h(AtomicReference atomicReference, b.a aVar) {
            this.f7759a = atomicReference;
            this.f7760b = aVar;
        }

        @Override // androidx.activity.result.c
        @m0
        public b.a<I, ?> a() {
            return this.f7760b;
        }

        @Override // androidx.activity.result.c
        public void c(I i7, @o0 androidx.core.app.i iVar) {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.f7759a.get();
            if (cVar == null) {
                throw new IllegalStateException("Operation cannot be started before fragment is in created state");
            }
            cVar.c(i7, iVar);
        }

        @Override // androidx.activity.result.c
        public void d() {
            androidx.activity.result.c cVar = (androidx.activity.result.c) this.f7759a.getAndSet(null);
            if (cVar != null) {
                cVar.d();
            }
        }
    }

    static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        View f7762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Animator f7763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f7764c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f7765d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f7766e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f7767f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f7768g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f7769h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ArrayList<String> f7770i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ArrayList<String> f7771j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f7772k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f7773l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        Object f7774m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Object f7775n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Object f7776o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        Object f7777p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        Boolean f7778q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        Boolean f7779r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        d7 f7780s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        d7 f7781t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        float f7782u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        View f7783v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        boolean f7784w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        l f7785x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        boolean f7786y;

        i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.f7773l = obj;
            this.f7774m = null;
            this.f7775n = obj;
            this.f7776o = null;
            this.f7777p = obj;
            this.f7780s = null;
            this.f7781t = null;
            this.f7782u = 1.0f;
            this.f7783v = null;
        }
    }

    public static class j extends RuntimeException {
        public j(@m0 String str, @o0 Exception exc) {
            super(str, exc);
        }
    }

    private static abstract class k {
        private k() {
        }

        abstract void a();

        /* synthetic */ k(a aVar) {
            this();
        }
    }

    interface l {
        void a();

        void b();
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new androidx.fragment.app.k();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new a();
        this.mMaxState = androidx.lifecycle.m.c.RESUMED;
        this.mViewLifecycleOwnerLiveData = new androidx.lifecycle.w<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        t();
    }

    @m0
    @Deprecated
    public static Fragment instantiate(@m0 Context context, @m0 String str) {
        return instantiate(context, str, null);
    }

    private i q() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    private int s() {
        androidx.lifecycle.m.c cVar = this.mMaxState;
        return (cVar == androidx.lifecycle.m.c.INITIALIZED || this.mParentFragment == null) ? cVar.ordinal() : Math.min(cVar.ordinal(), this.mParentFragment.s());
    }

    private void t() {
        this.mLifecycleRegistry = new androidx.lifecycle.r(this);
        this.mSavedStateRegistryController = androidx.savedstate.c.a(this);
        this.mDefaultFactory = null;
    }

    @m0
    private <I, O> androidx.activity.result.c<I> u(@m0 b.a<I, O> aVar, @m0 i.a<Void, ActivityResultRegistry> aVar2, @m0 androidx.activity.result.a<O> aVar3) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            v(new g(aVar2, atomicReference, aVar, aVar3));
            return new h(atomicReference, aVar);
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void v(@m0 k kVar) {
        if (this.mState >= 0) {
            kVar.a();
        } else {
            this.mOnPreAttachedListeners.add(kVar);
        }
    }

    private void w() {
        if (FragmentManager.T0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    void callStartTransitionListener(boolean z7) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        i iVar = this.mAnimationInfo;
        l lVar = null;
        if (iVar != null) {
            iVar.f7784w = false;
            l lVar2 = iVar.f7785x;
            iVar.f7785x = null;
            lVar = lVar2;
        }
        if (lVar != null) {
            lVar.b();
            return;
        }
        if (!FragmentManager.Q || this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        c0 c0VarN = c0.n(viewGroup, fragmentManager);
        c0VarN.p();
        if (z7) {
            this.mHost.g().post(new c(c0VarN));
        } else {
            c0VarN.g();
        }
    }

    @m0
    androidx.fragment.app.e createFragmentContainer() {
        return new d();
    }

    public void dump(@m0 String str, @o0 FileDescriptor fileDescriptor, @m0 PrintWriter printWriter, @o0 String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            androidx.loader.app.a.d(this).b(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.b0(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(@o0 Object obj) {
        return super.equals(obj);
    }

    @o0
    Fragment findFragmentByWho(@m0 String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.r0(str);
    }

    @m0
    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    @o0
    public final FragmentActivity getActivity() {
        androidx.fragment.app.h<?> hVar = this.mHost;
        if (hVar == null) {
            return null;
        }
        return (FragmentActivity) hVar.e();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f7779r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.f7778q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7762a;
    }

    Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7763b;
    }

    @o0
    public final Bundle getArguments() {
        return this.mArguments;
    }

    @m0
    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    @o0
    public Context getContext() {
        androidx.fragment.app.h<?> hVar = this.mHost;
        if (hVar == null) {
            return null;
        }
        return hVar.f();
    }

    @Override // androidx.lifecycle.l
    public /* synthetic */ v.a getDefaultViewModelCreationExtras() {
        return androidx.lifecycle.k.a(this);
    }

    @Override // androidx.lifecycle.l
    @m0
    public androidx.lifecycle.m0.b getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.T0(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new androidx.lifecycle.h0(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    int getEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f7765d;
    }

    @o0
    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7772k;
    }

    d7 getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7780s;
    }

    int getExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f7766e;
    }

    @o0
    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7774m;
    }

    d7 getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7781t;
    }

    View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7783v;
    }

    @o0
    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    @o0
    public final Object getHost() {
        androidx.fragment.app.h<?> hVar = this.mHost;
        if (hVar == null) {
            return null;
        }
        return hVar.i();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    @m0
    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.q
    @m0
    public androidx.lifecycle.m getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @m0
    @Deprecated
    public androidx.loader.app.a getLoaderManager() {
        return androidx.loader.app.a.d(this);
    }

    int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f7769h;
    }

    @o0
    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    @m0
    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    boolean getPopDirection() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f7764c;
    }

    int getPopEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f7767f;
    }

    int getPopExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f7768g;
    }

    float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.f7782u;
    }

    @o0
    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f7775n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    @m0
    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    @o0
    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f7773l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // androidx.savedstate.d
    @m0
    public final androidx.savedstate.b getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b();
    }

    @o0
    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f7776o;
    }

    @o0
    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.f7777p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    @m0
    ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.f7770i) == null) ? new ArrayList<>() : arrayList;
    }

    @m0
    ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        return (iVar == null || (arrayList = iVar.f7771j) == null) ? new ArrayList<>() : arrayList;
    }

    @m0
    public final String getString(@a1 int i7) {
        return getResources().getString(i7);
    }

    @o0
    public final String getTag() {
        return this.mTag;
    }

    @o0
    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.n0(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    @m0
    public final CharSequence getText(@a1 int i7) {
        return getResources().getText(i7);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    @o0
    public View getView() {
        return this.mView;
    }

    @m0
    @j0
    public androidx.lifecycle.q getViewLifecycleOwner() {
        z zVar = this.mViewLifecycleOwner;
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    @m0
    public LiveData<androidx.lifecycle.q> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.q0
    @m0
    public p0 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (s() != androidx.lifecycle.m.c.INITIALIZED.ordinal()) {
            return this.mFragmentManager.O0(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        t();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new androidx.fragment.app.k();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f7786y;
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        return this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.V0(this.mParentFragment));
    }

    boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.f7784w;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.Y0();
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    void noteStateNotSaved() {
        this.mChildFragmentManager.h1();
    }

    @c.i
    @j0
    @Deprecated
    public void onActivityCreated(@o0 Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i7, int i8, @o0 Intent intent) {
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i7 + " resultCode: " + i8 + " data: " + intent);
        }
    }

    @c.i
    @j0
    public void onAttach(@m0 Context context) {
        this.mCalled = true;
        androidx.fragment.app.h<?> hVar = this.mHost;
        Activity activityE = hVar == null ? null : hVar.e();
        if (activityE != null) {
            this.mCalled = false;
            onAttach(activityE);
        }
    }

    @j0
    @Deprecated
    public void onAttachFragment(@m0 Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    @c.i
    public void onConfigurationChanged(@m0 Configuration configuration) {
        this.mCalled = true;
    }

    @j0
    public boolean onContextItemSelected(@m0 MenuItem menuItem) {
        return false;
    }

    @c.i
    @j0
    public void onCreate(@o0 Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.X0(1)) {
            return;
        }
        this.mChildFragmentManager.H();
    }

    @o0
    @j0
    public Animation onCreateAnimation(int i7, boolean z7, int i8) {
        return null;
    }

    @o0
    @j0
    public Animator onCreateAnimator(int i7, boolean z7, int i8) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    @j0
    public void onCreateContextMenu(@m0 ContextMenu contextMenu, @m0 View view, @o0 ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @j0
    public void onCreateOptionsMenu(@m0 Menu menu, @m0 MenuInflater menuInflater) {
    }

    @o0
    @j0
    public View onCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        int i7 = this.mContentLayoutId;
        if (i7 != 0) {
            return layoutInflater.inflate(i7, viewGroup, false);
        }
        return null;
    }

    @c.i
    @j0
    public void onDestroy() {
        this.mCalled = true;
    }

    @j0
    public void onDestroyOptionsMenu() {
    }

    @c.i
    @j0
    public void onDestroyView() {
        this.mCalled = true;
    }

    @c.i
    @j0
    public void onDetach() {
        this.mCalled = true;
    }

    @m0
    public LayoutInflater onGetLayoutInflater(@o0 Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    @j0
    public void onHiddenChanged(boolean z7) {
    }

    @f1
    @c.i
    public void onInflate(@m0 Context context, @m0 AttributeSet attributeSet, @o0 Bundle bundle) {
        this.mCalled = true;
        androidx.fragment.app.h<?> hVar = this.mHost;
        Activity activityE = hVar == null ? null : hVar.e();
        if (activityE != null) {
            this.mCalled = false;
            onInflate(activityE, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    @c.i
    @j0
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z7) {
    }

    @j0
    public boolean onOptionsItemSelected(@m0 MenuItem menuItem) {
        return false;
    }

    @j0
    public void onOptionsMenuClosed(@m0 Menu menu) {
    }

    @c.i
    @j0
    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z7) {
    }

    @j0
    public void onPrepareOptionsMenu(@m0 Menu menu) {
    }

    @j0
    public void onPrimaryNavigationFragmentChanged(boolean z7) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i7, @m0 String[] strArr, @m0 int[] iArr) {
    }

    @c.i
    @j0
    public void onResume() {
        this.mCalled = true;
    }

    @j0
    public void onSaveInstanceState(@m0 Bundle bundle) {
    }

    @c.i
    @j0
    public void onStart() {
        this.mCalled = true;
    }

    @c.i
    @j0
    public void onStop() {
        this.mCalled = true;
    }

    @j0
    public void onViewCreated(@m0 View view, @o0 Bundle bundle) {
    }

    @c.i
    @j0
    public void onViewStateRestored(@o0 Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.h1();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            w();
            this.mChildFragmentManager.D();
        } else {
            throw new e0("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    void performAttach() {
        Iterator<k> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.p(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.f());
        if (this.mCalled) {
            this.mFragmentManager.N(this);
            this.mChildFragmentManager.E();
        } else {
            throw new e0("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    void performConfigurationChanged(@m0 Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.F(configuration);
    }

    boolean performContextItemSelected(@m0 MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.G(menuItem);
    }

    void performCreate(Bundle bundle) {
        this.mChildFragmentManager.h1();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new androidx.lifecycle.o() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.lifecycle.o
            public void g(@m0 androidx.lifecycle.q qVar, @m0 androidx.lifecycle.m.b bVar) {
                View view;
                if (bVar != androidx.lifecycle.m.b.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                view.cancelPendingInputEvents();
            }
        });
        this.mSavedStateRegistryController.d(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.j(androidx.lifecycle.m.b.ON_CREATE);
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onCreate()");
    }

    boolean performCreateOptionsMenu(@m0 Menu menu, @m0 MenuInflater menuInflater) {
        boolean z7 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z7 = true;
        }
        return z7 | this.mChildFragmentManager.I(menu, menuInflater);
    }

    void performCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        this.mChildFragmentManager.h1();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new z(this, getViewModelStore());
        View viewOnCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = viewOnCreateView;
        if (viewOnCreateView == null) {
            if (this.mViewLifecycleOwner.c()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        } else {
            this.mViewLifecycleOwner.b();
            r0.b(this.mView, this.mViewLifecycleOwner);
            t0.b(this.mView, this.mViewLifecycleOwner);
            androidx.savedstate.e.b(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.q(this.mViewLifecycleOwner);
        }
    }

    void performDestroy() {
        this.mChildFragmentManager.J();
        this.mLifecycleRegistry.j(androidx.lifecycle.m.b.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        this.mChildFragmentManager.K();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().b().a(androidx.lifecycle.m.c.CREATED)) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.m.b.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            androidx.loader.app.a.d(this).h();
            this.mPerformedCreateView = false;
        } else {
            throw new e0("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.S0()) {
                return;
            }
            this.mChildFragmentManager.J();
            this.mChildFragmentManager = new androidx.fragment.app.k();
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onDetach()");
    }

    @m0
    LayoutInflater performGetLayoutInflater(@o0 Bundle bundle) {
        LayoutInflater layoutInflaterOnGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = layoutInflaterOnGetLayoutInflater;
        return layoutInflaterOnGetLayoutInflater;
    }

    void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.L();
    }

    void performMultiWindowModeChanged(boolean z7) {
        onMultiWindowModeChanged(z7);
        this.mChildFragmentManager.M(z7);
    }

    boolean performOptionsItemSelected(@m0 MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.O(menuItem);
    }

    void performOptionsMenuClosed(@m0 Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.P(menu);
    }

    void performPause() {
        this.mChildFragmentManager.R();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.m.b.ON_PAUSE);
        }
        this.mLifecycleRegistry.j(androidx.lifecycle.m.b.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onPause()");
    }

    void performPictureInPictureModeChanged(boolean z7) {
        onPictureInPictureModeChanged(z7);
        this.mChildFragmentManager.S(z7);
    }

    boolean performPrepareOptionsMenu(@m0 Menu menu) {
        boolean z7 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z7 = true;
        }
        return z7 | this.mChildFragmentManager.T(menu);
    }

    void performPrimaryNavigationFragmentChanged() {
        boolean zW0 = this.mFragmentManager.W0(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != zW0) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(zW0);
            onPrimaryNavigationFragmentChanged(zW0);
            this.mChildFragmentManager.U();
        }
    }

    void performResume() {
        this.mChildFragmentManager.h1();
        this.mChildFragmentManager.h0(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new e0("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.r rVar = this.mLifecycleRegistry;
        androidx.lifecycle.m.b bVar = androidx.lifecycle.m.b.ON_RESUME;
        rVar.j(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.V();
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.e(bundle);
        Parcelable parcelableH1 = this.mChildFragmentManager.H1();
        if (parcelableH1 != null) {
            bundle.putParcelable("android:support:fragments", parcelableH1);
        }
    }

    void performStart() {
        this.mChildFragmentManager.h1();
        this.mChildFragmentManager.h0(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new e0("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.r rVar = this.mLifecycleRegistry;
        androidx.lifecycle.m.b bVar = androidx.lifecycle.m.b.ON_START;
        rVar.j(bVar);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(bVar);
        }
        this.mChildFragmentManager.W();
    }

    void performStop() {
        this.mChildFragmentManager.Y();
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(androidx.lifecycle.m.b.ON_STOP);
        }
        this.mLifecycleRegistry.j(androidx.lifecycle.m.b.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new e0("Fragment " + this + " did not call through to super.onStop()");
    }

    void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.Z();
    }

    public void postponeEnterTransition() {
        q().f7784w = true;
    }

    @Override // androidx.activity.result.b
    @m0
    @j0
    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(@m0 b.a<I, O> aVar, @m0 androidx.activity.result.a<O> aVar2) {
        return u(aVar, new e(), aVar2);
    }

    public void registerForContextMenu(@m0 View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(@m0 String[] strArr, int i7) {
        if (this.mHost != null) {
            getParentFragmentManager().Z0(this, strArr, i7);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @m0
    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @m0
    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this + " does not have any arguments.");
    }

    @m0
    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    @m0
    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    @m0
    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a host.");
    }

    @m0
    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException("Fragment " + this + " is not attached to any Fragment or host");
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    @m0
    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    void restoreChildFragmentState(@o0 Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.E1(parcelable);
        this.mChildFragmentManager.H();
    }

    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.d(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(androidx.lifecycle.m.b.ON_CREATE);
            }
        } else {
            throw new e0("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z7) {
        q().f7779r = Boolean.valueOf(z7);
    }

    public void setAllowReturnTransitionOverlap(boolean z7) {
        q().f7778q = Boolean.valueOf(z7);
    }

    void setAnimatingAway(View view) {
        q().f7762a = view;
    }

    void setAnimations(int i7, int i8, int i9, int i10) {
        if (this.mAnimationInfo == null && i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) {
            return;
        }
        q().f7765d = i7;
        q().f7766e = i8;
        q().f7767f = i9;
        q().f7768g = i10;
    }

    void setAnimator(Animator animator) {
        q().f7763b = animator;
    }

    public void setArguments(@o0 Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(@o0 d7 d7Var) {
        q().f7780s = d7Var;
    }

    public void setEnterTransition(@o0 Object obj) {
        q().f7772k = obj;
    }

    public void setExitSharedElementCallback(@o0 d7 d7Var) {
        q().f7781t = d7Var;
    }

    public void setExitTransition(@o0 Object obj) {
        q().f7774m = obj;
    }

    void setFocusedView(View view) {
        q().f7783v = view;
    }

    public void setHasOptionsMenu(boolean z7) {
        if (this.mHasMenu != z7) {
            this.mHasMenu = z7;
            if (!isAdded() || isHidden()) {
                return;
            }
            this.mHost.s();
        }
    }

    void setHideReplaced(boolean z7) {
        q().f7786y = z7;
    }

    public void setInitialSavedState(@o0 SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (savedState == null || (bundle = savedState.f7745a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z7) {
        if (this.mMenuVisible != z7) {
            this.mMenuVisible = z7;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.s();
            }
        }
    }

    void setNextTransition(int i7) {
        if (this.mAnimationInfo == null && i7 == 0) {
            return;
        }
        q();
        this.mAnimationInfo.f7769h = i7;
    }

    void setOnStartEnterTransitionListener(l lVar) {
        q();
        i iVar = this.mAnimationInfo;
        l lVar2 = iVar.f7785x;
        if (lVar == lVar2) {
            return;
        }
        if (lVar != null && lVar2 != null) {
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
        if (iVar.f7784w) {
            iVar.f7785x = lVar;
        }
        if (lVar != null) {
            lVar.a();
        }
    }

    void setPopDirection(boolean z7) {
        if (this.mAnimationInfo == null) {
            return;
        }
        q().f7764c = z7;
    }

    void setPostOnViewCreatedAlpha(float f8) {
        q().f7782u = f8;
    }

    public void setReenterTransition(@o0 Object obj) {
        q().f7775n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z7) {
        this.mRetainInstance = z7;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z7) {
            fragmentManager.n(this);
        } else {
            fragmentManager.B1(this);
        }
    }

    public void setReturnTransition(@o0 Object obj) {
        q().f7773l = obj;
    }

    public void setSharedElementEnterTransition(@o0 Object obj) {
        q().f7776o = obj;
    }

    void setSharedElementNames(@o0 ArrayList<String> arrayList, @o0 ArrayList<String> arrayList2) {
        q();
        i iVar = this.mAnimationInfo;
        iVar.f7770i = arrayList;
        iVar.f7771j = arrayList2;
    }

    public void setSharedElementReturnTransition(@o0 Object obj) {
        q().f7777p = obj;
    }

    @Deprecated
    public void setTargetFragment(@o0 Fragment fragment, int i7) {
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager != null && fragmentManager2 != null && fragmentManager != fragmentManager2) {
            throw new IllegalArgumentException("Fragment " + fragment + " must share the same FragmentManager to be set as a target fragment");
        }
        for (Fragment targetFragment = fragment; targetFragment != null; targetFragment = targetFragment.getTargetFragment()) {
            if (targetFragment.equals(this)) {
                throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
            }
        }
        if (fragment == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = fragment;
        } else {
            this.mTargetWho = fragment.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i7;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z7) {
        if (!this.mUserVisibleHint && z7 && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.k1(fragmentManager.A(this));
        }
        this.mUserVisibleHint = z7;
        this.mDeferStart = this.mState < 5 && !z7;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z7);
        }
    }

    public boolean shouldShowRequestPermissionRationale(@m0 String str) {
        androidx.fragment.app.h<?> hVar = this.mHost;
        if (hVar != null) {
            return hVar.o(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i7) {
        startActivityForResult(intent, i7, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i7, @o0 Intent intent, int i8, int i9, int i10, @o0 Bundle bundle) throws IntentSender.SendIntentException {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        if (FragmentManager.T0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i7 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        getParentFragmentManager().b1(this, intentSender, i7, intent, i8, i9, i10, bundle);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !q().f7784w) {
            return;
        }
        if (this.mHost == null) {
            q().f7784w = false;
        } else if (Looper.myLooper() != this.mHost.g().getLooper()) {
            this.mHost.g().postAtFrontOfQueue(new b());
        } else {
            callStartTransitionListener(true);
        }
    }

    @m0
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(com.alipay.sdk.util.j.f13808d);
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(@m0 View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {

        @m0
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Bundle f7745a;

        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState(Bundle bundle) {
            this.f7745a = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@m0 Parcel parcel, int i7) {
            parcel.writeBundle(this.f7745a);
        }

        SavedState(@m0 Parcel parcel, @o0 ClassLoader classLoader) {
            Bundle bundle = parcel.readBundle();
            this.f7745a = bundle;
            if (classLoader == null || bundle == null) {
                return;
            }
            bundle.setClassLoader(classLoader);
        }
    }

    @m0
    @Deprecated
    public static Fragment instantiate(@m0 Context context, @m0 String str, @o0 Bundle bundle) {
        try {
            Fragment fragmentNewInstance = androidx.fragment.app.g.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragmentNewInstance.getClass().getClassLoader());
                fragmentNewInstance.setArguments(bundle);
            }
            return fragmentNewInstance;
        } catch (IllegalAccessException e8) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e8);
        } catch (InstantiationException e9) {
            throw new j("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e9);
        } catch (NoSuchMethodException e10) {
            throw new j("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e10);
        } catch (InvocationTargetException e11) {
            throw new j("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e11);
        }
    }

    @m0
    public final String getString(@a1 int i7, @o0 Object... objArr) {
        return getResources().getString(i7, objArr);
    }

    public final void postponeEnterTransition(long j7, @m0 TimeUnit timeUnit) {
        q().f7784w = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        Handler handlerG = fragmentManager != null ? fragmentManager.H0().g() : new Handler(Looper.getMainLooper());
        handlerG.removeCallbacks(this.mPostponedDurationRunnable);
        handlerG.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j7));
    }

    @Override // androidx.activity.result.b
    @m0
    @j0
    public final <I, O> androidx.activity.result.c<I> registerForActivityResult(@m0 b.a<I, O> aVar, @m0 ActivityResultRegistry activityResultRegistry, @m0 androidx.activity.result.a<O> aVar2) {
        return u(aVar, new f(activityResultRegistry), aVar2);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, @o0 Bundle bundle) {
        androidx.fragment.app.h<?> hVar = this.mHost;
        if (hVar != null) {
            hVar.q(this, intent, -1, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i7, @o0 Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().a1(this, intent, i7, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @x0({x0.a.LIBRARY_GROUP_PREFIX})
    @m0
    @Deprecated
    public LayoutInflater getLayoutInflater(@o0 Bundle bundle) {
        androidx.fragment.app.h<?> hVar = this.mHost;
        if (hVar != null) {
            LayoutInflater layoutInflaterJ = hVar.j();
            androidx.core.view.q0.d(layoutInflaterJ, this.mChildFragmentManager.I0());
            return layoutInflaterJ;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @c.i
    @j0
    @Deprecated
    public void onAttach(@m0 Activity activity) {
        this.mCalled = true;
    }

    @f1
    @c.i
    @Deprecated
    public void onInflate(@m0 Activity activity, @m0 AttributeSet attributeSet, @o0 Bundle bundle) {
        this.mCalled = true;
    }

    @c.o
    public Fragment(@h0 int i7) {
        this();
        this.mContentLayoutId = i7;
    }
}
