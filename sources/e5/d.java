package e5;

import a7.e;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.internal.l0;
import kotlin.random.f;
import kotlin.ranges.k;
import kotlin.text.j;

/* JADX INFO: loaded from: classes2.dex */
public class d extends d5.a {
    @Override // kotlin.internal.l
    @a7.d
    public f b() {
        return new m5.a();
    }

    @Override // kotlin.internal.l
    @e
    public j c(@a7.d MatchResult matchResult, @a7.d String name) {
        l0.p(matchResult, "matchResult");
        l0.p(name, "name");
        Matcher matcher = matchResult instanceof Matcher ? (Matcher) matchResult : null;
        if (matcher == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        k kVar = new k(matcher.start(name), matcher.end(name) - 1);
        if (kVar.d().intValue() < 0) {
            return null;
        }
        String strGroup = matcher.group(name);
        l0.o(strGroup, "matcher.group(name)");
        return new j(strGroup, kVar);
    }
}
