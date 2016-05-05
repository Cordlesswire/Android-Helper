# Android-Helper [![](https://jitpack.io/v/com.amqtech/Android-Helper.svg)](https://jitpack.io/#com.amqtech/Android-Helper)
A small, simple library providing developers with some utility methods to use in their code.

# Compile in your Project
Add this in your root build.gradle file (not your module build.gradle file):

```
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Next, add the dependency in your module:

```
dependencies {
	   compile 'com.github.Andrew-Quebe:Android-Helper:v0.2.1'
}
````

# Features
Android-Helper currently has a small amount of functions, but that will change as future releases become available. Below are some things you can do with it already.

## Toasts
You can easily show short or long toasts with this code:

```
// Short Toast
AndroidHelper.shortToast(getBaseContext(), "Your message");

// Long Toast
AndroidHelper.longToast(getBaseContext(), "Your message");
```

## Convert Drawables to Bitmaps
This allows you to convert your drawable resources into Bitmap resources.

```
AndroidHelper.drawableToBitmap(ResourcesCompat.getDrawable(getResources(), drawable, theme));
```

## Dark Versions of Colors
This lets you convert your app colors to different shades using float values.

```
// float value: 0.1 = 10%, 0.9 = 90%
AndroidHelper.darker(Color.parseColor("#FFFFFF"), 0.8f);
```

# Java Documentation
If you would like to view the Javadocs for this library, [click here.](https://cdn.rawgit.com/Andrew-Quebe/Android-Helper/master/javadoc/index.html)

# Contributions
If you'd like to contribute to this library, feel free to make a pull request with your changes. 

# Developed By
Andrew Quebe<br>
[andrewquebe@amqtech.com](mailto:andrewquebe@amqtech.com)

# License

```
Copyright 2016 Andrew Quebe

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

