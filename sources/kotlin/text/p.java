package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: Add missing generic type declarations: [T] */
    static final class a<T> extends n0 implements i5.l<T, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f35430a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i7) {
            super(1);
            this.f35430a = i7;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // i5.l
        @a7.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean z(Enum r7) {
            i iVar = (i) r7;
            return Boolean.valueOf((this.f35430a & iVar.a()) == iVar.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m f(Matcher matcher, int i7, CharSequence charSequence) {
        if (matcher.find(i7)) {
            return new n(matcher, charSequence);
        }
        return null;
    }

    private static final /* synthetic */ <T extends Enum<T> & i> Set<T> g(int i7) {
        l0.y(4, "T");
        EnumSet enumSetAllOf = EnumSet.allOf(Enum.class);
        l0.o(enumSetAllOf, "");
        l0.w();
        kotlin.collections.d0.N0(enumSetAllOf, new a(i7));
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        l0.o(setUnmodifiableSet, "unmodifiableSet(EnumSet.…mask == it.value }\n    })");
        return setUnmodifiableSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m h(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new n(matcher, charSequence);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.ranges.k i(MatchResult matchResult) {
        return kotlin.ranges.q.z1(matchResult.start(), matchResult.end());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final kotlin.ranges.k j(MatchResult matchResult, int i7) {
        return kotlin.ranges.q.z1(matchResult.start(i7), matchResult.end(i7));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int k(Iterable<? extends i> iterable) {
        Iterator<? extends i> it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= it.next().getValue();
        }
        return value;
    }
}
