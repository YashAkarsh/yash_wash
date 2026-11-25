package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.internal.n;

/* JADX INFO: loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f18594h = 15;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @m0
    private final ListPopupWindow f18595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private final AccessibilityManager f18596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @m0
    private final Rect f18597g;

    class a implements AdapterView.OnItemClickListener {
        a() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            MaterialAutoCompleteTextView.this.g(i7 < 0 ? MaterialAutoCompleteTextView.this.f18595e.C() : MaterialAutoCompleteTextView.this.getAdapter().getItem(i7));
            AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
            if (onItemClickListener != null) {
                if (view == null || i7 < 0) {
                    view = MaterialAutoCompleteTextView.this.f18595e.F();
                    i7 = MaterialAutoCompleteTextView.this.f18595e.E();
                    j7 = MaterialAutoCompleteTextView.this.f18595e.D();
                }
                onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f18595e.l(), view, i7, j7);
            }
            MaterialAutoCompleteTextView.this.f18595e.dismiss();
        }
    }

    public MaterialAutoCompleteTextView(@m0 Context context) {
        this(context, null);
    }

    @o0
    private TextInputLayout e() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private int f() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutE = e();
        int i7 = 0;
        if (adapter == null || textInputLayoutE == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f18595e.E()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutE);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableI = this.f18595e.i();
        if (drawableI != null) {
            drawableI.getPadding(this.f18597g);
            Rect rect = this.f18597g;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutE.getEndIconView().getMeasuredWidth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends ListAdapter & Filterable> void g(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.TextView
    @o0
    public CharSequence getHint() {
        TextInputLayout textInputLayoutE = e();
        return (textInputLayoutE == null || !textInputLayoutE.Z()) ? super.getHint() : textInputLayoutE.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutE = e();
        if (textInputLayoutE != null && textInputLayoutE.Z() && super.getHint() == null && com.google.android.material.internal.e.c()) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i7, int i8) {
        super.onMeasure(i7, i8);
        if (View.MeasureSpec.getMode(i7) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), f()), View.MeasureSpec.getSize(i7)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(@o0 T t7) {
        super.setAdapter(t7);
        this.f18595e.q(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        AccessibilityManager accessibilityManager = this.f18596f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.f18595e.b();
        }
    }

    public MaterialAutoCompleteTextView(@m0 Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(@m0 Context context, @o0 AttributeSet attributeSet, int i7) {
        super(q1.a.c(context, attributeSet, i7, 0), attributeSet, i7);
        this.f18597g = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayJ = n.j(context2, attributeSet, R.styleable.MaterialAutoCompleteTextView, i7, R.style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (typedArrayJ.hasValue(R.styleable.MaterialAutoCompleteTextView_android_inputType) && typedArrayJ.getInt(R.styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f18596f = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f18595e = listPopupWindow;
        listPopupWindow.d0(true);
        listPopupWindow.S(this);
        listPopupWindow.a0(2);
        listPopupWindow.q(getAdapter());
        listPopupWindow.f0(new a());
        typedArrayJ.recycle();
    }
}
