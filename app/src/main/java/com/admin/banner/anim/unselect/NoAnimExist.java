package com.admin.banner.anim.unselect;

import android.view.View;

import com.admin.banner.anim.BaseAnimator;
import com.nineoldandroids.animation.ObjectAnimator;

public class NoAnimExist extends BaseAnimator {
    public NoAnimExist() {
        this.duration = 200;
    }

    public void setAnimation(View view) {
        this.animatorSet.playTogether(new com.nineoldandroids.animation.Animator[]{
                ObjectAnimator.ofFloat(view, "alpha", 1, 1)});
    }
}
