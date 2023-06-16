package br.eduprivate.dswalgol;

import br.eduprivate.dswalgol.vector.Position;
import br.eduprivate.dswalgol.vector.Sequence;

public class BubbleSorte {
    public static void bubbleSort1(Sequence S) {
        int n = S.size();
        for(int i = 0; i < n; i++)
            for(int j = 1; j < n-i; j++)
                if (valAtRank(S, j-1) > valAtRank(S, j));
    }

    private static int valAtRank(Sequence S, int i) {
        //return ((Integer)S.elemAtRank(i)).intValue();
        return 0;
    }

    private static int valAtPos(Position p) {
        return ((Integer) p.element()).intValue();
    }
}
