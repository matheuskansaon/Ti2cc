async function deleteProduct() {
  return fetch("/produto/delete/:id").then((resp) => resp.json());
}

async function insert(product) {
  const res = await fetch("/produto/insert", {
    method: "post",
    body: JSON.stringify(product),
  });
  
  if(res.status === 200) {
	alert("Produto salvo com sucesso");
  } else {
	alert("Ocorreu um erro ao salvar o produto");
  }
}

// const deleteProduto = document.getElementById("delete-produto");
// if (searchForm) {
//   searchForm.addEventListener("submit", () => {
//     const formData = new FormData(searchForm);
//     const search = formData.get("search");
//     if (search) {
//       window.location.href = `/?search=${search}`;
//     }
//   });
// }

/** @type {HTMLFormElement | null} */
const insertProduct = document.querySelector("#insert-product");
if (insertProduct) {
  insertProduct.addEventListener("submit", async (event) => {
    event.preventDefault();
    const formData = new FormData(insertProduct);
    const product = Object.fromEntries(formData.entries());
    await insert(product);
  });
}
