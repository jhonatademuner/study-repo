exports.homeGet = (req, res) => {
    res.render('index', {
        title: 'Home',
        numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    });
    return;
};

exports.homePost = (req, res, next) => {
    res.send(req.body);
    return;
};