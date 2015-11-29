package com.udacity.gradle.builditbigger;

/**
 * Interface for processing Async Reponses from the EndpointsAsyncTask
 *
 * Created by ctpotwin on 11/28/15.
 */
public interface AsyncResponse {
    void processFinish(String output);
}
