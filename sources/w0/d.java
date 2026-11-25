package w0;

import com.bumptech.glide.load.engine.m;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class d<T> implements g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Collection<? extends g<T>> f40492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f40493b;

    @SafeVarargs
    public d(g<T>... gVarArr) {
        if (gVarArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f40492a = Arrays.asList(gVarArr);
    }

    @Override // w0.g
    public String a() {
        if (this.f40493b == null) {
            StringBuilder sb = new StringBuilder();
            Iterator<? extends g<T>> it = this.f40492a.iterator();
            while (it.hasNext()) {
                sb.append(it.next().a());
            }
            this.f40493b = sb.toString();
        }
        return this.f40493b;
    }

    @Override // w0.g
    public m<T> b(m<T> mVar, int i7, int i8) {
        Iterator<? extends g<T>> it = this.f40492a.iterator();
        m<T> mVar2 = mVar;
        while (it.hasNext()) {
            m<T> mVarB = it.next().b(mVar2, i7, i8);
            if (mVar2 != null && !mVar2.equals(mVar) && !mVar2.equals(mVarB)) {
                mVar2.a();
            }
            mVar2 = mVarB;
        }
        return mVar2;
    }

    public d(Collection<? extends g<T>> collection) {
        if (collection.size() >= 1) {
            this.f40492a = collection;
            return;
        }
        throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
    }
}
