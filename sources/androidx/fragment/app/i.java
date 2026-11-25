package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R;
import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import c.m0;
import c.o0;

/* JADX INFO: loaded from: classes.dex */
class i implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f8006b = "FragmentManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final FragmentManager f8007a;

    class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f8008a;

        a(r rVar) {
            this.f8008a = rVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Fragment fragmentK = this.f8008a.k();
            this.f8008a.m();
            c0.n((ViewGroup) fragmentK.mView.getParent(), i.this.f8007a).j();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    i(FragmentManager fragmentManager) {
        this.f8007a = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    @o0
    public View onCreateView(@m0 String str, @m0 Context context, @m0 AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    @o0
    public View onCreateView(@o0 View view, @m0 String str, @m0 Context context, @m0 AttributeSet attributeSet) {
        r rVarA;
        if (FragmentContainerView.class.getName().equals(str)) {
            return new FragmentContainerView(context, attributeSet, this.f8007a);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, InstrumentationResultPrinter.f10179m);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Fragment);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_name);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.Fragment_android_id, -1);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.Fragment_android_tag);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !g.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentP0 = resourceId != -1 ? this.f8007a.p0(resourceId) : null;
        if (fragmentP0 == null && string != null) {
            fragmentP0 = this.f8007a.q0(string);
        }
        if (fragmentP0 == null && id != -1) {
            fragmentP0 = this.f8007a.p0(id);
        }
        if (fragmentP0 == null) {
            fragmentP0 = this.f8007a.E0().a(context.getClassLoader(), attributeValue);
            fragmentP0.mFromLayout = true;
            fragmentP0.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentP0.mContainerId = id;
            fragmentP0.mTag = string;
            fragmentP0.mInLayout = true;
            FragmentManager fragmentManager = this.f8007a;
            fragmentP0.mFragmentManager = fragmentManager;
            fragmentP0.mHost = fragmentManager.H0();
            fragmentP0.onInflate(this.f8007a.H0().f(), attributeSet, fragmentP0.mSavedFragmentState);
            rVarA = this.f8007a.k(fragmentP0);
            if (FragmentManager.T0(2)) {
                Log.v(f8006b, "Fragment " + fragmentP0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentP0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentP0.mInLayout = true;
            FragmentManager fragmentManager2 = this.f8007a;
            fragmentP0.mFragmentManager = fragmentManager2;
            fragmentP0.mHost = fragmentManager2.H0();
            fragmentP0.onInflate(this.f8007a.H0().f(), attributeSet, fragmentP0.mSavedFragmentState);
            rVarA = this.f8007a.A(fragmentP0);
            if (FragmentManager.T0(2)) {
                Log.v(f8006b, "Retained Fragment " + fragmentP0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        fragmentP0.mContainer = (ViewGroup) view;
        rVarA.m();
        rVarA.j();
        View view2 = fragmentP0.mView;
        if (view2 == null) {
            throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
        }
        if (resourceId != 0) {
            view2.setId(resourceId);
        }
        if (fragmentP0.mView.getTag() == null) {
            fragmentP0.mView.setTag(string);
        }
        fragmentP0.mView.addOnAttachStateChangeListener(new a(rVarA));
        return fragmentP0.mView;
    }
}
