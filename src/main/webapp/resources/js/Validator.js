PrimeFaces.locales['en_US'].messages['cpf_invalido'] = '{0}: \'{1}\' não pode ser entendido como um cpf válido.';
  PrimeFaces.validator['CPF'] = {
      MESSAGE_ID: 'cpf_invalido',
      validate: function (element, value) {
          if (value !== null && value !== "") {
              var vc = PrimeFaces.util.ValidationContext;
              if (!validarCPF(value)) {
                  var label = element.data('p-label');
                  var msgStr = element.data('p-cpf-msg'),
                          msg = msgStr ? {summary: msgStr, detail: msgStr} : vc.getMessage(this.MESSAGE_ID, label, value);
                  throw msg;
              }
          }
      }
  };
  function validarCPF(cpf) {
      var div1, div2;
      cpf = cpf.replace(/[^\d]+/g, '');
      // Verifica tamanho e se é um cpf padrão    
      if (cpf.length !== 11 || isCPFPadrao(cpf))
          return false;
      div1 = calcDVs(cpf.substring(0, 9));
      div2 = calcDVs(cpf.substring(0, 9) + div1);
      return (cpf == (cpf.substring(0, 9) + div1 + div2));
  }
  ;
   
  function isCPFPadrao(cpf) {
      if (cpf == "00000000000"
              || cpf == "11111111111"
              || cpf == "22222222222"
              || cpf == "33333333333"
              || cpf == "44444444444"
              || cpf == "55555555555"
              || cpf == "66666666666"
              || cpf == "77777777777"
              || cpf == "88888888888"
              || cpf == "99999999999")
          return true;
      else
          return false;
  }
  ;
   
  function calcDVs(cpf) {
      var soma, digito, resto;
      var peso = [11, 10, 9, 8, 7, 6, 5, 4, 3, 2];
      soma = 0;
      for (indice = cpf.length - 1; indice >= 0; indice--) {
          digito = parseInt(cpf.substring(indice, indice + 1));
          soma += digito * peso[peso.length - cpf.length + indice];
      }
      resto = (soma * 10) % 11;
      return (resto == 10 || resto == 11) ? 0 : resto;
  }
  ;