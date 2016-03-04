/*    */ package com.admin.banner.anim;
/*    */ 
/*    */ import com.nineoldandroids.animation.Animator;
/*    */ 
/*    */ public abstract class BaseAnimator { protected long duration;
/*    */   protected com.nineoldandroids.animation.AnimatorSet animatorSet;
/*    */   private android.view.animation.Interpolator interpolator;
/*    */   private long delay;
/*    */   private AnimatorListener listener;
/*    */   
/* 11 */   public BaseAnimator() { this.duration = 500L;
/* 12 */     this.animatorSet = new com.nineoldandroids.animation.AnimatorSet();
/*    */   }
/*    */   
/*    */ 
/*    */   public abstract void setAnimation(android.view.View paramView);
/*    */   
/*    */   protected void start(android.view.View view)
/*    */   {
/* 20 */     reset(view);
/* 21 */     setAnimation(view);
/*    */     
/* 23 */     this.animatorSet.setDuration(this.duration);
/* 24 */     if (this.interpolator != null) {
/* 25 */       this.animatorSet.setInterpolator(this.interpolator);
/*    */     }
/*    */     
/* 28 */     if (this.delay > 0L) {
/* 29 */       this.animatorSet.setStartDelay(this.delay);
/*    */     }
/*    */     
/* 32 */     if (this.listener != null) {
/* 33 */       this.animatorSet.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener()
/*    */       {
/*    */         public void onAnimationStart(Animator animator) {
/* 36 */           BaseAnimator.this.listener.onAnimationStart(animator);
/*    */         }
/*    */         
/*    */         public void onAnimationRepeat(Animator animator)
/*    */         {
/* 41 */           BaseAnimator.this.listener.onAnimationRepeat(animator);
/*    */         }
/*    */         
/*    */         public void onAnimationEnd(Animator animator)
/*    */         {
/* 46 */           BaseAnimator.this.listener.onAnimationEnd(animator);
/*    */         }
/*    */         
/*    */         public void onAnimationCancel(Animator animator)
/*    */         {
/* 51 */           BaseAnimator.this.listener.onAnimationCancel(animator);
/*    */         }
/*    */       });
/*    */     }
/*    */     
/* 56 */     this.animatorSet.start();
/*    */   }
/*    */   
/*    */   public static void reset(android.view.View view) {
/* 60 */     com.nineoldandroids.view.ViewHelper.setAlpha(view, 1.0F);
/* 61 */     com.nineoldandroids.view.ViewHelper.setScaleX(view, 1.0F);
/* 62 */     com.nineoldandroids.view.ViewHelper.setScaleY(view, 1.0F);
/* 63 */     com.nineoldandroids.view.ViewHelper.setTranslationX(view, 0.0F);
/* 64 */     com.nineoldandroids.view.ViewHelper.setTranslationY(view, 0.0F);
/* 65 */     com.nineoldandroids.view.ViewHelper.setRotation(view, 0.0F);
/* 66 */     com.nineoldandroids.view.ViewHelper.setRotationY(view, 0.0F);
/* 67 */     com.nineoldandroids.view.ViewHelper.setRotationX(view, 0.0F);
/*    */   }
/*    */   
/*    */   public BaseAnimator duration(long duration) {
/* 71 */     this.duration = duration;
/* 72 */     return this;
/*    */   }
/*    */   
/*    */   public BaseAnimator delay(long delay) {
/* 76 */     this.delay = delay;
/* 77 */     return this;
/*    */   }
/*    */   
/*    */   public BaseAnimator interpolator(android.view.animation.Interpolator interpolator) {
/* 81 */     this.interpolator = interpolator;
/* 82 */     return this;
/*    */   }
/*    */   
/*    */   public BaseAnimator listener(AnimatorListener listener) {
/* 86 */     this.listener = listener;
/* 87 */     return this;
/*    */   }
/*    */   
/*    */   public void playOn(android.view.View view) {
/* 91 */     start(view);
/*    */   }
/*    */   
/*    */   public static abstract interface AnimatorListener
/*    */   {
/*    */     public abstract void onAnimationStart(Animator paramAnimator);
/*    */     
/*    */     public abstract void onAnimationRepeat(Animator paramAnimator);
/*    */     
/*    */     public abstract void onAnimationEnd(Animator paramAnimator);
/*    */     
/*    */     public abstract void onAnimationCancel(Animator paramAnimator);
/*    */   }
/*    */ }


/* Location:              C:\Users\Michael\Desktop\classes.jar!\com\flyco\banner\anim\BaseAnimator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */