package org.apache.commons.collections4.sequence;

import java.util.List;
import org.apache.commons.collections4.Equator;
import org.apache.commons.collections4.functors.DefaultEquator;

/* JADX INFO: loaded from: classes3.dex */
public class SequencesComparator<T> {
    private final Equator<? super T> equator;
    private final List<T> sequence1;
    private final List<T> sequence2;
    private final int[] vDown;
    private final int[] vUp;

    private static class Snake {
        private final int diag;
        private final int end;
        private final int start;

        public Snake(int i7, int i8, int i9) {
            this.start = i7;
            this.end = i8;
            this.diag = i9;
        }

        public int getDiag() {
            return this.diag;
        }

        public int getEnd() {
            return this.end;
        }

        public int getStart() {
            return this.start;
        }
    }

    public SequencesComparator(List<T> list, List<T> list2) {
        this(list, list2, DefaultEquator.defaultEquator());
    }

    private void buildScript(int i7, int i8, int i9, int i10, EditScript<T> editScript) {
        Snake middleSnake = getMiddleSnake(i7, i8, i9, i10);
        if (middleSnake != null && ((middleSnake.getStart() != i8 || middleSnake.getDiag() != i8 - i10) && (middleSnake.getEnd() != i7 || middleSnake.getDiag() != i7 - i9))) {
            buildScript(i7, middleSnake.getStart(), i9, middleSnake.getStart() - middleSnake.getDiag(), editScript);
            for (int start = middleSnake.getStart(); start < middleSnake.getEnd(); start++) {
                editScript.append(new KeepCommand<>(this.sequence1.get(start)));
            }
            buildScript(middleSnake.getEnd(), i8, middleSnake.getEnd() - middleSnake.getDiag(), i10, editScript);
            return;
        }
        int i11 = i7;
        int i12 = i9;
        while (true) {
            if (i11 >= i8 && i12 >= i10) {
                return;
            }
            if (i11 < i8 && i12 < i10 && this.equator.equate(this.sequence1.get(i11), this.sequence2.get(i12))) {
                editScript.append(new KeepCommand<>(this.sequence1.get(i11)));
                i11++;
            } else if (i8 - i7 > i10 - i9) {
                editScript.append(new DeleteCommand<>(this.sequence1.get(i11)));
                i11++;
            } else {
                editScript.append(new InsertCommand<>(this.sequence2.get(i12)));
            }
            i12++;
        }
    }

    private Snake buildSnake(int i7, int i8, int i9, int i10) {
        int i11 = i7;
        while (true) {
            int i12 = i11 - i8;
            if (i12 >= i10 || i11 >= i9 || !this.equator.equate(this.sequence1.get(i11), this.sequence2.get(i12))) {
                break;
            }
            i11++;
        }
        return new Snake(i7, i11, i8);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0051  */
    /* JADX WARN: Code duplicated, block: B:49:0x00c8  */
    private Snake getMiddleSnake(int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14 = i8 - i7;
        int i15 = i10 - i9;
        if (i14 == 0 || i15 == 0) {
            return null;
        }
        int i16 = i14 - i15;
        int i17 = i15 + i14;
        if (i17 % 2 != 0) {
            i17++;
        }
        int i18 = i17 / 2;
        int i19 = i18 + 1;
        this.vDown[i19] = i7;
        this.vUp[i19] = i8 + 1;
        for (int i20 = 0; i20 <= i18; i20++) {
            int i21 = -i20;
            for (int i22 = i21; i22 <= i20; i22 += 2) {
                int i23 = i22 + i18;
                if (i22 == i21) {
                    int[] iArr = this.vDown;
                    iArr[i23] = iArr[i23 + 1];
                } else {
                    if (i22 != i20) {
                        int[] iArr2 = this.vDown;
                        if (iArr2[i23 - 1] < iArr2[i23 + 1]) {
                            int[] iArr3 = this.vDown;
                            iArr3[i23] = iArr3[i23 + 1];
                        }
                    }
                    int[] iArr4 = this.vDown;
                    iArr4[i23] = iArr4[i23 - 1] + 1;
                }
                int i24 = this.vDown[i23];
                for (int i25 = ((i24 - i7) + i9) - i22; i24 < i8 && i25 < i10 && this.equator.equate(this.sequence1.get(i24), this.sequence2.get(i25)); i25++) {
                    i24++;
                    this.vDown[i23] = i24;
                }
                if (i16 % 2 != 0 && i16 - i20 <= i22 && i22 <= i16 + i20 && (i13 = this.vUp[i23 - i16]) <= this.vDown[i23]) {
                    return buildSnake(i13, (i22 + i7) - i9, i8, i10);
                }
            }
            int i26 = i16 - i20;
            int i27 = i26;
            while (true) {
                int i28 = i16 + i20;
                if (i27 <= i28) {
                    int i29 = (i27 + i18) - i16;
                    if (i27 == i26) {
                        int[] iArr5 = this.vUp;
                        iArr5[i29] = iArr5[i29 + 1] - 1;
                    } else {
                        if (i27 != i28) {
                            int[] iArr6 = this.vUp;
                            if (iArr6[i29 + 1] <= iArr6[i29 - 1]) {
                                int[] iArr7 = this.vUp;
                                iArr7[i29] = iArr7[i29 + 1] - 1;
                            }
                        }
                        int[] iArr8 = this.vUp;
                        iArr8[i29] = iArr8[i29 - 1];
                    }
                    int i30 = this.vUp[i29] - 1;
                    int i31 = ((i30 - i7) + i9) - i27;
                    while (true) {
                        if (i30 < i7 || i31 < i9) {
                            i11 = i18;
                            break;
                        }
                        i11 = i18;
                        if (!this.equator.equate(this.sequence1.get(i30), this.sequence2.get(i31))) {
                            break;
                        }
                        this.vUp[i29] = i30;
                        i31--;
                        i30--;
                        i18 = i11;
                    }
                    if (i16 % 2 == 0 && i21 <= i27 && i27 <= i20 && (i12 = this.vUp[i29]) <= this.vDown[i29 + i16]) {
                        return buildSnake(i12, (i27 + i7) - i9, i8, i10);
                    }
                    i27 += 2;
                    i18 = i11;
                }
            }
        }
        throw new RuntimeException("Internal Error");
    }

    public EditScript<T> getScript() {
        EditScript<T> editScript = new EditScript<>();
        buildScript(0, this.sequence1.size(), 0, this.sequence2.size(), editScript);
        return editScript;
    }

    public SequencesComparator(List<T> list, List<T> list2, Equator<? super T> equator) {
        this.sequence1 = list;
        this.sequence2 = list2;
        this.equator = equator;
        int size = list.size() + list2.size() + 2;
        this.vDown = new int[size];
        this.vUp = new int[size];
    }
}
