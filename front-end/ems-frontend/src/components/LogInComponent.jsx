import React, { useState } from 'react';
import { getAdmin, getUser, getArtist } from '../services/LogInService'; // Import the login service functions
import { useNavigate } from 'react-router-dom';

const LoginComponent = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleLogin = async (e, userType) => {
    e.preventDefault();

    try {
      let loginServiceFunction;

      switch (userType) {
        case 'User':
          loginServiceFunction = getUser;
          break;
        case 'Artist':
          loginServiceFunction = getArtist;
          break;
        case 'Admin':
          loginServiceFunction = getAdmin;
          break;
        default:
          console.error('Invalid user type');
          return;
      }

      const response = await loginServiceFunction(username, password);

      if (response.data.success) {
        console.log(`${userType} logged in successfully`);
        redirectToDashboard(userType);
      } else {
        setError('Invalid username or password. Please try again.');
      }
    } catch (error) {
      console.error('Error during login:', error);
      setError('An error occurred during login. Please try again.');
    }
  };

  const redirectToDashboard = (userType) => {
    switch (userType) {
      case 'User':
        navigate('/user-homepage');
        break;
      case 'Artist':
        navigate('/artist-dashboard');
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