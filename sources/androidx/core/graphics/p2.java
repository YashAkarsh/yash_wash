package androidx.core.graphics;

import android.graphics.Matrix;
import android.graphics.Shader;

/* JADX INFO: loaded from: classes.dex */
public final class p2 {
    public static final void a(@a7.d Shader shader, @a7.d i5.l<? super Matrix, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(shader, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        Matrix matrix = new Matrix();
        shader.getLocalMatrix(matrix);
        block.z(matrix);
        shader.setLocalMatrix(matrix);
    }
}
