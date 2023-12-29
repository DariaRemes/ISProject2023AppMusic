import React, {useEffect, useState} from 'react'
import { listSongs } from '../services/SongService'

export const SongComponent = () => {

   const [songs, setSongs] = useState([])

   useEffect(() => {
        listSongs().then((response) => {
            setSongs(response.data);
        }).catch(error => {
            console.error(error);
        })
   }, [])

  return (
    <div className='container'>
        <h2 className='text-center'>List of Songs</h2>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Song id</th>
                    <th>Song Title</th>
                    <th>Played Number</th>
                    <th>Genre</th>
                </tr>
            </thead>
            <tbody>
                {
                    songs.map(song =>
                        <tr key={song.id}>
                            <td>{song.id}</td>
                            <td>{song.title}</td>
                            <td>{song.played_no}</td>
                            <td>{song.genre}</td>                            
                        </tr>)
                }
            </tbody>
        </table>
    </div>
  )
}
