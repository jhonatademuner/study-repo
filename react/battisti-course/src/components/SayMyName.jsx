import PropTypes from 'prop-types';

function SayMyName({ name }) {
  return (
    <>
      <p>My name is {name}</p>
    </>
  );
}

SayMyName.propTypes = {
  name: PropTypes.string.isRequired,
};

export default SayMyName;
