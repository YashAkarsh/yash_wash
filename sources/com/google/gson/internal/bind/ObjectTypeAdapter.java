package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.internal.i;
import com.google.gson.stream.d;
import com.google.gson.x;
import com.google.gson.y;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class ObjectTypeAdapter extends x<Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y f23049b = new y() { // from class: com.google.gson.internal.bind.ObjectTypeAdapter.1
        @Override // com.google.gson.y
        public <T> x<T> a(f fVar, com.google.gson.reflect.a<T> aVar) {
            if (aVar.getRawType() == Object.class) {
                return new ObjectTypeAdapter(fVar);
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f23050a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f23051a;

        static {
            int[] iArr = new int[com.google.gson.stream.c.values().length];
            f23051a = iArr;
            try {
                iArr[com.google.gson.stream.c.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23051a[com.google.gson.stream.c.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23051a[com.google.gson.stream.c.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f23051a[com.google.gson.stream.c.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f23051a[com.google.gson.stream.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f23051a[com.google.gson.stream.c.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    ObjectTypeAdapter(f fVar) {
        this.f23050a = fVar;
    }

    @Override // com.google.gson.x
    public Object e(com.google.gson.stream.a aVar) throws IOException {
        switch (a.f23051a[aVar.J0().ordinal()]) {
            case 1:
                ArrayList arrayList = new ArrayList();
                aVar.b();
                while (aVar.H()) {
                    arrayList.add(e(aVar));
                }
                aVar.C();
                return arrayList;
            case 2:
                i iVar = new i();
                aVar.e();
                while (aVar.H()) {
                    iVar.put(aVar.r0(), e(aVar));
                }
                aVar.E();
                return iVar;
            case 3:
                return aVar.G0();
            case 4:
                return Double.valueOf(aVar.l0());
            case 5:
                return Boolean.valueOf(aVar.h0());
            case 6:
                aVar.v0();
                return null;
            default:
                throw new IllegalStateException();
        }
    }

    @Override // com.google.gson.x
    public void i(d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.g0();
            return;
        }
        x xVarQ = this.f23050a.q(obj.getClass());
        if (!(xVarQ instanceof ObjectTypeAdapter)) {
            xVarQ.i(dVar, obj);
        } else {
            dVar.r();
            dVar.C();
        }
    }
}
