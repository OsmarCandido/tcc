 package com.devmedia.artigo.validator;
   
  import com.devmedia.artigo.constraint.CPFClientValidationConstraint;
  import com.devmedia.artigo.constraint.CPFConstraintValidator;
  import java.lang.annotation.Documented;
  import java.lang.annotation.ElementType;
  import java.lang.annotation.Retention;
  import static java.lang.annotation.RetentionPolicy.RUNTIME;
  import java.lang.annotation.Target;
  import javax.validation.Constraint;
  import javax.validation.Payload;
  import org.primefaces.validate.bean.ClientConstraint;
   

  @Documented
  @Target({ElementType.METHOD, ElementType.FIELD})
  @Retention(RUNTIME)
  @Constraint(validatedBy = CPFConstraintValidator.class)
  @ClientConstraint(resolvedBy = CPFClientValidationConstraint.class)
  public @interface CPF {
   
      String message() default "{cpf_invalido}";
   
      Class<?>[] groups() default {};
   
      Class<? extends Payload>[] payload() default {};
   
  }