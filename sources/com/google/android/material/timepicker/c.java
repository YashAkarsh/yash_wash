package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a1;
import c.b1;
import c.e0;
import c.m0;
import c.o0;
import c.u;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c extends androidx.fragment.app.c {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f18804r = 0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f18805s = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final String f18806t = "TIME_PICKER_TIME_MODEL";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final String f18807u = "TIME_PICKER_INPUT_MODE";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final String f18808v = "TIME_PICKER_TITLE_RES";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final String f18809w = "TIME_PICKER_TITLE_TEXT";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final String f18810x = "TIME_PICKER_OVERRIDE_THEME_RES_ID";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TimePickerView f18815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ViewStub f18816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @o0
    private f f18817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private j f18818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @o0
    private h f18819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @u
    private int f18820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @u
    private int f18821k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f18823m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MaterialButton f18824n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TimeModel f18826p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<View.OnClickListener> f18811a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<View.OnClickListener> f18812b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<DialogInterface.OnCancelListener> f18813c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<DialogInterface.OnDismissListener> f18814d = new LinkedHashSet();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f18822l = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f18825o = 0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f18827q = 0;

    class a implements TimePickerView.e {
        a() {
        }

        @Override // com.google.android.material.timepicker.TimePickerView.e
        public void a() {
            c.this.f18825o = 1;
            c cVar = c.this;
            cVar.f0(cVar.f18824n);
            c.this.f18818h.j();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = c.this.f18811a.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            c.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.timepicker.c$c, reason: collision with other inner class name */
    class ViewOnClickListenerC0210c implements View.OnClickListener {
        ViewOnClickListenerC0210c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = c.this.f18812b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            c.this.dismiss();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            cVar.f18825o = cVar.f18825o == 0 ? 1 : 0;
            c cVar2 = c.this;
            cVar2.f0(cVar2.f18824n);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f18833b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f18835d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TimeModel f18832a = new TimeModel();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f18834c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f18836e = 0;

        @m0
        public c f() {
            return c.Z(this);
        }

        @m0
        public e g(@e0(from = 0, to = 23) int i7) {
            this.f18832a.i(i7);
            return this;
        }

        @m0
        public e h(int i7) {
            this.f18833b = i7;
            return this;
        }

        @m0
        public e i(@e0(from = 0, to = 60) int i7) {
            this.f18832a.j(i7);
            return this;
        }

        @m0
        public e j(@b1 int i7) {
            this.f18836e = i7;
            return this;
        }

        @m0
        public e k(int i7) {
            TimeModel timeModel = this.f18832a;
            int i8 = timeModel.f18793d;
            int i9 = timeModel.f18794e;
            TimeModel timeModel2 = new TimeModel(i7);
            this.f18832a = timeModel2;
            timeModel2.j(i9);
            this.f18832a.i(i8);
            return this;
        }

        @m0
        public e l(@a1 int i7) {
            this.f18834c = i7;
            return this;
        }

        @m0
        public e m(@o0 CharSequence charSequence) {
            this.f18835d = charSequence;
            return this;
        }
    }

    private Pair<Integer, Integer> S(int i7) {
        if (i7 == 0) {
            return new Pair<>(Integer.valueOf(this.f18820j), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        }
        if (i7 == 1) {
            return new Pair<>(Integer.valueOf(this.f18821k), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i7);
    }

    private int W() {
        int i7 = this.f18827q;
        if (i7 != 0) {
            return i7;
        }
        TypedValue typedValueA = com.google.android.material.resources.b.a(requireContext(), R.attr.materialTimePickerTheme);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    private h Y(int i7) {
        if (i7 != 0) {
            if (this.f18818h == null) {
                this.f18818h = new j((LinearLayout) this.f18816f.inflate(), this.f18826p);
            }
            this.f18818h.f();
            return this.f18818h;
        }
        f fVar = this.f18817g;
        if (fVar == null) {
            fVar = new f(this.f18815e, this.f18826p);
        }
        this.f18817g = fVar;
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @m0
    public static c Z(@m0 e eVar) {
        c cVar = new c();
        Bundle bundle = new Bundle();
        bundle.putParcelable(f18806t, eVar.f18832a);
        bundle.putInt(f18807u, eVar.f18833b);
        bundle.putInt(f18808v, eVar.f18834c);
        bundle.putInt(f18810x, eVar.f18836e);
        if (eVar.f18835d != null) {
            bundle.putString(f18809w, eVar.f18835d.toString());
        }
        cVar.setArguments(bundle);
        return cVar;
    }

    private void e0(@o0 Bundle bundle) {
        if (bundle == null) {
            return;
        }
        TimeModel timeModel = (TimeModel) bundle.getParcelable(f18806t);
        this.f18826p = timeModel;
        if (timeModel == null) {
            this.f18826p = new TimeModel();
        }
        this.f18825o = bundle.getInt(f18807u, 0);
        this.f18822l = bundle.getInt(f18808v, 0);
        this.f18823m = bundle.getString(f18809w);
        this.f18827q = bundle.getInt(f18810x, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(MaterialButton materialButton) {
        h hVar = this.f18819i;
        if (hVar != null) {
            hVar.h();
        }
        h hVarY = Y(this.f18825o);
        this.f18819i = hVarY;
        hVarY.b();
        this.f18819i.c();
        Pair<Integer, Integer> pairS = S(this.f18825o);
        materialButton.setIconResource(((Integer) pairS.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) pairS.second).intValue()));
    }

    public boolean K(@m0 DialogInterface.OnCancelListener onCancelListener) {
        return this.f18813c.add(onCancelListener);
    }

    public boolean L(@m0 DialogInterface.OnDismissListener onDismissListener) {
        return this.f18814d.add(onDismissListener);
    }

    public boolean M(@m0 View.OnClickListener onClickListener) {
        return this.f18812b.add(onClickListener);
    }

    public boolean N(@m0 View.OnClickListener onClickListener) {
        return this.f18811a.add(onClickListener);
    }

    public void O() {
        this.f18813c.clear();
    }

    public void P() {
        this.f18814d.clear();
    }

    public void Q() {
        this.f18812b.clear();
    }

    public void R() {
        this.f18811a.clear();
    }

    @e0(from = 0, to = 23)
    public int T() {
        return this.f18826p.f18793d % 24;
    }

    public int U() {
        return this.f18825o;
    }

    @e0(from = 0, to = 60)
    public int V() {
        return this.f18826p.f18794e;
    }

    @o0
    f X() {
        return this.f18817g;
    }

    public boolean a0(@m0 DialogInterface.OnCancelListener onCancelListener) {
        return this.f18813c.remove(onCancelListener);
    }

    public boolean b0(@m0 DialogInterface.OnDismissListener onDismissListener) {
        return this.f18814d.remove(onDismissListener);
    }

    public boolean c0(@m0 View.OnClickListener onClickListener) {
        return this.f18812b.remove(onClickListener);
    }

    public boolean d0(@m0 View.OnClickListener onClickListener) {
        return this.f18811a.remove(onClickListener);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@m0 DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f18813c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        e0(bundle);
    }

    @Override // androidx.fragment.app.c
    @m0
    public final Dialog onCreateDialog(@o0 Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), W());
        Context context = dialog.getContext();
        int iG = com.google.android.material.resources.b.g(context, R.attr.colorSurface, c.class.getCanonicalName());
        com.google.android.material.shape.j jVar = new com.google.android.material.shape.j(context, null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.f18821k = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.f18820j = typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        typedArrayObtainStyledAttributes.recycle();
        jVar.Y(context);
        jVar.n0(ColorStateList.valueOf(iG));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(jVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @m0
    public final View onCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.f18815e = timePickerView;
        timePickerView.P(new a());
        this.f18816f = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.f18824n = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (!TextUtils.isEmpty(this.f18823m)) {
            textView.setText(this.f18823m);
        }
        int i7 = this.f18822l;
        if (i7 != 0) {
            textView.setText(i7);
        }
        f0(this.f18824n);
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new b());
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new ViewOnClickListenerC0210c());
        this.f18824n.setOnClickListener(new d());
        return viewGroup2;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@m0 DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f18814d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@m0 Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(f18806t, this.f18826p);
        bundle.putInt(f18807u, this.f18825o);
        bundle.putInt(f18808v, this.f18822l);
        bundle.putString(f18809w, this.f18823m);
        bundle.putInt(f18810x, this.f18827q);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f18819i = null;
        this.f18817g = null;
        this.f18818h = null;
        this.f18815e = null;
    }
}
