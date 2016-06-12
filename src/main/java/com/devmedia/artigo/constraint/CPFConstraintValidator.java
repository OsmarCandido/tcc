 package com.devmedia.artigo.constraint;
   
  import com.devmedia.artigo.validator.CPF;
  import javax.validation.ConstraintValidator;
  import javax.validation.ConstraintValidatorContext;
   

  public class CPFConstraintValidator implements ConstraintValidator<CPF, String> {
   
      private CPF icpf;
   
      /**
       *
       * @param icpf @CPF 
       */
      @Override
      public void initialize(CPF icpf) {
          this.icpf = icpf;
      }
      /**
       *
       * @param cpf valor do cpf a ser verificado.
       * @param cvc utilizado para construir template com mensagem do erro.
       * @return se o CPF é válido ou não.
       */
      @Override
      public boolean isValid(String cpf, ConstraintValidatorContext cvc) {
   
          if (cpf == null || cpf.equals("")) {
              return true;
          }
          cvc.buildConstraintViolationWithTemplate(icpf.message()).addConstraintViolation()
                  .disableDefaultConstraintViolation();
          cpf = cpf.replaceAll("[^0123456789]", "");
          if (isCPFPadrao(cpf) || cpf.length() != 11) {
              return false;
          }
          int dv1 = calcDVs(cpf.substring(0, 9), PESO_CPF);
          int dv2 = calcDVs(cpf.substring(0, 9) + dv1, PESO_CPF);
          return cpf.equals(cpf.substring(0, 9) + dv1 + dv2);
      }
   
      private static final int[] PESO_CPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
   
      private static boolean isCPFPadrao(String cpf) {
          return cpf.equals("00000000000")
                  || cpf.equals("11111111111") 
                  || cpf.equals("22222222222")
                  || cpf.equals("33333333333")
                  || cpf.equals("44444444444")
                  || cpf.equals("55555555555")
                  || cpf.equals("66666666666")
                  || cpf.equals("77777777777")
                  || cpf.equals("88888888888")
                  || cpf.equals("99999999999");
      }
   
      private static int calcDVs(String cpf, int[] peso) {
          int soma = 0;
          for (int indice = cpf.length() - 1, digito; indice >= 0; indice--) {
              digito = Integer.parseInt(cpf.substring(indice, indice + 1));
              soma += digito * peso[peso.length - cpf.length() + indice];
          }
          int resto = (soma * 10) % 11;
          return (resto == 10 || resto == 11) ? 0 : resto;
      }
  }