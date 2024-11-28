package com.gsd.daw.prog;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

public class AppTest {

    

    int contarCuantos(int[] elements, int n) {
        int counter = 0;

        for (int element : elements) {
            counter++;
        }

        return counter;
    }

}



