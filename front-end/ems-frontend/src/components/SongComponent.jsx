import React, {useEffect, useState} from 'react'
import { createSong, getSong, updateSong } from '../services/SongService'
import { useNavigate, useParams } from 'react-router-dom'
const SongComponent = () => {

    const [title, setTitle] = useState('')
    const [genre, setGenre] = useState('')
    const [artist, setArtist] = useState('')

    const {id} = useParams();
    const [errors, setErrors] = useState({
        title: '',
        genre: '',
        artist: ''
    })

    const navigator = useNavigate();

    useEffect(() => {
      if(id){
        getSong(id).then((response) =>{
           setTitle(response.data.title);
           setGenre(response.data.genre);
           setArtist(response.data.artist);
        }).catch(error =>{
            console.error(error);
        })
      }
    }, [id])

    function saveOrUpdateSong(e){
        e.preventDefault();
   
        if(validateForm()){
            const song = {title, genre, artist}
            console.log(song)
            if(id){
                updateSong(id,song).then((response) => {
                    console.log(response.data);
                }).catch(error =>{
                    console.error(error);
                })
            }else{
                createSong(song).then((response) =>{
                    console.log(response.data);
                    navigator('/songs')
                  }).catch(error => {
                    console.error(error);
                  })
            } 
        }
    }

    function validateForm(){
        let valid = true;

        const errorsCopy= {... errors}    

        if(title.trim()){
            errorsCopy.title = '';
        }else {
            errorsCopy.title = 'Title is required!';
            valid = false;
        }

        if(genre.trim()){
            errorsCopy.genre = '';
        }else {
            errorsCopy.genre = 'Genre is required!';
            valid = false;
        }

        if(artist.trim()){
            errorsCopy.artist = '';
        }else {
            errorsCopy.artist = 'Artist is required!';
            valid = false;
        }

        setErrors(errorsCopy);

        return valid;
    }

    function pageTitle(){
        if(id){
            return <h2 className='text-center'>Update song</h2>
        }else{
            return <h2 className='text-center'>Add song</h2>
        }
    }

  return (
    <div className='container'>
        <br/>  <br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md3'>
                {
                    pageTitle()
                }
                <div className='card-body'>
                   <form>
                      <div className='form_group mb-2'>
                          <label className='form-label'>Title
                          <input 
                             type='text'
                             placeholder='Enter song title'
                             name='title'
                             value={title}
                             className={`form-control ${errors.title ? 'is-invalid': ''}`}
                             onChange={(e) => setTitle(e.target.value)}
                          >
                          </input>
                          {errors.title && <div className='invalid-feedback'>{errors.title}</div>}
                          </label>
                      </div>

                      <div className='form_group mb-2'>
                          <label className='form-label'>Genre
                          <input 
                             type='text'
                             placeholder='Enter genre'
                             name='genre'
                             value={genre}
                             className={`form-control ${errors.genre ? 'is-invalid': ''}`}
                             onChange={(e) => setGenre(e.target.value)}
                          >
                          </input>
                          {errors.genre && <div className='invalid-feedback'>{errors.genre}</div>}
                          </label>
                      </div>

                      <div className='form_group mb-2'>
                          <label className='form-label'>Artist
                          <input 
                             type='text'
                             placeholder='Enter artist name'
                             name='artist'
                             value={artist}
                             className={`form-control ${errors.artist ? 'is-invalid': ''}`}
                             onChange={(e) => setArtist(e.target.value)}
                          >
                          </input>
                          {errors.artist && <div className='invalid-feedback'>{errors.artist}</div>}
                          </label>
                      </div>
                      <button className='btn btn-primary btn-succes' onClick={saveOrUpdateSong}>Submit</button>
                   </form>
                </div>

            </div>

        </div>

    </div>
  )
}


export default SongComponent
