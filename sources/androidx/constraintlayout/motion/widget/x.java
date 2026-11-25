package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4326a = "TransitionBuilder";

    public static s.b a(s scene, int transitionId, int startConstraintSetId, androidx.constraintlayout.widget.d startConstraintSet, int endConstraintSetId, androidx.constraintlayout.widget.d endConstraintSet) {
        s.b bVar = new s.b(transitionId, scene, startConstraintSetId, endConstraintSetId);
        b(scene, bVar, startConstraintSet, endConstraintSet);
        return bVar;
    }

    private static void b(s scene, s.b transition, androidx.constraintlayout.widget.d startConstraintSet, androidx.constraintlayout.widget.d endConstraintSet) {
        int I = transition.I();
        int iB = transition.B();
        scene.j0(I, startConstraintSet);
        scene.j0(iB, endConstraintSet);
    }

    public static void c(MotionLayout layout) {
        s sVar = layout.I;
        if (sVar == null) {
            throw new RuntimeException("Invalid motion layout. Layout missing Motion Scene.");
        }
        if (!sVar.s0(layout)) {
            throw new RuntimeException("MotionLayout doesn't have the right motion scene.");
        }
        if (sVar.f4214c == null || sVar.s().isEmpty()) {
            throw new RuntimeException("Invalid motion layout. Motion Scene doesn't have any transition.");
        }
    }
}
