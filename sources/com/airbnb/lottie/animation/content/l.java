package com.airbnb.lottie.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class l implements n, j {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f11654d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.model.content.h f11656f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Path f11651a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f11652b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f11653c = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<n> f11655e = new ArrayList();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f11657a;

        static {
            int[] iArr = new int[com.airbnb.lottie.model.content.h.a.values().length];
            f11657a = iArr;
            try {
                iArr[com.airbnb.lottie.model.content.h.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11657a[com.airbnb.lottie.model.content.h.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11657a[com.airbnb.lottie.model.content.h.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f11657a[com.airbnb.lottie.model.content.h.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f11657a[com.airbnb.lottie.model.content.h.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(com.airbnb.lottie.model.content.h hVar) {
        this.f11654d = hVar.c();
        this.f11656f = hVar;
    }

    private void a() {
        for (int i7 = 0; i7 < this.f11655e.size(); i7++) {
            this.f11653c.addPath(this.f11655e.get(i7).g());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.f11652b.reset();
        this.f11651a.reset();
        for (int size = this.f11655e.size() - 1; size >= 1; size--) {
            n nVar = this.f11655e.get(size);
            if (nVar instanceof d) {
                d dVar = (d) nVar;
                List<n> listJ = dVar.j();
                for (int size2 = listJ.size() - 1; size2 >= 0; size2--) {
                    Path pathG = listJ.get(size2).g();
                    pathG.transform(dVar.k());
                    this.f11652b.addPath(pathG);
                }
            } else {
                this.f11652b.addPath(nVar.g());
            }
        }
        n nVar2 = this.f11655e.get(0);
        if (nVar2 instanceof d) {
            d dVar2 = (d) nVar2;
            List<n> listJ2 = dVar2.j();
            for (int i7 = 0; i7 < listJ2.size(); i7++) {
                Path pathG2 = listJ2.get(i7).g();
                pathG2.transform(dVar2.k());
                this.f11651a.addPath(pathG2);
            }
        } else {
            this.f11651a.set(nVar2.g());
        }
        this.f11653c.op(this.f11651a, this.f11652b, op);
    }

    @Override // com.airbnb.lottie.animation.content.c
    public void b(List<c> list, List<c> list2) {
        for (int i7 = 0; i7 < this.f11655e.size(); i7++) {
            this.f11655e.get(i7).b(list, list2);
        }
    }

    @Override // com.airbnb.lottie.animation.content.j
    public void e(ListIterator<c> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVarPrevious = listIterator.previous();
            if (cVarPrevious instanceof n) {
                this.f11655e.add((n) cVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.n
    public Path g() {
        this.f11653c.reset();
        if (this.f11656f.d()) {
            return this.f11653c;
        }
        int i7 = a.f11657a[this.f11656f.b().ordinal()];
        if (i7 == 1) {
            a();
        } else if (i7 == 2) {
            c(Path.Op.UNION);
        } else if (i7 == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i7 == 4) {
            c(Path.Op.INTERSECT);
        } else if (i7 == 5) {
            c(Path.Op.XOR);
        }
        return this.f11653c;
    }

    @Override // com.airbnb.lottie.animation.content.c
    public String getName() {
        return this.f11654d;
    }
}
