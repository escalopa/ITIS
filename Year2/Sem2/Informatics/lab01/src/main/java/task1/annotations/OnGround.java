package task1.annotations;

public @interface OnGround {

    String motion() default "This vehicle moves on the ground";
}
