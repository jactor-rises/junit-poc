package com.github.jactorrises.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@DisplayName("A PocBean")
class PocBeanJupiterTest {

    private PocApi pocApiMock;
    private PocBean pocBeanToTest;

    @BeforeEach
    void init() {
        pocApiMock = mock(PocApi.class);
        pocBeanToTest = new PocBean(pocApiMock);
    }

    @DisplayName("should call the PocApi with uppercase values")
    @Test
    void shouldVerifyMock() {
        pocBeanToTest.doStuff("right now");
        pocBeanToTest.doStuff("just before");

        verify(pocApiMock).doStuff("RIGHT NOW");
        verify(pocApiMock).doStuff("JUST BEFORE");
    }

    @DisplayName("should get a list of all acronyms for a given PocEnum")
    @ParameterizedTest
    @EnumSource(PocEnum.class)
    void shouldAssertOperationResult(PocEnum pocEnum) {
        assumeFalse(pocEnum == PocEnum.NOT_SUPPORTED);
        List<String> strings = pocBeanToTest.doStuff(pocEnum);
        assertThat(strings, not(hasSize(0)));
    }

    @DisplayName("should throw an illegal argument exception if the argument is PocEnum.NOT_SUPPORTED")
    @Test
    void shouldThrowIllegalArgumentException() {
        assertThat(assertThrows(
                IllegalArgumentException.class, () -> pocBeanToTest.doStuff(PocEnum.NOT_SUPPORTED)
        ).getMessage(), is((equalTo("NOT_SUPPORTED"))));
    }
}