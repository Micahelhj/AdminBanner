package com.admin.banner.anim;

import com.nineoldandroids.animation.Animator;

public abstract class BaseAnimator {
    protected long duration;
    protected com.nineoldandroids.animation.AnimatorSet animatorSet;
    private android.view.animation.Interpolator interpolator;
    private long delay;
    private AnimatorListener listener;

    public BaseAnimator() {
        this.duration = 500L;
        this.animatorSet = new com.nineoldandroids.animation.AnimatorSet();
    }


    public abstract void setAnimation(android.view.View paramView);

    protected void start(android.view.View view) {
        reset(view);
        setAnimation(view);

        this.animatorSet.setDuration(this.duration);
        if (this.interpolator != null) {
            this.animatorSet.setInterpolator(this.interpolator);
        }

        if (this.delay > 0L) {
            this.animatorSet.setStartDelay(this.delay);
        }

        if (this.listener != null) {
            this.animatorSet.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {
                public void onAnimationStart(Animator animator) {
                    BaseAnimator.this.listener.onAnimationStart(animator);
                }

                public void onAnimationRepeat(Animator animator) {
                    BaseAnimator.this.listener.onAnimationRepeat(animator);
                }

                public void onAnimationEnd(Animator animator) {
                    BaseAnimator.this.listener.onAnimationEnd(animator);
                }

                public void onAnimationCancel(Animator animator) {
                    BaseAnimator.this.listener.onAnimationCancel(animator);
                }
            });
        }

        this.animatorSet.start();
    }

    public static void reset(android.view.View view) {
        com.nineoldandroids.view.ViewHelper.setAlpha(view, 1.0F);
        com.nineoldandroids.view.ViewHelper.setScaleX(view, 1.0F);
        com.nineoldandroids.view.ViewHelper.setScaleY(view, 1.0F);
        com.nineoldandroids.view.ViewHelper.setTranslationX(view, 0.0F);
        com.nineoldandroids.view.ViewHelper.setTranslationY(view, 0.0F);
        com.nineoldandroids.view.ViewHelper.setRotation(view, 0.0F);
        com.nineoldandroids.view.ViewHelper.setRotationY(view, 0.0F);
        com.nineoldandroids.view.ViewHelper.setRotationX(view, 0.0F);
    }

    public BaseAnimator duration(long duration) {
        this.duration = duration;
        return this;
    }

    public BaseAnimator delay(long delay) {
        this.delay = delay;
        return this;
    }

    public BaseAnimator interpolator(android.view.animation.Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    public BaseAnimator listener(AnimatorListener listener) {
        this.listener = listener;
        return this;
    }

    public void playOn(android.view.View view) {
        start(view);
    }

    public static abstract interface AnimatorListener {
        public abstract void onAnimationStart(Animator paramAnimator);

        public abstract void onAnimationRepeat(Animator paramAnimator);

        public abstract void onAnimationEnd(Animator paramAnimator);

        public abstract void onAnimationCancel(Animator paramAnimator);
    }
}
