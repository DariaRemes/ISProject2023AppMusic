import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
<<<<<<< HEAD
import ListSongComponent  from './components/ListSongComponent'
import YourLibraryComponent from './components/YourLibraryComponent'
import HomeComponent from './components/HomeComponent'
import {BrowserRouter, Routes, Route} from 'react-router-dom'
import SongComponent from './components/SongComponent'
import ListAllUsersComponent from './components/ListAllUsersComponent'
import UserComponent from './components/UserComponent'
=======
import { SongComponent } from './components/SongComponent'
import YourLibraryComponent from './components/YourLibraryComponent'
import HomeComponent from './components/HomeComponent'
>>>>>>> 2ac8e62746bf218185eab3eb3a5deb73083f3a14

function App() {
  

  return (
    <>
<<<<<<< HEAD
      <BrowserRouter>
       <Routes>
        {/* http://localhost:3000/songs */}
        <Route path='/songs' element = { <ListSongComponent />}></Route>
        {/* http://localhost:3000/add-song */}
        <Route path='/add-song' element = {<SongComponent/>}></Route>
        {/* http://localhost:3000/edit-song/1 */}
        <Route path='/edit-song/:id' element = {<SongComponent/>}></Route>
        {/* http://localhost:3000/user */}
        <Route path='/user' element = {<ListAllUsersComponent/>}></Route>
        {/* http://localhost:3000/add-user */}
        <Route path='/add-user' element = {<UserComponent/>}></Route>
        {/* http://localhost:3000/edit-user/1 */}
        <Route path='/edit-user/:id' element = {<UserComponent/>}></Route>
        {/* http://localhost:3000/add-artist */}
        <Route path='/add-artist' element = {<UserComponent/>}></Route>
        {/* http://localhost:3000/edit-artist/1 */}
        <Route path='/edit-artist/:id' element = {<UserComponent/>}></Route>
       </Routes>
        
        {/*<HeaderComponent/>
        {/*<YourLibraryComponent/>
        <FooterComponent/>
         <HomeComponent/>*/}
      </BrowserRouter>
=======
        <HeaderComponent/>
        {/* <SongComponent/> */}
        <YourLibraryComponent/>
        <FooterComponent/>
        <HomeComponent/>
>>>>>>> 2ac8e62746bf218185eab3eb3a5deb73083f3a14
    </>
  )
}

export default App
