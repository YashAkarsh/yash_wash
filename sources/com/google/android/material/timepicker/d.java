package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
class d implements InputFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18837a;

    public d(int i7) {
        this.f18837a = i7;
    }

    public int a() {
        return this.f18837a;
    }

    public void b(int i7) {
        this.f18837a = i7;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i7, int i8, Spanned spanned, int i9, int i10) {
        try {
            StringBuilder sb = new StringBuilder(spanned);
            sb.replace(i9, i10, charSequence.subSequence(i7, i8).toString());
            if (Integer.parseInt(sb.toString()) <= this.f18837a) {
                return null;
            }
            return "";
        } catch (NumberFormatException unused) {
            return "";
        }
    }
}
