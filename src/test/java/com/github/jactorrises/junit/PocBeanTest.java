package com.github.jactorrises.junit;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PocBeanTest {

    @Rule
    public ExpectedException expectedException = none();

    @Mock
    private PocApi pocApiMock;

    @InjectMocks
    private PocBean pocBeanToTest;

    @Test
    public void shouldVerifyMock() {
        pocBeanToTest.doStuff("right now");
        pocBeanToTest.doStuff("just before");

        verify(pocApiMock).doStuff("RIGHT NOW");
        verify(pocApiMock).doStuff("JUST BEFORE");
    }

    @Test
    public void shouldAssertOperationResult() {
        for (PocEnum pocEnum : Stream.of(PocEnum.values()).filter(pe -> pe != PocEnum.NOT_SUPPORTED).collect(toList())) {
            List<String> strings = pocBeanToTest.doStuff(pocEnum);
            assertThat(strings, not(hasSize(0)));
        }
    }

    @Test
    public void shouldThrowIllegalArgumentException() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("NOT_SUPPORTED");

        pocBeanToTest.doStuff(PocEnum.NOT_SUPPORTED);
    }
}