import React, { useState, useEffect } from 'react'
import Sidebar from './Sidebar'
import axios from 'axios';

const SearchPageComponent = () => {
  const [searchQuery, setSearchQuery] = useState('');
  const [resultsTitle, setResultsTitle] = useState([]);
  const [resultsGenre, setResultsGenre] = useState([]);

  const handleSearch = async () => {
    try {
      // Make requests to multiple APIs based on the search query
      const responseA = await axios.get(`https://localhost:8080/songs/filterByTitle?title=${searchQuery}`);
      const responseB = await axios.get(`https://localhost:8080/songs/filterByGenre?genre=${searchQuery}`);

      // Update state with the results
      setResultsTitle(responseTitle.data);
      setResultsGenre(responseGenre.data);
    } catch (error) {
      console.error('Error during search:', error);
    }
  };

   // Use useEffect to trigger the search when the searchQuery changes
    useEffect(() => {
      handleSearch();
    }, [searchQuery]);

  return (
    <div className='d-flex'>
      {/* //<div className='row'>  */}
        <div className='col-md-2'>
           <Sidebar/>  
        </div>
        <div className='col'>
         {/* <input className='form-control justify-content-center'
           type='text' 
           placeholder='Search here'
           aria-label='Search'>
         </input> */}
          <input
            type="text"
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)}
            placeholder="Enter your search query"
         />
        </div>
        {/* Display results from API A */}
        <div>
        <h2>Results from API Title</h2>
        <ul>
          {resultsTitle.map((result, index) => (
            <li key={index}>{result.title}</li>
          ))}
        </ul>
      </div>

      {/* Display results from API B */}
      <div>
        <h2>Results from API Genre</h2>
        <ul>
          {resultsGenre.map((result, index) => (
            <li key={index}>{result.title}</li>
          ))}
        </ul>
      </div>
     {/* </div> */}
    </div>

    
  )
}

export default SearchPageComponent
