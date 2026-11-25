package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import c.m0;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
class v extends RecyclerView.g<b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final g<?> f17585c;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f17586a;

        a(int i7) {
            this.f17586a = i7;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            v.this.f17585c.U(v.this.f17585c.N().f(Month.b(this.f17586a, v.this.f17585c.P().f17426b)));
            v.this.f17585c.V(g.k.DAY);
        }
    }

    public static class b extends RecyclerView.d0 {
        final TextView H;

        b(TextView textView) {
            super(textView);
            this.H = textView;
        }
    }

    v(g<?> gVar) {
        this.f17585c = gVar;
    }

    @m0
    private View.OnClickListener G(int i7) {
        return new a(i7);
    }

    int H(int i7) {
        return i7 - this.f17585c.N().k().f17427c;
    }

    int I(int i7) {
        return this.f17585c.N().k().f17427c + i7;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void u(@m0 b bVar, int i7) {
        int I = I(i7);
        String string = bVar.H.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        bVar.H.setText(String.format(Locale.getDefault(), TimeModel.f18789i, Integer.valueOf(I)));
        bVar.H.setContentDescription(String.format(string, Integer.valueOf(I)));
        com.google.android.material.datepicker.b bVarO = this.f17585c.O();
        Calendar calendarT = u.t();
        com.google.android.material.datepicker.a aVar = calendarT.get(1) == I ? bVarO.f17460f : bVarO.f17458d;
        Iterator<Long> it = this.f17585c.C().h0().iterator();
        while (it.hasNext()) {
            calendarT.setTimeInMillis(it.next().longValue());
            if (calendarT.get(1) == I) {
                aVar = bVarO.f17459e;
            }
        }
        aVar.f(bVar.H);
        bVar.H.setOnClickListener(G(I));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @m0
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public b w(@m0 ViewGroup viewGroup, int i7) {
        return new b((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.f17585c.N().l();
    }
}
