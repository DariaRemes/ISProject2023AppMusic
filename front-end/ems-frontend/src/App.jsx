import './App.css'
import FooterComponent from './components/FooterComponent'
import HeaderComponent from './components/HeaderComponent'
import { SongComponent } from './components/SongComponent'
import YourLibraryComponent from './components/YourLibraryComponent'
import HomeComponent from './components/HomeComponent'

function App() {
  

  return (
    <>
        <HeaderComponent/>
        {/* <SongComponent/> */}
        <YourLibraryComponent/>
        <FooterComponent/>
        <HomeComponent/>
    </>
  )
}

export default App
