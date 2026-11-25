package com.haier.globalwasher.mvp_api.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final Comparator<byte[]> f24965e = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<byte[]> f24966a = new LinkedList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<byte[]> f24967b = new ArrayList(64);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24968c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24969d;

    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public d(int i7) {
        this.f24969d = i7;
    }

    private synchronized void c() {
        while (this.f24968c > this.f24969d) {
            byte[] bArrRemove = this.f24966a.remove(0);
            this.f24967b.remove(bArrRemove);
            this.f24968c -= bArrRemove.length;
        }
    }

    public synchronized byte[] a(int i7) {
        for (int i8 = 0; i8 < this.f24967b.size(); i8++) {
            byte[] bArr = this.f24967b.get(i8);
            if (bArr.length >= i7) {
                this.f24968c -= bArr.length;
                this.f24967b.remove(i8);
                this.f24966a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i7];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f24969d) {
                this.f24966a.add(bArr);
                int iBinarySearch = Collections.binarySearch(this.f24967b, bArr, f24965e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                this.f24967b.add(iBinarySearch, bArr);
                this.f24968c += bArr.length;
                c();
            }
        }
    }
}
