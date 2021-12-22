package com.learn.transformer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MsgTransformerTest {
    MsgTransformer msgTransformer = new MsgTransformer();

    @Test
    public void test_stringToInt() {
        msgTransformer.stringToInt("123");
    }
}
