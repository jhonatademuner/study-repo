const Login = require('../models/loginModel');

exports.index = (req, res) => {
    if(req.session.user) return res.render('login-logged');
    return res.render('login');
}

exports.register = async (req, res) => {
    try{
        const login = new Login(req.body);
        await login.register();
    
        if(login.errors.length > 0){
            req.flash('errors', login.errors);
            req.session.save(function() {
                return res.redirect('/login/index');
            });
            return;
        }

        req.flash('success', 'User registered successfully!');
        req.session.save(function() {
            return res.redirect('/login/index');
        });

    } catch (err){
        res.render('404');
        return console.log('Sorry! Something got wrong:' + err);
    }
}

exports.login = async (req, res) => {
    try{
        const login = new Login(req.body);
        await login.login();
    
        if(login.errors.length > 0){
            req.flash('errors', login.errors);
            req.session.save(function() {
                return res.redirect('/login/index');
            });
            return;
        }

        req.flash('success', 'You are logged in!');
        req.session.user = login.user;
        req.session.save(function() {
            return res.redirect('/');
        });

    } catch (err){
        res.render('404');
        return console.log('Sorry! Something got wrong: ' + err);
    }
}

exports.logout = (req, res) => {
    req.session.destroy();
    res.redirect('/');
};