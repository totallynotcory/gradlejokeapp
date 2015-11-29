/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.builditbigger.finalproject.jokebackend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "jokebackend.finalproject.com.corypotwin.builditbigger.com",
    ownerName = "jokebackend.finalproject.com.corypotwin.builditbigger.com",
    packagePath=""
  )
)

public class MyEndpoint {

    /** A simple endpoint method that returns a joke from the jokeGenerator library*/
    @ApiMethod(name = "returnJoke")
    public MyBean returnJoke() {
        MyBean response = new MyBean();
        String jokeResponse = com.builditbigger.jokeGenerator.tellJoke();
        response.setData(jokeResponse);

        return response;
    }
}
