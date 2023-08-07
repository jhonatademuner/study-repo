import PropTypes from 'prop-types';

function Item({ brand, releaseYear }) {
  return (
    <>
    <li>{brand} - {releaseYear}</li>
    </>
  );
}

Item.propTypes = {
  brand: PropTypes.string.isRequired,
  releaseYear: PropTypes.number.isRequired,
};


Item.defaultProps = {
  brand: "Brand not informed",
  releaseYear: 0,
}

export default Item;