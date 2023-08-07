import PropTypes from "prop-types";

function AnotherList({ items }) {
  return (
    <>
      <h3>Items List</h3>
      {items.length > 0 ? (
        items.map((item, index) => <p key={index}>{item}</p>)
      ) : (
        <p>There are no items to show</p>
      )}
    </>
  );
}

AnotherList.propTypes = {
  items: PropTypes.arrayOf(PropTypes.string),
};

export default AnotherList;
