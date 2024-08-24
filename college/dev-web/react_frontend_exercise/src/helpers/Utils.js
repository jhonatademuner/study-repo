
export function login(userName, password) {
    localStorage.setItem('user', userName);
    localStorage.setItem('password', password);
}

export function logout() {
    localStorage.setItem('user', "");
    localStorage.setItem('password', "");
}

export function getUser() {
    var user = localStorage.getItem('user');
    return user;
}

export function getPassword() {
    return localStorage.getItem('password');
}