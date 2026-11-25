package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.p;
import androidx.navigation.q;
import androidx.navigation.v;
import androidx.navigation.w;
import c.i;
import c.l0;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
public class b extends Fragment implements p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8824f = "android-support-nav:fragment:graphId";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8825g = "android-support-nav:fragment:startDestinationArgs";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f8826h = "android-support-nav:fragment:navControllerState";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f8827i = "android-support-nav:fragment:defaultHost";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private q f8828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f8829b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private View f8830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8831d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8832e;

    @m0
    public static b A(@l0 int i7) {
        return B(i7, null);
    }

    @m0
    public static b B(@l0 int i7, @o0 Bundle bundle) {
        Bundle bundle2;
        if (i7 != 0) {
            bundle2 = new Bundle();
            bundle2.putInt(f8824f, i7);
        } else {
            bundle2 = null;
        }
        if (bundle != null) {
            if (bundle2 == null) {
                bundle2 = new Bundle();
            }
            bundle2.putBundle(f8825g, bundle);
        }
        b bVar = new b();
        if (bundle2 != null) {
            bVar.setArguments(bundle2);
        }
        return bVar;
    }

    @m0
    public static NavController D(@m0 Fragment fragment) {
        for (Fragment parentFragment = fragment; parentFragment != null; parentFragment = parentFragment.getParentFragment()) {
            if (parentFragment instanceof b) {
                return ((b) parentFragment).o();
            }
            Fragment fragmentL0 = parentFragment.getParentFragmentManager().L0();
            if (fragmentL0 instanceof b) {
                return ((b) fragmentL0).o();
            }
        }
        View view = fragment.getView();
        if (view != null) {
            return v.e(view);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a NavController set");
    }

    private int E() {
        int id = getId();
        return (id == 0 || id == -1) ? R.id.nav_host_fragment_container : id;
    }

    @m0
    @Deprecated
    protected w<? extends a.C0113a> C() {
        return new a(requireContext(), getChildFragmentManager(), E());
    }

    @i
    protected void F(@m0 NavController navController) {
        navController.o().a(new DialogFragmentNavigator(requireContext(), getChildFragmentManager()));
        navController.o().a(C());
    }

    @Override // androidx.navigation.p
    @m0
    public final NavController o() {
        q qVar = this.f8828a;
        if (qVar != null) {
            return qVar;
        }
        throw new IllegalStateException("NavController is not available before onCreate()");
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void onAttach(@m0 Context context) {
        super.onAttach(context);
        if (this.f8832e) {
            getParentFragmentManager().r().Q(this).r();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void onCreate(@o0 Bundle bundle) {
        Bundle bundle2;
        super.onCreate(bundle);
        q qVar = new q(requireContext());
        this.f8828a = qVar;
        qVar.S(this);
        this.f8828a.U(requireActivity().getOnBackPressedDispatcher());
        q qVar2 = this.f8828a;
        Boolean bool = this.f8829b;
        qVar2.d(bool != null && bool.booleanValue());
        this.f8829b = null;
        this.f8828a.V(getViewModelStore());
        F(this.f8828a);
        if (bundle != null) {
            bundle2 = bundle.getBundle(f8826h);
            if (bundle.getBoolean(f8827i, false)) {
                this.f8832e = true;
                getParentFragmentManager().r().Q(this).r();
            }
            this.f8831d = bundle.getInt(f8824f);
        } else {
            bundle2 = null;
        }
        if (bundle2 != null) {
            this.f8828a.M(bundle2);
        }
        int i7 = this.f8831d;
        if (i7 != 0) {
            this.f8828a.O(i7);
            return;
        }
        Bundle arguments = getArguments();
        int i8 = arguments != null ? arguments.getInt(f8824f) : 0;
        Bundle bundle3 = arguments != null ? arguments.getBundle(f8825g) : null;
        if (i8 != 0) {
            this.f8828a.P(i8, bundle3);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @o0
    public View onCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        FragmentContainerView fragmentContainerView = new FragmentContainerView(layoutInflater.getContext());
        fragmentContainerView.setId(E());
        return fragmentContainerView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        View view = this.f8830c;
        if (view != null && v.e(view) == this.f8828a) {
            v.h(this.f8830c, null);
        }
        this.f8830c = null;
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void onInflate(@m0 Context context, @m0 AttributeSet attributeSet, @o0 Bundle bundle) {
        super.onInflate(context, attributeSet, bundle);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.navigation.R.styleable.NavHost);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.f8831d = resourceId;
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.NavHostFragment);
        if (typedArrayObtainStyledAttributes2.getBoolean(R.styleable.NavHostFragment_defaultNavHost, false)) {
            this.f8832e = true;
        }
        typedArrayObtainStyledAttributes2.recycle();
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void onPrimaryNavigationFragmentChanged(boolean z7) {
        q qVar = this.f8828a;
        if (qVar != null) {
            qVar.d(z7);
        } else {
            this.f8829b = Boolean.valueOf(z7);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @i
    public void onSaveInstanceState(@m0 Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Bundle bundleN = this.f8828a.N();
        if (bundleN != null) {
            bundle.putBundle(f8826h, bundleN);
        }
        if (this.f8832e) {
            bundle.putBoolean(f8827i, true);
        }
        int i7 = this.f8831d;
        if (i7 != 0) {
            bundle.putInt(f8824f, i7);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@m0 View view, @o0 Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (!(view instanceof ViewGroup)) {
            throw new IllegalStateException("created host view " + view + " is not a ViewGroup");
        }
        v.h(view, this.f8828a);
        if (view.getParent() != null) {
            View view2 = (View) view.getParent();
            this.f8830c = view2;
            if (view2.getId() == getId()) {
                v.h(this.f8830c, this.f8828a);
            }
        }
    }
}
