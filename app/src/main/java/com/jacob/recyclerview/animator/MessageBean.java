package com.jacob.recyclerview.animator;

/**
 * Created by jacob-wj on 2015/4/13.
 */
public class MessageBean {
    private int drawable;
    private String message;

    public MessageBean(int drawable, String message) {
        this.drawable = drawable;
        this.message = message;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
