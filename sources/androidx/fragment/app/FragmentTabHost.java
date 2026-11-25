package androidx.fragment.app;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import c.m0;
import c.o0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<b> f7872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FrameLayout f7873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f7874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FragmentManager f7875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TabHost.OnTabChangeListener f7877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f7878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f7879h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7880a;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i7) {
                return new SavedState[i7];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @m0
        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.f7880a + com.alipay.sdk.util.j.f13808d;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeString(this.f7880a);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f7880a = parcel.readString();
        }
    }

    static class a implements TabHost.TabContentFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f7881a;

        public a(Context context) {
            this.f7881a = context;
        }

        @Override // android.widget.TabHost.TabContentFactory
        public View createTabContent(String str) {
            View view = new View(this.f7881a);
            view.setMinimumWidth(0);
            view.setMinimumHeight(0);
            return view;
        }
    }

    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @m0
        final String f7882a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @m0
        final Class<?> f7883b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @o0
        final Bundle f7884c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Fragment f7885d;

        b(@m0 String str, @m0 Class<?> cls, @o0 Bundle bundle) {
            this.f7882a = str;
            this.f7883b = cls;
            this.f7884c = bundle;
        }
    }

    @Deprecated
    public FragmentTabHost(@m0 Context context) {
        super(context, null);
        this.f7872a = new ArrayList<>();
        f(context, null);
    }

    @o0
    private v b(@o0 String str, @o0 v vVar) {
        Fragment fragment;
        b bVarE = e(str);
        if (this.f7878g != bVarE) {
            if (vVar == null) {
                vVar = this.f7875d.r();
            }
            b bVar = this.f7878g;
            if (bVar != null && (fragment = bVar.f7885d) != null) {
                vVar.w(fragment);
            }
            if (bVarE != null) {
                Fragment fragment2 = bVarE.f7885d;
                if (fragment2 == null) {
                    Fragment fragmentA = this.f7875d.E0().a(this.f7874c.getClassLoader(), bVarE.f7883b.getName());
                    bVarE.f7885d = fragmentA;
                    fragmentA.setArguments(bVarE.f7884c);
                    vVar.h(this.f7876e, bVarE.f7885d, bVarE.f7882a);
                } else {
                    vVar.q(fragment2);
                }
            }
            this.f7878g = bVarE;
        }
        return vVar;
    }

    private void c() {
        if (this.f7873b == null) {
            FrameLayout frameLayout = (FrameLayout) findViewById(this.f7876e);
            this.f7873b = frameLayout;
            if (frameLayout != null) {
                return;
            }
            throw new IllegalStateException("No tab content FrameLayout found for id " + this.f7876e);
        }
    }

    private void d(Context context) {
        if (findViewById(R.id.tabs) == null) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            addView(linearLayout, new FrameLayout.LayoutParams(-1, -1));
            TabWidget tabWidget = new TabWidget(context);
            tabWidget.setId(R.id.tabs);
            tabWidget.setOrientation(0);
            linearLayout.addView(tabWidget, new LinearLayout.LayoutParams(-1, -2, 0.0f));
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setId(R.id.tabcontent);
            linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(0, 0, 0.0f));
            FrameLayout frameLayout2 = new FrameLayout(context);
            this.f7873b = frameLayout2;
            frameLayout2.setId(this.f7876e);
            linearLayout.addView(frameLayout2, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        }
    }

    @o0
    private b e(String str) {
        int size = this.f7872a.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f7872a.get(i7);
            if (bVar.f7882a.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    private void f(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.inflatedId}, 0, 0);
        this.f7876e = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void a(@m0 TabHost.TabSpec tabSpec, @m0 Class<?> cls, @o0 Bundle bundle) {
        tabSpec.setContent(new a(this.f7874c));
        String tag = tabSpec.getTag();
        b bVar = new b(tag, cls, bundle);
        if (this.f7879h) {
            Fragment fragmentQ0 = this.f7875d.q0(tag);
            bVar.f7885d = fragmentQ0;
            if (fragmentQ0 != null && !fragmentQ0.isDetached()) {
                v vVarR = this.f7875d.r();
                vVarR.w(bVar.f7885d);
                vVarR.r();
            }
        }
        this.f7872a.add(bVar);
        addTab(tabSpec);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        int size = this.f7872a.size();
        v vVarR = null;
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f7872a.get(i7);
            Fragment fragmentQ0 = this.f7875d.q0(bVar.f7882a);
            bVar.f7885d = fragmentQ0;
            if (fragmentQ0 != null && !fragmentQ0.isDetached()) {
                if (bVar.f7882a.equals(currentTabTag)) {
                    this.f7878g = bVar;
                } else {
                    if (vVarR == null) {
                        vVarR = this.f7875d.r();
                    }
                    vVarR.w(bVar.f7885d);
                }
            }
        }
        this.f7879h = true;
        v vVarB = b(currentTabTag, vVarR);
        if (vVarB != null) {
            vVarB.r();
            this.f7875d.l0();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7879h = false;
    }

    @Override // android.view.View
    @Deprecated
    protected void onRestoreInstanceState(@SuppressLint({"UnknownNullness"}) Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.f7880a);
    }

    @Override // android.view.View
    @m0
    @Deprecated
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f7880a = getCurrentTabTag();
        return savedState;
    }

    @Override // android.widget.TabHost.OnTabChangeListener
    @Deprecated
    public void onTabChanged(@o0 String str) {
        v vVarB;
        if (this.f7879h && (vVarB = b(str, null)) != null) {
            vVarB.r();
        }
        TabHost.OnTabChangeListener onTabChangeListener = this.f7877f;
        if (onTabChangeListener != null) {
            onTabChangeListener.onTabChanged(str);
        }
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setOnTabChangedListener(@o0 TabHost.OnTabChangeListener onTabChangeListener) {
        this.f7877f = onTabChangeListener;
    }

    @Override // android.widget.TabHost
    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    @Deprecated
    public void setup(@m0 Context context, @m0 FragmentManager fragmentManager) {
        d(context);
        super.setup();
        this.f7874c = context;
        this.f7875d = fragmentManager;
        c();
    }

    @Deprecated
    public FragmentTabHost(@m0 Context context, @o0 AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7872a = new ArrayList<>();
        f(context, attributeSet);
    }

    @Deprecated
    public void setup(@m0 Context context, @m0 FragmentManager fragmentManager, int i7) {
        d(context);
        super.setup();
        this.f7874c = context;
        this.f7875d = fragmentManager;
        this.f7876e = i7;
        c();
        this.f7873b.setId(i7);
        if (getId() == -1) {
            setId(R.id.tabhost);
        }
    }
}
