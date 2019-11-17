function consultar() {
  $.ajax({
    url: "http://api.algafood.local:8080/formas-pagamento",
    type: "get",

    success: function(response) {
      preencherTabela(response);
    }
  });
}

function cadastrar() {
  var formaPagamentoJson = JSON.stringify({
    "descricao": $("#campo-descricao").val()
  });

  console.log(formaPagamentoJson);

  $.ajax({
    url: "http://api.algafood.local:8080/formas-pagamento",
    type: "post",
    data: formaPagamentoJson,
    contentType: "application/json",

    success: function(response) {
      alert("Forma de pagamento adicionada!");
      consultar();
    },

    error: function(error) {
      if (error.status >= 400 && error.status <= 499) {
        var problem = JSON.parse(error.responseText);
        alert(problem.userMessage);
      } else {
        alert("Erro ao cadastrar forma de pagamento!");
      }
    }
  });
}

function excluir(formaPagamento) {
  var url = "http://api.algafood.local:8080/formas-pagamento/" + formaPagamento.id;

  $.ajax({
    url: url,
    type: "delete",

    success: function(response) {
      consultar();

      alert("Forma de pagamento removida!");
    },

    error: function(error) {
      // tratando todos os erros da categoria 4xx
      if (error.status >= 400 && error.status <= 499) {
        var problem = JSON.parse(error.responseText);
        alert(problem.userMessage);
      } else {
        alert("Erro ao remover forma de pagamento!");
      }
    }
  });
}

function preencherTabela(formasPagamento) {
  $("#tabela tbody tr").remove();

  $.each(formasPagamento, function(i, formaPagamento) {
    var linha = $("<tr>");

    var linkAcao = $("<a href='#'>")
      .text("Excluir")
      .click(function(event) {
        event.preventDefault();
        excluir(formaPagamento);
      });

    linha.append(
      $("<td>").text(formaPagamento.id),
      $("<td>").text(formaPagamento.descricao),
      $("<td>").append(linkAcao)
    );

    linha.appendTo("#tabela");
  });
}


$("#btn-consultar").click(consultar);
$("#btn-cadastrar").click(cadastrar);