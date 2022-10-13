const nameRest = document.getElementById("name_rest");
if (nameRest != null) {
  const idRest = sessionStorage.getItem("id");
  const restaurantsString = localStorage.getItem("db1");
  if (restaurantsString != null) {
    const restaurantsObj = JSON.parse(restaurantsString);
    const restaurant = restaurantsObj.restaurant.find(
      (item) => item.id === idRest
    );
    if (restaurant != null) {
      nameRest.innerText = restaurant.name;
      console.log(restaurant);
    }
  }
}

// Adiciona produtos iniciais
let produtos_inicial = {
  data: [
    {
      id: 1,
      nome: "Pão de Queijo",
      id_rest: 1,
      preco: 2.59,
      descricao: "Pão de Queijo comum, 100g",
      urlFoto:
        "https://images.unsplash.com/photo-1598142982901-df6cec10ae35?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8cCVDMyVBM28lMjBkZSUyMHF1ZWlqb3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
    },
    {
      id: 2,
      nome: "Coxinha",
      id_rest: 2,
      preco: 4.59,
      descricao: "Coxinha de frango, 100g",
      urlFoto:
        "https://media.istockphoto.com/photos/drumsticks-picture-id926773634?s=612x612",
    },
    {
      id: 3,
      nome: "Pastel Assado",
      id_rest: 1,
      preco: 4.69,
      descricao: "Pastel assado de carne, 100g",
      urlFoto:
        "https://images.pexels.com/photos/12267750/pexels-photo-12267750.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
    },
    {
      id: 4,
      nome: "Cachorro Quente",
      id_rest: 1,
      preco: 8.99,
      descricao: "Cachorro quente completo. Gratis um copo de refrigerante.",
      urlFoto:
        "https://images.unsplash.com/photo-1599599810694-b5b37304c041?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=627&q=80",
    },
    {
      id: 5,
      nome: "Misto Quente",
      id_rest: 3,
      preco: 5.59,
      descricao: "Misto Quente de queijo com presunto",
      urlFoto:
        "https://images.unsplash.com/photo-1581574303858-f00f95088f7b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1170&q=80",
    },
    {
      id: 6,
      nome: "Macarrão a bolonhesa",
      id_rest: 2,
      preco: 10.99,
      descricao: "Macarrão com molho de carne.",
      urlFoto:
        "https://images.unsplash.com/photo-1621996346565-e3dbc646d9a9?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=880&q=80",
    },
    {
      id: 7,
      nome: "Tortinha de frango",
      id_rest: 2,
      preco: 5.99,
      descricao: "Tortinha de frango com catupiry",
      urlFoto:
        "https://images.unsplash.com/photo-1612477491914-a2f46ef8586e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1191&q=80",
    },
    {
      id: 8,
      nome: "Prato do dia",
      id_rest: 3,
      preco: 17.99,
      descricao: "DE segunda a sexta. Cada dia um prato diferente.",
      urlFoto:
        "https://images.unsplash.com/photo-1585975754487-25489eabf36a?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=687&q=80",
    },
  ],
};

// Tenta resgatar dados do localStorage. Se nao houver nenhum, aparece somente os dados iniciais
var pi = JSON.parse(localStorage.getItem("pi_produto"));
if (!pi) {
  pi = produtos_inicial;
}
function saveData_3(data) {
  localStorage.setItem("pi_produto", JSON.stringify(data));
}

saveData_3(pi);

function deleteProduto(id) {
  // Filtra o array removendo o elemento com o id passado
  pi.data = pi.data.filter(function (element) {
    return element.id != id;
  });

  // Atualiza os dados no Local Storage
  localStorage.setItem("pi_produto", JSON.stringify(pi));
}

function exibeProdutos() {
  // Remove todas as linhas do corpo da tabela
  let id = sessionStorage.getItem("id");
  $("#table_produtos").html("");

  // Popula a tabela com os registros do banco de dados
  for (let i = 0; i < pi.data.length; i++) {
    let produto = pi.data[i];
    if (produto.id_rest == id) {
      $("#table_produtos").append(`<tr><td scope="row">${produto.id}</td>
                                        <td>${produto.nome}</td>
                                        <td>R$${produto.preco}</td>
                                    </tr>`);
    }
  }
}

// Exibe mensagem em um elemento de ID msg
function displayMessage(msg) {
  $("#msg").html('<div class="alert alert-warning">' + msg + "</div>");
}

console.log(`TESTE`);

function insertProduto(produto) {
  // Calcula novo Id a partir do último código existente no array (PODE GERAR ERRO SE A BASE ESTIVER VAZIA)
  let novoId = 1;
  console.log(pi.data.length);
  if (pi.data.length != 0) {
    novoId = pi.data[pi.data.length - 1].id + 1;
  }
  const id_rest = sessionStorage.getItem("id");
  let novoproduto = {
    id: novoId,
    nome: produto.nome,
    preco: produto.preco,
    descricao: produto.descricao,
    urlFoto: produto.urlFoto,
    id_rest,
  };

  // Insere o novo objeto no array
  pi.data.push(novoproduto);
  displayMessage("Produto inserido com sucesso");

  // Atualiza os dados no Local Storage
  localStorage.setItem("pi_produto", JSON.stringify(pi));
}

function mostraImagem(id) {
  if (pi.data[id].urlFoto != "") {
    // coloca a imagem
    let produto = pi.data[i];
    $("#infoProduto")
      .append(`<div id="formImagem" class="col-12 d-flex justify-content-center">
        <img src="${pi.data[id].urlFoto}" 
        style="
        height: 240px;
        border: solid 3px #000c76;
        padding: 7px;
        border-radius: 2px;"/>
        </div>`);
  }
}

var id_selecionado = -1;
console.log(id_selecionado);

// body cadastroproduto.html onload
function init() {
  // TESTES -----------------------------------------------------------

  //-------------------------------------------------------------------

  // Exibe os produtos
  exibeProdutos();

  //intercepta o click em alguma linha da tabela e seleciona seu id
  $("#grid_produtos").on("click", "tr", function (e) {
    var linhaProduto = this;
    let colunas = linhaProduto.querySelectorAll("td");
    id_selecionado = colunas[0].innerText;
    console.log(`id ${id_selecionado}`);

    // testes
    let url = `produtodetalhe.html?id=${id_selecionado}`;
    console.log(url);
  });

  // intercepta o click no adicionar
  $("#btnAdicionar").click(function () {
    // var url = new URL("produtodetalhe.html");
    //url.searchParams.append("id", -1);

    /* ME */

    let url = `produtodetalhe.html?id=-1`;
    // console.log(url.toString(url));

    // Adiciona Produto

    window.location.href = url.toString();

    // location.href = url;
    // window.location.href = 'produtodetalhe.html'
  });

  // intercepta o click no botao excluir
  $("#btnExcluir").click(function () {
    console.log(`botao ${id_selecionado}`);
    let campoId = id_selecionado;
    if (campoId == -1) {
      window.alert("Selecione um produto a ser excluído.");
      return;
    } else {
      deleteProduto(parseInt(campoId));
      window.alert("Produto removido com sucesso");
      id_selecionado = -1;
    }

    // Reexibe os produtos
    exibeProdutos();
  });

  // intercepta o click no botao editar/visualizar
  $("#btnEditar").click(function () {
    console.log(`botao ${id_selecionado}`);
    let campoId = id_selecionado;
    if (campoId == -1) {
      window.alert("Selecione um produto para visualizar/editar.");
      return;
    }

    let url = `produtodetalhe.html?id=${id_selecionado}`;
    console.log(url);

    location.href = url;
  });
}

// body produtodetalhe.html onload
function cadastrarProduto() {
  const queryString = window.location.search;
  console.log("query: ", queryString); // ?id=x
  const urlParams = new URLSearchParams(queryString);
  const id_produto = urlParams.get("id");
  console.log(id_produto);

  let id_editar = -1;

  if (id_produto == -1) {
    // ADICIONAR PRODUTO
    $("#btnInsert").click(function () {
      // Obtem os valores dos campo do formulario
      let campoNome = $("#ProductName").val();
      let campoPreco = $("#ProductPrice").val();
      let campoDescricao = $("#ProductDescription").val();
      let campoImagem = $("#ProductImage").val();
      let produto = {
        nome: campoNome,
        preco: campoPreco,
        descricao: campoDescricao,
        urlFoto: campoImagem,
      };
      if (campoNome == "" || campoPreco == "") {
        window.alert("Preencha os campos obrigatórios (*).");
      } else {
        window.alert("Produto adicionado com sucesso!");
        insertProduto(produto);

        // Limpa o formulario
        $("#form_produto")[0].reset();
      }
    });
  } else if (id_produto > 0) {
    console.log(pi);

    for (i = 0; i < pi.data.length; i++) {
      if (pi.data[i].id == id_produto) {
        id_editar = i;
      }
    }

    console.log(id_editar);

    $("#ProductName").val(pi.data[id_editar].nome);
    $("#ProductPrice").val(pi.data[id_editar].preco);
    $("#ProductDescription").val(pi.data[id_editar].descricao);
    $("#ProductImage").val(pi.data[id_editar].urlFoto);
    mostraImagem(id_editar);
    //console.log(pi_produto);

    // editProduto
    $("#btnInsert").click(function () {
      console.log("chegou aqui");
      // Obtem os valores dos campo do formulario
      let campoNome = $("#ProductName").val();
      let campoPreco = $("#ProductPrice").val();
      let campoDescricao = $("#ProductDescription").val();
      let campoImagem = $("#ProductImage").val();
      let produto = {
        nome: campoNome,
        preco: campoPreco,
        descricao: campoDescricao,
        urlFoto: campoImagem,
      };
      if (campoNome == "" || campoPreco == "") {
        window.alert("Preencha os campos obrigatórios (*).");
      } else {
        // Localiza o indice do objeto a ser alterado no array a partir do seu ID
        //let index = pi.data.map(obj => obj.id_editar).indexOf(id_editar);

        // Altera os dados do objeto no array
        (pi.data[id_editar].nome = produto.nome),
          (pi.data[id_editar].preco = produto.preco),
          (pi.data[id_editar].descricao = produto.descricao),
          (pi.data[id_editar].urlFoto = produto.urlFoto),
          window.alert("Produto editado com sucesso!");

        const element = document.getElementById("formImagem");
        element.remove();
        mostraImagem(id_editar);
        // Atualiza os dados no Local Storage
        localStorage.setItem("pi_produto", JSON.stringify(pi));
      }
    });
  }
}
