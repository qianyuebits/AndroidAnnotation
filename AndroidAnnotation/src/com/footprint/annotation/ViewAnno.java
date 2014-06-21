package com.footprint.annotation;

import java.lang.annotation.*;


/**
 * provide annotation for view field
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewAnno {
	/** the id for view */
	public int id() default -1;
	public String click() default "";
}
