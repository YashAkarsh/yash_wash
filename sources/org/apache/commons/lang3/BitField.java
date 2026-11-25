package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes3.dex */
public class BitField {
    private final int _mask;
    private final int _shift_count;

    public BitField(int i7) {
        this._mask = i7;
        int i8 = 0;
        if (i7 != 0) {
            while ((i7 & 1) == 0) {
                i8++;
                i7 >>= 1;
            }
        }
        this._shift_count = i8;
    }

    public int clear(int i7) {
        return i7 & (~this._mask);
    }

    public byte clearByte(byte b8) {
        return (byte) clear(b8);
    }

    public short clearShort(short s7) {
        return (short) clear(s7);
    }

    public int getRawValue(int i7) {
        return i7 & this._mask;
    }

    public short getShortRawValue(short s7) {
        return (short) getRawValue(s7);
    }

    public short getShortValue(short s7) {
        return (short) getValue(s7);
    }

    public int getValue(int i7) {
        return getRawValue(i7) >> this._shift_count;
    }

    public boolean isAllSet(int i7) {
        int i8 = this._mask;
        return (i7 & i8) == i8;
    }

    public boolean isSet(int i7) {
        return (i7 & this._mask) != 0;
    }

    public int set(int i7) {
        return i7 | this._mask;
    }

    public int setBoolean(int i7, boolean z7) {
        return z7 ? set(i7) : clear(i7);
    }

    public byte setByte(byte b8) {
        return (byte) set(b8);
    }

    public byte setByteBoolean(byte b8, boolean z7) {
        return z7 ? setByte(b8) : clearByte(b8);
    }

    public short setShort(short s7) {
        return (short) set(s7);
    }

    public short setShortBoolean(short s7, boolean z7) {
        return z7 ? setShort(s7) : clearShort(s7);
    }

    public short setShortValue(short s7, short s8) {
        return (short) setValue(s7, s8);
    }

    public int setValue(int i7, int i8) {
        int i9 = this._mask;
        return (i7 & (~i9)) | ((i8 << this._shift_count) & i9);
    }
}
