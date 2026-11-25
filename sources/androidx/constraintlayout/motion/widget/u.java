package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
interface u {
    long a();

    int b(int cmd, String type, Object viewObject, float[] in, int inLength, float[] out, int outLength);

    boolean c(Object view, int position, int type, float x7, float y7);

    void d(float position);

    Boolean e(Object keyFrame, Object view, float x7, float y7, String[] attribute, float[] value);

    void f(Object view, int position, String name, Object value);

    void g(int dpi, String constraintSetId, Object opaqueView, Object opaqueAttributes);

    float h(Object view, int type, float x7, float y7);

    Object i(Object viewObject, float x7, float y7);
}
