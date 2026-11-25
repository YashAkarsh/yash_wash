package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.n2;
import c.a1;
import c.b1;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.internal.CheckableImageButton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class h<S> extends androidx.fragment.app.c {
    public static final int A = 0;
    public static final int B = 1;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f17517r = "OVERRIDE_THEME_RES_ID";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f17518s = "DATE_SELECTOR_KEY";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f17519t = "CALENDAR_CONSTRAINTS_KEY";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f17520u = "TITLE_TEXT_RES_ID_KEY";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f17521v = "TITLE_TEXT_KEY";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f17522w = "INPUT_MODE_KEY";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final Object f17523x = "CONFIRM_BUTTON_TAG";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final Object f17524y = "CANCEL_BUTTON_TAG";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final Object f17525z = "TOGGLE_BUTTON_TAG";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet<i<? super S>> f17526a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f17527b = new LinkedHashSet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f17528c = new LinkedHashSet<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f17529d = new LinkedHashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b1
    private int f17530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @o0
    private DateSelector<S> f17531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private o<S> f17532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @o0
    private CalendarConstraints f17533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private g<S> f17534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @a1
    private int f17535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CharSequence f17536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f17537l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f17538m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private TextView f17539n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private CheckableImageButton f17540o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @o0
    private com.google.android.material.shape.j f17541p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Button f17542q;

    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = h.this.f17526a.iterator();
            while (it.hasNext()) {
                ((i) it.next()).a(h.this.W());
            }
            h.this.dismiss();
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = h.this.f17527b.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            h.this.dismiss();
        }
    }

    class c extends n<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.n
        public void a() {
            h.this.f17542q.setEnabled(false);
        }

        @Override // com.google.android.material.datepicker.n
        public void b(S s7) {
            h.this.k0();
            h.this.f17542q.setEnabled(h.this.f17531f.g0());
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.f17542q.setEnabled(h.this.f17531f.g0());
            h.this.f17540o.toggle();
            h hVar = h.this;
            hVar.l0(hVar.f17540o);
            h.this.h0();
        }
    }

    public static final class e<S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final DateSelector<S> f17547a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CalendarConstraints f17549c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f17548b = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f17550d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f17551e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @o0
        S f17552f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f17553g = 0;

        private e(DateSelector<S> dateSelector) {
            this.f17547a = dateSelector;
        }

        private Month b() {
            long j7 = this.f17549c.k().f17430f;
            long j8 = this.f17549c.h().f17430f;
            if (!this.f17547a.h0().isEmpty()) {
                long jLongValue = this.f17547a.h0().iterator().next().longValue();
                if (jLongValue >= j7 && jLongValue <= j8) {
                    return Month.d(jLongValue);
                }
            }
            long jI0 = h.i0();
            if (j7 <= jI0 && jI0 <= j8) {
                j7 = jI0;
            }
            return Month.d(j7);
        }

        @x0({x0.a.LIBRARY_GROUP})
        @m0
        public static <S> e<S> c(@m0 DateSelector<S> dateSelector) {
            return new e<>(dateSelector);
        }

        @m0
        public static e<Long> d() {
            return new e<>(new SingleDateSelector());
        }

        @m0
        public static e<androidx.core.util.s<Long, Long>> e() {
            return new e<>(new RangeDateSelector());
        }

        @m0
        public h<S> a() {
            if (this.f17549c == null) {
                this.f17549c = new CalendarConstraints.b().a();
            }
            if (this.f17550d == 0) {
                this.f17550d = this.f17547a.C();
            }
            S s7 = this.f17552f;
            if (s7 != null) {
                this.f17547a.r(s7);
            }
            if (this.f17549c.j() == null) {
                this.f17549c.o(b());
            }
            return h.b0(this);
        }

        @m0
        public e<S> f(CalendarConstraints calendarConstraints) {
            this.f17549c = calendarConstraints;
            return this;
        }

        @m0
        public e<S> g(int i7) {
            this.f17553g = i7;
            return this;
        }

        @m0
        public e<S> h(S s7) {
            this.f17552f = s7;
            return this;
        }

        @m0
        public e<S> i(@b1 int i7) {
            this.f17548b = i7;
            return this;
        }

        @m0
        public e<S> j(@a1 int i7) {
            this.f17550d = i7;
            this.f17551e = null;
            return this;
        }

        @m0
        public e<S> k(@o0 CharSequence charSequence) {
            this.f17551e = charSequence;
            this.f17550d = 0;
            return this;
        }
    }

    @x0({x0.a.LIBRARY_GROUP})
    @Retention(RetentionPolicy.SOURCE)
    public @interface f {
    }

    @m0
    private static Drawable S(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, e.a.b(context, com.google.android.material.R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], e.a.b(context, com.google.android.material.R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int T(@m0 Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_days_of_week_height);
        int i7 = l.f17565f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_height) * i7) + ((i7 - 1) * resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int V(@m0 Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_content_padding);
        int i7 = Month.e().f17428d;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(com.google.android.material.R.dimen.mtrl_calendar_day_width) * i7) + ((i7 - 1) * resources.getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    private int X(Context context) {
        int i7 = this.f17530e;
        return i7 != 0 ? i7 : this.f17531f.H(context);
    }

    private void Y(Context context) {
        this.f17540o.setTag(f17525z);
        this.f17540o.setImageDrawable(S(context));
        this.f17540o.setChecked(this.f17538m != 0);
        n2.B1(this.f17540o, null);
        l0(this.f17540o);
        this.f17540o.setOnClickListener(new d());
    }

    static boolean Z(@m0 Context context) {
        return c0(context, R.attr.windowFullscreen);
    }

    static boolean a0(@m0 Context context) {
        return c0(context, com.google.android.material.R.attr.nestedScrollable);
    }

    @m0
    static <S> h<S> b0(@m0 e<S> eVar) {
        h<S> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f17517r, eVar.f17548b);
        bundle.putParcelable(f17518s, eVar.f17547a);
        bundle.putParcelable(f17519t, eVar.f17549c);
        bundle.putInt(f17520u, eVar.f17550d);
        bundle.putCharSequence(f17521v, eVar.f17551e);
        bundle.putInt(f17522w, eVar.f17553g);
        hVar.setArguments(bundle);
        return hVar;
    }

    static boolean c0(@m0 Context context, int i7) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.resources.b.g(context, com.google.android.material.R.attr.materialCalendarStyle, g.class.getCanonicalName()), new int[]{i7});
        boolean z7 = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h0() {
        int iX = X(requireContext());
        this.f17534i = g.S(this.f17531f, iX, this.f17533h);
        this.f17532g = this.f17540o.isChecked() ? k.E(this.f17531f, iX, this.f17533h) : this.f17534i;
        k0();
        androidx.fragment.app.v vVarR = getChildFragmentManager().r();
        vVarR.D(com.google.android.material.R.id.mtrl_calendar_frame, this.f17532g);
        vVarR.t();
        this.f17532g.A(new c());
    }

    public static long i0() {
        return Month.e().f17430f;
    }

    public static long j0() {
        return u.t().getTimeInMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        String strU = U();
        this.f17539n.setContentDescription(String.format(getString(com.google.android.material.R.string.mtrl_picker_announce_current_selection), strU));
        this.f17539n.setText(strU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(@m0 CheckableImageButton checkableImageButton) {
        this.f17540o.setContentDescription(this.f17540o.isChecked() ? checkableImageButton.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_calendar_input_mode) : checkableImageButton.getContext().getString(com.google.android.material.R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    public boolean K(DialogInterface.OnCancelListener onCancelListener) {
        return this.f17528c.add(onCancelListener);
    }

    public boolean L(DialogInterface.OnDismissListener onDismissListener) {
        return this.f17529d.add(onDismissListener);
    }

    public boolean M(View.OnClickListener onClickListener) {
        return this.f17527b.add(onClickListener);
    }

    public boolean N(i<? super S> iVar) {
        return this.f17526a.add(iVar);
    }

    public void O() {
        this.f17528c.clear();
    }

    public void P() {
        this.f17529d.clear();
    }

    public void Q() {
        this.f17527b.clear();
    }

    public void R() {
        this.f17526a.clear();
    }

    public String U() {
        return this.f17531f.c(getContext());
    }

    @o0
    public final S W() {
        return this.f17531f.l0();
    }

    public boolean d0(DialogInterface.OnCancelListener onCancelListener) {
        return this.f17528c.remove(onCancelListener);
    }

    public boolean e0(DialogInterface.OnDismissListener onDismissListener) {
        return this.f17529d.remove(onDismissListener);
    }

    public boolean f0(View.OnClickListener onClickListener) {
        return this.f17527b.remove(onClickListener);
    }

    public boolean g0(i<? super S> iVar) {
        return this.f17526a.remove(iVar);
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(@m0 DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f17528c.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f17530e = bundle.getInt(f17517r);
        this.f17531f = (DateSelector) bundle.getParcelable(f17518s);
        this.f17533h = (CalendarConstraints) bundle.getParcelable(f17519t);
        this.f17535j = bundle.getInt(f17520u);
        this.f17536k = bundle.getCharSequence(f17521v);
        this.f17538m = bundle.getInt(f17522w);
    }

    @Override // androidx.fragment.app.c
    @m0
    public final Dialog onCreateDialog(@o0 Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), X(requireContext()));
        Context context = dialog.getContext();
        this.f17537l = Z(context);
        int iG = com.google.android.material.resources.b.g(context, com.google.android.material.R.attr.colorSurface, h.class.getCanonicalName());
        com.google.android.material.shape.j jVar = new com.google.android.material.shape.j(context, null, com.google.android.material.R.attr.materialCalendarStyle, com.google.android.material.R.style.Widget_MaterialComponents_MaterialCalendar);
        this.f17541p = jVar;
        jVar.Y(context);
        this.f17541p.n0(ColorStateList.valueOf(iG));
        this.f17541p.m0(n2.R(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    @m0
    public final View onCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.f17537l ? com.google.android.material.R.layout.mtrl_picker_fullscreen : com.google.android.material.R.layout.mtrl_picker_dialog, viewGroup);
        Context context = viewInflate.getContext();
        if (this.f17537l) {
            viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(V(context), -2));
        } else {
            View viewFindViewById = viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_main_pane);
            View viewFindViewById2 = viewInflate.findViewById(com.google.android.material.R.id.mtrl_calendar_frame);
            viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(V(context), -1));
            viewFindViewById2.setMinimumHeight(T(requireContext()));
        }
        TextView textView = (TextView) viewInflate.findViewById(com.google.android.material.R.id.mtrl_picker_header_selection_text);
        this.f17539n = textView;
        n2.D1(textView, 1);
        this.f17540o = (CheckableImageButton) viewInflate.findViewById(com.google.android.material.R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) viewInflate.findViewById(com.google.android.material.R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.f17536k;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f17535j);
        }
        Y(context);
        this.f17542q = (Button) viewInflate.findViewById(com.google.android.material.R.id.confirm_button);
        if (this.f17531f.g0()) {
            this.f17542q.setEnabled(true);
        } else {
            this.f17542q.setEnabled(false);
        }
        this.f17542q.setTag(f17523x);
        this.f17542q.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(com.google.android.material.R.id.cancel_button);
        button.setTag(f17524y);
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(@m0 DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.f17529d.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(@m0 Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f17517r, this.f17530e);
        bundle.putParcelable(f17518s, this.f17531f);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.f17533h);
        if (this.f17534i.P() != null) {
            bVar.c(this.f17534i.P().f17430f);
        }
        bundle.putParcelable(f17519t, bVar.a());
        bundle.putInt(f17520u, this.f17535j);
        bundle.putCharSequence(f17521v, this.f17536k);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f17537l) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f17541p);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(com.google.android.material.R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.f17541p, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new l1.a(requireDialog(), rect));
        }
        h0();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStop() {
        this.f17532g.B();
        super.onStop();
    }
}
