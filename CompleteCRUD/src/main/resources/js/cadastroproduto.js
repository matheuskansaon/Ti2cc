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
