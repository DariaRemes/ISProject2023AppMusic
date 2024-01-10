import React, { useState } from 'react';
import { getAdmin, getUser, getArtist } from '../services/LogInService'; // Import the login service functions
import { useNavigate } from 'react-router-dom';

const LoginComponent = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();


  const handleLogin = async (e) => {
    e.preventDefault();
    const userTypes = ['User', 'Artist', 'Admin'];
      for (const userType of userTypes) {
       try {
      
        const loginServiceFunction = getLoginServiceFunction(userType);
        const credentials = {
          "username" : username,
          "password" : password
        }
        const response = await loginServiceFunction(credentials);
        if (response.status == 200) {
          console.log(`${userType} logged in successfully`);
          const id = response.data.id;
          redirectToDashboard(userType,id);
          return;
        }

        
    } catch (error) {
      if (error.response && error.response.status === 404) {
        console.log('User not found');
        setError('Invalid username or password. Please try again.');
      }else{
      console.error('Error during login:', error);
      setError('An error occurred during login. Please try again.');
      }
    }
   } };

  const getLoginServiceFunction = (userType) => {
    switch (userType) {
      case 'User':
        return getUser;
      case 'Artist':
        return getArtist;
      case 'Admin':
        return getAdmin;
      default:
        console.error('Invalid user type');
        return null;
    }
  };

  const redirectToDashboard = (userType,id) => {
    switch (userType) {
      case 'User':
        navigate(`/user-homepage/${id}`);
        break;
      case 'Artist':
        navigate(`/artist-homepage/${id}`);
        break;
      case 'Admin':
        navigate('/admin');
        break;
      default:
        break;
    }
  };
return (
    <div className="container">
      <br /> <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md3">
          <h2 className="text-center">Login</h2>
          <div className="card-body">
            <form>
              <div className="form_group mb-2">
                <label className="form-label">
                  Username
                  <input
                    type="text"
                    placeholder="Enter username"
                    name="username"
                    value={username}
                    className="form-control"
                    onChange={(e) => setUsername(e.target.value)}
                  />
                </label>
              </div>

              <div className="form_group mb-2">
                <label className="form-label">
                  Password
                  <input
                    type="password"
                    placeholder="Enter password"
                    name="password"
                    value={password}
                    className="form-control"
                    onChange={(e) => setPassword(e.target.value)}
                  />
                </label>
              </div>

              {error && <div className="text-danger">{error}</div>}

              <button className="btn btn-primary btn-success" onClick={handleLogin}>
                Login
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
    );
};

export default LoginComponent;