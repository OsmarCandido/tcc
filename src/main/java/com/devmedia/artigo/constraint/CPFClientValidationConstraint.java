 package com.devmedia.artigo.constraint;
   
  import com.devmedia.artigo.validator.CPF;
  import java.util.HashMap;
  import java.util.Map;
  import javax.validation.metadata.ConstraintDescriptor;
  import org.primefaces.validate.bean.ClientValidationConstraint;
   
  public class CPFClientValidationConstraint implements ClientValidationConstraint {
   
      private static final String MESSAGE_ID = "{cpf_invalido}";
   
      /**
       *
       * @param constraintDescriptor Descriptor de @interface CPF.
       * @return Map de metadados a serem utilizados na validação do cliente.
       */
      @Override
      public Map<String, Object> getMetadata(ConstraintDescriptor constraintDescriptor) {
          Map<String, Object> metadata = new HashMap<String, Object>();
          Map attrs = constraintDescriptor.getAttributes();
          String message = (String) attrs.get("message");
          if (!message.equals(MESSAGE_ID)) {
              metadata.put("data-p-cpf-msg", message);
          }
          return metadata;
      }
   
      /**
       *
       * @return retorna o ID do Validador
       */
      @Override
      public String getValidatorId() {
          return CPF.class.getSimpleName();
      }
   
  }