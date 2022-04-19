import facade from '../apiFacade'
import React, { useState,useEffect } from "react"

const Data = () => {

  const [dataFromServer, setDataFromServer] = useState("Loading...")
  
  useEffect(() => { facade.fetchBeerJoke().then(data=> setDataFromServer(data[0]));
  }, [])
 
  return (
    <div>
      <h2>Data Received from server</h2>
      <h3>{dataFromServer.name}</h3>
      <p>Goes with: </p>
      <h3>{dataFromServer.food_pairing}</h3>
      {/* <h3>{dataFromServer.joke[0]}</h3> */}
      {/* <h3>{d.volume.value}</h3> */}

    </div>
  )
}

export default Data