import PropTypes from 'prop-types'
import Button from './events/Button'

function Events({num}) {

  function myEvent() {
    console.log(`Event ${num} triggered!`)
  }

  function secondEvent() {
    console.log(`Second event ${num} triggered!`)
  }

  return (
    <div>
      <p>Click to trigger a event:</p>
      <Button event={myEvent} text="First Event"/>
      <Button event={secondEvent} text="Second Event"/>
    </div>
  )
}

Events.propTypes = {
  num: PropTypes.number.isRequired
}

export default Events