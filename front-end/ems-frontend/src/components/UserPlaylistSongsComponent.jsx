import React ,{useEffect, useState} from 'react'
import {getPlaylist} from '../services/PlaylistService'
import Sidebar from './Sidebar'

import { useNavigate, useParams } from 'react-router-dom'

const UserPlaylistSongsComponent = () => {
  const [name, setName] = useState('')
  const [songs, setSongs] = useState([])

  const {id} = useParams();

  const navigator = useNavigate();

  useEffect(() => {
    if(id){
      getPlaylist(id).then((response) => {
        setName(response.data.name);
        setSongs(response.data.songs);
    }).catch(error => {
        console.error(error);
    })
    //addSong(id);

  }}, [id])

  function addSong(){
    navigator(`/add-song/${id}`)
  }
  // function getPlaylist(id){
  //   navigator(`/playlist-songs/${id}`)
  // }
  // function updatePlaylist(id){
  //   navigator(`/edit-playlist/${id}`)
  // }

  // function removeSong(id){
  //   deletePlaylist(id).then((response) =>{
  //       getPlaylists();
  //   }
  //     ).catch(error => {
  //       console.error(error);
  //     })
  // } 
  return (
    <div className='d-flex'>
      <div className='col-md-2'>
           <Sidebar/>
      </div>
      <div className='column'>
        <h2>{name}</h2>
        <button className='btn btn-primary mb-2' onClick={addSong}>Add song</button>
        <table className='table table-striped table-bordered'>
            <tbody>
                {
                    songs.map(song =>
                        <tr key={song.id}>
                            <td>{song.title}</td>
                           <td>
                              <button className='btn btn-info' >Play</button>
                              <button className='btn btn-danger' >Delete</button>
                            </td>                           
                        </tr>)
                }
            </tbody> 
             
        </table>
        </div>
    </div>
  )
}

export default UserPlaylistSongsComponent