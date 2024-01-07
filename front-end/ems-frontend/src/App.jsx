import './App.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import ListSongComponent  from './components/ListSongComponent'
import YourLibraryComponent from './components/YourLibraryComponent'
import HomeComponent from './components/HomeComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import SongComponent from './components/SongComponent'
import ListAllUsersComponent from './components/ListAllUsersComponent'
import UserComponent from './components/UserComponent'
import ArtistComponent from './components/ArtistComponent'
import AdminComponent from './components/AdminComponent'
import UserHomepageComponent from './components/UserHomepageComponent';
import SearchPageComponent from './components/SearchPageComponent';
import UserLibraryComponent from './components/UserLibraryComponent';
import UserPlaylistSongsComponent from './components/UserPlaylistSongsComponent'
import AddSongToPlaylistComponent from './components/AddSongToPlaylistComponent';

function App() {
  

  return (
    <>
      <BrowserRouter>
       <Routes>
        {/* http://localhost:3000/songs */}
        <Route path='/songs' element = { <ListSongComponent />}></Route>
        {/* http://localhost:3000/add-song */}
        <Route path='/add-song' element = {<SongComponent/>}></Route>
        {/* http://localhost:3000/edit-song/1 */}
        <Route path='/edit-song/:id' element = {<SongComponent/>}></Route>
        {/* http://localhost:3000/admin */}
        <Route path='/admin' element = {<AdminComponent/>}></Route>
        {/* http://localhost:3000/user */}
        <Route path='/user' element = {<ListAllUsersComponent/>}></Route>
        {/* http://localhost:3000/add-user */}
        <Route path='/add-user' element = {<UserComponent/>}></Route>
        {/* http://localhost:3000/edit-user/1 */}
        <Route path='/edit-user/:id' element = {<UserComponent/>}></Route>
        {/* http://localhost:3000/add-artist */}
        <Route path='/add-artist' element = {<ArtistComponent/>}></Route>
        {/* http://localhost:3000/edit-artist/1 */}
        <Route path='/edit-artist/:id' element = {<ArtistComponent/>}></Route>
        {/* http://localhost:3000/user-homepage */}
        <Route path='/user-homepage' element = {<UserHomepageComponent/>}></Route>
        {/* http://localhost:3000/search */}
        <Route path='/search' element = {<SearchPageComponent/>}></Route>
        {/* http://localhost:3000/user-library */}
        <Route path='/user-library' element = {<UserLibraryComponent/>}></Route>
        
        {/* http://localhost:3000/add-song/1 */}
        <Route path='/add-song/:id' element = {<AddSongToPlaylistComponent/>}></Route>
        {/* http://localhost:3000/playlist-songs/1 */}
        <Route path='/playlist-songs/:id' element = {<UserPlaylistSongsComponent/>}></Route>

       </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
