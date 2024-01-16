// import React, { useState, useEffect } from 'react'
// import axios from 'axios';

// const SearchPage = () => {
//   const [searchTerm, setSearchTerm] = useState('');
//   const [searchResults, setSearchResults] = useState([]);

//   const handleSearch(){
//     try {
//       // Construct API request URLs based on the input value
//       const titleUrl = `/filterByTitle?title=${searchTerm}`;
//       const genreUrl = `/filterByGenre?genre=${searchTerm}`;
//       const keywordUrl = `/filterByKeyword?keyword=${searchTerm}`;
//       const artistUrl = `/filterByArtist?artist=${searchTerm}`;

//       // Make API requests using Axios
//       const titleResponse = await axios.get(titleUrl);
//       const genreResponse = await axios.get(genreUrl);
//       const keywordResponse = await axios.get(keywordUrl);
//       const artistResponse = await axios.get(artistUrl);

//       // Combine and set the search results
//       const combinedResults = [
//         ...titleResponse.data,
//         ...genreResponse.data,
//         ...keywordResponse.data,
//         ...artistResponse.data,
//       ];
//       setSearchResults(combinedResults);

//     } catch (error) {
//       // Handle errors
//       console.error('Error:', error.message);
//     }
//   }

//   return (
//     <div>
//       <label>Search: </label>
//       <input 
//               type="text"
//               placeholder='Search here'
//               value={searchTerm} 
//               onChange={(e) => setSearchTerm(e.target.value)} />

//       <button onClick={handleSearch}>Search</button>

//       {/* Display search results */}
//       {searchResults.length > 0 && (
//         <div>
//           <h2>Search Results:</h2>
//           <table>
//           <tbody>
              
//              {searchResults.map((result) => 
//                <tr key={result.id}>
//                    <td>{result.title}</td>
//                 </tr>
//               )}
//               </tbody>
//           </table>
//         </div>
//       )}
//     </div>
//   )
// }

// export default SearchPage
