package androidx.transition;

import android.content.Context;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class AutoTransition extends TransitionSet {
    public AutoTransition() {
        Z0();
    }

    private void Z0() {
        V0(1);
        I0(new Fade(2)).I0(new ChangeBounds()).I0(new Fade(1));
    }

    public AutoTransition(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Z0();
    }
}
