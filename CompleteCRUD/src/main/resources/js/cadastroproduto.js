async function deleteProduct() {
  return fetch("/produto/delete/:id").then((resp) => resp.json());
}

const deleteProduto = document.getElementById("delete-produto");
if (searchForm) {
  searchForm.addEventListener("submit", () => {
    const formData = new FormData(searchForm);
    const search = formData.get("search");
    if (search) {
      window.location.href = `/?search=${search}`;
    }
  });
}
