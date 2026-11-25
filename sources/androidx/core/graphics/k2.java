package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;

/* JADX INFO: loaded from: classes.dex */
public final class k2 {
    @a7.d
    public static final Picture a(@a7.d Picture picture, int i7, int i8, @a7.d i5.l<? super Canvas, kotlin.l2> block) {
        kotlin.jvm.internal.l0.p(picture, "<this>");
        kotlin.jvm.internal.l0.p(block, "block");
        Canvas canvasBeginRecording = picture.beginRecording(i7, i8);
        kotlin.jvm.internal.l0.o(canvasBeginRecording, "beginRecording(width, height)");
        try {
            block.z(canvasBeginRecording);
            return picture;
        } finally {
            kotlin.jvm.internal.i0.d(1);
            picture.endRecording();
            kotlin.jvm.internal.i0.c(1);
        }
    }
}
