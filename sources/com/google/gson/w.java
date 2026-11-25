package com.google.gson;

import com.facebook.share.internal.MessengerShareContentUtility;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public abstract class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f23310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f23311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ w[] f23312c;

    final enum a extends w {
        a(String str, int i7) {
            super(str, i7, null);
        }

        @Override // com.google.gson.w
        public l a(Long l7) {
            return new r(l7);
        }
    }

    static {
        a aVar = new a(MessengerShareContentUtility.PREVIEW_DEFAULT, 0);
        f23310a = aVar;
        w wVar = new w("STRING", 1) { // from class: com.google.gson.w.b
            {
                a aVar2 = null;
            }

            @Override // com.google.gson.w
            public l a(Long l7) {
                return new r(String.valueOf(l7));
            }
        };
        f23311b = wVar;
        f23312c = new w[]{aVar, wVar};
    }

    private w(String str, int i7) {
        super(str, i7);
    }

    public static w valueOf(String str) {
        return (w) Enum.valueOf(w.class, str);
    }

    public static w[] values() {
        return (w[]) f23312c.clone();
    }

    public abstract l a(Long l7);

    /* synthetic */ w(String str, int i7, a aVar) {
        this(str, i7);
    }
}
