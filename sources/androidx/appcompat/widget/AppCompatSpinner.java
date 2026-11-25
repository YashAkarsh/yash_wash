package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.core.view.j2;
import androidx.core.view.n2;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements j2 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SuppressLint({"ResourceType"})
    @c.c1
    private static final int[] f1449i = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f1450j = 15;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f1451k = "AppCompatSpinner";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f1452l = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f1453m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f1454n = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final androidx.appcompat.widget.d f1455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f1456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p0 f1457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private SpinnerAdapter f1458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f1459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private i f1460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f1461g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Rect f1462h;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f1463a;

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

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeByte(this.f1463a ? (byte) 1 : (byte) 0);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f1463a = parcel.readByte() != 0;
        }
    }

    class a extends p0 {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ h f1464j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, h hVar) {
            super(view);
            this.f1464j = hVar;
        }

        @Override // androidx.appcompat.widget.p0
        public androidx.appcompat.view.menu.q b() {
            return this.f1464j;
        }

        @Override // androidx.appcompat.widget.p0
        @SuppressLint({"SyntheticAccessor"})
        public boolean c() {
            if (AppCompatSpinner.this.getInternalPopup().c()) {
                return true;
            }
            AppCompatSpinner.this.b();
            return true;
        }
    }

    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!AppCompatSpinner.this.getInternalPopup().c()) {
                AppCompatSpinner.this.b();
            }
            ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                c.a(viewTreeObserver, this);
            }
        }
    }

    @c.t0(16)
    private static final class c {
        private c() {
        }

        @c.t
        static void a(@c.m0 ViewTreeObserver viewTreeObserver, @c.o0 ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    @c.t0(17)
    private static final class d {
        private d() {
        }

        @c.t
        static int a(@c.m0 View view) {
            return view.getTextAlignment();
        }

        @c.t
        static int b(@c.m0 View view) {
            return view.getTextDirection();
        }

        @c.t
        static void c(@c.m0 View view, int i7) {
            view.setTextAlignment(i7);
        }

        @c.t
        static void d(@c.m0 View view, int i7) {
            view.setTextDirection(i7);
        }
    }

    @c.t0(23)
    private static final class e {
        private e() {
        }

        @c.t
        static void a(@c.m0 ThemedSpinnerAdapter themedSpinnerAdapter, @c.o0 Resources.Theme theme) {
            if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                themedSpinnerAdapter.setDropDownViewTheme(theme);
            }
        }
    }

    @c.g1
    class f implements i, DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @c.g1
        androidx.appcompat.app.c f1467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f1468b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f1469c;

        f() {
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void a(Drawable drawable) {
            Log.e(AppCompatSpinner.f1451k, "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public boolean c() {
            androidx.appcompat.app.c cVar = this.f1467a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int d() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f1467a;
            if (cVar != null) {
                cVar.dismiss();
                this.f1467a = null;
            }
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void f(int i7) {
            Log.e(AppCompatSpinner.f1451k, "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public CharSequence g() {
            return this.f1469c;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public Drawable i() {
            return null;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void j(CharSequence charSequence) {
            this.f1469c = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void k(int i7) {
            Log.e(AppCompatSpinner.f1451k, "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void m(int i7) {
            Log.e(AppCompatSpinner.f1451k, "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void n(int i7, int i8) {
            if (this.f1468b == null) {
                return;
            }
            androidx.appcompat.app.c.a aVar = new androidx.appcompat.app.c.a(AppCompatSpinner.this.getPopupContext());
            CharSequence charSequence = this.f1469c;
            if (charSequence != null) {
                aVar.K(charSequence);
            }
            androidx.appcompat.app.c cVarA = aVar.H(this.f1468b, AppCompatSpinner.this.getSelectedItemPosition(), this).a();
            this.f1467a = cVarA;
            ListView listViewK = cVarA.k();
            d.d(listViewK, i7);
            d.c(listViewK, i8);
            this.f1467a.show();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int o() {
            return 0;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i7) {
            AppCompatSpinner.this.setSelection(i7);
            if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                AppCompatSpinner.this.performItemClick(null, i7, this.f1468b.getItemId(i7));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int p() {
            return 0;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void q(ListAdapter listAdapter) {
            this.f1468b = listAdapter;
        }
    }

    private static class g implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private SpinnerAdapter f1471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ListAdapter f1472b;

        public g(@c.o0 SpinnerAdapter spinnerAdapter, @c.o0 Resources.Theme theme) {
            this.f1471a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1472b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    e.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
                } else if (spinnerAdapter instanceof d1) {
                    d1 d1Var = (d1) spinnerAdapter;
                    if (d1Var.getDropDownViewTheme() == null) {
                        d1Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1472b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1471a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1471a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i7, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i7) {
            SpinnerAdapter spinnerAdapter = this.f1471a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i7);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i7) {
            SpinnerAdapter spinnerAdapter = this.f1471a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i7);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i7) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i7, View view, ViewGroup viewGroup) {
            return getDropDownView(i7, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1471a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i7) {
            ListAdapter listAdapter = this.f1472b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i7);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1471a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1471a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    @c.g1
    class h extends ListPopupWindow implements i {
        private CharSequence T;
        ListAdapter U;
        private final Rect V;
        private int W;

        class a implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ AppCompatSpinner f1473a;

            a(AppCompatSpinner appCompatSpinner) {
                this.f1473a = appCompatSpinner;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
                AppCompatSpinner.this.setSelection(i7);
                if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                    h hVar = h.this;
                    AppCompatSpinner.this.performItemClick(view, i7, hVar.U.getItemId(i7));
                }
                h.this.dismiss();
            }
        }

        class b implements ViewTreeObserver.OnGlobalLayoutListener {
            b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                h hVar = h.this;
                if (!hVar.r0(AppCompatSpinner.this)) {
                    h.this.dismiss();
                } else {
                    h.this.q0();
                    h.super.b();
                }
            }
        }

        class c implements PopupWindow.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1476a;

            c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1476a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1476a);
                }
            }
        }

        public h(Context context, AttributeSet attributeSet, int i7) {
            super(context, attributeSet, i7);
            this.V = new Rect();
            S(AppCompatSpinner.this);
            d0(true);
            j0(0);
            f0(new a(AppCompatSpinner.this));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public CharSequence g() {
            return this.T;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void j(CharSequence charSequence) {
            this.T = charSequence;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void m(int i7) {
            this.W = i7;
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public void n(int i7, int i8) {
            ViewTreeObserver viewTreeObserver;
            boolean zC = c();
            q0();
            a0(2);
            super.b();
            ListView listViewL = l();
            listViewL.setChoiceMode(1);
            d.d(listViewL, i7);
            d.c(listViewL, i8);
            l0(AppCompatSpinner.this.getSelectedItemPosition());
            if (zC || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            e0(new c(bVar));
        }

        @Override // androidx.appcompat.widget.AppCompatSpinner.i
        public int p() {
            return this.W;
        }

        @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.AppCompatSpinner.i
        public void q(ListAdapter listAdapter) {
            super.q(listAdapter);
            this.U = listAdapter;
        }

        void q0() {
            int i7;
            Drawable drawableI = i();
            if (drawableI != null) {
                drawableI.getPadding(AppCompatSpinner.this.f1462h);
                i7 = r1.b(AppCompatSpinner.this) ? AppCompatSpinner.this.f1462h.right : -AppCompatSpinner.this.f1462h.left;
            } else {
                Rect rect = AppCompatSpinner.this.f1462h;
                rect.right = 0;
                rect.left = 0;
                i7 = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            AppCompatSpinner appCompatSpinner = AppCompatSpinner.this;
            int i8 = appCompatSpinner.f1461g;
            if (i8 == -2) {
                int iA = appCompatSpinner.a((SpinnerAdapter) this.U, i());
                int i9 = AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = AppCompatSpinner.this.f1462h;
                int i10 = (i9 - rect2.left) - rect2.right;
                if (iA > i10) {
                    iA = i10;
                }
                U(Math.max(iA, (width - paddingLeft) - paddingRight));
            } else if (i8 == -1) {
                U((width - paddingLeft) - paddingRight);
            } else {
                U(i8);
            }
            f(r1.b(AppCompatSpinner.this) ? i7 + (((width - paddingRight) - H()) - p()) : i7 + paddingLeft + p());
        }

        boolean r0(View view) {
            return n2.O0(view) && view.getGlobalVisibleRect(this.V);
        }
    }

    @c.g1
    interface i {
        void a(Drawable drawable);

        boolean c();

        int d();

        void dismiss();

        void f(int i7);

        CharSequence g();

        Drawable i();

        void j(CharSequence charSequence);

        void k(int i7);

        void m(int i7);

        void n(int i7, int i8);

        int o();

        int p();

        void q(ListAdapter listAdapter);
    }

    public AppCompatSpinner(@c.m0 Context context) {
        this(context, (AttributeSet) null);
    }

    int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i7 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f1462h);
        Rect rect = this.f1462h;
        return iMax2 + rect.left + rect.right;
    }

    void b() {
        this.f1460f.n(d.b(this), d.a(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.d dVar = this.f1455a;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        i iVar = this.f1460f;
        return iVar != null ? iVar.d() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        i iVar = this.f1460f;
        return iVar != null ? iVar.o() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1460f != null ? this.f1461g : super.getDropDownWidth();
    }

    @c.g1
    final i getInternalPopup() {
        return this.f1460f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        i iVar = this.f1460f;
        return iVar != null ? iVar.i() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1456b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        i iVar = this.f1460f;
        return iVar != null ? iVar.g() : super.getPrompt();
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.d dVar = this.f1455a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    @Override // androidx.core.view.j2
    @c.o0
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.d dVar = this.f1455a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        i iVar = this.f1460f;
        if (iVar == null || !iVar.c()) {
            return;
        }
        this.f1460f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (this.f1460f == null || View.MeasureSpec.getMode(i7) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i7)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f1463a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        i iVar = this.f1460f;
        savedState.f1463a = iVar != null && iVar.c();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p0 p0Var = this.f1457c;
        if (p0Var == null || !p0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        i iVar = this.f1460f;
        if (iVar == null) {
            return super.performClick();
        }
        if (iVar.c()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(@c.o0 Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.d dVar = this.f1455a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(@c.u int i7) {
        super.setBackgroundResource(i7);
        androidx.appcompat.widget.d dVar = this.f1455a;
        if (dVar != null) {
            dVar.g(i7);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i7) {
        i iVar = this.f1460f;
        if (iVar == null) {
            super.setDropDownHorizontalOffset(i7);
        } else {
            iVar.m(i7);
            this.f1460f.f(i7);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i7) {
        i iVar = this.f1460f;
        if (iVar != null) {
            iVar.k(i7);
        } else {
            super.setDropDownVerticalOffset(i7);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i7) {
        if (this.f1460f != null) {
            this.f1461g = i7;
        } else {
            super.setDropDownWidth(i7);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        i iVar = this.f1460f;
        if (iVar != null) {
            iVar.a(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(@c.u int i7) {
        setPopupBackgroundDrawable(e.a.b(getPopupContext(), i7));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        i iVar = this.f1460f;
        if (iVar != null) {
            iVar.j(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintList(@c.o0 ColorStateList colorStateList) {
        androidx.appcompat.widget.d dVar = this.f1455a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    @Override // androidx.core.view.j2
    @c.x0({c.x0.a.LIBRARY_GROUP_PREFIX})
    public void setSupportBackgroundTintMode(@c.o0 PorterDuff.Mode mode) {
        androidx.appcompat.widget.d dVar = this.f1455a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public AppCompatSpinner(@c.m0 Context context, int i7) {
        this(context, null, androidx.appcompat.R.attr.spinnerStyle, i7);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1459e) {
            this.f1458d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1460f != null) {
            Context context = this.f1456b;
            if (context == null) {
                context = getContext();
            }
            this.f1460f.q(new g(spinnerAdapter, context.getTheme()));
        }
    }

    public AppCompatSpinner(@c.m0 Context context, @c.o0 AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7) {
        this(context, attributeSet, i7, -1);
    }

    public AppCompatSpinner(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7, int i8) {
        this(context, attributeSet, i7, i8, null);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0071  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:41:0x00d9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.content.res.TypedArray] */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.view.View, androidx.appcompat.widget.AppCompatSpinner] */
    public AppCompatSpinner(@c.m0 Context context, @c.o0 AttributeSet attributeSet, int i7, int i8, Resources.Theme theme) throws Throwable {
        TypedArray typedArrayObtainStyledAttributes;
        CharSequence[] charSequenceArrY;
        SpinnerAdapter spinnerAdapter;
        super(context, attributeSet, i7);
        this.f1462h = new Rect();
        c1.a(this, getContext());
        h1 h1VarG = h1.G(context, attributeSet, androidx.appcompat.R.styleable.Spinner, i7, 0);
        this.f1455a = new androidx.appcompat.widget.d(this);
        if (theme != null) {
            this.f1456b = new androidx.appcompat.view.d(context, theme);
        } else {
            int iU = h1VarG.u(androidx.appcompat.R.styleable.Spinner_popupTheme, 0);
            if (iU != 0) {
                this.f1456b = new androidx.appcompat.view.d(context, iU);
            } else {
                this.f1456b = context;
            }
        }
        ?? r11 = -1;
        ?? r7 = 0;
        try {
            if (i8 == -1) {
                try {
                    typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1449i, i7, 0);
                    try {
                        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
                        r11 = typedArrayObtainStyledAttributes;
                        if (zHasValue) {
                            i8 = typedArrayObtainStyledAttributes.getInt(0, 0);
                            r11 = typedArrayObtainStyledAttributes;
                        }
                    } catch (Exception e8) {
                        e = e8;
                        Log.i(f1451k, "Could not read android:spinnerMode", e);
                        r11 = typedArrayObtainStyledAttributes;
                        if (typedArrayObtainStyledAttributes != null) {
                        }
                        if (i8 != 0) {
                            f fVar = new f();
                            this.f1460f = fVar;
                            fVar.j(h1VarG.w(androidx.appcompat.R.styleable.Spinner_android_prompt));
                        } else if (i8 == 1) {
                            h hVar = new h(this.f1456b, attributeSet, i7);
                            h1 h1VarG2 = h1.G(this.f1456b, attributeSet, androidx.appcompat.R.styleable.Spinner, i7, 0);
                            this.f1461g = h1VarG2.q(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
                            hVar.a(h1VarG2.h(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
                            hVar.j(h1VarG.w(androidx.appcompat.R.styleable.Spinner_android_prompt));
                            h1VarG2.I();
                            this.f1460f = hVar;
                            this.f1457c = new a(this, hVar);
                        }
                        charSequenceArrY = h1VarG.y(androidx.appcompat.R.styleable.Spinner_android_entries);
                        if (charSequenceArrY != null) {
                            ArrayAdapter arrayAdapter = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrY);
                            arrayAdapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        h1VarG.I();
                        this.f1459e = true;
                        spinnerAdapter = this.f1458d;
                        if (spinnerAdapter != null) {
                            setAdapter(spinnerAdapter);
                            this.f1458d = null;
                        }
                        this.f1455a.e(attributeSet, i7);
                    }
                } catch (Exception e9) {
                    e = e9;
                    typedArrayObtainStyledAttributes = null;
                } catch (Throwable th) {
                    th = th;
                    if (r7 != 0) {
                        r7.recycle();
                    }
                    throw th;
                }
                r11.recycle();
            }
            if (i8 != 0) {
                f fVar2 = new f();
                this.f1460f = fVar2;
                fVar2.j(h1VarG.w(androidx.appcompat.R.styleable.Spinner_android_prompt));
            } else if (i8 == 1) {
                h hVar2 = new h(this.f1456b, attributeSet, i7);
                h1 h1VarG3 = h1.G(this.f1456b, attributeSet, androidx.appcompat.R.styleable.Spinner, i7, 0);
                this.f1461g = h1VarG3.q(androidx.appcompat.R.styleable.Spinner_android_dropDownWidth, -2);
                hVar2.a(h1VarG3.h(androidx.appcompat.R.styleable.Spinner_android_popupBackground));
                hVar2.j(h1VarG.w(androidx.appcompat.R.styleable.Spinner_android_prompt));
                h1VarG3.I();
                this.f1460f = hVar2;
                this.f1457c = new a(this, hVar2);
            }
            charSequenceArrY = h1VarG.y(androidx.appcompat.R.styleable.Spinner_android_entries);
            if (charSequenceArrY != null) {
                ArrayAdapter arrayAdapter2 = new ArrayAdapter(context, R.layout.simple_spinner_item, charSequenceArrY);
                arrayAdapter2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
                setAdapter(arrayAdapter2);
            }
            h1VarG.I();
            this.f1459e = true;
            spinnerAdapter = this.f1458d;
            if (spinnerAdapter != null) {
                setAdapter(spinnerAdapter);
                this.f1458d = null;
            }
            this.f1455a.e(attributeSet, i7);
        } catch (Throwable th2) {
            th = th2;
            r7 = r11;
        }
    }
}
