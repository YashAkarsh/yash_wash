package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.n2;
import androidx.recyclerview.widget.RecyclerView;
import c.m0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
class m extends RecyclerView.g<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f17571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @m0
    private final CalendarConstraints f17572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DateSelector<?> f17573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g.l f17574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f17575g;

    class a implements AdapterView.OnItemClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaterialCalendarGridView f17576a;

        a(MaterialCalendarGridView materialCalendarGridView) {
            this.f17576a = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i7, long j7) {
            if (this.f17576a.getAdapter().n(i7)) {
                m.this.f17574f.a(this.f17576a.getAdapter().getItem(i7).longValue());
            }
        }
    }

    public static class b extends RecyclerView.d0 {
        final TextView H;
        final MaterialCalendarGridView I;

        b(@m0 LinearLayout linearLayout, boolean z7) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.H = textView;
            n2.C1(textView, true);
            this.I = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z7) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    m(@m0 Context context, DateSelector<?> dateSelector, @m0 CalendarConstraints calendarConstraints, g.l lVar) {
        Month monthK = calendarConstraints.k();
        Month monthH = calendarConstraints.h();
        Month monthJ = calendarConstraints.j();
        if (monthK.compareTo(monthJ) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (monthJ.compareTo(monthH) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int iQ = l.f17565f * g.Q(context);
        int iQ2 = h.Z(context) ? g.Q(context) : 0;
        this.f17571c = context;
        this.f17575g = iQ + iQ2;
        this.f17572d = calendarConstraints;
        this.f17573e = dateSelector;
        this.f17574f = lVar;
        D(true);
    }

    @m0
    Month G(int i7) {
        return this.f17572d.k().k(i7);
    }

    @m0
    CharSequence H(int i7) {
        return G(i7).i(this.f17571c);
    }

    int I(@m0 Month month) {
        return this.f17572d.k().l(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void u(@m0 b bVar, int i7) {
        Month monthK = this.f17572d.k().k(i7);
        bVar.H.setText(monthK.i(bVar.f9157a.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.I.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthK.equals(materialCalendarGridView.getAdapter().f17566a)) {
            l lVar = new l(monthK, this.f17573e, this.f17572d);
            materialCalendarGridView.setNumColumns(monthK.f17428d);
            materialCalendarGridView.setAdapter((ListAdapter) lVar);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().m(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new a(materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @m0
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public b w(@m0 ViewGroup viewGroup, int i7) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!h.Z(viewGroup.getContext())) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f17575g));
        return new b(linearLayout, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f17572d.i();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long f(int i7) {
        return this.f17572d.k().k(i7).j();
    }
}
