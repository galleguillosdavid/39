package com.example.veri.model;

import com.example.veri.R;
import com.google.j2objc.annotations.Weak;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class VerifierTest {

    private Verifier verifier;

    @Before
    public void setUp() {
        verifier = new Verifier();
    }

    @Test
    public void verifierWeek() {
        //Given
        String password = "pass";

        //When
        int option = verifier.evaluatePass(password);

        //Then
        assertThat(option).isEqualTo(Verifier.WEAK);
        assertThat(option).isEqualTo(-1);

    }

    @Test
    public void verifierMedium() {
        //Given
        String password = "passea";

        //When
        int option = verifier.evaluatePass(password);

        //Then
        assertThat(option).isEqualTo(Verifier.MEDIUM);
        assertThat(option).isEqualTo(-2);
    }

    @Test
    public void verifierStrong() {
        //Given
        String password = "passAB";

        //When
        int option = verifier.evaluatePass(password);

        //Then
        assertThat(option).isEqualTo(Verifier.STRONG);
        assertThat(option).isEqualTo(-3);
    }
}
