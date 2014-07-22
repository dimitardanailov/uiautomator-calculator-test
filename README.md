<h2> Configuration</h2>

1. Using eclipse create a new project.

<pre>
2.1 Right click of project and select "Properties" -> "Libraries" -> "Add library" -> "JUnit" -> "JUnit version 3" -> "Next" -> "Finish"
</pre>

<pre>
2.2 Right click of project and select "Properties" -> "Libraries" -> "Add external JARs" find android-sdk folder and select android.jar and uiautomator.jar
</pre>

My locations are: 

/home/user/android-sdk/platform/{latest-android-version}/android.jar

/home/user/android-sdk/platform/{latest-android-version}/uiautomator.jar

<h2>
Compile your test cases into a JAR file and install it on your test device along with your app.
</h2>

1. Create a jar file
<pre>
/home/user/android-sdks/tools/android create uitest-project -n MyQAProject -t 5 -p /home/user/workspace/Android/AndroidQAFirstProject/
</pre>

2. Go to project folder and type: 
<pre>
ant build
</pre>

3. Upload a jar file to device:
<pre>
/home/user/android-sdks/platform-tools/adb push /home/user/workspace/Android/AndroidQAFirstProject/bin/MyFirstQAproject.jar /data/local/tmp
</pre>

<h2>
Run the tests and view the test results.
</h2>

Example 1: 
<pre>
/home/user/android-sdks/platform-tools/adb shell uiautomator runtest {jar file name}.jar -c {package name}.{class name}
</pre>

Example 2:
<pre>
cd /home/user/android-sdks/platform-tools/
adb shell uiautomator runtest MyFirstQAproject.jar -c testcases.CalculatorTest
</pre>

<h3> Demo </h3>

https://www.youtube.com/watch?v=y8CRUAk2d7U

For more information please visit: 

- http://university.utest.com/android-ui-testing-uiautomatorviewer-and-uiautomator/
- http://developer.android.com/tools/testing/testing_ui.html
- http://www.tutorialspoint.com/android/android_ui_testing.htm
- https://www.youtube.com/watch?v=O1u8iBLUFL0

