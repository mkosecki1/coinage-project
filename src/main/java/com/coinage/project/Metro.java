package com.coinage.project;

import java.util.ArrayList;

class Metro {

    public static int countPassengers(ArrayList<int[]> stops) {
        int enter = 0;
        int leave = 0;

        for (int[] stop: stops) {
            enter += stop[0];
            leave += stop[1];
        }
        return enter - leave;
    }

}
