package androidx.fragment.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.n2;
import androidx.fragment.R;
import androidx.lifecycle.q0;
import c.m0;
import c.o0;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: loaded from: classes.dex */
class r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8035f = "FragmentManager";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8036g = "android:target_req_state";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f8037h = "android:target_state";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f8038i = "android:view_state";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f8039j = "android:view_registry_state";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f8040k = "android:user_visible_hint";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f8041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f8042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @m0
    private final Fragment f8043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8044d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8045e = -1;

    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f8046a;

        a(View view) {
            this.f8046a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f8046a.removeOnAttachStateChangeListener(this);
            n2.v1(this.f8046a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8048a;

        static {
            int[] iArr = new int[androidx.lifecycle.m.c.values().length];
            f8048a = iArr;
            try {
                iArr[androidx.lifecycle.m.c.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8048a[androidx.lifecycle.m.c.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8048a[androidx.lifecycle.m.c.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8048a[androidx.lifecycle.m.c.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    r(@m0 j jVar, @m0 u uVar, @m0 Fragment fragment) {
        this.f8041a = jVar;
        this.f8042b = uVar;
        this.f8043c = fragment;
    }

    private boolean l(@m0 View view) {
        if (view == this.f8043c.mView) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f8043c.mView) {
                return true;
            }
        }
        return false;
    }

    private Bundle q() {
        Bundle bundle = new Bundle();
        this.f8043c.performSaveInstanceState(bundle);
        this.f8041a.j(this.f8043c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.f8043c.mView != null) {
            t();
        }
        if (this.f8043c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray(f8038i, this.f8043c.mSavedViewState);
        }
        if (this.f8043c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle(f8039j, this.f8043c.mSavedViewRegistryState);
        }
        if (!this.f8043c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean(f8040k, this.f8043c.mUserVisibleHint);
        }
        return bundle;
    }

    void a() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "moveto ACTIVITY_CREATED: " + this.f8043c);
        }
        Fragment fragment = this.f8043c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        j jVar = this.f8041a;
        Fragment fragment2 = this.f8043c;
        jVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    void b() {
        int iJ = this.f8042b.j(this.f8043c);
        Fragment fragment = this.f8043c;
        fragment.mContainer.addView(fragment.mView, iJ);
    }

    void c() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "moveto ATTACHED: " + this.f8043c);
        }
        Fragment fragment = this.f8043c;
        Fragment fragment2 = fragment.mTarget;
        r rVarN = null;
        if (fragment2 != null) {
            r rVarN2 = this.f8042b.n(fragment2.mWho);
            if (rVarN2 == null) {
                throw new IllegalStateException("Fragment " + this.f8043c + " declared target fragment " + this.f8043c.mTarget + " that does not belong to this FragmentManager!");
            }
            Fragment fragment3 = this.f8043c;
            fragment3.mTargetWho = fragment3.mTarget.mWho;
            fragment3.mTarget = null;
            rVarN = rVarN2;
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (rVarN = this.f8042b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f8043c + " declared target fragment " + this.f8043c.mTargetWho + " that does not belong to this FragmentManager!");
            }
        }
        if (rVarN != null && (FragmentManager.Q || rVarN.k().mState < 1)) {
            rVarN.m();
        }
        Fragment fragment4 = this.f8043c;
        fragment4.mHost = fragment4.mFragmentManager.H0();
        Fragment fragment5 = this.f8043c;
        fragment5.mParentFragment = fragment5.mFragmentManager.K0();
        this.f8041a.g(this.f8043c, false);
        this.f8043c.performAttach();
        this.f8041a.b(this.f8043c, false);
    }

    int d() {
        Fragment fragment;
        ViewGroup viewGroup;
        Fragment fragment2 = this.f8043c;
        if (fragment2.mFragmentManager == null) {
            return fragment2.mState;
        }
        int iMin = this.f8045e;
        int i7 = b.f8048a[fragment2.mMaxState.ordinal()];
        if (i7 != 1) {
            if (i7 == 2) {
                iMin = Math.min(iMin, 5);
            } else if (i7 != 3) {
                iMin = i7 != 4 ? Math.min(iMin, -1) : Math.min(iMin, 0);
            } else {
                iMin = Math.min(iMin, 1);
            }
        }
        Fragment fragment3 = this.f8043c;
        if (fragment3.mFromLayout) {
            if (fragment3.mInLayout) {
                iMin = Math.max(this.f8045e, 2);
                View view = this.f8043c.mView;
                if (view != null && view.getParent() == null) {
                    iMin = Math.min(iMin, 2);
                }
            } else {
                iMin = this.f8045e < 4 ? Math.min(iMin, fragment3.mState) : Math.min(iMin, 1);
            }
        }
        if (!this.f8043c.mAdded) {
            iMin = Math.min(iMin, 1);
        }
        c0.e.b bVarL = (!FragmentManager.Q || (viewGroup = (fragment = this.f8043c).mContainer) == null) ? null : c0.n(viewGroup, fragment.getParentFragmentManager()).l(this);
        if (bVarL == c0.e.b.ADDING) {
            iMin = Math.min(iMin, 6);
        } else if (bVarL == c0.e.b.REMOVING) {
            iMin = Math.max(iMin, 3);
        } else {
            Fragment fragment4 = this.f8043c;
            if (fragment4.mRemoving) {
                iMin = fragment4.isInBackStack() ? Math.min(iMin, 1) : Math.min(iMin, -1);
            }
        }
        Fragment fragment5 = this.f8043c;
        if (fragment5.mDeferStart && fragment5.mState < 5) {
            iMin = Math.min(iMin, 4);
        }
        if (FragmentManager.T0(2)) {
            Log.v(f8035f, "computeExpectedState() of " + iMin + " for " + this.f8043c);
        }
        return iMin;
    }

    void e() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "moveto CREATED: " + this.f8043c);
        }
        Fragment fragment = this.f8043c;
        if (fragment.mIsCreated) {
            fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
            this.f8043c.mState = 1;
            return;
        }
        this.f8041a.h(fragment, fragment.mSavedFragmentState, false);
        Fragment fragment2 = this.f8043c;
        fragment2.performCreate(fragment2.mSavedFragmentState);
        j jVar = this.f8041a;
        Fragment fragment3 = this.f8043c;
        jVar.c(fragment3, fragment3.mSavedFragmentState, false);
    }

    void f() {
        String resourceName;
        if (this.f8043c.mFromLayout) {
            return;
        }
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "moveto CREATE_VIEW: " + this.f8043c);
        }
        Fragment fragment = this.f8043c;
        LayoutInflater layoutInflaterPerformGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
        Fragment fragment2 = this.f8043c;
        ViewGroup viewGroup = fragment2.mContainer;
        if (viewGroup == null) {
            int i7 = fragment2.mContainerId;
            if (i7 == 0) {
                viewGroup = null;
            } else {
                if (i7 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f8043c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) fragment2.mFragmentManager.B0().c(this.f8043c.mContainerId);
                if (viewGroup == null) {
                    Fragment fragment3 = this.f8043c;
                    if (!fragment3.mRestored) {
                        try {
                            resourceName = fragment3.getResources().getResourceName(this.f8043c.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            resourceName = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f8043c.mContainerId) + " (" + resourceName + ") for fragment " + this.f8043c);
                    }
                }
            }
        }
        Fragment fragment4 = this.f8043c;
        fragment4.mContainer = viewGroup;
        fragment4.performCreateView(layoutInflaterPerformGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
        View view = this.f8043c.mView;
        if (view != null) {
            boolean z7 = false;
            view.setSaveFromParentEnabled(false);
            Fragment fragment5 = this.f8043c;
            fragment5.mView.setTag(R.id.fragment_container_view_tag, fragment5);
            if (viewGroup != null) {
                b();
            }
            Fragment fragment6 = this.f8043c;
            if (fragment6.mHidden) {
                fragment6.mView.setVisibility(8);
            }
            if (n2.O0(this.f8043c.mView)) {
                n2.v1(this.f8043c.mView);
            } else {
                View view2 = this.f8043c.mView;
                view2.addOnAttachStateChangeListener(new a(view2));
            }
            this.f8043c.performViewCreated();
            j jVar = this.f8041a;
            Fragment fragment7 = this.f8043c;
            jVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
            int visibility = this.f8043c.mView.getVisibility();
            float alpha = this.f8043c.mView.getAlpha();
            if (FragmentManager.Q) {
                this.f8043c.setPostOnViewCreatedAlpha(alpha);
                Fragment fragment8 = this.f8043c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View viewFindFocus = fragment8.mView.findFocus();
                    if (viewFindFocus != null) {
                        this.f8043c.setFocusedView(viewFindFocus);
                        if (FragmentManager.T0(2)) {
                            Log.v(f8035f, "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + this.f8043c);
                        }
                    }
                    this.f8043c.mView.setAlpha(0.0f);
                }
            } else {
                Fragment fragment9 = this.f8043c;
                if (visibility == 0 && fragment9.mContainer != null) {
                    z7 = true;
                }
                fragment9.mIsNewlyAdded = z7;
            }
        }
        this.f8043c.mState = 2;
    }

    void g() {
        Fragment fragmentF;
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "movefrom CREATED: " + this.f8043c);
        }
        Fragment fragment = this.f8043c;
        boolean zIsChangingConfigurations = true;
        boolean z7 = fragment.mRemoving && !fragment.isInBackStack();
        if (!(z7 || this.f8042b.p().s(this.f8043c))) {
            String str = this.f8043c.mTargetWho;
            if (str != null && (fragmentF = this.f8042b.f(str)) != null && fragmentF.mRetainInstance) {
                this.f8043c.mTarget = fragmentF;
            }
            this.f8043c.mState = 0;
            return;
        }
        h<?> hVar = this.f8043c.mHost;
        if (hVar instanceof q0) {
            zIsChangingConfigurations = this.f8042b.p().o();
        } else if (hVar.f() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) hVar.f()).isChangingConfigurations();
        }
        if (z7 || zIsChangingConfigurations) {
            this.f8042b.p().h(this.f8043c);
        }
        this.f8043c.performDestroy();
        this.f8041a.d(this.f8043c, false);
        for (r rVar : this.f8042b.l()) {
            if (rVar != null) {
                Fragment fragmentK = rVar.k();
                if (this.f8043c.mWho.equals(fragmentK.mTargetWho)) {
                    fragmentK.mTarget = this.f8043c;
                    fragmentK.mTargetWho = null;
                }
            }
        }
        Fragment fragment2 = this.f8043c;
        String str2 = fragment2.mTargetWho;
        if (str2 != null) {
            fragment2.mTarget = this.f8042b.f(str2);
        }
        this.f8042b.r(this);
    }

    void h() {
        View view;
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "movefrom CREATE_VIEW: " + this.f8043c);
        }
        Fragment fragment = this.f8043c;
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null && (view = fragment.mView) != null) {
            viewGroup.removeView(view);
        }
        this.f8043c.performDestroyView();
        this.f8041a.n(this.f8043c, false);
        Fragment fragment2 = this.f8043c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.q(null);
        this.f8043c.mInLayout = false;
    }

    void i() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "movefrom ATTACHED: " + this.f8043c);
        }
        this.f8043c.performDetach();
        boolean z7 = false;
        this.f8041a.e(this.f8043c, false);
        Fragment fragment = this.f8043c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z7 = true;
        }
        if (z7 || this.f8042b.p().s(this.f8043c)) {
            if (FragmentManager.T0(3)) {
                Log.d(f8035f, "initState called for fragment: " + this.f8043c);
            }
            this.f8043c.initState();
        }
    }

    void j() {
        Fragment fragment = this.f8043c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.T0(3)) {
                Log.d(f8035f, "moveto CREATE_VIEW: " + this.f8043c);
            }
            Fragment fragment2 = this.f8043c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.f8043c.mSavedFragmentState);
            View view = this.f8043c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.f8043c;
                fragment3.mView.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.f8043c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.f8043c.performViewCreated();
                j jVar = this.f8041a;
                Fragment fragment5 = this.f8043c;
                jVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.f8043c.mState = 2;
            }
        }
    }

    @m0
    Fragment k() {
        return this.f8043c;
    }

    void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f8044d) {
            if (FragmentManager.T0(2)) {
                Log.v(f8035f, "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f8044d = true;
            while (true) {
                int iD = d();
                Fragment fragment = this.f8043c;
                int i7 = fragment.mState;
                if (iD == i7) {
                    if (FragmentManager.Q && fragment.mHiddenChanged) {
                        if (fragment.mView != null && (viewGroup = fragment.mContainer) != null) {
                            c0 c0VarN = c0.n(viewGroup, fragment.getParentFragmentManager());
                            if (this.f8043c.mHidden) {
                                c0VarN.c(this);
                            } else {
                                c0VarN.e(this);
                            }
                        }
                        Fragment fragment2 = this.f8043c;
                        FragmentManager fragmentManager = fragment2.mFragmentManager;
                        if (fragmentManager != null) {
                            fragmentManager.R0(fragment2);
                        }
                        Fragment fragment3 = this.f8043c;
                        fragment3.mHiddenChanged = false;
                        fragment3.onHiddenChanged(fragment3.mHidden);
                    }
                    return;
                }
                if (iD <= i7) {
                    switch (i7 - 1) {
                        case -1:
                            i();
                            break;
                        case 0:
                            g();
                            break;
                        case 1:
                            h();
                            this.f8043c.mState = 1;
                            break;
                        case 2:
                            fragment.mInLayout = false;
                            fragment.mState = 2;
                            break;
                        case 3:
                            if (FragmentManager.T0(3)) {
                                Log.d(f8035f, "movefrom ACTIVITY_CREATED: " + this.f8043c);
                            }
                            Fragment fragment4 = this.f8043c;
                            if (fragment4.mView != null && fragment4.mSavedViewState == null) {
                                t();
                            }
                            Fragment fragment5 = this.f8043c;
                            if (fragment5.mView != null && (viewGroup3 = fragment5.mContainer) != null) {
                                c0.n(viewGroup3, fragment5.getParentFragmentManager()).d(this);
                            }
                            this.f8043c.mState = 3;
                            break;
                        case 4:
                            w();
                            break;
                        case 5:
                            fragment.mState = 5;
                            break;
                        case 6:
                            n();
                            break;
                    }
                } else {
                    switch (i7 + 1) {
                        case 0:
                            c();
                            break;
                        case 1:
                            e();
                            break;
                        case 2:
                            j();
                            f();
                            break;
                        case 3:
                            a();
                            break;
                        case 4:
                            if (fragment.mView != null && (viewGroup2 = fragment.mContainer) != null) {
                                c0.n(viewGroup2, fragment.getParentFragmentManager()).b(c0.e.c.b(this.f8043c.mView.getVisibility()), this);
                            }
                            this.f8043c.mState = 4;
                            break;
                        case 5:
                            v();
                            break;
                        case 6:
                            fragment.mState = 6;
                            break;
                        case 7:
                            p();
                            break;
                    }
                }
            }
        } finally {
            this.f8044d = false;
        }
    }

    void n() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "movefrom RESUMED: " + this.f8043c);
        }
        this.f8043c.performPause();
        this.f8041a.f(this.f8043c, false);
    }

    void o(@m0 ClassLoader classLoader) {
        Bundle bundle = this.f8043c.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        Fragment fragment = this.f8043c;
        fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray(f8038i);
        Fragment fragment2 = this.f8043c;
        fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle(f8039j);
        Fragment fragment3 = this.f8043c;
        fragment3.mTargetWho = fragment3.mSavedFragmentState.getString(f8037h);
        Fragment fragment4 = this.f8043c;
        if (fragment4.mTargetWho != null) {
            fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt(f8036g, 0);
        }
        Fragment fragment5 = this.f8043c;
        Boolean bool = fragment5.mSavedUserVisibleHint;
        if (bool != null) {
            fragment5.mUserVisibleHint = bool.booleanValue();
            this.f8043c.mSavedUserVisibleHint = null;
        } else {
            fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean(f8040k, true);
        }
        Fragment fragment6 = this.f8043c;
        if (fragment6.mUserVisibleHint) {
            return;
        }
        fragment6.mDeferStart = true;
    }

    void p() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "moveto RESUMED: " + this.f8043c);
        }
        View focusedView = this.f8043c.getFocusedView();
        if (focusedView != null && l(focusedView)) {
            boolean zRequestFocus = focusedView.requestFocus();
            if (FragmentManager.T0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(zRequestFocus ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : com.alipay.sdk.util.f.f13791i);
                sb.append(" on Fragment ");
                sb.append(this.f8043c);
                sb.append(" resulting in focused view ");
                sb.append(this.f8043c.mView.findFocus());
                Log.v(f8035f, sb.toString());
            }
        }
        this.f8043c.setFocusedView(null);
        this.f8043c.performResume();
        this.f8041a.i(this.f8043c, false);
        Fragment fragment = this.f8043c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    @o0
    Fragment.SavedState r() {
        Bundle bundleQ;
        if (this.f8043c.mState <= -1 || (bundleQ = q()) == null) {
            return null;
        }
        return new Fragment.SavedState(bundleQ);
    }

    @m0
    FragmentState s() {
        FragmentState fragmentState = new FragmentState(this.f8043c);
        Fragment fragment = this.f8043c;
        if (fragment.mState <= -1 || fragmentState.f7871m != null) {
            fragmentState.f7871m = fragment.mSavedFragmentState;
        } else {
            Bundle bundleQ = q();
            fragmentState.f7871m = bundleQ;
            if (this.f8043c.mTargetWho != null) {
                if (bundleQ == null) {
                    fragmentState.f7871m = new Bundle();
                }
                fragmentState.f7871m.putString(f8037h, this.f8043c.mTargetWho);
                int i7 = this.f8043c.mTargetRequestCode;
                if (i7 != 0) {
                    fragmentState.f7871m.putInt(f8036g, i7);
                }
            }
        }
        return fragmentState;
    }

    void t() {
        if (this.f8043c.mView == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f8043c.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f8043c.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f8043c.mViewLifecycleOwner.e(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f8043c.mSavedViewRegistryState = bundle;
    }

    void u(int i7) {
        this.f8045e = i7;
    }

    void v() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "moveto STARTED: " + this.f8043c);
        }
        this.f8043c.performStart();
        this.f8041a.k(this.f8043c, false);
    }

    void w() {
        if (FragmentManager.T0(3)) {
            Log.d(f8035f, "movefrom STARTED: " + this.f8043c);
        }
        this.f8043c.performStop();
        this.f8041a.l(this.f8043c, false);
    }

    r(@m0 j jVar, @m0 u uVar, @m0 ClassLoader classLoader, @m0 g gVar, @m0 FragmentState fragmentState) {
        this.f8041a = jVar;
        this.f8042b = uVar;
        Fragment fragmentA = gVar.a(classLoader, fragmentState.f7859a);
        this.f8043c = fragmentA;
        Bundle bundle = fragmentState.f7868j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        fragmentA.setArguments(fragmentState.f7868j);
        fragmentA.mWho = fragmentState.f7860b;
        fragmentA.mFromLayout = fragmentState.f7861c;
        fragmentA.mRestored = true;
        fragmentA.mFragmentId = fragmentState.f7862d;
        fragmentA.mContainerId = fragmentState.f7863e;
        fragmentA.mTag = fragmentState.f7864f;
        fragmentA.mRetainInstance = fragmentState.f7865g;
        fragmentA.mRemoving = fragmentState.f7866h;
        fragmentA.mDetached = fragmentState.f7867i;
        fragmentA.mHidden = fragmentState.f7869k;
        fragmentA.mMaxState = androidx.lifecycle.m.c.values()[fragmentState.f7870l];
        Bundle bundle2 = fragmentState.f7871m;
        if (bundle2 != null) {
            fragmentA.mSavedFragmentState = bundle2;
        } else {
            fragmentA.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.T0(2)) {
            Log.v(f8035f, "Instantiated fragment " + fragmentA);
        }
    }

    r(@m0 j jVar, @m0 u uVar, @m0 Fragment fragment, @m0 FragmentState fragmentState) {
        this.f8041a = jVar;
        this.f8042b = uVar;
        this.f8043c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.f7871m;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
