package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.k;

/* JADX INFO: loaded from: classes3.dex */
public class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Exception> f40071a = Collections.emptyList();

    @Override // org.junit.validator.e
    public List<Exception> a(k kVar) {
        if (kVar.p()) {
            return f40071a;
        }
        return Collections.singletonList(new Exception("The class " + kVar.k() + " is not public."));
    }
}
