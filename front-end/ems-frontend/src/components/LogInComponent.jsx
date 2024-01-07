import React, {useState} from 'react';
import {useNavigate} from 'react-router-dom';

const LoginComponent = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();

    const handleLogin = (e) => {
        e.preventDefault();
    
    //Simulate authentification 
    const validUser = checkUserInDatabase(username, password);

    if(validUser){
        console.log('${validUser.type} logged in successfully');
        redirectToDashboard(validUser.type);
    }else{
        setError('Invalid username or password. Please try again.');
    }
};

const checkUserInDatabase = (username, password) => {
    const users = [
        {username: 'user1', password : 'password1', type: 'User'},
        {username: 'artist1', password: 'password1', type: 'Artist'},
        {username: 'admin1', password: 'password1', type: 'Admin'}
    ];

    return users.find((validUser) => validUser.username === username && validUser.password === password);
};

const redirectToDashboard = (userType) => {
    switch (userType) {
        case 'User':
            navigate('/user-dashboard');
            break;
        case 'Artist':
            navigate('/artist-dashboard');
            break;
        case 'Admin':
            navigate('/admin-dashboard');
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