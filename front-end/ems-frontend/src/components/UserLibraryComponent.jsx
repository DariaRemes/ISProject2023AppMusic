import React ,{useEffect, useState} from 'react'
import Sidebar from './Sidebar'
import { deletePlaylist, getPlaylist, listUserPlaylists } from '../services/PlaylistService'
import { useNavigate, useParams } from 'react-router-dom'

const UserLibraryComponent = () => {
  const [playlists, setPlaylists] = useState([])

  const navigator = useNavigate();

  const {id} = useParams();

  useEffect(() => {
    getPlaylists();
  }, [])

  function getPlaylists(){
    listUserPlaylists(id).then((response) => {
        setPlaylists(response.data);
    }).catch(error => {
        console.error(error);
    })
  } 

  function addNewPlaylist(){
    navigator(`/create-playlist/${id}`)
  }
  function getPlaylist(playlistId){
    navigator(`/playlist-songs/${id}/${playlistId}`)
  }
  function updatePlaylist(playlistId){
    navigator(`/edit-playlist/${playlistId}`)
  }

  function removePlaylist(playlistId){
    deletePlaylist(id,playlistId).then((response) =>{
        getPlaylists();
    }
      ).catch(error => {
        console.error(error);
      })
  } 
  return (
    <div className='d-flex'>
      <div className='col-md-2'>
           <Sidebar userId={id} />
      </div>
      <div className='column'>
        <button className='btn btn-primary mb-2' onClick={addNewPlaylist}>Create playlist</button>
        <table className='table table-striped table-bordered'>
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