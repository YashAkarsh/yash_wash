package com.google.android.gms.common.data;

import c.m0;
import c.o0;
import com.google.android.gms.common.internal.u;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@c1.a
public abstract class i<T> extends a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f15562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<Integer> f15563c;

    @c1.a
    protected i(@m0 DataHolder dataHolder) {
        super(dataHolder);
        this.f15562b = false;
    }

    private final void u() {
        synchronized (this) {
            if (!this.f15562b) {
                int count = ((DataHolder) u.k(this.f15551a)).getCount();
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.f15563c = arrayList;
                if (count > 0) {
                    arrayList.add(0);
                    String strR = r();
                    String strX0 = this.f15551a.x0(strR, 0, this.f15551a.G0(0));
                    for (int i7 = 1; i7 < count; i7++) {
                        int iG0 = this.f15551a.G0(i7);
                        String strX1 = this.f15551a.x0(strR, i7, iG0);
                        if (strX1 == null) {
                            StringBuilder sb = new StringBuilder(String.valueOf(strR).length() + 78);
                            sb.append("Missing value for markerColumn: ");
                            sb.append(strR);
                            sb.append(", at row: ");
                            sb.append(i7);
                            sb.append(", for window: ");
                            sb.append(iG0);
                            throw new NullPointerException(sb.toString());
                        }
                        if (!strX1.equals(strX0)) {
                            this.f15563c.add(Integer.valueOf(i7));
                            strX0 = strX1;
                        }
                    }
                }
                this.f15562b = true;
            }
        }
    }

    @o0
    @c1.a
    protected String b() {
        return null;
    }

    @c1.a
    @m0
    protected abstract T f(int i7, int i8);

    @Override // com.google.android.gms.common.data.a, com.google.android.gms.common.data.b
    @c1.a
    @m0
    public final T get(int i7) {
        int iIntValue;
        int iIntValue2;
        u();
        int iS = s(i7);
        int i8 = 0;
        if (i7 >= 0 && i7 != this.f15563c.size()) {
            if (i7 == this.f15563c.size() - 1) {
                iIntValue = ((DataHolder) u.k(this.f15551a)).getCount();
                iIntValue2 = this.f15563c.get(i7).intValue();
            } else {
                iIntValue = this.f15563c.get(i7 + 1).intValue();
                iIntValue2 = this.f15563c.get(i7).intValue();
            }
            int i9 = iIntValue - iIntValue2;
            if (i9 == 1) {
                int iS2 = s(i7);
                int iG0 = ((DataHolder) u.k(this.f15551a)).G0(iS2);
                String strB = b();
                if (strB == null || this.f15551a.x0(strB, iS2, iG0) != null) {
                    i8 = 1;
                }
            } else {
                i8 = i9;
            }
        }
        return f(iS, i8);
    }

    @Override // com.google.android.gms.common.data.a, com.google.android.gms.common.data.b
    @c1.a
    public int getCount() {
        u();
        return this.f15563c.size();
    }

    @c1.a
    @m0
    protected abstract String r();

    final int s(int i7) {
        if (i7 >= 0 && i7 < this.f15563c.size()) {
            return this.f15563c.get(i7).intValue();
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("Position ");
        sb.append(i7);
        sb.append(" is out of bounds for this buffer");
        throw new IllegalArgumentException(sb.toString());
    }
}
