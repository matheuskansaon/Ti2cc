async function readDataRestaurante() {
  return fetch("/restaurantes").then((resp) => resp.json());
}