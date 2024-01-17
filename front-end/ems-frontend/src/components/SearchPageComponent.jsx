import React, { useState, useEffect } from 'react'
import Sidebar from './Sidebar'
import axios from 'axios';
import { useParams } from 'react-router-dom';
import { getSongsByTitle, getSongsByArtist,getSongsByGenre } from '../services/SongService';

const SearchPageComponent = () => {
  const [searchQuery, setSearchQuery] = useState('');
  const [resultsTitle, setResultsTitle] = useState([]);
  const [resultsGenre, setResultsGenre] = useState([]);
  const [resultsArtist, setResultsArtist] = useState([]);

  const [searchResults, setSearchResults] = useState([]);

  const {userType} = useParams('');
  const {id} = useParams('');

  function getSongTitle(searchData){
    getSongsByTitle(searchData).then((response) => {
        setResultsTitle(response.data);
    }).catch(error => {
        console.error(error);
    })
  }

  function getSongArtist(searchData){
    getSongsByArtist(searchData).then((response) => {
        setResultsArtist(response.data);
    }).catch(error => {
        console.error(error);
    })
  }

  function getSongGenre(searchData){
    getSongsByGenre(searchData).then((response) => {
        setResultsGenre(response.data);
    }).catch(error => {
        console.error(error);
    })
  }
  //console.log(searchQuery)
  const handleSearch = async () => {
    try {
      // Make requests to multiple APIs based on the search query
      // const searchTitle= await axios.get(`https://localhost:8080/songs/filterByTitle?title=${searchQuery}`);
      // const searchGenre = await axios.get(`https://localhost:8080/songs/filterByGenre?genre=${searchQuery}`);
      // const searchArtist = await axios.get(`https://localhost:8080/songs/filterByGenre?artist=${searchQuery}`);

      // console.log(searchTitle.data)
      // // Update state with the results
      // setResultsTitle(searchTitle.data);
      // setResultsGenre(searchGenre.data);
      // setResultsArtist(searchArtist.data);

      const searchData = {"keyword" : searchQuery}
      // const [resultsTitle, resultsArtist, resultsGenre] = await Promise.all([
      //   getSongsByTitle(searchData),
      //   getSongsByArtist(searchData),
      //   getSongsByGenre(searchData),
      // ]);
      getSongTitle(searchData);
      getSongGenre(searchData);
      getSongArtist(searchData);

      console.log(resultsTitle)
      // console.log(resultsGenre)
      console.log(resultsArtist)
      // const combinedResults = [
      //   ...resultsTitle,
      //   ...resultsGenre,
      //   ...resultsArtist,

      // ];
      const combinedResults = [];
      if(resultsTitle.length>0){
        //combinedResults.concat(resultsTitle)
        setSearchResults(resultsTitle);
      }
      if(resultsGenre.length>0){
        //combinedResults.concat(resultsGenre)
        setSearchResults(resultsGenre);
      }
      if(resultsArtist.length>0){
        //combinedResults.concat(resultsArtist)
        setSearchResults(resultsArtist);
      }
      //setSearchResults(combinedResults);
      setResultsTitle([]);
    } catch (error) {
      console.error('Error during search:', error);
    }
  };

   // Use useEffect to trigger the search when the searchQuery changes
    useEffect(() => {
      //handleSearch();
    }, []);
   // console.log(searchQuery)

  return (
    <div className='d-flex'>
      
        <div className='col-md-2'>
           <Sidebar userId={id} userType={userType}/>  
        </div>
        <div className='row'>  
        <div>
        <label>Search: </label>
        <input 
               type="text"
               placeholder='Search here'
               value={searchQuery} 
               onChange={(e) => setSearchQuery(e.target.value)} 
        />
         <button onClick={handleSearch}>Search</button>
    </div>
    {/* Display search results */}
    {searchResults.length > 0 && (
        <div>
          <h2>Search Results:</h2>
          <table className='table table-bordered'>
          <tbody>
              
             {searchResults.map((result) => 
               <tr key={result.id}>
                   <td>{result.title}</td>
                   <td>{result.artist}</td>
                   <td>{result.genre}</td>
                </tr>
              )}
              </tbody>
          </table>
        </div>
      )}
      </div>
    </div>

    
  )
}

export default SearchPageComponent
