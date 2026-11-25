package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.accessibility.l0;
import androidx.core.view.n2;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.x;
import c.b1;
import c.g1;
import c.m0;
import c.o0;
import c.r0;
import c.x0;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP})
public final class g<S> extends o<S> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String f17479l = "THEME_RES_ID_KEY";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final String f17480m = "GRID_SELECTOR_KEY";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f17481n = "CALENDAR_CONSTRAINTS_KEY";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f17482o = "CURRENT_MONTH_KEY";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final int f17483p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @g1
    static final Object f17484q = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g1
    static final Object f17485r = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g1
    static final Object f17486s = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @g1
    static final Object f17487t = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1
    private int f17488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @o0
    private DateSelector<S> f17489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @o0
    private CalendarConstraints f17490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @o0
    private Month f17491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private k f17492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.google.android.material.datepicker.b f17493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RecyclerView f17494h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private RecyclerView f17495i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f17496j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private View f17497k;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17498a;

        a(int i7) {
            this.f17498a = i7;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f17495i.K1(this.f17498a);
        }
    }

    class b extends androidx.core.view.a {
        b() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.Y0(null);
        }
    }

    class c extends p {
        final /* synthetic */ int P;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context, int i7, boolean z7, int i8) {
            super(context, i7, z7);
            this.P = i8;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        protected void k2(@m0 RecyclerView.a0 a0Var, @m0 int[] iArr) {
            if (this.P == 0) {
                iArr[0] = g.this.f17495i.getWidth();
                iArr[1] = g.this.f17495i.getWidth();
            } else {
                iArr[0] = g.this.f17495i.getHeight();
                iArr[1] = g.this.f17495i.getHeight();
            }
        }
    }

    class d implements l {
        d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.g.l
        public void a(long j7) {
            if (g.this.f17490d.g().m(j7)) {
                g.this.f17489c.o0(j7);
                Iterator<n<S>> it = g.this.f17578a.iterator();
                while (it.hasNext()) {
                    it.next().b(g.this.f17489c.l0());
                }
                g.this.f17495i.getAdapter().j();
                if (g.this.f17494h != null) {
                    g.this.f17494h.getAdapter().j();
                }
            }
        }
    }

    class e extends RecyclerView.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Calendar f17502a = u.v();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Calendar f17503b = u.v();

        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void i(@m0 Canvas canvas, @m0 RecyclerView recyclerView, @m0 RecyclerView.a0 a0Var) {
            if ((recyclerView.getAdapter() instanceof v) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                v vVar = (v) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                for (androidx.core.util.s<Long, Long> sVar : g.this.f17489c.q()) {
                    Long l7 = sVar.f6387a;
                    if (l7 != null && sVar.f6388b != null) {
                        this.f17502a.setTimeInMillis(l7.longValue());
                        this.f17503b.setTimeInMillis(sVar.f6388b.longValue());
                        int iH = vVar.H(this.f17502a.get(1));
                        int iH2 = vVar.H(this.f17503b.get(1));
                        View viewJ = gridLayoutManager.J(iH);
                        View viewJ2 = gridLayoutManager.J(iH2);
                        int iH3 = iH / gridLayoutManager.H3();
                        int iH4 = iH2 / gridLayoutManager.H3();
                        int i7 = iH3;
                        while (i7 <= iH4) {
                            View viewJ3 = gridLayoutManager.J(gridLayoutManager.H3() * i7);
                            if (viewJ3 != null) {
                                canvas.drawRect(i7 == iH3 ? viewJ.getLeft() + (viewJ.getWidth() / 2) : 0, viewJ3.getTop() + g.this.f17493g.f17458d.e(), i7 == iH4 ? viewJ2.getLeft() + (viewJ2.getWidth() / 2) : recyclerView.getWidth(), viewJ3.getBottom() - g.this.f17493g.f17458d.b(), g.this.f17493g.f17462h);
                            }
                            i7++;
                        }
                    }
                }
            }
        }
    }

    class f extends androidx.core.view.a {
        f() {
        }

        @Override // androidx.core.view.a
        public void g(View view, @m0 l0 l0Var) {
            super.g(view, l0Var);
            l0Var.l1(g.this.f17497k.getVisibility() == 0 ? g.this.getString(R.string.mtrl_picker_toggle_to_year_selection) : g.this.getString(R.string.mtrl_picker_toggle_to_day_selection));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.datepicker.g$g, reason: collision with other inner class name */
    class C0197g extends RecyclerView.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f17506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MaterialButton f17507b;

        C0197g(m mVar, MaterialButton materialButton) {
            this.f17506a = mVar;
            this.f17507b = materialButton;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void a(@m0 RecyclerView recyclerView, int i7) {
            if (i7 == 0) {
                recyclerView.announceForAccessibility(this.f17507b.getText());
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.s
        public void b(@m0 RecyclerView recyclerView, int i7, int i8) {
            int iY2 = i7 < 0 ? g.this.R().y2() : g.this.R().C2();
            g.this.f17491e = this.f17506a.G(iY2);
            this.f17507b.setText(this.f17506a.H(iY2));
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.W();
        }
    }

    class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f17510a;

        i(m mVar) {
            this.f17510a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iY2 = g.this.R().y2() + 1;
            if (iY2 < g.this.f17495i.getAdapter().e()) {
                g.this.U(this.f17510a.G(iY2));
            }
        }
    }

    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f17512a;

        j(m mVar) {
            this.f17512a = mVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int iC2 = g.this.R().C2() - 1;
            if (iC2 >= 0) {
                g.this.U(this.f17512a.G(iC2));
            }
        }
    }

    enum k {
        DAY,
        YEAR
    }

    interface l {
        void a(long j7);
    }

    private void L(@m0 View view, @m0 m mVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(f17487t);
        n2.B1(materialButton, new f());
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(f17485r);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(f17486s);
        this.f17496j = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f17497k = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        V(k.DAY);
        materialButton.setText(this.f17491e.i(view.getContext()));
        this.f17495i.r(new C0197g(mVar, materialButton));
        materialButton.setOnClickListener(new h());
        materialButton3.setOnClickListener(new i(mVar));
        materialButton2.setOnClickListener(new j(mVar));
    }

    @m0
    private RecyclerView.n M() {
        return new e();
    }

    @r0
    static int Q(@m0 Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    @m0
    public static <T> g<T> S(@m0 DateSelector<T> dateSelector, @b1 int i7, @m0 CalendarConstraints calendarConstraints) {
        g<T> gVar = new g<>();
        Bundle bundle = new Bundle();
        bundle.putInt(f17479l, i7);
        bundle.putParcelable(f17480m, dateSelector);
        bundle.putParcelable(f17481n, calendarConstraints);
        bundle.putParcelable(f17482o, calendarConstraints.j());
        gVar.setArguments(bundle);
        return gVar;
    }

    private void T(int i7) {
        this.f17495i.post(new a(i7));
    }

    @Override // com.google.android.material.datepicker.o
    public boolean A(@m0 n<S> nVar) {
        return super.A(nVar);
    }

    @Override // com.google.android.material.datepicker.o
    @o0
    public DateSelector<S> C() {
        return this.f17489c;
    }

    @o0
    CalendarConstraints N() {
        return this.f17490d;
    }

    com.google.android.material.datepicker.b O() {
        return this.f17493g;
    }

    @o0
    Month P() {
        return this.f17491e;
    }

    @m0
    LinearLayoutManager R() {
        return (LinearLayoutManager) this.f17495i.getLayoutManager();
    }

    void U(Month month) {
        m mVar = (m) this.f17495i.getAdapter();
        int I = mVar.I(month);
        int I2 = I - mVar.I(this.f17491e);
        boolean z7 = Math.abs(I2) > 3;
        boolean z8 = I2 > 0;
        this.f17491e = month;
        if (z7 && z8) {
            this.f17495i.C1(I - 3);
            T(I);
        } else if (!z7) {
            T(I);
        } else {
            this.f17495i.C1(I + 3);
            T(I);
        }
    }

    void V(k kVar) {
        this.f17492f = kVar;
        if (kVar == k.YEAR) {
            this.f17494h.getLayoutManager().R1(((v) this.f17494h.getAdapter()).H(this.f17491e.f17427c));
            this.f17496j.setVisibility(0);
            this.f17497k.setVisibility(8);
        } else if (kVar == k.DAY) {
            this.f17496j.setVisibility(8);
            this.f17497k.setVisibility(0);
            U(this.f17491e);
        }
    }

    void W() {
        k kVar = this.f17492f;
        k kVar2 = k.YEAR;
        if (kVar == kVar2) {
            V(k.DAY);
        } else if (kVar == k.DAY) {
            V(kVar2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(@o0 Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f17488b = bundle.getInt(f17479l);
        this.f17489c = (DateSelector) bundle.getParcelable(f17480m);
        this.f17490d = (CalendarConstraints) bundle.getParcelable(f17481n);
        this.f17491e = (Month) bundle.getParcelable(f17482o);
    }

    @Override // androidx.fragment.app.Fragment
    @m0
    public View onCreateView(@m0 LayoutInflater layoutInflater, @o0 ViewGroup viewGroup, @o0 Bundle bundle) {
        int i7;
        int i8;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f17488b);
        this.f17493g = new com.google.android.material.datepicker.b(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month monthK = this.f17490d.k();
        if (com.google.android.material.datepicker.h.Z(contextThemeWrapper)) {
            i7 = R.layout.mtrl_calendar_vertical;
            i8 = 1;
        } else {
            i7 = R.layout.mtrl_calendar_horizontal;
            i8 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i7, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(R.id.mtrl_calendar_days_of_week);
        n2.B1(gridView, new b());
        gridView.setAdapter((ListAdapter) new com.google.android.material.datepicker.f());
        gridView.setNumColumns(monthK.f17428d);
        gridView.setEnabled(false);
        this.f17495i = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_months);
        this.f17495i.setLayoutManager(new c(getContext(), i8, false, i8));
        this.f17495i.setTag(f17484q);
        m mVar = new m(contextThemeWrapper, this.f17489c, this.f17490d, new d());
        this.f17495i.setAdapter(mVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f17494h = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f17494h.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f17494h.setAdapter(new v(this));
            this.f17494h.n(M());
        }
        if (viewInflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            L(viewInflate, mVar);
        }
        if (!com.google.android.material.datepicker.h.Z(contextThemeWrapper)) {
            new x().b(this.f17495i);
        }
        this.f17495i.C1(mVar.I(this.f17491e));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(@m0 Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(f17479l, this.f17488b);
        bundle.putParcelable(f17480m, this.f17489c);
        bundle.putParcelable(f17481n, this.f17490d);
        bundle.putParcelable(f17482o, this.f17491e);
    }
}
