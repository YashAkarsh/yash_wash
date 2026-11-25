package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f10675b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f10674a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<Transition> f10676c = new ArrayList<>();

    @Deprecated
    public d0() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f10675b == d0Var.f10675b && this.f10674a.equals(d0Var.f10674a);
    }

    public int hashCode() {
        return (this.f10675b.hashCode() * 31) + this.f10674a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f10675b + "\n") + "    values:";
        for (String str2 : this.f10674a.keySet()) {
            str = str + "    " + str2 + ": " + this.f10674a.get(str2) + "\n";
        }
        return str;
    }

    public d0(@c.m0 View view) {
        this.f10675b = view;
    }
}
