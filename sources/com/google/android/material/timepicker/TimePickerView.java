package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.n2;
import c.a1;
import c.m0;
import c.o0;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class TimePickerView extends ConstraintLayout implements com.google.android.material.timepicker.g {
    private final Chip I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final Chip f18797J;
    private final ClockHandView K;
    private final ClockFaceView L;
    private final MaterialButtonToggleGroup M;
    private final View.OnClickListener N;
    private f O;
    private g P;
    private e Q;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.P != null) {
                TimePickerView.this.P.g(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    class b implements MaterialButtonToggleGroup.e {
        b() {
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup.e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i7, boolean z7) {
            int i8 = i7 == R.id.material_clock_period_pm_button ? 1 : 0;
            if (TimePickerView.this.O == null || !z7) {
                return;
            }
            TimePickerView.this.O.f(i8);
        }
    }

    class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
            if (TimePickerView.this.Q != null) {
                TimePickerView.this.Q.a();
            }
            return zOnDoubleTap;
        }
    }

    class d implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ GestureDetector f18801a;

        d(GestureDetector gestureDetector) {
            this.f18801a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f18801a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    interface e {
        void a();
    }

    interface f {
        void f(int i7);
    }

    interface g {
        void g(int i7);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    private void S() {
        this.I.setTag(R.id.selection_type, 12);
        this.f18797J.setTag(R.id.selection_type, 10);
        this.I.setOnClickListener(this.N);
        this.f18797J.setOnClickListener(this.N);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void T() {
        d dVar = new d(new GestureDetector(getContext(), new c()));
        this.I.setOnTouchListener(dVar);
        this.f18797J.setOnTouchListener(dVar);
    }

    private void V() {
        if (this.M.getVisibility() == 0) {
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            dVar.H(this);
            dVar.F(R.id.material_clock_display, n2.Z(this) == 0 ? 2 : 1);
            dVar.r(this);
        }
    }

    public void J(ClockHandView.d dVar) {
        this.K.b(dVar);
    }

    public void K(boolean z7) {
        this.K.j(z7);
    }

    public void L(float f8, boolean z7) {
        this.K.m(f8, z7);
    }

    public void M(androidx.core.view.a aVar) {
        n2.B1(this.I, aVar);
    }

    public void N(androidx.core.view.a aVar) {
        n2.B1(this.f18797J, aVar);
    }

    public void O(ClockHandView.c cVar) {
        this.K.o(cVar);
    }

    void P(@o0 e eVar) {
        this.Q = eVar;
    }

    void Q(f fVar) {
        this.O = fVar;
    }

    void R(g gVar) {
        this.P = gVar;
    }

    public void U() {
        this.M.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.g
    public void a(int i7) {
        this.I.setChecked(i7 == 12);
        this.f18797J.setChecked(i7 == 10);
    }

    @Override // com.google.android.material.timepicker.g
    @SuppressLint({"DefaultLocale"})
    public void b(int i7, int i8, int i9) {
        this.M.j(i7 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.f18788h, Integer.valueOf(i9));
        String str2 = String.format(locale, TimeModel.f18788h, Integer.valueOf(i8));
        this.I.setText(str);
        this.f18797J.setText(str2);
    }

    @Override // com.google.android.material.timepicker.g
    public void c(String[] strArr, @a1 int i7) {
        this.L.c(strArr, i7);
    }

    @Override // com.google.android.material.timepicker.g
    public void g(float f8) {
        this.K.l(f8);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        V();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@m0 View view, int i7) {
        super.onVisibilityChanged(view, i7);
        if (view == this && i7 == 0) {
            V();
        }
    }

    public TimePickerView(Context context, @o0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, @o0 AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.N = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.L = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.M = materialButtonToggleGroup;
        materialButtonToggleGroup.g(new b());
        this.I = (Chip) findViewById(R.id.material_minute_tv);
        this.f18797J = (Chip) findViewById(R.id.material_hour_tv);
        this.K = (ClockHandView) findViewById(R.id.material_clock_hand);
        T();
        S();
    }
}
