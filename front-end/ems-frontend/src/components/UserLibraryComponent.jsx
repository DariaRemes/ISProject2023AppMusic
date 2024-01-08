import React ,{useEffect, useState} from 'react'
import Sidebar from './Sidebar'
import { deletePlaylist, getPlaylist, listUserPlaylists } from '../services/PlaylistService'
import { useNavigate } from 'react-router-dom'

const UserLibraryComponent = () => {
  const [playlists, setPlaylists] = useState([])

  const navigator = useNavigate();

  useEffect(() => {
    getPlaylists();
  }, [])

  function getPlaylists(){
    listUserPlaylists().then((response) => {
        setPlaylists(response.data);
    }).catch(error => {
        console.error(error);
    })
  } 

  function addNewPlaylist(){
    navigator(`/create-playlist`)
  }
  function getPlaylist(id){
    navigator(`/playlist-songs/${id}`)
  }
  function updatePlaylist(id){
    navigator(`/edit-playlist/${id}`)
  }

  function removePlaylist(id){
    deletePlaylist(id).then((response) =>{
        getPlaylists();
    }
      ).catch(error => {
        console.error(error);
      })
  } 
  return (
    <div className='d-flex'>
      <div className='col-md-2'>
           <Sidebar/>
      </div>
      <div className='column'>
        <button className='btn btn-primary mb-2' onClick={addNewPlaylist}>Create playlist</button>
        <table className='table table-striped table-bordered'>
            {/* <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead> */}
            <tbody>
                {
                    playlists.map(playlist =>
                        <tr key={playlist.id}>
                            {/* <td>{playlist.id}</td> */}
                            <td>{playlist.name}</td>
                           <td>
                              <button className='btn btn-info' onClick={()=>getPlaylist(playlist.id)}>Open playlist</button>
                              <button className='btn btn-info' onClick={()=>updatePlaylist(playlist.id)}>Update</button>
                              <button className='btn btn-danger' onClick={()=>removePlaylist(playlist.id)}>Delete</button>
                            </td>                           
                        </tr>)
                }
            </tbody>
        </table>
        </div>
    </div>
    
  )
}

export default UserLibraryComponent