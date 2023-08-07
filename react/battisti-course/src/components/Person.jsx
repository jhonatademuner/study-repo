import PropTypes from 'prop-types';

function Person({ photo, name, age, job }) {
  return (
    <>
      <img src={photo} alt={name} />
      <p>Age: {age}</p>
      <p>Job: {job}</p>
    </>
  );
}

Person.propTypes = {
  photo: PropTypes.string.isRequired,
  name: PropTypes.string.isRequired,
  age: PropTypes.number.isRequired,
  job: PropTypes.string.isRequired,
};

export default Person;
