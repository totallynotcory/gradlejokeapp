package com.corypotwin;

import org.junit.Test;
/**
 * Created by ctpotwin on 11/27/15.
 */
public class jokeTester {

    @Test
    public static void testJoke(){
        String joke = jokeGenerator.tellJoke();
        assert(joke.length() != 0);
    }
}
