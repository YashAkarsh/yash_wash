package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import c.m0;
import c.o0;
import com.google.android.material.R;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Calendar f17422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f17423b;

    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.Y0(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    private void a(int i7, Rect rect) {
        if (i7 == 33) {
            setSelection(getAdapter().i());
        } else if (i7 == 130) {
            setSelection(getAdapter().b());
        } else {
            super.onFocusChanged(true, i7, rect);
        }
    }

    private static int c(@m0 View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean d(@o0 Long l7, @o0 Long l8, @o0 Long l9, @o0 Long l10) {
        return l7 == null || l8 == null || l9 == null || l10 == null || l9.longValue() > l8.longValue() || l10.longValue() < l7.longValue();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    @m0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l getAdapter() {
        return (l) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(@m0 Canvas canvas) {
        int iA;
        int iC;
        int iA2;
        int iC2;
        int width;
        int i7;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        l adapter = getAdapter();
        DateSelector<?> dateSelector = adapter.f17567b;
        b bVar = adapter.f17569d;
        Long item = adapter.getItem(adapter.b());
        Long item2 = adapter.getItem(adapter.i());
        for (androidx.core.util.s<Long, Long> sVar : dateSelector.q()) {
            Long l7 = sVar.f6387a;
            if (l7 != null) {
                if (sVar.f6388b != null) {
                    long jLongValue = l7.longValue();
                    long jLongValue2 = sVar.f6388b.longValue();
                    if (!d(item, item2, Long.valueOf(jLongValue), Long.valueOf(jLongValue2))) {
                        boolean zJ = com.google.android.material.internal.v.j(this);
                        if (jLongValue < item.longValue()) {
                            iA = adapter.b();
                            iC = adapter.f(iA) ? 0 : !zJ ? materialCalendarGridView.getChildAt(iA - 1).getRight() : materialCalendarGridView.getChildAt(iA - 1).getLeft();
                        } else {
                            materialCalendarGridView.f17422a.setTimeInMillis(jLongValue);
                            iA = adapter.a(materialCalendarGridView.f17422a.get(5));
                            iC = c(materialCalendarGridView.getChildAt(iA));
                        }
                        if (jLongValue2 > item2.longValue()) {
                            iA2 = Math.min(adapter.i(), getChildCount() - 1);
                            iC2 = adapter.g(iA2) ? getWidth() : !zJ ? materialCalendarGridView.getChildAt(iA2).getRight() : materialCalendarGridView.getChildAt(iA2).getLeft();
                        } else {
                            materialCalendarGridView.f17422a.setTimeInMillis(jLongValue2);
                            iA2 = adapter.a(materialCalendarGridView.f17422a.get(5));
                            iC2 = c(materialCalendarGridView.getChildAt(iA2));
                        }
                        int itemId = (int) adapter.getItemId(iA);
                        int itemId2 = (int) adapter.getItemId(iA2);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt.getTop() + bVar.f17455a.e();
                            int bottom = childAt.getBottom() - bVar.f17455a.b();
                            if (zJ) {
                                int i8 = iA2 > numColumns2 ? 0 : iC2;
                                width = numColumns > iA ? getWidth() : iC;
                                i7 = i8;
                            } else {
                                i7 = numColumns > iA ? 0 : iC;
                                width = iA2 > numColumns2 ? getWidth() : iC2;
                            }
                            canvas.drawRect(i7, top, width, bottom, bVar.f17462h);
                            itemId++;
                            materialCalendarGridView = this;
                            adapter = adapter;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z7, int i7, Rect rect) {
        if (z7) {
            a(i7, rect);
        } else {
            super.onFocusChanged(false, i7, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i7, KeyEvent keyEvent) {
        if (!super.onKeyDown(i7, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().b()) {
            return true;
        }
        if (19 != i7) {
            return false;
        }
        setSelection(getAdapter().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i7, int i8) {
        if (!this.f17423b) {
            super.onMeasure(i7, i8);
            return;
        }
        super.onMeasure(i7, View.MeasureSpec.makeMeasureSpec(n2.f6742s, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i7) {
        if (i7 < getAdapter().b()) {
            super.setSelection(getAdapter().b());
        } else {
            super.setSelection(i7);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AdapterView
    public final void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof l)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), l.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f17422a = u.v();
        if (h.Z(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f17423b = h.a0(getContext());
        n2.B1(this, new a());
    }
}
