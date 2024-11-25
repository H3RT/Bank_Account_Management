-- Users Table
CREATE TABLE users (
    user_id INTEGER PRIMARY KEY,
    username TEXT UNIQUE NOT NULL,            
    password TEXT NOT NULL                    
);

--  Accounts Table
CREATE TABLE accounts (
    account_id INTEGER PRIMARY KEY , 
    user_id INTEGER NOT NULL,                     
    account_type TEXT NOT NULL,                   
    balance REAL DEFAULT 0.0,                  
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

--  Sample Data (to be removed)
INSERT INTO users (username, password) VALUES ('john_doe', '12345'); 
INSERT INTO accounts (user_id, account_type, balance) VALUES (1, 'Savings', 500.0);

