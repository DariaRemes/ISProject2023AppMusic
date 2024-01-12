import React, {useState,useEffect}from 'react'
import Sidebar from './Sidebar'
import { useParams } from 'react-router-dom'
import { listSongs, playSong } from '../services/SongService'
import PlaybarComponent from './PlaybarComponent'

const ArtistHomepageComponent = () => {
  const [songs, setSongs] = useState([])

  const [title, setTitle] = useState('')
  const [artist, setArtist] = useState('')


  const {id} = useParams();

  useEffect(() => {
    getAllSongs();
    const sortedSongs = songs.sort((a, b) => b.played_no - a.played_no);
    setSongs(sortedSongs);
    //console.log(songs) 
  }, [])

  function getAllSongs(){
    listSongs().then((response) => {
        setSongs(response.data.slice(0,10));
    }).catch(error => {
        console.error(error);
    })
  }
  
  function play(songId,songTitle,songArtist){
    setTitle(songTitle)
    setArtist(songArtist)
    playSong(songId)
    
  }

  
  return (
    <div className='container-fluid'>
    <div className='row'>
      <div className='col-md-2 p-0' >
        <Sidebar userId={id} userType= 'Artist'/>
      </div>
      <div className='col-md-10'>
      <h2>Homepage </h2>
        <div className='row'>
          <div className='col-md-6'>
            <div className='card'>
              <div className='card-body'>
                <h4 className='text-center'>Top 10 songs</h4>
                <table className='table bordered'>
                  <tbody>
                  {
                    songs.map(song =>
                     <tr key={song.id}>
                        <td>{song.title}</td>
                        <td>{song.artist}</td> 
                        <td>{song.played_no}</td>
                        <td>{song.genre}</td> 
                        <td>
                            <button className='btn btn-info' onClick={()=>play(song.id,song.title,song.artist)}>Play</button>
                        </td>                          
                    </tr>)
                  }
                 </tbody>
                </table>
              </div>
            </div>
          </div>
          <div className='col-md-6'>
            <div className='card'>
              <div className='card-body'>
                <h4 className='text-center'>Table 2</h4>
                {/* Your second table content goes here */}
              </div>
            </div>
          </div>
        </div>
        <div className='row'>
          <div className='col-md-12 p-0'>
            <PlaybarComponent title = {title} artist = {artist}/>
          </div>
        </div>
      </div>
    </div>
  </div>
  )
}

export default ArtistHomepageComponent