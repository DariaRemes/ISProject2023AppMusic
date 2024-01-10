import React, {useState,useEffect}from 'react'
import Sidebar from './Sidebar'
import { useParams } from 'react-router-dom'
import { listSongs } from '../services/SongService'
import PlayBarComponent from './PlaybarComponent'

const UserHomepageComponent = () => {
  const [songs, setSongs] = useState([])


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

  
  return (
    <div className='container-fluid'>
    <div className='row'>
      <div className='col-md-2 p-0' >
        <Sidebar userId={id} />
      </div>
      <div className='col-md-10'>
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
                            <button className='btn btn-info' >Play</button>
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
            <PlayBarComponent />
          </div>
        </div>
      </div>
    </div>
  </div>
  )
}

export default UserHomepageComponent