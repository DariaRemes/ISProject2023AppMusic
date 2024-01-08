import React from 'react'
import { useNavigate } from 'react-router-dom';
const AdminComponent = () => {
  
  const navigator = useNavigate();

  function chooseSongs(){
    navigator('/songs')
  }
  function chooseUsers(){
    navigator('/user')
  }
  function logOut(){
    navigator('/login')
  }

  return (
    <div className='container'>
      <h2 className='text-center'>Welcome admin</h2>
      <h5 className='text-center'>Choose what data you want to work on.</h5>
      <div className='row'>
        <div className='col-md-6'>
          <button className='btn btn-primary mb-2' onClick={chooseSongs}>Songs</button>
        </div>
        <div className='col-md-6'>
          <button className='btn btn-primary mb-2' onClick={chooseUsers}>Users</button>
        </div>
        <button className='btn btn-primary mb-2' onClick={logOut}>Log out</button>
      </div>


    </div>
  )
}

export default AdminComponent