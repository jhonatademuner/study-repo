import Item from "./Item";

function List() {
  return (
    <>
      <h1>My list</h1>
      <ul>
        <Item brand="Ford" releaseYear={2019} />
        <Item brand="Fiat" releaseYear={2018} />
        <Item brand="Honda" releaseYear={2021} />
        <Item brand="Hyundai" releaseYear={2019} />
        <Item />
      </ul>
    </>
  );
}


export default List;
