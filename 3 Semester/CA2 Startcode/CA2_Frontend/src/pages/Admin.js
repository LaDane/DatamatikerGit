import facade from '../apiFacade'
import React, { useState,useEffect } from "react"

const Admin = () => {

  const [dataFromServer, setDataFromServer] = useState("Loading...")
  
  useEffect(() => { facade.fetchUserData( "admin" ).then(data=> setDataFromServer(data.msg));
  }, [])
 
  return (
    <div>
      <h2>Data Received from server</h2>
      <h3>{dataFromServer}</h3>
    </div>
  )
}

export default Admin