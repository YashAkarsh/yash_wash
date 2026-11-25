package com.haier.library.json.serializer;

import java.io.IOException;
import java.lang.reflect.Member;
import java.util.Collection;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements Comparable<j> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i3.a f26823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final boolean f26824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final int f26825c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String f26826d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f26827e;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        t f26828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Class<?> f26829b;

        public a(t tVar, Class<?> cls) {
            this.f26828a = tVar;
            this.f26829b = cls;
        }
    }

    public j(i3.a aVar) {
        this.f26823a = aVar;
        g3.b bVarD = aVar.d();
        boolean z7 = false;
        String str = null;
        if (bVarD != null) {
            boolean z8 = false;
            for (a0 a0Var : bVarD.serialzeFeatures()) {
                if (a0Var == a0.WriteMapNullValue) {
                    z8 = true;
                }
            }
            String strTrim = bVarD.format().trim();
            str = strTrim.length() != 0 ? strTrim : null;
            this.f26825c = a0.a(bVarD.serialzeFeatures());
            z7 = z8;
        } else {
            this.f26825c = 0;
        }
        this.f26824b = z7;
        this.f26826d = str;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(j jVar) {
        return this.f26823a.compareTo(jVar.f26823a);
    }

    public Object b(Object obj) throws Exception {
        try {
            return this.f26823a.c(obj);
        } catch (Exception e8) {
            i3.a aVar = this.f26823a;
            Member member = aVar.f34162b;
            if (member == null) {
                member = aVar.f34163c;
            }
            throw new com.haier.library.json.d("get property error。 " + (member.getDeclaringClass().getName() + com.alibaba.android.arouter.utils.b.f12515h + member.getName()), e8);
        }
    }

    public void c(m mVar) throws IOException {
        z zVar = mVar.f26832b;
        int i7 = zVar.f26874c;
        if ((a0.QuoteFieldNames.f26811a & i7) == 0) {
            zVar.v(this.f26823a.f34161a, true);
        } else if ((i7 & a0.UseSingleQuotes.f26811a) != 0) {
            zVar.v(this.f26823a.f34161a, true);
        } else {
            char[] cArr = this.f26823a.f34173m;
            zVar.write(cArr, 0, cArr.length);
        }
    }

    public void d(m mVar, Object obj) throws Exception {
        String str = this.f26826d;
        if (str != null) {
            mVar.E(obj, str);
            return;
        }
        if (this.f26827e == null) {
            Class<?> cls = obj == null ? this.f26823a.f34167g : obj.getClass();
            this.f26827e = new a(mVar.f26831a.a(cls), cls);
        }
        a aVar = this.f26827e;
        if (obj != null) {
            Class<?> cls2 = obj.getClass();
            if (cls2 == aVar.f26829b) {
                t tVar = aVar.f26828a;
                i3.a aVar2 = this.f26823a;
                tVar.b(mVar, obj, aVar2.f34161a, aVar2.f34168h);
                return;
            } else {
                t tVarA = mVar.f26831a.a(cls2);
                i3.a aVar3 = this.f26823a;
                tVarA.b(mVar, obj, aVar3.f34161a, aVar3.f34168h);
                return;
            }
        }
        if ((this.f26825c & a0.WriteNullNumberAsZero.f26811a) != 0 && Number.class.isAssignableFrom(aVar.f26829b)) {
            mVar.f26832b.write(48);
            return;
        }
        int i7 = this.f26825c;
        if ((a0.WriteNullBooleanAsFalse.f26811a & i7) != 0 && Boolean.class == aVar.f26829b) {
            mVar.f26832b.write(com.paytm.pgsdk.d.G);
        } else if ((i7 & a0.WriteNullListAsEmpty.f26811a) == 0 || !Collection.class.isAssignableFrom(aVar.f26829b)) {
            aVar.f26828a.b(mVar, null, this.f26823a.f34161a, aVar.f26829b);
        } else {
            mVar.f26832b.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
    }
}
