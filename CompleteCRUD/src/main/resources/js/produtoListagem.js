async function init() {
  const urlParams = new URLSearchParams(window.location.search);
  const restId = urlParams.get("restid");
  const produtos = await fetch(`/produtos/${restId}`).then((r) => r.json());
  let html = "";
  for (let i = 0; i < produtos.length; i++) {
    const produto = produtos[i];

    const template = `<tr>
    <th scope="row">${i + 1}</th>
    <td>${produto.name}</td>
    <td>R$${produto.price}</td>
    <td>
      <a href="#" title="Editar">
        <i
          class="bi bi-pencil m-1"
          style="font-size: 1rem; color: #000c76"
        ></i
      ></a>
      <!-- <a href="#" title="Ver" id="ver-produto">
        <i
          class="bi bi-search m-1"
          style="font-size: 1rem; color: #000c76"
        ></i
      ></a> -->
      <a href="#" title="Deletar" id="delete-produto" onclick="event.preventDefault(), deletar(${
        produto.id
      })">
        <i
          class="bi bi-x-circle m-1"
          style="font-size: 1rem; color: #000c76"
        ></i
      ></a>
    </td>
    </tr>`;

    html += template;
  }
  const tabela = document.getElementById("table_produtos");
  if (tabela) {
    tabela.innerHTML = html;
  }
}

async function deletar(id) {
  await fetch(`/produto/delete/${id}`);
  init();
}

init();
