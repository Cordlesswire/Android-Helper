package com.amqtech.androidhelper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by andrew on 5/3/16.
 */
public class AndroidHelper {

    public static void shortToast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public static void longToast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }

        // We ask for the bounds if they have been set as they would be most
        // correct, then we check we are  > 0
        final int width = !drawable.getBounds().isEmpty() ?
                drawable.getBounds().width() : drawable.getIntrinsicWidth();

        final int height = !drawable.getBounds().isEmpty() ?
                drawable.getBounds().height() : drawable.getIntrinsicHeight();

        // Now we check we are > 0
        final Bitmap bitmap = Bitmap.createBitmap(width <= 0 ? 1 : width, height <= 0 ? 1 : height,
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }

    public static int darkenColor(int color, float factor) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= factor;
        return Color.HSVToColor(hsv);
    }

    public static int lightenColor(int color, float factor) {
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        hsv[2] *= -factor;
        return Color.HSVToColor(hsv);
    }

    public static void drawToolbar(AppCompatActivity activity, Toolbar toolbar, String title){
        toolbar.setTitle(title);
        activity.setSupportActionBar(toolbar);
    }

    public static void restart(Activity activity) {
        try {
            Intent i = activity.getPackageManager().getLaunchIntentForPackage(activity.getPackageName());
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            int mPendingIntentId = 223344;
            PendingIntent mPendingIntent = PendingIntent.getActivity(activity, mPendingIntentId, i, PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager mgr = (AlarmManager) activity.getSystemService(Context.ALARM_SERVICE);
            mgr.set(AlarmManager.RTC, System.currentTimeMillis() + 100, mPendingIntent);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            activity.finish();
        }
    }

    public static void fadeImage(final Activity activity, final ImageView imageView, final Bitmap image) {
        Animation exitAnim = AnimationUtils.loadAnimation(activity, android.R.anim.fade_out);
        exitAnim.setDuration(150);
        exitAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override public void onAnimationStart(Animation animation) {

            }

            @Override public void onAnimationRepeat(Animation animation) {

            }

            @Override public void onAnimationEnd(Animation animation) {
                imageView.setImageBitmap(image);
                Animation enterAnim = AnimationUtils.loadAnimation(activity, android.R.anim.fade_in);
                enterAnim.setDuration(150);
                imageView.startAnimation(enterAnim);
            }
        });
        imageView.startAnimation(exitAnim);
    }

    public static void slideImage(final Activity activity, final ImageView imageView, final Bitmap image) {
        Animation exitAnim = AnimationUtils.loadAnimation(activity, android.R.anim.slide_out_right);
        exitAnim.setDuration(150);
        exitAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override public void onAnimationStart(Animation animation) {
            }

            @Override public void onAnimationRepeat(Animation animation) {
            }

            @Override public void onAnimationEnd(Animation animation) {
                imageView.setImageBitmap(image);
                Animation enterAnim = AnimationUtils.loadAnimation(activity, android.R.anim.slide_in_left);
                enterAnim.setDuration(150);
                imageView.startAnimation(enterAnim);
            }
        });
        imageView.startAnimation(exitAnim);
    }

    @TargetApi(21)
    public static void circularRevealEnter(View view) {
        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;

        float finalRadius = (float) Math.hypot(cx, cy);

        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);

        view.setVisibility(View.VISIBLE);
        anim.start();
    }

    @TargetApi(21)
    public static void circularRevealExit(final View view) {
        int cx = view.getWidth() / 2;
        int cy = view.getHeight() / 2;

        float initialRadius = (float) Math.hypot(cx, cy);

        Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.INVISIBLE);
            }
        });

        anim.start();
    }
