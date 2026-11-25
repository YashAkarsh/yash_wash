package com.facebook.internal;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes.dex */
public enum SmartLoginOption {
    None(0),
    Enabled(1),
    RequireConfirm(2);

    public static final EnumSet<SmartLoginOption> ALL = EnumSet.allOf(SmartLoginOption.class);
    private final long mValue;

    SmartLoginOption(long j7) {
        this.mValue = j7;
    }

    public static EnumSet<SmartLoginOption> parseOptions(long j7) {
        EnumSet<SmartLoginOption> enumSetNoneOf = EnumSet.noneOf(SmartLoginOption.class);
        for (SmartLoginOption smartLoginOption : ALL) {
            if ((smartLoginOption.getValue() & j7) != 0) {
                enumSetNoneOf.add(smartLoginOption);
            }
        }
        return enumSetNoneOf;
    }

    public long getValue() {
        return this.mValue;
    }
}
