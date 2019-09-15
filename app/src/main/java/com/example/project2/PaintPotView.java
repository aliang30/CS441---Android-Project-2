package com.example.project2;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class PaintPotView extends View {
    private final int DEFAULT_DOT_SIZE = 10;
    private final int MAX_DOT_SIZE = 100;
    private final int MIN_DOT_SIZE = 5;
    private int mDotSize;
    private int mPenColor;
    private Path mPath;
    private Paint mPaint;
    private final int DEFAULT_COLOR = Color.GREEN;

    public PaintPotView(Context context) {
        super(context);
        this.init();
    }

    public PaintPotView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public int getDotSize() {
        return mDotSize;
    }

    public void changeDotSize(int increment) {
        this.mDotSize += increment;
        this.mDotSize = Math.max(mDotSize, MIN_DOT_SIZE); //ceiling
        this.mDotSize = Math.min(mDotSize, MAX_DOT_SIZE); //floor
    }

    public int getPenColor() {
        return mPenColor;
    }

    public void setPenColor(int PenColor) {
        this.mPenColor = PenColor;
    }

    private void init() {
        mDotSize = DEFAULT_DOT_SIZE;
        mPenColor = DEFAULT_COLOR;
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(mPenColor);
    }

    public PaintPotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void reset() {
    }
}
