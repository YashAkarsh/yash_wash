package bolts;

/* JADX INFO: loaded from: classes.dex */
public class n extends RuntimeException {
    public n(Exception exc) {
        super("An exception was thrown by an Executor", exc);
    }
}
