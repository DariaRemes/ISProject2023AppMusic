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

  function getSongTitle(){
    getSongsByTitle(searchQuery).then((response) => {
        setResultsTitle(response.data);
        console.log(response.data)
    }).catch(error => {
        console.error(error);
    })
  }

  function getSongArtist(){
    getSongsByArtist(searchQuery).then((response) => {
        setResultsArtist(response.data);
    }).catch(error => {
        console.error(error);
    })
  }

  function getSongGenre(){
    getSongsByGenre(searchQuery).then((response) => {
        setResultsGenre(response.data);
    }).catch(error => {
        console.error(error);
    })
  }
  console.log(searchQuery)
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
      const [resultsTitle, resultsArtist, resultsGenre] = await Promise.all([
        getSongsByTitle(searchQuery),
        getSongsByArtist(searchQuery),
        getSongsByGenre(searchQuery),
      ]);
      console.log(resultsTitle)
      console.log(resultsGenre)
      console.log(resultsArtist)
      const combinedResults = [
        ...resultsTitle,
        ...resultsGenre,
        ...resultsArtist,

      ];
      setSearchResults(combinedResults);
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
      {/* //<div className='row'>  */}
        <div className='col-md-2'>
           <Sidebar userId={id} userType={userType}/>  
        </div>
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
          <table>
          <tbody>
              
             {searchResults.map((result) => 
               <tr key={result.id}>
                   <td>{result.title}</td>
                </tr>
              )}
              </tbody>
          </table>
        </div>
      )}
    </div>

    
  )
}

export default SearchPageComponent
