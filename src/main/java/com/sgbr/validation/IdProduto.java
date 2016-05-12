package com.sgbr.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.persistence.PostLoad;
import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.constraints.Pattern;

@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "d{1,4}")
public @interface IdProduto {

	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "{com.sgbr.constraints.IdProduto.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends PostLoad>[] payload() default {};
	
}