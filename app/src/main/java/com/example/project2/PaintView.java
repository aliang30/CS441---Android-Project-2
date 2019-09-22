package com.example.project2;

import android.util.AttributeSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.util.ArrayList;


public class PaintView extends View implements View.OnTouchListener{

    private int DEFAULT_COLOR = Color.BLACK;
    private final int DEFAULT_DOT_SIZE = 5;
    private final int MAX_DOT_SIZE = 100;
    private final int MIN_DOT_SIZE = 0;
    private int mDotSize;
    private int mPenColor;
    private Path mPath;
    private Paint mPaint;

    private float X, Y, OldX, OldY;
    private ArrayList<Path> mPaths;
    private ArrayList<Paint> mPaints;

    //Constructor
    public PaintView(Context context) {
        super(context);
        this.init();
    }

    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.init();
    }

    public void changeDotSize(int increment) {
        this.mDotSize += increment;
        this.mDotSize = Math.max(mDotSize, MIN_DOT_SIZE); //ceiling
        this.mDotSize = Math.min(mDotSize, MAX_DOT_SIZE); //floor
    }

    public void setPenColor(int penColor) {
        this.mPenColor = penColor;
        this.mPaint.setColor(mPenColor);
    }

    private void init() {
        this.mDotSize = DEFAULT_DOT_SIZE;
        this.mPenColor = DEFAULT_COLOR;
        this.mPath = new Path();
        this.mPaths = new ArrayList<>();
        this.mPaints = new ArrayList<>();
        this.addPath(false);
        this.X = this.Y = this.OldX = this.OldY = (float) 0.0;
        this.setOnTouchListener(this);
        this.X = this.Y = (float) 0.0;
    }

    //erase everything on the canvas
    public void reset() {
        this.init();
        this.invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0 ; i < mPaths.size() ; i++)
            canvas.drawPath(mPaths.get(i), mPaints.get(i));
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        X = motionEvent.getX();
        Y = motionEvent.getY();

        Log.d("Touched:", " (" + X + "," + Y + ")");

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                this.addPath(false);
                this.mPath.addCircle(X, Y, mDotSize / 2, Path.Direction.CW);
                this.addPath(false);
                this.mPath.moveTo(X, Y);
                break;
            case MotionEvent.ACTION_MOVE:
                this.mPath.lineTo(X, Y);
                break;
            case MotionEvent.ACTION_UP:
                this.addPath(true);
                if (OldX == X && OldY == Y) {
                    this.mPath.addCircle(X, Y, mDotSize / 2, Path.Direction.CW);
                }
                break;
        }
        this.invalidate();
        OldX = X;
        OldY = Y;

        return true;
    }

    private void addPath(boolean fill){
        mPath = new Path();
        mPaths.add(mPath);
        mPaint = new Paint();
        mPaints.add(mPaint);
        mPaint.setColor(mPenColor);
        if (!fill) {
            mPaint.setStyle(Paint.Style.STROKE);
        }
        mPaint.setStrokeWidth(mDotSize);
    }
}
