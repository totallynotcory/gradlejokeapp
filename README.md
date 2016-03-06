Gradle for Android 
==================
For the fourth project of the Udacity Android  Nanodegree, we were asked to use Gradle to create a joke app.  In addition to using Gradle to create a paid and free version (with ads), several modules were created.  Specifically, this app consists of four modules. It contains a Java library that provides jokes, a Google Could Endpoints (GCE) project that serves those jokes, an Android Library containing an activity for displaying jokes, and an Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

Getting Started
---------------
This sample uses the Gradle build system.  To build this project, use the
"gradlew build" command or use "Import Project" in Android Studio.

Features:
---------
- Includes free and paid versions and set up so code is shared between the versions
- Factors reusable functionality into a Java library
- Factors reusable Android functionality into an Android library
- Configures a multi project build to compile libraries and app
- Uses the Gradle App Engine plugin to deploy a backend
- Configures an integration test suite that runs against the local App Engine development server
