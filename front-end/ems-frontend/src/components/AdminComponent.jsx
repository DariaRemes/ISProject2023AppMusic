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
      </div>


    </div>
  )
}

export default AdminComponent