import PropTypes from 'prop-types';

function YourName({setName}){

  return (
    <div>
      <p>Type yout name:</p>
      <input type="text" onChange={(e) => {
        setName(e.target.value);
      }}/>
    </div>
  )
}

YourName.propTypes = {
  setName: PropTypes.func.isRequired,
}

export default YourName;