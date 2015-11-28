/*
package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.res.Configuration;
import android.test.InstrumentationTestCase;
import android.util.Log;
import android.util.Pair;

import java.net.URL;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

*/
/**
 * Created by ctpotwin on 11/28/15.
 *//*

public class AsyncTaskTest extends InstrumentationTestCase{

    private final static String LOG_TAG = "AsyncTaskTest";
    private static boolean called;
    private final Context context = getInstrumentation().getContext();

    protected void setUp() throws Exception {
        super.setUp();
        called = false;
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public final void testSuccessfulFetch() throws Throwable {
        // create  a signal to let us know when our task is done.
        final CountDownLatch signal = new CountDownLatch(1);

        // Execute the async task on the UI thread! THIS IS KEY!
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                new EndpointsAsyncTask() {

                    @Override
                    protected void onPostExecute (String result){

                        assert(result.length() > 0);
                    //    super.onPostExecute(result);

                */
/* This is the key, normally you would use some type of listener
                 * to notify your activity that the async call was finished.
                 *
                 * In your test method you would subscribe to that and signal
                 * from there instead.
                 *//*

                        signal.countDown();
                    }
                }.execute(new Pair<Context, Integer>(context, 1));

            }
        });

	    */
/* The testing thread will wait here until the UI thread releases it
	     * above with the countDown() or 30 seconds passes and it times out.
	     *//*

            signal.await(10,TimeUnit.SECONDS);

            assertTrue(called);
        }

    }
*/
