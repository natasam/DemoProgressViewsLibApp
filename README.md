# Android-ProgressViewsLib
Android library with custom Progress Bars in different shapes. 

![example1](https://github.com/natasam/DemoProgressViewsLibApp/blob/master/screenshots/Screenshot_2015-12-13-17-36-48.png)![example3](https://github.com/natasam/DemoProgressViewsLibApp/blob/master/screenshots/Screenshot_2015-12-13-18-23-10.png)![example2](https://github.com/natasam/DemoProgressViewsLibApp/blob/master/screenshots/Screenshot_2015-12-13-15-56-38.png)
##DemoProgressViewsLibApp
DemoProgressViewsLibApp is sample app with **progressviewslib**, Android library which is collection of custom views that represents 
ProgressBars in different shapes. It is easy to understand, to integrate and to customize it.
At the moment there are four different types:

-**CircleProgressBar**

-**CircleSegmentBar**

-**ArcProgressBar**

-**LineProgressBar**(vertical or horizontal)

All Progress views can be easy customized by your needs, through a wide range of methods or through xml.

#Implementation
In https://github.com/natasam/DemoProgressViewsLibApp you have example with all four views in role of ProgressBar and 
how to customize them.
Basic implementation though xml would be, for example for CircleProgressBar:
```
<com.natasa.progressviews.CircleProgressBar
            android:id="@+id/circle_progress"
            android:layout_width="130dp"
            android:layout_height="130dp"
            app:bar_width="12dp"
            app:bar_color="#b5b6b9"
            app:progress=55
            app:progress_color="#d3f115"
            app:progress_width="10dp" />
            
or you can add it programmatically in your class:
 
 CircleProgressBar circleProgressBar = new CircleProgressBar(this);
        ((ViewGroup) findViewById(R.id.rlContainer)).addView(circleProgressBar);
        circleProgressBar.setProgress(65);
        circleProgressBar.setWidth(200);
        circleProgressBar.setWidthProgressBackground(25);
        circleProgressBar.setWidthProgressBarLine(25);
        circleProgressBar.setText("Loading...");
        circleProgressBar.setTextSize(30);
        circleProgressBar.setBackgroundColor(Color.LTGRAY);
        circleProgressBar.setProgressColor(Color.RED);
        
         
 or you can set Linear gradient for progress with default colors or add your array of colors:

        circleProgressBar.setLinearGradientProgress(true);
or
        circleProgressBar.setLinearGradientProgress(true, colors_array);
 
 
 
you can add progress listener on every ProgressView:

circleProgressBar.setOnProgressViewListener(new OnProgressViewListener() {
            @Override
            public void onFinish() {
                //do something on progress finish
                circleProgressBar.setText("done!");
                // circleProgressBar.resetProgressBar();
            }

            @Override
            public void onProgressUpdate(float progress) {
                circleProgressBar.setText("" + (int) progress);

            }
        });
        
        
   for convenience, you can always cast them as ProgressShape:
   
   ProgressViewFactory pv = new ProgressViewFactory(this);
        ProgressShape progres = pv.getShape(ShapeType.ARC);
        addView((View) progres);
   
   
        
 All of them extend ProgressView class which extends View and also implements ProgressShape interface.
  So you have a lot of possibilities to use them as you wish.

 you can set all Progress views as indeterminate progress with infinite animation 
 and speed of animation as parametar.
        progressBar.setProgressIndeterminateAnimation(2000);
 ```
  
#Library
  Library is available here: https://github.com/natasam/android-progressviewslib
