package clanner.app.V.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import clanner.app.V.R;

/**
 * Created by Clanner on 2016/6/29.
 * 底部自定义View
 */
public class BottomView extends View {

    //底部icon
    private Bitmap bottomIcon;
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
        textPaint.setColor(0Xff555555);
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
        /**
         * 有空再来
         */
    }
}
