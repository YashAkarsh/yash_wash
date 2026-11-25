package com.airbnb.lottie;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f12310a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<b> f12311b = new androidx.collection.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, com.airbnb.lottie.utils.h> f12312c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Comparator<androidx.core.util.s<String, Float>> f12313d = new a();

    class a implements Comparator<androidx.core.util.s<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.core.util.s<String, Float> sVar, androidx.core.util.s<String, Float> sVar2) {
            float fFloatValue = sVar.f6388b.floatValue();
            float fFloatValue2 = sVar2.f6388b.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    public interface b {
        void a(float f8);
    }

    public void a(b bVar) {
        this.f12311b.add(bVar);
    }

    public void b() {
        this.f12312c.clear();
    }

    public List<androidx.core.util.s<String, Float>> c() {
        if (!this.f12310a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f12312c.size());
        for (Map.Entry<String, com.airbnb.lottie.utils.h> entry : this.f12312c.entrySet()) {
            arrayList.add(new androidx.core.util.s(entry.getKey(), Float.valueOf(entry.getValue().b())));
        }
        Collections.sort(arrayList, this.f12313d);
        return arrayList;
    }

    public void d() {
        if (this.f12310a) {
            List<androidx.core.util.s<String, Float>> listC = c();
            Log.d(e.f11762b, "Render times:");
            for (int i7 = 0; i7 < listC.size(); i7++) {
                androidx.core.util.s<String, Float> sVar = listC.get(i7);
                Log.d(e.f11762b, String.format("\t\t%30s:%.2f", sVar.f6387a, sVar.f6388b));
            }
        }
    }

    public void e(String str, float f8) {
        if (this.f12310a) {
            com.airbnb.lottie.utils.h hVar = this.f12312c.get(str);
            if (hVar == null) {
                hVar = new com.airbnb.lottie.utils.h();
                this.f12312c.put(str, hVar);
            }
            hVar.a(f8);
            if (str.equals("__container")) {
                Iterator<b> it = this.f12311b.iterator();
                while (it.hasNext()) {
                    it.next().a(f8);
                }
            }
        }
    }

    public void f(b bVar) {
        this.f12311b.remove(bVar);
    }

    void g(boolean z7) {
        this.f12310a = z7;
    }
}
