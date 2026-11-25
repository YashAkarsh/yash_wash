package com.google.android.material.datepicker;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import c.b1;
import c.m0;
import c.o0;
import c.x0;
import com.google.android.material.R;

/* JADX INFO: loaded from: classes.dex */
@x0({x0.a.LIBRARY_GROUP, x0.a.TESTS})
public class j extends DatePickerDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @c.f
    private static final int f17554c = 16843612;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b1
    private static final int f17555d = R.style.MaterialAlertDialog_MaterialComponents_Picker_Date_Spinner;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @m0
    private final Drawable f17556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @m0
    private final Rect f17557b;

    public j(@m0 Context context) {
        this(context, 0);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(this.f17556a);
        getWindow().getDecorView().setOnTouchListener(new l1.a(this, this.f17557b));
    }

    public j(@m0 Context context, int i7) {
        this(context, i7, null, -1, -1, -1);
    }

    public j(@m0 Context context, @o0 DatePickerDialog.OnDateSetListener onDateSetListener, int i7, int i8, int i9) {
        this(context, 0, onDateSetListener, i7, i8, i9);
    }

    public j(@m0 Context context, int i7, @o0 DatePickerDialog.OnDateSetListener onDateSetListener, int i8, int i9, int i10) {
        super(context, i7, onDateSetListener, i8, i9, i10);
        Context context2 = getContext();
        int iG = com.google.android.material.resources.b.g(getContext(), R.attr.colorSurface, getClass().getCanonicalName());
        int i11 = f17555d;
        com.google.android.material.shape.j jVar = new com.google.android.material.shape.j(context2, null, 16843612, i11);
        jVar.n0(ColorStateList.valueOf(iG));
        Rect rectA = l1.c.a(context2, 16843612, i11);
        this.f17557b = rectA;
        this.f17556a = l1.c.b(jVar, rectA);
    }
}
