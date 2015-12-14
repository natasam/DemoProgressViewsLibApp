package com.natasa.demoprogressviews;


import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;

import com.natasa.progressviews.ArcProgressBar;
import com.natasa.progressviews.CircleProgressBar;
import com.natasa.progressviews.CircleSegmentBar;
import com.natasa.progressviews.LineProgressBar;
import com.natasa.progressviews.utils.OnProgressViewListener;
import com.natasa.progressviews.utils.ProgressLineOrientation;
import com.natasa.progressviews.utils.ProgressShape;
import com.natasa.progressviews.utils.ProgressStartPoint;
import com.natasa.progressviews.utils.ProgressViewFactory;
import com.natasa.progressviews.utils.ShapeType;

public class DemoActivity extends AppCompatActivity {
    private CircleProgressBar circleProgressBar;
    private CircleProgressBar circleProgressBar1;
    private CircleSegmentBar segmentBar;
    private LineProgressBar lineProgressbar;
    private Runnable mTimer;
    protected int progress;
    private Handler mHandler;
    private LineProgressBar lineProgressbar1;
    private ArcProgressBar arc_progressbar;
    private int[] colors = {Color.GRAY, Color.CYAN, Color.BLUE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHandler = new Handler();

        //initSegmentProgressBar();


        initLineProgressBar();

        circleProgressBar1 = (CircleProgressBar) findViewById(R.id.circle_progress1);
        circleProgressBar = (CircleProgressBar) findViewById(R.id.circle_progress);


       // arc_progressbar = (ArcProgressBar) findViewById(R.id.arc_progressbar);
       // arc_progressbar.setLinearGradientProgress(true, colors);
        circleProgressBar1.setRoundEdgeProgress(true);

        circleProgressBar1.setLinearGradientProgress(true, colors);
        circleProgressBar.setRoundEdgeProgress(true);
        circleProgressBar.setTextSize(62);
        circleProgressBar.setLinearGradientProgress(true);

        //you can set listener for progress in every ProgressView
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
        // addArcProgress();
        addCircleView();


    }

    private void initLineProgressBar() {
        lineProgressbar = (LineProgressBar) findViewById(R.id.line_progressbar);
        lineProgressbar1 = (LineProgressBar) findViewById(R.id.line_progressbar1);
        lineProgressbar1.setLineOrientation(ProgressLineOrientation.VERTICAL);
        lineProgressbar1.setLinearGradientProgress(true);
    }

    private void initSegmentProgressBar() {
        segmentBar = (CircleSegmentBar) findViewById(R.id.segment_bar);
        //you can set for every ProgressView width, progress background width, progress bar line width
        segmentBar.setCircleViewPadding(2);
        segmentBar.setWidth(250);
        segmentBar.setWidthProgressBackground(25);
        segmentBar.setWidthProgressBarLine(25);
        //you can set start position for progress
        segmentBar.setStartPositionInDegrees(ProgressStartPoint.BOTTOM);

        //you can set linear gradient with default colors or to set yours colors, or sweep gradient
        segmentBar.setLinearGradientProgress(true);
    }

    //examples adding progressview programatically
    private void addArcProgress() {
        ProgressViewFactory pv = new ProgressViewFactory(this);
        ProgressShape progres = pv.getShape(ShapeType.ARC);
        ((ViewGroup) findViewById(R.id.rlMain)).addView((View) progres);
        ((ArcProgressBar) progres).setProgressIndeterminateAnimation(2000);
    }

    private void addCircleView() {
        CircleProgressBar cpbar = new CircleProgressBar(this);
        ((ViewGroup) findViewById(R.id.rlContainer)).addView(cpbar);
        cpbar.setProgress(65);
        cpbar.setWidth(200);
        cpbar.setText("Loading...");
        cpbar.setTextSize(30);
        cpbar.setBackgroundColor(Color.LTGRAY);
        cpbar.setProgressColor(Color.RED);

    }


    @Override
    protected void onResume() {
        super.onResume();
        setTimer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mTimer);

    }

    private void setTimer() {
        mTimer = new Runnable() {
            @Override
            public void run() {
                progress += 1;
                if (progress <= 100)
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            circleProgressBar.setProgress(progress);

                            circleProgressBar1.setProgress(progress);
                            circleProgressBar1.setText("" + progress, Color.DKGRAY);

                            //lineProgressbar.setProgress(progress);
                            //lineProgressbar1.setProgress(progress);

                            //segmentBar.setProgress((float) progress);
                            //segmentBar.setText("" + progress, 30, Color.GRAY);

                           // arc_progressbar.setProgress(progress);
                           // arc_progressbar.setText("" + progress);
                        }
                    });

                mHandler.postDelayed(this, 100);
            }
        };

        mHandler.postDelayed(mTimer, 1000);

    }
}
