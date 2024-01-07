import React, {useEffect, useState} from 'react'
import { listSongs } from '../services/SongService'
import { addSongToPlaylist } from '../services/PlaylistService'
import { useNavigate, useParams} from 'react-router-dom'

const AddSongToPlaylistComponent = () => {

   const [songs, setSongs] = useState([])

   const navigator = useNavigate();

   const {id} = useParams();

   useEffect(() => {
        getAllSongs();
   }, [])
   
    function getAllSongs(){
        listSongs().then((response) => {
            setSongs(response.data);
        }).catch(error => {
            console.error(error);
        })
    }
    
    function addSong(id,songId){
        //navigator('/add-song')
        addSongToPlaylist(id,songId).then((response) => {
        }).catch(error => {
            console.error(error);
        })
    }

    function updateSong(id){
        navigator(`/edit-song/${id}`)
    }

    function removeSong(id){
        deleteSong(id).then((response) =>{
            getAllSongs();
        }).catch(error => {
            console.error(error);
          })
    }

  return (
    <div className='container'>
        <h2 className='text-center'>Songs</h2>
        {/* <button className='btn btn-primary mb-2' onClick={addNewSong}>Add Song</button> */}
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    {/* <th>Id</th> */}
                    <th>Title</th>
                    <th>Played Number</th>
                    <th>Genre</th>
                    <th>Artist</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    songs.map(song =>
                        <tr key={song.id}>
                            {/* <td>{song.id}</td> */}
                            <td>{song.title}</td>
                            <td>{song.played_no}</td>
                            <td>{song.genre}</td> 
                            <td>{song.artist}</td> 
                            <td>
                                <button className='btn btn-info' onClick={()=>addSong(id,song.id)}>Add</button>
                                {/* <button className='btn btn-danger' onClick={()=>removeSong(song.id)}>Delete</button> */}
                            </td>                          
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}


export default AddSongToPlaylistComponent