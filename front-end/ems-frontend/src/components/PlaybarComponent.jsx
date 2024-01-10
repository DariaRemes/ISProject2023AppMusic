import React, { useState } from 'react';

const PlayBarComponent = () => {
  const [isPlaying, setIsPlaying] = useState(false);
  const [currentSong, setCurrentSong] = useState({
    title: 'Song Title',
    artist: 'Artist Name',
  });

  const handlePlayPause = () => {
    setIsPlaying(!isPlaying);
  };

  return (
    <div className='playbar bg-dark'>
     <div className='container-fluid'>
     <div className='row'>
     <div className='col-md-2'>
      <div className='song-info text-left'>
        <p className='title'>{currentSong.title}</p>
        <p className='artist'>{currentSong.artist}</p>
      </div>
      </div>
      <div className='col-md-4  d-flex justify-content-end'>
        <div className='control'  style={{ marginTop: '20px' }}>
        <button className='btn btn-lg  bg-white' 
                onClick={handlePlayPause}
                style={{ border: 'none' }}>
          {isPlaying ? (
              <i className='bi bi-pause-circle'></i> // Icon for pause
            ) : (
              <i className='bi bi-play-circle'></i> // Icon for play
            )}
        </button>
        </div>
      </div>
      </div>
    </div>
    </div>
  );
};

export default PlayBarComponent;
