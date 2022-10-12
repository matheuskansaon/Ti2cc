const form = document.getElementById("search-form");
if (form != null) {
  form.addEventListener("submit", searchProduct);
}
const searchButton = document.getElementById("btn-search");

function searchProduct(event) {
  event.preventDefault();
  const searchItem = document.getElementById("search-input");
  if (searchItem != null) {
    const productsString = localStorage.getItem("pi_produto");
    if (productsString != null) {
      const productsObj = JSON.parse(productsString);
      const productsSearch = productsObj.data.filter((item) =>
        item.nome.toLowerCase().includes(searchItem.value)
      );

      if (productsSearch != null) {
        renderSearch(productsSearch);
      }
    }
  }
}

// função para renderizar dados na tela
function renderSearch(results) {
  const resultsElement = document.getElementById("search-display");
  if (resultsElement == null) {
    return;
  }
  resultsElement.innerHTML = "";

  for (const result of results) {
    const html = String.raw;
    const template = html` <div class="col-6">
      <div class="card">
        <img
          src="${result.urlFoto}"
          alt="${result.nome}"
          style="height: 130px"
          class="mt-2"
          onerror="this.src='img/not-found.png'"
        />
        <div class="card-body">
          <h5 class="card-title">${result.nome}</h5>
          <p class="card-text">${result.preco}</p>
          <p class="card-text">${result.descricao}</p>
        </div>
      </div>
    </div>`;
    // acumula os templates e mostra na tela
    resultsElement.innerHTML += template;
  }
}
