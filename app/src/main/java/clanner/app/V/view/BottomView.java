package clanner.app.V.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import clanner.app.V.R;

/**
 * Created by Clanner on 2016/6/29.
 * 底部自定义View
 */
public class BottomView extends View {
    private static final String INSTANCE_STATUS = "instance_status";
    private static final String STATUS_ALPHA = "status_alpha";

    //底部icon
    private Bitmap bottomIcon;
    private Bitmap mBitmap;
    //底部icon颜色
    private int bottomColor = 0xFF45C01A;
    //底部文字
    private String bottomText = "App";
    //底部文字大小
    private int bottomTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 12,
            getResources().getDisplayMetrics());
    //图片范围
    private Rect iconBound;
    //文字范围
    private Rect textBound;
    //绘制图片的画笔
    private Paint iconPaint;
    //绘制文字的画笔
    private Paint textPaint;
    private float mAlpha;
    //绘制图片的画布
    private Canvas iconCanvas;

    public BottomView(Context context) {
        this(context, null);
    }

    public BottomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BottomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BottomView);
        int n = typedArray.getIndexCount();

        for (int i = 0; i < n; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.BottomView_bottom_icon:
                    BitmapDrawable drawable = (BitmapDrawable) typedArray.getDrawable(attr);
                    bottomIcon = drawable.getBitmap();
                    break;
                case R.styleable.BottomView_bottom_color:
                    bottomColor = typedArray.getColor(attr, 0xFF45C01A);
                    break;
                case R.styleable.BottomView_bottom_text:
                    bottomText = typedArray.getString(attr);
                    break;
                case R.styleable.BottomView_bottom_textSize:
                    bottomTextSize = (int) typedArray.getDimension(attr, TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 12, getResources().getDisplayMetrics()));
                    break;
            }
        }
        typedArray.recycle();
        textBound = new Rect();
        textPaint = new Paint();
        textPaint.setTextSize(bottomTextSize);
        textPaint.setColor(bottomColor);
        textPaint.getTextBounds(bottomText, 0, bottomText.length(), textBound);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int iconWidth = Math.min(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(),
                getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
        int left = (getMeasuredWidth() - iconWidth) / 2;
        int top = (getMeasuredHeight() - (textBound.height() + iconWidth)) / 2;
        iconBound = new Rect(left, top, left + iconWidth, top + iconWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bottomIcon, null, iconBound, null);
        int alpha = (int) Math.ceil(255 * mAlpha);

        //内存去准备mBitmap , setAlpha , 纯色 ，xfermode ， 图标
        setupTargetBitmap(alpha);
        // 1、绘制原文本 ； 2、绘制变色的文本
        drawSourceText(canvas, alpha);
        drawTargetText(canvas, alpha);

        canvas.drawBitmap(mBitmap, 0, 0, null);
    }

    /**
     * 在内存中绘制可变色的Icon
     *
     * @param alpha
     */
    private void setupTargetBitmap(int alpha) {
        mBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        iconCanvas = new Canvas(mBitmap);
        iconPaint = new Paint();
        iconPaint.setColor(bottomColor);
        iconPaint.setAntiAlias(true);
        iconPaint.setDither(true);
        iconPaint.setAlpha(alpha);
        iconCanvas.drawRect(iconBound, iconPaint);
        iconPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        iconPaint.setAlpha(255);
        iconCanvas.drawBitmap(bottomIcon, null, iconBound, iconPaint);
    }

    /**
     * 绘制原文本
     *
     * @param canvas
     * @param alpha
     */
    private void drawSourceText(Canvas canvas, int alpha) {
        textPaint.setColor(0xff333333);
        textPaint.setAlpha(255 - alpha);
        int x = getMeasuredWidth() / 2 - textBound.width() / 2;
        int y = iconBound.bottom + textBound.height()/2;
        canvas.drawText(bottomText, x, y, textPaint);
    }

    /**
     * 绘制变色的文本
     *
     * @param canvas
     * @param alpha
     */
    private void drawTargetText(Canvas canvas, int alpha) {
        textPaint.setColor(bottomColor);
        textPaint.setAlpha(alpha);
        int x = getMeasuredWidth() / 2 - textBound.width() / 2;
        int y = iconBound.bottom + textBound.height()/2;
        canvas.drawText(bottomText, x, y, textPaint);
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATUS, super.onSaveInstanceState());
        bundle.putFloat(STATUS_ALPHA, mAlpha);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle) state;
            mAlpha = bundle.getFloat(STATUS_ALPHA);
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATUS));
            return;
        }
        super.onRestoreInstanceState(state);
    }

    public void setIconAlpha(float alpha) {
        this.mAlpha = alpha;
        invalidateView();
    }

    /**
     * 重绘
     */
    private void invalidateView() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            invalidate();
        } else {
            postInvalidate();
        }
    }
}
