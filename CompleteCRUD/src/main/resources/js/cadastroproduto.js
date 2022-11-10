async function deleteProduct() {
  return fetch("/produto/delete/:id").then((resp) => resp.json());
}

async function insert(product) {
  return fetch("/produto/insert", {
    method: "post",
    body: JSON.stringify(product),
  }).then((resp) => resp.json());
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
