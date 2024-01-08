import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/playlists';

const REST_API_BASE_URL_USER = 'http://localhost:8080/user/playlists';

const userId = 102;

export const listPlaylists = () => axios.get(REST_API_BASE_URL);

export const listUserPlaylists = () => axios.get(REST_API_BASE_URL_USER + '/' + 102);

export const createPlaylist = (userId,playlist) => axios.post(REST_API_BASE_URL_USER + '/' + userId, playlist);

// export const createPlaylist = (playlist) => axios.post(REST_API_BASE_URL,playlist);

export const getPlaylist = (playlistId) => axios.get(REST_API_BASE_URL + '/' + playlistId);

export const updatePlaylist = (playlistId, playlist) => axios.put(REST_API_BASE_URL + '/' + playlistId, playlist);

export const addSongToPlaylist = (playlistId, songId) => axios.put(REST_API_BASE_URL + '/' + playlistId + '/' + songId);

export const removeSongFromPlaylist = (playlistId, songId) => axios.put(REST_API_BASE_URL + '/delete/' + playlistId + '/' + songId);

export const deletePlaylist = (playlistId) => axios.delete(REST_API_BASE_URL + '/' + playlistId);