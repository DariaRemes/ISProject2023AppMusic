import React from 'react'
import 'bootstrap-icons/font/bootstrap-icons.css'

function Sidebar() {
  return (
    <div className='sidebar d-flex flex-column justify-content-between bg-dark text-white p-4 vh-100'>
      <div>
        <a href='' className='nav-link text-white'>
            <i className='bi bi-vinyl fs-5 me-2'></i>
            <span className='fs-4'>Music app</span>
        </a> 
        <hr className='text-secondary mt-2'/>
        <ul className='nav nav-pills flex-column p-0 m-0'>
            <li className='nav-item p-1'>
                <a href='http://localhost:3000/user-homepage' className='nav-link text-white'>
                    <i className='bi bi-house fs-5 me-2'></i>
                    <span className='fs-5'>Home</span>
                </a>
            </li>
            <li className='nav-item p-1'>
                <a href='http://localhost:3000/search' className='nav-link text-white'>
                    <i className='bi bi-search-heart fs-5 me-2'></i>
                    <span className='fs-5'>Search</span>
                </a>
            </li>
            <li className='nav-item p-1'>
                <a href='http://localhost:3000/user-library' className='nav-link text-white'>
                    <i className='bi bi-collection fs-5 me-2'></i>
                    <span className='fs-5'>Your library</span>
                </a>
            </li>
        </ul>
       </div>
        <div>
           <hr className='text-secondary'/>
           <i className='bi bi-person fs-5'></i>
           <span className='fs-4'>You</span>
        </div>
    </div>
  )
}

export default Sidebar