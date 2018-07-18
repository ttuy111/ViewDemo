package me.kule.viewdemo.breakText;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.WindowDecorActionBar;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import me.kule.viewdemo.R;
import me.kule.viewdemo.Utils;

/**
 * Created by KuLe on 2018/7/17.
 * Email: 783051@qq.com
 */

public class BreakTextView extends View {


    private static final float PADDING = Utils.dp2Px(3);
    private static final float TEXT_SIZE = Utils.dp2Px(16);
    private static final int IMAGE_WIDTH = (int) Utils.dp2Px(150);
    private static final int IMAGE_Y_OFFSET = (int) Utils.dp2Px(80);
    private static final int IMAGE_LEFT_PADDING = (int) Utils.dp2Px(1);
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    TextPaint textPaint = new TextPaint(paint);
    StaticLayout staticLayout;
    String text = "My father was a self-taught mandolin player. He was one of the best string instrument players in our town. He could not read music, but if he heard a tune a few times, he could play it. When he was younger, he was a member of a small country music band. They would play at local dances and on a few occasions would play for the local radio station. He often told us how he had auditioned and earned a position in a band that featured Patsy Cline as their lead singer. He told the family that after he was hired he never went back. Dad was a very religious man. He stated that there was a lot of drinking and cursing the day of his audition and he did not want to be around that type of environment.";

    float[] measuredTextWidth = new float[1];
    Paint.FontMetrics fontMetrics = new Paint.FontMetrics();

    public BreakTextView(Context context) {
        super(context);
    }

    public BreakTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BreakTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    {
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.getFontMetrics(fontMetrics);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        /**
         *
         * 第一次
         *
         * */
//        staticLayout.draw(canvas);
//        float y = -fontMetrics.top;
//        int totleWidth;
//        if ((y + fontMetrics.top > IMAGE_Y_OFFSET && y + fontMetrics.top < IMAGE_Y_OFFSET + IMAGE_WIDTH
//        )|| (y + fontMetrics.bottom > IMAGE_Y_OFFSET && y + fontMetrics.bottom < IMAGE_Y_OFFSET + IMAGE_WIDTH)) {
//            totleWidth = getWidth() - IMAGE_WIDTH-IMAGE_LEFT_PADDING;
//        } else {
//            totleWidth = getWidth();
//        }
//        int count = textPaint.breakText(text, 0, text.length(), true, totleWidth, measuredTextWidth);
//        String substring = text.substring(0, count);
//        int i = substring.lastIndexOf(" ");
//        String c = text.charAt(count + 1)+"";
//        if (i<count||c.equals(" ")){
//            count = i;
//        }
//        int start = 0;
//        while (count > 0) {
////            staticLayout = new StaticLayout(text, textPaint, totleWidth, Layout.Alignment.ALIGN_NORMAL, 1, 0, false);
////            canvas.translate(0,y);
////            staticLayout.draw(canvas);
//            canvas.drawText(text, start, start + count, 0, y, textPaint);
//            start += count;
//            y += textPaint.getFontSpacing();
//            if ((y + fontMetrics.top > IMAGE_Y_OFFSET && y + fontMetrics.top < IMAGE_Y_OFFSET + IMAGE_WIDTH
//            )|| (y + fontMetrics.bottom > IMAGE_Y_OFFSET && y + fontMetrics.bottom < IMAGE_Y_OFFSET + IMAGE_WIDTH)) {
//                totleWidth = getWidth() - IMAGE_WIDTH-IMAGE_LEFT_PADDING;
//            } else {
//                totleWidth = getWidth();
//            }
//            count = textPaint.breakText(text, start, text.length(), true, totleWidth, measuredTextWidth);
//            String substring2 = text.substring(start, start + count);
//            int i2 = substring2.lastIndexOf(" ");
//            String c2 = text.charAt(count + 1)+"";
//            if (i2<count||c2.equals(" ")){
//                count = i2;
//            }
//        }
//        canvas.drawBitmap(getAvatar(IMAGE_WIDTH), getWidth() - IMAGE_WIDTH, IMAGE_Y_OFFSET, paint);


        /**
         *
         * 第二次
         *
         * */

        float y = -fontMetrics.top+PADDING;
        int totleWidth;
        int start = 0;
        int count = 0;
        do {
            if ((y + fontMetrics.top > IMAGE_Y_OFFSET && y + fontMetrics.top < IMAGE_Y_OFFSET + IMAGE_WIDTH
            ) || (y + fontMetrics.bottom > IMAGE_Y_OFFSET && y + fontMetrics.bottom < IMAGE_Y_OFFSET + IMAGE_WIDTH)) {
                totleWidth = getWidth() - IMAGE_WIDTH - IMAGE_LEFT_PADDING-2*(int) PADDING;
            } else {
                totleWidth = getWidth()-2*(int) PADDING;
            }
            count = textPaint.breakText(text, start, text.length(), true, totleWidth, measuredTextWidth);
            String substring2 = text.substring(start, start + count);
            int i2 = substring2.lastIndexOf(" ");
            String c2 = text.charAt(count + 1) + "";
            if (i2 < count || c2.equals(" ")) {
                count = i2+1;
            }
            canvas.drawText(text, start, start + count, PADDING, y, textPaint);
            start += count;
            y += textPaint.getFontSpacing();
        } while (count > 0);
        canvas.drawBitmap(getAvatar(IMAGE_WIDTH), getWidth() - IMAGE_WIDTH-PADDING, IMAGE_Y_OFFSET, paint);
    }

    Bitmap getAvatar(int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.ic_img, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(getResources(), R.drawable.ic_img, options);
    }
}
