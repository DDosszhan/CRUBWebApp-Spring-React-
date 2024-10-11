import React from 'react';

const HeaderComponent = () => {
  return (
    <div>
      <header>
        <nav className='navbar navbar-dark bg-dark'>
          <span className='navbar-brand'>
            <a href='https://github.com/DDosszhan' target="_blank" rel="noopener noreferrer">
              <i className="bi bi-book" style={{ fontSize: '1.5rem', marginRight: '10px', color: 'white' }}></i>
            </a>
            Employee Management System
          </span>
        </nav>
      </header>
    </div>
  );
};

export default HeaderComponent;
