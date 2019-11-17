function consultar() {
  $.ajax({
    url: "http://api.algafood.local:8080/formas-pagamento",
    type: "get",

    success: function(response) {
      preencherTabela(response);
    }
  });
}

function preencherTabela(formasPagamento) {
  $("#tabela tbody tr").remove();

  $.each(formasPagamento, function(i, formaPagamento) {
    var linha = $("<tr>");

    linha.append(
      $("<td>").text(formaPagamento.id),
      $("<td>").text(formaPagamento.descricao)
    );

    linha.appendTo("#tabela");
  });
}


$("#btn-consultar").click(consultar);