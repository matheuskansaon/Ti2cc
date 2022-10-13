const html = String.raw;

async function readDataRestaurante() {
  return fetch("/restaurantes" + location.search).then((resp) => resp.json());
}

async function readDataProduct() {
  return fetch("/produtos" + location.search).then((resp) => resp.json());
}

// Atualiza a tela com o termo de busca
/** @type {HTMLFormElement | null} */
const searchForm = document.querySelector("#search-form");
if (searchForm) {
  searchForm.addEventListener("submit", () => {
    const formData = new FormData(searchForm);
    const search = formData.get("search");
    if (search) {
      window.location.href = `/?search=${search}`;
    }
  });
}

window.onload = async function listing() {
  /*
      List restaurant

   */
  let data = await readDataRestaurante();

  let strHTMl = "";
  for (let i = 0; i < data.length; i++) {
    // console.log(data.restaurant[i].biography);
    strHTMl += html` <div
      class="col-6 bg-white p-1 border border-light border-5"
    >
      <div class="row">
        <div class="col-12 d-flex justify-content-center align-items-center">
          <img
            style="max-width:100px;width:100%; height:100px"
            src="${data[i].urlLogo}"
            alt="${data[i].name}"
            onerror="this.src='images/not-found.png'"
          />
        </div>
        <div class="row">
          <div class="col-12 mt-2">
            <h6>${data[i].name}</h6>
            <p>${data[i].description}</p>
            <p>${data[i].address}</p>
          </div>
        </div>
      </div>
    </div>`;
  }

  const listagem = document.getElementById("listagem");
  if (listagem) {
    listagem.innerHTML = strHTMl;
  }
  // End Restaurant

  // List products

  let products = await readDataProduct();

  let strProduct = "";

  // console.log(products);
  for (let i = products.length - 1; i >= 0; i--) {
    let nome = products[i].restaurante.name;
    let logo = products[i].restaurante.urlLogo;
    strProduct += html`
      <div class="side-by-side">
        <div class="card">
          <img
            src=${products[i].image}
            class="card-img-top"
            alt="${products[i].name}"
            onerror="this.src='imagem/not-found.png'"
          />
          <div class="card-body">
            <div class="row">
              <div class="col-4 d-flex align-items-center">
                <img
                  src="${logo}"
                  alt="logo restaurante"
                  style="height: 60px;width:60px "
                />
              </div>
              <div class="col-8">
                <h5 class="card-title">${products[i].name}</h5>
                <p class="card-text">R$ ${products[i].price}</p>
                <p class="card-text">${nome}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    `;
  }
  // console.log("produtos: " + strProduct);
  const listagemProduto = document.querySelector("#listagemProduto");
  if (listagemProduto) {
    listagemProduto.innerHTML = strProduct;
  }
};
