import PropTypes  from 'prop-types';

function Greetings({name}){

  function createGreeting(name){
    return `Hello ${name}, how are you?`;
  }

  return <>{name && <p>{createGreeting(name)}</p>}</>
}

Greetings.propTypes = {
  name: PropTypes.string.isRequired,
}

export default Greetings;