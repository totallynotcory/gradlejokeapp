
package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.res.Configuration;
import android.test.InstrumentationTestCase;
import android.util.Log;
import android.util.Pair;


/**
 * Test to ensure the AsyncTaskTest returns a non-null string.
 *
 * Created by ctpotwin on 11/28/15.
 */

public class AsyncTaskTest extends InstrumentationTestCase implements AsyncResponse {

    private final static String LOG_TAG = "AsyncTaskTest";

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Kick off the AsyncTask.
     * @throws Throwable
     */
    public final void testSuccessfulFetch() throws Throwable {
        new EndpointsAsyncTask().execute(this);
        }

    /**
     * when the Async task has finished, make sure out put is not null and returns a value
     * @param output string returned from asynctask
     */
    @Override
    public void processFinish(String output){
        assert (output != null && output.length() > 0);
    }

}

